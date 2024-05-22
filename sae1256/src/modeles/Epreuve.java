package modeles;

import java.util.*;

public class Epreuve {

	private Classement classement;
	private ArrayList<Session> sessions;
	private ArrayList<Athlete> athletes;
	private Discipline discipline;
	private int numero;
	private String nom;
	private String description;
	private Boolean individuelle;
	private String unite;

	/**
	 * 
	 * @param nom
	 * @param description
	 * @param individuelle
	 * @param unite
	 * @param discipline
	 */
	Epreuve(String nom, String description, boolean individuelle, String unite, Discipline discipline) {
		this.nom = nom;
		this.description = description;
		this.individuelle = individuelle;
		this.unite = unite;
		
		this.discipline = null;
		this.sessions = new ArrayList<Session>();
		this.athletes = new ArrayList<Athlete>();
	}

	/**
	 * 
	 * @param session
	 */
	public boolean ajouterSession(Session session) {
		// TODO - implement Epreuve.ajouterSession
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param session
	 */
	public boolean retirerSession(Session session) {
		// TODO - implement Epreuve.retirerSession
		throw new UnsupportedOperationException();
	}

	public boolean afficher() {
		// TODO - implement Epreuve.afficher
		throw new UnsupportedOperationException();
	}

	public boolean afficherClassement() {
		// TODO - implement Epreuve.afficherClassement
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param numeroAthlete
	 */
	public boolean retirerAthlete(int numeroAthlete) {
		// TODO - implement Epreuve.retirerAthlete
		throw new UnsupportedOperationException();
	}

	public boolean detruire() {
		// TODO - implement Epreuve.detruire
		throw new UnsupportedOperationException();
	}

	public boolean afficherResultat() {
		// TODO - implement Epreuve.afficherResultat
		throw new UnsupportedOperationException();
	}

}