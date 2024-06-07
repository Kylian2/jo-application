package modeles;

import java.util.ArrayList;

/**
 * Interface représentant un système de planification pour ordonner des sessions.
 * 
 * @author kylianrichard
 */
public interface Planning {

    /**
     * Ordonne par ordre chronologique les sessions pour une épreuve donnée.
     *
     * @param sessionsNonOrdonnee L'épreuve à planifier
     */
    public ArrayList<Session> OrdonneSession(ArrayList<Session> sessionsNonOrdonnee);

}

