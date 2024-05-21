package modeles;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class Athlete implements Serializable{
	
    private static final long serialVersionUID = 1L;
    public static ArrayList<Athlete> athletesList = new ArrayList<>();
    public static final String fileName = "athlete.dat";

	public static final char HOMME = 'H';
	public static final char FEMME = 'F';
	
	private Collection<Epreuve> inscriptions;
	private Collection<Resultat> sesResultats;
	private Pays pays;
	private Equipe equipe;
	private Discipline discipline;
	private Collection<Session> engagements;
	private Recompense recompenses;
	private int numero;
	private String nom;
	private String prenom;
	private int taille;
	private int poids;
	private String description;
	private String dateNaissance;
	private char genre;

	/**
	 * 
	 * @param nom
	 * @param prenom
	 * @param taille
	 * @param poids
	 * @param description
	 * @param dateNaissance
	 * @param genre
	 */
	public Athlete(String nom, String prenom, int taille, int poids, String description, String dateNaissance, char genre) {
		this.nom = nom; 
		this.prenom = prenom; 
		
		if(taille > 0) {
			this.taille = taille;
		}else {
			throw new Error("Attribut de taille invalide, la taille doit être supérieure à 0cm.");
		}
		
		if(poids > 0) {
			this.poids = poids;
		}else {
			throw new Error("Attribut de poids invalide, le poids doit être supérieur à 0kg.");
		}
		
		this.description = description;
		this.dateNaissance = dateNaissance;
		
		if(genre == HOMME || genre == FEMME) {
			this.genre = genre;
		}else {
			throw new Error("Genre invalide, les deux genre possibles sont HOMME ou FEMME.");
		}
		
		this.enregister();
	}

	/**
	 * 
	 * @param discipline
	 */
	public boolean setDiscipline(Discipline discipline) {
		this.discipline = discipline;
		return true;
	}
	
	public Discipline getDiscipline() {
		return this.discipline;
	}

	/**
	 * 
	 * @param session
	 */
	public boolean engager(Session session) {
		// TODO - implement Athlete.engager
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param session
	 */
	public boolean desengager(Session session) {
		// TODO - implement Athlete.desengager
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param equipe
	 */
	public boolean ajouterEquipe(Equipe equipe) {
		// TODO - implement Athlete.ajouterEquipe
		throw new UnsupportedOperationException();
	}

	public boolean retirerEquipe() {
		// TODO - implement Athlete.retirerEquipe
		throw new UnsupportedOperationException();
	}

	public Athlete rechercher() {
		// TODO - implement Athlete.rechercher
		throw new UnsupportedOperationException();
	}

	public int calculerAge() {
		// TODO - implement Athlete.calculerAge
		throw new UnsupportedOperationException();
	}

	public boolean afficherEpreuves() {
		// TODO - implement Athlete.afficherEpreuves
		throw new UnsupportedOperationException();
	}

	public boolean afficher() {
		// TODO - implement Athlete.afficher
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param epreuve
	 */
	public boolean ajouterEpreuve(Epreuve epreuve) {
		// TODO - implement Athlete.ajouterEpreuve
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param numeroEpreuve
	 */
	public boolean retirerEpreuve(int numeroEpreuve) {
		// TODO - implement Athlete.retirerEpreuve
		throw new UnsupportedOperationException();
	}

	public boolean detruire() {
		// TODO - implement Athlete.detruire
		throw new UnsupportedOperationException();
	}

	public boolean modifier() {
		// TODO - implement Athlete.modifier
		throw new UnsupportedOperationException();
	}
	
	public Pays getPays() {
		return pays;
	}
	
	public void setPays(Pays pays) {
		this.pays = pays;
	}
	
	public String toString() {
		return nom + " " + prenom + " : " + description;
	}
	
	
	//Cette méthode permet d'enregister (serialiser) les athlètes.
	//Les athletes sont stocké dans une liste pour etre facilement manipulable
	//Lorsque cette fonction est appelé sur un athlete, elle ajoute l'athlete à la 
	//la liste est enregistre la liste sur le disque
	public void enregister() {
		try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            athletesList.add(this); 
			outputStream.writeObject(athletesList);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	//Cette methodes est relativement similaire à enregister() à la différence
	//qu'elle ne rajoute pas l'athlete, elle serialize uniquement pour que les 
	//modifications sont enregistrées. 
	public void enregisterModifications() {
		try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
			outputStream.writeObject(athletesList);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	//Permet de récupérer les elements qui ont été sérialisé dans un fichier. 
	public static void recuperer() { //
		File f = new File(fileName);
		if(f.exists()) {
			try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
	            ArrayList<Athlete> deserializedAthletes = (ArrayList<Athlete>) inputStream.readObject();
	            athletesList.clear();
	            for(Athlete athlete: deserializedAthletes ) {
	            	athletesList.add(athlete);
	            }
	        } catch (IOException | ClassNotFoundException e) {
	            e.printStackTrace();
	        }
		}else {
			System.out.println("Impossible de récupérer les données, le fichier n'existe pas");
		}
	}
	
	public void setDescription(String description) {
		this.description = description;
		this.enregisterModifications();
	}

}