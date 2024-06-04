package vues;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import modeles.*;

public class VueAthlete extends JPanel {
	
	Athlete athlete;
	
	VueAthlete(Athlete athlete){
		this.athlete = athlete;
		
		setLayout(new BorderLayout());
		
		//Header
        JPanel header = new JPanel(new BorderLayout());
        header.setMaximumSize(new Dimension(700, 100));
        header.setPreferredSize(new Dimension(700, 100));
        header.setBackground(Color.WHITE);
        
		//Définir le titre
	    JLabel titre = new JLabel(athlete.getPrenom() + " " + athlete.getNom());
	    titre.setFont(new Font(titre.getFont().getName(), titre.getFont().getStyle(), 32));
	    titre.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 0));
	    header.add(titre, BorderLayout.WEST);
	    
	    //Bouton ajouter
	    JPanel panelBouton = new JPanel();
	    panelBouton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(10, 10, 10, 10), 
                BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK) // Bordure de couleur de 2 pixels en bas
        ));
	    panelBouton.setBackground(Color.WHITE);
        
        JButton button = new JButton("Editer");
        button.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        button.setFocusPainted(false);
        
        panelBouton.add(button);
	    header.add(panelBouton, BorderLayout.EAST);
	    
	    add(header, BorderLayout.NORTH);
	    
	    JPanel biographie = new JPanel(new BorderLayout());
	    biographie.setBackground(Color.WHITE);

	    
	    ImageIcon icon = new ImageIcon("img/no-picture.png");
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(250, 200, Image.SCALE_SMOOTH);
        icon = new ImageIcon(newImg);
        
        JLabel profileImage = new JLabel(icon);
        profileImage.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        biographie.add(profileImage, BorderLayout.WEST);
        
        JPanel informations = new JPanel();
        informations.setBackground(Color.WHITE);
        informations.setLayout(new BoxLayout(informations, BoxLayout.Y_AXIS));
        
        // Title section
        JPanel titlePanel = new JPanel(new GridLayout(2, 1));
        titlePanel.setBackground(Color.WHITE);
        JLabel delegation = new JLabel(athlete.getPays().getCode(), JLabel.LEFT);
        delegation.setFont(new Font(titre.getFont().getName(), titre.getFont().getStyle(), 28));
        JLabel discipline = new JLabel(athlete.getDiscipline().getNom(), JLabel.LEFT);
        discipline.setFont(new Font(titre.getFont().getName(), titre.getFont().getStyle(), 22));
        titlePanel.add(delegation);
        titlePanel.add(discipline);
        
        // Description section
        JTextArea description = new JTextArea(athlete.getDescription());
        description.setFont(new Font(titre.getFont().getName(), titre.getFont().getStyle(), 14));
        
        description.setLineWrap(true);
        description.setWrapStyleWord(true);
        description.setEditable(false);
        description.setOpaque(false);
        
        // Medals section
        JPanel medalsPanel = new JPanel(new GridLayout(2, 1));
        JLabel medalsTitle = new JLabel("Ses médailles", JLabel.CENTER);
        medalsTitle.setFont(new Font("SansSerif", Font.PLAIN, 24));
        
        JPanel medaillesPanel = new JPanel(new BorderLayout());
        medaillesPanel.setBackground(Color.WHITE);
        medaillesPanel.setMaximumSize(new Dimension(500, 50));
        JLabel medaillesLabel = new JLabel("Ses Médailles :");
        
        medaillesLabel.setFont(new Font(titre.getFont().getName(), titre.getFont().getStyle(), 16));
        medaillesPanel.add(medaillesLabel, BorderLayout.WEST);
        
        EmplacementMedaille medailles = new EmplacementMedaille();
        //Application des valeurs aux emplacements
        medailles.setValeur(0, athlete.getOr());
        medailles.setValeur(1, athlete.getArgent());
        medailles.setValeur(2, athlete.getBronze());
        medailles.setBackground(Color.WHITE);
        medaillesPanel.add(medailles, BorderLayout.EAST);

        
        
        // Add sections to main panel
        informations.add(titlePanel, BorderLayout.NORTH);
        informations.add(description, BorderLayout.CENTER);
        informations.add(medaillesPanel, BorderLayout.SOUTH);
        biographie.add(informations, BorderLayout.CENTER);

        add(biographie);
        
        JPanel informationsComplementairesPanel = new JPanel(new GridLayout(1, 2));
        informationsComplementairesPanel.setBackground(Color.WHITE);
        informationsComplementairesPanel.setPreferredSize(new Dimension(700, 150));
        
        JPanel informationsComplementaires = new JPanel();
        informationsComplementaires.setBackground(Color.WHITE);
        informationsComplementaires.setLayout(new BoxLayout(informationsComplementaires, BoxLayout.Y_AXIS));
        informationsComplementaires.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 10));

        JLabel naissance = new JLabel("Date de naissance : " + athlete.getAnneeNaissance(), JLabel.LEFT);
        naissance.setFont(new Font(titre.getFont().getName(), titre.getFont().getStyle(), 16));
        JLabel genre = new JLabel("Genre : " + athlete.getGenre(), JLabel.LEFT);
        genre.setFont(new Font(titre.getFont().getName(), titre.getFont().getStyle(), 16));
        JLabel poids = new JLabel("Poids : " + athlete.getPoids() + " kg", JLabel.LEFT);
        poids.setFont(new Font(titre.getFont().getName(), titre.getFont().getStyle(), 16));
        JLabel taille = new JLabel("Taille : " + athlete.getTaille() + " cm", JLabel.LEFT);
        taille.setFont(new Font(titre.getFont().getName(), titre.getFont().getStyle(), 16));
        informationsComplementaires.add(naissance);
        informationsComplementaires.add(genre);
        informationsComplementaires.add(poids);
        informationsComplementaires.add(taille);
        
        informationsComplementairesPanel.add(informationsComplementaires);
        
        add(informationsComplementairesPanel, BorderLayout.SOUTH);
		
	}
	
	public static void main (String[] args) {
		System.out.println("Hello SAE 1256 !");
		
		JFrame fenetre = new JFrame ();
		fenetre.setSize(960,540);
		fenetre.setLocationRelativeTo(null); 
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.getContentPane().setBackground(Color.WHITE); // Définir le fond blanc
		
		//Création de l'instance de l'application
		ApplicationJo applicationJo = new ApplicationJo();
		//Récupération des données sérializées
		applicationJo.recuperer();
		
		//Panel qui va accueillir les vues
		JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setLayout(new BorderLayout());
        
        VueAthlete athelte = new VueAthlete(applicationJo.athletesList.get(1));
        mainPanel.add(athelte);
		
		// Menu de navigation
        JPanel menu = new JPanel();
        menu.setPreferredSize(new Dimension(270, fenetre.getHeight())); 
		
        
        // Organiser les panneaux
        fenetre.setLayout(new BorderLayout());
        fenetre.add(mainPanel, BorderLayout.CENTER);
        fenetre.add(menu, BorderLayout.WEST);
        
        // Afficher la fenetre
     	fenetre.setVisible(true);
        
		//Sauvegarde des données
		applicationJo.enregister();
	}
}