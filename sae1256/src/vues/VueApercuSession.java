package vues;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controleurs.ControleurSession;
import modeles.*;

public class VueApercuSession extends JPanel {
	
	ApplicationJo application;
	
	Dimension dimension;
	
	ControleurSession controleur;

	public VueApercuSession(ControleurSession controleur, Dimension dimension){
		this.controleur = controleur;
		this.dimension = dimension;
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setPreferredSize(dimension);
	    this.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
	    this.setBackground(Color.white);
	    
	    ArrayList <Session> toutSessionOrdonnee = controleur.getToutesSessionOrdonnées();

		
		// Header
        JPanel header = new JPanel(new BorderLayout());
        header.setMaximumSize(new Dimension((int) dimension.getWidth(), 50));
        header.setBackground(Color.WHITE);
        
        // Définir le titre
        JLabel titre = new JLabel("Planning");
        titre.setFont(new Font(titre.getFont().getName(), titre.getFont().getStyle(), 32));
        titre.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
        header.add(titre, BorderLayout.WEST);
        
        
        // Panel pour afficher la session en cours
        JPanel sessionEnCoursPanel = new JPanel(new BorderLayout()); 
        sessionEnCoursPanel.setBackground(Color.WHITE);
        sessionEnCoursPanel.setMaximumSize(new Dimension((int)dimension.getWidth(), 170));
        
        JLabel sessionEnCoursTitre = new JLabel("Session en cours");
        
        Session sessionEnCours = toutSessionOrdonnee.get(0);
        
        sessionEnCoursTitre.setBackground(Color.WHITE);
        sessionEnCoursTitre.setFont(new Font(titre.getFont().getName(), titre.getFont().getStyle(), 24));
        sessionEnCoursTitre.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
        sessionEnCoursPanel.add(sessionEnCoursTitre, BorderLayout.WEST);
        
        JPanel sessionEnCoursCard = new JPanel(new BorderLayout());
        sessionEnCoursCard.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        sessionEnCoursCard.setBackground(Couleur.ROUGE_JO.getColor());
        sessionEnCoursCard.setPreferredSize(new Dimension((int)dimension.getWidth(), 120));
        
        JPanel infoNiveau1 = new JPanel(new BorderLayout());
        infoNiveau1.setBackground(Couleur.ROUGE_JO.getColor());

        JLabel sessionEnCoursDiscipline = new JLabel(sessionEnCours.getEpreuve().getDiscipline().getNom(), JLabel.CENTER);
        sessionEnCoursDiscipline.setFont(new Font(titre.getFont().getName(), titre.getFont().getStyle(), 18));
        JLabel sessionEnCoursEpreuve = new JLabel(toutSessionOrdonnee.get(0).getEpreuve().getNom(), JLabel.CENTER);
        sessionEnCoursEpreuve.setFont(new Font(titre.getFont().getName(), titre.getFont().getStyle(), 18));
        infoNiveau1.add(sessionEnCoursDiscipline, BorderLayout.NORTH);
        infoNiveau1.add(sessionEnCoursEpreuve, BorderLayout.SOUTH);
        
        JPanel infoNiveau2 = new JPanel(new BorderLayout());
        infoNiveau2.setBorder(BorderFactory.createEmptyBorder(0, 125, 0, 125));
        infoNiveau2.setBackground(Couleur.ROUGE_JO.getColor());

        String heureDebut = sessionEnCours.getHeureDebut(); 
        int duree = sessionEnCours.getDuree(); 
        JLabel sessionEnCoursHoraire = new JLabel(heureDebut +" - "+ sessionEnCours.calculerHeureFin());
        sessionEnCoursHoraire.setFont(new Font(titre.getFont().getName(), titre.getFont().getStyle(), 18));
        JLabel sessionEnCoursLieu = new JLabel(sessionEnCours.getLieu());
        sessionEnCoursLieu.setFont(new Font(titre.getFont().getName(), titre.getFont().getStyle(), 18));
        infoNiveau2.add(sessionEnCoursHoraire, BorderLayout.WEST);
        infoNiveau2.add(sessionEnCoursLieu, BorderLayout.EAST);
        
        sessionEnCoursCard.add(infoNiveau1, BorderLayout.NORTH);
        sessionEnCoursCard.add(infoNiveau2, BorderLayout.SOUTH);
        sessionEnCoursPanel.add(sessionEnCoursCard, BorderLayout.SOUTH);
        
        JPanel sessionAVenirPanel = new JPanel(new BorderLayout()); 
        sessionAVenirPanel.setBackground(Color.WHITE);
        sessionAVenirPanel.setMaximumSize(new Dimension((int)dimension.getWidth(), 210));
        
        JPanel cardAVenirConteneur = new JPanel(new GridLayout(1,3, 20, 20));
        cardAVenirConteneur.setBackground(Color.WHITE);
        
        
        JLabel sessionAVenirTitre = new JLabel("Sessions à venir");
        sessionAVenirTitre.setBackground(Color.WHITE);
        sessionAVenirTitre.setFont(new Font(titre.getFont().getName(), titre.getFont().getStyle(), 24));
        sessionAVenirTitre.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        sessionAVenirPanel.add(sessionAVenirTitre, BorderLayout.WEST);
        
        //Ajout de 3 cartes pour les sessions à venir 
        Color[] colors = {Couleur.BLEU_JO.getColor(), Couleur.JAUNE_JO.getColor(), Couleur.VERT_JO.getColor()};
        for (int i = 0; i<3; i++) {
        	JPanel sessionAVenirCard = new JPanel(new BorderLayout());
        	sessionAVenirCard.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        	sessionAVenirCard.setBackground(colors[i%3]);
        	sessionAVenirCard.setPreferredSize(new Dimension(170, 140));
            
            JPanel infoNiveau1AVenir = new JPanel(new BorderLayout());
            infoNiveau1AVenir.setBackground(colors[i%3]);

            JLabel sessionAVenirDiscipline = new JLabel("Athlétisme", JLabel.CENTER);
            sessionAVenirDiscipline.setFont(new Font(titre.getFont().getName(), titre.getFont().getStyle(), 18));
            JLabel sessionAVenirEpreuve = new JLabel("Lancer de Poids", JLabel.CENTER);
            sessionAVenirEpreuve.setFont(new Font(titre.getFont().getName(), titre.getFont().getStyle(), 18));
            infoNiveau1AVenir.add(sessionAVenirDiscipline, BorderLayout.NORTH);
            infoNiveau1AVenir.add(sessionAVenirEpreuve, BorderLayout.SOUTH);
            
            JPanel infoNiveau2AVenir = new JPanel(new BorderLayout());
            infoNiveau2AVenir.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
            infoNiveau2AVenir.setBackground(colors[i%3]);

            JLabel sessionAVenirHoraire = new JLabel("9h00 - 11h30", JLabel.CENTER);
            sessionAVenirHoraire.setFont(new Font(titre.getFont().getName(), titre.getFont().getStyle(), 18));
            JLabel sessionAVenirLieu = new JLabel("Stade de Gaulle", JLabel.CENTER);
            sessionAVenirLieu.setFont(new Font(titre.getFont().getName(), titre.getFont().getStyle(), 18));
            infoNiveau2AVenir.add(sessionAVenirHoraire, BorderLayout.NORTH);
            infoNiveau2AVenir.add(sessionAVenirLieu, BorderLayout.SOUTH);
            
            sessionAVenirCard.add(infoNiveau1AVenir, BorderLayout.NORTH);
            sessionAVenirCard.add(infoNiveau2AVenir, BorderLayout.SOUTH);
            cardAVenirConteneur.add(sessionAVenirCard, BorderLayout.SOUTH);
        }
        sessionAVenirPanel.add(cardAVenirConteneur, BorderLayout.SOUTH);
        
        JPanel buttonPanel = new JPanel(new BorderLayout()); 
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.setMaximumSize(new Dimension((int)dimension.getWidth(), 210));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        JButton VoirToutButton = new JButton("Voir le planning complet");
        buttonPanel.add(VoirToutButton, BorderLayout.EAST);
        
        add(header);
        add(sessionEnCoursPanel);
        add(sessionAVenirPanel);
        add(buttonPanel);

	}
}
