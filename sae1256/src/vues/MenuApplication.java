package vues;

import javax.swing.*;
import javax.swing.border.Border;

import controleurs.ControleurAthlete;
import controleurs.ControleurSession;
import modeles.ApplicationJo;
import sae1256.Main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


//TODO : 
// - Gerer les actions à l'appui sur les boutons
// - ajouter l'affichage du profil de l'utilisateur si implémentation

public class MenuApplication extends JPanel {
	
	// Constantes pour les dimensions
    private static final int BUTTON_WIDTH = 200;
    private static final int BUTTON_HEIGHT = 50;
    
    public JPanel vueConteneur;
     
    public VueAccueil vueAccueil;
    
    ApplicationJo application;
	
    public MenuApplication(ApplicationJo application,JPanel vueConteneur,VueAccueil accueil) {
    	this.vueConteneur = vueConteneur;
    	
    	this.application = application;
    	
    	this.vueAccueil = accueil;
    	
        // Panneau principal
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Couleur.COULEUR_FOND_JO.getColor());
                
        // Logo des anneaux olympiques
        ImageIcon icon = new ImageIcon("img/logo-jo.png");
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(150, 68, Image.SCALE_SMOOTH);
        icon = new ImageIcon(newImg);
        
        JLabel logo = new JLabel(icon);
        logo.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        logo.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(logo);
        
        logo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	application.mainPanel.removeAll();
            	application.mainPanel.add(accueil);
                // Rafraîchir le conteneur
            	application.mainPanel.revalidate();
            	application.mainPanel.repaint();
            }
        });
        
        // Boutons du menu
        JButton athletesButton = createMenuButton("Athlètes", Couleur.BLEU_JO);
        athletesButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//Masquer les autres
				vueConteneur.removeAll();
				//Afficher le panel correspondant
				ControleurAthlete controleur = new ControleurAthlete(application);
				vueConteneur.add(new VueListeAthlete(controleur, Main.DIMENSION), BorderLayout.CENTER);
				
				// Rafraîchir le conteneur
                vueConteneur.revalidate();
                vueConteneur.repaint();
			}
        });
        JButton paysButton = createMenuButton("Délégations", Couleur.JAUNE_JO);
        paysButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//Masquer les autres
				vueConteneur.removeAll();
				//Afficher le panel correspondant
				MenuApplication.this.application.recuperer();
				vueConteneur.add(new VueListePays(MenuApplication.this.application, new Dimension(700, 540)), BorderLayout.CENTER);
				
				// Rafraîchir le conteneur
                vueConteneur.revalidate();
                vueConteneur.repaint();
			}
        });
        JButton resultsButton = createMenuButton("Résultats", Couleur.VERT_JO);
        JButton planningButton = createMenuButton("Planning", Couleur.BLEU_JO);
        planningButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//Masquer les autres
				vueConteneur.removeAll();
				//Afficher le panel correspondant
				ControleurSession controleurSession = new ControleurSession(MenuApplication.this.application);
				vueConteneur.add(new VueApercuSession(controleurSession, new Dimension(700, 540)), BorderLayout.CENTER);
				
				// Rafraîchir le conteneur
                vueConteneur.revalidate();
                vueConteneur.repaint();
			}
        });
        JButton disciplineButton = createMenuButton("Discipline", Couleur.ROUGE_JO);
        disciplineButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//Masquer les autres
				vueConteneur.removeAll();
				//Afficher le panel correspondant
				vueConteneur.add(new VueListeDiscipline(application, Main.DIMENSION), BorderLayout.CENTER);
				
				// Rafraîchir le conteneur
                vueConteneur.revalidate();
                vueConteneur.repaint();
			}
        });
        // Ajouter les boutons au panneau principal
        add(athletesButton);
        athletesButton.setBackground(Couleur.COULEUR_FOND_JO.getColor());
        add(paysButton);
        paysButton.setBackground(Couleur.COULEUR_FOND_JO.getColor());
        add(resultsButton);
        resultsButton.setBackground(Couleur.COULEUR_FOND_JO.getColor());
        add(planningButton);
        planningButton.setBackground(Couleur.COULEUR_FOND_JO.getColor());
        add(disciplineButton);
        disciplineButton.setBackground(Couleur.COULEUR_FOND_JO.getColor());
        
    }
    
    private JButton createMenuButton(String text, Couleur couleur) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setMaximumSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        button.setBackground(Color.WHITE);
        button.setFont(new Font("Arial", Font.PLAIN, 26));
        button.setHorizontalAlignment(SwingConstants.LEFT);
        
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(10, 10, 0, 10), 
                BorderFactory.createMatteBorder(0, 0, 2, 0, couleur.getColor()) // Bordure de couleur de 2 pixels en bas
        ));
        
        return button;
    }
    
}
