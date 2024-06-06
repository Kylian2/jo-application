package sae1256;

import java.time.LocalDate;

import controleurs.ControleurSession;
import modeles.*;

public class Test {
	public static void main(String[] args) {
		System.out.println("Hello SAE 1256 - Test");
		
		System.out.println("\n-------- TEST SERIALISATION V2 ---------");

		ApplicationJo applicationJo = new ApplicationJo();
		
		applicationJo.recuperer();
		
		System.out.println(applicationJo.paysList.size());
		System.out.println(applicationJo.disciplinesList.size());
		System.out.println(applicationJo.athletesList.size());
		
		System.out.println("\n------Athlètes récupérés : ");
        for(Athlete athlete : applicationJo.athletesList) {
        	athlete.afficherAttribut();
        }
        
        System.out.println("\n------Pays récupérés : ");
        for(Pays pays : applicationJo.paysList) {
        	System.out.println(pays.getNom());
        	System.out.println(pays.getEquipes().size());
        	for (Equipe equipe : pays.getEquipes()) {
        		System.out.println(equipe.getNom());
        		for (Athlete membre: equipe.getMembres()) {
        			System.out.println(membre.getNom());
        		}
        	}
        }
        
        System.out.println("\n------Disciplines récupérés : ");
        for(Discipline discipline : applicationJo.disciplinesList) {
        	System.out.println(discipline.getNom());
        	discipline.afficherEpreuves();
        }
        
        ControleurSession controleurSession = new ControleurSession(applicationJo);
        
        LocalDate date1 = controleurSession.convertStringToLocalDate("19/07/2024");
        LocalDate date2 = controleurSession.convertStringToLocalDate("19/07/2024");
        LocalDate date3 = controleurSession.convertStringToLocalDate("20/07/2024");
        LocalDate date4 = controleurSession.convertStringToLocalDate("21/07/2024");
        
        applicationJo.disciplinesList.get(1).getEpreuves().get(0).ajouterSession(new Session(date1, "10:30", 60, "Piscine George Vallerey"));
        applicationJo.disciplinesList.get(1).getEpreuves().get(0).ajouterSession(new Session(date3, "10:30", 60, "Piscine George Vallerey"));
        applicationJo.disciplinesList.get(0).getEpreuves().get(0).ajouterSession(new Session(date2, "14:30", 60, "Stade de France"));
        applicationJo.disciplinesList.get(0).getEpreuves().get(0).ajouterSession(new Session(date4, "9:30", 120, "Stade de France"));
        
        System.out.println("Liste des sessions des epreuves de Natation");
        for (Epreuve epreuve : applicationJo.disciplinesList.get(1).getEpreuves()) {
        	System.out.println(epreuve.getNom());
        	for(Session session : epreuve.getSession()) {
        		System.out.println(session);
        	}
        }
        
        System.out.println("Liste des sessions des epreuves d'athlétisme ");
        for (Epreuve epreuve : applicationJo.disciplinesList.get(0).getEpreuves()) {
        	System.out.println(epreuve.getNom());
        	for(Session session : epreuve.getSession()) {
        		System.out.println(session);
        	}
        }
        
        applicationJo.enregister();
        
	}
}

