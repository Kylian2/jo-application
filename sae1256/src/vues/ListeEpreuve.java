package vues;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controlleurs.ControlleurAthlete;
import modeles.*;

public class ListeEpreuve extends JPanel{
	//Permet d'accéder aux données de l'application qui seront affichées. 
		ApplicationJo application;
		
		//Panel servant à contenir les pays
		JPanel panelEpreuve; 
		
		Dimension dimension;
		
		JPanel header;
		JPanel legende;
		
		Discipline discipline;
			
		public ListeEpreuve(ApplicationJo application, Dimension dimension, Discipline discipline) {
				
		    this.application = application;
		    application.recuperer();
		    this.discipline = discipline;
		    
		    this.dimension = dimension;
		    
		    setLayout(new BorderLayout()); 
		    this.setPreferredSize(dimension);
		
		    this.panelEpreuve = new JPanel();
		    panelEpreuve.setLayout(new BoxLayout(panelEpreuve, BoxLayout.Y_AXIS));
		    panelEpreuve.setBackground(Color.WHITE);
		    panelEpreuve.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		    panelEpreuve.setPreferredSize(dimension);
		
		    
		    //Header
	        JPanel header = new JPanel(new BorderLayout());
	        header.setMaximumSize(new Dimension((int) dimension.getWidth(), 50));
	        header.setBackground(Color.WHITE);
	        
		    //Définir le titre
		    JLabel titre = new JLabel(discipline.getNom());
		    titre.setFont(new Font(titre.getFont().getName(), titre.getFont().getStyle(), 32));
		    titre.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

		    header.add(titre, BorderLayout.WEST);
		    
		    //Bouton ajouter
		    JPanel panelBouton = new JPanel();
		    panelBouton.setBackground(Color.WHITE);
	        
	        JButton button = new JButton("Ajouter");
	        button.setPreferredSize(new Dimension(90, 35));
	        button.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
	        button.setFocusPainted(false);
	        button.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
					//ECRAN D'AJOUT D'UNE EPREUVE

					// Rafraîchir le conteneur
	                application.mainPanel.revalidate();
	                application.mainPanel.repaint();
				}
	        	
	        });
	        panelBouton.add(button);
		    
		    header.add(panelBouton, BorderLayout.EAST);
		    
		    this.header = header;
		    panelEpreuve.add(header);
		    
		    legende = new JPanel(new BorderLayout());
		    legende.setBackground(Color.WHITE);
		    legende.setMaximumSize(new Dimension(700, 50));
		    JLabel paragraphe = new JLabel("Liste des épreuves pour cette discipline : ", JLabel.LEFT);
		    paragraphe.setFont(new Font(paragraphe.getFont().getName(), paragraphe.getFont().getStyle(), 18));
		    paragraphe.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
		    legende.add(paragraphe, BorderLayout.WEST);
		    panelEpreuve.add(legende);
		    
		    add(panelEpreuve, BorderLayout.CENTER);
		    
		    // changer la couleur de fond du bouton
	        button.setBackground(Color.GRAY);
	        // changer la couleur de la police du bouton
	        button.setForeground(Color.WHITE);
	        // changer la couleur du fond de la fenêtre
		    setBackground(Color.WHITE);
		    
		    this.refresh();
		}
		
		public void masquer() {
			this.setVisible(false);
	    }
		
		public void afficher() {
			this.setVisible(true);
	    }
		
		public void refresh() {
			panelEpreuve.removeAll();
			panelEpreuve.add(header);
			panelEpreuve.add(legende);
			int couleurCount = 0;
			for(Epreuve epreuve : discipline.getEpreuves()) { 
				
		        //Création d'un panel servant à recueillir les infos du pays
		        JPanel panelSimpleEpreuve = new JPanel();
		        panelSimpleEpreuve.setLayout(new BorderLayout()); // Utilisation de BoxLayout horizontal
		        panelSimpleEpreuve.setBackground(Couleur.COULEUR_FOND_JO.getColor());
		        panelSimpleEpreuve.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		        panelSimpleEpreuve.setMaximumSize(new Dimension((int) dimension.getWidth(), 50));
		
		        //Ajout des infos de l'athlete
		        JLabel nomPays = new JLabel(epreuve.getNom());
		        panelSimpleEpreuve.add(nomPays, BorderLayout.WEST);
		        
		        panelSimpleEpreuve.addMouseListener(new MouseAdapter() {
		            @Override
		            public void mouseClicked(MouseEvent e) {
		            	
		                // Rafraîchir le conteneur
		            	application.mainPanel.revalidate();
		            	application.mainPanel.repaint();
		            }
		        });
		        
		        Color[] colors = {Couleur.BLEU_JO.getColor(), Couleur.JAUNE_JO.getColor(), Couleur.ROUGE_JO.getColor(), Couleur.VERT_JO.getColor()};
		        panelSimpleEpreuve.setBackground(colors[couleurCount%colors.length]);
		        couleurCount++;
		        
		        panelEpreuve.add(panelSimpleEpreuve);
		        panelEpreuve.add(Box.createVerticalStrut(10));
		    }
			// Rafraîchir le conteneur
			panelEpreuve.revalidate();
			panelEpreuve.repaint();
		}
}
