package beans;

import java.util.ArrayList;
import java.util.Arrays;

public class bigCase {

	
	private simpleCase[][] cases = new simpleCase[3][3];
	
	private int[][][] potentialsValues = new int[3][3][9];
	
	
	// Constructor
	public bigCase(ArrayList<simpleCase> casesList) {
		// Remplissage des valeurs potentielles
		for(int l = 0; l < 3; l++) {
			for(int c = 0; c < 3; c++) {
				for(int nb = 1; nb <= 9; nb++) {
					potentialsValues[l][c][nb-1] = nb; 
				}
			}
		}
		
		// Mise en place des petits carrés
		for(int x = 0; x < 3; x++) {
			for(int y = 0; y < 3; y++) {
				cases[x][y] = casesList.get(x + y);
			}
		}
		
	}
	
	
	
	// Recuperation d'une ligne de carre
	public ArrayList<Integer> getLine(int x) {
		ArrayList<Integer> listL = new ArrayList<Integer>();
		for(int i = 0; i < 3; i++) {
			listL.add(cases[x][i].getValue());
		}
		return listL;
	}
	
	// Recuperation d'une colonne de carre
	public ArrayList<Integer> getColumn(int y) {
		ArrayList<Integer> listC = new ArrayList<Integer>();
		for(int i = 0; i < 3; i++) {
			listC.add(cases[i][y].getValue());
		}
		return listC;
	}
	
	
	
	
	
	// Nettoie une ligne
	public void cleanLine(int l, int value) {
		for(int c = 0; c < 3; c++) {
			potentialsValues[l][c][value -1] = 0; 
		}
	}
	
	// Nettoie une colonne
	public void cleanColumn(int c, int value) {
		for(int l = 0; l < 3; l++) {
			potentialsValues[l][c][value -1] = 0; 
		}
	}
	
	
	
	

	
	
	
	

	// Getters && Setters
	
	public simpleCase[][] getsimpleCases(){
		return cases;
	}
	
	
	
	
	
}