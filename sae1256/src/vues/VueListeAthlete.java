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

import controleurs.ControleurAthlete;
import modeles.Athlete;
import modeles.Pays;
/**
 * Cette classe l'affichage de la liste des athlètes.
 * 
 * @author kylianrichard
 */
public class VueListeAthlete extends JPanel {
	
	//Panel servant à contenir les pays
	JPanel panelAthlete;
	
	ControleurAthlete controleur; 
	
	Dimension dimension;
	
	JPanel header;
	
	 /**
     * Constructeur de la vue pour afficher la liste des athlètes.
     * 
     * @param controleur Le contrôleur permettant de gérer les athlètes.
     * @param dimension Les dimensions de la vue.
     */
	public VueListeAthlete(ControleurAthlete controleur, Dimension dimension) {
			
	    this.controleur = controleur;
	    
	    controleur.recuperer();
	    
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
        header.setMaximumSize(new Dimension((int) dimension.getWidth(), 50));
        header.setBackground(Color.WHITE);
        
	    //Définir le titre
	    JLabel titre = new JLabel("Athlètes");
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
				controleur.application.mainPanel.removeAll();
				controleur.setLastPanel(VueListeAthlete.this);
				controleur.application.mainPanel.add(new VueAjouterAthlete(controleur));

				// Rafraîchir le conteneur
                controleur.application.mainPanel.revalidate();
                controleur.application.mainPanel.repaint();
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
	
	/**
     * Rafraîchie/crée la liste des athlètes pour prendre en comptes les modifications.
     */
	public void refresh() {
		panelAthlete.removeAll();
		panelAthlete.add(header);
		for(Athlete athlete : controleur.application.athletesList) { 
			
	        //Création d'un panel servant à recueillir les infos du pays
	        JPanel panelSimplePays = new JPanel();
	        panelSimplePays.setLayout(new BorderLayout()); // Utilisation de BoxLayout horizontal
	        panelSimplePays.setBackground(Couleur.COULEUR_FOND_JO.getColor());
	        panelSimplePays.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	        panelSimplePays.setMaximumSize(new Dimension((int) dimension.getWidth(), 50));
	
	        //Ajout des infos de l'athlete
	        JLabel nomPays = new JLabel(athlete.getPays().getCode() + " - "  + athlete.getNom() + ' ' + athlete.getPrenom());
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
	        
	        panelSimplePays.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	            	controleur.application.mainPanel.removeAll();
	            	controleur.application.mainPanel.add(new VueAthlete(athlete));
	                // Rafraîchir le conteneur
	            	controleur.application.mainPanel.revalidate();
	            	controleur.application.mainPanel.repaint();
	            }
	        });
	        panelAthlete.add(panelSimplePays);
	        panelAthlete.add(Box.createVerticalStrut(10));
	    }
		// Rafraîchir le conteneur
		panelAthlete.revalidate();
		panelAthlete.repaint();
	}
}