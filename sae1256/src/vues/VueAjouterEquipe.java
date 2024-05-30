package vues;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import modeles.Discipline;

public class VueAjouterEquipe extends JPanel {
    protected JPanel mainPanel, titre, disciplinePanel, athletePanel, membrePanel, boutonPanel;
    protected JLabel ajouterEquipe, athlete, discipline, titreMembreLB;
    protected JButton ajouterAthlete, annuler, valider;
    protected JComboBox disciplineTexte;
    protected JList<String> membres;
    protected ArrayList<Discipline> disciplinesList;

    VueAjouterEquipe() {
        setLayout(new BorderLayout());

        // initialisation des panel globaux
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout());
        
        titre = new JPanel();
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
        disciplineTexte = new JComboBox();
        disciplineTexte.addItem("Choisir une discipline");

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
        
        // initialisation des composant de mainPanel
        athletePanel = new JPanel();
       
        // JPanel choisir ahlete
        
        
        membrePanel = new JPanel();
        
        boutonPanel = new JPanel();
        
        // ajout des composants au mainPanel
        mainPanel.add(athletePanel, BorderLayout.NORTH);
        mainPanel.add(membrePanel, BorderLayout.CENTER);
        mainPanel.add(boutonPanel, BorderLayout.SOUTH);

        // ajout des JPANEL principaux à la fenetre
        add(mainPanel, BorderLayout.EAST);
        add(titre, BorderLayout.WEST);

        // uniformisation du fond de la fenetre en BLANC ("Color.WHITE")
        setBackground(Color.WHITE);
//        titre.setBackground(Color.WHITE);
//        disciplinePanel.setBackground(Color.WHITE);
        athletePanel.setBackground(Color.RED);
        membrePanel.setBackground(Color.BLUE);
        boutonPanel.setBackground(Color.GREEN);

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
