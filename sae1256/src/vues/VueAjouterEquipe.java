package vues;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import utilitaires.Couleur;
import modeles.Athlete;
import modeles.Discipline;

public class VueAjouterEquipe extends JPanel {
    protected JPanel mainPanel, titre, disciplinePanel, athletePanel, membrePanel, boutonPanel;
    protected JLabel ajouterEquipe, athlete, discipline, titreMembreLB;
    protected JButton ajouterAthlete, annuler, enregistrer;
    protected JComboBox<String> disciplineTexte, athleteTexte;
    protected JList<String> membres;
    protected ArrayList<Discipline> disciplinesList;
    protected ArrayList<Athlete> athletesList;

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
        
        // initialisation des composant de athletePanel
        athletePanel = new JPanel();
        athletePanel.setLayout(new GridLayout(4,4));
		athletePanel.setBorder(new EmptyBorder(50,50,20,50)); 
        
        athlete = new JLabel(" Athlète :");
        athlete.setHorizontalAlignment(SwingConstants.RIGHT);		// aligner le texte à droite dans son Panel
        athleteTexte = new JComboBox<String>();
        athleteTexte.addItem("Choisir un athlète");
        ajouterAthlete = new JButton("Ajouter");
        ajouterAthlete.setForeground(Color.white);
        ajouterAthlete.setBackground((Couleur.ROUGE_JO).getColor());
        
        // ajout des composant a athletePanel 
        for (int i = 0; i < 4; i++) {			// ajout de panel vide est blanc pour placer correctement athletePanel
            JPanel panel = new JPanel();
            panel.setBackground(Color.WHITE);
            athletePanel.add(panel);
    }

        athletePanel.add(athlete);
        athletePanel.add(athleteTexte);	
        JPanel defaut = new JPanel();
        defaut.setBackground(Color.WHITE);
        athletePanel.add(defaut);
        athletePanel.add(ajouterAthlete);
        
        // initialisation des composants de membrePanel
        membrePanel = new JPanel();
        membrePanel.setBorder(new EmptyBorder(0,0,0,50));
        
        membres = new JList<String>();
        String[] listeAthletes = new String[50];
//        for(int i =0; i< athletesList.len) {
//        	listeAthletes[]
//        }
//        membres.setListData(athlesList);
        
        // ajout des composant à membre Panel
        membrePanel.add(membres);
        
        // initialisation des composant de boutonPanel
        boutonPanel = new JPanel();
        boutonPanel.setLayout(new GridLayout(4,4));
        boutonPanel.setBorder(new EmptyBorder(0,0,0,50));
        
        annuler = new JButton("Annuler");
        annuler.setBackground((Couleur.COULEUR_FOND_JO).getColor());
        enregistrer = new JButton("Enregistrer");
        enregistrer.setForeground(Color.white);
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
        mainPanel.add(athletePanel, BorderLayout.NORTH);
        mainPanel.add(membrePanel, BorderLayout.CENTER);
        mainPanel.add(boutonPanel, BorderLayout.SOUTH);

        // ajout des JPANEL principaux à la fenetre
        add(mainPanel, BorderLayout.EAST);
        add(titre, BorderLayout.WEST);

        // uniformisation du fond de la fenetre en BLANC ("Color.WHITE")
        setBackground(Color.WHITE);
        titre.setBackground(Color.WHITE);
        disciplinePanel.setBackground(Color.WHITE);
        athletePanel.setBackground(Color.WHITE);
        athleteTexte.setBackground(Color.WHITE);
        membrePanel.setBackground(Color.blue);
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
