package vues;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import controleurs.ControleurEquipe;
import controleurs.ControleurPays;
import modeles.*;
/**
 * Cette classe représente une vue pour afficher la liste des délégations.
 * Elle étend JPanel et contient des fonctionnalités pour rafraîchir la liste.
 * 
 * @author kylianrichard
 */
public class VueListePays extends JPanel {
		
	//Permet d'accéder aux données de l'application qui seront affichées. 
	ApplicationJo application;
	
	//Panel servant à contenir les pays
	JPanel panelPays;
	
	JPanel header;
	
	Dimension dimension;
	
	/**
     * Constructeur de la classe VueListePays.
     * 
     * @param application L'instance de l'application qui contient les données.
     * @param dimension La dimension de cette vue.
     * 
     * @author kylianrichard
     */
	public VueListePays(ApplicationJo application, Dimension dimension) {
		
	    this.application = application;
	    this.dimension = dimension;
	    
	    setLayout(new BorderLayout()); 
	    this.setPreferredSize(dimension);

	    this.panelPays = new JPanel();
	    panelPays.setLayout(new BoxLayout(panelPays, BoxLayout.Y_AXIS));
	    panelPays.setBackground(Color.WHITE);
        panelPays.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panelPays.setPreferredSize(dimension);

	    // Header
        JPanel header = new JPanel(new BorderLayout());
        header.setMaximumSize(new Dimension((int) dimension.getWidth(), 50));
        header.setBackground(Color.WHITE);
        
	    // Définir le titre
	    JLabel titre = new JLabel("Délégations");
	    titre.setFont(new Font(titre.getFont().getName(), titre.getFont().getStyle(), 32));
	    titre.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
	    header.add(titre, BorderLayout.WEST);
	    
	    // Bouton ajouter
	    JPanel panelBouton = new JPanel();
	    panelBouton.setBackground(Color.WHITE);
        
        JButton button = new JButton("Ajouter");
        button.setPreferredSize(new Dimension(90, 35));
        button.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        button.setFocusPainted(false);
        
        button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				application.mainPanel.removeAll();
				ControleurPays controleur = new ControleurPays(application);
				controleur.setLastPanel(VueListePays.this);
				application.mainPanel.add(new VueCreerPays(controleur));

				// Rafraîchir le conteneur
                application.mainPanel.revalidate();
                application.mainPanel.repaint();
			}
        	
        });
        
        panelBouton.add(button);
	    
	    header.add(panelBouton, BorderLayout.EAST);
	    this.header = header;
	    panelPays.add(header);
	    this.refresh();
	    
	    //Ajout de chacun des pays au panel 
	    add(panelPays, BorderLayout.CENTER);

	    // changer la couleur de fond du bouton
        button.setBackground(Color.GRAY);
        // changer la couleur de la police du bouton
        button.setForeground(Color.WHITE);
        // changer la couleur du fond de la fenêtre
	    setBackground(Color.WHITE);
	}
	
	/**
     * Rafraîchit la liste des equipes et les affiche.
     * @author kylianrichard
     */
	
	public void refresh() {
		panelPays.removeAll();
		panelPays.add(header);
		for(Pays pays : application.paysList) { 
			
	        //Création d'un panel servant à recueillir les infos du pays
	        JPanel panelSimplePays = new JPanel();
	        panelSimplePays.setLayout(new BorderLayout()); // Utilisation de BoxLayout horizontal
	        panelSimplePays.setBackground(Couleur.COULEUR_FOND_JO.getColor());
	        panelSimplePays.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	        panelSimplePays.setMaximumSize(new Dimension((int) dimension.getWidth(), 50));
	
	        //Ajout des infos de l'athlete
	        JLabel nomPays = new JLabel(pays.getCode() + " - "  + pays.getNom());
	        panelSimplePays.add(nomPays, BorderLayout.WEST);
	        
	        // Création du panneau coteGauche
	        JPanel coteGauche = new JPanel();
	        coteGauche.setBackground(Couleur.COULEUR_FOND_JO.getColor()); // Exemple de couleur
	        panelSimplePays.add(coteGauche, BorderLayout.EAST);
	
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
	        
	        panelPays.add(panelSimplePays);
	        panelPays.add(Box.createVerticalStrut(10));
	        
	        panelSimplePays.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseClicked(MouseEvent e) {
					application.mainPanel.removeAll();
					ControleurEquipe controleur = new ControleurEquipe(application);
	            	application.mainPanel.add(new VueListeEquipePays(pays, controleur));
	                // Rafraîchir le conteneur
	            	application.mainPanel.revalidate();
	            	application.mainPanel.repaint();
				}
	        	
	        });
	    }
		// Rafraîchir le conteneur
		panelPays.revalidate();
		panelPays.repaint();
	}
}
