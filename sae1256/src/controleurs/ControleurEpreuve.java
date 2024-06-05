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

public class ControleurEpreuve implements Controleur {
	
	ApplicationJo application;
	JPanel lastPanel;
	Discipline discipline;
	
	public ControleurEpreuve(ApplicationJo application) {
		this.application = application;
	}
	
	public boolean ajouterEpreuve(String nom, String unite) {
		
		int disciplineIndex = getDisciplineIndex(this.discipline.getNom());
		
		String description = "La description est vide"; // A ajouter dans la vue en fonction du temps
		
		Boolean individuel = true; // A ajouter dans la vue en fonction du temps
		
		if(disciplineIndex >= 0) {
			discipline.ajouterEpreuve(new Epreuve(nom, description, individuel, unite));
			System.out.println("Epreuve ajoutée");
			//Je ne comprends tout à fait pourquoi mais il semble que les deux liste ne soit pas les memes
            for (Discipline discipline2 : this.application.disciplinesList) {
            	if(discipline2.getNom().equalsIgnoreCase(discipline.getNom())) {
            		System.out.println("---------------------------OK");
            		discipline2.setEpreuves(discipline.getEpreuves());
            	}
            }
			application.enregister();
			application.recuperer();
			((ListeEpreuve)lastPanel).refresh();
			return true;
		}
		
		return false;
	};

	public void enregistrer() {
		application.enregister();
	}
	
	public void retour() {
		
		application.mainPanel.removeAll();
		application.mainPanel.add(lastPanel);
		((ListeEpreuve) lastPanel).refresh();
		//application.mainPanel.add(application.vueListeAthlete);
		// Rafraîchir le conteneur
        application.mainPanel.revalidate();
        application.mainPanel.repaint();
		
	}
	
	public void setLastPanel(JPanel panel) {
		this.lastPanel = panel;
	}
	
	public void setDiscipline(Discipline discipline) {
		this.discipline = discipline;
	};
	
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
	
	public boolean supprimerEpreuve(Epreuve epreuve) {
	    
	    for (int i = 0; i < discipline.getEpreuves().size(); i++) {
	        Epreuve epreuveCourante = discipline.getEpreuves().get(i);
	        	        
	        if (epreuveCourante.getNom().equalsIgnoreCase(epreuve.getNom())) {
	            
	            // Retirer l'épreuve de la liste
	            discipline.getEpreuves().remove(i);
	            
	            //Je ne comprends tout à fait pourquoi mais il semble que les deux liste ne soit pas les memes
	            for (Discipline discipline2 : this.application.disciplinesList) {
	            	if(discipline2.getNom().equalsIgnoreCase(discipline.getNom())) {
	            		discipline2.setEpreuves(discipline.getEpreuves());
	            	}
	            }
	            this.application.enregister();
	            this.application.recuperer();
	            return true;
	        }
	    }
	    
	    System.out.println("Equipe non trouvée");
	    return false;
	}
}
