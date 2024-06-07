package modeles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JPanel;

import vues.VueListeAthlete;
/**
 * Cette classe représente l'application pour les Jeux Olympiques.
 * Elle gère les listes de pays, disciplines et athlètes, ainsi que la sérialisation
 * des données de l'application.
 * 
 * @author kylianrichard
 * 
 * @param paysList Liste des pays participant aux Jeux Olympiques.
 * @param disciplinesList Liste des disciplines sportives des Jeux Olympiques.
 * @param athletesList Liste des athlètes participant aux Jeux Olympiques.
 * @param mainPanel Le panneau principal de l'interface graphique de l'application.
 * @param vueListeAthlete La vue affichant la liste des athlètes dans l'interface graphique.
 * @param fileName Le nom du fichier de sauvegarde des données de l'application.
 */
public class ApplicationJo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public ArrayList<Pays> paysList;
	public ArrayList<Discipline> disciplinesList;
	public ArrayList<Athlete> athletesList;
	
	
	//ignore lors de la serialization
	public transient JPanel mainPanel;
	public transient VueListeAthlete vueListeAthlete;
	
	public static final String fileName = "application-jo.dat";
	
	/**
     * Constructeur par défaut de l'application pour les Jeux Olympiques.
     * Initialise les listes de pays, disciplines et athlètes.
     */
	public ApplicationJo(){
		paysList = new ArrayList<Pays>();
		disciplinesList = new ArrayList<Discipline>();
		athletesList = new ArrayList<Athlete>();
	}
	
	/**
     * Définit le panneau principal de l'interface graphique de l'application.
     * 
     * @param panel Le panneau principal à définir.
     */
	public void setMainPanel(JPanel panel) {
		this.mainPanel = panel;
	}
	
	/**
     * Définit la vue affichant la liste des athlètes dans l'interface graphique de l'application.
     * 
     * @param vueListeAthlete La vue à définir pour afficher la liste des athlètes.
     */
	public void setVueListeAthlete(VueListeAthlete vueListeAthlete) {
		this.vueListeAthlete = vueListeAthlete;
	}
	
	/**
     * Enregistre les données de l'application dans un fichier.
     */
	public void enregister() {
		try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
			//this.paysList = Pays.paysList;
            //this.athletesList = Athlete.athletesList;
            //this.disciplinesList = Discipline.disciplinesList;			
            outputStream.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	/**
     * Récupère les données sérialisées depuis un fichier et les charge dans l'application.
     */
	//Permet de récupérer les elements qui ont été sérialisé dans un fichier. 
	public void recuperer() { //
		File f = new File(fileName);
		if(f.exists()) {
			try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
				ApplicationJo deserialized = (ApplicationJo) inputStream.readObject();
	            this.paysList = deserialized.paysList;
	            this.athletesList = deserialized.athletesList;
	            this.disciplinesList = deserialized.disciplinesList;
	            
	        } catch (IOException | ClassNotFoundException e) {
	            e.printStackTrace();
	        }
		}else {
			System.out.println("Impossible de récupérer les données, le fichier n'existe pas");
		}
	}

}