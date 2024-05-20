package modeles;

import java.util.*;

public class Pays {

	private Collection<Athlete> membres;
	private Collection<Equipe> equipes;
	private Recompense recompenses;
	private String code;
	private String nom;
	
	public Pays(String code, String nom) {
		this.code = code;
		this.nom = nom;
		recompenses = new Recompense();
		
		membres = new ArrayList<Athlete>();
		equipes = new ArrayList<Equipe>();
	}

	/**
	 * 
	 * @param equipe
	 */
	public boolean ajouterEquipe(Equipe equipe) {
		// TODO - implement Pays.ajouterEquipe
		throw new UnsupportedOperationException();
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

	public boolean afficherEquipes() {
		// TODO - implement Pays.afficherEquipes
		throw new UnsupportedOperationException();
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

}