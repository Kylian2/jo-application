package vues;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class vueModifierAthlete extends JPanel{

	JPanel top, topInfo, nomPanel, delegPanel, discipPanel, mainInfo, infoAthletePanel, bioPanel, anneeNaissancePanel, genrePanel,
			poidsPanel, firstParticipation;
	JLabel ajouterAthlete, nom, deleg, discip, desc, anneeNaissance, genre, poids, participation;
	JTextField nomTexte, delegTexte, discipTexte, descTexte,anneeNaissanceTexte, genreTexte, poidsTexte, participationTexte;

	vueModifierAthlete(){
		// définition du Panel "top" 
		top = new JPanel();
		ajouterAthlete = new JLabel("Ajouter un Athlète");
		Border borderAthlete = ajouterAthlete.getBorder();
		Border marginAthlete = new EmptyBorder(0,50,0,0);
		ajouterAthlete.setBorder(new CompoundBorder(borderAthlete, marginAthlete));
		ajouterAthlete.setFont(new Font("Source", Font.PLAIN, 30));


		//definition des Label et FieldText nom - discipline - discipline
		topInfo = new JPanel();

		nomPanel = new JPanel();
		delegPanel = new JPanel();
		discipPanel = new JPanel();

		nom = new JLabel("Nom :");
		nomTexte = new JTextField("Entrez le nom de l'athlète"); 
		nomTexte.setPreferredSize(new Dimension(180,30));

		deleg = new JLabel("Délégation :");
		delegTexte = new JTextField("Choisir une délégation"); 
		delegTexte.setPreferredSize(new Dimension(180,30));

		discip = new JLabel("Discipline :");
		discipTexte = new JTextField("Choisir une discipline"); 	
		discipTexte.setPreferredSize(new Dimension(180,30));

		nom.setFont(new Font("Source", Font.PLAIN, 20));
		deleg.setFont(new Font("Source", Font.PLAIN, 20));
		discip.setFont(new Font("Source", Font.PLAIN, 20));


		//définition de description - naissance - genre - poids - participation
		mainInfo = new JPanel();
		mainInfo.setLayout(new GridLayout(1,2));
		desc = new JLabel("Description");
		Border borderDescription = desc.getBorder();
		Border marginDescription = new EmptyBorder(0,50,0,0);
		desc.setBorder(new CompoundBorder(borderDescription, marginDescription));
		desc.setFont(new Font("Source", Font.PLAIN, 20));


		descTexte = new JTextField("Entrez un texte");
		descTexte.setPreferredSize(new Dimension(180,150));

		
		infoAthletePanel = new JPanel();
		infoAthletePanel.setLayout(new GridLayout(1,2));
		
		bioPanel = new JPanel();
		bioPanel.setLayout(new GridLayout(6,1));
		
		//annee de Naissance
		anneeNaissancePanel = new JPanel();
		anneeNaissancePanel.setLayout(new GridLayout(2,1));
		
		anneeNaissance = new JLabel("Année de naissance :");
		anneeNaissanceTexte = new JTextField("Entrez une date (Format : AAAA)");
		
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
		
		participation = new JLabel("Première participation :");
		participationTexte = new JTextField("Entrez une date (Format : AAAA)");


		// ajout des Panel dans la fenetre
		this.setLayout(new GridLayout(3,1));

		top.setLayout(new GridLayout(3, 1));
		topInfo.setLayout(new GridLayout(1,3));

		nomPanel.add(nom);
		nomPanel.add(nomTexte);

		delegPanel.add(deleg);
		delegPanel.add(delegTexte);
		discipPanel.add(discip);
		discipPanel.add(discipTexte);

		topInfo.add(nomPanel);
		topInfo.add(delegPanel);
		topInfo.add(discipPanel);

		top.add(ajouterAthlete);
		top.add(topInfo);
		top.add(desc);
		
		bioPanel.add(anneeNaissance);
		bioPanel.add(anneeNaissanceTexte);
		
		bioPanel.add(genre);
		bioPanel.add(genreTexte);
		
		bioPanel.add(poids);
		bioPanel.add(poidsTexte);
		
		firstParticipation.add(participation);
		firstParticipation.add(participationTexte);
		
		infoAthletePanel.add(bioPanel);
		infoAthletePanel.add(firstParticipation);
		
		mainInfo.add(descTexte);
		mainInfo.add(infoAthletePanel);
		
		add(top);
		add(mainInfo);
		
		/*border pour debug
		top.setBorder(BorderFactory.createLineBorder(Color.red));
		mainInfo.setBorder(BorderFactory.createLineBorder(Color.green));
		mainInfo.setBorder(BorderFactory.createLineBorder(Color.blue));
		*/



	}

	public static void main(String[] args) {
		// Creer une fenetre
		JFrame fenetre = new JFrame ();
		fenetre.setSize(960,540);
		fenetre.setLocationRelativeTo(null); 
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Creer une instance de ma classe
		vueModifierAthlete p = new vueModifierAthlete ();

		// Ajouter mon instance dans un des conteneurs de la fen?tre
		fenetre.add(p);

		// Afficher la fenetre
		fenetre.setVisible(true);
	}
}
