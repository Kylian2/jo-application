package vues;

import java.awt.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.LineBorder;

import controleurs.ControleurEquipe;

public class VuePlanning extends JPanel {

    protected JPanel topPanel, middlePanel, bottomPanel;
    protected JLabel nomPlanning, nom, code;
    protected JTextField nomTexte, codeTexte;
    protected JButton precedent, suivant, ajouterSession;

    protected ControleurSession controleur;
    
    VuePlanning(ControleurSession controleur)
    {
    	setLayout(new GridLayout(8, 1, 0, 5));
    	
    	
    	// -----------------------------------
    	// Définir le panel de la ligne n°1
    	topPanel = new JPanel(new GridLayout(1,3));
    	topPanel.setBackground(Color.WHITE);
    	
    	// Définir le panel de droite du panel de la ligne n°1
    	JPanel top_1 = new JPanel(new GridLayout(1,3));
    	
    	// Définir 2 lables qui permettent de placer le bouton à gauche et limité sa taille
    	JPanel top_1_1 = new JPanel();
    	top_1_1.setBackground(Color.WHITE);
    	JPanel top_1_2 = new JPanel();
    	top_1_2.setBackground(Color.WHITE);
    	
    	// Définir et ajouter le bouton de gauche du panel de la ligne n°1
    	precedent = new JButton("<");
    	precedent.setBorder(BorderFactory.createEmptyBorder());
    	precedent.setFont(new Font("Source", Font.BOLD, 23));
    	precedent.setBackground(Color.WHITE);
    	top_1.add(top_1_1);
    	top_1.add(top_1_2);
    	top_1.add(precedent);
    	
    	// Ajouter le panel de gauche au panel de la ligne n°1
    	topPanel.add(top_1);
    	
    	// Définir le label du centre du panel du haut
    	nomPlanning = new JLabel("     Planning du 29/07/24");
    	nomPlanning.setFont(new Font(nomPlanning.getFont().getName(), Font.BOLD, 23));
    	topPanel.add(nomPlanning);
    	
    	// Définir le panel de droite du panel de la ligne n°1
    	JPanel top_2 = new JPanel(new GridLayout(1,3));
    	// Définir 2 lables qui permettent de placer le bouton à gauche et limité sa taille
    	JPanel top_2_1 = new JPanel();
    	top_2_1.setBackground(Color.WHITE);
    	JPanel top_2_2 = new JPanel();
    	top_2_2.setBackground(Color.WHITE);
    	// Définir et ajouter le bouton de droite du panel de la ligne n°1
    	suivant = new JButton(">");
    	suivant.setBorder(BorderFactory.createEmptyBorder());
    	suivant.setFont(new Font("Source", Font.BOLD, 23));
    	suivant.setBackground(Color.WHITE);
    	top_2.add(suivant);
    	top_2.add(top_2_1);
    	top_2.add(top_2_2);
    	
    	// Ajouter le panel de droite au panel de la ligne n°1
    	topPanel.add(top_2);
    	// -----------------------------------
    	
    	
    	
    	// -----------------------------------
    	JLabel heures = new JLabel("    9h                            10h                            11h                            12h                          13h                            14h                            15h  ");
    	heures.setFont(new Font("Source", Font.PLAIN, 15));
    	
    	// -----------------------------------
    	
    	
    	
    	
    	
    	// -----------------------------------
    	// Définir le panel de la ligne n°2
    	JPanel session_1 = new JPanel(new GridLayout(1,1));
    	session_1.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 190));
    	session_1.setBackground(Color.WHITE);
    	JPanel kayak = new JPanel(new BorderLayout());
    	kayak.setBackground(Color.BLUE);
    	
    	// Ajouter le panel kayak au panel de la session_1
    	session_1.add(kayak);
    	
    	// Définir les 2 panels du panel de la ligne n°2
    	JPanel kayak_west = new JPanel();
    	kayak_west.setBackground(Color.BLUE);
    	kayak_west.setLayout(new BorderLayout());
    	
    	JPanel kayak_east = new JPanel(new BorderLayout());
    	kayak_east.setBackground(Color.BLUE);
    	
    	// Définir les labels pour le panel de gauche de kayak
    	JLabel kayak_1 = new JLabel("  KAYAK - Sprint", SwingConstants.LEFT);
    	kayak_1.setFont(new Font("Source", Font.PLAIN, 17));
    	kayak_1.setForeground(Color.WHITE);
    	JLabel kayak_2 = new JLabel("  Séries qualificatives", SwingConstants.LEFT);
    	kayak_2.setFont(new Font("Source", Font.PLAIN, 17));
    	kayak_2.setForeground(Color.WHITE);
    	
    	// Ajouter ces labels au panel de gauche
    	kayak_west.add(kayak_1, BorderLayout.NORTH);
    	kayak_west.add(kayak_2, BorderLayout.SOUTH);
    	
    	// Définir les labels pour le panel de droite de kayak
    	JLabel kayak_3 = new JLabel("9h00 - 14h00  ", SwingConstants.RIGHT);
    	kayak_3.setFont(new Font("Source", Font.PLAIN, 17));
    	kayak_3.setForeground(Color.WHITE);
    	JLabel kayak_4 = new JLabel("Base Nautique de Vaires-Sur-Marne  ", SwingConstants.RIGHT);
    	kayak_4.setFont(new Font("Source", Font.PLAIN, 17));
    	kayak_4.setForeground(Color.WHITE);
    	
    	// Ajouter ces labels au panel de droite
    	kayak_east.add(kayak_3, BorderLayout.NORTH);
    	kayak_east.add(kayak_4, BorderLayout.SOUTH);
    	
    	// Ajouter les panels dans la ligne n°1
    	kayak.add(kayak_west, BorderLayout.WEST);
    	kayak.add(kayak_east, BorderLayout.EAST);
    	// -----------------------------------
    	
    
    	// -----------------------------------
    	// Définir le panel de la ligne n°3
    	JPanel session_2 = new JPanel(new GridLayout(1,1));
    	session_2.setBorder(BorderFactory.createEmptyBorder(0, 90, 0, 110));
    	session_2.setBackground(Color.WHITE);
    	
    	JPanel natation_1 = new JPanel(new BorderLayout());
    	session_2.add(natation_1);
    	natation_1.setBackground(Color.ORANGE);
    	
    	// Définir les 2 panels du panel de la ligne n°3
    	JPanel natation_1_west = new JPanel(new BorderLayout());
    	natation_1_west.setBackground(Color.ORANGE);
    	
    	JPanel natation_1_east = new JPanel(new BorderLayout());
    	natation_1_east.setBackground(Color.ORANGE);
    	
    	// Définir les labels pour le panel de gauche
    	JLabel natation_1_west_1 = new JLabel("  NATATION - 200 4N", SwingConstants.LEFT);
    	natation_1_west_1.setFont(new Font("Source", Font.PLAIN, 17));
    	natation_1_west_1.setForeground(Color.WHITE);
    	
    	JLabel natation_1_west_2 = new JLabel("  Séries qualificatives", SwingConstants.LEFT);
    	natation_1_west_2.setFont(new Font("Source", Font.PLAIN, 17));
    	natation_1_west_2.setForeground(Color.WHITE);
    	
    	// Ajouter ces labels au panel de gauche
    	natation_1_west.add(natation_1_west_1, BorderLayout.NORTH);
    	natation_1_west.add(natation_1_west_2, BorderLayout.SOUTH);
    	
    	// Définir les labels pour le panel de droite
    	JLabel natation_1_east_1 = new JLabel("9h30 - 14h30  ", SwingConstants.RIGHT);
    	natation_1_east_1.setFont(new Font("Source", Font.PLAIN, 17));
    	natation_1_east_1.setForeground(Color.WHITE);
    	
    	JLabel natation_1_east_2 = new JLabel("Piscine George Valerey  ", SwingConstants.RIGHT);
    	natation_1_east_2.setFont(new Font("Source", Font.PLAIN, 17));
    	natation_1_east_2.setForeground(Color.WHITE);
    	
    	// Ajouter ces labels au panel de droite
    	natation_1_east.add(natation_1_east_1, BorderLayout.NORTH);
    	natation_1_east.add(natation_1_east_2, BorderLayout.SOUTH);
    	
    	// Ajouter les panels dans la ligne n°3
    	natation_1.add(natation_1_west, BorderLayout.WEST);
    	natation_1.add(natation_1_east, BorderLayout.EAST); 	
    	// -----------------------------------
    	
    	
    	
    	// -----------------------------------
    	// Définir le panel de la ligne n°4
    	JPanel session_3 = new JPanel(new GridLayout(1,1));
    	session_3.setBorder(BorderFactory.createEmptyBorder(0, 150, 0, 60));
    	session_3.setBackground(Color.WHITE);
    	
    	JPanel natation_2 = new JPanel(new BorderLayout());
    	session_3.add(natation_2);
    	natation_2.setBackground(Color.RED);
    	
    	// Définir les 2 panels du panel de la ligne n°4
    	JPanel natation_2_west = new JPanel(new BorderLayout());
    	natation_2_west.setBackground(Color.RED);
    	
    	JPanel natation_2_east = new JPanel(new BorderLayout());
    	natation_2_east.setBackground(Color.RED);
    	
    	// Définir les labels pour le panel de gauche
    	JLabel natation_2_west_1 = new JLabel("  NATATION - 100m", SwingConstants.LEFT);
    	natation_2_west_1.setFont(new Font("Source", Font.PLAIN, 17));
    	natation_2_west_1.setForeground(Color.WHITE);
    	
    	JLabel natation_2_west_2 = new JLabel("  Séries qualificatives", SwingConstants.LEFT);
    	natation_2_west_2.setFont(new Font("Source", Font.PLAIN, 17));
    	natation_2_west_2.setForeground(Color.WHITE);
    	
    	// Ajouter ces labels au panel de gauche
    	natation_2_west.add(natation_2_west_1, BorderLayout.NORTH);
    	natation_2_west.add(natation_2_west_2, BorderLayout.SOUTH);
    	
    	// Définir les labels pour le panel de droite
    	JLabel natation_2_east_1 = new JLabel("10h00 - 15h00  ", SwingConstants.RIGHT);
    	natation_2_east_1.setFont(new Font("Source", Font.PLAIN, 17));
    	natation_2_east_1.setForeground(Color.WHITE);
    	
    	JLabel natation_2_east_2 = new JLabel("Piscine George Valerey  ", SwingConstants.RIGHT);
    	natation_2_east_2.setFont(new Font("Source", Font.PLAIN, 17));
    	natation_2_east_2.setForeground(Color.WHITE);
    	
    	// Ajouter ces labels au panel de droite
    	natation_2_east.add(natation_2_east_1, BorderLayout.NORTH);
    	natation_2_east.add(natation_2_east_2, BorderLayout.SOUTH);
    	
    	// Ajouter les panels dans la ligne n°4
    	natation_2.add(natation_2_west, BorderLayout.WEST);
    	natation_2.add(natation_2_east, BorderLayout.EAST);    	
    	// -----------------------------------
    	
    	
    	
    	// -----------------------------------
    	// Définir le panel de la ligne n°5
    	JPanel session_4 = new JPanel(new GridLayout(1,1));
    	session_4.setBorder(BorderFactory.createEmptyBorder(0, 150, 0, 190));
    	session_4.setBackground(Color.WHITE);
    	
    	JPanel natation_3 = new JPanel(new BorderLayout());
    	session_4.add(natation_3);
    	natation_3.setBackground(Color.GREEN);
    	
    	// Définir les 2 panels du panel de la ligne n°5
    	JPanel natation_3_west = new JPanel(new BorderLayout());
    	natation_3_west.setBackground(Color.GREEN);
    	
    	JPanel natation_3_east = new JPanel(new BorderLayout());
    	natation_3_east.setBackground(Color.GREEN);
    	
    	// Définir les labels pour le panel de gauche
    	JLabel natation_3_west_1 = new JLabel("  NATATION", SwingConstants.LEFT);
    	natation_3_west_1.setFont(new Font("Source", Font.PLAIN, 17));
    	natation_3_west_1.setForeground(Color.WHITE);
    	
    	JLabel natation_3_west_2 = new JLabel("  Séries qualificatives", SwingConstants.LEFT);
    	natation_3_west_2.setFont(new Font("Source", Font.PLAIN, 17));
    	natation_3_west_2.setForeground(Color.WHITE);
    	
    	// Ajouter ces labels au panel de gauche
    	natation_3_west.add(natation_3_west_1, BorderLayout.NORTH);
    	natation_3_west.add(natation_3_west_2, BorderLayout.SOUTH);
    	
    	// Définir les labels pour le panel de droite
    	JLabel natation_3_east_1 = new JLabel("10h00 - 14h00  ", SwingConstants.RIGHT);
    	natation_3_east_1.setFont(new Font("Source", Font.PLAIN, 17));
    	natation_3_east_1.setForeground(Color.WHITE);
    	
    	JLabel natation_3_east_2 = new JLabel("Piscine George Valerey  ", SwingConstants.RIGHT);
    	natation_3_east_2.setFont(new Font("Source", Font.PLAIN, 17));
    	natation_3_east_2.setForeground(Color.WHITE);
    	
    	// Ajouter ces labels au panel de droite
    	natation_3_east.add(natation_3_east_1, BorderLayout.NORTH);
    	natation_3_east.add(natation_3_east_2, BorderLayout.SOUTH);
    	
    	// Ajouter les panels dans la ligne n°4
    	natation_3.add(natation_3_west, BorderLayout.WEST);
    	natation_3.add(natation_3_east, BorderLayout.EAST);    	
    	// -----------------------------------
    	
    	
    	
    	// -----------------------------------
    	// Définir le panel de la ligne n°6
    	JPanel session_5 = new JPanel(new GridLayout(1,1));
    	session_5.setBorder(BorderFactory.createEmptyBorder(0, 90, 0, 60));
    	session_5.setBackground(Color.WHITE);
    	
    	JPanel natation_4 = new JPanel(new BorderLayout());
    	session_5.add(natation_4);
    	natation_4.setBackground(Color.CYAN);
    	
    	// Définir les 2 panels du panel de la ligne n°6
    	JPanel natation_4_west = new JPanel(new BorderLayout());
    	natation_4_west.setBackground(Color.CYAN);
    	
    	JPanel natation_4_east = new JPanel(new BorderLayout());
    	natation_4_east.setBackground(Color.CYAN);
    	
    	// Définir les labels pour le panel de gauche
    	JLabel natation_4_west_1 = new JLabel("  Aviron", SwingConstants.LEFT);
    	natation_4_west_1.setFont(new Font("Source", Font.PLAIN, 17));
    	natation_4_west_1.setForeground(Color.WHITE);
    	
    	JLabel natation_4_west_2 = new JLabel("  Séries qualificatives", SwingConstants.LEFT);
    	natation_4_west_2.setFont(new Font("Source", Font.PLAIN, 17));
    	natation_4_west_2.setForeground(Color.WHITE);
    	
    	// Ajouter ces labels au panel de gauche
    	natation_4_west.add(natation_4_west_1, BorderLayout.NORTH);
    	natation_4_west.add(natation_4_west_2, BorderLayout.SOUTH);
    	
    	// Définir les labels pour le panel de droite
    	JLabel natation_4_east_1 = new JLabel("9h30 - 15h00  ", SwingConstants.RIGHT);
    	natation_4_east_1.setFont(new Font("Source", Font.PLAIN, 17));
    	natation_4_east_1.setForeground(Color.WHITE);
    	
    	JLabel natation_4_east_2 = new JLabel("Stade Nautique de Vaires-sur-Marne  ", SwingConstants.RIGHT);
    	natation_4_east_2.setFont(new Font("Source", Font.PLAIN, 17));
    	natation_4_east_2.setForeground(Color.WHITE);
    	
    	// Ajouter ces labels au panel de droite
    	natation_4_east.add(natation_4_east_1, BorderLayout.NORTH);
    	natation_4_east.add(natation_4_east_2, BorderLayout.SOUTH);
    	
    	// Ajouter les panels dans la ligne n°4
    	natation_4.add(natation_4_west, BorderLayout.WEST);
    	natation_4.add(natation_4_east, BorderLayout.EAST);    	
    	// -----------------------------------
    	
    	
    	
    	// -----------------------------------
    	JPanel bottomPanel = new JPanel(new BorderLayout());
    	bottomPanel.setBackground(Color.WHITE);
    	bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 635, 15, 40));
    	
    	ajouterSession = new JButton ("Ajouter une session");
    	ajouterSession.setFont(new Font("Source", Font.BOLD, 13));
    	ajouterSession.setBackground(Color.GRAY);
    	ajouterSession.setForeground(Color.WHITE);
    	ajouterSession.setPreferredSize(new Dimension(70, 40)); 
    	
    	bottomPanel.add(ajouterSession);
    	
    	// -----------------------------------
    	
    	
    	
    	// Ajouter les 7 lignes à la fenêtre
    	add(topPanel);
    	add(heures);
    	add(session_1);
    	add(session_2);
    	add(session_3);
    	add(session_4);
    	add(session_5);
    	add(bottomPanel);
    	
    	// Centre les sessions sur l'écran
    	setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 30));
    	// Mettre la couleur du fond de la fenêtre en blanc
    	setBackground(Color.WHITE);
    	
    	// Ajouter les écouteurs sur les boutons
        EcouteurImbrique ecouteur = new EcouteurImbrique();
        precedent.addActionListener(ecouteur);
        suivant.addActionListener(ecouteur);
        ajouterSession.addActionListener(ecouteur);
        
    }

    private class EcouteurImbrique implements ActionListener {

        public void actionPerformed(ActionEvent e) {
        	if (e.getActionCommand().equalsIgnoreCase("Ajouter une session")) {
                System.out.println("Ajouter une session...");
                System.out.println("#va sur la page ajouter session.");
            }
            if (e.getActionCommand().equalsIgnoreCase("<")) {
                System.out.println("Jour précédent...");
                System.out.println("#retour au jour précédent.");
            }
            if (e.getActionCommand().equalsIgnoreCase(">")) {
                System.out.println("Jour suivant...");
                System.out.println("#va au jour suivant.");
            }
        }
    }

	public static void main(String[] args) {
		// Créer une fenêtre
		JFrame fenetre = new JFrame();
		fenetre.setSize(960, 540);
		fenetre.setLocationRelativeTo(null);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Créer une instance de ma classe
		VuePlanning p = new VuePlanning();

		// Ajouter mon instance dans un des conteneurs de la fenêtre
		fenetre.add(p);

		// Afficher la fenêtre
		fenetre.setVisible(true);
	}
}

