package controleurs;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

import javax.swing.JPanel;

import modeles.ApplicationJo;
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
}
