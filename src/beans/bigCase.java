package beans;

import java.util.ArrayList;
import java.util.Arrays;

public class bigCase {

	
	private simpleCase[][] cases = new simpleCase[3][3];
	
	private ArrayList<Integer> potentialsValuesForColumns1 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
	private ArrayList<Integer> potentialsValuesForLines1 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
	private ArrayList<Integer> potentialsValuesForColumns2 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
	private ArrayList<Integer> potentialsValuesForLines2 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
	private ArrayList<Integer> potentialsValuesForColumns3 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
	private ArrayList<Integer> potentialsValuesForLines3 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
	
	
	//constructor
	public bigCase() {
		
		
	}
	
	
	
	
	public ArrayList<Integer> getLine(int x) {
		return new ArrayList<Integer>(Arrays.asList(cases[x][0].getValue(), cases[x][1].getValue(), cases[x][2].getValue()));
	}
	
	public ArrayList<Integer> getColumn(int y) {
		return new ArrayList<Integer>(Arrays.asList(cases[0][y].getValue(), cases[1][y].getValue(), cases[2][y].getValue()));
	}
	

	/*
	une case :
	
	champs
		[pttcase]
		
		[[int], [int], [int]] potialsValuesForColumns
		[[int], [int], [int]] potialsValuesForLines
		
		
	méthodes
		getLine(x)               //getLine(simpleCase.getposX())
		getColumn(y)
		
		blockColumn(int colone) => [int] (regarder chaques cases pour bloquer)
		blockLine(int line) => [int] (regarder chaques cases pour bloquer)
			
		
	
	
	
	
	*/
	
	
	
	
	
	
	
	
}
