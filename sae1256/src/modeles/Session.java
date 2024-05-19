package modeles;

import java.util.*;

public class Session {

	private Collection<Athlete> sesAthlètes;
	private Lieu lieu;
	private Epreuve epreuve;
	private String date;
	private String heure;
	private int duree;

	/**
	 * 
	 * @param date
	 * @param heure
	 * @param lieu
	 */
	Session(String date, String heure, Lieu lieu) {
		// TODO - implement Session.Session
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param athlete
	 */
	public void ajouterAthlete(Athlete athlete) {
		// TODO - implement Session.ajouterAthlete
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param athlete
	 */
	public void retirerAthlete(Athlete athlete) {
		// TODO - implement Session.retirerAthlete
		throw new UnsupportedOperationException();
	}

	public void afficher() {
		// TODO - implement Session.afficher
		throw new UnsupportedOperationException();
	}

	public String calculerHeureFin() {
		// TODO - implement Session.calculerHeureFin
		throw new UnsupportedOperationException();
	}

	public boolean detruire() {
		// TODO - implement Session.detruire
		throw new UnsupportedOperationException();
	}

}