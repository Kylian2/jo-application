package modeles;

import java.util.*;

public class Discipline {

	private Collection<Athlete> pratiquants;
	private Collection<Epreuve> sesEpreuves;
	private Collection<Equipe> lesEquipes;
	private int numero;
	private String description;
	private String nom;

	/**
	 * 
	 * @param nom
	 * @param description
	 */
	Discipline(String nom, String description) {
		// TODO - implement Discipline.Discipline
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param epreuve
	 */
	public boolean ajouterEpreuve(Epreuve epreuve) {
		// TODO - implement Discipline.ajouterEpreuve
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param epreuve
	 */
	public boolean retirerEpreuve(Epreuve epreuve) {
		// TODO - implement Discipline.retirerEpreuve
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nom
	 */
	public Epreuve[] rechercherEpreuve(String nom) {
		// TODO - implement Discipline.rechercherEpreuve
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param equipe
	 */
	public boolean ajouterEquipe(Equipe equipe) {
		// TODO - implement Discipline.ajouterEquipe
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param numeroEquipe
	 */
	public boolean retirerEquipe(int numeroEquipe) {
		// TODO - implement Discipline.retirerEquipe
		throw new UnsupportedOperationException();
	}

	public boolean modifier() {
		// TODO - implement Discipline.modifier
		throw new UnsupportedOperationException();
	}

}