package vues;

import java.awt.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * La classe VuePlanning represente une interface graphique de planning pour afficher et gerer les sessions.
 */
public class VuePlanning extends JPanel {

    protected JPanel topPanel, middlePanel, bottomPanel;
    protected JLabel nomPlanning, nom, code;
    protected JTextField nomTexte, codeTexte;
    protected JButton precedent, suivant, ajouterSession;

    /**
     * Constructeur par defaut de la classe VuePlanning.
     * Initialise l'interface utilisateur avec une disposition en grille et ajoute les composants necessaires.
     */
    public VuePlanning() {
        setLayout(new GridLayout(8, 1, 0, 5));

        // Definir le panel de la ligne n°1
        topPanel = new JPanel(new GridLayout(1, 3));
        topPanel.setBackground(Color.WHITE);

        // Definir le panel de droite du panel de la ligne n°1
        JPanel top_1 = new JPanel(new GridLayout(1, 3));
        top_1.setBackground(Color.WHITE);

        // Definir 2 panneaux qui permettent de placer le bouton a gauche et limiter sa taille
        JPanel top_1_1 = new JPanel();
        top_1_1.setBackground(Color.WHITE);
        JPanel top_1_2 = new JPanel();
        top_1_2.setBackground(Color.WHITE);

        // Definir et ajouter le bouton de gauche du panel de la ligne n°1
        precedent = new JButton("<");
        precedent.setBorder(BorderFactory.createEmptyBorder());
        precedent.setFont(new Font("Source", Font.BOLD, 23));
        precedent.setBackground(Color.WHITE);
        top_1.add(top_1_1);
        top_1.add(top_1_2);
        top_1.add(precedent);

        // Ajouter le panel de gauche au panel de la ligne n°1
        topPanel.add(top_1);

        // Definir le label du centre du panel du haut
        nomPlanning = new JLabel("     Planning du 29/07/24");
        nomPlanning.setFont(new Font(nomPlanning.getFont().getName(), Font.BOLD, 23));
        topPanel.add(nomPlanning);

        // Definir le panel de droite du panel de la ligne n°1
        JPanel top_2 = new JPanel(new GridLayout(1, 3));
        top_2.setBackground(Color.WHITE);
        JPanel top_2_1 = new JPanel();
        top_2_1.setBackground(Color.WHITE);
        JPanel top_2_2 = new JPanel();
        top_2_2.setBackground(Color.WHITE);
        suivant = new JButton(">");
        suivant.setBorder(BorderFactory.createEmptyBorder());
        suivant.setFont(new Font("Source", Font.BOLD, 23));
        suivant.setBackground(Color.WHITE);
        top_2.add(suivant);
        top_2.add(top_2_1);
        top_2.add(top_2_2);

        // Ajouter le panel de droite au panel de la ligne n°1
        topPanel.add(top_2);

        // Ajouter le panel du haut a la fenetre
        add(topPanel);
        
        // Creer le panel de la ligne n°2
        JPanel heures = new JPanel(new GridLayout(1, 6));
        heures.setBackground(Color.WHITE);
        
        // Creer les labels des heures
        JLabel heure_9 = new JLabel("  9h", SwingConstants.LEFT);
        heure_9.setFont(new Font("Source", Font.PLAIN, 15));
        
        JLabel heure_10 = new JLabel("    10h", SwingConstants.LEFT);
        heure_10.setFont(new Font("Source", Font.PLAIN, 15));
        
        JLabel heure_11 = new JLabel("11h", SwingConstants.CENTER);
        heure_11.setFont(new Font("Source", Font.PLAIN, 15));
        
        JLabel heure_12 = new JLabel("12h", SwingConstants.CENTER);
        heure_12.setFont(new Font("Source", Font.PLAIN, 15));
        
        JLabel heure_13 = new JLabel("13h", SwingConstants.CENTER);
        heure_13.setFont(new Font("Source", Font.PLAIN, 15));
        
        JLabel heure_14 = new JLabel("14h", SwingConstants.CENTER);
        heure_14.setFont(new Font("Source", Font.PLAIN, 15));
        
        JLabel heure_15 = new JLabel("15h", SwingConstants.CENTER);
        heure_15.setFont(new Font("Source", Font.PLAIN, 15));
        
        // Ajouter les labels au panel des heures
        heures.add(heure_9);
        heures.add(heure_10);
        heures.add(heure_11);
        heures.add(heure_12);
        heures.add(heure_13);
        heures.add(heure_14);
        heures.add(heure_15);
        
        // Definir et ajouter les autres composants
        add(heures);

        JPanel session_1 = createSessionPanel(Color.BLUE, "KAYAK - Sprint", "Series qualificatives", "9h00 - 14h00", "Base Nautique de Vaires-Sur-Marne", 0, 20, 0, 190);
        add(session_1);

        JPanel session_2 = createSessionPanel(Color.ORANGE, "NATATION - 200 4N", "Series qualificatives", "9h30 - 14h30", "Piscine George Valerey", 0, 90, 0, 110);
        add(session_2);

        JPanel session_3 = createSessionPanel(Color.RED, "NATATION - 100m", "Series qualificatives", "10h00 - 15h00", "Piscine George Valerey", 0, 150, 0, 60);
        add(session_3);

        JPanel session_4 = createSessionPanel(Color.GREEN, "NATATION", "Series qualificatives", "10h00 - 14h00", "Piscine George Valerey", 0, 150, 0, 190);
        add(session_4);

        JPanel session_5 = createSessionPanel(Color.CYAN, "Aviron", "Series qualificatives", "9h30 - 15h00", "Stade Nautique de Vaires-sur-Marne", 0, 90, 0, 60);
        add(session_5);

        bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBackground(Color.WHITE);
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 635, 15, 40));
        ajouterSession = new JButton("Ajouter une session");
        ajouterSession.setFont(new Font("Source", Font.BOLD, 13));
        ajouterSession.setBackground(Color.GRAY);
        ajouterSession.setForeground(Color.WHITE);
        ajouterSession.setPreferredSize(new Dimension(70, 40));
        bottomPanel.add(ajouterSession);
        add(bottomPanel);

        // Centre les sessions sur l'ecran
        setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 30));
        setBackground(Color.WHITE);

        // Ajouter les ecouteurs sur les boutons
        EcouteurImbrique ecouteur = new EcouteurImbrique();
        precedent.addActionListener(ecouteur);
        suivant.addActionListener(ecouteur);
        ajouterSession.addActionListener(ecouteur);
    }

    /**
     * Cree un panneau de session avec les proprietes specifiees.
     *
     * @param color La couleur de fond du panneau.
     * @param title Le titre de la session.
     * @param subtitle Le sous-titre de la session.
     * @param time Le creneau horaire de la session.
     * @param location Le lieu de la session.
     * @param top Marge superieure.
     * @param left Marge gauche.
     * @param bottom Marge inferieure.
     * @param right Marge droite.
     * @return Un panneau JPanel configure avec les parametres specifies.
     */
    private JPanel createSessionPanel(Color color, String title, String subtitle, String time, String location, int top, int left, int bottom, int right) {
        JPanel sessionPanel = new JPanel(new GridLayout(1, 1));
        sessionPanel.setBorder(BorderFactory.createEmptyBorder(top, left, bottom, right));
        sessionPanel.setBackground(Color.WHITE);
        JPanel sessionContent = new JPanel(new BorderLayout());
        sessionContent.setBackground(color);
        sessionPanel.add(sessionContent);

        JPanel westPanel = new JPanel(new BorderLayout());
        westPanel.setBackground(color);
        JPanel eastPanel = new JPanel(new BorderLayout());
        eastPanel.setBackground(color);

        JLabel titleLabel = new JLabel("  " + title, SwingConstants.LEFT);
        titleLabel.setFont(new Font("Source", Font.PLAIN, 17));
        titleLabel.setForeground(Color.WHITE);
        JLabel subtitleLabel = new JLabel("  " + subtitle, SwingConstants.LEFT);
        subtitleLabel.setFont(new Font("Source", Font.PLAIN, 17));
        subtitleLabel.setForeground(Color.WHITE);
        westPanel.add(titleLabel, BorderLayout.NORTH);
        westPanel.add(subtitleLabel, BorderLayout.SOUTH);

        JLabel timeLabel = new JLabel(time + "  ", SwingConstants.RIGHT);
        timeLabel.setFont(new Font("Source", Font.PLAIN, 17));
        timeLabel.setForeground(Color.WHITE);
        JLabel locationLabel = new JLabel(location + "  ", SwingConstants.RIGHT);
        locationLabel.setFont(new Font("Source", Font.PLAIN, 17));
        locationLabel.setForeground(Color.WHITE);
        eastPanel.add(timeLabel, BorderLayout.NORTH);
        eastPanel.add(locationLabel, BorderLayout.SOUTH);

        sessionContent.add(westPanel, BorderLayout.WEST);
        sessionContent.add(eastPanel, BorderLayout.EAST);

        return sessionPanel;
    }

    /**
     * Ecouteur pour les actions des boutons.
     */
    private class EcouteurImbrique implements ActionListener {

        /**
         * Action a effectuer lorsque l'un des boutons est clique.
         *
         * @param e L'evenement d'action.
         */
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equalsIgnoreCase("Ajouter une session")) {
                System.out.println("Ajouter une session...");
                System.out.println("#va sur la page ajouter session.");
            }
            if (e.getActionCommand().equalsIgnoreCase("<")) {
                System.out.println("Jour precedent...");
                System.out.println("#retour au jour precedent.");
            }
            if (e.getActionCommand().equalsIgnoreCase(">")) {
                System.out.println("Jour suivant...");
                System.out.println("#va au jour suivant.");
            }
        }
    }

    /**
     * Methode principale pour executer l'application.
     *
     * @param args Arguments de ligne de commande.
     */
    public static void main(String[] args) {
        // Creer une fenetre
        JFrame fenetre = new JFrame();
        fenetre.setTitle("Connexion");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setSize(960, 540);
        fenetre.setLocationRelativeTo(null);
        fenetre.setResizable(true);

        // Creer une instance de VuePlanning et l'ajouter a la fenetre
        VuePlanning vuePlanning = new VuePlanning();
        fenetre.add(vuePlanning);

        // Afficher la fenetre
        fenetre.setVisible(true);
    }
}
