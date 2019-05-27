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
		
		
		// boucle principale
		//TODO trouver une methode pour terminer
		while(!complete()) {
			globalCleaning();
			globalFilling();
			render();
			
			for(int u : lignes[8].getSimpleCases().get(8).getPotentials()) {
				System.out.println(u);
			}
		}
		
		
		System.out.println("Sudoku résolu !");
	}

	

	
 
	// Methods
	
	// nettoyage global
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

	
	// remplissage global
	private void globalFilling() {
		for(int id = 0; id < 9; id++) {
			// il faut juste parcours toutes les cases UNE fois pour les remplir (mais pour nettoyer faut faire les lignes, colonnes et carres)
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
	
	
	public boolean complete() {
		for(GroupedCases l : lignes) {
			for(SimpleCase c : l.getSimpleCases()) {
				if(c.getValue() == 0) return false;
			}
		}
		return true;
	}
	
	
	
 	
 	// Getters && Setters
 	
 	public Board getBoard() {
 		return sudoBoard;
 	}
 	
 	


 	
 	
 	public static void main (String args[]) {
 		new Resolver();
 	}

}
