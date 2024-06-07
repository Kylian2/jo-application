/**
 * Package contenant les controleurs de l'application.
 */
package controleurs;

import javax.swing.JPanel;

import modeles.ApplicationJo;
import modeles.Athlete;
import modeles.Discipline;
import modeles.Epreuve;
import modeles.Equipe;
import modeles.Pays;
import vues.ListeEpreuve;
import vues.VueListeEquipePays;

/**
 * Controleur pour la gestion des epreuves.
 * Cette classe contient les methodes pour creer et manipuler des epreuves.
 * 
 * @author kylianrichard
 */
public class ControleurEpreuve implements Controleur {

    ApplicationJo application;
    JPanel lastPanel;
    Discipline discipline;

    /**
     * Constructeur du controleur des epreuves.
     * 
     * @param application L'application principale
     * @author kylianrichard
     */
    public ControleurEpreuve(ApplicationJo application) {
        this.application = application;
    }

    /**
     * Ajoute une nouvelle epreuve a la discipline courante.
     * 
     * @param nom   Le nom de l'epreuve
     * @param unite L'unite de mesure de l'epreuve
     * @return true si l'epreuve a ete ajoutee avec succes, false sinon
     * @author kylianrichard
     */
    public boolean ajouterEpreuve(String nom, String unite) {
        int disciplineIndex = getDisciplineIndex(this.discipline.getNom());

        String description = "La description est vide"; // A ajouter dans la vue en fonction du temps
        Boolean individuel = true; // A ajouter dans la vue en fonction du temps

        if (disciplineIndex >= 0) {
            discipline.ajouterEpreuve(new Epreuve(nom, description, individuel, unite));
            System.out.println("Epreuve ajoutee");

            // Mettre a jour les epreuves dans la liste des disciplines de l'application
            for (Discipline discipline2 : this.application.disciplinesList) {
                if (discipline2.getNom().equalsIgnoreCase(discipline.getNom())) {
                    discipline2.setEpreuves(discipline.getEpreuves());
                }
            }
            application.enregister();
            application.recuperer();
            ((ListeEpreuve) lastPanel).refresh();
            return true;
        }
        return false;
    }

    /**
     * Enregistre les donnees de l'application.
     * Cette methode sauvegarde l'etat actuel de l'application.
     * 
     * @author kylianrichard
     */
    public void enregistrer() {
        application.enregister();
    }

    /**
     * Retourne au panneau precedent.
     * Cette methode permet de revenir au panneau precedent dans l'interface utilisateur.
     * 
     * @author kylianrichard
     */
    public void retour() {
        application.mainPanel.removeAll();
        application.mainPanel.add(lastPanel);
        ((ListeEpreuve) lastPanel).refresh();
        application.mainPanel.revalidate();
        application.mainPanel.repaint();
    }

    /**
     * Definit le dernier panneau utilise.
     * 
     * @param panel Le panneau a definir comme dernier panneau
     * @author kylianrichard
     */
    public void setLastPanel(JPanel panel) {
        this.lastPanel = panel;
    }

    /**
     * Definit la discipline courante.
     * 
     * @param discipline La discipline a definir
     * @author kylianrichard
     */
    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    /**
     * Retourne l'index d'une discipline dans la liste.
     * 
     * @param nom Le nom de la discipline
     * @return L'index de la discipline ou -1 si non trouve
     * @author kylianrichard
     */
    public int getDisciplineIndex(String nom) {
        int index = -1;
        for (int i = 0; i < application.disciplinesList.size(); i++) {
            if (application.disciplinesList.get(i).getNom().equalsIgnoreCase(nom)) {
                index = i;
                return index;
            }
        }
        return -1;
    }

    /**
     * Supprime une epreuve de la discipline courante.
     * 
     * @param epreuve L'epreuve a supprimer
     * @return true si l'epreuve a ete supprimee avec succes, false sinon
     * @author kylianrichard
     */
    public boolean supprimerEpreuve(Epreuve epreuve) {
        for (int i = 0; i < discipline.getEpreuves().size(); i++) {
            Epreuve epreuveCourante = discipline.getEpreuves().get(i);

            if (epreuveCourante.getNom().equalsIgnoreCase(epreuve.getNom())) {
                // Retirer l'epreuve de la liste
                discipline.getEpreuves().remove(i);

                // Mettre a jour les epreuves dans la liste des disciplines de l'application
                for (Discipline discipline2 : this.application.disciplinesList) {
                    if (discipline2.getNom().equalsIgnoreCase(discipline.getNom())) {
                        discipline2.setEpreuves(discipline.getEpreuves());
                    }
                }
                this.application.enregister();
                this.application.recuperer();
                return true;
            }
        }
        return false;
    }
}
