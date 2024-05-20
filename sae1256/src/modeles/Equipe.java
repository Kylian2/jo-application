package modeles;

import java.util.*;

public class Equipe {

	private Pays pays;
	private ArrayList<Athlete> membres;
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
		this.nom = nom; 
		this.pays = pays;
		this.discipline = discipline;
		recompenses = new Recompense();
		membres = new ArrayList<Athlete>();
	}

	/**
	 * 
	 * @param Athlete
	 */
	public void ajouterMembre(Athlete membre) {
		if(membre.getPays().getNom() == pays.getNom()) { //A voir si possibilité de faire comme en C++ pour comparer
			membres.add(membre);
		}else {
			throw new Error("L'athlète ne fait pas partie du pays de l'équipe");
		}
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