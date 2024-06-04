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

public class VueAjouterAthlete extends JPanel{

	protected JPanel top, topInfo, nomPanel, delegPanel, discipPanel, mainInfo, infoAthletePanel, bioPanel, anneeNaissancePanel, genrePanel,
			poidsPanel, firstParticipation, bottomPanel, btnPanel;
	protected JLabel ajouterAthlete, nom, prenom, deleg, discip, desc, anneeNaissance, genre, poids, taille;
	protected JTextField nomTexte, prenomTexte,anneeNaissanceTexte, genreTexte, poidsTexte, tailleTexte;
	protected JButton annuler, valider;
	protected JTextArea descTexte;
    protected JComboBox<String> delegTexte, discipTexte;
	ArrayList<Pays> paysList;
	
	protected ControlleurAthlete controlleur;

	VueAjouterAthlete(ControlleurAthlete controlleur){
		this.controlleur = controlleur;
		
		/// définition du Panel "top" 
		top = new JPanel();
		ajouterAthlete = new JLabel("Ajouter un Athlète");
		Border borderAthlete = ajouterAthlete.getBorder();
		Border marginAthlete = new EmptyBorder(0,50,0,0);
		ajouterAthlete.setBorder(new CompoundBorder(borderAthlete, marginAthlete));



		//definition des Label et FieldText nom - discipline - discipline
		topInfo = new JPanel();

		nomPanel = new JPanel();
		delegPanel = new JPanel();
		discipPanel = new JPanel();

		nom = new JLabel("Nom :");
		nomTexte = new JTextField("Entrez le nom de l'athlète");
		nomTexte.setPreferredSize(new Dimension(130,30));
		
		prenom = new JLabel("Prénom :");
		prenomTexte = new JTextField("Entrez le prénom de l'athlète");
		prenomTexte.setPreferredSize(new Dimension(130,30));

		deleg = new JLabel("Délégation :");
		delegTexte = new JComboBox();
		delegTexte.setPreferredSize(new Dimension(130,30));
		delegTexte.setBackground(Color.WHITE);
		
		delegTexte.addItem("Choisir une delegation");
		//inserer item dans liste
		for(Pays pays : controlleur.getPays()) {
			delegTexte.addItem(pays.getNom());
		}
		

		discip = new JLabel("Discipline :");
		discipTexte = new JComboBox(); 	
		discipTexte.setBackground(Color.WHITE);
		discipTexte.setPreferredSize(new Dimension(130,30));
		discipTexte.addItem("Choisir une discipline");
		//inserer item dans liste
		for(Discipline discipline : controlleur.getDiscipline()) {
			discipTexte.addItem(discipline.getNom());
		}




		//définition de description - naissance - genre - poids - participation
		mainInfo = new JPanel();
		mainInfo.setLayout(new GridLayout(1,2));
		JPanel descPanel = new JPanel(new BorderLayout());
		descPanel.setBorder(new EmptyBorder(0, 20, 0, 20));
		descPanel.setBackground(Color.WHITE);
		desc = new JLabel("Description");
		descPanel.add(desc);


		JPanel descTextePanel = new JPanel(new BorderLayout());
        descTextePanel.setBorder(new EmptyBorder(0, 20, 0, 20)); 
        descTexte = new JTextArea("Entrez un texte");
        Border blackline = BorderFactory.createLineBorder(Color.black);
        descTextePanel.setBorder(blackline);
        descTexte.setPreferredSize(new Dimension(180, 150));
        descTextePanel.add(descTexte, BorderLayout.CENTER);
        descTextePanel.setBackground(Color.WHITE);

		
		infoAthletePanel = new JPanel();
		infoAthletePanel.setLayout(new GridLayout(1,2));
		
		bioPanel = new JPanel();
		bioPanel.setLayout(new GridLayout(6,1));
		
		//annee de Naissance
		anneeNaissancePanel = new JPanel();
		anneeNaissancePanel.setLayout(new GridLayout(2,1));
		
		anneeNaissance = new JLabel("Date de naissance :");
		anneeNaissanceTexte = new JTextField("Entrez une date (JJ/MM/AAAA)");
		
		// genre
		genrePanel = new JPanel();
		genrePanel.setLayout(new GridLayout(2,1));
		
		genre = new JLabel("Genre :");
		genreTexte = new JTextField("Selectionnez un genre");
		
		// poids
		poidsPanel = new JPanel();
		poidsPanel.setLayout(new GridLayout(2,1));
		
		poids = new JLabel("Poids :");
		poidsTexte = new JTextField("Entrez un poids");
		
		// participation
		firstParticipation = new JPanel();
		firstParticipation.setLayout(new GridLayout(6,1));
		
		taille = new JLabel("Taille :");
		tailleTexte = new JTextField("Entrez une taille");
		
		
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
		ajouterAthlete.setFont(new Font("Source", Font.PLAIN, 30));
		desc.setFont(new Font("Source", Font.PLAIN, 20));
		nom.setFont(new Font("Source", Font.PLAIN, 20));
		deleg.setFont(new Font("Source", Font.PLAIN, 20));			
		discip.setFont(new Font("Source", Font.PLAIN, 20));
		anneeNaissance.setFont(new Font("Source", Font.PLAIN, 15));
		genre.setFont(new Font("Source", Font.PLAIN, 15));
		poids.setFont(new Font("Source", Font.PLAIN, 15));
		taille.setFont(new Font("Source", Font.PLAIN, 15));
		
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
		nomPanel1.add(prenom);
		nomPanel1.add(prenomTexte);

//		delegPanel.add(deleg);
//		delegPanel.add(delegTexte);
//		discipPanel.add(discip);
//		discipPanel.add(discipTexte);

		topInfo.add(nomPanel);
		topInfo.add(nomPanel1);
//		topInfo.add(delegPanel);
//		topInfo.add(discipPanel);

		top.add(ajouterAthlete);
		top.add(topInfo);
		top.add(descPanel);
		
		bioPanel.add(anneeNaissance);
		bioPanel.add(anneeNaissanceTexte);
		
		bioPanel.add(genre);
		bioPanel.add(genreTexte);
		
		bioPanel.add(poids);
		bioPanel.add(poidsTexte);
		
		firstParticipation.add(taille);
		firstParticipation.add(tailleTexte);
		firstParticipation.add(deleg);
		firstParticipation.add(delegTexte);
		firstParticipation.add(discip);
		firstParticipation.add(discipTexte);
			
		
		infoAthletePanel.add(bioPanel);
		infoAthletePanel.add(firstParticipation);
		
		mainInfo.add(descTextePanel);
		mainInfo.add(infoAthletePanel);
		
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
		EcouteurImbrique ecouteur = new EcouteurImbrique();
		annuler.addActionListener(ecouteur);
		valider.addActionListener(ecouteur);

		
		top.setBackground(Color.WHITE); 
		topInfo.setBackground(Color.WHITE);
		nomPanel.setBackground(Color.WHITE);
		nomPanel1.setBackground(Color.WHITE);
		delegPanel.setBackground(Color.WHITE); 
		discipPanel.setBackground(Color.WHITE); 
		mainInfo.setBackground(Color.WHITE); 
		infoAthletePanel.setBackground(Color.WHITE); 
		bioPanel.setBackground(Color.WHITE); 
		anneeNaissancePanel.setBackground(Color.WHITE); 
		genrePanel.setBackground(Color.WHITE);
		poidsPanel.setBackground(Color.WHITE); 
		firstParticipation.setBackground(Color.WHITE); 
		bottomPanel.setBackground(Color.WHITE); 
		btnPanel.setBackground(Color.WHITE);
	}
	
