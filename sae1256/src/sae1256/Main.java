package sae1256;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controleurs.ControleurAthlete;
import modeles.*;
import vues.*; 

/**
 * Cette classe représente la base de l'application SAE 1256.
 * Elle initialise et affiche l'interface utilisateur de l'application.
 * 
 * 
 * @author kylianrichard
 */
public class Main {
	
	/**
	 * Dimension par défaut de la fenêtre principale de l'application.
	 */
	public static final Dimension DIMENSION = new Dimension(700, 540);
	
	/**
	 * Méthode principale de l'application. Elle initialise les différents composants
	 * de l'interface utilisateur et lance l'application.
	 * 
	 * @param args les arguments de la ligne de commande
	 */
	public static void main (String[] args) {
		System.out.println("Hello SAE 1256 !");
		
		// Création de la fenêtre principale
		JFrame fenetre = new JFrame ();
		fenetre.setSize(960,540);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.getContentPane().setBackground(Color.WHITE); // Définir le fond blanc
		
		// Création de l'instance de l'application
		ApplicationJo applicationJo = new ApplicationJo();
		// Récupération des données sérializées
		applicationJo.recuperer();
		
		// Panel qui va accueillir les vues
		JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setLayout(new BorderLayout());
        applicationJo.setMainPanel(mainPanel);
        
        // Accueil 
        VueAccueil accueil = new VueAccueil(mainPanel, applicationJo);
        mainPanel.add(accueil);
              	
		// Menu de navigation
        MenuApplication menu = new MenuApplication(applicationJo,mainPanel,accueil);
        menu.setPreferredSize(new Dimension(270, fenetre.getHeight())); 
	        
        // Organiser les panneaux
        fenetre.setLayout(new BorderLayout());
        fenetre.add(mainPanel, BorderLayout.CENTER);
        fenetre.add(menu, BorderLayout.WEST);
        
        // Afficher la fenêtre
     	fenetre.setVisible(true);
     	
		// Sauvegarde des données
		applicationJo.enregister();
	}
}
