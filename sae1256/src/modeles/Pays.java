package modeles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class Pays implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private ArrayList<Athlete> membres;
	private ArrayList<Equipe> equipes;
	private Recompense recompenses;
	private String code;
	private String nom;
	
	//A implémenter : verification de l'unicité des pays. 
    public static ArrayList<Pays> paysList = new ArrayList<Pays>();
	
	public Pays(String code, String nom) {
		this.code = code;
		this.nom = nom; 
		recompenses = new Recompense(this);
		
		membres = new ArrayList<Athlete>();
		equipes = new ArrayList<Equipe>();
		
		//Une equipe pour chaque discipline est créée et ajoutée à la liste des équipes du pays
		for(Discipline discipline : Discipline.disciplinesList ) {
			ajouterEquipe(new Equipe("Equipe de "+ nom + " de " + discipline.getNom(), discipline));
		}
	}

	/**
	 * 
	 * @param equipe
	 */
	public boolean ajouterEquipe(Equipe equipe) {
		equipes.add(equipe);
		equipe.setPays(this);
		return true;
	}

	/**
	 * 
	 * @param equipe
	 */
	public boolean retirerEquipe(Equipe equipe) {
		// TODO - implement Pays.retirerEquipe
		throw new UnsupportedOperationException();
	}

	public boolean afficher() {
		// TODO - implement Pays.afficher
		throw new UnsupportedOperationException();
	}

	//Version pour les tests dans la console.
	//La méthode peut etre modifiée si besoin
	public boolean afficherEquipes() { 
		for (Equipe equipe: equipes) {
			System.out.println(equipe.getNom());
		}
		return true;
	}

	public void modifier() {
		// TODO - implement Pays.modifier
		throw new UnsupportedOperationException();
	}

	public boolean afficherNbMedailles() {
		// TODO - implement Pays.afficherNbMedailles
		throw new UnsupportedOperationException();
	}
	
	public String getNom() {
		return nom;
	}
	
	public boolean ajouterAthlete(Athlete athlete) {
		membres.add(athlete);
		athlete.setPays(this);
		for(Equipe equipe : equipes) {
			if (equipe.getDiscipline().getNom().equalsIgnoreCase(athlete.getDiscipline().getNom())) {
				equipe.ajouterMembre(athlete);
				athlete.setEquipe(equipe);
				return true;
			}
		}
		return false;
	}
	
	public void ajouterOr() {
		recompenses.ajouterOr();
	}

	public void ajouterArgent() {
		recompenses.ajouterArgent();
	}

	public void ajouterBronze() {
		recompenses.ajouterBronze();
	}

	public void retirerOr() {
		recompenses.retirerOr();
	}

	public void retirerArgent() {
		recompenses.retirerArgent();
	}

	public void retirerBronze() {
		recompenses.retirerArgent();
	}

	public int getOr() {
		return recompenses.getOr();
	}

	public int getArgent() {
		return recompenses.getArgent();
	}

	public int getBronze() {
		return recompenses.getBronze();
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
	
	public ArrayList<Equipe> getEquipes(){
		return equipes;
	}

	public void setEquipes(ArrayList<Equipe> equipes) {
		this.equipes = equipes;
	}
	
}