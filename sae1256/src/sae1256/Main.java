package sae1256;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controlleurs.ControlleurAthlete;
import modeles.*;
import vues.*; 

public class Main {
	
	public static void main (String[] args) {
		System.out.println("Hello SAE 1256 !");
		
		JFrame fenetre = new JFrame ();
		fenetre.setSize(960,540);
		//fenetre.setLocationRelativeTo(null); 
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
        applicationJo.setMainPanel(mainPanel);
        
        //Accueil 
        VueAccueil accueil = new VueAccueil();
        mainPanel.add(accueil);
        
        //VueAthlete
        ControlleurAthlete controlleurAthlete = new ControlleurAthlete(applicationJo);
      	VueListeAthlete vueAthlete = new VueListeAthlete(applicationJo, controlleurAthlete,  new Dimension(fenetre.getWidth(), fenetre.getHeight()));
      	
        //VuePays
      	VueListePays vuePays = new VueListePays(applicationJo, new Dimension(fenetre.getWidth(), fenetre.getHeight()));
		
      	//VueDiscplines 
      	VueListeDiscipline vueDiscipline = new VueListeDiscipline(applicationJo, new Dimension(fenetre.getWidth(), fenetre.getHeight()));
      	
		// Menu de navigation
        MenuApplication menu = new MenuApplication(mainPanel,accueil, vuePays, vueAthlete, vueDiscipline);
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