package vues;

import javax.swing.*; 
import java.awt.*;
import javax.swing.border.EmptyBorder;

import modeles.Athlete;
import modeles.Session;

/**
 * La classe VueDescriptifSession représente la vue descriptive d'une session.
 * Elle affiche les détails de la session ainsi que les participants.
 * 
 * @author estebanrodrigues
 */
public class VueDescriptifSession extends JPanel {
    protected JPanel PanelAnnonceEvenement, PanelDetailEvenement, DateHeurePanel, PanelInfo, panelDesParticipants,
    PanelRemplissage1, PanelRetour;
    protected JLabel nomDiscipline, TypeSerie, DateSession, HeureSession, InformationSession, GenreSession,
    LieuSession, Participant;
    protected JButton BoutonRetour;
    
    Session session;

    /**
     * Constructeur de la classe VueDescriptifSession.
     * Initialise les composants de la vue descriptive d'une session.
     * 
     * @param session la session à décrire
     */
    public VueDescriptifSession(Session session) {
        
        this.session = session;
        
        // Création des Panel de haut niveau
        JPanel PanelAnnonceEvenement = new JPanel(new BorderLayout());
        JPanel PanelSession = new JPanel(new GridLayout(2, 2));

        // Création des Panel de haut niveau moyen
        JPanel PanelDetailEvenement = new JPanel(new GridLayout(2, 1));
        JPanel DateHeurePanel = new JPanel(new GridLayout(2, 1));
        JPanel panelDesParticipants = new JPanel(new GridLayout(5, 1));
        
        // Création des Panel de bas niveau
        JPanel PanelInfo = new JPanel(new GridLayout(5, 1));
        JPanel PanelRemplissage1 = new JPanel();
        JPanel PanelRetour = new JPanel(new BorderLayout());

        // Création des Label pour PanelAnnonceEvenement
        JLabel nomDiscipline = new JLabel(session.getEpreuve().getDiscipline().getNom(), SwingConstants.LEFT);
        nomDiscipline.setFont(new Font(nomDiscipline.getFont().getName(), Font.BOLD, 32));
        JLabel TypeSerie = new JLabel(session.getEpreuve().getNom(), SwingConstants.LEFT);
        TypeSerie.setFont(new Font("Arial", Font.ITALIC, 20));
        JLabel DateSession = new JLabel(session.getDate().toString(), SwingConstants.CENTER);
        DateSession.setFont(new Font("Arial", Font.PLAIN, 24));
        JLabel HeureSession = new JLabel(session.getHeureDebut() + " - " + session.calculerHeureFin(), SwingConstants.CENTER);
        HeureSession.setFont(new Font("Arial", Font.BOLD, 24));

        // Ajout dans les Panel de niveau moyen
        PanelDetailEvenement.add(nomDiscipline);
        PanelDetailEvenement.add(TypeSerie);
        PanelAnnonceEvenement.add(PanelDetailEvenement, BorderLayout.WEST);
        PanelDetailEvenement.setBorder(BorderFactory.createEmptyBorder(20, 40, 0, 0));
        
        DateHeurePanel.add(DateSession);
        DateHeurePanel.add(HeureSession);
        PanelAnnonceEvenement.add(DateHeurePanel, BorderLayout.EAST);
        DateHeurePanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 40));

        // Création des Label pour les informations sur la session
        JLabel InformationSession = new JLabel("Information : ", SwingConstants.LEFT);
        InformationSession.setFont(new Font("Arial", Font.BOLD, 14));
        JLabel GenreSession = new JLabel("Sexe : " + session.getSexe(), SwingConstants.LEFT);
        GenreSession.setFont(new Font("Arial", Font.PLAIN, 14));
        JLabel LieuSession = new JLabel("Lieu : " + session.getLieu(), SwingConstants.LEFT);
        LieuSession.setFont(new Font("Arial", Font.PLAIN, 14));

        // Ajout dans les Panel de bas niveau
        PanelInfo.add(InformationSession);
        PanelInfo.add(GenreSession);
        PanelInfo.add(LieuSession);
        PanelInfo.setBorder(BorderFactory.createEmptyBorder(60, 40, 0, 0));

        // Création des Label pour les athlètes de la session
        JLabel titreParticipants = new JLabel("Participants : ", SwingConstants.LEFT);
        titreParticipants.setFont(new Font("Arial", Font.BOLD, 14));
        panelDesParticipants.add(titreParticipants);
        panelDesParticipants.setBorder(BorderFactory.createEmptyBorder(60, 40, 0, 0));
        
        for (Athlete athlete : session.getParticipants()) {
            JLabel participant = new JLabel(" - " + athlete.getNom() + " " + athlete.getPrenom(), SwingConstants.LEFT);
            participant.setFont(new Font("Arial", Font.PLAIN, 14));
            participant.add(Box.createVerticalStrut(100));
            panelDesParticipants.add(participant);
        }

        // Création du bouton pour le retour
        JButton BoutonRetour = new JButton("Retour");
        BoutonRetour.setFont(new Font("Arial", Font.PLAIN, 14));
        BoutonRetour.setForeground(Color.WHITE);
        BoutonRetour.setBackground(Color.GRAY);
        PanelRetour.add(BoutonRetour, BorderLayout.SOUTH);
        PanelRetour.setBorder(BorderFactory.createEmptyBorder(0, 0, 45, 0));
        
        // Ajout dans le Panel de session
        PanelSession.add(PanelInfo);
        PanelSession.add(panelDesParticipants); 
        PanelSession.add(PanelRemplissage1);
        PanelSession.add(PanelRetour);

        // Changement des couleur de tous les background
        PanelAnnonceEvenement.setBackground(Color.WHITE);
        PanelDetailEvenement.setBackground(Color.WHITE);        
        DateHeurePanel.setBackground(Color.WHITE);
        PanelInfo.setBackground(Color.WHITE);
        panelDesParticipants.setBackground(Color.WHITE);
        PanelRemplissage1.setBackground(Color.WHITE);
        PanelRetour.setBackground(Color.WHITE);
        
        this.setBackground(Color.WHITE); 
        this.setLayout(new BorderLayout());
        this.add(PanelAnnonceEvenement, BorderLayout.NORTH);
        this.add(PanelSession, BorderLayout.CENTER); 
        
    }
}
