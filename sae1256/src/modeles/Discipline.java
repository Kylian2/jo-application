package modeles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class Discipline implements Serializable{
	
	public static ArrayList<Discipline> disciplinesList = new ArrayList<Discipline>();
	private static final long serialVersionUID = 1L;
    public static final String fileName = "discipline.dat";
    
	private ArrayList<Athlete> pratiquants;
	private ArrayList<Epreuve> epreuves;
	private ArrayList<Equipe> equipes;
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
			this.epreuves = new ArrayList<Epreuve>();
			this.equipes = new ArrayList<Equipe>();
			this.pratiquants = new ArrayList<Athlete>();
		}
		
	}

	/**
	 * 
	 * @param epreuve
	 */
	public boolean ajouterEpreuve(Epreuve epreuve) {
		epreuves.add(epreuve);
		epreuve.setDiscipline(this);
		return true;
	}

	/**
	 * 
	 * @param epreuve
	 */
	public boolean retirerEpreuve(Epreuve epreuve) {
		Epreuve result = epreuves.remove(epreuves.indexOf(epreuve));
		return result != null;
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
	
	public void afficherEpreuves() {
		System.out.println("Voici les disciplines de " + this.nom + " : ");
		if(epreuves != null && epreuves.size() > 0) {
			for(Epreuve epreuve: epreuves) {
				System.out.println("- "+epreuve.getNom());
			}
		}else {
			System.out.println("aucune epreuve");
		}
	}
	
	public ArrayList<Epreuve> getEpreuves() {
		return epreuves;
	}

}