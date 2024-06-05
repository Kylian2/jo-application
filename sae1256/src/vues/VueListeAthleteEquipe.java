package vues;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import controleurs.ControleurEquipe;
import modeles.*;

public class VueListeAthleteEquipe extends JPanel {
	
	
	//Panel servant à contenir les pays
	JPanel panelAthlete;
	
	Dimension dimension;
	
	JPanel header;
	
	Equipe equipe;

	ControleurEquipe controleur;
		
	public VueListeAthleteEquipe(ControleurEquipe controleur, Equipe equipe) {
			
	    this.controleur = controleur;
	    controleur.application.recuperer();
	    this.equipe = equipe;
	    
	    this.dimension = dimension;
	    
	    setLayout(new BorderLayout()); 
	    this.setPreferredSize(dimension);
	
	    this.panelAthlete = new JPanel();
	    panelAthlete.setLayout(new BoxLayout(panelAthlete, BoxLayout.Y_AXIS));
	    panelAthlete.setBackground(Color.WHITE);
	    panelAthlete.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
	    panelAthlete.setPreferredSize(dimension);
	
	    
	    //Header
        JPanel header = new JPanel(new BorderLayout());
        header.setMaximumSize(new Dimension(700, 50));
        header.setBackground(Color.WHITE);
        
	    //Définir le titre
	    JLabel titre = new JLabel("Membres de " + equipe.getNom());
	    titre.setFont(new Font(titre.getFont().getName(), titre.getFont().getStyle(), 18));
	    titre.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
	    header.add(titre, BorderLayout.WEST);
	    
	    //Bouton ajouter
	    JPanel panelBouton = new JPanel();
	    panelBouton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(0, 10, 10, 10), 
                BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK) // Bordure de couleur de 2 pixels en bas
        ));
	    panelBouton.setBackground(Color.WHITE);
        
        JButton button = new JButton("Supprimer l'equipe");
        button.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        button.setFocusPainted(false);
        button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controleur.setPays(equipe.getPays());
				if(controleur.supprimerEquipe(equipe)) {
					controleur.application.mainPanel.removeAll();
					controleur.application.mainPanel.add(new VueListeEquipePays(equipe.getPays(), controleur));
					controleur.enregistrer();

					// Rafraîchir le conteneur
	                controleur.application.mainPanel.revalidate();
	                controleur.application.mainPanel.repaint();
				}
			}
        });
        panelBouton.add(button);
	    
	    header.add(panelBouton, BorderLayout.EAST);
	    
	    this.header = header;
	    panelAthlete.add(header);
	    
	    add(panelAthlete, BorderLayout.CENTER);
	    
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
		panelAthlete.removeAll();
		panelAthlete.add(header);
		controleur.application.recuperer();
		
		for(Athlete athlete : equipe.getMembres()) { 
			
	        //Création d'un panel servant à recueillir les infos du pays
	        JPanel panelSimpleAthlete = new JPanel();
	        panelSimpleAthlete.setLayout(new BorderLayout()); // Utilisation de BoxLayout horizontal
	        panelSimpleAthlete.setBackground(Couleur.COULEUR_FOND_JO.getColor());
	        panelSimpleAthlete.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	        panelSimpleAthlete.setMaximumSize(new Dimension(700, 50));
	
	        //Ajout des infos de l'athlete
	        JLabel nomPays = new JLabel(athlete.getPays().getCode() + " - "  + athlete.getNom() + ' ' + athlete.getPrenom());
	        panelSimpleAthlete.add(nomPays, BorderLayout.WEST);
	        
	        // Création du panneau coteGauche
	        JPanel coteGauche = new JPanel();
	        coteGauche.setBackground(Couleur.COULEUR_FOND_JO.getColor()); // Exemple de couleur
	        panelSimpleAthlete.add(coteGauche, BorderLayout.EAST);
	
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
	        
	        panelSimpleAthlete.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	            	controleur.application.mainPanel.removeAll();
	            	controleur.application.mainPanel.add(new VueAthlete(athlete));
	                // Rafraîchir le conteneur
	            	controleur.application.mainPanel.revalidate();
	            	controleur.application.mainPanel.repaint();
	            }
	        });
	        panelAthlete.add(panelSimpleAthlete);
	        panelAthlete.add(Box.createVerticalStrut(10));
	        System.out.println("Rafraichie");
	    }
		// Rafraîchir le conteneur
		panelAthlete.revalidate();
		panelAthlete.repaint();
	}
}