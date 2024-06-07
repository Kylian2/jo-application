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

/**
 * Classe Athlete programmee par kylianrichard.
 * 
 * Cette classe represente un athlete avec diverses informations telles que 
 * son nom, prenom, taille, poids, description, date de naissance et genre.
 * Elle permet egalement de gerer les disciplines, equipes, epreuves et recompenses 
 * associees a l'athlete.
 * 
 * @author kylianrichard
 */
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
	 * Constructeur de la classe Athlete.
	 * 
	 * @param nom Le nom de l'athlete
	 * @param prenom Le prenom de l'athlete
	 * @param taille La taille de l'athlete
	 * @param poids Le poids de l'athlete
	 * @param description La description
	 * @param dateNaissance La date de naissance de l'athlete
	 * @param genre Le genre de l'athlete
	 * @throws Error Si la taille ou le poids sont invalides, ou si le genre est invalide.
	 */
	public Athlete(String nom, String prenom, int taille, int poids, String description, String dateNaissance, char genre) {
		this.nom = nom; 
		this.prenom = prenom; 
		
		if(taille > 0) {
			this.taille = taille;
		}else {
			throw new Error("Attribut de taille invalide, la taille doit etre superieure a 0cm.");
		}
		
		if(poids > 0) {
			this.poids = poids;
		}else {
			throw new Error("Attribut de poids invalide, le poids doit etre superieur a 0kg.");
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
	 * Definit la discipline de l'athlete.
	 * 
	 * @param discipline La discipline a definir
	 * @return true si la discipline a ete definie avec succes
	 */
	public boolean setDiscipline(Discipline discipline) {
		this.discipline = discipline;
		return true;
	}
	
	/**
	 * Retourne la discipline de l'athlete.
	 * 
	 * @return La discipline de l'athlete
	 */
	public Discipline getDiscipline() {
		return this.discipline;
	}
	
	/**
	 * Affiche les attributs de l'athlete dans la console.
	 */
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
		System.out.println("Recompenses : " + recompenses.getOr() + "O" + recompenses.getArgent() + "A" + recompenses.getBronze() + "B");
		
	}

	/**
	 * Ajoute une epreuve a l'athlete.
	 * 
	 * @param epreuve L'epreuve a ajouter
	 * @return true si l'epreuve a ete ajoutee avec succes
	 */
	public boolean ajouterEpreuve(Epreuve epreuve) {
		// TODO - implement Athlete.ajouterEpreuve
		throw new UnsupportedOperationException();
	}

	/**
	 * Retire une epreuve de l'athlete.
	 * 
	 * @param numeroEpreuve Le numero de l'epreuve a retirer
	 * @return true si l'epreuve a ete retiree avec succes
	 */
	public boolean retirerEpreuve(int numeroEpreuve) {
		// TODO - implement Athlete.retirerEpreuve
		throw new UnsupportedOperationException();
	}

	/**
	 * Detruit l'athlete.
	 * 
	 * @return true si l'athlete a ete detruit avec succes
	 */
	public boolean detruire() {
		// TODO - implement Athlete.detruire
		throw new UnsupportedOperationException();
	}

	/**
	 * Modifie l'athlete.
	 * 
	 * @return true si l'athlete a ete modifie avec succes
	 */
	public boolean modifier() {
		// TODO - implement Athlete.modifier
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Retourne le pays de l'athlete.
	 * 
	 * @return Le pays de l'athlete
	 */
	public Pays getPays() {
		return pays;
	}
	
	/**
	 * Definit le pays de l'athlete.
	 * 
	 * @param pays Le pays a definir
	 */
	public void setPays(Pays pays) {
		this.pays = pays;
	}
	
	/**
	 * Retourne une representation sous forme de chaine de caracteres de l'athlete.
	 * 
	 * @return Representation sous forme de chaine de caracteres de l'athlete
	 */
	public String toString() {
		return nom + " " + prenom + " : " + description;
	}
	
	/**
	 * Definit la description de l'athlete.
	 * 
	 * @param description La description a definir
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Ajoute une recompense d'or a l'athlete.
	 */
	public void ajouterOr() {
		recompenses.ajouterOr();
	}

	/**
	 * Ajoute une recompense d'argent a l'athlete.
	 */
	public void ajouterArgent() {
		recompenses.ajouterArgent();
	}

	/**
	 * Ajoute une recompense de bronze a l'athlete.
	 */
	public void ajouterBronze() {
		recompenses.ajouterBronze();
	}

	/**
	 * Retire une recompense d'or a l'athlete.
	 */
	public void retirerOr() {
		recompenses.retirerOr();
	}

	/**
	 * Retire une recompense d'argent a l'athlete.
	 */
	public void retirerArgent() {
		recompenses.retirerArgent();
	}

	/**
	 * Retire une recompense de bronze a l'athlete.
	 */
	public void retirerBronze() {
		recompenses.retirerArgent();
	}

	/**
	 * Retourne le nombre de recompenses d'or de l'athlete.
	 * 
	 * @return Nombre de recompenses d'or
	 */
	public int getOr() {
		return recompenses.getOr();
	}

	/**
	 * Retourne le nombre de recompenses d'argent de l'athlete.
	 * 
	 * @return Nombre de recompenses d'argent
	 */
	public int getArgent() {
		return recompenses.getArgent();
	}

	/**
	 * Retourne le nombre de recompenses de bronze de l'athlete.
	 * 
	 * @return Nombre de recompenses de bronze
	 */
	public int getBronze() {
		return recompenses.getBronze();
	}
	
	/**
	 * Retourne le nom de l'athlete.
	 * 
	 * @return Nom de l'athlete
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * Retourne le prenom de l'athlete.
	 * 
	 * @return Prenom de l'athlete
	 */
	public String getPrenom() {
		return prenom;
	}
	
	/**
	 * Retourne la description de l'athlete.
	 * 
	 * @return Description de l'athlete
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Retourne l'annee de naissance de l'athlete.
	 * 
	 * @return Annee de naissance de l'athlete
	 */
	public String getAnneeNaissance() {
		return dateNaissance;
	}

	/**
	 * Retourne le genre de l'athlete sous forme de chaine de caracteres.
	 * 
	 * @return "Homme" si l'athlete est de genre masculin, "Femme" sinon
	 */
	public String getGenre() {
		if(genre == Athlete.HOMME) {
			return "Homme";
		}else {
			return "Femme";
		}
	}
	
	/**
	 * Retourne le poids de l'athlete.
	 * 
	 * @return Poids de l'athlete
	 */
	public int getPoids() {
		return poids;
	}
	
	/**
	 * Retourne la taille de l'athlete.
	 * 
	 * @return Taille de l'athlete
	 */
	public int getTaille() {
		return taille;
	}

	/**
	 * Definit l'equipe de l'athlete.
	 * 
	 * @param equipe L'equipe a definir
	 */
	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	/**
	 * Retourne l'equipe de l'athlete.
	 * 
	 * @return L'equipe de l'athlete
	 */
	public Equipe getEquipe() {
		return equipe;
	}
	
	/**
	 * Retire l'equipe de l'athlete.
	 */
	public void removeEquipe() {
		this.equipe = null;
	}
}