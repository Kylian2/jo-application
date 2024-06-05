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

public class ApplicationJo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public ArrayList<Pays> paysList;
	public ArrayList<Discipline> disciplinesList;
	public ArrayList<Athlete> athletesList;
	
	
	//ignore lors de la serialization
	public transient JPanel mainPanel;
	public transient VueListeAthlete vueListeAthlete;
	
	public static final String fileName = "application-jo.dat";
	
	public ApplicationJo(){
		paysList = new ArrayList<Pays>();
		disciplinesList = new ArrayList<Discipline>();
		athletesList = new ArrayList<Athlete>();
	}
	
	public void setMainPanel(JPanel panel) {
		this.mainPanel = panel;
	}
	
	public void setVueListeAthlete(VueListeAthlete vueListeAthlete) {
		this.vueListeAthlete = vueListeAthlete;
	}
	
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