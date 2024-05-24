package modeles;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;



public class Epreuve implements Serializable{
	
    private static final long serialVersionUID = 1L;
    
	//Unite de mesure
	public final static String METRE = "m";
	public final static String MINUTES = "min";
	public final static String SECONDE = "s";
	public final static String GRAMME = "g";
	public static final String HEURE = "h";
	public static final String POINT = "point(s)";

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
	public Epreuve(String nom, String description, boolean individuelle, String unite) {
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
		this.sessions.add(session);
		session.setEpreuve(this);
		this.ordonnerSessions();
		this.getDiscipline().enregisterModifications();
		return true;
	}
	
	public boolean setDiscipline(Discipline discipline) {
		this.discipline = discipline;
		discipline.enregisterModifications();
		return true;
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
		System.out.println(nom);
		System.out.println(description);
		System.out.println("Est individuelle : " + individuelle);
		System.out.println("Discipline : " + discipline.getNom());
		return true;
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

	public Discipline getDiscipline() {
		return discipline;
	}

	public String getNom() {
		return nom;
	}
	
	public void setIndividuelle(boolean individuelle) {
		this.individuelle = individuelle;
		this.discipline.enregisterModifications();
	}
	
	public void ordonnerSessions() {
		Collections.sort(sessions);
	}
	
	public void afficherSessions() {
		for(Session session : sessions) {
			System.out.println(session);
		}
	}
}