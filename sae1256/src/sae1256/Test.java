package sae1256;

import java.time.LocalDate;

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
        
        //applicationJo.paysList.add(new Pays("DEU", "Allemagne"));
               
        applicationJo.enregister();
        
	}
}

