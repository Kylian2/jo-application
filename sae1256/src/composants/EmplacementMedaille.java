package composants;

import javax.swing.*;

import utilitaires.Couleur;

import java.awt.*;

public class EmplacementMedaille extends JPanel {
	
    private String[] texts = {"-", "-", "-"};

    public EmplacementMedaille() {
        setPreferredSize(new Dimension(110, 50));
        this.setBackground(Couleur.COULEUR_FOND_JO.getColor());
    }

    public void setValeur(int index, int valeur) {
        if (index >= 0 && index < texts.length) {
            texts[index] = valeur+"";
            repaint();
        }
    }

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