	private class EcouteurImbrique implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equalsIgnoreCase("Annuler")){
				
				controlleur.retour();
				
			}
			if (e.getActionCommand().equalsIgnoreCase("Valider")) {
				String nom = nomTexte.getText();
				String genre = genreTexte.getText();
				String naissance = anneeNaissanceTexte.getText();
				String poids = poidsTexte.getText();
				String taille = tailleTexte.getText();
				String prenom = prenomTexte.getText();
				String description = descTexte.getText();
				String pays = (String) delegTexte.getSelectedItem();
				String discipline = (String) discipTexte.getSelectedItem();

				System.out.println(nom);
				System.out.println(genre);
				System.out.println(naissance);
				System.out.println(poids);
				System.out.println(taille);
				System.out.println(prenom);
				System.out.println(description);				
				System.out.println(pays);
				System.out.println(discipline);
				
				boolean ajoute = controlleur.createAthlete(nom, prenom, taille, poids, description, naissance, genre, pays, discipline);

				if(ajoute) {
					System.out.println("L'athlete a bien été ajouté");
					controlleur.enregister();
					controlleur.retour();
				}else {
					System.out.println("Une erreur est survenue suite à l'entrée d'une valeur incorrecte");
				}
				
			}
			
		}
	}

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

		VueAjouterAthlete p = new VueAjouterAthlete(controlleur);

		// Ajouter mon instance dans un des conteneurs de la fen?tre
		fenetre.add(p);

		// Afficher la fenetre
		fenetre.setVisible(true);
	}
}
