/**
 * Package contenant les controleurs de l'application.
 */
package controleurs;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;

import modeles.*;
import vues.VueListeAthlete;

/**
 * Controleur pour la gestion des athletes.
 * Cette classe contient les methodes pour creer et manipuler des athletes.
 * 
 * @author kylianrichard
 */
public class ControleurAthlete implements Controleur {

    public ApplicationJo application;
    public JPanel lastPanel;

    /**
     * Constructeur du controleur des athletes.
     * 
     * @param application L'application principale
     * @author kylianrichard
     */
    public ControleurAthlete(ApplicationJo application) {
        this.application = application;
    }

    /**
     * Cree un nouvel athlete.
     * 
     * @param nom           Le nom de l'athlete
     * @param prenom        Le prenom de l'athlete
     * @param taille        La taille de l'athlete
     * @param poids         Le poids de l'athlete
     * @param description   La description de l'athlete
     * @param dateNaissance La date de naissance de l'athlete
     * @param genre         Le genre de l'athlete
     * @param nomPays       Le nom du pays de l'athlete
     * @param nomDiscipline Le nom de la discipline de l'athlete
     * @return true si l'athlete a ete cree avec succes, false sinon
     * @author kylianrichard
     */
    public boolean createAthlete(String nom, String prenom, String taille, String poids, String description, String dateNaissance, String genre, String nomPays, String nomDiscipline) {
        char genreFormatte;
        int indexPays = this.getPaysIndex(nomPays);
        int indexDiscipline = this.getDisciplineIndex(nomDiscipline);

        if (genre.equalsIgnoreCase("Homme")) {
            genreFormatte = 'H';
        } else if (genre.equalsIgnoreCase("Femme")) {
            genreFormatte = 'F';
        } else {
            System.out.println(1);
            return false;
        }

        if (Integer.parseInt(poids) <= 0) {
            System.out.println(2);
            return false;
        }

        if (Integer.parseInt(taille) <= 0) {
            System.out.println(3);
            return false;
        }

        if (indexPays == -1) {
            System.out.println(4);
            return false;
        }

        if (indexDiscipline == -1) {
            System.out.println(5);
            return false;
        }

        Athlete newAthlete = new Athlete(nom, prenom, Integer.parseInt(taille), Integer.parseInt(poids), description, dateNaissance, genreFormatte);
        newAthlete.setDiscipline(application.disciplinesList.get(indexDiscipline));
        application.paysList.get(indexPays).ajouterAthlete(newAthlete);
        application.athletesList.add(newAthlete);
        this.application.enregister();
        this.application.recuperer();
        return true;
    }

    /**
     * Retourne la liste des disciplines.
     * 
     * @return La liste des disciplines disponibles
     * @author kylianrichard
     */
    public ArrayList<Discipline> getDiscipline() {
        return application.disciplinesList;
    }

    /**
     * Retourne la liste des pays.
     * 
     * @return La liste des pays disponibles
     * @author kylianrichard
     */
    public ArrayList<Pays> getPays() {
        return application.paysList;
    }

    /**
     * Retourne l'index d'un pays dans la liste.
     * 
     * @param nom Le nom du pays
     * @return L'index du pays ou -1 si non trouve
     * @author kylianrichard
     */
    public int getPaysIndex(String nom) {
        int index = -1;
        for (int i = 0; i < application.paysList.size(); i++) {
            if (application.paysList.get(i).getNom().equalsIgnoreCase(nom)) {
                index = i;
                return index;
            }
        }
        return index;
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
     * Definit le dernier panneau utilise.
     * 
     * @param panel Le panneau a definir comme dernier panneau
     * @author kylianrichard
     */
    public void setLastPanel(JPanel panel) {
        this.lastPanel = panel;
    }

    /**
     * Enregistre les donnees de l'application.
     * Cette methode sauvegarde l'etat actuel de l'application.
     * 
     * @author kylianrichard
     */
    public void enregister() {
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
        ((VueListeAthlete) lastPanel).refresh();
        application.mainPanel.revalidate();
        application.mainPanel.repaint();
    }

    /**
     * Recupere les donnees de l'application.
     * Cette methode charge les donnees sauvegardees de l'application.
     * 
     * @author kylianrichard
     */
    public void recuperer() {
        application.recuperer();
    }
}
