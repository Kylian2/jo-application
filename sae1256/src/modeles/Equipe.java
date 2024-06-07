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
	 * @param nom Le nom
	 * @param discipline La Discipline
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
	 * @param membre Le membre p ajouter
	 */
	public void ajouterMembre(Athlete membre) {
		if(membre.getPays().getNom().equalsIgnoreCase(pays.getNom())) { //A voir si possibilité de faire comme en C++ pour comparer
			membres.add(membre);
		}else {
			throw new Error("L'athlète ne fait pas partie du pays de l'équipe");
		}
	}
	
	public ArrayList<Athlete> getMembres() {
		return membres;
	}

}