package modeles;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

/**
 * Classe Session programmee par kylianrichard.
 * 
 * Cette classe represente une session d'epreuve sportive avec des participants, un lieu, une date, une heure, une duree et un sexe specifique.
 * 
 * @author kylianrichard
 */
public class Session implements Serializable, Comparable<Session> {

    private static final long serialVersionUID = 1L;

    private ArrayList<Athlete> participants;
    private String lieu;
    private Epreuve epreuve;
    private LocalDate date;
    private String heure;
    private int duree;
    private String sexe;

    /**
     * Constructeur de la classe Session.
     *
     * @param date La date de la session.
     * @param heure L'heure de la session.
     * @param duree La duree de la session en minutes.
     * @param lieu Le lieu de la session.
     * @param sexe Le sexe des participants (M/F).
     */
    public Session(LocalDate date, String heure, int duree, String lieu, String sexe) {
        this.date = date;
        this.heure = heure;
        this.lieu = lieu;
        this.duree = duree;
        this.sexe = sexe;

        this.epreuve = null;
        participants = new ArrayList<Athlete>();
    }

    /**
     * Constructeur de la classe Session avec participants.
     *
     * @param date La date de la session.
     * @param heure L'heure de la session.
     * @param duree La duree de la session en minutes.
     * @param lieu Le lieu de la session.
     * @param sexe Le sexe des participants (M/F).
     * @param participants La liste des participants a la session.
     */
    public Session(LocalDate date, String heure, int duree, String lieu, String sexe, ArrayList<Athlete> participants) {
        this.date = date;
        this.heure = heure;
        this.lieu = lieu;
        this.duree = duree;
        this.sexe = sexe;

        this.epreuve = null;
        this.participants = participants;
    }

    /**
     * Ajoute un athlete a la session.
     *
     * @param athlete L'athlete a ajouter.
     * @return true si l'athlete est ajoute avec succes.
     */
    public boolean ajouterAthlete(Athlete athlete) {
        participants.add(athlete);
        return true;
    }

    /**
     * Retire un athlete de la session.
     *
     * @param athlete L'athlete a retirer.
     */
    public void retirerAthlete(Athlete athlete) {
        // TODO - implement Session.retirerAthlete
        throw new UnsupportedOperationException();
    }

    /**
     * Affiche les details de la session.
     */
    public void afficher() {
        System.out.println("Epreuve : " + this.epreuve.getNom());
        System.out.println("Discipline : " + this.epreuve.getDiscipline().getNom());
        System.out.println("Date : " + this.date);
        System.out.println("Heure : " + this.heure);
        System.out.println("Duree : " + this.duree);
    }

    /**
     * Calcule l'heure de fin de la session.
     *
     * @return L'heure de fin au format HH:mm.
     */
    public String calculerHeureFin() {
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        try {
            // Convertir l'heure de debut en LocalTime
            LocalTime startTime = LocalTime.parse(heure, timeFormatter);

            // Calculer l'heure de fin
            LocalTime endTime = startTime.plus(Duration.ofMinutes(duree));
            return endTime.format(timeFormatter);
        } catch (DateTimeParseException | NumberFormatException e) {
            System.err.println("Erreur de parsing: " + e.getMessage() + heure);
            return null;
        }
    }

    /**
     * Detruit la session.
     *
     * @return true si la session est detruite avec succes.
     */
    public boolean detruire() {
        // TODO - implement Session.detruire
        throw new UnsupportedOperationException();
    }

    /**
     * Retourne une representation sous forme de chaine de caracteres de la session.
     *
     * @return Une chaine de caracteres representant la session.
     */
    @Override
    public String toString() {
        return epreuve.getNom() + " - " + date + " - " + heure;
    }

    /**
     * Compare cette session avec une autre session pour l'ordre.
     *
     * @param o L'autre session a comparer.
     * @return Un nombre negatif, zero, ou un nombre positif si cette session
     * est respectivement avant, egale, ou apres l'autre session.
     */
    @Override
    public int compareTo(Session o) {
        // On commence par comparer les dates
        int dateComparison = this.date.compareTo(o.date);
        // Si les dates ne sont pas egales alors on sait laquelle est la plus grande (0 = egales)
        if (dateComparison != 0) {
            return dateComparison;
        }
        // Sinon on compare aussi sur les heures
        LocalTime thisTime = LocalTime.parse(this.heure);
        LocalTime otherTime = LocalTime.parse(o.heure);
        return thisTime.compareTo(otherTime);
    }

    /**
     * Definit l'epreuve de la session.
     *
     * @param epreuve L'epreuve de la session.
     */
    public void setEpreuve(Epreuve epreuve) {
        this.epreuve = epreuve;
    }

    /**
     * Obtient l'epreuve de la session.
     *
     * @return L'epreuve de la session.
     */
    public Epreuve getEpreuve() {
        return epreuve;
    }

    /**
     * Obtient l'heure de debut de la session.
     *
     * @return L'heure de debut de la session.
     */
    public String getHeureDebut() {
        return heure;
    }

    /**
     * Obtient la duree de la session.
     *
     * @return La duree de la session en minutes.
     */
    public int getDuree() {
        return duree;
    }

    /**
     * Definit le lieu de la session.
     *
     * @param lieu Le lieu de la session.
     */
    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    /**
     * Obtient le lieu de la session.
     *
     * @return Le lieu de la session.
     */
    public String getLieu() {
        return lieu;
    }

    /**
     * Obtient la date de la session.
     *
     * @return La date de la session.
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Obtient la liste des participants a la session.
     *
     * @return La liste des participants a la session.
     */
    public ArrayList<Athlete> getParticipants() {
        return participants;
    }

    /**
     * Obtient le sexe des participants a la session.
     *
     * @return Le sexe des participants a la session (M/F).
     */
    public String getSexe() {
        return sexe;
    }
}