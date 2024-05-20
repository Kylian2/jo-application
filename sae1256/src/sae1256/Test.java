package sae1256;

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
		France.afficherEquipes();
		
	}
}
