package controleurs;

import javax.swing.JPanel;

import modeles.ApplicationJo;
import modeles.Pays;
import vues.VueListeAthlete;
import vues.VueListePays;

public class ControleurPays implements Controleur{

	public ApplicationJo application; 
	public JPanel lastPanel;
	
	public ControleurPays(ApplicationJo application) {
		this.application = application;
	}
	
	public boolean creerPays(String code, String nom) {
		
		if(verifieLongueurEtUniciteCode(code) && nomIsUnique(nom)) {
			//Créer le pays
			System.out.println("Création...");
			application.paysList.add(new Pays(code, nom));
			return true;
		}else {
			System.out.println("Verifiez vos données");
		}
		
		return false;
	}
	
	public void setLastPanel(JPanel panel) {
		this.lastPanel = panel;
	}
	
	public void enregister() {
		application.enregister();
	}

	public void retour() {
		
		application.mainPanel.removeAll();
		application.mainPanel.add(lastPanel);
		((VueListePays) lastPanel).refresh();
		//application.mainPanel.add(application.vueListeAthlete);
		// Rafraîchir le conteneur
        application.mainPanel.revalidate();
        application.mainPanel.repaint();
		
	}
	
	public boolean verifieLongueurEtUniciteCode(String code) {
		boolean unique = true;
		
		if(code.length() != 3) {
			return false;
		}
		
		for(Pays pays: application.paysList) {
			if(pays.getCode().equalsIgnoreCase(code)) {
				return false;
			}
		}
		
		return unique;
	}
	
	public boolean nomIsUnique(String nom) {
		boolean unique = true;
		
		for(Pays pays: application.paysList) {
			if(pays.getNom().equalsIgnoreCase(nom)) {
				return false;
			}
		}
		
		return unique;
	}
}
