package controleurs;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

import javax.swing.JPanel;

import modeles.ApplicationJo;
import modeles.Discipline;
import modeles.Epreuve;
import modeles.Session;
import vues.ListeEpreuve;

public class ControleurSession implements Controleur{
	
	JPanel lastPanel;
	ApplicationJo application; 
	
	public ControleurSession(ApplicationJo application) {
		this.application = application;
	}

	public void retour() {
		
		application.mainPanel.removeAll();
		application.mainPanel.add(lastPanel);
		((ListeEpreuve) lastPanel).refresh();
		//application.mainPanel.add(application.vueListeAthlete);
		// Rafraîchir le conteneur
        application.mainPanel.revalidate();
        application.mainPanel.repaint();
		
	}
	
	public void setLastPanel(JPanel panel) {
		this.lastPanel = panel;
	}
	

    public static LocalDate convertStringToLocalDate(String dateString) {
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        try {
            return LocalDate.parse(dateString, formatter);
        } catch (DateTimeParseException e) {
            System.err.println("Erreur de parsing: " + e.getMessage());
            return null;
        }
    }

	public ArrayList<Session> getToutesSessionOrdonnées() {
		ArrayList<Session> toutesSessionOrdonnee = new ArrayList<Session>();
		for(Discipline discipline : this.application.disciplinesList) {
			for(Epreuve epreuve : discipline.getEpreuves()) {
				for(Session session : epreuve.getSession()) {
					toutesSessionOrdonnee.add(session);
				}
			}
		}
		Collections.sort(toutesSessionOrdonnee);
		
		for(Session session : toutesSessionOrdonnee) {
			System.out.println(session);
		}
		return toutesSessionOrdonnee;
	}
}
