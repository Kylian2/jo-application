package controleurs;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.regex.Pattern;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import modeles.ApplicationJo;
import modeles.Athlete;
import modeles.Discipline;
import modeles.Epreuve;
import modeles.Session;
import vues.ListeEpreuve;
import vues.VuePlanning;

public class ControleurSession implements Controleur{
	
	JPanel lastPanel;
	public ApplicationJo application; 
	
	public ControleurSession(ApplicationJo application) {
		this.application = application;
	}

	public void retour() {
		
		if(lastPanel instanceof VuePlanning) {
			application.mainPanel.removeAll();
			application.mainPanel.add(lastPanel);
			//((VuePlanning) lastPanel).refresh();
			//application.mainPanel.add(application.vueListeAthlete);
			// Rafraîchir le conteneur
	        application.mainPanel.revalidate();
	        application.mainPanel.repaint();
		}
		
	}
	
	public void setLastPanel(JPanel panel) {
		this.lastPanel = panel;
	}
	

    public static LocalDate convertStringToLocalDate(String dateString) {
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
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
		
		return toutesSessionOrdonnee;
	}
	
	public ArrayList<Epreuve> getEpreuveDiscipline(String nom){
		for(Discipline discipline : application.disciplinesList) {
			if(discipline.getNom().equalsIgnoreCase(nom)) {
				return discipline.getEpreuves();
			}
		}
		return new ArrayList<Epreuve>(); 
	}
	

	public String verifierEtCorrigerFormatHeure(String heure) {
	    // Expression régulière pour vérifier le format HH:mm ou H:mm
	    Pattern pattern = Pattern.compile("^(\\d{2}):[0-5][0-9]$");
	
	    if (pattern.matcher(heure).matches()) {
		        return heure;
	    }else {
    		if (heure.matches("^\\d:[0-5][0-9]$")) {
		        heure = "0" + heure;
		        return heure;
    		}else {
    			JOptionPane.showMessageDialog(null, "Format d'heure incorrect. Rappel : HH:mm'", "Erreur", JOptionPane.WARNING_MESSAGE);
    		}
	    }
	    return null;
	}
	
	public boolean ajouterSession(String date, String heure, String duree, String lieu, String sexe, String discipline, String epreuve, ArrayList<Athlete> athleteParticipants) {
		
		boolean dureeValide = true;
		int dureeInt = 0;
		LocalDate dateFormatee = convertStringToLocalDate(date); 

		Epreuve epreuvePourAjout = getEpreuve(epreuve, discipline);
		
		String heureValide = verifierEtCorrigerFormatHeure(heure);
		System.out.println("heure"+heureValide);
		if(heureValide == null) {
			return false;
		}
		
		if(dateFormatee == null) {
			JOptionPane.showMessageDialog(null, "Format de date incorrect. Rappel : JJ/MM/AAAA", "Erreur", JOptionPane.WARNING_MESSAGE);
		}
		
		try {
			dureeInt = Integer.parseInt(duree);
        } catch (NumberFormatException error) {
        	JOptionPane.showMessageDialog(null, "La durée doit être entière", "Erreur", JOptionPane.WARNING_MESSAGE);
        	dureeValide = false;
        }
		
		if(dureeValide && epreuvePourAjout != null && dateFormatee != null) {
			Session newSession = new Session(dateFormatee, heureValide, dureeInt, lieu, sexe, athleteParticipants);
			newSession.setEpreuve(epreuvePourAjout);
			newSession.afficher();
			for(Athlete participant : newSession.getParticipants()) {
				System.out.println(participant.getNom());
			}
			epreuvePourAjout.ajouterSession(newSession);
			this.enregister();
			
	        System.out.println("Liste des sessions des epreuves de Natation");
	        for (Epreuve epreuve2 : application.disciplinesList.get(1).getEpreuves()) {
	        	System.out.println(epreuve2.getNom());
	        	for(Session session : epreuve2.getSession()) {
	        		System.out.println(session);
	        	}
	        }
	        
	        System.out.println("Liste des sessions des epreuves d'athlétisme ");
	        for (Epreuve epreuve2 : application.disciplinesList.get(0).getEpreuves()) {
	        	System.out.println(epreuve2.getNom());
	        	for(Session session : epreuve2.getSession()) {
	        		System.out.println(session);
	        	}
	        }
	        
			return true;
		}
		return false; 
	}
	
	public Epreuve getEpreuve(String epreuveNom, String discipline) {
		int disciplineIndex = getDisciplineIndex(discipline);
		
		for(Epreuve epreuve : application.disciplinesList.get(disciplineIndex).getEpreuves()) {
			if(epreuve.getNom().equalsIgnoreCase(epreuveNom)) {
				return epreuve;
			}
		}
		
		return null;
	}
	
	public int getDisciplineIndex(String nom) {
		
		int index = -1;
		for (int i = 0; i < application.disciplinesList.size(); i++) {
			if(application.disciplinesList.get(i).getNom().equalsIgnoreCase(nom)) {
				index = i;
				return index;
			}
		}
		return -1;
	}
	
	public void enregister() {
		application.enregister();
	}
	
	public ArrayList<Session> getToutesSessionsDeLaDate(LocalDate date) {
		ArrayList<Session> sessionsDeLaDate = new ArrayList<Session>();
		for (Session session : getToutesSessionOrdonnées()) {
			if (session.getDate().isEqual(date)){
				sessionsDeLaDate.add(session);
			}
		}
		return sessionsDeLaDate;
	}
}
