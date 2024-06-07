package modeles;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Classe Epreuve programmee par kylianrichard.
 * 
 * Cette classe represente une epreuve sportive avec ses sessions, athletes et discipline.
 * Elle permet d'ajouter et retirer des sessions, d'afficher des informations et d'ordonner les sessions.
 * 
 * @author kylianrichard
 */
public class Epreuve implements Serializable, Planning{
	
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
	private String nom;
	private String description;
	private Boolean individuelle;
	private String unite;

	/**
	 * Constructeur de la classe Epreuve.
	 * 
	 * @param nom Le nom de l'epreuve
	 * @param description La description de l'epreuve
	 * @param individuelle Indique si l'epreuve est individuelle ou par equipe
	 * @param unite L'unite de mesure de l'epreuve
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
	 * Ajoute une session a l'epreuve.
	 * 
	 * @param session La session a ajouter
	 * @return true si la session a ete ajoutee avec succes
	 */
	public boolean ajouterSession(Session session) {
		this.sessions.add(session);
		session.setEpreuve(this);
		this.ordonnerSessions();
		return true;
	}
	
	/**
	 * Definit la discipline de l'epreuve.
	 * 
	 * @param discipline La discipline a definir
	 * @return true si la discipline a ete definie avec succes
	 */
	public boolean setDiscipline(Discipline discipline) {
		this.discipline = discipline;
		return true;
	}

	/**
	 * Retire une session de l'epreuve.
	 * 
	 * @param session La session a retirer
	 * @return true si la session a ete retiree avec succes
	 */
	public boolean retirerSession(Session session) {
		// TODO - implement Epreuve.retirerSession
		throw new UnsupportedOperationException();
	}

	/**
	 * Affiche les informations de l'epreuve.
	 * 
	 * @return true si les informations ont ete affichees avec succes
	 */
	public boolean afficher() {
		System.out.println(nom);
		System.out.println(description);
		System.out.println("Est individuelle : " + individuelle);
		System.out.println("Discipline : " + discipline.getNom());
		return true;
	}

	/**
	 * Affiche le classement de l'epreuve.
	 * 
	 * @return true si le classement a ete affiche avec succes
	 */
	public boolean afficherClassement() {
		// TODO - implement Epreuve.afficherClassement
		throw new UnsupportedOperationException();
	}

	/**
	 * Retire un athlete de l'epreuve par son numero.
	 * 
	 * @param numeroAthlete Le numero de l'athlete a retirer
	 * @return true si l'athlete a ete retire avec succes
	 */
	public boolean retirerAthlete(int numeroAthlete) {
		// TODO - implement Epreuve.retirerAthlete
		throw new UnsupportedOperationException();
	}

	/**
	 * Detruit l'epreuve.
	 * 
	 * @return true si l'epreuve a ete detruite avec succes
	 */
	public boolean detruire() {
		// TODO - implement Epreuve.detruire
		throw new UnsupportedOperationException();
	}

	/**
	 * Affiche les resultats de l'epreuve.
	 * 
	 * @return true si les resultats ont ete affiches avec succes
	 */
	public boolean afficherResultat() {
		// TODO - implement Epreuve.afficherResultat
		throw new UnsupportedOperationException();
	}

	/**
	 * Retourne la discipline de l'epreuve.
	 * 
	 * @return La discipline de l'epreuve
	 */
	public Discipline getDiscipline() {
		return discipline;
	}

	/**
	 * Retourne le nom de l'epreuve.
	 * 
	 * @return Le nom de l'epreuve
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * Retourne la description de l'epreuve.
	 * 
	 * @return La description de l'epreuve
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Definit si l'epreuve est individuelle ou par equipe.
	 * 
	 * @param individuelle Indique si l'epreuve est individuelle ou par equipe
	 */
	public void setIndividuelle(boolean individuelle) {
		this.individuelle = individuelle;
	}
	
	/**
	 * Ordonne les sessions de l'epreuve.
	 */
	public void ordonnerSessions() {
		Collections.sort(sessions);
	}
	
	/**
	 * Affiche les sessions de l'epreuve.
	 */
	public void afficherSessions() {
		for(Session session : sessions) {
			System.out.println(session);
		}
	}

	/**
	 * Ordonne les sessions non ordonnees.
	 * 
	 * @param sessionsNonOrdonnee La liste des sessions non ordonnees
	 * @return La liste des sessions ordonnees
	 */
	@Override
	public ArrayList<Session> OrdonneSession(ArrayList<Session> sessionsNonOrdonnee) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Retourne la liste des sessions de l'epreuve.
	 * 
	 * @return La liste des sessions
	 */
	public ArrayList<Session> getSession() {
		return sessions;
	}
}
