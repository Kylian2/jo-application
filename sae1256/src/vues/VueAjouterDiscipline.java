package vues;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;

import controleurs.ControleurDiscipline;

/**
 * Cette classe représente la vue pour ajouter une discipline.
 * Elle hérite de JPanel.
 * @author estebanrodrigues
 */
public class VueAjouterDiscipline extends JPanel {

    // Déclaration des composants graphiques
    protected JPanel PanelGauche, PanelTitre, PanelInfo, PanelNom, 
    PanelTextDescription, PanelJtextField, PanelDroite, PanelAction, PanelCentre;
    protected JLabel Titre, Nom, Numero, Description;
    protected JTextField nomTexte, NumeroTexte ;
    protected JTextArea descriptionTexte;
    protected JButton annuler, valider;

    ControleurDiscipline controleur;
    /**
     * Constructeur de la classe VueAjouterDiscipline.
     */
    VueAjouterDiscipline(ControleurDiscipline controleur)
    {
    	this.controleur = controleur;
    	this.setLayout(new BorderLayout());
    	JPanel PanelCentre = new JPanel(new GridLayout(1,2));
    	
        // Premier Panel de haut niveau sur la gauche de l'écran
        JPanel PanelGauche = new JPanel(new BorderLayout());
        
        // Création du Panel pour le titre
        JPanel PanelTitre = new JPanel();
        PanelTitre.setBackground(Color.WHITE);
        
        // Création du titre de la vue
        JLabel Titre = new JLabel("Créer une discipline");
        Titre.setFont(new Font(Titre.getFont().getName(), Font.BOLD, 32));
        PanelTitre.setBorder(BorderFactory.createEmptyBorder(0, 0, 40, 250));
        
        // Ajout du titre dans son Panel
        PanelTitre.add(Titre);
        this.add(PanelTitre, BorderLayout.NORTH);
        
        // Mise en place du panel d'information
        JPanel PanelInfo = new JPanel();
        PanelInfo.setBackground(Color.WHITE);
        
        // Création des Panel de bas niveau qui feront partie des Panel de PanelInfo
        JPanel PanelNom = new JPanel();
        JPanel PanelTextDescription = new JPanel();
        JPanel PanelJtextField = new JPanel();
        
        // Création du nom avec son champs de texte
        JLabel Nom = new JLabel("Nom :");
        Nom.setFont(new Font("Arial", Font.PLAIN, 20));
        JTextField nomTexte = new JTextField("Entrez le nom d'une discipline");
        nomTexte.setPreferredSize(new Dimension(170, 30)); 
        
        // Ajout des éléments dans les Panel
        PanelNom.add(Nom);
        PanelNom.add(nomTexte);
        PanelNom.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 60));
        PanelNom.setBackground(Color.WHITE);
        PanelInfo.add(PanelNom, BorderLayout.NORTH);
        
        // Création de la description avec son champs de texte
        JLabel Description = new JLabel("Description :");
        Description.setFont(new Font("Arial", Font.PLAIN, 20));
        JTextArea descriptionTexte = new JTextArea("Entrez une description pour cette discipline");
        Border bordureNoir = BorderFactory.createLineBorder(Color.black);
        descriptionTexte.setBorder(bordureNoir);
        descriptionTexte.setPreferredSize(new Dimension(290, 250)); 
        
        // Ajout dans les Panel
        PanelTextDescription.add(Description);
        PanelJtextField.add(descriptionTexte);
        PanelTextDescription.setBackground(Color.WHITE);
        PanelJtextField.setBackground(Color.WHITE);
        
        // Ajout de bordure manuellement pour déclaler les éléments vers la gauche
        PanelTextDescription.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 180));
        
        // Ajout des panel de bas niveau vers les Panel de haut niveau
        PanelInfo.add(PanelTextDescription, BorderLayout.CENTER);
        PanelInfo.add(PanelJtextField, BorderLayout.SOUTH);
        
        // Création de Panel de remplissage pour permettre le coloriage du fonds
        JPanel PanelRemplissage1 = new JPanel();
        PanelRemplissage1.setBackground(Color.WHITE);
        
        // Disposition des Panel dans les cellules du grid
        //PanelGauche.add(PanelTitre, BorderLayout.NORTH);
        PanelGauche.add(PanelInfo, BorderLayout.CENTER);
        PanelGauche.add(PanelRemplissage1, BorderLayout.SOUTH);
        PanelCentre.add(PanelGauche);
        
        // Création du Panel de droite
        PanelDroite = new JPanel(new BorderLayout());
        
        // Utilisation de Panel de remplissage pour le coloriage du fonds
        JPanel PanelRemplissage2 = new JPanel();
        PanelRemplissage2.setBackground(Color.WHITE);
        JPanel PanelRemplissage3 = new JPanel();
        PanelRemplissage3.setBackground(Color.WHITE);
        PanelAction = new JPanel(new GridLayout(1,2));
        PanelAction.setBackground(Color.WHITE);
        
        // Création des boutons avec leur style
        JButton annuler = new JButton("annuler");
        annuler.setBackground(Color.GRAY);
        annuler.setForeground(Color.WHITE);
        annuler.setFont(new Font("Arial", Font.PLAIN, 12));
        
        JButton valider = new JButton("valider les modifications");
        valider.setBackground(Color.RED);
        valider.setForeground(Color.WHITE);
        valider.setFont(new Font("Arial", Font.PLAIN, 12));
        
        // Ajout dans les Panel de niveau moyen
        PanelAction.add(annuler);
        PanelAction.add(valider);
        PanelAction.setBorder(BorderFactory.createEmptyBorder(0, 0, 60, 0));
        
        // Disposition des Panel dans les cellules du grid
        PanelDroite.add(PanelRemplissage2, BorderLayout.NORTH);
        PanelDroite.add(PanelRemplissage3, BorderLayout.CENTER);
        PanelDroite.add(PanelAction, BorderLayout.SOUTH);
  
        //Ajout dans le Panel global
        PanelCentre.add(PanelGauche);
        PanelCentre.add(PanelDroite);
        
        this.add(PanelCentre, BorderLayout.CENTER);
        
        valider.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String nom = nomTexte.getText();
	            String description = descriptionTexte.getText();

	            boolean creation = controleur.creerDiscipline(nom, description);

	            if (creation) {
	                controleur.enregister();
	                controleur.retour();
	            } else {
	                System.out.println("Une erreur est survenue");
	            }
			}
            
        });
        
        annuler.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controleur.retour();
			}
        	
        });
    }
}
