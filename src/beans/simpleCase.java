package beans;

import java.util.ArrayList;
import java.util.Arrays;

public class simpleCase {
	
	private int value;
	private int posX;
	private int posY;
	
	private ArrayList<Integer> potentials = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
	
	public simpleCase(int value, int posX, int posY) {
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
