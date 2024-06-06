package vues;

import javax.swing.*; 
import java.awt.*;
import javax.swing.border.EmptyBorder;

public class VueDescriptifSession extends JPanel{
	protected JPanel PanelAnnonceEvenement, PanelDetailEvenement, DateHeurePanel, PanelInfo, PanelDesParticipants,
	PanelRemplissage1, PanelRemplissage2;
    protected JLabel NomEpreuve, TypeSerie, DateSession, HeureSession, InformationSession, GenreSession,
    Categorie, FormatSession, LieuSession, TexteDescriptif, Participant, Participant1, Participant2, Participant3,
    Participant4;
	
	public VueDescriptifSession() {
		
        // Création des Panel de haut niveau
        JPanel PanelAnnonceEvenement = new JPanel(new BorderLayout());
        JPanel PanelSession = new JPanel(new GridLayout(2, 2));

        // Création des Panel de haut niveau moyen
        JPanel PanelDetailEvenement = new JPanel(new GridLayout(2, 1));
        JPanel DateHeurePanel = new JPanel(new GridLayout(2, 1));
        JPanel PanelDesParticipants = new JPanel(new GridLayout(5, 1));
        
        // Création des Panel de bas niveau
        JPanel PanelInfo = new JPanel(new GridLayout(5, 1));
        JPanel PanelRemplissage1 = new JPanel();
        JPanel PanelRemplissage2 = new JPanel();

        // Création des Label pour PanelAnnonceEvenement
        JLabel NomEpreuve = new JLabel("KAYAK", SwingConstants.LEFT);
        NomEpreuve.setFont(new Font(NomEpreuve.getFont().getName(), Font.BOLD, 32));
        JLabel TypeSerie = new JLabel("Séries Qualificatives", SwingConstants.CENTER);
        TypeSerie.setFont(new Font("Arial", Font.ITALIC, 20));
        JLabel DateSession = new JLabel("16/07/24", SwingConstants.CENTER);
        DateSession.setFont(new Font("Arial", Font.PLAIN, 24));
        JLabel HeureSession = new JLabel("9h30 - 14h", SwingConstants.CENTER);
        HeureSession.setFont(new Font("Arial", Font.BOLD, 24));

        // Ajout dans les Panel de niveau moyen
        PanelDetailEvenement.add(NomEpreuve);
        PanelDetailEvenement.add(TypeSerie);
        PanelAnnonceEvenement.add(PanelDetailEvenement, BorderLayout.WEST);
        PanelDetailEvenement.setBorder(BorderFactory.createEmptyBorder(0, 40, 0, 0));
        
        DateHeurePanel.add(DateSession);
        DateHeurePanel.add(HeureSession);
        PanelAnnonceEvenement.add(DateHeurePanel, BorderLayout.EAST);
        DateHeurePanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 40));

        // Création des Label pour les informations sur la session
        JLabel InformationSession = new JLabel("Information : ", SwingConstants.LEFT);
        InformationSession.setFont(new Font("Arial", Font.BOLD, 14));
        JLabel GenreSession = new JLabel("Sexe : Homme", SwingConstants.LEFT);
        GenreSession.setFont(new Font("Arial", Font.PLAIN, 14));
        JLabel Categorie = new JLabel("Catégorie : Aucune", SwingConstants.LEFT);
        Categorie.setFont(new Font("Arial", Font.PLAIN, 14));
        JLabel FormatSession = new JLabel("Format : Sprint", SwingConstants.LEFT);
        FormatSession.setFont(new Font("Arial", Font.PLAIN, 14));
        JLabel LieuSession = new JLabel("Lieu : Base Nautique de Vaires-sur-Marne", SwingConstants.LEFT);
        LieuSession.setFont(new Font("Arial", Font.PLAIN, 14));

        // Ajout dans les Panel de bas niveau
        PanelInfo.add(InformationSession);
        PanelInfo.add(GenreSession);
        PanelInfo.add(Categorie);
        PanelInfo.add(FormatSession);
        PanelInfo.add(LieuSession);
        PanelInfo.setBorder(BorderFactory.createEmptyBorder(60, 40, 0, 0));


        // Création des Label pour les athlètes de la session
        JLabel Participant = new JLabel("Participants : ", SwingConstants.LEFT);
        Participant.setFont(new Font("Arial", Font.BOLD, 14));

        JLabel Participant1 = new JLabel("Teddy Riner", SwingConstants.LEFT);
        Participant1.setFont(new Font("Arial", Font.PLAIN, 14));
        Participant1.add(Box.createVerticalStrut(100));

        JLabel Participant2 = new JLabel("Michal Smolen", SwingConstants.LEFT);
        Participant2.setFont(new Font("Arial", Font.PLAIN, 14));

        JLabel Participant3 = new JLabel("Lucien Delfour", SwingConstants.LEFT);
        Participant3.setFont(new Font("Arial", Font.PLAIN, 14));

        JLabel Participant4 = new JLabel("Boris Neveu", SwingConstants.LEFT);
        Participant4.setFont(new Font("Arial", Font.PLAIN, 14));

        // Ajout dans les Panel de niveau moyen
        PanelDesParticipants.add(Participant);
        PanelDesParticipants.add(Participant1);
        PanelDesParticipants.add(Participant2);
        PanelDesParticipants.add(Participant3);
        PanelDesParticipants.add(Participant4);
        PanelDesParticipants.setBorder(BorderFactory.createEmptyBorder(60, 60, 0, 0));

        // Ajout dans le Panel de session
        PanelSession.add(PanelInfo);
        PanelSession.add(PanelDesParticipants); 
        PanelSession.add(PanelRemplissage1);
        PanelSession.add(PanelRemplissage2);

        //Changement des couleur de tous les background
      	PanelAnnonceEvenement.setBackground(Color.WHITE);
      	PanelDetailEvenement.setBackground(Color.WHITE);		
      	DateHeurePanel.setBackground(Color.WHITE);
      	PanelInfo.setBackground(Color.WHITE);
      	PanelDesParticipants.setBackground(Color.WHITE);
      	PanelRemplissage1.setBackground(Color.WHITE);
      	PanelRemplissage2.setBackground(Color.WHITE);
        
      	this.setBackground(Color.WHITE); 
        this.setLayout(new BorderLayout());
        this.add(PanelAnnonceEvenement, BorderLayout.NORTH);
        this.add(PanelSession, BorderLayout.CENTER); 
    }
		
	//Création de la JFrame
	public static void main(String[] args) {
			
		//Paramétrage de la fenêtre
		JFrame fenetre = new JFrame("Descriptif de la session");
		fenetre.setSize(960,540);
			
		//Permet de fermer la fenêtre si on appuie sur la croix en haut à gauche
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		//Création du nouveau PanelCalculatrice et ajout à le fenêtre 
		VueDescriptifSession panel = new VueDescriptifSession(); 
		fenetre.add(panel);
			
		//Rend la JFrame visible
		fenetre.setVisible(true);
	}
}