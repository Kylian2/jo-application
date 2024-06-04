package vues;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import vues.Couleur;
import modeles.Athlete;
import modeles.Discipline;

public class VueAjouterEquipe extends JPanel {
    protected JPanel mainPanel, titre, disciplinePanel, boutonPanel, nomEquipePanel;
    protected JLabel ajouterEquipe, discipline, nomEquipe;
    protected JTextField nomEquipeTexte;
    protected JButton annuler, enregistrer;
    protected JComboBox<String> disciplineTexte;
    protected ArrayList<Discipline> disciplinesList;

    VueAjouterEquipe() {
        setLayout(new BorderLayout());

        // initialisation des panel globaux
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3,1));
        mainPanel.setPreferredSize(new Dimension(400,600));
        
        titre = new JPanel();
        titre.setLayout(new GridBagLayout());
        
        // initialisation des sous-JPanel
        disciplinePanel = new JPanel();
        disciplinePanel.setLayout(new BorderLayout());
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();  	// recupere la taille de la fenete pour placer correctement le titre
        DisplayMode fenetreSize = gd.getDisplayMode();

        // Calculer la taille en fonction de la fenêtre active
        int taille = fenetreSize.getWidth() / 5;
        disciplinePanel.setBorder(new EmptyBorder(20, 20, taille,0)); // ajout d'une bordure vide de 20 pixels en haut et en bas

        // initialisation du JLabel + JComboBox discipline
        discipline = new JLabel("Discipline :     ");
        disciplineTexte = new JComboBox<String>();
        // ajouter discipline dans la comboBox
//        for (Discipline discipline: disciplineList) {
//        	disciplineTexte.addItem(discipline);
//        }
        disciplineTexte.addItem("Choisir une discipline");
        
        // initialisation des composant de nomEquipePanel
        nomEquipePanel = new JPanel();
        nomEquipePanel.setLayout(new GridLayout(1,2));
        nomEquipePanel.setBorder(new EmptyBorder(20, 20,150,0)); 
        
        nomEquipe = new JLabel("Nom d'équipe : ");
        nomEquipeTexte = new JTextField("Entrez un nom d'équipe");
        
        nomEquipePanel.add(nomEquipe);
        nomEquipePanel.add(nomEquipeTexte);

        // ajout des composants au disciplinePanel
        disciplinePanel.add(discipline, BorderLayout.WEST);
        disciplinePanel.add(disciplineTexte, BorderLayout.CENTER);

        // titre de la fenetre : "Ajouter une Equipe"
        ajouterEquipe = new JLabel("  Ajouter une Equipe");

        // GridBagConstraints composants
        titre.add(ajouterEquipe);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        titre.add(disciplinePanel, gbc);
        titre.add(nomEquipePanel,gbc);
        
        // initialisation des composant de boutonPanel
        boutonPanel = new JPanel();
        boutonPanel.setLayout(new GridLayout(4,4));
        boutonPanel.setBorder(new EmptyBorder(0,0,0,50));
        
        annuler = new JButton("Annuler");
        annuler.setForeground(Color.WHITE);
        annuler.setBackground(Color.GRAY);
        enregistrer = new JButton("Enregistrer");
        enregistrer.setForeground(Color.WHITE);
        enregistrer.setBackground((Couleur.ROUGE_JO).getColor());
        
        // ajout des composant à boutonPanel
        for (int i = 0; i < 4; i++) {			// ajout de panel vide est blanc pour placer correctement athletePanel
            JPanel panel = new JPanel();
            panel.setBackground(Color.WHITE);
            boutonPanel.add(panel);
    }
        boutonPanel.add(annuler);
        boutonPanel.add(enregistrer);
        
        // ajout des composants au mainPanel
		JPanel defaut = new JPanel();
		defaut.setBackground(Color.WHITE);		// création de panel vide blanc pour combler
		JPanel defaut1 = new JPanel();
		defaut1.setBackground(Color.WHITE);
		
        mainPanel.add(defaut, BorderLayout.NORTH);
        mainPanel.add(defaut1, BorderLayout.CENTER);
        mainPanel.add(boutonPanel, BorderLayout.SOUTH);

        // ajout des JPANEL principaux à la fenetre
        add(mainPanel, BorderLayout.EAST);
        add(titre, BorderLayout.WEST);

        // uniformisation du fond de la fenetre en BLANC ("Color.WHITE")
        setBackground(Color.WHITE);
        titre.setBackground(Color.WHITE);
        disciplinePanel.setBackground(Color.WHITE);
        boutonPanel.setBackground(Color.WHITE);

        // uniformisation de la police d'écriture
        ajouterEquipe.setFont(new Font("Source", Font.PLAIN, 30));
    }

    public static void main(String[] args) {
        // Creer une fenetre
        JFrame fenetre = new JFrame();
        fenetre.setSize(960, 540);
        fenetre.setLocationRelativeTo(null);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creer une instance de ma classe
        VueAjouterEquipe p = new VueAjouterEquipe();

        // Ajouter mon instance dans un des conteneurs de la fenêtre
        fenetre.add(p);

        // Afficher la fenetre
        fenetre.setVisible(true);
    }
}
