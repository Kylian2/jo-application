package modeles;

import java.util.*;

public class Discipline {
	
	public static ArrayList<Discipline> disciplinesList = new ArrayList<Discipline>();

	private Collection<Athlete> pratiquants;
	private Collection<Epreuve> sesEpreuves;
	private Collection<Equipe> lesEquipes;
	private int numero;
	private String description;
	private String nom;

	/**
	 * 
	 * @param nom
	 * @param description
	 */
	public Discipline(String nom, String description) {
		boolean unique = true;
		
		//Verifie que la discipline est unique
		for (Discipline discipline : disciplinesList) {
			if(nom == discipline.getNom()) {
				unique = false;
				throw new Error("Deux disciplines ne peuvent pas avoir le meme nom");
			}
		}
		
		if(unique) {
			this.nom = nom;
			this.description = description;
			//Ajout de la discipline à la liste des disciplines
			disciplinesList.add(this);
		}
	}

	/**
	 * 
	 * @param epreuve
	 */
	public boolean ajouterEpreuve(Epreuve epreuve) {
		// TODO - implement Discipline.ajouterEpreuve
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param epreuve
	 */
	public boolean retirerEpreuve(Epreuve epreuve) {
		// TODO - implement Discipline.retirerEpreuve
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nom
	 */
	public Epreuve[] rechercherEpreuve(String nom) {
		// TODO - implement Discipline.rechercherEpreuve
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param equipe
	 */
	public boolean ajouterEquipe(Equipe equipe) {
		// TODO - implement Discipline.ajouterEquipe
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param numeroEquipe
	 */
	public boolean retirerEquipe(int numeroEquipe) {
		// TODO - implement Discipline.retirerEquipe
		throw new UnsupportedOperationException();
	}

	public boolean modifier() {
		// TODO - implement Discipline.modifier
		throw new UnsupportedOperationException();
	}
	
	public String getNom() {
		return nom;
	}

}