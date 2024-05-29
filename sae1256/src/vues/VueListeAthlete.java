package vues;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import composants.EmplacementMedaille;
import modeles.ApplicationJo;
import modeles.Athlete;
import modeles.Pays;
import utilitaires.Couleur;

public class VueListeAthlete extends JPanel {
	
	//Permet d'accéder aux données de l'application qui seront affichées. 
	ApplicationJo application;
	
	//Panel servant à contenir les pays
	JPanel panelAthlete;
		
	public VueListeAthlete(ApplicationJo application, Dimension dimension) {
			
	    this.application = application;
	    
	    setLayout(new BorderLayout()); 
	    this.setPreferredSize(dimension);
	
	    this.panelAthlete = new JPanel();
	    panelAthlete.setLayout(new BoxLayout(panelAthlete, BoxLayout.Y_AXIS));
	    panelAthlete.setBackground(Color.WHITE);
	    panelAthlete.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
	    panelAthlete.setPreferredSize(dimension);
	
	    
	    //Définir le titre
	    JLabel titre = new JLabel("Athlètes");
	    titre.setFont(new Font(titre.getFont().getName(), titre.getFont().getStyle(), 32));
	    titre.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
	    panelAthlete.add(titre);
	    
	    //Ajout de chacun des pays au panel 
	    for(Athlete athlete : application.athletesList) { 
	
	        //Création d'un panel servant à recueillir les infos du pays
	        JPanel panelSimplePays = new JPanel();
	        panelSimplePays.setLayout(new BorderLayout()); // Utilisation de BoxLayout horizontal
	        panelSimplePays.setBackground(Couleur.COULEUR_FOND_JO.getColor());
	        panelSimplePays.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	        panelSimplePays.setMaximumSize(new Dimension((int) dimension.getWidth(), 50));
	
	        //Ajout des infos de l'athlete
	        JLabel nomPays = new JLabel(athlete.getNom() + ' ' + athlete.getPrenom());
	        panelSimplePays.add(nomPays, BorderLayout.WEST);
	        
	        // Création du panneau coteGauche
	        JPanel coteGauche = new JPanel();
	        coteGauche.setBackground(Couleur.COULEUR_FOND_JO.getColor()); // Exemple de couleur
	        panelSimplePays.add(coteGauche, BorderLayout.EAST);
	
	        // Utilisation de BoxLayout pour centrer le contenu verticalement
	        coteGauche.setLayout(new BoxLayout(coteGauche, BoxLayout.X_AXIS));
	
	        // Ajout des recompenses 
	        EmplacementMedaille medaille = new EmplacementMedaille();
	        medaille.setValeur(0, athlete.getOr());
	        medaille.setValeur(1, athlete.getArgent());
	        medaille.setValeur(2, athlete.getBronze());
	
	        coteGauche.add(Box.createVerticalGlue());
	        medaille.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrer horizontalement
	        coteGauche.add(medaille);
	        coteGauche.add(Box.createVerticalStrut(10));
	
	        //Création d'un bouton avec une image
	        ImageIcon icon = new ImageIcon("img/modification.png");
	        Image img = icon.getImage();
	        Image newImg = img.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
	        icon = new ImageIcon(newImg);
	        JButton btnModification = new JButton(icon);
	        btnModification.setPreferredSize(new Dimension(25, 25));
	        btnModification.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
	        coteGauche.add(btnModification);
	        
	        panelAthlete.add(panelSimplePays);
	        panelAthlete.add(Box.createVerticalStrut(10));
	    }
	    
	    add(panelAthlete, BorderLayout.CENTER);
	
	    setBackground(Color.WHITE);
	}
	
	public void masquer() {
		this.setVisible(false);
    }
	
	public void afficher() {
		this.setVisible(true);
    }
}
