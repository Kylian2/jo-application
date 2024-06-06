package vues;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComponent;

import controleurs.ControleurAthlete;
import modeles.ApplicationJo;

public class VueAjouterSession extends JPanel {
		
	
	VueAjouterSession(ControleurAthlete controleur){
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
        JLabel titre = new JLabel ("    Ajouter une Session");
        titre.setFont(new Font("Source", Font.PLAIN, 30));
        titrePanel.add(titre, SwingConstants.CENTER);
        titrePanel.setBackground(Color.WHITE);
        
        // initialisation du JLabel + JComboBox discipline
        JPanel disciplinePanel = new JPanel();
        disciplinePanel.setLayout(new GridLayout(1,2));
        JLabel discipline = new JLabel("Discipline :     ", SwingConstants.RIGHT);
        JComboBox<String> disciplineTexte = new JComboBox<String>();
        disciplineTexte.addItem("Choisir une discipline");
        disciplinePanel.setBackground(Color.WHITE);
        
        
        disciplinePanel.add(discipline);
        disciplinePanel.add(disciplineTexte);
        
        JPanel epreuvesPanel = new JPanel();
        epreuvesPanel.setLayout(new GridLayout(1,2));
        JLabel epreuves = new JLabel("Epreuves :     ", SwingConstants.RIGHT);
        JComboBox<String> epreuvesTexte = new JComboBox<String>();
        epreuvesTexte.addItem("Choisir une épreuve");
        epreuvesPanel.setBackground(Color.WHITE);
        epreuvesPanel.add(epreuves);
        epreuvesPanel.add(epreuvesTexte);
        
        JPanel typePanel = new JPanel();
        typePanel.setLayout(new GridLayout(1,2));
        JLabel type = new JLabel("Type :     ", SwingConstants.RIGHT);
        JComboBox<String> typeTexte = new JComboBox<String>();
        typeTexte.addItem("Choisir un type d'épreuve");
        typePanel.setBackground(Color.WHITE);
        typePanel.add(type);
        typePanel.add(typeTexte);
        
        JPanel datePanel = new JPanel();
        datePanel.setLayout(new GridLayout(1,2));
        JLabel date = new JLabel("Date :     ", SwingConstants.RIGHT);
        JTextField dateTexte = new JTextField("Entrez une date (JJ/MM/AAAA)");
        datePanel.setBackground(Color.WHITE);
        datePanel.add(date);
        datePanel.add(dateTexte);

        JPanel debutPanel = new JPanel();
        debutPanel.setLayout(new GridLayout(1,2));
        JLabel debut = new JLabel("Début :     ", SwingConstants.RIGHT);
        JTextField debutTexte = new JTextField("Entrez l'heure de début");
        debutPanel.setBackground(Color.WHITE);
        debutPanel.add(debut);
        debutPanel.add(debutTexte);

        JPanel dureePanel = new JPanel();
        dureePanel.setLayout(new GridLayout(1,2));
        JLabel duree = new JLabel("Durée :     ", SwingConstants.RIGHT);
        JTextField dureeTexte = new JTextField("Entrez une durée");
        dureePanel.setBackground(Color.WHITE);
        dureePanel.add(duree);
        dureePanel.add(dureeTexte);
        
        JPanel categoriePanel = new JPanel();
        categoriePanel.setLayout(new GridLayout(1,2));
        JLabel categorie = new JLabel("Catégorie :     ", SwingConstants.RIGHT);
        JComboBox<String> categorieTexte = new JComboBox<String>();
        categorieTexte.addItem("Choisir une catégorie");
        categoriePanel.setBackground(Color.WHITE);
        categoriePanel.add(categorie);
        categoriePanel.add(categorieTexte);
        
        JPanel sexePanel = new JPanel();
        sexePanel.setLayout(new GridLayout(1,2));
        JLabel sexe = new JLabel("Sexe :     ", SwingConstants.RIGHT);
        JComboBox<String> sexeTexte = new JComboBox<String>();
        sexeTexte.addItem("Choisir un sexe");
        sexeTexte.addItem("Homme");
        sexeTexte.addItem("Femme");
        sexePanel.setBackground(Color.WHITE);
        sexePanel.add(sexe);
        sexePanel.add(sexeTexte);
        
        // ajout des composants a infoPanel
        info.add(titrePanel);
        info.add(Box.createHorizontalStrut(10));
        info.add(disciplinePanel);
        info.add(Box.createHorizontalStrut(10));
        info.add(epreuvesPanel);
        info.add(Box.createHorizontalStrut(10));			// créer un espace entre chaque panel
        info.add(typePanel);
        info.add(Box.createHorizontalStrut(10));
        info.add(datePanel);
        info.add(Box.createHorizontalStrut(10));
        info.add(debutPanel);
        info.add(Box.createHorizontalStrut(10));
        info.add(dureePanel);
        info.add(Box.createHorizontalStrut(10));
        info.add(categoriePanel);
        info.add(Box.createHorizontalStrut(10));
        info.add(sexePanel);
        
        
        // panel ajouter Athlete
        // initialisation des composant de athletePanel
        JPanel athletePanel = new JPanel();
        athletePanel.setBackground(Color.WHITE);
        athletePanel.setLayout(new GridLayout(4,4));
		athletePanel.setBorder(BorderFactory.createEmptyBorder(0,40, 0, 40));
        
		JLabel athlete = new JLabel(" Athlète :");
        athlete.setHorizontalAlignment(SwingConstants.LEFT);		// aligner le texte à droite dans son Panel
        JComboBox<String> athleteTexte = new JComboBox<String>();
        athleteTexte.addItem("Choisir un athlète");
        JButton ajouterAthlete = new JButton("Ajouter");
        ajouterAthlete.setForeground(Color.white);
        ajouterAthlete.setBackground((Couleur.ROUGE_JO).getColor());
        
        // ajout des composant a athletePanel 
//        for (int i = 0; i < 4; i++) {			// ajout de panel vide est blanc pour placer correctement athletePanel
//            JPanel panel = new JPanel();
//            panel.setBackground(Color.WHITE);
//            athletePanel.add(panel);
//    }

        athletePanel.add(athlete);
        athletePanel.add(athleteTexte);	
        JPanel defaut4 = new JPanel();
        defaut4.setBackground(Color.WHITE);
        athletePanel.add(defaut4);
        athletePanel.add(ajouterAthlete);
        
        mainPanel.add(athletePanel, BorderLayout.NORTH);
        
        //JTable pour stocker les résultats
        JPanel tabPanel = new JPanel();
        tabPanel.setBackground(Color.WHITE);
        tabPanel.setLayout(new GridLayout(3,1));
        DefaultTableModel modele = new DefaultTableModel();
        JTable tableau = new JTable(modele);
        
        modele.addColumn("NomAthlete");
        modele.addColumn("PrenomAthlete");
        modele.addColumn("CodePays");
        
        modele.addRow(new Object[] {"1","2","3"});
        modele.addRow(new Object[] {"7","8","9"});
        modele.addRow(new Object[] {"1","2","3"});
        modele.addRow(new Object[] {"4","5","6"});
        modele.addRow(new Object[] {"7","8","9"});
        modele.addRow(new Object[] {"1","2","3"});
        modele.addRow(new Object[] {"4","5","6"});
        modele.addRow(new Object[] {"7","8","9"});
        modele.addRow(new Object[] {"1","2","3"});
        modele.addRow(new Object[] {"4","5","6"});
        modele.addRow(new Object[] {"7","8","9"});
        modele.addRow(new Object[] {"1","2","3"});
        modele.addRow(new Object[] {"4","5","6"});
        modele.addRow(new Object[] {"7","8","9"});
        modele.addRow(new Object[] {"1","2","3"});
        modele.addRow(new Object[] {"4","5","6"});
        modele.addRow(new Object[] {"7","8","9"});
        
        // ajout des compostant au mainJpane
        JScrollPane panneau = new JScrollPane(tableau);
        panneau.setBackground(Color.WHITE);
        panneau.setBorder(BorderFactory.createEmptyBorder(0,40, 0, 40));
        tableau.setFillsViewportHeight(true);
        JPanel defaut5 = new JPanel();
        defaut5.setBackground(Color.WHITE);
        tabPanel.add(defaut5);
        tabPanel.add(panneau);
        mainPanel.add(tabPanel, BorderLayout.CENTER);
        
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
		JFrame fenetre = new JFrame ();
		fenetre.setSize(960,540);
		fenetre.setLocationRelativeTo(null); 
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		// Creer une instance de ma classe
		ApplicationJo applicationJo = new ApplicationJo();
		
		applicationJo.recuperer();
		
		ControleurAthlete controleur = new ControleurAthlete(applicationJo);

		VueAjouterSession p = new VueAjouterSession(controleur);

		// Ajouter mon instance dans un des conteneurs de la fen?tre
		fenetre.add(p);

		// Afficher la fenetre
		fenetre.setVisible(true);
	}
}
