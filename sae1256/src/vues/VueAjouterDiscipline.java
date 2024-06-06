package vues;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;

/**
 * Cette classe représente la vue pour ajouter une discipline.
 * Elle hérite de JPanel.
 * @autor estebanrodrigues
 */
public class VueAjouterDiscipline extends JPanel {

    // Déclaration des composants graphiques
    protected JPanel PanelGauche, PanelTitre, PanelInfo, PanelNom, PanelNum, 
    PanelTextDescription, PanelJtextField, PanelDroite, PanelAction;
    protected JLabel Titre, Nom, Numero, Description;
    protected JTextField NomTexte, NumeroTexte ;
    protected JTextArea DescriptionTexte;
    protected JButton Annuler, Valider;

    /**
     * Constructeur de la classe VueAjouterDiscipline.
     */
    VueAjouterDiscipline()
    {
        // Définition de la disposition du Panel VueAjouterDiscipline
        this.setLayout(new GridLayout(1,2));
        
        // Premier Panel de haut niveau sur la gauche de l'écran
        JPanel PanelGauche = new JPanel(new BorderLayout());
        
        // Création du Panel pour le titre
        JPanel PanelTitre = new JPanel(new BorderLayout());
        PanelTitre.setBackground(Color.WHITE);
        
        // Création du titre de la vue
        JLabel Titre = new JLabel("Créer une discipline");
        Titre.setFont(new Font(Titre.getFont().getName(), Font.BOLD, 32));
        PanelTitre.setBorder(BorderFactory.createEmptyBorder(0, 60, 40, 0));
        
        // Ajout du titre dans son Panel
        PanelTitre.add(Titre, BorderLayout.WEST);
        
        // Mise en place du panel d'information
        JPanel PanelInfo = new JPanel();
        PanelInfo.setBackground(Color.WHITE);
        
        // Création des Panel de bas niveau qui feront partie des Panel de PanelInfo
        JPanel PanelNom = new JPanel();
        JPanel PanelNum = new JPanel();
        JPanel PanelTextDescription = new JPanel();
        JPanel PanelJtextField = new JPanel();
        
        // Création du nom avec son champs de texte
        JLabel Nom = new JLabel("Nom :");
        Nom.setFont(new Font("Arial", Font.PLAIN, 20));
        JTextField NomTexte = new JTextField("Entrez le nom d'une discipline");
        NomTexte.setPreferredSize(new Dimension(170, 30)); 
        
        // Ajout des éléments dans les Panel
        PanelNom.add(Nom);
        PanelNom.add(NomTexte);
        PanelNom.setBackground(Color.WHITE);
        PanelNom.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 180));
        PanelInfo.add(PanelNom);
        
        // Création du numero avec son champs de texte
        JLabel Numero = new JLabel("Numéro :");
        Numero.setFont(new Font("Arial", Font.PLAIN, 20));
        JTextField NumeroTexte = new JTextField("Entrez le numero d'une discipline");
        NumeroTexte.setPreferredSize(new Dimension(200, 30)); 
        
        // Ajout dans les Panel
        PanelNum.add(Numero);
        PanelNum.add(NumeroTexte);
        PanelNum.setBackground(Color.WHITE);
        PanelNum.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 120));
        PanelInfo.add(PanelNum);
        
        // Création de la description avec son champs de texte
        JLabel Description = new JLabel("Description :");
        Description.setFont(new Font("Arial", Font.PLAIN, 20));
        JTextArea DescriptionTexte = new JTextArea("Entrez une description pour cette discipline");
        Border bordureNoir = BorderFactory.createLineBorder(Color.black);
        DescriptionTexte.setBorder(bordureNoir);
        DescriptionTexte.setPreferredSize(new Dimension(290, 250)); 
        
        // Ajout dans les Panel
        PanelTextDescription.add(Description);
        PanelJtextField.add(DescriptionTexte);
        PanelTextDescription.setBackground(Color.WHITE);
        PanelJtextField.setBackground(Color.WHITE);
        
        // Ajout de bordure manuellement pour déclaler les éléments vers la gauche
        PanelTextDescription.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 300));
        PanelJtextField.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 115));
        
        // Ajout des panel de bas niveau vers les Panel de haut niveau
        PanelInfo.add(PanelTextDescription);
        PanelInfo.add(PanelJtextField);
        
        // Création de Panel de remplissage pour permettre le coloriage du fonds
        JPanel PanelRemplissage1 = new JPanel();
        PanelRemplissage1.setBackground(Color.WHITE);
        
        // Disposition des Panel dans les cellules du grid
        PanelGauche.add(PanelTitre, BorderLayout.NORTH);
        PanelGauche.add(PanelInfo, BorderLayout.CENTER);
        PanelGauche.add(PanelRemplissage1, BorderLayout.SOUTH);
        
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
        JButton Annuler = new JButton("Annuler");
        Annuler.setBackground(Color.GRAY);
        Annuler.setForeground(Color.WHITE);
        Annuler.setFont(new Font("Arial", Font.PLAIN, 16));
        
        JButton Valider = new JButton("Valider les modifications");
        Valider.setBackground(Color.RED);
        Valider.setForeground(Color.WHITE);
        Valider.setFont(new Font("Arial", Font.PLAIN, 16));
        
        // Ajout dans les Panel de niveau moyen
        PanelAction.setBorder(BorderFactory.createEmptyBorder(0, 0, 25, 0));
        PanelAction.add(Annuler);
        PanelAction.add(Valider);
        
        // Disposition des Panel dans les cellules du grid
        PanelDroite.add(PanelRemplissage2, BorderLayout.NORTH);
        PanelDroite.add(PanelAction, BorderLayout.SOUTH);
        PanelDroite.add(PanelRemplissage3, BorderLayout.CENTER);
  
        //Ajout dans le Panel global
        this.add(PanelGauche);
        this.add(PanelDroite);
    }

    //Création de la JFrame
  	public static void main(String[] args) {
  			
  		//Paramétrage de la fenêtre
  		JFrame fenetre = new JFrame("Descriptif de la session");
  		fenetre.setSize(960,540);
  			
  		//Permet de fermer la fenêtre si on appuie sur la croix en haut à gauche
  		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  			
  		//Création du nouveau PanelCalculatrice et ajout à le fenêtre 
  		VueAjouterDiscipline panel = new VueAjouterDiscipline(); 
  		fenetre.add(panel);
  			
  		//Rend la JFrame visible
  		fenetre.setVisible(true);
  	}
}
