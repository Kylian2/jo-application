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
			if (equipe.getDiscipline().getNom() == athlete.getDiscipline().getNom()) {
				equipe.ajouterMembre(athlete);
				return true;
			}
		}
		return false;
	}

}