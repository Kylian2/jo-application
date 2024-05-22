package modeles;

import java.time.LocalDate;
import java.util.*;

public class Session {

	private ArrayList<Athlete> participants;
	private Lieu lieu;
	private Epreuve epreuve;
	private LocalDate date;
	private String heure;
	private int duree;

	/**
	 * 
	 * @param date
	 * @param heure
	 * @param lieu
	 */
	Session(LocalDate date, String heure, int duree, Lieu lieu) {
		this.date = date;
		this.heure = heure;
		this.lieu = lieu;
		this.duree = duree;
		
		this.epreuve = null;
		participants = new ArrayList<Athlete>();
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