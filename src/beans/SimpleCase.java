package beans;

import java.util.ArrayList;

public class SimpleCase {
	
	private int value = 0;
	private int posX;
	private int posY;
	
	private ArrayList<Integer> potentials = new ArrayList<Integer>();
	
	public SimpleCase(int value, int posX, int posY) {
		this.value = value;
		this.posX = posX;
		this.posY = posY;

		// Ajout de tous les nombres potentiels si la case n'a pas deja de valeur
		if(this.value == 0) {
			for(int i = 1; i <= 9; i++) {
				potentials.add(i);
			}
		}
	}
	
	// Methodes
	
	// Supprime une valeur potentiel
	public boolean removePotential(int number) {
		return potentials.remove((Integer) number);
	}
	
	// Vide l'ArrayList de valeurs potentiels
	public void clearPotentials() {
		potentials.clear();
		
	}
	
	public String getInfos() {
		String infos = String.format("La case %d:%d ", posX, posY);
		if(value == 0) {
			infos += "peut contenir [";
			for(int i = 0; i < potentials.size(); i++) {
				infos += potentials.get(i);
				if(i < potentials.size() -1) infos += ",";
			}
			infos += "]";
		}else {
			infos += String.format("contient un %d", value);
		}
		return infos;
	}
	
	
	
	
	
	// Getters && Setters
	
	public void setValue(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
	
	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}
	
	public void setPotentials(ArrayList<Integer> potentials) {
		this.potentials = potentials;
	}

	public void addPotentials(int nb) {
		potentials.add(nb);
	}
	
	public ArrayList<Integer> getPotentials() {
		return potentials;
	}


}