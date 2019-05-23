package beans;

import java.util.ArrayList;
import java.util.Arrays;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class GroupedCases {

	private ArrayList<SimpleCase> cases = new ArrayList<SimpleCase>();
	// pour un gros carre, imaginer 3x3
	// pour une ligne, imaginer 1x9
	// pour une colonne, imaginer 9x1
	
	// Constructor
	public GroupedCases(ArrayList<SimpleCase> casesList) {
		
	}
	
	
	
	// Methodes
	
	public boolean checkForValue(int value) {
		for(SimpleCase c : cases) {
			if(c.getValue() == value) return true;
		}
		return false;
	}
	
	// nettoyage
	public void clean(int number) {
		for(SimpleCase c : cases) {
			if(c.getValue() != 0) if(c.getPotentials().contains((Integer)(number))) c.removePotential(number);
		}
	}
	
	
	// remplissage des valuers (par elimination)
	private void fillValues() {
		for (int number = 1; number <= 9; number ++) {
			ArrayList<SimpleCase> availables = new ArrayList<SimpleCase>();
			//recup de tt les cases
			for(SimpleCase c : cases) {
				if(c.getValue() != 0 && c.getPotentials().contains((Integer) number)) {
					availables.add(c);	
				}
			}
			if(availables.size() == 1) {
				availables.get(0).setValue(number);
			}
			availables.clear();
		}
	}

	// Getters && Setters
	
	public ArrayList<SimpleCase> getSimpleCases(){
		return cases;
	}
	
	public void addCase(SimpleCase c) {
		cases.add(c);
	}
	
	
	
	
	
}