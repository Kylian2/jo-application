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

/**
 * Controleur pour la gestion des sessions.
 * Cette classe contient les methodes pour ajouter, vérifier et manipuler des sessions.
 * 
 * @author kylianrichard
 */
public class ControleurSession implements Controleur{
	
	JPanel lastPanel;
	public ApplicationJo application; 
	
	/**
     * Constructeur du controleur de session.
     * 
     * @param application L'application principale
     * @author kylianrichard
     */
	public ControleurSession(ApplicationJo application) {
		this.application = application;
	}

	/**
     * Retourne au panneau précédent.
     * @author kylianrichard
     */
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
	
	/**
     * Définit le dernier panneau utilisé.
     * 
     * @param panel Le panneau à définir comme dernier panneau
     * @author kylianrichard
     */
	public void setLastPanel(JPanel panel) {
		this.lastPanel = panel;
	}
	
	/**
     * Convertit une chaîne de caractères en objet LocalDate.
     * 
     * @param dateString La chaîne de caractères représentant la date
     * @return LocalDate représentant la date
     * @author kylianrichard
     */
    public static LocalDate convertStringToLocalDate(String dateString) {
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            return LocalDate.parse(dateString, formatter);
        } catch (DateTimeParseException e) {
            System.err.println("Erreur de parsing: " + e.getMessage());
            return null;
        }
    }
    
    /**
     * Recupere les sessions de toutes les epreuves de toutes les disciplines
     * 
     * @author kylianrichard
     */
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
	
	/**
     * Recupere les sessions de toutes les epreuves de toutes les disciplines
     * 
     * @author kylianrichard
     */
	public ArrayList<Epreuve> getEpreuveDiscipline(String nom){
		for(Discipline discipline : application.disciplinesList) {
			if(discipline.getNom().equalsIgnoreCase(nom)) {
				return discipline.getEpreuves();
			}
		}
		return new ArrayList<Epreuve>(); 
	}
	
	/**
     * Vérifie et corrige le format de l'heure.
     * 
     * @param heure L'heure à vérifier et corriger
     * @return L'heure corrigée si le format est valide, sinon null
     * 
     * @author kylianrichard
     */
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
	
	/**
     * Ajoute une nouvelle session.
     * 
     * @param date La date de la session
     * @param heure L'heure de la session
     * @param duree La durée de la session
     * @param lieu Le lieu de la session
     * @param sexe Le sexe de la session
     * @param discipline La discipline de la session
     * @param epreuve L'épreuve de la session
     * @param athleteParticipants Les athlètes participants à la session
     * @return true si la session a été ajoutée avec succès, false sinon
     * 
     * @author kylianrichard
     */
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
	
	/**
     * Obtient une épreuve spécifique en fonction de son nom et de sa discipline.
     * 
     * @param epreuveNom Le nom de l'épreuve
     * @param discipline La discipline de l'épreuve
     * @return L'épreuve correspondante s'il existe, sinon null
     * 
     * @author kylianrichard
     */
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
	
	/**
     * Enregistre les données de l'application.
     */
	public void enregister() {
		application.enregister();
	}
	
	/**
     * Recupere les sessions de toutes les epreuves de toutes les disciplines en fonction d'une date
     * 
     * @param date la date pour laquelle il faut recuperer les epreuves
     * 
     * @author mathieu_GUIBORAT--BOST
     */
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