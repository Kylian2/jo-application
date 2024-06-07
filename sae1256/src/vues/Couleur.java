package vues;

import java.awt.Color;

/**
 * Enumération contenant les couleurs de l'application.
 * @author kylianrichard
 */
public enum Couleur {
    BLEU_JO(new Color(2, 120, 208)),
    JAUNE_JO(new Color(254, 202, 78)),
    VERT_JO(new Color(74, 163, 89)),
    ROUGE_JO(new Color(220, 62, 66)),
	COULEUR_FOND_JO(new Color(229, 229, 229)),
	OR(new Color(252, 200, 97)),
	ARGENT(new Color(215, 213, 213)),
	BRONZE(new Color(220, 179, 134));

    private Color color;

    Couleur(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}