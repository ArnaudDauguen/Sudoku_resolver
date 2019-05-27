package launchers;

import java.util.ArrayList;

import beans.GroupedCases;
import beans.Board;
import beans.SimpleCase;

public class Resolver {	

	private Board sudoBoard;
	private GroupedCases[] bigCases = new GroupedCases[9];
	private GroupedCases[] colonnes = new GroupedCases[9];
	private GroupedCases[] lignes = new GroupedCases[9];
	
	// Constructeur
	public Resolver() {
		sudoBoard = new Board();
		
		
		
		// initialisation des cases
		
		for(int i = 0; i < 9; i++) {
			bigCases[i] = new GroupedCases();
			colonnes[i] = new GroupedCases();
			lignes[i] = new GroupedCases();
		}
		
		
		// Remplissage des lignes colonnes carres 
		for(int l = 0; l < 9; l++) {
			for(int c = 0; c < 9; c++) {
				SimpleCase sCase = sudoBoard.getTab()[l][c];
				
				// For bigSquarre
				int posX = l / 3;
				int posY = c / 3;
				
				bigCases[posX * 3 + posY].addCase(sCase);
				lignes[l].addCase(sCase);
				colonnes[c].addCase(sCase);
			}
		}
		
		
		
		for(int i = 0; i < 20; i++) {
			globalCleaning();
			globalFilling();
			render();
		}
	}

	

	
 
	// Methods
	
	// nettoyage global
	private void globalCleaning() {
		for(int id = 0; id < 9; id++) {
			bigCases[id].cleanAll();
			colonnes[id].cleanAll();
			lignes[id].cleanAll();
		}
	}

	
	// remplissage global
	private void globalFilling() {
		for(int id = 0; id < 9; id++) {
			bigCases[id].fillValues();
			colonnes[id].fillValues();
			lignes[id].fillValues();
		}
	}
	
	
	public void render() {
		for(GroupedCases l : lignes) {
			for(SimpleCase c : l.getSimpleCases()) {
				System.out.print(c.getValue() + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	
	
	
	
	
//	// Regarde si la valeur passer en parametre est dans la ligne
//	private boolean checkIfIsInTheLine(int l, int value) {
// 		for(int c = 0; c < 9; c++) {
// 			if(sudoBoard.getTab()[l][c].getValue() == value) return true;
// 		}
// 		return false;
// 	}
//	
//	// Nettoie une ligne
//	private void cleanLine(int l, int value) {
//		for(int c = 0; c < 9; c++) {
//			if(sudoBoard.getTab()[l][c].getValue() == 0) sudoBoard.getTab()[l][c].getPotentials().remove((Integer) value);
//		}
//	}
//	 	
//	// Regarde si la valeur passer en parametre est dans une colonne
//	private boolean checkIfIsInTheColumn(int c, int value) {
// 		for(int l = 0; l < 9; l++) {
// 			if(sudoBoard.getTab()[l][c].getValue() == value) return true;
// 		}
// 		return false;
// 	}
//	
//	// Nettoie une colonne
//	private void cleanColumn(int c, int value) {
//		for(int l = 0; l < 9; l++) {
//			if(sudoBoard.getTab()[l][c].getValue() == 0) sudoBoard.getTab()[l][c].getPotentials().remove((Integer) value);
//		}
//	}
	
	
	
	
	
	
	
	
 	
 	// Getters && Setters
 	
 	public Board getBoard() {
 		return sudoBoard;
 	}
 	
 	
 	
 	
 	
 	
 	public static void main (String args[]) {
 		new Resolver();
 	}

}
