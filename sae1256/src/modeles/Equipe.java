package modeles;

import java.util.*;

public class Equipe {

	private Pays pays;
	private Collection<Athlete> membres;
	private Discipline discipline;
	private Recompense recompenses;
	private int numero;
	private String nom;

	/**
	 * 
	 * @param nom
	 * @param pays
	 * @param discipline
	 */
	Equipe(String nom, Pays pays, Discipline discipline) {
		// TODO - implement Equipe.Equipe
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param Athlete
	 */
	public void ajouterMembre(Athlete membre) {
		// TODO - implement Equipe.ajouterMembre
		throw new UnsupportedOperationException();
	}

	public boolean afficherAthlete() {
		// TODO - implement Equipe.afficherAthlete
		throw new UnsupportedOperationException();
	}

	public void afficher() {
		// TODO - implement Equipe.afficher
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nom
	 */
	public Athlete[] rechercherAthlete(String nom) {
		// TODO - implement Equipe.rechercherAthlete
		throw new UnsupportedOperationException();
	}

	public double tauxPodium() {
		// TODO - implement Equipe.tauxPodium
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param Athlete
	 */
	public void retirerMembre(Athlete membre) {
		// TODO - implement Equipe.retirerMembre
		throw new UnsupportedOperationException();
	}

	public boolean modifier() {
		// TODO - implement Equipe.modifier
		throw new UnsupportedOperationException();
	}

	public boolean detruire() {
		// TODO - implement Equipe.detruire
		throw new UnsupportedOperationException();
	}

}