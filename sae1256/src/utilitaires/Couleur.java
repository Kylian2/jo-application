package utilitaires;

import java.awt.Color;

public enum Couleur {
    BLEU_JO(new Color(2, 120, 208)),
    JAUNE_JO(new Color(254, 202, 78)),
    VERT_JO(new Color(0, 202, 80)),
    ROUGE_JO(new Color(241, 40, 46)),
	COULEUR_FOND_JO(new Color(229, 229, 229));

    private Color color;

    Couleur(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}