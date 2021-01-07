package view;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PassedSubjectsPanel extends JPanel {
	// Polja:
	private JButton gradeCancellationButton;
	
	private JPanel averageGradeAndTotalEspbPanel;
	
	// Konstruktor:
	public PassedSubjectsPanel() {
		setUpGradeCancellationButton();
		
		setUpAverageGradeAndTotalEspbPanel();
	}
	
	private void setUpGradeCancellationButton() {
		gradeCancellationButton = new JButton("Poništi ocenu");
	}
	
	private void setUpAverageGradeAndTotalEspbPanel() {
		averageGradeAndTotalEspbPanel = new JPanel();
	}
}
