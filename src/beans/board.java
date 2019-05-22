 package beans;

public class board {
	
	private int[][] sudoBoard = {
		{0,0,0,0,3,0,0,6,2},
	    {0,0,0,0,7,2,0,0,1},
	    {2,0,0,6,0,0,8,0,0},
	    
	    {1,0,9,4,0,6,0,8,7},
	    {0,0,4,0,0,0,2,0,0},
	    {5,8,0,1,0,7,6,0,4},
	    
	    {0,0,6,0,0,1,0,0,3},
	    {4,0,0,3,8,0,0,0,0},
	    {7,3,0,0,6,0,0,0,0}
	};
	
	private simpleCase[][] tab = new simpleCase[9][9];
	
	// Constructor
	public board() {
		for(int x = 0; x < 9; x++) {
			for(int y = 0; y < 9; y++) {
				tab[x][y] = new simpleCase(sudoBoard[x][y], x, y);
			}
		}
	}

	
	
	
	
	// Getters && Setters
	
	public board(int[][] board) {
		this.sudoBoard = board;
	}

	public int[][] getSudoBoard() {
		return sudoBoard;
	}

	public void setSudoBoard(int[][] sudoBoard) {
		this.sudoBoard = sudoBoard;
	}
	
	public simpleCase[][] getTab() {
		return tab;
	}

	public void setTab(simpleCase[][] tab) {
		this.tab = tab;
	}
	
}
