package vues;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.time.LocalDate;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controleurs.ControleurEquipe;
import controleurs.ControleurSession;
import modeles.*;
/**
 * VueApercuSession affiche un aperçus des sessions.
 * 
 * @author kylianrichard
 */
public class VueApercuSession extends JPanel {
	
	Dimension dimension;
	
	ControleurSession controleur;
	/**
	 * Contructeur de la classe VueApercuSession
	 * 
	 * @param controleur Le controleur qui permet de gerer les sessions.
	 * @param dimension Les dimensions de la vue.
	 */
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
        //Création de la carte session en cours
        if(toutSessionOrdonnee.size() >=1) {
        	Session sessionEnCours = toutSessionOrdonnee.get(0);
            
            sessionEnCoursTitre.setBackground(Color.WHITE);
            sessionEnCoursTitre.setFont(new Font(titre.getFont().getName(), titre.getFont().getStyle(), 24));
            sessionEnCoursTitre.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
            sessionEnCoursPanel.add(sessionEnCoursTitre, BorderLayout.WEST);
            
            JPanel sessionEnCoursCard = new JPanel(new BorderLayout());
            sessionEnCoursCard.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
            sessionEnCoursCard.setBackground(Couleur.ROUGE_JO.getColor());
            sessionEnCoursCard.setPreferredSize(new Dimension((int)dimension.getWidth(), 120));
            
            sessionEnCoursCard.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                	controleur.application.mainPanel.removeAll();
                	controleur.setLastPanel(VueApercuSession.this);
                	controleur.application.mainPanel.add(new VueDescriptifSession(controleur,sessionEnCours));                    // Rafraîchir le conteneur
                	controleur.application.mainPanel.revalidate();
                	controleur.application.mainPanel.repaint();
                }
            });
            
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
        }
        
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
        for (int i = 1; i<4 && i < toutSessionOrdonnee.size(); i++) {
        	Session sessionCourante = toutSessionOrdonnee.get(i);
        	
        	JPanel sessionAVenirCard = new JPanel(new BorderLayout());
        	sessionAVenirCard.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        	sessionAVenirCard.setBackground(colors[i%3]);
        	sessionAVenirCard.setPreferredSize(new Dimension(170, 140));
            
            JPanel infoNiveau1AVenir = new JPanel(new BorderLayout());
            infoNiveau1AVenir.setBackground(colors[i%3]);

            JLabel sessionAVenirDiscipline = new JLabel(sessionCourante.getEpreuve().getDiscipline().getNom(), JLabel.CENTER);
            sessionAVenirDiscipline.setFont(new Font(titre.getFont().getName(), titre.getFont().getStyle(), 18));
            JLabel sessionAVenirEpreuve = new JLabel(sessionCourante.getEpreuve().getNom(), JLabel.CENTER);
            sessionAVenirEpreuve.setFont(new Font(titre.getFont().getName(), titre.getFont().getStyle(), 18));
            infoNiveau1AVenir.add(sessionAVenirDiscipline, BorderLayout.NORTH);
            infoNiveau1AVenir.add(sessionAVenirEpreuve, BorderLayout.SOUTH);
            
            JPanel infoNiveau2AVenir = new JPanel(new BorderLayout());
            infoNiveau2AVenir.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
            infoNiveau2AVenir.setBackground(colors[i%3]);

            String heureDebutCourante = sessionCourante.getHeureDebut(); 
            int dureeCourante = sessionCourante.getDuree(); 
            JLabel sessionAVenirHoraire = new JLabel(heureDebutCourante +" - "+ sessionCourante.calculerHeureFin(), JLabel.CENTER);
            sessionAVenirHoraire.setFont(new Font(titre.getFont().getName(), titre.getFont().getStyle(), 18));
            JLabel sessionAVenirLieu = new JLabel(sessionCourante.getLieu(), JLabel.CENTER);
            sessionAVenirLieu.setFont(new Font(titre.getFont().getName(), titre.getFont().getStyle(), 18));
            infoNiveau2AVenir.add(sessionAVenirHoraire, BorderLayout.NORTH);
            infoNiveau2AVenir.add(sessionAVenirLieu, BorderLayout.SOUTH);
            
            sessionAVenirCard.add(infoNiveau1AVenir, BorderLayout.NORTH);
            sessionAVenirCard.add(infoNiveau2AVenir, BorderLayout.SOUTH);
            cardAVenirConteneur.add(sessionAVenirCard, BorderLayout.SOUTH);
            
            sessionAVenirCard.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                	controleur.application.mainPanel.removeAll();
                	controleur.setLastPanel(VueApercuSession.this);
                	controleur.application.mainPanel.add(new VueDescriptifSession(controleur,sessionCourante));
                    // Rafraîchir le conteneur
                	controleur.application.mainPanel.revalidate();
                	controleur.application.mainPanel.repaint();
                }
            });
            
        }
        sessionAVenirPanel.add(cardAVenirConteneur, BorderLayout.SOUTH);
        
        JPanel buttonPanel = new JPanel(new BorderLayout()); 
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.setMaximumSize(new Dimension((int)dimension.getWidth(), 210));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        JButton voirToutButton = new JButton("Voir le planning complet");
        voirToutButton.setBackground(Couleur.ROUGE_JO.getColor());
        voirToutButton.setForeground(Color.WHITE);
        
        voirToutButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controleur.application.mainPanel.removeAll();
				// Créer une instance de la class LocalDate et l'initialiser au 24 juillet (début des JO)
				LocalDate date = LocalDate.of(2024, 7, 24);
				controleur.application.mainPanel.add(new VuePlanning(controleur, date));
                // Rafraîchir le conteneur
				controleur.application.mainPanel.revalidate();
				controleur.application.mainPanel.repaint();
			}
        	
        });
        
        buttonPanel.add(voirToutButton, BorderLayout.EAST);
        
        add(header);
        add(sessionEnCoursPanel);
        add(sessionAVenirPanel);
        add(buttonPanel);

	}
}
