package launchers;

import java.util.ArrayList;

import beans.BigCase;
import beans.Board;
import beans.SimpleCase;

public class Resolver {	

	private Board sudoBoard;
	private BigCase[] bigCases = new BigCase[9];
	
	// Constructor
	public Resolver() {
		sudoBoard = new Board();
		
		//TODO la boucle de l'infini
		
	}

	

	
 
	// Methods
	
	//TODO WIP
	private void globalCleaning() {
		for(int number = 1; number <= 9; number++) {
			for(BigCase bc : bigCases) {
				//TODO
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
	
	
	
	
	//TODO check
	// Remplissage des valeurs (par elimination dans un gros carre)
	private void fillValues(int grosCarreNumber) {
		for (int number = 1; number < 10; number ++) {
			ArrayList<SimpleCase> availables = new ArrayList<SimpleCase>();
			//recup de tt les cases
			for(SimpleCase c : bigCases[grosCarreNumber].getSimpleCases()) {
				if(c.getValue() != 0 && c.getPotentials().contains((Integer) number)) {
					availables.add(c);	
				}
			}
			System.out.println(availables.size());
			if(availables.size() == 1) {
				availables.get(0).setValue(number);
				availables.clear();
			}
		}
	}
	
	// Main program
 	public static void main (String args[]) {
 		new Resolver();
 	}

}
