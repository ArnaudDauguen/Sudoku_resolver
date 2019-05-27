package beans;

import java.util.ArrayList;

public class GroupedCases {

	private ArrayList<SimpleCase> cases = new ArrayList<SimpleCase>();
	// pour un gros carre, imaginer 3x3
	// pour une ligne, imaginer 1x9
	// pour une colonne, imaginer 9x1
	
	
	
	// Methodes
	
	// Permet d'ajouter une case
	public void addCase(SimpleCase c) {
		cases.add(c);
	}
	
	// Check si il y a une valeur sur une case
	public boolean checkForValue(int value) {
		for(SimpleCase c : cases) {
			if(c.getValue() == value) return true;
		}
		return false;
	}
	
	// Nettoyage
	public void clean(int number) {
		for(SimpleCase c : cases) {
			if(c.getValue() == 0) if(c.getPotentials().contains((Integer)(number))) c.removePotential((Integer) number);
		}
	}
	
	
	// Remplissage des valeurs (par elimination)
	public void fillValues() {
		for (int number = 1; number <= 9; number ++) {
			ArrayList<SimpleCase> availables = new ArrayList<SimpleCase>();
			// Récuperation de toutes les cases
			for(SimpleCase c : cases) {
				if(c.getValue() == 0 && c.getPotentials().contains((Integer) number)) {
					availables.add(c);	
				}
			}
			if(availables.size() == 1) {
				availables.get(0).setValue(number);
				availables.get(0).clearPotentials();
			}
			availables.clear();
		}
	}

	// Getter 
	
	public ArrayList<SimpleCase> getSimpleCases(){
		return cases;
	}	

	
}