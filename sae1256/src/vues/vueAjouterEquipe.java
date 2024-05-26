package vues;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

public class vueAjouterEquipe extends JPanel {
	protected JPanel mainInfo,titrePanel, listPanel, bottomPanel, boutonPanel, athletePanel;
	protected JLabel ajouterEquipe, athlete, discipline;
	protected JTextField disciplineTexte, athleteTexte;
	protected JButton ajouterAthlete, annuler, valider;
	protected JList<String> membres;
	
	vueAjouterEquipe(){
		// déclaration
		mainInfo = new JPanel();
		mainInfo.setLayout(new GridLayout(1,2));

		titrePanel = new JPanel();
		titrePanel.setLayout(new GridLayout(2,1));
		
		ajouterEquipe = new JLabel("Ajouter une Equipe");
		Border borderEquipe = ajouterEquipe.getBorder();
		Border marginEquipe = new EmptyBorder(0,50,0,0);
		ajouterEquipe.setBorder(new CompoundBorder(borderEquipe, marginEquipe));
		
		
		
		// ajout des panel dans la fenetre
		this.setLayout(new GridLayout(3,1));
		
		titrePanel.add(ajouterEquipe);
		
		mainInfo.add(titrePanel);
		
		add(mainInfo);
		
		//uniformisation de la police d'écriture
		ajouterEquipe.setFont(new Font("Source", Font.PLAIN, 30));
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
