/**
 * Package contenant les controleurs de l'application.
 */
package controleurs;

import javax.swing.JPanel;

import modeles.ApplicationJo;
import modeles.Discipline;
import vues.VueListeDiscipline;

/**
 * Controleur pour la gestion des disciplines.
 * Cette classe contient les methodes pour creer et manipuler des disciplines.
 * 
 * @author kylianrichard
 */
public class ControleurDiscipline implements Controleur {

    JPanel lastPanel;
    ApplicationJo application;

    /**
     * Constructeur du controleur des disciplines.
     * 
     * @param application L'application principale
     * @author kylianrichard
     */
    public ControleurDiscipline(ApplicationJo application) {
        this.application = application;
    }

    /**
     * Definit le dernier panneau utilise.
     * 
     * @param lastPanel Le panneau a definir comme dernier panneau
     * @author kylianrichard
     */
    @Override
    public void setLastPanel(JPanel lastPanel) {
        this.lastPanel = lastPanel;
    }

    /**
     * Retourne au panneau precedent.
     * Cette methode permet de revenir au panneau precedent dans l'interface utilisateur.
     * 
     * @author kylianrichard
     */
    @Override
    public void retour() {
        application.mainPanel.removeAll();
        application.mainPanel.add(lastPanel);
        ((VueListeDiscipline) lastPanel).refresh();
        application.mainPanel.revalidate();
        application.mainPanel.repaint();
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
     * Cree une nouvelle discipline.
     * 
     * @param nom         Le nom de la discipline
     * @param description La description de la discipline
     * @return true si la discipline a ete creee avec succes, false sinon
     * @author kylianrichard
     */
    public boolean creerDiscipline(String nom, String description) {
        application.disciplinesList.add(new Discipline(nom, description));
        this.enregister();
        return true;
    }
}
