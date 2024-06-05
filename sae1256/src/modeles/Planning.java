package modeles;

import java.util.ArrayList;

/**
 * Interface représentant un système de planification pour ordonner des sessions.
 * 
 * @author kylianrichard
 */
public interface Planning {

    /**
     * Ordonne par ordre chronologique les session pour une épreuve donnée.
     *
     * @param epreuve l'épreuve (test ou examen) à planifier
     */
    public ArrayList<Session> OrdonneSession(ArrayList<Session> sessionsNonOrdonnee);

}

