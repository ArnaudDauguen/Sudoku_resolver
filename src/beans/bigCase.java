package beans;

import java.util.ArrayList;
import java.util.Arrays;

public class bigCase {

	private simpleCase[] cases = new simpleCase[9];
	
	// Constructor
	public bigCase(ArrayList<simpleCase> casesList) {
		// Mise en place des petits carres
		for(int x = 0; x < 9; x++) {
			cases[x] = casesList.get(x);
		}
		
	}
	
	
	
	// Methodes
	
	public boolean checkForValue(int value) {
		for(simpleCase c : cases) {
			if(c.getValue() == value) return true;
		}
		return false;
	}
	
	//TODO nettoyage
	

	// Getters && Setters
	
	public simpleCase[] getSimpleCases(){
		return cases;
	}
	
	
	
	
	
}