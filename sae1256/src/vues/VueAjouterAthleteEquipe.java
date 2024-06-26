package vues;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controleurs.ControleurEpreuve;
import controleurs.ControleurEquipe;
import vues.Couleur;
import modeles.ApplicationJo;
import modeles.Athlete;
import modeles.Discipline;
import modeles.Epreuve;
import modeles.Equipe;

/**
 * Vue permettant d'ajouter un athlète à une épreuve.
 * Cette classe représente l'interface graphique permettant de sélectionner 
 * et ajouter un athlète à une épreuve spécifique dans une application de gestion d'événements sportifs.
 * 
 * @author kilianlentz (vues / controlleur)
 * @author kylianrichard (controlleur / eventListener)
 */
public class VueAjouterAthleteEquipe extends JPanel {
	Equipe equipe;
	
	ControleurEquipe controleur;
    /**
     * Constructeur par défaut de la classe VueAjouterAthleteEquipe.
     * Initialise l'interface graphique pour ajouter un athlète à une épreuve.
     */
	VueAjouterAthleteEquipe(Equipe equipe, 	ControleurEquipe controleur){
		this.controleur = controleur;
		this.equipe = equipe;
		
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
        JLabel titre = new JLabel ("    Ajouter un athlete");
        titre.setFont(new Font("Source", Font.PLAIN, 30));
        titrePanel.add(titre, SwingConstants.CENTER);
        titrePanel.setBackground(Color.WHITE);
        
        
        // panel ajouter Athlete
        // initialisation des composant de athletePanel
        JPanel athletePanel = new JPanel();
        athletePanel.setBackground(Color.WHITE);
        athletePanel.setLayout(new GridLayout(4,4));
		athletePanel.setBorder(BorderFactory.createEmptyBorder(0,40, 0, 40));
        
		JLabel athlete = new JLabel(" Athlète :");
        athlete.setHorizontalAlignment(SwingConstants.LEFT);		// aligner le texte à droite dans son Panel
        JComboBox<String> athleteTexte = new JComboBox<String>();
        athleteTexte.setBackground(Color.WHITE);
        athleteTexte.addItem("Choisir un athlète");
        JButton ajouterAthlete = new JButton("Ajouter");
        ajouterAthlete.setForeground(Color.white);
        ajouterAthlete.setBackground((Couleur.ROUGE_JO).getColor());
        
        ArrayList<Athlete> athletesDisponibles = new ArrayList<Athlete>();
        ArrayList<Athlete> athletesAjoutes = new ArrayList<Athlete>();
        String discipline = equipe.getDiscipline().getNom();
        if(!discipline.equalsIgnoreCase("Choisir une discipline")) {
        	athletesDisponibles.removeAll(athletesDisponibles);
            athletesAjoutes.removeAll(athletesAjoutes);
            athleteTexte.removeAllItems();
            for(Athlete athlete1 : controleur.application.athletesList) {
            	if(athlete1.getDiscipline().getNom().equalsIgnoreCase(discipline)) {
            		athleteTexte.addItem(athlete1.getNom() + " " + athlete1.getPrenom());
                	athletesDisponibles.add(athlete1);
                }
           }
           }else {
                	athletesDisponibles.removeAll(athletesDisponibles);
                	athleteTexte.addItem("Choisir un athlète");
           }
        
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
        
        modele.addColumn("CodePays");
        modele.addColumn("NomAthlete");
        modele.addColumn("PrenomAthlete");

        
        // ajout des compostant au mainJpanel
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
        	
        JButton annuler = new JButton("Annuler");

		// changer la couleur de fond des boutons
        annuler.setBackground(Color.GRAY);
        valider.setBackground(Couleur.ROUGE_JO.getColor());
        // changer la couleur de la police des boutons
        annuler.setForeground(Color.WHITE);
        valider.setForeground(Color.WHITE);
        valider.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//Recuperer les informations contenu dans les inputs
				ArrayList<Athlete> athleteParticipants = athletesAjoutes;
				
				if(athletesAjoutes.size() <= 0) {
	    			JOptionPane.showMessageDialog(null, "Veuillez ajouter des membres", "Erreur", JOptionPane.WARNING_MESSAGE);
				}else {
					boolean creation = controleur.ajouterMembre(equipe, athleteParticipants);
					if(creation) {
						controleur.enregistrer();
						controleur.retour();
					}else {
						System.out.println("Une erreur est survenue");
					}
				}
			}
        	
        });
        
        annuler.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controleur.retour();	
			}
        });
       
        boutons.add(defaut);
        boutons.add(annuler);
        boutons.add(valider);
        boutons.add(defaut1);
        boutons.add(defaut2);
        mainPanel.add(boutons, BorderLayout.SOUTH);
        

        info.add(titre);
        
        // ajout des composant principaux
        add(info, BorderLayout.WEST);
        add(mainPanel, BorderLayout.CENTER);
	}
	

}
