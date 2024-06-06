package vues;

import java.awt.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import controleurs.ControleurAthlete;
import controleurs.ControleurSession;
import sae1256.*;
import modeles.*;

/**
 * La classe VuePlanning represente une interface graphique de planning pour afficher et gerer les sessions.
 */
public class VuePlanning extends JPanel {

	protected final static String L9_00 = "900";
	protected final static String L9_30 = "930";
	protected final static String L10_00 = "1000";
	protected final static String L10_30 = "1030";
	protected final static String L11_00 = "1100";
	protected final static String L11_30 = "1130";
	protected final static String L12_00 = "1200";
	protected final static String L12_30 = "1230";
	protected final static String L13_00 = "1300";
	protected final static String L13_30 = "1330";
	protected final static String L14_00 = "1400";
	protected final static String L14_30 = "1430";

	protected final static String R9_30 = "930";
	protected final static String R10_00 = "1000";
	protected final static String R10_30 = "1030";
	protected final static String R11_00 = "1100";
	protected final static String R11_30 = "1130";
	protected final static String R12_00 = "1200";
	protected final static String R12_30 = "1230";
	protected final static String R13_00 = "1300";
	protected final static String R13_30 = "1330";
	protected final static String R14_00 = "1400";
	protected final static String R14_30 = "1430";
	protected final static String R15_00 = "1500";

	private static final Map<String, Integer> leftCoordMap = new HashMap<>();
	private static final Map<String, Integer> rightCoordMap = new HashMap<>();

	static {
		leftCoordMap.put(L9_00, 20);
		leftCoordMap.put(L9_30, 60);
		leftCoordMap.put(L10_00, 100);
		leftCoordMap.put(L10_30, 140);
		leftCoordMap.put(L11_00, 180);
		leftCoordMap.put(L11_30, 220);
		leftCoordMap.put(L12_00, 260);
		leftCoordMap.put(L12_30, 300);
		leftCoordMap.put(L13_00, 340);
		leftCoordMap.put(L13_30, 380);
		leftCoordMap.put(L14_00, 420);
		leftCoordMap.put(L14_30, 460);

		rightCoordMap.put(R9_30, 460);
		rightCoordMap.put(R10_00, 420);
		rightCoordMap.put(R10_30, 380);
		rightCoordMap.put(R11_00, 340);
		rightCoordMap.put(R11_30, 300);
		rightCoordMap.put(R12_00, 260);
		rightCoordMap.put(R12_30, 220);
		rightCoordMap.put(R13_00, 180);
		rightCoordMap.put(R13_30, 140);
		rightCoordMap.put(R14_00, 100);
		rightCoordMap.put(R14_30, 60);
		rightCoordMap.put(R15_00, 20);
	}

	private static final int MAX_SESSIONS = 5;

	protected JPanel topPanel, middlePanel, bottomPanel;
	protected JLabel nomPlanning, nom, code;
	protected JTextField nomTexte, codeTexte;
	protected JButton precedent, suivant, ajouterSession;
	protected ControleurSession controleur;
	protected LocalDate date;

