/**
 * Package contenant les controleurs de l'application.
 */
package controleurs;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import modeles.ApplicationJo;
import modeles.Athlete;
import modeles.Discipline;
import modeles.Epreuve;
import modeles.Equipe;
import modeles.Pays;
import modeles.Session;
import vues.VueListeAthlete;
import vues.VueListeAthleteEquipe;
import vues.VueListeEquipePays;

/**
 * Controleur pour la gestion des equipes.
 * Cette classe contient les methodes pour creer et manipuler des equipes.
 * 
 * @author kylianrichard
 */
public class ControleurEquipe implements Controleur {

    public ApplicationJo application;
    public JPanel lastPanel;
    public Pays pays;

    /**
     * Constructeur du controleur des equipes.
     * 
     * @param application L'application principale
     * @author kylianrichard
     */
    public ControleurEquipe(ApplicationJo application) {
        this.application = application;
    }

    /**
     * Retourne la liste des disciplines non encore associees a une equipe de ce pays.
     * 
     * @return La liste des disciplines disponibles
     * @author kylianrichard
     */
    public ArrayList<Discipline> getDisciplines() {
        ArrayList<Discipline> listeSansDisciplineDejaAjoute = new ArrayList<>(application.disciplinesList);
        for (Equipe equipe : pays.getEquipes()) {
            for (int i = 0; i < listeSansDisciplineDejaAjoute.size(); i++) {
                if (listeSansDisciplineDejaAjoute.get(i).getNom().equalsIgnoreCase(equipe.getDiscipline().getNom())) {
                    listeSansDisciplineDejaAjoute.remove(i);
                    continue;
                }
            }
        }
        return listeSansDisciplineDejaAjoute;
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
     * Definit le pays courant.
     * 
     * @param pays Le pays a definir
     * @author kylianrichard
     */
    public void setPays(Pays pays) {
        this.pays = pays;
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
                continue;
            }
        }
        return index;
    }

    /**
     * Ajoute une nouvelle equipe au pays courant.
     * 
     * @param nom        Le nom de l'equipe
     * @param discipline La discipline de l'equipe
     * @return true si l'equipe a ete ajoutee avec succes, false sinon
     * @author kylianrichard
     */
    public boolean ajouterEquipe(String nom, String discipline) {
        int disciplineIndex = this.getDisciplineIndex(discipline);

        if (disciplineIndex >= 0) {
            this.pays.ajouterEquipe(new Equipe(nom, application.disciplinesList.get(disciplineIndex)));
            
            // Mettre a jour les equipes dans la liste des pays de l'application
            for (Pays pays2 : this.application.paysList) {
                if (pays2.getNom().equalsIgnoreCase(pays.getNom())) {
                    pays2.setEquipes(pays.getEquipes());
                }
            }
            this.application.enregister();
            this.application.recuperer();
            return true;
        } else {
            return false;
        }
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
        ((VueListeEquipePays) lastPanel).refresh();
        application.mainPanel.revalidate();
        application.mainPanel.repaint();
    }
    
    /**
     * Retourne au panneau precedent.
     * Cette methode permet de revenir au panneau precedent dans l'interface utilisateur pour ajouter Athlete Equipe.
     * 
     * @author kilianlentz
     */
    public void retourMembre() {
        application.mainPanel.removeAll();
        application.mainPanel.add(lastPanel);
        ((VueListeAthleteEquipe) lastPanel).refresh();
        application.mainPanel.revalidate();
        application.mainPanel.repaint();
    }
    
    

    /**
     * Supprime une equipe du pays courant.
     * 
     * @param equipe L'equipe a supprimer
     * @return true si l'equipe a ete supprimee avec succes, false sinon
     * @author kylianrichard
     */
    public boolean supprimerEquipe(Equipe equipe) {
        System.out.println("Nombre d'équipes avant suppression : " + pays.getEquipes().size());

        for (int i = 0; i < pays.getEquipes().size(); i++) {
            Equipe equipeCourante = pays.getEquipes().get(i);

            if (equipeCourante.getDiscipline().getNom().equalsIgnoreCase(equipe.getDiscipline().getNom())) {
                System.out.println("Equipe trouvée : " + equipeCourante.getDiscipline().getNom());

                // Definir l'equipe des athlètes à null
                for (Athlete athlete : equipeCourante.getMembres()) {
                    athlete.setEquipe(null);
                    System.out.println("Mise à jour de l'athlète : " + athlete.getNom());
                }

                // Retirer l'equipe de la liste
                Equipe equipeSupprimee = pays.getEquipes().remove(i);
                System.out.println("Equipe supprimée : " + equipeSupprimee.getNom());
                System.out.println("Nombre d'équipes après suppression : " + pays.getEquipes().size());
                
                // Mettre a jour les equipes dans la liste des pays de l'application
                for (Pays pays2 : this.application.paysList) {
                    if (pays2.getNom().equalsIgnoreCase(pays.getNom())) {
                        pays2.setEquipes(pays.getEquipes());
                    }
                }
                this.application.enregister();
                this.application.recuperer();
                return equipeSupprimee != null;
            }
        }

        System.out.println("Equipe non trouvée");
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
     * Ajouter un membre à une équipe
     * 
     * @author kilianlentz
     */
    public boolean ajouterMembre(Equipe equipe, ArrayList<Athlete> athleteParticipants) {
    	boolean estAjoutee = false;
    	for (Athlete athlete : athleteParticipants) {
    			equipe.ajouterMembre(athlete);
    			estAjoutee = true;
    	}
		return estAjoutee;
    }
    
}
