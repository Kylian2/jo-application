package vues;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.EmptyBorder;

import controleurs.ControleurAthlete;
import controleurs.ControleurSession;
import modeles.ApplicationJo;
import sae1256.Main;

/**
 * La classe VueAccueil représente la vue principale de la page d'accueil de l'application.
 * Elle contient des panneaux et des boutons qui permettent de naviguer vers différentes sections de l'application.
 * 
 * @author estebanrodrigues
 */
public class VueAccueil extends JPanel{
    protected JPanel PanelText, PanelIMG, PanelIMG1, PanelIMG2, PanelIMG3, PanelIMG4;
    protected JLabel TexteAccueil;
    protected JLabel ImageLabel1, ImageLabel2, ImageLabel3, ImageLabel4;
    
    ApplicationJo application;

    /**
     * Construit la VueAccueil avec le conteneur et l'application spécifiés.
     * 
     * @param vueConteneur le panneau conteneur
     * @param application le modèle de l'application
     */
    public VueAccueil(JPanel vueConteneur, ApplicationJo application) {
        
        this.application = application;
        // Création des panels
        JPanel PanelText = new JPanel();
        PanelText.setBackground(Color.WHITE);
        JPanel PanelIMG = new JPanel(new GridLayout(2, 2));
        PanelIMG.setBackground(Color.WHITE);
        JLayeredPane PanelIMG1 = new JLayeredPane();
        JLayeredPane PanelIMG2 = new JLayeredPane();
        JLayeredPane PanelIMG3 = new JLayeredPane();
        JLayeredPane PanelIMG4 = new JLayeredPane();

        // Créations d'autres éléments pour mettre dans les panels
        JButton BoutonIMG1 = new JButton("Voir les Résultats 	");
        BoutonIMG1.setBackground(Couleur.ROUGE_JO.getColor());
        BoutonIMG1.setForeground(Color.WHITE);
        

        JButton BoutonIMG2 = new JButton("Accéder aux délégations 	");
        BoutonIMG2.setBackground(Couleur.BLEU_JO.getColor());
        BoutonIMG2.setForeground(Color.WHITE);
        
        BoutonIMG2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //Masquer les autres
                vueConteneur.removeAll();
                vueConteneur.add(new VueListePays(application, new Dimension(700, 540)), BorderLayout.CENTER);
                
                // Rafraîchir le conteneur
                vueConteneur.revalidate();
                vueConteneur.repaint();
            }
            
        });

        JButton buttonPlanning = new JButton("Voir le planning		");
        buttonPlanning.setBackground(Couleur.VERT_JO.getColor());
        buttonPlanning.setForeground(Color.WHITE);
        
        buttonPlanning.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //Masquer les autres
                vueConteneur.removeAll();
                //Afficher le panel correspondant
                ControleurSession controleurSession = new ControleurSession(VueAccueil.this.application);
                vueConteneur.add(new VueApercuSession(controleurSession, Main.DIMENSION), BorderLayout.CENTER);
                
                // Rafraîchir le conteneur
                vueConteneur.revalidate();
                vueConteneur.repaint();
            }
        });

        JButton buttonAthlete = new JButton("Voir les athlètes 	");
        buttonAthlete.setBackground(Couleur.JAUNE_JO.getColor());
        buttonAthlete.setForeground(Color.WHITE);

        buttonAthlete.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //Masquer les autres
                vueConteneur.removeAll();
                //Afficher le panel correspondant
                ControleurAthlete controleur = new ControleurAthlete(application);
                vueConteneur.add(new VueListeAthlete(controleur, Main.DIMENSION), BorderLayout.CENTER);
                
                // Rafraîchir le conteneur
                vueConteneur.revalidate();
                vueConteneur.repaint();
            }
        });
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
        configurationDesLayeredPane(PanelIMG3, ImageLabel3, buttonPlanning);
        configurationDesLayeredPane(PanelIMG4, ImageLabel4, buttonAthlete);

        // Les layout et border sur les panels de plus haut niveau
        PanelText.setLayout(new FlowLayout(FlowLayout.LEFT));
        PanelText.setBorder(new EmptyBorder(10, 15, 10, 20));
        PanelIMG.setBorder(new EmptyBorder(0, 20, 20, 20));
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

    /**
     * Configure le JLayeredPane pour superposer les boutons sur les images.
     * 
     * @param layer le JLayeredPane à configurer
     * @param imageLabel le JLabel contenant l'image
     * @param button le JButton à superposer sur l'image
     */
    private void configurationDesLayeredPane(JLayeredPane layer, JLabel imageLabel, JButton button) {
        
        // Récupération de la taille des éléments
        int LargeurImage = imageLabel.getIcon().getIconWidth();
        int Longueurimage = imageLabel.getIcon().getIconHeight();
        int Largeurbouton = 200;
        int Longueurbouton = 30;

        layer.setPreferredSize(new Dimension(LargeurImage, Longueurimage));

        // Positionnement du bouton en bas à droite
        imageLabel.setBounds(0, 0, LargeurImage, Longueurimage);
        button.setBounds(LargeurImage - Largeurbouton - 50, Longueurimage - Longueurbouton - 10, Largeurbouton, Longueurbouton); 

        // Intégration dans le layerPane
        layer.add(imageLabel, JLayeredPane.DEFAULT_LAYER);
        layer.add(button, JLayeredPane.PALETTE_LAYER);
    }    
}
