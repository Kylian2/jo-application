package vues;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class vueModifierAthlete extends JPanel{

	JPanel top, topInfo, nomPanel, delegPanel, discipPanel, mainInfo;
	JLabel ajouterAthlete, nom, deleg, discip;
	JTextField nomTexte, delegTexte, discipTexte;

	vueModifierAthlete(){
		// définition du Panel "top" 
		JPanel top = new JPanel();
		JLabel ajouterAthlete = new JLabel("Ajouter un Athlète");
		Border borderAthlete = ajouterAthlete.getBorder();
		Border marginAthlete = new EmptyBorder(0,50,0,0);
		ajouterAthlete.setBorder(new CompoundBorder(borderAthlete, marginAthlete));
		ajouterAthlete.setFont(new Font("Source", Font.PLAIN, 30));


		//definition des Label et FieldText nom - discipline - discipline
		JPanel topInfo = new JPanel();

		JPanel nomPanel = new JPanel();
		JPanel delegPanel = new JPanel();
		JPanel discipPanel = new JPanel();

		JLabel nom = new JLabel("Nom :");
		JTextField nomTexte = new JTextField("Entrez le nom de l'athlète"); 
		nomTexte.setPreferredSize(new Dimension(180,30));

		JLabel deleg = new JLabel("Délégation :");
		JTextField delegTexte = new JTextField("Choisir une délégation"); 
		delegTexte.setPreferredSize(new Dimension(180,30));

		JLabel discip = new JLabel("Discipline :");
		JTextField discipTexte = new JTextField("Choisir une discipline"); 	
		discipTexte.setPreferredSize(new Dimension(180,30));

		nom.setFont(new Font("Source", Font.PLAIN, 20));
		deleg.setFont(new Font("Source", Font.PLAIN, 20));
		discip.setFont(new Font("Source", Font.PLAIN, 20));


		//définition de description - naissance - genre - poids - participation
		JPanel mainInfo = new JPanel();
		JPanel infoPanel = new JPanel();
		mainInfo.setLayout(new GridLayout(2,1));
		JLabel desc = new JLabel("Description");
		Border borderDescription = desc.getBorder();
		Border marginDescription = new EmptyBorder(0,50,0,0);
		desc.setBorder(new CompoundBorder(borderDescription, marginDescription));
		desc.setFont(new Font("Source", Font.PLAIN, 20));
		mainInfo.add(desc);


		JTextField descTexte = new JTextField("Entrez un texte");
		descTexte.setPreferredSize(new Dimension(180,150));
		infoPanel.add(descTexte);



		// ajout des Panel dans la fenetre
		this.setLayout(new GridLayout(3,1));

		top.setLayout(new GridLayout(2, 1));
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
		
		mainInfo.add(infoPanel);

		add(top);
		add(mainInfo);
		top.setBorder(BorderFactory.createLineBorder(Color.red));
		mainInfo.setBorder(BorderFactory.createLineBorder(Color.green));



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
