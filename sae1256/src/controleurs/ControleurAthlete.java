package controleurs;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;

import modeles.*;
import vues.VueListeAthlete;

public class ControleurAthlete {

	public ApplicationJo application; 
	public JPanel lastPanel;
	
	public ControleurAthlete(ApplicationJo application) {
		this.application = application;
	}
	
	public boolean createAthlete(String nom, String prenom, String taille, String poids, String description, String dateNaissance, String genre, String nomPays, String nomDiscipline) {
		
		char genreFormatte;
		int indexPays = this.getPaysIndex(nomPays);
		int indexDiscipline = this.getDisciplineIndex(nomDiscipline);
		
		if(genre.equalsIgnoreCase("Homme")) {
			genreFormatte = 'H';
		}else if (genre.equalsIgnoreCase("Femme")) {
			genreFormatte = 'F';
		}else {
			System.out.println(1);
			return false;
		}
		
		if(Integer.parseInt(poids) <= 0) {
			System.out.println(2);
			return false;
		}
		
		if(Integer.parseInt(taille) <= 0) {
			System.out.println(3);
			return false;
		}
		
		if(indexPays == -1) {
			System.out.println(4);
			return false;
		}
		
		if(indexDiscipline == -1) {
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

	public ArrayList<Discipline> getDiscipline() {		
		return application.disciplinesList;
	}
	
	public ArrayList<Pays> getPays() {		
		return application.paysList;
	}
	
	public int getPaysIndex(String nom) {
		int index = -1;
		for (int i = 0; i < application.paysList.size(); i++) {
			if(application.paysList.get(i).getNom().equalsIgnoreCase(nom)) {
				index = i;
				return index;
			}
		}
		return index;
	}
	
	public int getDisciplineIndex(String nom) {
		
		int index = -1;
		for (int i = 0; i < application.disciplinesList.size(); i++) {
			if(application.disciplinesList.get(i).getNom().equalsIgnoreCase(nom)) {
				index = i;
				return index;
			}
		}
		return -1;
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
		((VueListeAthlete) lastPanel).refresh();
		//application.mainPanel.add(application.vueListeAthlete);
		// Rafraîchir le conteneur
        application.mainPanel.revalidate();
        application.mainPanel.repaint();
		
	}
	
}
