package modeles;

import java.util.*;

public class Athlete {

	private static final char HOMME = 'H';
	private static final char FEMME = 'F';
	
	private Collection<Epreuve> inscriptions;
	private Collection<Resultat> sesResultats;
	private Pays pays;
	private Equipe equipe;
	private Discipline pratique;
	private Collection<Session> engagements;
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
	 * @param nom
	 * @param prenom
	 * @param taille
	 * @param poids
	 * @param description
	 * @param dateNaissance
	 * @param genre
	 */
	Athlete(String nom, String prenom, int taille, int poids, String description, String dateNaissance, char genre) {
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
	}

	/**
	 * 
	 * @param discipline
	 */
	public boolean definirDiscipline(Discipline discipline) {
		// TODO - implement Athlete.definirDiscipline
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param session
	 */
	public boolean engager(Session session) {
		// TODO - implement Athlete.engager
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param session
	 */
	public boolean desengager(Session session) {
		// TODO - implement Athlete.desengager
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param equipe
	 */
	public boolean ajouterEquipe(Equipe equipe) {
		// TODO - implement Athlete.ajouterEquipe
		throw new UnsupportedOperationException();
	}

	public boolean retirerEquipe() {
		// TODO - implement Athlete.retirerEquipe
		throw new UnsupportedOperationException();
	}

	public Athlete rechercher() {
		// TODO - implement Athlete.rechercher
		throw new UnsupportedOperationException();
	}

	public int calculerAge() {
		// TODO - implement Athlete.calculerAge
		throw new UnsupportedOperationException();
	}

	public boolean afficherEpreuves() {
		// TODO - implement Athlete.afficherEpreuves
		throw new UnsupportedOperationException();
	}

	public boolean afficher() {
		// TODO - implement Athlete.afficher
		throw new UnsupportedOperationException();
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

}