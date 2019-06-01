package launchers;

import beans.GroupedCases;

import java.util.ArrayList;

import beans.Board;
import beans.SimpleCase;
import gui.MainFrame;

public class Resolver {	

	private MainFrame mainFrame;
	private Board sudoBoard;
	private GroupedCases[] bigCases = new GroupedCases[9];
	private GroupedCases[] colonnes = new GroupedCases[9];
	private GroupedCases[] lignes = new GroupedCases[9];
	private int nbSteepPerSecond = 10;
	private int speed = 1000/nbSteepPerSecond;
	
	private ArrayList<String> chat = new ArrayList<String>();
	
	// Constructeur
	public Resolver() {
		sudoBoard = new Board();
		mainFrame = new MainFrame(this);
		
		// Initialisation des cases
		
		for(int i = 0; i < 9; i++) {
			bigCases[i] = new GroupedCases(this, "son carre");
			colonnes[i] = new GroupedCases(this, "sa colonne");
			lignes[i] = new GroupedCases(this, "sa ligne");
		}
		
		
		// Remplissage des lignes / colonnes / carres 
		for(int l = 0; l < 9; l++) {
			for(int c = 0; c < 9; c++) {
				SimpleCase sCase = sudoBoard.getTab()[l][c];
				
				// Pour le gros carrÃ©
				int posX = l / 3;
				int posY = c / 3;
				
				bigCases[posX * 3 + posY].addCase(sCase);
				lignes[l].addCase(sCase);
				colonnes[c].addCase(sCase);
			}
		}
		
		
		int totalUpdate = -1;
		
		// Boucle principale
		while(!complete() && totalUpdate != 0) {
			// Affichage
			render();
			// Nettoyage
			globalCleaning();
			// Remplissage
			totalUpdate = globalFilling();
			insertLineInChat("*** Une boucle de resolution a été terminé ***");
		}
		
		
		// Fin de la resolution
		render();
		
		if(totalUpdate == 0) {
			insertLineInChat("J'arrive pooo");
		}else {
			// Calcul de la bonne resolution de la grille
			int sum = 0;
			for(int i = 0; i < 9; i++) {
				sum += lignes[i].sum();
				sum += colonnes[i].sum();
				sum += bigCases[i].sum();
			}

			
			// Suspens
			String resultat = sum == 45 * 9 * 3 ? "Sudoku Resolu et verifié !" : "Quelque chose ne va pas :/";
				// une ligne = 45 donc *9 pour toutes les lignes et *3 car lignes/colonnes/carres
			insertLineInChat(resultat);
			System.out.println(resultat);
			
		}
		
		
		
		
	}

	

	

	// Methodes
	
	// Nettoyage global
	private void globalCleaning() {
		// Nettoyage stupide
		for(int n = 1; n <= 9; n++) {
			for(GroupedCases ligne : lignes) {
				if(ligne.checkForValue(n)) ligne.stupidCleaning(n);
			}
			for(GroupedCases col : colonnes) {
				if(col.checkForValue(n)) col.stupidCleaning(n);
			}
			for(GroupedCases sqr : bigCases) {
				if(sqr.checkForValue(n)) sqr.stupidCleaning(n);
			}
			
		}
		// Nettoyage logique
		// Nous sommes contraints de limiter les nettoyages 'logiques' à seulement 1 type par tour sinon ils se confrontent
		int nbUpdate = 0;
		for(GroupedCases ligne : lignes) {
			nbUpdate += ligne.logicalCleaning();
		}
		if(nbUpdate < 1) {
			for(GroupedCases col : colonnes) {
				nbUpdate += col.logicalCleaning();
			}
		}
		if(nbUpdate < 1) {
			for(GroupedCases sqr : bigCases) {
				nbUpdate += sqr.logicalCleaning();
			}
		}
		
	}

	
	// Remplissage global
	private int globalFilling() {
		int totalUpdate = 0;
		for(int id = 0; id < 9; id++) {
			// Il faut juste parcourir toutes les cases UNE fois pour les remplir (mais pour nettoyer il faut faire les lignes, les colonnes et les carres)
			totalUpdate += lignes[id].fillValues();
		}
		return totalUpdate;
	}
	
	// Affichage de la grille du sudoku (console et GUI)
	public void render() {
		System.out.println();
		for(GroupedCases l : lignes) {
			for(SimpleCase c : l.getSimpleCases()) {
				System.out.print(c.getValue() + " ");
				mainFrame.getGrid()[c.getPosX()][c.getPosY()].setText((String) (c.getValue() == 0 ? " " : ""+ c.getValue()));
			}
			System.out.println();
		}
		System.out.println();
	}
	
	// Verifie que toutes les cases soit remplis 
	public boolean complete() {
		for(GroupedCases l : lignes) {
			for(SimpleCase c : l.getSimpleCases()) {
				if(c.getValue() == 0) return false;
			}
		}
		return true;
	}
	
	// Rajout d'une ligne dans le chat
	public void insertLineInChat(String exp) {
		try {
			mainFrame.changeChat(exp + "\n");
			Thread.sleep(speed);
		} catch (InterruptedException e) {
			System.out.println("Une erreur est survenue :/");
		}
	}
	
	
	

	
 	// Getter
 	
 	public Board getBoard() {
 		return sudoBoard;
 	}
	
 	
 	
 	
 	
 	

 	// Main
 	
 	public static void main (String args[]) {
 		new Resolver();
 	}
 	
 	
 	

}
