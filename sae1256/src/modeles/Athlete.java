package modeles;

import java.util.*;

public class Athlete {

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
		// TODO - implement Athlete.Athlete
		throw new UnsupportedOperationException();
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

}