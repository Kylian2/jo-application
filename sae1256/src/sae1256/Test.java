package sae1256;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import modeles.*;
import modeles.Discipline;
import modeles.Pays;

public class Test {
	public static void main(String[] args) {
		System.out.println("Hello SAE 1256 - Test");
		
		//Test de la créations des disciplines + Ajout à la liste des disciplines
		new Discipline("Natation", "Discipline comportant toutes les epreuves de natation en bassin");
		new Discipline("Athlétisme", "Discipline comportant toutes les epreuves d'athlétismes");
		new Discipline("Cyclisme", "Discipline comportant toutes les epreuves de cyclisme");
		
		for(Discipline discipline : Discipline.disciplinesList) {
			System.out.println(discipline.getNom());
		}
		
		//Verification de la créations des équipes d'un pays à la création du pays
		Pays France = new Pays("FRA", "France");
		Pays GBR = new Pays("GBR","Grande-Bretagne");
		France.afficherEquipes();
		GBR.afficherEquipes();
		
		System.out.println("\n-------- TEST SERIALISATION ---------");

		/*
		//creation d'athlete, ils sont automatiquement ajouté à leur création
		new Athlete("Froome", "Chris", 186, 69, "Cycliste britannique, multiple vainqueur du Tour de France", "1985-05-20", Athlete.HOMME);
        new Athlete("Vos", "Marianne", 168, 58, "Cycliste néerlandaise, multiple championne du monde", "1987-05-13", Athlete.FEMME);

        //On les récuperer et les affiches
        Athlete.recuperer();  
        System.out.println("\nRecuperer1 : ");
        for(Athlete athlete : Athlete.athletesList) {
        	System.out.println(athlete);
        }
        
        //On effectue un modif sur l'un d'eux, modification automatiquement enregistrées
        System.out.println("\nModif : ");
        System.out.println(Athlete.athletesList.get(0));
        Athlete.athletesList.get(0).setDescription("Une nouvelle description");
        System.out.println(Athlete.athletesList.get(0));
        
        //Si on les récupere les modifications sont belles et bien enregistrées
        Athlete.recuperer();
        System.out.println("\nRecuperer2 : ");
        for(Athlete athlete : Athlete.athletesList) {
        	System.out.println(athlete);
        }
        */
		
		//Si l'on ne fait pas tout le processus de création, on observe que l'on
		//recupere ce qui est stocké dans le fichier. ATTENTION IL FAUT QU'IL EXISTE. 
		Athlete.recuperer();
        System.out.println("\nRecuperer sans creation : ");
        for(Athlete athlete : Athlete.athletesList) {
        	System.out.println(athlete);
        }
        
        System.out.println("\n" + Athlete.athletesList.get(0));
        Athlete.athletesList.get(0).setDiscipline(Discipline.disciplinesList.get(2));
        System.out.println(GBR.ajouterAthlete(Athlete.athletesList.get(0)));
        
	}
}
