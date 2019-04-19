package launchers;

import beans.board;

public class resolver {	

	private board sudoBoard;
	
	public resolver() {
		
	}

	public static void main(String[] args) {
		
	}
	
	 
	
	// Méthodes
	
	private boolean checkIfIsInTheLine(int c, int value) {
 		for(int l = 0; l < 9; l++) {
 			if(sudoBoard[l][c] == value) return true;
 		}
 		return false;
 	}
	 	

	private boolean checkIfIsInTheColumn(int l, int value) {
 		for(int c = 0; c < 9; c++) {
 			if(sudoBoard[l][c] == value) return true;
 		}
 		return false;
 	}
	
 	
 	private boolean checkBigSquarre(int c, int l, int value) {
 		for(int col = 0; col < 3; col++) {
 			for(int row = 0; row < 3; row++) {
 				if(sudoBoard[l][c] == value) return true;
 			}
 		}
 		return false;
 	}
	 
	 
	 

}
