package modeles;

import java.io.Serializable;
import java.util.ArrayList;

public class Recompense implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Equipe equipe;
	private Athlete athlete;
	private Pays pays;
	private int or;
	private int argent;
	private int bronze;

	public Recompense(Athlete athlete) {
		this.athlete = athlete;
		this.pays = null;
		this.equipe = null;
		this.or = 0;
		this.argent = 0;
		this.bronze = 0;
	}
	
	public Recompense(Pays pays) {
		this.pays = pays;
		this.athlete = null;
		this.pays = null;
		this.or = 0;
		this.argent = 0;
		this.bronze = 0;
	}
	
	public Recompense(Equipe equipe) {
		this.equipe = equipe;
		this.pays = null;
		this.athlete = null;
		this.or = 0;
		this.argent = 0;
		this.bronze = 0;
	}
	

	public void ajouterOr() {
		or++;
	}

	public void ajouterArgent() {
		argent++;
	}

	public void ajouterBronze() {
		bronze++;
	}

	public void retirerOr() {
		or--;
	}

	public void retirerArgent() {
		argent--;
	}

	public void retirerBronze() {
		bronze--;
	}

	public int getOr() {
		return or;
	}

	public int getArgent() {
		return argent;
	}

	public int getBronze() {
		return bronze;
	}

}