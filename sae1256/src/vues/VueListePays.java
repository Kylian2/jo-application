package vues;

import java.awt.*;

import javax.swing.*;

import composants.MenuApplication;
import modeles.*;

public class VueListePays extends JPanel {
	
	//Définition des constantes 
	final static Color FOND_GRIS_COLOR = new Color(229, 229, 229);
		
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
	        panelSimplePays.setLayout(new BoxLayout(panelSimplePays, BoxLayout.X_AXIS)); // Utilisation de BoxLayout horizontal
	        panelSimplePays.setBackground(FOND_GRIS_COLOR);
	        panelSimplePays.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	        panelSimplePays.setMaximumSize(new Dimension((int) dimension.getWidth(), 50));

	        //Ajout du nom du pays
	        JLabel nomPays = new JLabel(pays.getNom());
	        panelSimplePays.add(nomPays);
	        
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
