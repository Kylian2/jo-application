package modeles;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe Recompense programmee par kylianrichard.
 * 
 * Cette classe represente les recompenses pour un athlete, une equipe ou un pays.
 * 
 * @author kylianrichard
 */
public class Recompense implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Equipe equipe;
	private Athlete athlete;
	private Pays pays;
	private int or;
	private int argent;
	private int bronze;

	/**
	 * Constructeur pour la classe Recompense lie a un athlete.
	 * 
	 * @param athlete L'athlete concerne
	 */
	public Recompense(Athlete athlete) {
		this.athlete = athlete;
		this.pays = null;
		this.equipe = null;
		this.or = 0;
		this.argent = 0;
		this.bronze = 0;
	}
	
	/**
	 * Constructeur pour la classe Recompense lie a un pays.
	 * 
	 * @param pays Le pays concerne
	 */
	public Recompense(Pays pays) {
		this.pays = pays;
		this.athlete = null;
		this.equipe = null;
		this.or = 0;
		this.argent = 0;
		this.bronze = 0;
	}
	
	/**
	 * Constructeur pour la classe Recompense lie a une equipe.
	 * 
	 * @param equipe L'equipe concerne
	 */
	public Recompense(Equipe equipe) {
		this.equipe = equipe;
		this.pays = null;
		this.athlete = null;
		this.or = 0;
		this.argent = 0;
		this.bronze = 0;
	}
	
	/**
	 * Ajouter une medaille d'or.
	 */
	public void ajouterOr() {
		or++;
	}

	/**
	 * Ajouter une medaille d'argent.
	 */
	public void ajouterArgent() {
		argent++;
	}

	/**
	 * Ajouter une medaille de bronze.
	 */
	public void ajouterBronze() {
		bronze++;
	}

	/**
	 * Retirer une medaille d'or.
	 */
	public void retirerOr() {
		or--;
	}

	/**
	 * Retirer une medaille d'argent.
	 */
	public void retirerArgent() {
		argent--;
	}

	/**
	 * Retirer une medaille de bronze.
	 */
	public void retirerBronze() {
		bronze--;
	}

	/**
	 * Obtenir le nombre de medailles d'or.
	 * 
	 * @return Le nombre de medailles d'or
	 */
	public int getOr() {
		return or;
	}

	/**
	 * Obtenir le nombre de medailles d'argent.
	 * 
	 * @return Le nombre de medailles d'argent
	 */
	public int getArgent() {
		return argent;
	}

	/**
	 * Obtenir le nombre de medailles de bronze.
	 * 
	 * @return Le nombre de medailles de bronze
	 */
	public int getBronze() {
		return bronze;
	}

}
