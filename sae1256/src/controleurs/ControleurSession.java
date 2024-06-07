package controleurs;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;

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
 * @author VotreNom
 */
public class ControleurSession implements Controleur {

    JPanel lastPanel;
    public ApplicationJo application;

    /**
     * Constructeur du controleur de session.
     * 
     * @param application L'application principale
     * @author VotreNom
     */
    public ControleurSession(ApplicationJo application) {
        this.application = application;
    }

    /**
     * Retourne au panneau précédent.
     */
    public void retour() {

        if (lastPanel instanceof VuePlanning) {
            application.mainPanel.removeAll();
            application.mainPanel.add(lastPanel);
            application.mainPanel.revalidate();
            application.mainPanel.repaint();
        }
    }

    /**
     * Définit le dernier panneau utilisé.
     * 
     * @param panel Le panneau à définir comme dernier panneau
     */
    public void setLastPanel(JPanel panel) {
        this.lastPanel = panel;
    }

    /**
     * Convertit une chaîne de caractères en objet LocalDate.
     * 
     * @param dateString La chaîne de caractères représentant la date
     * @return LocalDate représentant la date
     */
    public static LocalDate convertStringToLocalDate(String dateString) {
        try {
            return LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        } catch (DateTimeParseException e) {
            System.err.println("Erreur de parsing: " + e.getMessage());
            return null;
        }
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
     */
    public boolean ajouterSession(String date, String heure, String duree, String lieu, String sexe, String discipline,
            String epreuve, ArrayList<Athlete> athleteParticipants) {

        boolean dureeValide = true;
        int dureeInt = 0;
        LocalDate dateFormatee = convertStringToLocalDate(date);

        Epreuve epreuvePourAjout = getEpreuve(epreuve, discipline);

        String heureValide = verifierEtCorrigerFormatHeure(heure);

        if (heureValide == null) {
            return false;
        }

        if (dateFormatee == null) {
            JOptionPane.showMessageDialog(null, "Format de date incorrect. Rappel : JJ/MM/AAAA", "Erreur",
                    JOptionPane.WARNING_MESSAGE);
        }

        //Verifie que la duree est bien un entier
        try {
            dureeInt = Integer.parseInt(duree);
        } catch (NumberFormatException error) {
            JOptionPane.showMessageDialog(null, "La durée doit être entière", "Erreur", JOptionPane.WARNING_MESSAGE);
            dureeValide = false;
        }

        if (dureeValide && epreuvePourAjout != null && dateFormatee != null) {
            Session newSession = new Session(dateFormatee, heureValide, dureeInt, lieu, sexe, athleteParticipants);
            newSession.setEpreuve(epreuvePourAjout);
            epreuvePourAjout.ajouterSession(newSession);
            this.enregister();
            return true;
        }
        return false;
    }

    /**
     * Vérifie et corrige le format de l'heure si il peut etre corrigé.
     * 
     * @param heure L'heure à vérifier et corriger
     * @return L'heure corrigée si le format est valide, sinon null
     */
    public String verifierEtCorrigerFormatHeure(String heure) {
        Pattern pattern = Pattern.compile("^(\\d{2}):[0-5][0-9]$");

        if (pattern.matcher(heure).matches()) {
            return heure;
        } else {
            if (heure.matches("^\\d:[0-5][0-9]$")) {
                heure = "0" + heure;
                return heure;
            } else {
                JOptionPane.showMessageDialog(null, "Format d'heure incorrect. Rappel : HH:mm'", "Erreur",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
        return null;
    }

    /**
     * Enregistre les données de l'application.
     */
    public void enregister() {
        application.enregister();
    }

    /**
     * Obtient une épreuve spécifique en fonction de son nom et de sa discipline.
     * 
     * @param epreuveNom Le nom de l'épreuve
     * @param discipline La discipline de l'épreuve
     * @return L'épreuve correspondante s'il existe, sinon null
     */
    public Epreuve getEpreuve(String epreuveNom, String discipline) {
        int disciplineIndex = getDisciplineIndex(discipline);

        for (Epreuve epreuve : application.disciplinesList.get(disciplineIndex).getEpreuves()) {
            if (epreuve.getNom().equalsIgnoreCase(epreuveNom)) {
                return epreuve;
            }
        }

        return null;
    }

    /**
     * Obtient l'indice d'une discipline dans la liste des disciplines.
     * 
     * @param nom Le nom de la discipline à rechercher
     * @return L'indice de la discipline dans la liste, ou -1 si non trouvé
     */
    public int getDisciplineIndex(String nom) {
        int index = -1;
        for (int i = 0; i < application.disciplinesList.size(); i++) {
            if (application.disciplinesList.get(i).getNom().equalsIgnoreCase(nom)) {
                index = i;
                return index;
            }
        }
        return -1;
    }

}
