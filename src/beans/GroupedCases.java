package beans;

import java.util.ArrayList;

import launchers.Resolver;

public class GroupedCases {

	private Resolver parent;
	private String type;
	private ArrayList<SimpleCase> cases = new ArrayList<SimpleCase>();
	// Pour un gros carre, imaginer 3x3
	// Pour une ligne, imaginer 1x9
	// Pour une colonne, imaginer 9x1
	
	public GroupedCases(launchers.Resolver resolver, String type) {
		this.type = type;
		this.parent = resolver;
	}
	
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
			if(c.getValue() == 0) {
				if(c.getPotentials().contains((Integer)(number))) {
					c.removePotential((Integer) number);
					if(c.getPotentials().size() == 1) {
						// creer une explication
						parent.insertLineInChat(explication(c.getPosX(), c.getPosY(), c.getPotentials().get(0)));
					}
				}
			}
		}
		
	}
	
	
	// Remplissage des valeurs (par elimination)
	public int fillValues() {
		int totalUpdate = 0;
		for (int number = 1; number <= 9; number ++) {
			ArrayList<SimpleCase> availables = new ArrayList<SimpleCase>();
			// Recuperation de toutes les cases
			for(SimpleCase c : cases) {
				if(c.getValue() == 0 && c.getPotentials().contains((Integer) number)) {
					availables.add(c);	
				}
			}
			if(availables.size() == 1) {
				SimpleCase c = availables.get(0);
				c.setValue(number);
				c.clearPotentials();
				totalUpdate++;
			}
			availables.clear();
		}
		return totalUpdate;
	}
	
	// Creation de la phrase explicative
	private String explication(int x, int y, int value) {
		return String.format("La case %d:%d attend un %d car c'est la seule place pour un %d dans %s", x, y, value, value, type);
	}

	// Getter 
	
	public ArrayList<SimpleCase> getSimpleCases(){
		return cases;
	}	

	
}