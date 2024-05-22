package vues;
import java.awt.*;
import javax.swing.*;

public class interfaceAjouterAthlete extends JPanel{

	interfaceAjouterAthlete(){
		// ajouterAthlete
		JPanel top = new JPanel();
		JLabel ajouterAthlete = new JLabel("Ajouter un Athlète");
		
		
		//Nom - deleg - discipline
		JPanel mainInfo = new JPanel();
		
		JPanel nomPanel = new JPanel();
		JPanel delegPanel = new JPanel();
		JPanel discipPanel = new JPanel();
		
		JLabel nom = new JLabel("Nom :");
		JTextField nomTexte = new JTextField(12); 
		JLabel deleg = new JLabel("Délégation :");
		JTextField delegTexte = new JTextField(12); 
		JLabel discip = new JLabel("Discipline :");
		JTextField discipTexte = new JTextField(12); 
		
		
		//ajout
		top.setLayout(new GridLayout(2, 1));
		mainInfo.setLayout(new GridLayout(1,3));
		
		nomPanel.add(nom);
		nomPanel.add(nomTexte);
		
		delegPanel.add(deleg);
		delegPanel.add(delegTexte);
		
		discipPanel.add(discip);
		discipPanel.add(discipTexte);
		
		mainInfo.add(nomPanel);
		mainInfo.add(delegPanel);
		mainInfo.add(discipPanel);
		
		top.add(ajouterAthlete);
		top.add(mainInfo);
		
		add(top);
		
		
		ajouterAthlete.setFont(new Font("Source", Font.PLAIN, 30));

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
