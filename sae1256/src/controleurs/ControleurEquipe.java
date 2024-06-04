package controleurs;

import java.util.ArrayList;

import javax.swing.JPanel;

import modeles.*;
import vues.VueListeAthlete;
import vues.VueListeEquipePays;

public class ControleurEquipe {
	
	public ApplicationJo application;
	public JPanel lastPanel;
	public Pays pays;
	
	public ControleurEquipe(ApplicationJo application){
		this.application = application;
	}
	
	public ArrayList<Discipline> getDisciplines(){
		ArrayList <Discipline> listeSansDisciplineDejaAjoute = new ArrayList<>(application.disciplinesList);
		for(Equipe equipe : pays.getEquipes()) {
			for (int i = 0; i< listeSansDisciplineDejaAjoute.size(); i++) {
				if(listeSansDisciplineDejaAjoute.get(i).getNom().equalsIgnoreCase(equipe.getDiscipline().getNom())) {
					listeSansDisciplineDejaAjoute.remove(i);
					continue;
				}
			}
		}
		return listeSansDisciplineDejaAjoute;
	}
	
	public void setLastPanel(JPanel panel) {
		this.lastPanel = panel;
	}
	
	public void setPays(Pays pays) {
		this.pays = pays;
	}
	
	public int getDisciplineIndex(String nom) {
		int index = -1;
		for (int i = 0; i < application.disciplinesList.size(); i++) {
			if(application.disciplinesList.get(i).getNom().equalsIgnoreCase(nom)) {
				index = i;
				continue;
			}
		}
		return index;
	}

	public boolean ajouterEquipe(String nom, String discipline) {
		
		int disciplineIndex = this.getDisciplineIndex(discipline);
		
		if(disciplineIndex >= 0) {
			this.pays.ajouterEquipe(new Equipe(nom, application.disciplinesList.get(disciplineIndex)));
			return true;
		}
		else {
			return false;
		}
	}
	
public void retour() {
		
		application.mainPanel.removeAll();
		application.mainPanel.add(lastPanel);
		((VueListeEquipePays) lastPanel).refresh();
		//application.mainPanel.add(application.vueListeAthlete);
		// Rafraîchir le conteneur
        application.mainPanel.revalidate();
        application.mainPanel.repaint();
		
	}

public boolean supprimerEquipe(Equipe equipe) {
    System.out.println("Nombre d'équipes avant suppression : " + pays.getEquipes().size());
    
    for (int i = 0; i < pays.getEquipes().size(); i++) {
        Equipe equipeCourante = pays.getEquipes().get(i);
        
        System.out.println(equipeCourante.getDiscipline().getNom() + " - " + equipe.getDiscipline().getNom());
        
        if (equipeCourante.getDiscipline().getNom().equalsIgnoreCase(equipe.getDiscipline().getNom())) {
            System.out.println("Equipe trouvée : " + equipeCourante.getDiscipline().getNom());
            
            // Définir l'équipe des athlètes à null
            for (Athlete athlete : equipeCourante.getMembres()) {
                athlete.setEquipe(null);
                System.out.println("Mise à jour de l'athlète : " + athlete.getNom());
            }
            
            // Retirer l'équipe de la liste
            Equipe equipeSupprimee = pays.getEquipes().remove(i);
            System.out.println("Equipe supprimée : " + equipeSupprimee.getNom());
            System.out.println("Nombre d'équipes après suppression : " + pays.getEquipes().size());
            this.application.enregister();
            this.application.recuperer();
            return equipeSupprimee != null;
        }
    }
    
    System.out.println("Equipe non trouvée");
    return false;
}

private Object typeof(Equipe remove) {
	// TODO Auto-generated method stub
	return null;
}
}
