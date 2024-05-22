package vues;
import java.awt.*;
import javax.swing.*;

public class interfaceAjouterAthlete extends JPanel{

	interfaceAjouterAthlete(){
		// ajouterAthlete
		JLabel ajouterAthlete = new JLabel("Ajouter un Athlète");
		
		//Nom - deleg - discipline
		JLabel nomDelegDiscip = new JLabel();
		nomDelegDiscip.setPreferredSize(new Dimension(400,50));
		
		
		//ajout
		add(ajouterAthlete);
		add(nomDelegDiscip);
	}
	
	public static void main(String[] args) {
		// Creer une fenetre
		JFrame fenetre = new JFrame ();
		fenetre.setSize(960,540);
		fenetre.setLocationRelativeTo(null); 
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Creer une instance de ma classe
		interfaceAjouterAthlete p = new interfaceAjouterAthlete ();
		
		// Ajouter mon instance dans un des conteneurs de la fen?tre
		fenetre.add(p);
		
		// Afficher la fenetre
		fenetre.setVisible(true);
	}
}
