/**
 * Package contenant les controleurs de l'application.
 */
package controleurs;

import javax.swing.JPanel;

import modeles.ApplicationJo;
import modeles.Pays;
import vues.VueListeAthlete;
import vues.VueListePays;

/**
 * Controleur pour la gestion des pays.
 * Cette classe contient les methodes pour creer et manipuler des pays.
 * 
 * @author kylianrichard
 */
public class ControleurPays implements Controleur {

    public ApplicationJo application;
    public JPanel lastPanel;

    /**
     * Constructeur du controleur des pays.
     * 
     * @param application L'application principale
     * @author kylianrichard
     */
    public ControleurPays(ApplicationJo application) {
        this.application = application;
    }

    /**
     * Cree un nouveau pays.
     * 
     * @param code Le code du pays (doit etre unique et de longueur 3)
     * @param nom Le nom du pays (doit etre unique)
     * @return true si le pays a ete cree avec succes, false sinon
     * @author kylianrichard
     */
    public boolean creerPays(String code, String nom) {
        if (verifieLongueurEtUniciteCode(code) && nomIsUnique(nom)) {
            // Creer le pays
            System.out.println("Creation...");
            application.paysList.add(new Pays(code, nom));
            return true;
        } else {
            System.out.println("Verifiez vos donnees");
        }
        return false;
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
        ((VueListePays) lastPanel).refresh();
        application.mainPanel.revalidate();
        application.mainPanel.repaint();
    }

    /**
     * Verifie que le code est de longueur 3 et qu'il est unique.
     * 
     * @param code Le code a verifier
     * @return true si le code est valide, false sinon
     * @author kylianrichard
     */
    public boolean verifieLongueurEtUniciteCode(String code) {
        if (code.length() != 3) {
            return false;
        }
        for (Pays pays : application.paysList) {
            if (pays.getCode().equalsIgnoreCase(code)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Verifie que le nom du pays est unique.
     * 
     * @param nom Le nom a verifier
     * @return true si le nom est unique, false sinon
     * @author kylianrichard
     */
    public boolean nomIsUnique(String nom) {
        for (Pays pays : application.paysList) {
            if (pays.getNom().equalsIgnoreCase(nom)) {
                return false;
            }
        }
        return true;
    }
}
