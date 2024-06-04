package vues;
import java.awt.*;
import modeles.ApplicationJo;
import modeles.Discipline;
import modeles.Pays;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.*;

import controlleurs.ControlleurAthlete;

public class VueAjouterEquipe extends JPanel{

	protected JPanel top, topInfo, nomPanel, delegPanel, discipPanel, mainInfo, infoAthletePanel, bioPanel, anneeNaissancePanel, genrePanel,
			poidsPanel, firstParticipation, bottomPanel, btnPanel;
	protected JLabel nom, discipline, ajouterEquipe;
	protected JTextField nomTexte;
	protected JButton annuler, valider;
    protected JComboBox<String> disciplineTexte;
	
	protected ControlleurAthlete controlleur;

	VueAjouterEquipe(ControlleurAthlete controlleur){
		this.controlleur = controlleur;
		
		/// définition du Panel "top" 
		top = new JPanel();
		ajouterEquipe = new JLabel("Ajouter une Equipe");
		Border borderEquipe = ajouterEquipe.getBorder();
		Border marginEquipe = new EmptyBorder(0,50,0,0);
		ajouterEquipe.setBorder(new CompoundBorder(borderEquipe, marginEquipe));



		//definition des Label et FieldText nom - discipline - discipline
		topInfo = new JPanel();

		nomPanel = new JPanel();
		discipPanel = new JPanel();

		nom = new JLabel("Nom :");
		nomTexte = new JTextField("Entrez le nom de l'équipe");
		nomTexte.setPreferredSize(new Dimension(130,30));
		
		discipline = new JLabel("Discipline :     ");
        disciplineTexte = new JComboBox<String>();
        disciplineTexte.addItem("Choisir une discipline");

		//définition de description - naissance - genre - poids - participation
		mainInfo = new JPanel();
		
		/// définition du bottom Panel
		
		bottomPanel = new JPanel();
		bottomPanel.setLayout(new GridLayout(1,2));
		
		btnPanel = new JPanel();
		btnPanel.setLayout(new GridLayout(5,2));
		
		// définition des bouton annuler - valider
		annuler = new JButton("Annuler");
		valider = new JButton("Valider les modification");
		valider.setActionCommand("Valider");

		//uniformisation de la police d'écriture
		nom.setFont(new Font("Source", Font.PLAIN, 20));
		discipline.setFont(new Font("Source", Font.PLAIN, 20));
		
		// changer la couleur de fond des boutons
        annuler.setBackground(Color.GRAY);
        valider.setBackground(Couleur.ROUGE_JO.getColor());
        // changer la couleur de la police des boutons
        annuler.setForeground(Color.WHITE);
        valider.setForeground(Color.WHITE);
        
		// ajout des Panel dans la fenetre
		setBackground(Color.WHITE);
		this.setLayout(new GridLayout(3,1));

		top.setLayout(new GridLayout(3, 1));
		topInfo.setLayout(new GridLayout(1,3));

		nomPanel.add(nom);
		nomPanel.add(nomTexte);
		
		JPanel nomPanel1 = new JPanel();
		nomPanel1.add(discipline);
		nomPanel1.add(disciplineTexte);

		topInfo.add(nomPanel);
		topInfo.add(nomPanel1);
		
		top.add(topInfo);
		
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
 
        
		// ajout des panel sur la fenetre principale
		add(top);
		add(mainInfo);
		add(bottomPanel);
		
		// ajout des ecouteurs sur les bouton
//		EcouteurImbrique ecouteur = new EcouteurImbrique();
//		annuler.addActionListener(ecouteur);
//		valider.addActionListener(ecouteur);

		
//		top.setBackground(Color.WHITE); 
//		topInfo.setBackground(Color.WHITE);
//		nomPanel.setBackground(Color.WHITE);
//		nomPanel1.setBackground(Color.WHITE);
//		delegPanel.setBackground(Color.WHITE); 
//		discipPanel.setBackground(Color.WHITE); 
//		mainInfo.setBackground(Color.WHITE); 
//		infoAthletePanel.setBackground(Color.WHITE); 
//		bioPanel.setBackground(Color.WHITE); 
//		anneeNaissancePanel.setBackground(Color.WHITE); 
//		genrePanel.setBackground(Color.WHITE);
//		poidsPanel.setBackground(Color.WHITE); 
//		firstParticipation.setBackground(Color.WHITE); 
//		bottomPanel.setBackground(Color.WHITE); 
//		btnPanel.setBackground(Color.WHITE);
	}
	
//	private class EcouteurImbrique implements ActionListener {
//
//		public void actionPerformed(ActionEvent e) {
//			if (e.getActionCommand().equalsIgnoreCase("Annuler")){
//				
//				controlleur.retour();
//				
//			}
//			if (e.getActionCommand().equalsIgnoreCase("Valider")) {
////				String nom = nomTexte.getText();
////				String genre = genreTexte.getText();
////				String naissance = anneeNaissanceTexte.getText();
////				String poids = poidsTexte.getText();
////				String taille = tailleTexte.getText();
////				String prenom = prenomTexte.getText();
////				String description = descTexte.getText();
////				String pays = (String) delegTexte.getSelectedItem();
////				String discipline = (String) discipTexte.getSelectedItem();
//
//				System.out.println(nom);
////				System.out.println(genre);
////				System.out.println(naissance);
////				System.out.println(poids);
////				System.out.println(taille);
////				System.out.println(prenom);
////				System.out.println(description);				
////				System.out.println(pays);
//				System.out.println(discipline);
//				
////				boolean ajoute = controlleur.createAthlete(nom, prenom, taille, poids, description, naissance, genre, pays, discipline);
//
//				if(ajoute) {
//					System.out.println("L'athlete a bien été ajouté");
//					controlleur.enregister();
//					controlleur.retour();
//				}else {
//					System.out.println("Une erreur est survenue suite à l'entrée d'une valeur incorrecte");
//				}
//				
//			}
//			
//		}
//	}

	public static void main(String[] args) {
		// Creer une fenetre
		JFrame fenetre = new JFrame ();
		fenetre.setSize(960,540);
		fenetre.setLocationRelativeTo(null); 
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		// Creer une instance de ma classe
		ApplicationJo applicationJo = new ApplicationJo();
		
		applicationJo.recuperer();
		
		ControlleurAthlete controlleur = new ControlleurAthlete(applicationJo);

		VueAjouterEquipe p = new VueAjouterEquipe(controlleur);

		// Ajouter mon instance dans un des conteneurs de la fen?tre
		fenetre.add(p);

		// Afficher la fenetre
		fenetre.setVisible(true);
	}
}
