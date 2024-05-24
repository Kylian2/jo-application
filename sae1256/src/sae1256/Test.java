package sae1256;

import java.time.LocalDate;

import modeles.*;

public class Test {
	public static void main(String[] args) {
		System.out.println("Hello SAE 1256 - Test");
		
		System.out.println("\n-------- TEST SERIALISATION V2 ---------");

		ApplicationJo applicationJo = new ApplicationJo();
		
		//Athlete athlete2 = new Athlete("Froome", "Chris", 186, 69, "Cycliste", "1985-05-20", Athlete.HOMME);
		// Athlete athlete3 = new Athlete("Ledecky", "Katie", 183, 70, "Nageuse", "1997-03-17", Athlete.FEMME);
        //Athlete athlete1 = new Athlete("Bolt", "Usain", 195, 94, "Sprinteur", "1986-08-21", Athlete.HOMME);
        
        //Discipline natation = new Discipline("Natation", "Sport de compétition consistant à nager.");
        //Discipline cyclisme = new Discipline("Cyclisme", "Sport de course à vélo.");
        //Discipline athletisme = new Discipline("Athlétisme", "Ensemble des disciplines regroupant les courses, les sauts et les lancers.");
        
        //Pays usa = new Pays("USA", "États-Unis");
        //Pays uk = new Pays("UK", "Royaume-Uni");
        //Pays france = new Pays("FR", "France");
        
        //applicationJo.enregister();


		applicationJo.recuperer();
		
		System.out.println("\n------Athlètes récupérés : ");
        for(Athlete athlete : applicationJo.athletesList) {
        	athlete.afficherAttribut();
        }
        
        System.out.println("\n------Pays récupérés : ");
        for(Pays pays : applicationJo.paysList) {
        	System.out.println(pays.getNom());
        }
        
        System.out.println("\n------Disciplines récupérés : ");
        for(Discipline discipline : applicationJo.disciplinesList) {
        	System.out.println(discipline.getNom());
        	discipline.afficherEpreuves();  
        }
        
        //applicationJo.disciplinesList.get(0).getEpreuves().get(0).ajouterSession(new Session(LocalDate.of(2024, 5, 25), "10:00", 120));
        //applicationJo.disciplinesList.get(0).getEpreuves().get(0).ajouterSession(new Session(LocalDate.of(2024, 5, 26), "14:00", 90));
        //applicationJo.disciplinesList.get(0).getEpreuves().get(0).ajouterSession(new Session(LocalDate.of(2024, 5, 27), "09:00", 120));
      
        //applicationJo.disciplinesList.get(0).getEpreuves().get(0).afficherSessions();
        
        applicationJo.enregister();
        
	}
}

