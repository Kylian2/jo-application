package modeles;

import java.util.*;

/**
 * Classe Classement programmee par kylianrichard.
 * 
 * Cette classe represente le classement des resultats pour une epreuve specifique.
 * Elle permet d'ajouter, retirer, trier et rechercher des resultats, ainsi que d'afficher le classement.
 * 
 * @author kylianrichard
 */
public class Classement {

	private Collection<Resultat> classement;
	private Epreuve epreuve;
	private int numero;

	/**
	 * Constructeur de la classe Classement.
	 * 
	 * @param epreuve L'epreuve associee au classement
	 */
	Classement(Epreuve epreuve) {
		// TODO - implement Classement.Classement
		throw new UnsupportedOperationException();
	}

	/**
	 * Ajoute un resultat au classement.
	 * 
	 * @param resultat Le resultat a ajouter
	 * @return true si le resultat a ete ajoute avec succes
	 */
	public boolean ajouterResultat(Resultat resultat) {
		// TODO - implement Classement.ajouterResultat
		throw new UnsupportedOperationException();
	}

	/**
	 * Trie les resultats du classement.
	 * 
	 * @return true si le classement a ete trie avec succes
	 */
	public boolean trier() {
		// TODO - implement Classement.trier
		throw new UnsupportedOperationException();
	}

	/**
	 * Retire un resultat du classement.
	 * 
	 * @param resultat Le resultat a retirer
	 * @return true si le resultat a ete retire avec succes
	 */
	public boolean retirerResultat(Resultat resultat) {
		// TODO - implement Classement.retirerResultat
		throw new UnsupportedOperationException();
	}

	/**
	 * Affiche le classement.
	 * 
	 * @return true si le classement a ete affiche avec succes
	 */
	public boolean afficher() {
		// TODO - implement Classement.afficher
		throw new UnsupportedOperationException();
	}

	/**
	 * Recherche un athlete dans le classement par son nom.
	 * 
	 * @param nom Le nom de l'athlete a rechercher
	 * @return Un tableau des resultats trouves
	 */
	public Resultat[] rechercherAthlete(String nom) {
		// TODO - implement Classement.rechercherAthlete
		throw new UnsupportedOperationException();
	}

	/**
	 * Modifie le classement.
	 * 
	 * @return true si le classement a ete modifie avec succes
	 */
	public boolean modifier() {
		// TODO - implement Classement.modifier
		throw new UnsupportedOperationException();
	}
}
