package launchers;

import java.util.ArrayList;

import beans.bigCase;
import beans.board;
import beans.simpleCase;

public class resolver {	

	private board sudoBoard;
	private bigCase[][] bigCases = new bigCase[3][3];
	
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
			  for(int nb = 1; nb < 10; nb++) {
				  
				  for(int c = 0; c < 9; c++) {
					  if(solver.checkIfIsInTheColumn(c, nb)) solver.cleanColumn(c, nb);
				  }
				  
				  for(int l = 0; l < 9; l++) {
					  if(solver.checkIfIsInTheLine(l, nb)) solver.cleanLine(l, nb);
				  }
				  
				  for(int c = 0; c < 3; c++) {
					  for(int l = 0; l < 3; l++) {
						  if(solver.checkBigSquarre(c, l, nb)) solver.cleanBigSquarre(c, l, nb);
					  }
				  }
				  
			  }
		  }
	}
	
	
 
	// Methods
	
	private boolean checkIfIsInTheLine(int c, int value) {
 		for(int l = 0; l < 9; l++) {
 			if(sudoBoard.getTab()[l][c].getValue() == value) return true;
 		}
 		return false;
 	}
	
	private void cleanLine(int l, int value) {
		for(int c = 0; c < 9; c++) {
			if(sudoBoard.getTab()[l][c].getValue() != 0) sudoBoard.getTab()[l][c].getPotentials().remove((Integer) value);
		}
	}
	 	

	private boolean checkIfIsInTheColumn(int l, int value) {
 		for(int c = 0; c < 9; c++) {
 			if(sudoBoard.getTab()[l][c].getValue() == value) return true;
 		}
 		return false;
 	}
	
	private void cleanColumn(int c, int value) {
		for(int l = 0; l < 9; l++) {
			if(sudoBoard.getTab()[l][c].getValue() != 0) sudoBoard.getTab()[l][c].getPotentials().remove((Integer) value);
		}
	}
	
 	
 	private boolean checkBigSquarre(int c, int l, int value) {
 		for(int col = 0; col < 3; col++) {
 			for(int row = 0; row < 3; row++) {
 				if(sudoBoard.getTab()[l][c].getValue() == value) return true;
 			}
 		}
 		return false;
 	}
 	
 	
 	private void cleanBigSquarre(int c, int l, int value) {
 		bigCase bc = getbigCaseBySimpleCase(l, c);
 		simpleCase[][] tmpCases = bc.getsimpleCases();
 		
 		// nettoyage des cases
 		for(int col = 0; col < 3; col++) {
 			for(int row = 0; row < 3; row++) {
 				if(tmpCases[l][c].getValue() != 0) tmpCases[l][c].getPotentials().remove((Integer) value);
 			}
 		}
 		
 		// nettoyage des lines/collones du carr�
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
	
	
	
	
	
	
	
	
 	
 	private bigCase getbigCaseBySimpleCase(int l, int c) {
 		int bigSquarrePosL = (int) (Math.ceil(l/3) -1);
 		int bigSquarrePosC = (int) (Math.ceil(c/3) -1);
 		return bigCases[bigSquarrePosL][bigSquarrePosC];
 	}
	 

}