	/**
	 * Constructeur par defaut de la classe VuePlanning.
	 * Initialise l'interface utilisateur avec une disposition en grille et ajoute les composants necessaires.
	 */
	public VuePlanning(ControleurSession controleur, LocalDate date) {

		this.controleur = controleur;
		this.date = date;

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
		precedent.setFocusPainted(false);
		precedent.setBorder(BorderFactory.createEmptyBorder());
		precedent.setFont(new Font("Source", Font.BOLD, 20));
		precedent.setBackground(Color.WHITE);
		top_1.add(top_1_1);
		top_1.add(top_1_2);
		top_1.add(precedent);

		// Ajouter le panel de gauche au panel de la ligne n°1
		topPanel.add(top_1);

		// Créer un formatter pour le format JJ/MM/YY
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
		
		// Definir le label du centre du panel du haut
		nomPlanning = new JLabel("Planning du " + date.format(formatter));
		nomPlanning.setFont(new Font(nomPlanning.getFont().getName(), Font.BOLD, 20));
		topPanel.add(nomPlanning);

		// Definir le panel de droite du panel de la ligne n°1
		JPanel top_2 = new JPanel(new GridLayout(1, 3));
		top_2.setBackground(Color.WHITE);
		JPanel top_2_1 = new JPanel();
		top_2_1.setBackground(Color.WHITE);
		JPanel top_2_2 = new JPanel();
		top_2_2.setBackground(Color.WHITE);
		suivant = new JButton(">");
		suivant.setFocusPainted(false);
		suivant.setBorder(BorderFactory.createEmptyBorder());
		suivant.setFont(new Font("Source", Font.BOLD, 20));
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

		add(heures);

		// Definir et ajouter les sessions
		int nbSessions = 0;

		// Intégration des sessions à l'écran
		if(controleur.getToutesSessionsDeLaDate(date) != null) {
			ArrayList<Session> sesSessions = controleur.getToutesSessionsDeLaDate(date);
			for (int i = 0 ; i < sesSessions.size() && i < MAX_SESSIONS ; i++) {
				JPanel session = createSessionPanel(sesSessions.get(i));
				add(session);
			}
			nbSessions = sesSessions.size();
		}

		if (nbSessions < MAX_SESSIONS) {
			for (int i = 0 ; i < 5 - nbSessions ; i++) {
				JPanel panel = new JPanel();
				panel.setBackground(Color.WHITE);
				add(panel);
			}
		}

		bottomPanel = new JPanel(new BorderLayout());
		bottomPanel.setBackground(Color.WHITE);
		bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 450, 10, 20));
		ajouterSession = new JButton("Ajouter une session");
		ajouterSession.setFocusPainted(false);
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
	private JPanel createSessionPanel(Session session){

		Color color = Color.BLUE;
		String titre = session.getEpreuve().getNom();
		String subtitle = session.getEpreuve().getDescription();
		String time = session.getHeureDebut();
		String location = session.getLieu();

		// Diviser la chaîne en utilisant 'h' comme séparateur
		String[] parts = time.split(":");
		// Refusionner la chaîne
		String heuresMinutes = parts[0] + parts[1];

		int left = coordLeft(heuresMinutes);
		int right = coordRight(session.calculerHeureFin());


		JPanel sessionPanel = new JPanel(new GridLayout(1, 1));
		sessionPanel.setBorder(BorderFactory.createEmptyBorder(0, left, 0, right));
		sessionPanel.setBackground(Color.WHITE);
		JPanel sessionContent = new JPanel(new BorderLayout());
		sessionContent.setBackground(color);
		sessionPanel.add(sessionContent);

		JPanel westPanel = new JPanel(new BorderLayout());
		westPanel.setBackground(color);
		JPanel eastPanel = new JPanel(new BorderLayout());
		eastPanel.setBackground(color);

		JLabel titleLabel = new JLabel("  " + titre, SwingConstants.LEFT);
		titleLabel.setFont(new Font("Source", Font.PLAIN, 17));
		titleLabel.setForeground(Color.WHITE);
		JLabel subtitleLabel = new JLabel("  " + subtitle, SwingConstants.LEFT);
		subtitleLabel.setFont(new Font("Source", Font.PLAIN, 17));
		subtitleLabel.setForeground(Color.WHITE);
		westPanel.add(titleLabel, BorderLayout.NORTH);
		westPanel.add(subtitleLabel, BorderLayout.SOUTH);

		JLabel timeLabel = new JLabel(time + " - " + session.calculerHeureFin() + "  ", SwingConstants.RIGHT);
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

	private int coordLeft(String heuresMinutes) {
		return leftCoordMap.getOrDefault(heuresMinutes, 20);
	}

	private int coordRight(String heuresMinutes) {
		return rightCoordMap.getOrDefault(heuresMinutes, 20);
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
				if (date.isAfter(LocalDate.of(2024, 7, 24))){
					
				}
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
		fenetre.setTitle("Test VuePlanning");
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setSize(700, 540);
		fenetre.setLocationRelativeTo(null);
		fenetre.setResizable(true);

		// Creer une instance de ma classe
		ApplicationJo applicationJo = new ApplicationJo();

		applicationJo.recuperer();

		// Creer une instance de VuePlanning et l'ajouter a la fenetre
		ControleurSession controleur = new ControleurSession(applicationJo);

		// Créer une instance de la classe Localdate
		LocalDate date = LocalDate.of(2024, 7, 21);

		VuePlanning vuePlanning = new VuePlanning(controleur, date);
		fenetre.add(vuePlanning);

		// Afficher la fenetre
		fenetre.setVisible(true);
		
		/*
		if (controleur.getToutesSessionOrdonnées() == null) {
			System.out.println("Aucune session existe.");
		}
		
		ArrayList<Session> sesSessions = controleur.getToutesSessionOrdonnées();
		for (Session session : sesSessions) {
			System.out.println(session.getDate());
		}
		*/
	}
}
