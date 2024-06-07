package modeles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

/**
 * Classe Equipe programmee par kylianrichard.
 * 
 * Cette classe represente une equipe sportive avec ses membres, pays, discipline et recompenses.
 * Elle permet d'ajouter des membres, d'afficher des informations et de gerer les membres de l'equipe.
 * 
 * @author kylianrichard
 */
public class Equipe implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Pays pays;
	private ArrayList<Athlete> membres;
	private Discipline discipline;
	private Recompense recompenses;
	private int numero;
	private String nom;

	/**
	 * Constructeur de la classe Equipe.
	 * 
	 * @param nom Le nom de l'equipe
	 * @param discipline La discipline de l'equipe
	 */
	public Equipe(String nom, Discipline discipline) {
		this.nom = nom; 
		this.discipline = discipline;
		recompenses = new Recompense(this);
		membres = new ArrayList<Athlete>();
	}
	
	/**
	 * Retourne la discipline de l'equipe.
	 * 
	 * @return La discipline de l'equipe
	 */
	public Discipline getDiscipline() {
		return this.discipline;
	}
	
	/**
	 * Definit le pays de l'equipe.
	 * 
	 * @param pays Le pays de l'equipe
	 */
	public void setPays(Pays pays) {
		this.pays = pays;
	}
	
	/**
	 * Retourne le pays de l'equipe.
	 * 
	 * @return Le pays de l'equipe
	 */
	public Pays getPays() {
		return this.pays;
	}
	
	/**
	 * Retourne le nom de l'equipe.
	 * 
	 * @return Le nom de l'equipe
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Ajoute un membre a l'equipe.
	 * 
	 * @param membre Le membre a ajouter
	 */
	public void ajouterMembre(Athlete membre) {
		if(membre.getPays().getNom().equalsIgnoreCase(pays.getNom())) { 
			membres.add(membre);
		}else {
			throw new Error("L'athlete ne fait pas partie du pays de l'equipe");
		}
	}
	
	/**
	 * Retourne la liste des membres de l'equipe.
	 * 
	 * @return La liste des membres de l'equipe
	 */
	public ArrayList<Athlete> getMembres() {
		return membres;
	}
}