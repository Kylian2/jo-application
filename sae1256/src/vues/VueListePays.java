package vues;

import java.awt.*;

import javax.swing.*;

import modeles.*;

public class VueListePays extends JPanel {
	
	//Permet d'accéder aux données de l'application qui seront affichées. 
	ApplicationJo application;
	
	//Panel servant à contenir les pays
	JPanel panelPays;
	
	public VueListePays(ApplicationJo application) {
		this.application = application;
		
		this.panelPays = new JPanel();
		panelPays.setLayout(new BoxLayout(panelPays, BoxLayout.Y_AXIS));
		
		//Définir le titre
		JLabel titre = new JLabel("Délégations");
        titre.setFont(new Font(titre.getFont().getName(), titre.getFont().getStyle(), 20));
		panelPays.add(titre);
        
		
		//Ajout de chacun des pays au panel 
		for(Pays pays: application.paysList) {
			//Création d'un panel servant à recuiellir les infos du pays
			JPanel panelSimplePays = new JPanel();
			panelSimplePays.setLayout(new BorderLayout());
			panelSimplePays.setBackground(Color.LIGHT_GRAY);
			panelSimplePays.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
			panelSimplePays.setOpaque(true);
			
			JLabel nomPays = new JLabel(pays.getNom());
			panelSimplePays.add(nomPays);
	        
	        panelPays.add(panelSimplePays);
	        panelPays.add(Box.createVerticalStrut(10));
		}
		
		add(panelPays);
	}
	
	public static void main (String[] args) {
		System.out.println("------- Vue affichage Athletes -------");
		
		JFrame fenetre = new JFrame ();
		fenetre.setSize(960,540);
		fenetre.setLocationRelativeTo(null); 
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Récuperation des données (sera fait au lancement de l'application dans le main principal)
		ApplicationJo applicationJo = new ApplicationJo();
		applicationJo.recuperer();
		
		
		// Creer une instance de ma classe
		VueListePays vueListeApplication = new VueListePays(applicationJo);
		
		// Ajouter mon instance dans un des conteneurs de la fenetre
		fenetre.add(vueListeApplication);
		
		// Afficher la fenetre
		fenetre.setVisible(true);
	}

}
