package modeles;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class Athlete implements Serializable{
	
    private static final long serialVersionUID = 1L;

	public static final char HOMME = 'H';
	public static final char FEMME = 'F';
	
	private ArrayList<Epreuve> inscriptions;
	private ArrayList<Resultat> sesResultats;
	private Pays pays;
	private Equipe equipe;
	private Discipline discipline;
	private ArrayList<Session> engagements;
	private Recompense recompenses;
	private int numero;
	private String nom;
	private String prenom;
	private int taille;
	private int poids;
	private String description;
	private String dateNaissance;
	private char genre;

	/**
	 * 
	 * @param nom Le nom de l'athlete
	 * @param prenom Le prenom de l'athlete
	 * @param taille La taille de l'athlete
	 * @param poids Le poids de l'athlete
	 * @param description La description
	 * @param dateNaissance La date de naissance de l'athlete
	 * @param genre Le genre de l'athlete
	 */
	public Athlete(String nom, String prenom, int taille, int poids, String description, String dateNaissance, char genre) {
		this.nom = nom; 
		this.prenom = prenom; 
		
		if(taille > 0) {
			this.taille = taille;
		}else {
			throw new Error("Attribut de taille invalide, la taille doit être supérieure à 0cm.");
		}
		
		if(poids > 0) {
			this.poids = poids;
		}else {
			throw new Error("Attribut de poids invalide, le poids doit être supérieur à 0kg.");
		}
		
		this.description = description;
		this.dateNaissance = dateNaissance;
		
		if(genre == HOMME || genre == FEMME) {
			this.genre = genre;
		}else {
			throw new Error("Genre invalide, les deux genre possibles sont HOMME ou FEMME.");
		}
		
		this.discipline = null;
		this.pays = null;
		this.recompenses = new Recompense(this);
		this.engagements = new ArrayList<Session>();
		this.inscriptions = new ArrayList<Epreuve>();
		this.sesResultats = new ArrayList<Resultat>();
	}

	/**
	 * 
	 * @param discipline La discipline à definir
	 */
	public boolean setDiscipline(Discipline discipline) {
		this.discipline = discipline;
		return true;
	}
	
	public Discipline getDiscipline() {
		return this.discipline;
	}
	
	//Affichage console
	public void afficherAttribut() {
		System.out.println("\n"+nom + " " + prenom + " :");
		System.out.println(dateNaissance);
		if(pays != null) {
			System.out.println("Pays : " + pays.getNom());
		}else {
			System.out.println("Pays : " + "Non defini");
		}
		if(discipline != null) {
			System.out.println("Discipline : " + discipline.getNom());
		}else {
			System.out.println("Discipline : " + "Non definie");
		}
		if(equipe != null) {
			System.out.println("Equipe : " + equipe.getNom());
		}else {
			System.out.println("Equipe : " + "Non definie");
		}
		System.out.println("Poids : " + poids);
		System.out.println("Taille : " + taille);
		System.out.println("Récompenses : " + recompenses.getOr() + "O" + recompenses.getArgent() + "A" + recompenses.getBronze() + "B");
		
	}

	/**
	 * 
	 * @param epreuve
	 */
	public boolean ajouterEpreuve(Epreuve epreuve) {
		// TODO - implement Athlete.ajouterEpreuve
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param numeroEpreuve
	 */
	public boolean retirerEpreuve(int numeroEpreuve) {
		// TODO - implement Athlete.retirerEpreuve
		throw new UnsupportedOperationException();
	}

	public boolean detruire() {
		// TODO - implement Athlete.detruire
		throw new UnsupportedOperationException();
	}

	public boolean modifier() {
		// TODO - implement Athlete.modifier
		throw new UnsupportedOperationException();
	}
	
	public Pays getPays() {
		return pays;
	}
	
	public void setPays(Pays pays) {
		this.pays = pays;
	}
	
	public String toString() {
		return nom + " " + prenom + " : " + description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void ajouterOr() {
		recompenses.ajouterOr();
	}

	public void ajouterArgent() {
		recompenses.ajouterArgent();
	}

	public void ajouterBronze() {
		recompenses.ajouterBronze();
	}

	public void retirerOr() {
		recompenses.retirerOr();
	}

	public void retirerArgent() {
		recompenses.retirerArgent();
	}

	public void retirerBronze() {
		recompenses.retirerArgent();
	}

	public int getOr() {
		return recompenses.getOr();
	}

	public int getArgent() {
		return recompenses.getArgent();
	}

	public int getBronze() {
		return recompenses.getBronze();
	}
	
	public String getNom() {
		return nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public String getDescription() {
		return description;
	}

	public String getAnneeNaissance() {
		return dateNaissance;
	}

	public String getGenre() {
		if(genre == Athlete.HOMME) {
			return "Homme";
		}else {
			return "Femme";
		}
	}
	
	public int getPoids() {
		return poids;
	}
	
	public int getTaille() {
		return taille;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	public Equipe getEquipe() {
		return equipe;
	}
	
	public void removeEquipe() {
		this.equipe = null;
	}
}