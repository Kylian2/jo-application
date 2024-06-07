package vues;

import java.awt.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import controleurs.ControleurAthlete;
import controleurs.ControleurSession;
import controleurs.*;
import sae1256.*;
import modeles.*;

/**
 * La classe VuePlanning represente une interface graphique de planning pour afficher et gerer les sessions.
 * 
 * @author Mathieu_GUIBORAT--BOST
 */
public class VuePlanning extends JPanel {

	protected final static String L9_00 = "0900";
	protected final static String L9_30 = "0930";
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

	protected final static String R9_30 = "09:30";
	protected final static String R10_00 = "10:00";
	protected final static String R10_30 = "10:30";
	protected final static String R11_00 = "11:00";
	protected final static String R11_30 = "11:30";
	protected final static String R12_00 = "12:00";
	protected final static String R12_30 = "12:30";
	protected final static String R13_00 = "13:00";
	protected final static String R13_30 = "13:30";
	protected final static String R14_00 = "14:00";
	protected final static String R14_30 = "14:30";
	protected final static String R15_00 = "15:00";

	private static final Map<String, Integer> leftCoordMap = new HashMap<>();
	private static final Map<String, Integer> rightCoordMap = new HashMap<>();

	static {
		leftCoordMap.put(L9_00, 45);
		leftCoordMap.put(L9_30, 100);
		leftCoordMap.put(L10_00, 140);
		leftCoordMap.put(L10_30, 190);
		leftCoordMap.put(L11_00, 235);
		leftCoordMap.put(L11_30, 290);
		leftCoordMap.put(L12_00, 335);
		leftCoordMap.put(L12_30, 380);
		leftCoordMap.put(L13_00, 430);
		leftCoordMap.put(L13_30, 475);
		leftCoordMap.put(L14_00, 520);
		leftCoordMap.put(L14_30, 570);

		rightCoordMap.put(R9_30, 570);
		rightCoordMap.put(R10_00, 520);
		rightCoordMap.put(R10_30, 475);
		rightCoordMap.put(R11_00, 430);
		rightCoordMap.put(R11_30, 380);
		rightCoordMap.put(R12_00, 335);
		rightCoordMap.put(R12_30, 280);
		rightCoordMap.put(R13_00, 235);
		rightCoordMap.put(R13_30, 190);
		rightCoordMap.put(R14_00, 140);
		rightCoordMap.put(R14_30, 90);
		rightCoordMap.put(R15_00, 50);
	}

	private static final int MAX_SESSIONS = 5;

	protected JPanel topPanel, middlePanel, bottomPanel;
	protected JLabel nomPlanning, nom, code;
	protected JTextField nomTexte, codeTexte;
	protected JButton precedent, suivant, ajouterSession;
	protected LocalDate date;

	ControleurSession controleur;

