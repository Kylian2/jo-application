package vues;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import controleurs.ControleurEpreuve;
import vues.Couleur;
import modeles.Athlete;
import modeles.Discipline;
import modeles.Epreuve;

public class VueAjouterEpreuve extends JPanel{
    
	ControleurEpreuve controleur;
	Discipline discipline;

    VueAjouterEpreuve(ControleurEpreuve controleur, Discipline discipline) {
    	
    	this.controleur = controleur;
    	this.discipline = discipline;
    	
    	this.setLayout(new BorderLayout());
		
        // initialisation des panel globaux
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setPreferredSize(new Dimension(1000,800));
        mainPanel.setBackground(Color.WHITE);
        
        // initialisation des sous-JPanel
        JPanel info = new JPanel();
        info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS));
        info.setPreferredSize(new Dimension(400,450));
        info.setBackground(Color.WHITE);
        
        // titre
        JPanel titrePanel = new JPanel();
        titrePanel.setLayout(new GridLayout(1,1));
        JLabel titre = new JLabel ("    Ajouter une Epreuve");
        titre.setFont(new Font("Source", Font.PLAIN, 30));
        titrePanel.add(titre, SwingConstants.CENTER);
        titrePanel.setBackground(Color.WHITE);
        
        // initialisation du JLabel + JComboBox discipline
        JPanel nomPanel = new JPanel();
        nomPanel.setLayout(new GridLayout(1,2));
        JLabel nom = new JLabel("Nom de l'épreuve :     ", SwingConstants.RIGHT);
        JTextField nomTexte = new JTextField("Choisir un type d'épreuve");
        nomPanel.setBackground(Color.WHITE);
        
        nomPanel.add(nom);
        nomPanel.add(nomTexte);
        
        JPanel unitePanel = new JPanel();
        unitePanel.setLayout(new GridLayout(1,2));
        JLabel unite = new JLabel("Unite :     ", SwingConstants.RIGHT);
        JComboBox<String> uniteTexte = new JComboBox<String>();
        uniteTexte.addItem(Epreuve.GRAMME);
        uniteTexte.addItem(Epreuve.HEURE);
        uniteTexte.addItem(Epreuve.METRE);
        uniteTexte.addItem(Epreuve.MINUTES);
        uniteTexte.addItem(Epreuve.POINT);
        uniteTexte.addItem(Epreuve.SECONDE);
        unitePanel.setBackground(Color.WHITE);
        unitePanel.add(unite);
        unitePanel.add(uniteTexte);
        
        //A AJOUTE
        /*
        JPanel individuelPanel = new JPanel();
        individuelPanel.setLayout(new GridLayout(1,2));
        JLabel individuel = new JLabel("Epreuve Individuelle :     ", SwingConstants.RIGHT);
        JComboBox<String> individuelTexte = new JComboBox<String>();
        individuelTexte.addItem("Oui");
        individuelTexte.addItem("Nom");
        individuelPanel.setBackground(Color.WHITE);
        individuelPanel.add(unite);
        individuelPanel.add(uniteTexte);
        */
        
        // création de panel vide pour combler la mise en page
        JPanel vide = new JPanel();
        vide.setBackground(Color.WHITE);
        JPanel vide1 = new JPanel();
        vide1.setBackground(Color.WHITE);
        JPanel vide2 = new JPanel();
        vide2.setBackground(Color.WHITE);
        JPanel vide3 = new JPanel();
        vide3.setBackground(Color.WHITE);
        JPanel vide4 = new JPanel();
        vide4.setBackground(Color.WHITE);
        JPanel vide5 = new JPanel();
        vide5.setBackground(Color.WHITE);
        JPanel vide6 = new JPanel();
        vide6.setBackground(Color.WHITE);
        
        
        // ajout des composants a infoPanel
        info.add(titrePanel);
        info.add(Box.createHorizontalStrut(10));
        info.add(nomPanel);
        info.add(Box.createHorizontalStrut(10));  // créer un espace entre chaque panel
        info.add(unitePanel);			
        info.add(vide);
        info.add(vide1);
        info.add(vide2);
        info.add(vide3);
        info.add(vide4);
        info.add(vide5);
        info.add(vide6);
        
        // définition de panel vide pour combler la mise en page
        JPanel defaut = new JPanel();
        defaut.setBackground(Color.WHITE);
        JPanel defaut1 = new JPanel();
        defaut1.setBackground(Color.WHITE);
        JPanel defaut2 = new JPanel();
        defaut2.setBackground(Color.WHITE);
        
        
        // initialisation des boutons valider et annuler
        JPanel boutons = new JPanel();
        boutons.setBackground(Color.WHITE);
        boutons.setLayout(new GridLayout(2,3));
        JButton valider = new JButton("Valider");
        JButton annuler = new JButton("Annuler");
        
		// changer la couleur de fond des boutons
        annuler.setBackground(Color.GRAY);
        valider.setBackground(Couleur.ROUGE_JO.getColor());
        // changer la couleur de la police des boutons
        annuler.setForeground(Color.WHITE);
        valider.setForeground(Color.WHITE);
        
        //Définitions des ecouteurs
        
        valider.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String nom = nomTexte.getText();
				String unite = (String) uniteTexte.getSelectedItem();
				
				System.out.println("Creation...");
				boolean creation = controleur.ajouterEpreuve(nom, unite);
				
				if(creation) {
            		controleur.enregistrer();;
                	controleur.retour();
            	}else {
            		System.out.println("Une erreur est survenue");
            	}
			}
        	
        });
        
        annuler.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controleur.retour();
				
			}
        	
        });
       
        boutons.add(defaut);
        boutons.add(annuler);
        boutons.add(valider);
        boutons.add(defaut1);
        boutons.add(defaut2);
        mainPanel.add(boutons, BorderLayout.SOUTH);
        

        
        // ajout des composant principaux
        add(info, BorderLayout.WEST);
        add(mainPanel, BorderLayout.CENTER);
	}
}