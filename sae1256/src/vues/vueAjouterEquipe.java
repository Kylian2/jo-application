package vues;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

public class vueAjouterEquipe extends JPanel {
	protected JPanel mainInfo,titrePanel, listPanel, bottomPanel, boutonPanel, athletePanel, disciplinePanel,
					titreMembres;
	protected JLabel ajouterEquipe, athlete, discipline,titreMembreLB;
	protected JTextField disciplineTexte, athleteTexte;
	protected JButton ajouterAthlete, annuler, valider;
	protected JList<String> membres;
	
	vueAjouterEquipe(){
		// déclaration
		mainInfo = new JPanel();
		mainInfo.setLayout(new GridLayout(1,3));

		titrePanel = new JPanel();
		titrePanel.setLayout(new GridLayout(2,1));
		
		ajouterEquipe = new JLabel("Ajouter une Equipe");
		
		disciplinePanel = new JPanel();
		disciplinePanel.setLayout(new GridLayout(3,2));
		
		discipline = new JLabel("Discipline :");
		
		disciplineTexte = new JTextField("Choisir une discipline");
		disciplineTexte.setPreferredSize( new Dimension( 200, 24 ) );
		
		athletePanel = new JPanel();
		athletePanel.setLayout(new GridLayout(5,2));
		
		athlete = new JLabel("Athlète : ");
		athleteTexte = new JTextField("Choisir un athlète");
		
		ajouterAthlete = new JButton("Ajouter");
		ajouterAthlete.setBackground(Color.RED);
		ajouterAthlete.setForeground(Color.WHITE);
		
		titreMembres = new JPanel();
		titreMembres.setLayout(new BorderLayout());
		titreMembreLB = new JLabel("Membres de l'équipe");
		
		listPanel = new JPanel();
		listPanel.setLayout(new GridLayout(1,2));
		
		membres = new JList<String>();
		
		bottomPanel = new JPanel();
		bottomPanel.setLayout(new GridLayout(3,8));
		
		annuler = new JButton("Annuler");
		annuler.setBackground(Color.RED);
		annuler.setForeground(Color.WHITE);
		valider = new JButton("Enregistrer");
		valider.setBackground(Color.GRAY);
		
		// ajout des panel dans la fenetre
		this.setLayout(new GridLayout(3,1));
		
		disciplinePanel.add(new JPanel());
		disciplinePanel.add(new JPanel()); 	// panel vide 
		disciplinePanel.add(discipline);
		disciplinePanel.add(disciplineTexte);
		
		athletePanel.add(new JPanel());
		athletePanel.add(new JPanel());
		athletePanel.add(new JPanel());
		athletePanel.add(new JPanel());
		athletePanel.add(athlete);
		athletePanel.add(athleteTexte);
		athletePanel.add(new JPanel());
		athletePanel.add(ajouterAthlete);
		
		titrePanel.add(ajouterEquipe);
		titrePanel.add(disciplinePanel);
		
		JPanel rightAlignPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	    rightAlignPanel.add(titreMembreLB);
	    titreMembres.add(rightAlignPanel, BorderLayout.SOUTH);				// afficher le titre de membres en bas à droit du panel

		mainInfo.add(titrePanel);
		mainInfo.add(titreMembres);
		mainInfo.add(athletePanel);
		
		listPanel.add(new JPanel());
		listPanel.add(membres);
		
		bottomPanel.add(new JPanel());
		bottomPanel.add(new JPanel());
		bottomPanel.add(new JPanel());
		bottomPanel.add(new JPanel());
		bottomPanel.add(new JPanel());
		bottomPanel.add(new JPanel());
		bottomPanel.add(valider);
		bottomPanel.add(annuler);


		add(mainInfo);
		add(listPanel);
		add(bottomPanel);
		
		//uniformisation de la police d'écriture
		ajouterEquipe.setFont(new Font("Source", Font.PLAIN, 30));
		discipline.setFont(new Font("Source", Font.PLAIN, 20));
		athlete.setFont(new Font("Source", Font.PLAIN, 20));
		titreMembreLB.setFont(new Font("Source", Font.PLAIN, 20));
		
		 
		// border for debug (SUPPRIMER)
		/*
		titrePanel.setBorder(BorderFactory.createLineBorder(Color.black));
		ajouterEquipe.setBorder(BorderFactory.createLineBorder(Color.green));
		mainInfo.setBorder(BorderFactory.createLineBorder(Color.red));
		disciplinePanel.setBorder(BorderFactory.createLineBorder(Color.blue));*/
	}
	
	public static void main(String[] args) {
		// Creer une fenetre
		JFrame fenetre = new JFrame ();
		fenetre.setSize(960,540);
		fenetre.setLocationRelativeTo(null); 
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Creer une instance de ma classe
		vueAjouterEquipe p = new vueAjouterEquipe();

		// Ajouter mon instance dans un des conteneurs de la fen?tre
		fenetre.add(p);

		// Afficher la fenetre
		fenetre.setVisible(true);
	}
}
