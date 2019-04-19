package beans;

public class simpleCase {
	
	private int value;
	private int posX;
	private int posY;
	
	private int[] potentials = {1, 2, 3, 4, 5, 6, 7, 8, 9};
	
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
	
	public void setPotentials(int[] potentials) {
		this.potentials = potentials;
	}
	
	public int[] getPotentials() {
		return potentials;
	}

}
