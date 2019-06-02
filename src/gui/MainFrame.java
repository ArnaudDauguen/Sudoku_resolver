package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import launchers.Resolver;

public class MainFrame extends JFrame implements ActionListener {

	private Resolver resolver;
	private JButton[][] grid = new JButton[9][9];
	private JTextPane chat = new JTextPane();
	// Creation d'un style pour pouvoir centrer du texte
	private SimpleAttributeSet styleCentrer = new SimpleAttributeSet();
	
	
	
	// Constructeur
	public MainFrame(Resolver resolver) {
		this.resolver = resolver;
		
		// Parametrage
		this.setSize(1000, 500);
		this.setTitle("Sudoku solver - DAUGUEN Arnaud && GANS Quentin");
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		// Conf du style de centrage
		StyleConstants.setAlignment(styleCentrer, StyleConstants.ALIGN_CENTER);
		
		
		
		// Premier panel
		JPanel panelGrid = new JPanel(new GridLayout(9, 9, 10, 10));
		panelGrid.setBorder(new EmptyBorder(10, 10, 10, 10));
		for(int l = 0; l < 9; l++) {
			for(int c = 0; c < 9; c++) {
				grid[l][c] = new JButton(" ");
				grid[l][c].putClientProperty("ligne", l);
				grid[l][c].putClientProperty("colonne", c);
				grid[l][c].addActionListener(this);
				panelGrid.add(grid[l][c]);
			}
		}
		
		this.add(panelGrid, BorderLayout.WEST);
		
		
		// Et pour le chat
		this.add(chat, BorderLayout.EAST);
		
		
		
		
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		resolver.printCaseInfos((int) btn.getClientProperty("ligne"), (int) btn.getClientProperty("colonne"));
		
	}
	
	public void changeChat(String message) {
		try {
			StyledDocument doc = chat.getStyledDocument();
			doc.insertString(0, message, styleCentrer);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());;
		}
	}
	
	public JButton[][] getGrid(){ return grid;}
}
