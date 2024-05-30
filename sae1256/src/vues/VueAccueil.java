package vues;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;

public class VueAccueil extends JPanel{
	 	protected JPanel PanelText, PanelIMG, PanelIMG1, PanelIMG2, PanelIMG3, PanelIMG4;
	    protected JLabel TexteAccueil;
	    protected JLabel ImageLabel1, ImageLabel2, ImageLabel3, ImageLabel4;
	
	    public VueAccueil() {
	    	 // Création des panels
	        JPanel PanelText = new JPanel();
	        JPanel PanelIMG = new JPanel();
	        JLayeredPane PanelIMG1 = new JLayeredPane();
	        JLayeredPane PanelIMG2 = new JLayeredPane();
	        JLayeredPane PanelIMG3 = new JLayeredPane();
	        JLayeredPane PanelIMG4 = new JLayeredPane();

	        // Créations d'autres éléments pour mettre dans les panels
	        JButton BoutonIMG1 = new JButton("Voir les Résultats 	");
	        BoutonIMG1.setBackground(Color.RED);
	        BoutonIMG1.setForeground(Color.WHITE);

	        JButton BoutonIMG2 = new JButton("Accéder aux équipes 	");
	        BoutonIMG2.setBackground(Color.BLUE);
	        BoutonIMG2.setForeground(Color.WHITE);

	        JButton BoutonIMG3 = new JButton("Voir le planning		");
	        BoutonIMG3.setBackground(Color.GREEN);
	        BoutonIMG3.setForeground(Color.WHITE);

	        JButton BoutonIMG4 = new JButton("Voir les athlètes 	");
	        BoutonIMG4.setBackground(Color.YELLOW);
	        BoutonIMG4.setForeground(Color.WHITE);

	        JLabel TexteAccueil = new JLabel("Salut Louis !");
	        TexteAccueil.setFont(new Font("Arial", Font.PLAIN, 32));

	        // On importe les images depuis le dossier img
	        ImageIcon image1 = new ImageIcon("img/img_accueil1.png");
	        ImageIcon image2 = new ImageIcon("img/img_accueil2.png");
	        ImageIcon image3 = new ImageIcon("img/img_accueil3.png");
	        ImageIcon image4 = new ImageIcon("img/img_accueil4.png");

	        // On met les images dans des Labels
	        JLabel ImageLabel1 = new JLabel(image1);
	        JLabel ImageLabel2 = new JLabel(image2);
	        JLabel ImageLabel3 = new JLabel(image3);
	        JLabel ImageLabel4 = new JLabel(image4);
	        
	        // Configuration des panels avec JLayeredPane
	        configurationDesLayeredPane(PanelIMG1, ImageLabel1, BoutonIMG1);
	        configurationDesLayeredPane(PanelIMG2, ImageLabel2, BoutonIMG2);
	        configurationDesLayeredPane(PanelIMG3, ImageLabel3, BoutonIMG3);
	        configurationDesLayeredPane(PanelIMG4, ImageLabel4, BoutonIMG4);

	        // Les layout et border sur les panels de plus haut niveau
	        PanelText.setLayout(new FlowLayout(FlowLayout.LEFT));
	        PanelText.setBorder(new EmptyBorder(10, 0, 20, 0));
	        PanelIMG.setBorder(new EmptyBorder(0, 0, 0, 200));
	        PanelIMG.setLayout(new GridLayout(2, 2, 15, 15));

	        // On ajoute dans les panels de plus haut niveau
	        PanelIMG.add(PanelIMG1);
	        PanelIMG.add(PanelIMG2);
	        PanelIMG.add(PanelIMG3);
	        PanelIMG.add(PanelIMG4);
	        PanelText.add(TexteAccueil);

	        // Répartit les panels dans panel de niveau 2 dans le panel principal
	        setLayout(new BorderLayout());
	        add(PanelText, BorderLayout.NORTH);
	        add(PanelIMG, BorderLayout.CENTER);
	    }

	    // Permet le superpositionnement des éléments entre images et boutons
	    private void configurationDesLayeredPane(JLayeredPane layer, JLabel imageLabel, JButton button) {
	    	
	    	// Récupération de la taille des éléments
	        int LargeurImage = imageLabel.getIcon().getIconWidth();
	        int Longueurimage = imageLabel.getIcon().getIconHeight();
	        int Largeurbouton = 200;
	        int Longueurbouton = 30;

	        layer.setPreferredSize(new Dimension(LargeurImage, Longueurimage));

	        // Positionnement du bouton en bas à droite
	        imageLabel.setBounds(0, 0, LargeurImage, Longueurimage);
	        button.setBounds(LargeurImage - Largeurbouton - 10, Longueurimage - Longueurbouton - 10, Largeurbouton, Longueurbouton); 

	        // Intégration dans le layerPane
	        layer.add(imageLabel, JLayeredPane.DEFAULT_LAYER);
	        layer.add(button, JLayeredPane.PALETTE_LAYER);
	    }	    

    // Permet de créer la fenêtre de l'interface graphique
    public static void main(String[] args) {
        JFrame fenetre = new JFrame("Accueil");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setSize(960,540);
        fenetre.add(new VueAccueil());
        fenetre.setVisible(true);
    }
}
