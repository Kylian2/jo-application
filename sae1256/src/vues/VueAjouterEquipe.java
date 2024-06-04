package vues;
import java.awt.*;
import modeles.ApplicationJo;
import modeles.Discipline;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.*;

import controleurs.ControleurEquipe;

public class VueAjouterEquipe extends JPanel{
	JPanel titrePanel, mainInfoPanel, middlePanel, bottomPanel, btnPanel;
	JLabel titre, discipline,nomEquipe;
	JTextField nomEquipeTexte;
	JButton annuler, valider;
	JComboBox<String> disciplineTexte;
	
	ControleurEquipe controleur;

	VueAjouterEquipe(ControleurEquipe controleur){
		this.controleur = controleur;
		// définition du layout principal 
		this.setLayout(new GridLayout(3,1));
		this.setBackground(Color.white);
		
		// création de JPanel vide avec fond blanc pour combler les GridLayout et uniformiser la mise en page
		JPanel defaut = new JPanel();
		defaut.setBackground(Color.WHITE);
		JPanel defaut1 = new JPanel();
		defaut1.setBackground(Color.WHITE);
		JPanel defaut2 = new JPanel();
		defaut2.setBackground(Color.WHITE);
		JPanel defaut3 = new JPanel();
		defaut3.setBackground(Color.WHITE);
		JPanel defaut4 = new JPanel();
		defaut4.setBackground(Color.WHITE);
		JPanel defaut5 = new JPanel();
		defaut5.setBackground(Color.WHITE);
		JPanel defaut6 = new JPanel();
		defaut6.setBackground(Color.WHITE);
		JPanel defaut7 = new JPanel();
		defaut7.setBackground(Color.WHITE);
		JPanel defaut8 = new JPanel();
		defaut8.setBackground(Color.WHITE);
		JPanel defaut9 = new JPanel();
		defaut9.setBackground(Color.WHITE);
		JPanel defaut10 = new JPanel();
		defaut10.setBackground(Color.WHITE);
		JPanel defaut11 = new JPanel();
		defaut11.setBackground(Color.WHITE);
		
		//////// définition du panel titre 
		titrePanel = new JPanel();
		titrePanel.setLayout(new GridLayout(3,2));
		titrePanel.setBackground(Color.white);
		
		// définition des composants du panel titre
		titre = new JLabel("Ajouter une Équipe :");	
		titre.setFont(new Font("Source", Font.PLAIN, 30)); 		// taille et style de police
		Border borderTitre = titre.getBorder();
		Border marginTitre= new EmptyBorder(0,50,0,0);
		titre.setBorder(new CompoundBorder(borderTitre, marginTitre));		// bordure invisible pour décaler titre du bord de 50px
		titre.setBackground(Color.white);
		
		// panel contenant discipline et nom equipe
		mainInfoPanel = new JPanel();
		mainInfoPanel.setLayout(new GridLayout(2,6));
		mainInfoPanel.setBackground(Color.white);
		
		// discipline 
		discipline = new JLabel("Discipline : ");		
		discipline.setFont(new Font("Source", Font.PLAIN, 15)); 		// taille et style de police
		Border borderDiscipline = discipline.getBorder();
		Border marginDiscipline= new EmptyBorder(0,50,0,0);
		discipline.setBorder(new CompoundBorder(borderDiscipline, marginDiscipline));		// bordure invisible pour décaler titre du bord de 50px
		//inserer item dans liste
		disciplineTexte = new JComboBox<String>();
		for(Discipline discipline : controleur.getDisciplines()) {
			disciplineTexte.addItem(discipline.getNom());
		}
		
		// nom d'équipe
		nomEquipe = new JLabel("Nom de l'équipe :");
		nomEquipe.setFont(new Font("Source", Font.PLAIN, 15)); 		// taille et style de police
		nomEquipeTexte = new JTextField("Entrez le nom de l\'équipe");
		
		// ajout des composants au panel discipline
		mainInfoPanel.add(discipline);
		mainInfoPanel.add(disciplineTexte);
		mainInfoPanel.add(defaut7);			// panel vide pour combler et décaller les composants suivant
		mainInfoPanel.add(nomEquipe);
		mainInfoPanel.add(nomEquipeTexte);
		mainInfoPanel.add(defaut8);
		mainInfoPanel.add(defaut9);			// panel vide pour combler et décaller les composants suivant
		mainInfoPanel.add(defaut10);
		mainInfoPanel.add(defaut11);			// panel vide pour combler et décaller les composants suivant

		
		// ajout des composants au panel titre
		titrePanel.add(titre);
		titrePanel.add(mainInfoPanel);
		
		// panel vide intermédiaire pour la mise en page
		middlePanel = new JPanel();
		middlePanel.setBackground(Color.white);
		
		
		// définition du panel bottom pour les boutons
		bottomPanel = new JPanel();
		bottomPanel.setLayout(new GridLayout(1,2));
		
		btnPanel = new JPanel();
		btnPanel.setLayout(new GridLayout(5,2));
		btnPanel.setBackground(Color.white);
		
		// définition des bouton annuler - valider
		annuler = new JButton("Annuler");
		valider = new JButton("Valider les modification");
		valider.setActionCommand("Valider");
		
		// changer la couleur de fond des boutons
        annuler.setBackground(Color.GRAY);
        valider.setBackground(Couleur.ROUGE_JO.getColor());
        // changer la couleur de la police des boutons
        annuler.setForeground(Color.WHITE);
        valider.setForeground(Color.WHITE);
        

		bottomPanel.add(defaut); // case vide
		bottomPanel.add(btnPanel);
		
		btnPanel.add(defaut1); 
		btnPanel.add(defaut2); 
		btnPanel.add(defaut3); 
		btnPanel.add(defaut4); 
		btnPanel.add(defaut5); 
		btnPanel.add(defaut6); 
		btnPanel.add(defaut6); 
		btnPanel.add(annuler);
		btnPanel.add(valider);
		
		valider.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String nom = nomEquipeTexte.getText();
				String discipline = (String) disciplineTexte.getSelectedItem();
				
				boolean ajoute = controleur.ajouterEquipe(nom, discipline);
				
				if(ajoute) {
					controleur.retour();
				}else {
					System.out.println("Une erreur est survenue suite à l'entrée d'une valeur incorrecte");
				}
			}
			
		});
		
		annuler.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controleur.retour();
			}
		});
		
		// ajout des panels principaux 
		add(titrePanel);
		add(middlePanel);
		add(bottomPanel);
		
	}

}
