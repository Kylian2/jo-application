package modeles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

/**
 * Classe Discipline programmee par kylianrichard.
 * 
 * Cette classe represente une discipline sportive avec ses epreuves, equipes et pratiquants.
 * Elle permet d'ajouter, retirer et rechercher des epreuves, ainsi que de gerer les equipes.
 * 
 * @author kylianrichard
 */
public class Discipline implements Serializable{
	
	private static final long serialVersionUID = 1L;
    
	private ArrayList<Athlete> pratiquants;
	private ArrayList<Epreuve> epreuves;
	private ArrayList<Equipe> equipes;
	private String description;
	private String nom;
	
	//permet de verifier l'unicite de la discipline
	public static ArrayList<Discipline> disciplinesList = new ArrayList<Discipline>();

	/**
	 * Constructeur de la classe Discipline.
	 * 
	 * @param nom Le nom de la discipline
	 * @param description La description de la discipline
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
			
			disciplinesList.add(this);
		}
		
	}

	/**
	 * Ajoute une epreuve a la discipline.
	 * 
	 * @param epreuve L'epreuve a ajouter
	 * @return true si l'epreuve a ete ajoutee avec succes
	 */
	public boolean ajouterEpreuve(Epreuve epreuve) {
		epreuves.add(epreuve);
		epreuve.setDiscipline(this);
		return true;
	}

	/**
	 * Retire une epreuve de la discipline.
	 * 
	 * @param epreuve L'epreuve a retirer
	 * @return true si l'epreuve a ete retiree avec succes
	 */
	public boolean retirerEpreuve(Epreuve epreuve) {
		Epreuve result = epreuves.remove(epreuves.indexOf(epreuve));
		return result != null;
	}

	/**
	 * Recherche des epreuves par leur nom.
	 * 
	 * @param nom Le nom des epreuves a rechercher
	 * @return Un tableau des epreuves trouvees
	 */
	public Epreuve[] rechercherEpreuve(String nom) {
		// TODO - implement Discipline.rechercherEpreuve
		throw new UnsupportedOperationException();
	}

	/**
	 * Ajoute une equipe a la discipline.
	 * 
	 * @param equipe L'equipe a ajouter
	 * @return true si l'equipe a ete ajoutee avec succes
	 */
	public boolean ajouterEquipe(Equipe equipe) {
		// TODO - implement Discipline.ajouterEquipe
		throw new UnsupportedOperationException();
	}

	/**
	 * Retire une equipe de la discipline par son numero.
	 * 
	 * @param numeroEquipe Le numero de l'equipe a retirer
	 * @return true si l'equipe a ete retiree avec succes
	 */
	public boolean retirerEquipe(int numeroEquipe) {
		// TODO - implement Discipline.retirerEquipe
		throw new UnsupportedOperationException();
	}

	/**
	 * Modifie les informations de la discipline.
	 * 
	 * @return true si les informations ont ete modifiees avec succes
	 */
	public boolean modifier() {
		// TODO - implement Discipline.modifier
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Retourne le nom de la discipline.
	 * 
	 * @return Le nom de la discipline
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * Affiche la liste des epreuves de la discipline.
	 */
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
	
	/**
	 * Retourne la liste des epreuves de la discipline.
	 * 
	 * @return La liste des epreuves
	 */
	public ArrayList<Epreuve> getEpreuves() {
		return epreuves;
	}
	
	/**
	 * Definit la liste des epreuves de la discipline.
	 * 
	 * @param epreuves La liste des epreuves a definir
	 */
	public void setEpreuves(ArrayList<Epreuve> epreuves) {
		this.epreuves = epreuves;
	}

}
