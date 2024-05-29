package vues;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;

public class vueAccueil extends JPanel{
	 	protected JPanel PanelText, PanelIMG, PanelIMG1, PanelIMG2, PanelIMG3, PanelIMG4;
	    protected JLabel TexteAccueil;
	    protected JLabel ImageLabel1, ImageLabel2, ImageLabel3, ImageLabel4;
	
	    public vueAccueil() {
	    	// Création des Panels
	        JPanel PanelText = new JPanel();
	        JPanel PanelIMG = new JPanel();
	        JPanel PanelIMG1 = new JPanel();
	        JPanel PanelIMG2 = new JPanel();
	        JPanel PanelIMG3 = new JPanel();
	        JPanel PanelIMG4 = new JPanel();
	        JLabel TexteAccueil = new JLabel("Salut Louis !");
	        
	        TexteAccueil.setFont(new Font("Arial", Font.PLAIN, 36));

	        // Exportation des images
	        ImageIcon image1 = new ImageIcon("img/img_accueil1.png");
	        ImageIcon image2 = new ImageIcon("img/img_accueil2.png");
	        ImageIcon image3 = new ImageIcon("img/img_accueil3.png");
	        ImageIcon image4 = new ImageIcon("img/img_accueil4.png");

	        // On met les images dans des Label pour simplifier leur utilisation 
	        JLabel ImageLabel1 = new JLabel(image1);
	        JLabel ImageLabel2 = new JLabel(image2);
	        JLabel ImageLabel3 = new JLabel(image3);
	        JLabel ImageLabel4 = new JLabel(image4);

	        setLayout(new BorderLayout());

	        // Ajout des marges autour des images
	        ImageLabel1.setBorder(new EmptyBorder(10, 10, 10, 10));
	        ImageLabel2.setBorder(new EmptyBorder(10, 10, 10, 10));
	        ImageLabel3.setBorder(new EmptyBorder(10, 10, 10, 10));
	        ImageLabel4.setBorder(new EmptyBorder(10, 10, 10, 10));

	        // On ajoute dans les panels de plus haut niveau
	        PanelIMG.setLayout(new GridLayout(2, 2, 10, 10)); // Ajout d'espaces entre les cellules de GridLayout
	        PanelText.setLayout(new FlowLayout(FlowLayout.LEFT));
	        
	        PanelIMG1.add(ImageLabel1);
	        PanelIMG2.add(ImageLabel2);
	        PanelIMG3.add(ImageLabel3);
	        PanelIMG4.add(ImageLabel4);
	        
	        PanelIMG.add(PanelIMG1);
	        PanelIMG.add(PanelIMG2);
	        PanelIMG.add(PanelIMG3);
	        PanelIMG.add(PanelIMG4);
	        PanelText.add(TexteAccueil);

	        // Ajout d'une marge autour du PanelIMG pour espacer du PanelText
	        PanelIMG.setBorder(new EmptyBorder(20, 0, 0, 0)); // marge de 20 pixels en haut

	        // On modifie le placement des Panel principaux
	        add(PanelText, BorderLayout.NORTH);
	        add(PanelIMG, BorderLayout.CENTER);
	}	    

    // Main method for testing the panel
    public static void main(String[] args) {
        JFrame fenetre = new JFrame("Accueil");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setSize(960,540);
        fenetre.add(new vueAccueil());
        fenetre.setVisible(true);
    }
}
