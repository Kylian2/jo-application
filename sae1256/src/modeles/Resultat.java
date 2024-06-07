package modeles;

/**
 * Classe Resultat programmee par kylianrichard.
 * 
 * Cette classe represente le resultat d'un athlete dans une epreuve.
 * 
 * @author kylianrichard
 */
public class Resultat {

	private Classement classement;
	private Athlete athlete;
	private int numero;
	private int score;
	private int penalite;
	private int scoreFinal;
	private Epreuve epreuve;

	/**
	 * Constructeur pour la classe Resultat.
	 * 
	 * @param athlete  L'athlete concerne
	 * @param score    Le score obtenu
	 * @param penalite La penalite appliquee
	 */
	Resultat(Athlete athlete, int score, int penalite) {
		// TODO - implement Resultat.Resultat
		throw new UnsupportedOperationException();
	}

	/**
	 * Modifier la penalite.
	 * 
	 * @param newPenalite La nouvelle penalite a appliquer
	 */
	public void modifiePenalite(int newPenalite) {
		// TODO - implement Resultat.modifiePenalite
		throw new UnsupportedOperationException();
	}

	/**
	 * Calculer le score final en prenant en compte les penalites.
	 * 
	 * @return Le score final apres penalites
	 */
	public int calculerScoreFinal() {
		// TODO - implement Resultat.calculerScoreFinal
		throw new UnsupportedOperationException();
	}

	/**
	 * Afficher le resultat.
	 * 
	 * @return true si l'affichage est reussi, false sinon
	 */
	public boolean afficher() {
		// TODO - implement Resultat.afficher
		throw new UnsupportedOperationException();
	}

	/**
	 * Ajouter le resultat au classement.
	 */
	public void ajouterClassement() {
		// TODO - implement Resultat.ajouterClassement
		throw new UnsupportedOperationException();
	}

}
