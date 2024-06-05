package vues;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controleurs.ControleurAthlete;
import modeles.ApplicationJo;
import modeles.Discipline;

/**
 * Cette classe représente une vue pour afficher une liste de disciplines.
 * Elle étend JPanel et contient des fonctionnalités pour rafraîchir la liste des disciplines.
 * 
 * @author kylianrichard
 */
public class VueListeDiscipline extends JPanel {
    
    // Permet d'accéder aux données de l'application qui seront affichées.
    ApplicationJo application;
    
    // Panel servant à contenir les disciplines.
    JPanel panelDisciplineConteneur;
    
    JPanel panelDiscipline;
    
    ControleurAthlete controlleur; 
    
    Dimension dimension;
    
    JPanel header;
        
    /**
     * Constructeur de la classe VueListeDiscipline.
     * 
     * @param application L'instance de l'application qui contient les données.
     * @param dimension La dimension de cette vue.
     * 
     * @author kylianrichard
     */
    public VueListeDiscipline(ApplicationJo application, Dimension dimension) {
            
        this.application = application;
        application.recuperer();
        this.controlleur = controlleur;
        
        this.dimension = dimension;
        
        setLayout(new BorderLayout()); 
        this.setPreferredSize(dimension);

        this.panelDiscipline = new JPanel();
        panelDiscipline.setLayout(new BoxLayout(panelDiscipline, BoxLayout.Y_AXIS));
        panelDiscipline.setBackground(Color.WHITE);
        panelDiscipline.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panelDiscipline.setPreferredSize(dimension);

        
        // Header
        JPanel header = new JPanel(new BorderLayout());
        header.setMaximumSize(new Dimension((int) dimension.getWidth(), 50));
        header.setBackground(Color.WHITE);
        
        // Définir le titre
        JLabel titre = new JLabel("Disciplines");
        titre.setFont(new Font(titre.getFont().getName(), titre.getFont().getStyle(), 32));
        titre.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
        header.add(titre, BorderLayout.WEST);
        
        // Bouton ajouter
        JPanel panelBouton = new JPanel();
        panelBouton.setBackground(Color.WHITE);
        
        JButton button = new JButton("Ajouter");
        button.setPreferredSize(new Dimension(90, 35));
        button.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        button.setFocusPainted(false);
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                application.mainPanel.removeAll();
                controlleur.setLastPanel(VueListeDiscipline.this);
                // application.mainPanel.add(new VueAjouterAthlete(controlleur));

                // Rafraîchir le conteneur
                application.mainPanel.revalidate();
                application.mainPanel.repaint();
            }
            
        });
        panelBouton.add(button);
        
        header.add(panelBouton, BorderLayout.EAST);
        
        this.header = header;
        panelDiscipline.add(header);
       
        // Changer la couleur de fond du bouton
        button.setBackground(Color.GRAY);
        // Changer la couleur de la police du bouton
        button.setForeground(Color.WHITE);
        // Changer la couleur du fond de la fenêtre
        setBackground(Color.WHITE);
        
        panelDisciplineConteneur = new JPanel();
        panelDisciplineConteneur.setLayout(new GridLayout(3, 3, 10, 10));
        panelDisciplineConteneur.setMaximumSize(new Dimension(600, 600));
        panelDisciplineConteneur.setBackground(Color.WHITE);
        
        panelDiscipline.add(panelDisciplineConteneur);
        
        add(panelDiscipline, BorderLayout.CENTER);
        
        this.refresh();
    }
    
    /**
     * Rafraîchit la liste des disciplines et les affiche.
     * @author kylianrichard
     */
    public void refresh() {
        panelDisciplineConteneur.removeAll();
        int couleurCount = 0;
        for (Discipline discipline : application.disciplinesList) { 
            
            // Création d'un panel servant à recueillir les infos du pays
            JPanel panelSimpleDiscipline = new JPanel(new BorderLayout());
            panelSimpleDiscipline.setPreferredSize(new Dimension(100, 100));
            
            JLabel nomDiscipline = new JLabel(discipline.getNom(), JLabel.CENTER);
            nomDiscipline.setFont(new Font(nomDiscipline.getFont().getName(), nomDiscipline.getFont().getStyle(), 18));
            panelSimpleDiscipline.add(nomDiscipline, BorderLayout.CENTER);
            
            panelSimpleDiscipline.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    
                	application.mainPanel.removeAll();
                	application.mainPanel.add(new ListeEpreuve(application, dimension, discipline));
                	
                    application.mainPanel.revalidate();
                    application.mainPanel.repaint();
                }
            });
            // Définition du fond du conteneur 
            Color[] colors = {Couleur.BLEU_JO.getColor(), Couleur.JAUNE_JO.getColor(), Couleur.ROUGE_JO.getColor(), Couleur.VERT_JO.getColor()};
            
            panelSimpleDiscipline.setBackground(colors[couleurCount%colors.length]);
            couleurCount++;
            panelDisciplineConteneur.add(panelSimpleDiscipline);
        }
        
        // Rafraîchir le conteneur
        panelDisciplineConteneur.revalidate();
        panelDisciplineConteneur.repaint();
    }
}
