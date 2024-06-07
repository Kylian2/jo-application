package vues;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import controleurs.ControleurEquipe;
import modeles.*;

public class VueListeEquipePays extends JPanel {
		
	//Permet d'accéder aux données de l'application qui seront affichées. 
	Pays pays;
	//Panel servant à contenir les pays
	JPanel panelEquipes;
	
	JPanel header;
	
	ControleurEquipe controleur;
	
	public VueListeEquipePays(Pays pays, ControleurEquipe controleur) {
		
	    this.pays = pays;
	    this.controleur = controleur;
	    
	    setLayout(new BorderLayout()); 
	    //this.setPreferredSize(dimension);

	    this.panelEquipes = new JPanel();
	    panelEquipes.setLayout(new BoxLayout(panelEquipes, BoxLayout.Y_AXIS));
	    panelEquipes.setBackground(Color.WHITE);
        panelEquipes.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        //panelEquipes.setPreferredSize(dimension);

	    //Header
        JPanel header = new JPanel(new BorderLayout());
        header.setMaximumSize(new Dimension(700, 50));
        header.setBackground(Color.WHITE);
        
	    //Définir le titre
	    JLabel titre = new JLabel("Equipes");
	    titre.setFont(new Font(titre.getFont().getName(), titre.getFont().getStyle(), 32));
	    titre.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
	    header.add(titre, BorderLayout.WEST);
	    
	  //Bouton ajouter
	    JPanel panelBouton = new JPanel();
	    panelBouton.setBackground(Color.WHITE);
        
        JButton button = new JButton("Ajouter");
        button.setBackground(Color.GRAY);
        button.setForeground(Color.WHITE);
        button.setPreferredSize(new Dimension(90, 35));
        button.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        button.setFocusPainted(false);
        panelBouton.add(button);
        
        button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				controleur.application.mainPanel.removeAll();
				controleur.setLastPanel(VueListeEquipePays.this);
				controleur.setPays(VueListeEquipePays.this.pays);
				controleur.application.mainPanel.add(new VueAjouterEquipe(controleur));
				
				// Rafraîchir le conteneur
				controleur.application.mainPanel.revalidate();
				controleur.application.mainPanel.repaint();
			}
        	
        });
	    
	    header.add(panelBouton, BorderLayout.EAST);
	    this.header = header;
	    panelEquipes.add(header);
	    this.refresh();
	    
	    //Ajout de chacun des pays au panel 
	    add(panelEquipes, BorderLayout.CENTER);

	    setBackground(Color.WHITE);
	}
	
	public void masquer() {
		this.setVisible(false);
    }
	
	public void afficher() {
		this.setVisible(true);
    }
	
	public void refresh() {
		panelEquipes.removeAll();
		panelEquipes.add(header);
		for(Equipe equipe : pays.getEquipes()) { 
			
	        //Création d'un panel servant à recueillir les infos du pays
	        JPanel panelSimpleEquipe = new JPanel();
	        panelSimpleEquipe.setLayout(new BorderLayout()); // Utilisation de BoxLayout horizontal
	        panelSimpleEquipe.setBackground(Couleur.COULEUR_FOND_JO.getColor());
	        panelSimpleEquipe.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	        panelSimpleEquipe.setMaximumSize(new Dimension(700, 50));
	
	        //Ajout des infos de l'athlete
	        JLabel nomEquipe = new JLabel(equipe.getPays().getCode() + " - "  + equipe.getNom());

	        panelSimpleEquipe.add(nomEquipe, BorderLayout.WEST);
	        
	        // Création du panneau coteGauche
	        JPanel coteGauche = new JPanel();
	        coteGauche.setBackground(Couleur.COULEUR_FOND_JO.getColor()); // Exemple de couleur
	        panelSimpleEquipe.add(coteGauche, BorderLayout.EAST);
	
	        // Utilisation de BoxLayout pour centrer le contenu verticalement
	        coteGauche.setLayout(new BoxLayout(coteGauche, BoxLayout.X_AXIS));
	
	        // Ajout des recompenses 
	        EmplacementMedaille medaille = new EmplacementMedaille();
	        medaille.setValeur(0, pays.getOr());
	        medaille.setValeur(1, pays.getArgent());
	        medaille.setValeur(2, pays.getBronze());
	
	        coteGauche.add(Box.createVerticalGlue());
	        medaille.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrer horizontalement
	        coteGauche.add(medaille);
	        coteGauche.add(Box.createVerticalStrut(10));
	        
	        panelSimpleEquipe.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	            	controleur.application.mainPanel.removeAll();
	            	VueListeAthleteEquipe listeAthlete = new VueListeAthleteEquipe(controleur, equipe);
	            	listeAthlete.refresh();
	            	controleur.application.mainPanel.add(listeAthlete);
	                // Rafraîchir le conteneur
	            	controleur.application.mainPanel.revalidate();
	            	controleur.application.mainPanel.repaint();
	            }
	        });
	        
	        panelEquipes.add(panelSimpleEquipe);
	        panelEquipes.add(Box.createVerticalStrut(10));
	    }
		// Rafraîchir le conteneur
		panelEquipes.revalidate();
		panelEquipes.repaint();
	}
}
