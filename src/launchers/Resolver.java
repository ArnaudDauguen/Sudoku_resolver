package launchers;

import java.util.ArrayList;

import beans.BigCase;
import beans.Board;
import beans.SimpleCase;

public class Resolver {	

	private Board sudoBoard;
	private BigCase[] bigCases = new BigCase[9];
	
	// Constructeur
	public Resolver() {
		sudoBoard = new Board();
		
		//TODO la boucle de l'infini
			// blogalCleaning
			// grosCarres.fillValues
	}

	

	
 
	// Methods
	
	//TODO WIP
	private void globalCleaning() {
		for(int number = 1; number <= 9; number++) {
			for(BigCase bc : bigCases) {
				bc.clean(number);
			}
			for(int i = 0; i < 9; i++) {
				if(checkIfIsInTheColumn(i, number)) cleanColumn(i, number);
				if(checkIfIsInTheLine(i, number)) cleanLine(i, number);
			}
		}
	}
	
	// Regarde si la valeur passer en parametre est dans la ligne
	private boolean checkIfIsInTheLine(int l, int value) {
 		for(int c = 0; c < 9; c++) {
 			if(sudoBoard.getTab()[l][c].getValue() == value) return true;
 		}
 		return false;
 	}
	
	// Nettoie une ligne
	private void cleanLine(int l, int value) {
		for(int c = 0; c < 9; c++) {
			if(sudoBoard.getTab()[l][c].getValue() == 0) sudoBoard.getTab()[l][c].getPotentials().remove((Integer) value);
		}
	}
	 	
	// Regarde si la valeur passer en parametre est dans une colonne
	private boolean checkIfIsInTheColumn(int c, int value) {
 		for(int l = 0; l < 9; l++) {
 			if(sudoBoard.getTab()[l][c].getValue() == value) return true;
 		}
 		return false;
 	}
	
	// Nettoie une colonne
	private void cleanColumn(int c, int value) {
		for(int l = 0; l < 9; l++) {
			if(sudoBoard.getTab()[l][c].getValue() == 0) sudoBoard.getTab()[l][c].getPotentials().remove((Integer) value);
		}
	}
	
	
	
	
	
	
	
	
 	
 	// Getters && Setters
 	
 	public Board getBoard() {
 		return sudoBoard;
 	}
 	
 	
 	
 	
 	
 	
 	public static void main (String args[]) {
 		new Resolver();
 	}

}
