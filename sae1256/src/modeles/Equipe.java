package modeles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class Equipe implements Serializable{
	
	private static final long serialVersionUID = 1L;

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
	public Equipe(String nom, Discipline discipline) {
		this.nom = nom; 
		this.discipline = discipline;
		recompenses = new Recompense(this);
		membres = new ArrayList<Athlete>();
	}
	
	public Discipline getDiscipline() {
		return this.discipline;
	}
	
	public void setPays(Pays pays) {
		this.pays = pays;
	}
	
	public Pays getPays() {
		return this.pays;
	}
	
	public String getNom() {
		return nom;
	}

	/**
	 * 
	 * @param Athlete
	 */
	public void ajouterMembre(Athlete membre) {
		if(membre.getPays().getNom().equalsIgnoreCase(pays.getNom())) { //A voir si possibilité de faire comme en C++ pour comparer
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
	
	public ArrayList<Athlete> getMembres() {
		return membres;
	}

}