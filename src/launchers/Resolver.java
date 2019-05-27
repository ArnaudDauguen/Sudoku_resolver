package launchers;

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
		
		// Initialisation des cases
		
		for(int i = 0; i < 9; i++) {
			bigCases[i] = new GroupedCases();
			colonnes[i] = new GroupedCases();
			lignes[i] = new GroupedCases();
		}
		
		
		// Remplissage des lignes / colonnes / carres 
		for(int l = 0; l < 9; l++) {
			for(int c = 0; c < 9; c++) {
				SimpleCase sCase = sudoBoard.getTab()[l][c];
				
				// Pour le gros carré
				int posX = l / 3;
				int posY = c / 3;
				
				bigCases[posX * 3 + posY].addCase(sCase);
				lignes[l].addCase(sCase);
				colonnes[c].addCase(sCase);
			}
		}
		
		
		// Boucle principale
		while(!complete()) {
			globalCleaning();
			globalFilling();
			render();
			
			for(int u : lignes[8].getSimpleCases().get(8).getPotentials()) {
				System.out.println(u);
			}
		}
		
		
		System.out.println("Sudoku resolu !");
	}

	

	

	// Methodes
	
	// Nettoyage global
	private void globalCleaning() {
		for(int n = 1; n <= 9; n++) {
			
			for(GroupedCases ligne : lignes) {
				if(ligne.checkForValue(n)) ligne.clean(n);
			}
			for(GroupedCases col : colonnes) {
				if(col.checkForValue(n)) col.clean(n);
			}
			for(GroupedCases sqr : bigCases) {
				if(sqr.checkForValue(n)) sqr.clean(n);
			}
		}
	}

	
	// Remplissage global
	private void globalFilling() {
		for(int id = 0; id < 9; id++) {
			// Il faut juste parcourir toutes les cases UNE fois pour les remplir (mais pour nettoyer il faut faire les lignes, les colonnes et les carres)
			lignes[id].fillValues();
		}
	}
	
	// Affichage de la grille du sudoku
	public void render() {
		for(GroupedCases l : lignes) {
			for(SimpleCase c : l.getSimpleCases()) {
				System.out.print(c.getValue() + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	// Vérifie que toutes les cases soit remplis 
	public boolean complete() {
		for(GroupedCases l : lignes) {
			for(SimpleCase c : l.getSimpleCases()) {
				if(c.getValue() == 0) return false;
			}
		}
		return true;
	}
	

 	// Main
 	
 	public static void main (String args[]) {
 		new Resolver();
 	}
 	
 	// Getter
 	
 	public Board getBoard() {
 		return sudoBoard;
 	}
 	
 	

}
