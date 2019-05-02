package beans;

import java.util.ArrayList;

public class simpleCase {
	
	private int value;
	private int posX;
	private int posY;
	
	private ArrayList<Integer> potentials = new ArrayList<Integer>();
	
	public simpleCase(int value, int posX, int posY) {
		for(int i = 1; i <= 9; i++) {
			potentials.add(i);
		}
		this.value = value;
		this.posX = posX;
		this.posY = posY;
		
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
	
	public ArrayList<Integer> getPotentials() {
		return potentials;
	}

}