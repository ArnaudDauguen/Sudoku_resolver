package launchers;

import beans.GroupedCases;

import java.util.ArrayList;

import beans.Board;
import beans.SimpleCase;

public class Resolver {	

	private Board sudoBoard;
	private GroupedCases[] bigCases = new GroupedCases[9];
	private GroupedCases[] colonnes = new GroupedCases[9];
	private GroupedCases[] lignes = new GroupedCases[9];
	private int speed = 333;
	
	private ArrayList<String> chat = new ArrayList<String>();
	
	// Constructeur
	public Resolver() {
		sudoBoard = new Board();
		
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
				
				// Pour le gros carré
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
			globalCleaning();
			totalUpdate = globalFilling();
			insertLineInChat("*** Placement des nouveaux chiffres ***");
			render();
		}
		
		if(totalUpdate == 0) {
			insertLineInChat("J'arrive pooo");
		}else {
			insertLineInChat("Sudoku resolu !");
		}
		
		render();
		
		
		
	}

	

	

	// Methodes
	
	// Nettoyage global
	private void globalCleaning() {
		for(int n = 1; n <= 9; n++) {
			
			for(GroupedCases ligne : lignes) {
				if(ligne.checkForValue(n)) ligne.clean(n);
			}
			for(GroupedCases col : colonnes) {
				if(col.checkForValue(n)) col.clean(n);
			}
			for(GroupedCases sqr : bigCases) {
				if(sqr.checkForValue(n)) sqr.clean(n);
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
	
	// Affichage de la grille du sudoku
	public void render() {
		for(GroupedCases l : lignes) {
			for(SimpleCase c : l.getSimpleCases()) {
				System.out.print(c.getValue() + " ");
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
		chat.add(0, exp);
		//if(chat.size() > 20) chat.remove(20);
		//renderChat();
		System.out.println(chat.get(0));
		try {
			Thread.sleep(speed);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Affichage du chat
	private void renderChat() {
		for(String str : chat) {
			System.out.println(str);
		}
	}
	

 	// Main
 	
 	public static void main (String args[]) {
 		new Resolver();
 	}
 	
 	// Getter
 	
 	public Board getBoard() {
 		return sudoBoard;
 	}
 	
 	

}
