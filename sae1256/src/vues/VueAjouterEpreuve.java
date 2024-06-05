package vues;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import vues.Couleur;
import modeles.Athlete;
import modeles.Discipline;

public class VueAjouterEpreuve extends JPanel{
    

    VueAjouterEpreuve() {
    	this.setLayout(new BorderLayout());
		
        // initialisation des panel globaux
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setPreferredSize(new Dimension(1000,800));
        mainPanel.setBackground(Color.WHITE);
        
        // initialisation des sous-JPanel
        JPanel info = new JPanel();
        info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS));
        info.setPreferredSize(new Dimension(400,450));
        info.setBackground(Color.WHITE);
        
        // titre
        JPanel titrePanel = new JPanel();
        titrePanel.setLayout(new GridLayout(1,1));
        JLabel titre = new JLabel ("    Ajouter une Epreuve");
        titre.setFont(new Font("Source", Font.PLAIN, 30));
        titrePanel.add(titre, SwingConstants.CENTER);
        titrePanel.setBackground(Color.WHITE);
        
        // initialisation du JLabel + JComboBox discipline
        JPanel nomPanel = new JPanel();
        nomPanel.setLayout(new GridLayout(1,2));
        JLabel nom = new JLabel("Nom de l'épreuve :     ", SwingConstants.RIGHT);
        JTextField nomTexte = new JTextField("Choisir un type d'épreuve");
        nomPanel.setBackground(Color.WHITE);
        
        nomPanel.add(nom);
        nomPanel.add(nomTexte);
        
        JPanel sexePanel = new JPanel();
        sexePanel.setLayout(new GridLayout(1,2));
        JLabel sexe = new JLabel("Sexe :     ", SwingConstants.RIGHT);
        JComboBox<String> sexeTexte = new JComboBox<String>();
        sexeTexte.addItem("Choisir un sexe");
        sexePanel.setBackground(Color.WHITE);
        sexePanel.add(sexe);
        sexePanel.add(sexeTexte);
        
        // création de panel vide pour combler la mise en page
        JPanel vide = new JPanel();
        vide.setBackground(Color.WHITE);
        JPanel vide1 = new JPanel();
        vide1.setBackground(Color.WHITE);
        JPanel vide2 = new JPanel();
        vide2.setBackground(Color.WHITE);
        JPanel vide3 = new JPanel();
        vide3.setBackground(Color.WHITE);
        JPanel vide4 = new JPanel();
        vide4.setBackground(Color.WHITE);
        JPanel vide5 = new JPanel();
        vide5.setBackground(Color.WHITE);
        JPanel vide6 = new JPanel();
        vide6.setBackground(Color.WHITE);
        
        
        // ajout des composants a infoPanel
        info.add(titrePanel);
        info.add(Box.createHorizontalStrut(10));
        info.add(nomPanel);
        info.add(Box.createHorizontalStrut(10));  // créer un espace entre chaque panel
        info.add(sexePanel);			
        info.add(vide);
        info.add(vide1);
        info.add(vide2);
        info.add(vide3);
        info.add(vide4);
        info.add(vide5);
        info.add(vide6);
        
        // définition de panel vide pour combler la mise en page
        JPanel defaut = new JPanel();
        defaut.setBackground(Color.WHITE);
        JPanel defaut1 = new JPanel();
        defaut1.setBackground(Color.WHITE);
        JPanel defaut2 = new JPanel();
        defaut2.setBackground(Color.WHITE);
        
        
        // initialisation des boutons valider et annuler
        JPanel boutons = new JPanel();
        boutons.setBackground(Color.WHITE);
        boutons.setLayout(new GridLayout(2,3));
        JButton valider = new JButton("Valider");
        JButton annuler = new JButton("Annuler");
        
		// changer la couleur de fond des boutons
        annuler.setBackground(Color.GRAY);
        valider.setBackground(Couleur.ROUGE_JO.getColor());
        // changer la couleur de la police des boutons
        annuler.setForeground(Color.WHITE);
        valider.setForeground(Color.WHITE);
       
        boutons.add(defaut);
        boutons.add(annuler);
        boutons.add(valider);
        boutons.add(defaut1);
        boutons.add(defaut2);
        mainPanel.add(boutons, BorderLayout.SOUTH);
        

        
        // ajout des composant principaux
        add(info, BorderLayout.WEST);
        add(mainPanel, BorderLayout.CENTER);
	}

	public static void main(String[] args) {
        // Creer une fenetre
        JFrame fenetre = new JFrame();
        fenetre.setSize(960, 540);
        fenetre.setLocationRelativeTo(null);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creer une instance de ma classe
        VueAjouterEpreuve p = new VueAjouterEpreuve();

        // Ajouter mon instance dans un des conteneurs de la fenêtre
        fenetre.add(p);

        // Afficher la fenetre
        fenetre.setVisible(true);
    }
}