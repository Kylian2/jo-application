package vues;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComponent;

import controleurs.ControleurAthlete;
import controleurs.ControleurSession;
import modeles.ApplicationJo;
import modeles.Athlete;
import modeles.Discipline;
import modeles.Epreuve;

/**
 * Vue permettant d'ajouter une session
 * @author klentz
 * @author kylianrichard
 */

public class VueAjouterSession extends JPanel {
		
	
	VueAjouterSession(ControleurSession controleur){
		this.setLayout(new BorderLayout());
		
		//Déclaration du moedele de table
        DefaultTableModel modele = new DefaultTableModel();
		
        // initialisation des panel globaux
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);
        
        // initialisation des sous-JPanel
        JPanel info = new JPanel();
        info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS));
        info.setPreferredSize(new Dimension(400,450));
        info.setBackground(Color.WHITE);
        
        // titre
        JPanel titrePanel = new JPanel();
        titrePanel.setLayout(new GridLayout(1,1));
        JLabel titre = new JLabel ("    Ajouter une Session");
        titre.setFont(new Font("Source", Font.PLAIN, 30));
        titrePanel.add(titre, SwingConstants.CENTER);
        titrePanel.setBackground(Color.WHITE);
        
        // initialisation du JLabel + JComboBox discipline
        JPanel disciplinePanel = new JPanel();
        disciplinePanel.setLayout(new GridLayout(1,2));
        JLabel discipline = new JLabel("Discipline :     ", SwingConstants.RIGHT);
        JComboBox<String> disciplineTexte = new JComboBox<String>();
        disciplineTexte.addItem("Choisir une discipline");
        disciplinePanel.setBackground(Color.WHITE);
        disciplinePanel.add(discipline);
        disciplinePanel.add(disciplineTexte);
        
        for(Discipline disciplineFromApp : controleur.application.disciplinesList) {
        	disciplineTexte.addItem(disciplineFromApp.getNom());
        }
        
        JPanel epreuvesPanel = new JPanel();
        epreuvesPanel.setLayout(new GridLayout(1,2));
        JLabel epreuves = new JLabel("Epreuves :     ", SwingConstants.RIGHT);
        JComboBox<String> epreuveTexte = new JComboBox<String>();
        epreuveTexte.addItem("Choisir une épreuve");
        epreuvesPanel.setBackground(Color.WHITE);
        epreuvesPanel.add(epreuves);
        epreuvesPanel.add(epreuveTexte);
        
        //Modifie la liste des epreuves en fonction de la discipline selectionnée
        disciplineTexte.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtient l'élément sélectionné
                String selectedItem = (String) disciplineTexte.getSelectedItem();
                if(!selectedItem.equalsIgnoreCase("Choisir une discipline")) {
                	ArrayList<Epreuve> epreuves = controleur.getEpreuveDiscipline(selectedItem);
                	epreuveTexte.removeAllItems();
                	while(modele.getRowCount() != 0) {
                		modele.removeRow(0);
                	}
                	for(Epreuve epreuveFromControleur : epreuves) {
                		epreuveTexte.addItem(epreuveFromControleur.getNom());
                	}
                }else {
                	epreuveTexte.removeAllItems();
                	epreuveTexte.addItem("Choisir une épreuve");
                }
            }

        });
        
        JPanel datePanel = new JPanel();
        datePanel.setLayout(new GridLayout(1,2));
        JLabel date = new JLabel("Date :     ", SwingConstants.RIGHT);
        JTextField dateTexte = new JTextField("Entrez une date (JJ/MM/AAAA)");
        datePanel.setBackground(Color.WHITE);
        datePanel.add(date);
        datePanel.add(dateTexte);

        JPanel debutPanel = new JPanel();
        debutPanel.setLayout(new GridLayout(1,2));
        JLabel debut = new JLabel("Début :     ", SwingConstants.RIGHT);
        JTextField debutTexte = new JTextField("Heure de début (hh:mm)");
        debutPanel.setBackground(Color.WHITE);
        debutPanel.add(debut);
        debutPanel.add(debutTexte);

        JPanel dureePanel = new JPanel();
        dureePanel.setLayout(new GridLayout(1,2));
        JLabel duree = new JLabel("Durée :     ", SwingConstants.RIGHT);
        JTextField dureeTexte = new JTextField("Entrez une durée (en minutes)");
        dureePanel.setBackground(Color.WHITE);
        dureePanel.add(duree);
        dureePanel.add(dureeTexte);
        
        JPanel lieuPanel = new JPanel();
        lieuPanel.setLayout(new GridLayout(1,2));
        JLabel lieu = new JLabel("Lieu :     ", SwingConstants.RIGHT);
        JTextField lieuTexte = new JTextField("Entrez un lieu");
        lieuPanel.setBackground(Color.WHITE);
        lieuPanel.add(lieu);
        lieuPanel.add(lieuTexte);
        
        JPanel sexePanel = new JPanel();
        sexePanel.setLayout(new GridLayout(1,2));
        JLabel sexe = new JLabel("Sexe :     ", SwingConstants.RIGHT);
        JComboBox<String> sexeTexte = new JComboBox<String>();
        sexeTexte.addItem("Homme");
        sexeTexte.addItem("Femme");
        sexePanel.setBackground(Color.WHITE);
        sexePanel.add(sexe);
        sexePanel.add(sexeTexte);
        
        // ajout des composants a infoPanel
        info.add(titrePanel);
        info.add(Box.createHorizontalStrut(10));
        info.add(disciplinePanel);
        info.add(Box.createHorizontalStrut(10));
        info.add(epreuvesPanel);
        info.add(Box.createHorizontalStrut(10));
        info.add(datePanel);
        info.add(Box.createHorizontalStrut(10));
        info.add(debutPanel);
        info.add(Box.createHorizontalStrut(10));
        info.add(dureePanel);
        info.add(Box.createHorizontalStrut(10));
        info.add(lieuPanel);
        info.add(Box.createHorizontalStrut(10));
        info.add(sexePanel);
        
        
        // panel ajouter Athlete
        // initialisation des composant de athletePanel
        JPanel athletePanel = new JPanel();
        athletePanel.setBackground(Color.WHITE);
        athletePanel.setLayout(new GridLayout(4,4));
		athletePanel.setBorder(BorderFactory.createEmptyBorder(0,40, 0, 40));
        
		JLabel athlete = new JLabel(" Athlète :");
        athlete.setHorizontalAlignment(SwingConstants.LEFT);		// aligner le texte à droite dans son Panel
        JComboBox<String> athleteTexte = new JComboBox<String>();
        athleteTexte.addItem("Choisir un athlète");
        JButton ajouterAthlete = new JButton("Ajouter");
        ajouterAthlete.setForeground(Color.white);
        ajouterAthlete.setBackground((Couleur.ROUGE_JO).getColor());
        
        // ajout des composant a athletePanel 
