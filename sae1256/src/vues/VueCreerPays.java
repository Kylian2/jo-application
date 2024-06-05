package vues;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import controleurs.ControleurPays;

public class VueCreerPays extends JPanel {

    protected JPanel topPanel, middlePanel, bottomPanel;
    protected JLabel creerPays, nom, code;
    protected JTextField nomTexte, codeTexte;
    protected JButton annuler, valider;
    
    ControleurPays controleur;

    public VueCreerPays(ControleurPays controleur)
    {
    	
    	this.controleur = controleur;
    	
        // Définir le panel du haut et le JLabel contenant le nom de la vue
        topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 0)); // Crée une marge de 30 pixels à gauche
        creerPays = new JLabel("Créer un pays");
        creerPays.setFont(new Font("Source", Font.PLAIN, 30));
        creerPays.setFont(new Font(creerPays.getFont().getName(), Font.BOLD, 32));
        topPanel.add(creerPays);

        // Définir le panel central avec GridLayout
        middlePanel = new JPanel(new GridLayout(2, 1)); // 2 lignes, 1 colonne
        // Création d'un JPanel avec un GridLayout de 2 lignes et 4 colonnes pour la saisie du nom et du code
        JPanel panelSaisie = new JPanel(new GridLayout(3, 4)); // 2 lignes, 4 colonnes

        JPanel n1 = new JPanel();
        JPanel n2 = new JPanel();
        n1.setBackground(Color.WHITE);
        n2.setBackground(Color.WHITE);
        
        // Ajout d'un espace entre le panel du haut et le panel du centre
        panelSaisie.add(n1);
        panelSaisie.add(n2);
        
        // Créer un panel pour la saisie du nom
        JPanel panelNom = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Utiliser FlowLayout pour que les éléments s'alignent à gauche
        JLabel labelEspaceNom = new JLabel("   "); // Espace à gauche du JLabel "Nom :"
        nom = new JLabel("Nom :");
        nom.setFont(new Font("Source", Font.PLAIN, 20));
        nomTexte = new JTextField("Entrez le nom du pays");
        nomTexte.setPreferredSize(new Dimension(150, 30)); // Définir la taille personnalisée du JTextField
        panelNom.add(labelEspaceNom); // Ajout de l'espace
        panelNom.add(nom);
        panelNom.add(nomTexte);

        // Créer un panel pour la saisie du code
        JPanel panelCode = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Utiliser FlowLayout pour que les éléments s'alignent à gauche
        JLabel labelEspaceCode = new JLabel("   "); // Espace à gauche du JLabel "Code :"
        code = new JLabel("Code :");
        code.setFont(new Font("Source", Font.PLAIN, 20));
        codeTexte = new JTextField("Entrez le code du pays");
        codeTexte.setPreferredSize(new Dimension(150, 30)); // Définir la taille personnalisée du JTextField
        panelCode.add(labelEspaceCode); // Ajout de l'espace
        panelCode.add(code);
        panelCode.add(codeTexte);

        JPanel n3 = new JPanel();
        JPanel n4 = new JPanel();
        n3.setBackground(Color.WHITE);
        n4.setBackground(Color.WHITE);
        // Ajout des panels de saisie à panelSaisie
        panelSaisie.add(panelNom);
        panelSaisie.add(n3); // Ajouter un JPanel vide pour créer de l'espace entre les colonnes
        panelSaisie.add(panelCode);
        panelSaisie.add(n4); // Ajouter un JPanel vide pour créer de l'espace entre les colonnes

        // Ajout du panel de saisie à middlePanel
        middlePanel.add(panelSaisie);

        // Initialiser les boutons
        bottomPanel = new JPanel(new GridLayout(1, 5)); // 1 ligne, 5 colonnes
        annuler = new JButton("Annuler");
        annuler.setBackground(Color.GRAY);
        annuler.setForeground(Color.WHITE);
        annuler.setPreferredSize(new Dimension(200, 40)); // Définir la taille préférée du bouton
        valider = new JButton("Valider");
        valider.setBackground(Color.RED);
        valider.setForeground(Color.WHITE);
        valider.setPreferredSize(new Dimension(200, 40)); // Définir la taille préférée du bouton
    
        JPanel n5 = new JPanel();
        JPanel n6 = new JPanel();
        JPanel n7 = new JPanel();
        n5.setBackground(Color.WHITE);
        n6.setBackground(Color.WHITE);
        n7.setBackground(Color.WHITE);
        
        bottomPanel.add(n5);
        bottomPanel.add(n6);
        bottomPanel.add(n7);
        bottomPanel.add(annuler);
        bottomPanel.add(valider);
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));
        // Crée une marge de 60 pixels en bas

        // Définir le layout du JPanel principal
        setLayout(new BorderLayout());

        // Ajouter les panels sur la fenêtre principale
        add(topPanel, BorderLayout.NORTH);
        add(middlePanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        // Mettre le fond de la fenêtre en blanc
        topPanel.setBackground(Color.WHITE);
        middlePanel.setBackground(Color.WHITE);
        bottomPanel.setBackground(Color.WHITE);
        panelSaisie.setBackground(Color.WHITE);
        panelNom.setBackground(Color.WHITE);
        panelCode.setBackground(Color.WHITE);
        
        
        // Ajouter les écouteurs sur les boutons
        EcouteurImbrique ecouteur = new EcouteurImbrique();
        annuler.addActionListener(ecouteur);
        valider.addActionListener(ecouteur);
    }

    private class EcouteurImbrique implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equalsIgnoreCase("Annuler")) {
                controleur.retour();
            }
            if (e.getActionCommand().equalsIgnoreCase("Valider")) {
            	String code = codeTexte.getText();
            	String nom = nomTexte.getText();
            	
            	boolean creation = controleur.creerPays(code, nom);
            	
            	if(creation) {
            		controleur.enregister();
                	controleur.retour();
            	}else {
            		System.out.println("Une erreur est survenue");
            	}
            }
        }
    }
}
