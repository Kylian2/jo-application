package vues;
import java.awt.*;
import modeles.ApplicationJo;
import modeles.Athlete;
import modeles.Discipline;
import modeles.Pays;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.*;

import controleurs.ControleurAthlete;

public class VueAjouterSession extends JPanel {
		
	
	VueAjouterSession(ControleurAthlete controleur){
		this.setLayout(new BorderLayout());
		this.setBackground(Color.white);
		
        // initialisation des panel globaux
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3,1));
        mainPanel.setPreferredSize(new Dimension(1000,800));
        
        // initialisation des sous-JPanel
        JPanel info = new JPanel();
        info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS));
        info.setPreferredSize(new Dimension(400,450));
        
        // titre
        JLabel titre = new JLabel ("Ajouter une Session");
        titre.setFont(new Font("Source", Font.PLAIN, 30));
        
        // initialisation du JLabel + JComboBox discipline
        JPanel disciplinePanel = new JPanel();
        disciplinePanel.setLayout(new GridLayout(1,2));
        JLabel discipline = new JLabel("Discipline :     ", SwingConstants.RIGHT);
        JComboBox<String> disciplineTexte = new JComboBox<String>();
        disciplineTexte.addItem("Choisir une discipline");
        
        disciplinePanel.add(discipline);
        disciplinePanel.add(disciplineTexte);
        
        JPanel epreuvesPanel = new JPanel();
        epreuvesPanel.setLayout(new GridLayout(1,2));
        JLabel epreuves = new JLabel("Epreuves :     ", SwingConstants.RIGHT);
        JComboBox<String> epreuvesTexte = new JComboBox<String>();
        epreuvesTexte.addItem("Choisir une épreuve");
        epreuvesPanel.add(epreuves);
        epreuvesPanel.add(epreuvesTexte);
        
        JPanel typePanel = new JPanel();
        typePanel.setLayout(new GridLayout(1,2));
        JLabel type = new JLabel("Type :     ", SwingConstants.RIGHT);
        JComboBox<String> typeTexte = new JComboBox<String>();
        typeTexte.addItem("Choisir un type d'épreuve");
        typePanel.add(type);
        typePanel.add(typeTexte);
        
        JPanel datePanel = new JPanel();
        datePanel.setLayout(new GridLayout(1,2));
        JLabel date = new JLabel("Date :     ", SwingConstants.RIGHT);
        JTextField dateTexte = new JTextField("Entrez une date");
        datePanel.add(date);
        datePanel.add(dateTexte);

        JPanel debutPanel = new JPanel();
        debutPanel.setLayout(new GridLayout(1,2));
        JLabel debut = new JLabel("Début :     ", SwingConstants.RIGHT);
        JTextField debutTexte = new JTextField("Entrez l'heure de début");
        debutPanel.add(debut);
        debutPanel.add(debutTexte);

        JPanel dureePanel = new JPanel();
        dureePanel.setLayout(new GridLayout(1,2));
        JLabel duree = new JLabel("Durée :     ", SwingConstants.RIGHT);
        JTextField dureeTexte = new JTextField("Entrez une durée");
        dureePanel.add(duree);
        dureePanel.add(dureeTexte);
        
        JPanel categoriePanel = new JPanel();
        categoriePanel.setLayout(new GridLayout(1,2));
        JLabel categorie = new JLabel("Catégorie :     ", SwingConstants.RIGHT);
        JComboBox<String> categorieTexte = new JComboBox<String>();
        categorieTexte.addItem("Choisir une catégorie");
        categoriePanel.add(categorie);
        categoriePanel.add(categorieTexte);
        
        JPanel sexePanel = new JPanel();
        sexePanel.setLayout(new GridLayout(1,2));
        JLabel sexe = new JLabel("Sexe :     ", SwingConstants.RIGHT);
        JComboBox<String> sexeTexte = new JComboBox<String>();
        sexeTexte.addItem("Choisir un sexe");
        sexePanel.add(sexe);
        sexePanel.add(sexeTexte);
        
        // ajout des composants a infoPanel7
        info.add(titre);
        
        info.add(disciplinePanel);
        
        info.add(epreuvesPanel);
        
        info.add(typePanel);
        
        info.add(datePanel);
        
        info.add(debutPanel);
        
        info.add(dureePanel);
        
        info.add(categoriePanel);
        
        info.add(sexePanel);

        
        // ajout des composant principaux
        add(info, BorderLayout.WEST);
        add(mainPanel, BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
		// Creer une fenetre
		JFrame fenetre = new JFrame ();
		fenetre.setSize(960,540);
		fenetre.setLocationRelativeTo(null); 
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		// Creer une instance de ma classe
		ApplicationJo applicationJo = new ApplicationJo();
		
		applicationJo.recuperer();
		
		ControleurAthlete controleur = new ControleurAthlete(applicationJo);

		VueAjouterSession p = new VueAjouterSession(controleur);

		// Ajouter mon instance dans un des conteneurs de la fen?tre
		fenetre.add(p);

		// Afficher la fenetre
		fenetre.setVisible(true);
	}
}