	/**
	 * Constructeur de la classe VuePlanning.
	 * Initialise l'interface utilisateur avec une disposition en grille et ajoute les composants necessaires.
	 * @param controleur Controleur pour gerer les actions de la vue
	 * @param date Date pour laquelle afficher le planning
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
		JLabel heure_9 = new JLabel("9h", SwingConstants.CENTER);
		heure_9.setFont(new Font("Source", Font.PLAIN, 15));

		JLabel heure_10 = new JLabel("10h", SwingConstants.CENTER);
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
				Color couleur = Couleur.BLEU_JO.getColor();
				if (i == 1){
					couleur = Couleur.JAUNE_JO.getColor();
				}
				if (i == 2){
					couleur = Couleur.ROUGE_JO.getColor();
				}
				if (i >= 3){
					couleur = Couleur.VERT_JO.getColor();
				}
				JPanel session = createSessionPanel(couleur, sesSessions.get(i));
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
		bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 430, 10, 20));
		ajouterSession = new JButton("Ajouter une session");
		ajouterSession.setFocusPainted(false);
		ajouterSession.setFont(new Font("Source", Font.BOLD, 13));
		ajouterSession.setBackground(Color.GRAY);
		ajouterSession.setForeground(Color.WHITE);
		ajouterSession.setPreferredSize(new Dimension(70, 40));
		bottomPanel.add(ajouterSession);
		add(bottomPanel);

		// Centre les sessions sur l'ecran
		setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
		setBackground(Color.WHITE);

		// Ajouter les ecouteurs sur les boutons
		EcouteurImbrique ecouteur = new EcouteurImbrique();
		precedent.addActionListener(ecouteur);
		suivant.addActionListener(ecouteur);
		ajouterSession.addActionListener(ecouteur);
	}

	/**
	 * Cree une ligne de session avec les informations de la session.
	 * @param session La session pour laquelle creer une ligne
	 * @param couleur La couleur de la ligne
	 */
	private JPanel createSessionPanel(Color color, Session session){

		String titre = session.getEpreuve().getDiscipline().getNom();
		String subtitle = session.getEpreuve().getNom();
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
		sessionContent.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		sessionContent.setBackground(color);
		sessionPanel.add(sessionContent);
		
		sessionPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	controleur.application.mainPanel.removeAll();
            	controleur.setLastPanel(VuePlanning.this);
            	controleur.application.mainPanel.add(new VueDescriptifSession(controleur, session));
                // Rafraîchir le conteneur
            	controleur.application.mainPanel.revalidate();
            	controleur.application.mainPanel.repaint();
            }
        });

		JPanel westPanel = new JPanel(new BorderLayout());
		westPanel.setBackground(color);
		JPanel eastPanel = new JPanel(new BorderLayout());
		eastPanel.setBackground(color);

		JLabel titleLabel = new JLabel(titre, SwingConstants.LEFT);
		titleLabel.setFont(new Font("Source", Font.PLAIN, 17));
		titleLabel.setForeground(Color.WHITE);
		JLabel subtitleLabel = new JLabel(subtitle, SwingConstants.LEFT);
		subtitleLabel.setFont(new Font("Source", Font.PLAIN, 17));
		subtitleLabel.setForeground(Color.WHITE);
		westPanel.add(titleLabel, BorderLayout.NORTH);
		westPanel.add(subtitleLabel, BorderLayout.SOUTH);

		JLabel timeLabel = new JLabel(time + " - " + session.calculerHeureFin(), SwingConstants.RIGHT);		
		timeLabel.setFont(new Font("Source", Font.PLAIN, 17));
		timeLabel.setForeground(Color.WHITE);
		JLabel locationLabel = new JLabel(location, SwingConstants.RIGHT);
		locationLabel.setFont(new Font("Source", Font.PLAIN, 17));
		locationLabel.setForeground(Color.WHITE);
		eastPanel.add(timeLabel, BorderLayout.NORTH);
		eastPanel.add(locationLabel, BorderLayout.SOUTH);

		sessionContent.add(westPanel, BorderLayout.WEST);
		sessionContent.add(eastPanel, BorderLayout.EAST);

		return sessionPanel;
	}

	private int coordLeft(String heuresDebut) {
		return leftCoordMap.getOrDefault(heuresDebut, 45);
	}

	private int coordRight(String heuresFin) {
		return rightCoordMap.getOrDefault(heuresFin, 50);
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

				controleur.application.mainPanel.removeAll();
				controleur.setLastPanel(VuePlanning.this);
				controleur.application.mainPanel.add(new VueAjouterSession(controleur));
				// Rafraîchir le conteneur
				controleur.application.mainPanel.revalidate();
				controleur.application.mainPanel.repaint();

			}
			if (e.getActionCommand().equalsIgnoreCase("<")) {
				if (date.isAfter(LocalDate.of(2024, 7, 24))){
					controleur.application.mainPanel.removeAll();
					controleur.setLastPanel(VuePlanning.this);
					controleur.application.mainPanel.add(new VuePlanning(controleur, date.minusDays(1)));
					// Rafraîchir le conteneur
					controleur.application.mainPanel.revalidate();
					controleur.application.mainPanel.repaint();
				}
			}
			if (e.getActionCommand().equalsIgnoreCase(">")) {
				if (date.isBefore(LocalDate.of(2024, 8, 11))){
					controleur.application.mainPanel.removeAll();
					controleur.setLastPanel(VuePlanning.this);
					controleur.application.mainPanel.add(new VuePlanning(controleur, date.plusDays(1)));
					// Rafraîchir le conteneur
					controleur.application.mainPanel.revalidate();
					controleur.application.mainPanel.repaint();
				}
			}
		}
	}
}
