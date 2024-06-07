package controleurs;

import javax.swing.JPanel;

import modeles.ApplicationJo;
import modeles.Discipline;
import vues.VueListeDiscipline;

public class ControleurDiscipline implements Controleur {

	JPanel lastPanel; 
	
	ApplicationJo application;
	
	public ControleurDiscipline(ApplicationJo application) {
		this.application = application;
	}
	
	@Override
	public void setLastPanel(JPanel lastPanel) {
		this.lastPanel = lastPanel;
	}

	@Override
	public void retour() {
		application.mainPanel.removeAll();
		application.mainPanel.add(lastPanel);
		((VueListeDiscipline) lastPanel).refresh();
		// Rafraîchir le conteneur
        application.mainPanel.revalidate();
        application.mainPanel.repaint();
	}

	public void enregister() {
		application.enregister();
	}

	public boolean creerDiscipline(String nom, String description) {
		application.disciplinesList.add(new Discipline(nom, description));
		this.enregister();
		return true;
	}

}
