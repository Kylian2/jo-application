package vues;

import java.awt.*;

import javax.swing.*;

import composants.EmplacementMedaille;
import composants.MenuApplication;
import modeles.*;
import utilitaires.Couleur;

public class VueListePays extends JPanel {
		
	//Permet d'accéder aux données de l'application qui seront affichées. 
	ApplicationJo application;
	
	//Panel servant à contenir les pays
	JPanel panelPays;
	
	public VueListePays(ApplicationJo application, Dimension dimension) {
		
	    this.application = application;

	    setLayout(new BorderLayout()); 
	    this.setPreferredSize(dimension);

	    this.panelPays = new JPanel();
	    panelPays.setLayout(new BoxLayout(panelPays, BoxLayout.Y_AXIS));
	    panelPays.setBackground(Color.WHITE);
        panelPays.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panelPays.setPreferredSize(dimension);

	    
	    //Définir le titre
	    JLabel titre = new JLabel("Délégations");
	    titre.setFont(new Font(titre.getFont().getName(), titre.getFont().getStyle(), 32));
	    titre.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
	    panelPays.add(titre);
	    
	    //Ajout de chacun des pays au panel 
	    for(Pays pays: application.paysList) { 

	        //Création d'un panel servant à recueillir les infos du pays
	        JPanel panelSimplePays = new JPanel();
	        panelSimplePays.setLayout(new BorderLayout()); // Utilisation de BoxLayout horizontal
	        panelSimplePays.setBackground(Couleur.COULEUR_FOND_JO.getColor());
	        panelSimplePays.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	        panelSimplePays.setMaximumSize(new Dimension((int) dimension.getWidth(), 50));

	        //Ajout du nom du pays
	        JLabel nomPays = new JLabel(pays.getNom());
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

	        //Création d'un bouton avec une image
	        ImageIcon icon = new ImageIcon("img/modification.png");
	        Image img = icon.getImage();
	        Image newImg = img.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
	        icon = new ImageIcon(newImg);
	        JButton btnModification = new JButton(icon);
	        btnModification.setPreferredSize(new Dimension(25, 25));
	        btnModification.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
	        coteGauche.add(btnModification);
	        
	        panelPays.add(panelSimplePays);
	        panelPays.add(Box.createVerticalStrut(10));
	    }
	    
	    add(panelPays, BorderLayout.CENTER);

	    setBackground(Color.WHITE);
	}
	
	public static void main (String[] args) {
		System.out.println("------- Vue affichage Athletes -------");
		
		JFrame fenetre = new JFrame ();
		fenetre.setSize(960,540);
		fenetre.setLocationRelativeTo(null); 
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.getContentPane().setBackground(Color.WHITE); // Définir le fond blanc
		
		//Récuperation des données (sera fait au lancement de l'application dans le main principal)
		ApplicationJo applicationJo = new ApplicationJo();
		applicationJo.recuperer();
		
		JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setLayout(new BorderLayout());
        
        VueListePays listePays = new VueListePays(applicationJo, new Dimension(fenetre.getWidth(), fenetre.getHeight()));
        mainPanel.add(listePays);
        
        // Créer le panneau de menu
        MenuApplication menuPanel = new MenuApplication();
        menuPanel.setPreferredSize(new Dimension(270, fenetre.getHeight())); // Fixer la largeur du panneau de menu à 300 pixels
        
        // Organiser les panneaux
        fenetre.setLayout(new BorderLayout());
        fenetre.add(mainPanel, BorderLayout.CENTER);
        fenetre.add(menuPanel, BorderLayout.WEST);
		
		// Afficher la fenetre
		fenetre.setVisible(true);
	}

}
