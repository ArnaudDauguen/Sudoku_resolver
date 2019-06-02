package beans;

import java.util.ArrayList;

import launchers.Resolver;

public class GroupedCases {

	private Resolver parent;
	private String type;
	private int tmpUpdate = 0;
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
	
	// Nettoyage par elimination, enleve les possiblites pour chaque cases
	public void stupidCleaning(int number) {
		
		// Par Elimination
		for(SimpleCase c : cases) {
			if(c.getValue() == 0) {
				if(c.removePotential(number)){
					if(c.getPotentials().size() == 1) {
						// creer une explication
						String expl = explication(0, c.getPosX(), c.getPosY(), c.getPotentials().get(0));
						parent.insertLineInChat(expl);
						System.out.println(expl);
					}
				}
			}
		}
		
	}
	
	// Nettoyage par 'reflexion', trouve la seule case ou placer un nombre
	public int logicalCleaning() {
		for (int nb = 1; nb <= 9; nb ++) {
			ArrayList<SimpleCase> availables = new ArrayList<SimpleCase>();
			// Recuperation de toutes les cases possibles pour ce nombre
			for(SimpleCase c : cases) {
				if(c.getValue() == 0 && c.getPotentials().contains((Integer) nb)) {
					availables.add(c);	
				}
			}
			if(availables.size() == 1) {
				SimpleCase c = availables.get(0);
				c.setValue(nb);
				removeAPotential(nb);
				tmpUpdate++;
				// creer une explication
				String expl = explication(1, c.getPosX(), c.getPosY(), c.getPotentials().get(0));
				parent.insertLineInChat(expl);
				System.out.println(expl);
			}
			availables.clear();
		}
		return tmpUpdate;
	}
	
	
	
	private void removeAPotential(int nb) {
		for(SimpleCase c : cases) {
			if(c.getValue() == 0) c.removePotential(nb);
		}
	}
	
	
	
	// Remplissage des cases
	public int fillValues() {
		int totalUpdate = tmpUpdate;
		for(SimpleCase c : cases) {
			if(c.getValue() == 0 && c.getPotentials().size() == 1) {
				c.setValue(c.getPotentials().get(0));
				totalUpdate++;
			}
		}
		tmpUpdate = 0;
		return totalUpdate;
	}
	
	// Creation de la phrase explicative
	private String explication(int categorie, int x, int y, int value) {
		if(categorie == 1) return String.format("La case %d:%d attend un %d car aucune autre case dans %s ne peut accueillir de %d", x, y, value, type, value);
		return String.format("La case %d:%d attend un %d car c'est la seule place pour un %d dans %s", x, y, value, value, type);
	}
	
	// Retourne la somme des cases
	public int sum() {
		int sum = 0;
		for(SimpleCase c : cases) {
			sum += c.getValue();
		}
		return sum;
	}

	// Getter 
	
	public ArrayList<SimpleCase> getSimpleCases(){
		return cases;
	}	

	
}