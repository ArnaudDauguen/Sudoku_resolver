package launchers;

import java.util.ArrayList;

import beans.bigCase;
import beans.board;
import beans.simpleCase;

public class resolver {	

	private board sudoBoard;
	private bigCase[][] bigCases = new bigCase[3][3];
	
	// Constructeur
	public resolver() {
		for(int x = 0; x < 3; x++) {
			for(int y = 0; y < 3; y++) {
				ArrayList<simpleCase> casesList = new ArrayList<simpleCase>();
				
				for(int row = x*3; row < x*3+3; row++) {
					for(int col = x*3; col < x*3+3; col ++) {
						casesList.add(sudoBoard.getTab()[row][col]);
					}
				}
				bigCases[x][y] = new bigCase(casesList);
			}
		}
		
	}

	public static void main(String[] args) {
		
		  resolver solver = new resolver();
		  
		  while(true) {
			  // Pour les nombres entre 1 et 9 inclus
			  for(int nb = 1; nb < 10; nb++) {
				  
				  // Nettoyage colonne
				  for(int c = 0; c < 9; c++) {
					  if(solver.checkIfIsInTheColumn(c, nb)) solver.cleanColumn(c, nb);
				  }
				  // Nettoyage ligne
				  for(int l = 0; l < 9; l++) {
					  if(solver.checkIfIsInTheLine(l, nb)) solver.cleanLine(l, nb);
				  }
				  // Nettoyage gros carré
				  for(int c = 0; c < 3; c++) {
					  for(int l = 0; l < 3; l++) {
						  if(solver.checkBigSquarre(c, l, nb)) solver.cleanBigSquarre(c, l, nb);
					  }
				  } 
				  // Parcours toutes les cases
				  for(int c = 0; c < 9; c++) {
					  for(int l = 0; l < 9; l++) {
						 
					  }
				  }
			  }
		  }
	}
	
	
 
	// Methods
	
	// Regarde si la valeur passer en paramètre est dans la ligne
	private boolean checkIfIsInTheLine(int c, int value) {
 		for(int l = 0; l < 9; l++) {
 			if(sudoBoard.getTab()[l][c].getValue() == value) return true;
 		}
 		return false;
 	}
	
	// Nettoie une ligne
	private void cleanLine(int l, int value) {
		for(int c = 0; c < 9; c++) {
			if(sudoBoard.getTab()[l][c].getValue() != 0) sudoBoard.getTab()[l][c].getPotentials().remove((Integer) value);
		}
	}
	 	
	// Regarde si la valeur passer en paramètre est dans une colonne
	private boolean checkIfIsInTheColumn(int l, int value) {
 		for(int c = 0; c < 9; c++) {
 			if(sudoBoard.getTab()[l][c].getValue() == value) return true;
 		}
 		return false;
 	}
	
	// Nettoie une colonne
	private void cleanColumn(int c, int value) {
		for(int l = 0; l < 9; l++) {
			if(sudoBoard.getTab()[l][c].getValue() != 0) sudoBoard.getTab()[l][c].getPotentials().remove((Integer) value);
		}
	}
	
	// Regarde si la valeur passer en paramètre est dans le gros carré 3x3
 	private boolean checkBigSquarre(int c, int l, int value) {
 		for(int col = 0; col < 3; col++) {
 			for(int row = 0; row < 3; row++) {
 				if(sudoBoard.getTab()[l][c].getValue() == value) return true;
 			}
 		}
 		return false;
 	}
 	
 	// Nettoie un gros carré de 3x3
 	private void cleanBigSquarre(int c, int l, int value) {
 		bigCase bc = getbigCaseBySimpleCase(l, c);
 		simpleCase[][] tmpCases = bc.getsimpleCases();
 		
 		// nettoyage des cases
 		for(int col = 0; col < 3; col++) {
 			for(int row = 0; row < 3; row++) {
 				if(tmpCases[l][c].getValue() != 0) tmpCases[l][c].getPotentials().remove((Integer) value);
 			}
 		}
 		
 		// Nettoyage des lines/collones du carré
 		for(int i = 0; i < 3; i++) {
 			for(int j = 0; j < 3; j++) {
 				bc.cleanColumn(c, value);
 				bc.cleanLine(l, value);
 			}
 		}
 	}
 	
 				
	private boolean possibleValues(int c, int l, int value) {
 		return !this.checkIfIsInTheLine(c, value) 
 			&& !this.checkIfIsInTheColumn(l, value) 
 			&& !this.checkBigSquarre(c, l, value);
 	}
	
	
	
	
	
	
	
	
 	// Récupère les grosses cases 3x3 en fonction d'une petite case
 	private bigCase getbigCaseBySimpleCase(int l, int c) {
 		int bigSquarrePosL = (int) (Math.ceil(l/3) -1);
 		int bigSquarrePosC = (int) (Math.ceil(c/3) -1);
 		return bigCases[bigSquarrePosL][bigSquarrePosC];
 	}
	 

}