//        for (int i = 0; i < 4; i++) {			// ajout de panel vide est blanc pour placer correctement athletePanel
//            JPanel panel = new JPanel();
//            panel.setBackground(Color.WHITE);
//            athletePanel.add(panel);
//    }

        athletePanel.add(athlete);
        athletePanel.add(athleteTexte);	
        JPanel defaut4 = new JPanel();
        defaut4.setBackground(Color.WHITE);
        athletePanel.add(defaut4);
        athletePanel.add(ajouterAthlete);
        
        mainPanel.add(athletePanel, BorderLayout.NORTH);
        
        //JTable pour stocker les résultats
        JPanel tabPanel = new JPanel();
        tabPanel.setBackground(Color.WHITE);
        tabPanel.setLayout(new GridLayout(3,1));
        JTable tableau = new JTable(modele);
        
        ArrayList<Athlete> athletesDisponibles = new ArrayList<Athlete>();
        ArrayList<Athlete> athletesAjoutes = new ArrayList<Athlete>();
        
        modele.addColumn("CodePays");
        modele.addColumn("NomAthlete");
        modele.addColumn("PrenomAthlete");
        
        disciplineTexte.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtient l'élément sélectionné
                String discipline = (String) disciplineTexte.getSelectedItem();
                if(!discipline.equalsIgnoreCase("Choisir une discipline")) {
                	athletesDisponibles.removeAll(athletesDisponibles);
                	athletesAjoutes.removeAll(athletesAjoutes);
                	athleteTexte.removeAllItems();
                	for(Athlete athlete : controleur.application.athletesList) {
                		if(athlete.getDiscipline().getNom().equalsIgnoreCase(discipline)) {
                			athleteTexte.addItem(athlete.getNom() + " " + athlete.getPrenom());
                			athletesDisponibles.add(athlete);
                		}
                	}
                }else {
                	athletesDisponibles.removeAll(athletesDisponibles);
                	athleteTexte.addItem("Choisir un athlète");
                }
            }

        });
        
        ajouterAthlete.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	int athleteIndex = athleteTexte.getSelectedIndex();
            	if(!((String) athleteTexte.getSelectedItem()).equalsIgnoreCase("Choisir un athlète")) {
            		Athlete athlete = athletesDisponibles.get(athleteIndex);
            		String codePays = athlete.getPays().getCode();
        			String nomAthlete = athlete.getNom();
        			String prenomAthlete = athlete.getPrenom();
        			modele.addRow(new Object[] {codePays,nomAthlete,prenomAthlete});
        			athletesAjoutes.add(athlete);
        			athletesDisponibles.remove(athleteIndex);
        			athleteTexte.removeAllItems();
        			for(Athlete athleteDisponible : athletesDisponibles) {
        				athleteTexte.addItem(athleteDisponible.getNom() + " " + athleteDisponible.getPrenom());
        			}
            	}
            }

        });
        
        // ajout des compostant au mainJpane
        JScrollPane panneau = new JScrollPane(tableau);
        panneau.setBackground(Color.WHITE);
        panneau.setBorder(BorderFactory.createEmptyBorder(0,40, 0, 40));
        tableau.setFillsViewportHeight(true);
        JPanel defaut5 = new JPanel();
        defaut5.setBackground(Color.WHITE);
        tabPanel.add(defaut5);
        tabPanel.add(panneau);
        mainPanel.add(tabPanel, BorderLayout.CENTER);
        
        // définition de panel vide pour combler la mise en page
        JPanel defaut = new JPanel();
        defaut.setBackground(Color.WHITE);
        JPanel defaut1 = new JPanel();
        defaut1.setBackground(Color.WHITE);
        JPanel defaut2 = new JPanel();
        defaut2.setBackground(Color.WHITE);
        
        
        // initialisation des boutons valider et annuler
        JPanel boutons = new JPanel();
        boutons.setBackground(Color.WHITE);
        boutons.setLayout(new GridLayout(2,3));
        JButton valider = new JButton("Valider");
        
        valider.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//Recuperer les informations contenu dans les inputs
				String discipline = (String) disciplineTexte.getSelectedItem();
				String epreuve = (String) epreuveTexte.getSelectedItem();
				String date = dateTexte.getText();
				String debut = debutTexte.getText();
				String sexe = (String) sexeTexte.getSelectedItem();
				String duree = dureeTexte.getText();
				String lieu = lieuTexte.getText();
				ArrayList<Athlete> athleteParticipants = athletesAjoutes;
				boolean creation = controleur.ajouterSession(date, debut, duree, lieu, sexe, discipline, epreuve, athleteParticipants);
				
			}
        	
        });
        	
        JButton annuler = new JButton("Annuler");
        
        annuler.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controleur.retour();	
			}
        });
        
		// changer la couleur de fond des boutons
        annuler.setBackground(Color.GRAY);
        valider.setBackground(Couleur.ROUGE_JO.getColor());
        // changer la couleur de la police des boutons
        annuler.setForeground(Color.WHITE);
        valider.setForeground(Color.WHITE);
       
        boutons.add(defaut);
        boutons.add(annuler);
        boutons.add(valider);
        boutons.add(defaut1);
        boutons.add(defaut2);
        mainPanel.add(boutons, BorderLayout.SOUTH);
        

        
        // ajout des composant principaux
        add(info, BorderLayout.WEST);
        add(mainPanel, BorderLayout.CENTER);
	}
}
