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

	
	
	
	/*
	une case :
	
	champs
		int value
		[int] liste de pententielles nombre
		int posX
		int posY
		
		
	méthodes
		setValue
		getValue
		getPosX
		getPosY
		regarder le gros carr�
			
		
	
	
	
	
	*/
}
