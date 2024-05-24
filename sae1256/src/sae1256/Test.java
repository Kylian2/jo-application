package sae1256;

import modeles.*;
import modeles.Discipline;
import modeles.Pays;

public class Test {
	public static void main(String[] args) {
		System.out.println("Hello SAE 1256 - Test");
		
		System.out.println("\n-------- TEST SERIALISATION ---------");

		Athlete.recuperer();
		Pays.recuperer();
		Discipline.recuperer();
		
        System.out.println("\n------Athlètes récupérés : ");
        for(Athlete athlete : Athlete.athletesList) {
        	athlete.afficherAttribut();
        }
        
        System.out.println("\n------Pays récupérés : ");
        for(Pays pays : Pays.paysList) {
        	System.out.println(pays.getNom());
        }
        
        System.out.println("\n------Disciplines récupérés : ");
        for(Discipline discipline : Discipline.disciplinesList) {
        	System.out.println(discipline.getNom());
        	discipline.afficherEpreuves();        	
        }
        
        System.out.println("Les sessions de " +  Discipline.disciplinesList.get(0).getEpreuves().get(0).getNom() + " :");
        Discipline.disciplinesList.get(0).getEpreuves().get(0).afficherSessions();
	}
}
