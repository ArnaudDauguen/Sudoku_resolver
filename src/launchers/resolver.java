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
			sudoBoard.getTab()[l][c].getPotentials().remove((Integer) value);
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
			// Cast la value en Integer
			sudoBoard.getTab()[l][c].getPotentials().remove((Integer) value);
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
 		
 		int bigSquarrePosL = (int) (Math.ceil(l/3) -1);
 		int bigSquarrePosC = (int) (Math.ceil(c/3) -1);
 		
 		
 		simpleCase[][] tmpCases = bigCases[bigSquarrePosL][bigSquarrePosC].getsimpleCases();
 		
 		
 		for(int col = 0; col < 3; col++) {
 			for(int row = 0; row < 3; row++) {
 				if(tmpCases[l][c].getValue() == value) {
 					
 				}
 			}
 		}
 	}
 		
 		
 	
	 

}
