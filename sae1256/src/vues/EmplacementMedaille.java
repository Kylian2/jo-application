package vues;

import javax.swing.*;

import java.awt.*;

/**
 * Cette classe représente un emplacement pour afficher les médailles (or, argent, bronze) dans une interface graphique.
 * 
 * @author kylianrichard
 * 
 */
public class EmplacementMedaille extends JPanel {
	
    private String[] texts = {"-", "-", "-"};

    /**
     * Constructeur par défaut de l'emplacement pour les médailles.
     * Initialise la taille et la couleur de fond de l'emplacement.
     */
    public EmplacementMedaille() {
        setPreferredSize(new Dimension(110, 50));
        this.setBackground(Couleur.COULEUR_FOND_JO.getColor());
    }

    /**
     * Définit la valeur d'une médaille à un certain index.
     * 
     * @param index L'index de la médaille à modifier (0 pour l'or, 1 pour l'argent, 2 pour le bronze).
     * @param valeur La valeur à attribuer à la médaille.
     */
    public void setValeur(int index, int valeur) {
        if (index >= 0 && index < texts.length) {
            texts[index] = valeur+"";
            repaint();
        }
    }

    /**
     * Redessine l'emplacement pour les médailles avec les valeurs mises à jour.
     * 
     * @param g L'objet Graphics utilisé pour dessiner.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int circleDiameter = 30;
        int padding = 5;
        Color[] colors = {Couleur.OR.getColor(), Couleur.ARGENT.getColor(),Couleur.BRONZE.getColor()};

        for (int i = 0; i < 3; i++) {
            int x = padding + (circleDiameter + padding) * i;
            int y = 0;

            g2d.setColor(colors[i]);
            g2d.fillOval(x, y, circleDiameter, circleDiameter);

            g2d.setColor(Color.BLACK);
            FontMetrics fm = g2d.getFontMetrics();
            int textWidth = fm.stringWidth(texts[i]);
            int textHeight = fm.getAscent();

            g2d.drawString(texts[i], x + (circleDiameter - textWidth) / 2, y + (circleDiameter + textHeight) / 2);
        }
    }
}

