package modeles;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class Session implements Serializable, Comparable<Session> {

	private static final long serialVersionUID = 1L;
	
	private ArrayList<Athlete> participants;
	private Lieu lieu;
	private Epreuve epreuve;
	private LocalDate date;
	private String heure;
	private int duree;
	
	//Temporaire le temps de la création de lieu
	public Session(LocalDate date, String heure, int duree) {
		this.date = date;
		this.heure = heure;
		this.duree = duree;
		
		this.lieu = null;
		this.epreuve = null;
		participants = new ArrayList<Athlete>();
	}
	
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
	public boolean ajouterAthlete(Athlete athlete) {
		participants.add(athlete);
		return true;
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
		System.out.println("Epreuve : " +this.epreuve.getNom());
		System.out.println("Discipline : " +this.epreuve.getDiscipline().getNom());
		System.out.println("Date : " +this.date);
		System.out.println("Heure : " +this.heure);
		System.out.println("Duree : " + this.duree);
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
	
	@Override
	public String toString() {
		return epreuve.getNom() + " - " + date + " - " + heure;
	}

	@Override
    public int compareTo(Session o) {
        // On commence par comparer les dates
        int dateComparison = this.date.compareTo(o.date);
        //Si les dates ne sont pas égales alors on sait laquelle est la plus grande (0 = egales)
        if (dateComparison != 0) {
            return dateComparison;
        }
        // Sinon on compare aussi sur les heures
        LocalTime thisTime = LocalTime.parse(this.heure);
        LocalTime otherTime = LocalTime.parse(o.heure);
        return thisTime.compareTo(otherTime);
    }

	public void setEpreuve(Epreuve epreuve) {
		this.epreuve = epreuve;
	}

	public LocalDate getDate() {
		return date;
	}

	public String getHeure() {
		return heure;
	}

}