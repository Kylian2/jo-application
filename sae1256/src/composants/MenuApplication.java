package composants;

import javax.swing.*;
import javax.swing.border.Border;

import utilitaires.Couleur;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//TODO : 
// - Gerer les actions à l'appui sur les boutons
// - ajouter l'affichage du profil de l'utilisateur si implémentation

public class MenuApplication extends JPanel {
	
	// Constantes pour les dimensions
    private static final int BUTTON_WIDTH = 200;
    private static final int BUTTON_HEIGHT = 50;
	
    public MenuApplication() {
        // Panneau principal
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Couleur.COULEUR_FOND_JO.getColor());
                
        // Logo des anneaux olympiques
        ImageIcon icon = new ImageIcon("img/logo-jo.png");
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(150, 68, Image.SCALE_SMOOTH);
        icon = new ImageIcon(newImg);
        
        JLabel logo = new JLabel(icon);
        logo.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        logo.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(logo);
        
        // Boutons du menu
        JButton athletesButton = createMenuButton("Athlètes", Couleur.BLEU_JO);
        JButton delegationsButton = createMenuButton("Délégations", Couleur.JAUNE_JO);
        JButton resultsButton = createMenuButton("Résultats", Couleur.VERT_JO);
        JButton planningButton = createMenuButton("Planning", Couleur.BLEU_JO);
        JButton disciplineButton = createMenuButton("Discipline", Couleur.ROUGE_JO);
        
        // Ajouter les boutons au panneau principal
        add(athletesButton);
        add(delegationsButton);
        add(resultsButton);
        add(planningButton);
        add(disciplineButton);
        
    }
    
    private JButton createMenuButton(String text, Couleur couleur) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setMaximumSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        button.setBackground(Color.WHITE);
        button.setFont(new Font("Arial", Font.PLAIN, 26));
        button.setHorizontalAlignment(SwingConstants.LEFT);
        
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(10, 10, 0, 10), 
                BorderFactory.createMatteBorder(0, 0, 2, 0, couleur.getColor()) // Bordure de couleur de 2 pixels en bas
        ));
        
        return button;
    }
}
