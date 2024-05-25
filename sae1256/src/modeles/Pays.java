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
    public static ArrayList<Pays> paysList = new ArrayList<Pays>();
    public static final String fileName = "pays.dat";

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
			if (equipe.getDiscipline().getNom().equalsIgnoreCase(athlete.getDiscipline().getNom())) {
				equipe.ajouterMembre(athlete);
				return true;
			}
		}
		return false;
	}
	
	//Cette méthode permet d'enregister (serialiser) les athlètes.
		//Les athletes sont stocké dans une liste pour etre facilement manipulable
		//Lorsque cette fonction est appelé sur un athlete, elle ajoute l'athlete à la 
		//la liste est enregistre la liste sur le disque
		public void enregister() {
			try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
				paysList.add(this); 
				outputStream.writeObject(paysList);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}
		
		//Cette methodes est relativement similaire à enregister() à la différence
		//qu'elle ne rajoute pas l'athlete, elle serialize uniquement pour que les 
		//modifications sont enregistrées. 
		public void enregisterModifications() {
			try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
				outputStream.writeObject(paysList);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}
}