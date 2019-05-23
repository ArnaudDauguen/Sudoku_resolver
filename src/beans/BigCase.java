package beans;

import java.util.ArrayList;

public class BigCase {

	private SimpleCase[] cases = new SimpleCase[9];
	
	// Constructor
	//TODO rework builder, use [] instead of arraylist
	public BigCase(ArrayList<SimpleCase> casesList) {
		// Mise en place des petits carres
		for(int x = 0; x < 9; x++) {
			cases[x] = casesList.get(x);
		}
		
	}
	
	
	
	// Methods
	
	public boolean checkForValue(int value) {
		for(SimpleCase c : cases) {
			if(c.getValue() == value) return true;
		}
		return false;
	}
	
	//TODO nettoyage
	public void clean(int number) {
		for(SimpleCase c : cases) {
			if(c.getValue() != 0) 
				if(c.getPotentials().contains((Integer)(number))) c.removePotential(number);
		}
	}
	

	// Getters && Setters
	
	public SimpleCase[] getSimpleCases(){
		return cases;
	}
	
	
	
	
	
}