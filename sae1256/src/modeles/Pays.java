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
 * Classe Pays programmee par kylianrichard.
 * 
 * Cette classe represente un pays avec ses membres, equipes, recompenses, code et nom.
 * 
 * @author kylianrichard
 */
public class Pays implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private ArrayList<Athlete> membres;
	private ArrayList<Equipe> equipes;
	private Recompense recompenses;
	private String code;
	private String nom;
	
	// A implementer : verification de l'unicite des pays. 
    public static ArrayList<Pays> paysList = new ArrayList<Pays>();
	
	/**
	 * Constructeur pour la classe Pays.
	 * 
	 * @param code Le code du pays
	 * @param nom Le nom du pays
	 */
	public Pays(String code, String nom) {
		this.code = code;
		this.nom = nom; 
		recompenses = new Recompense(this);
		
		membres = new ArrayList<Athlete>();
		equipes = new ArrayList<Equipe>();
		
		// Une equipe pour chaque discipline est creee et ajoutee a la liste des equipes du pays
		for(Discipline discipline : Discipline.disciplinesList ) {
			ajouterEquipe(new Equipe("Equipe de "+ nom + " de " + discipline.getNom(), discipline));
		}
	}

	/**
	 * Ajouter une equipe a la liste des equipes du pays.
	 * 
	 * @param equipe L'equipe a ajouter
	 * @return true si l'ajout est reussi
	 */
	public boolean ajouterEquipe(Equipe equipe) {
		equipes.add(equipe);
		equipe.setPays(this);
		return true;
	}

	/**
	 * Retirer une equipe de la liste des equipes du pays.
	 * 
	 * @param equipe L'equipe a retirer
	 * @return boolean
	 */
	public boolean retirerEquipe(Equipe equipe) {
		// TODO - implement Pays.retirerEquipe
		throw new UnsupportedOperationException();
	}

	/**
	 * Afficher les informations du pays.
	 * 
	 * @return boolean
	 */
	public boolean afficher() {
		// TODO - implement Pays.afficher
		throw new UnsupportedOperationException();
	}

	/**
	 * Afficher les equipes du pays.
	 * 
	 * @return true si l'affichage est reussi
	 */
	public boolean afficherEquipes() { 
		for (Equipe equipe: equipes) {
			System.out.println(equipe.getNom());
		}
		return true;
	}

	/**
	 * Modifier les informations du pays.
	 */
	public void modifier() {
		// TODO - implement Pays.modifier
		throw new UnsupportedOperationException();
	}

	/**
	 * Afficher le nombre de medailles du pays.
	 * 
	 * @return boolean
	 */
	public boolean afficherNbMedailles() {
		// TODO - implement Pays.afficherNbMedailles
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Obtenir le nom du pays.
	 * 
	 * @return Le nom du pays
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * Ajouter un athlete au pays.
	 * 
	 * @param athlete L'athlete a ajouter
	 * @return true si l'ajout est reussi, false sinon
	 */
	public boolean ajouterAthlete(Athlete athlete) {
		membres.add(athlete);
		athlete.setPays(this);
		for(Equipe equipe : equipes) {
			System.out.println(equipe.getDiscipline().getNom() + " - " + athlete.getDiscipline().getNom());
			if (equipe.getDiscipline().getNom().equalsIgnoreCase(athlete.getDiscipline().getNom())) {
				equipe.ajouterMembre(athlete);
				athlete.setEquipe(equipe);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Ajouter une medaille d'or au pays.
	 */
	public void ajouterOr() {
		recompenses.ajouterOr();
	}

	/**
	 * Ajouter une medaille d'argent au pays.
	 */
	public void ajouterArgent() {
		recompenses.ajouterArgent();
	}

	/**
	 * Ajouter une medaille de bronze au pays.
	 */
	public void ajouterBronze() {
		recompenses.ajouterBronze();
	}

	/**
	 * Retirer une medaille d'or au pays.
	 */
	public void retirerOr() {
		recompenses.retirerOr();
	}

	/**
	 * Retirer une medaille d'argent au pays.
	 */
	public void retirerArgent() {
		recompenses.retirerArgent();
	}

	/**
	 * Retirer une medaille de bronze au pays.
	 */
	public void retirerBronze() {
		recompenses.retirerArgent();
	}

	/**
	 * Obtenir le nombre de medailles d'or du pays.
	 * 
	 * @return Le nombre de medailles d'or
	 */
	public int getOr() {
		return recompenses.getOr();
	}

	/**
	 * Obtenir le nombre de medailles d'argent du pays.
	 * 
	 * @return Le nombre de medailles d'argent
	 */
	public int getArgent() {
		return recompenses.getArgent();
	}

	/**
	 * Obtenir le nombre de medailles de bronze du pays.
	 * 
	 * @return Le nombre de medailles de bronze
	 */
	public int getBronze() {
		return recompenses.getBronze();
	}
	
	/**
	 * Definir le code du pays.
	 * 
	 * @param code Le code du pays
	 */
	public void setCode(String code) {
		this.code = code;
	}
	
	/**
	 * Obtenir le code du pays.
	 * 
	 * @return Le code du pays
	 */
	public String getCode() {
		return code;
	}
	
	/**
	 * Obtenir la liste des equipes du pays.
	 * 
	 * @return La liste des equipes
	 */
	public ArrayList<Equipe> getEquipes(){
		return equipes;
	}

	/**
	 * Definir la liste des equipes du pays.
	 * 
	 * @param equipes La liste des equipes
	 */
	public void setEquipes(ArrayList<Equipe> equipes) {
		this.equipes = equipes;
	}
	
}
