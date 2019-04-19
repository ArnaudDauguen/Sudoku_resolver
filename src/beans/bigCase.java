package beans;

import java.util.ArrayList;
import java.util.Arrays;

public class bigCase {

	
	private simpleCase[][] cases = new simpleCase[3][3];
	
	private ArrayList<Integer> potentialsValuesForColumns1 = new ArrayList<Integer>();
	private ArrayList<Integer> potentialsValuesForLines1 = new ArrayList<Integer>();
	private ArrayList<Integer> potentialsValuesForColumns2 = new ArrayList<Integer>();
	private ArrayList<Integer> potentialsValuesForLines2 = new ArrayList<Integer>();
	private ArrayList<Integer> potentialsValuesForColumns3 = new ArrayList<Integer>();
	private ArrayList<Integer> potentialsValuesForLines3 = new ArrayList<Integer>();
	
	
	//constructor
	public bigCase(ArrayList<simpleCase> casesList) {
		for(int i = 1; i <= 9; i++) {
			potentialsValuesForColumns1.add(i);
			potentialsValuesForColumns2.add(i);
			potentialsValuesForColumns3.add(i);
			potentialsValuesForLines1.add(i);
			potentialsValuesForLines2.add(i);
			potentialsValuesForLines3.add(i);
		}
		
		// mise en place des petits carrés
		for(int x = 0; x < 3; x++) {
			for(int y = 0; y < 3; y++) {
				cases[x][y] = casesList.get(x + y);
			}
		}
		
	}
	
	
	
	
	public ArrayList<Integer> getLine(int x) {
		ArrayList<Integer> listL = new ArrayList<Integer>();
		for(int i = 0; i < 3; i++) {
			listL.add(cases[x][i].getValue());
		}
		return listL;
	}
	
	public ArrayList<Integer> getColumn(int y) {
		ArrayList<Integer> listC = new ArrayList<Integer>();
		for(int i = 0; i < 3; i++) {
			listC.add(cases[i][y].getValue());
		}
		return listC;
	}
	
	
	
	
	
	
	
	
	
	
	

	/*
	une case :
	
	champs
		[pttcase]
		
		[[int], [int], [int]] potialsValuesForColumns
		[[int], [int], [int]] potialsValuesForLines
		
		
	mÃ©thodes
		getLine(x)               //getLine(simpleCase.getposX())
		getColumn(y)
		
		blockColumn(int colone) => [int] (regarder chaques cases pour bloquer)
		blockLine(int line) => [int] (regarder chaques cases pour bloquer)
			
		
	
	
	
	
	*/
	
	
	
	
	
	
	
	
}
