/**
 * Package contenant les controleurs de l'application.
 */
package controleurs;

import javax.swing.JPanel;

/**
 * Interface definissant les methodes de controle pour la gestion des panneaux.
 * Cette interface permet de definir les methodes necessaires pour
 * la manipulation des panneaux dans l'application.
 * 
 * @author kylianrichard
 */
public interface Controleur {
    
    /**
     * Definit le dernier panneau utilise.
     * Cette methode permet de sauvegarder une reference au dernier 
     * panneau affiche pour pouvoir y revenir plus tard si necessaire.
     * 
     * @param panel Le panneau a definir comme dernier panneau.
     */
    public void setLastPanel(JPanel panel);
    
    /**
     * Retourne au panneau precedent.
     * Cette methode permet de naviguer en arriere dans l'historique des panneaux.
     */
    public void retour();
}
