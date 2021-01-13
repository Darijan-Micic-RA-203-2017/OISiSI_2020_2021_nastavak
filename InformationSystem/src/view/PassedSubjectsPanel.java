package view;

import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.Student;

public class PassedSubjectsPanel extends JPanel {
	// Polja:
	private Student selectedStudent;
	
	private JPanel upperPanel;
	private JButton gradeCancellationButton;
	
	private PassedSubjectsTable passedSubjectsTable;
	private JScrollPane passedSubjectsTableScrollPane;
	
	private JPanel bottomPanel;
	private JPanel labelsPanel;
	private JLabel averageGradeLabel;
	private JLabel totalEspbLabel;
	
	// Konstruktor:
	public PassedSubjectsPanel(Student selectedStudent) {
		BorderLayout layout = new BorderLayout(0, 10);
		setLayout(layout);
		
		this.selectedStudent = selectedStudent;
		
		setUpPassedSubjectsTable();
		
		setUpUpperPanel();
		add(upperPanel, BorderLayout.NORTH);
		
		setUpBottomPanel();
		add(bottomPanel, BorderLayout.SOUTH);
		
		add(passedSubjectsTableScrollPane, BorderLayout.CENTER);
	}
	
	public JButton getGradeCancellationButton() {
		return gradeCancellationButton;
	}
	
	public PassedSubjectsTable getPassedSubjectsTable() {
		return passedSubjectsTable;
	}
	
	private void setUpUpperPanel() {
		/** REFERENCA: Materijali za vežbe (v5 -> Termin5 - Layout.pdf) */
		upperPanel = new JPanel();
		BoxLayout upperPanelLayout = new BoxLayout(upperPanel, BoxLayout.X_AXIS);
		upperPanel.setLayout(upperPanelLayout);
		
		gradeCancellationButton = new JButton("Poništi ocenu");
		gradeCancellationButton.setName("gradeCancellationButton");
		
		upperPanel.add(Box.createHorizontalStrut(5));
		upperPanel.add(gradeCancellationButton);
		upperPanel.add(Box.createGlue());
	}
	
	private void setUpPassedSubjectsTable() {
		passedSubjectsTable = new PassedSubjectsTable(selectedStudent.getIndexNumber());
		passedSubjectsTableScrollPane = new JScrollPane(passedSubjectsTable);
	}
	
	private void setUpBottomPanel() {
		/** REFERENCA: Materijali za vežbe (v3 -> Termin5 - Layout.pdf) */
		bottomPanel = new JPanel();
		BoxLayout bottomPanelLayout = new BoxLayout(bottomPanel, BoxLayout.X_AXIS);
		bottomPanel.setLayout(bottomPanelLayout);
		
		labelsPanel = new JPanel();
		BoxLayout labelsPanelLayout = new BoxLayout(labelsPanel, BoxLayout.Y_AXIS);
		labelsPanel.setLayout(labelsPanelLayout);
		
		averageGradeLabel = new JLabel();
		setAverageGradeLabelText();
		
		totalEspbLabel = new JLabel();
		setTotalEspbLabelText();
		
		labelsPanel.add(averageGradeLabel);
		labelsPanel.add(totalEspbLabel);
		
		bottomPanel.add(Box.createGlue());
		bottomPanel.add(labelsPanel);
		bottomPanel.add(Box.createHorizontalStrut(5));
	}
	
	public void setAverageGradeLabelText() {
		double averageGrade = selectedStudent.getAverageGrade();
		/** REFERENCA: https://java2blog.com/java-round-double-float-to-2-decimal-places/ */
		String averageGradeInString = Double.toString(Math.round(averageGrade * 100.0) / 100.0);
		averageGradeLabel.setText("Prosečna ocena: " + averageGradeInString);
	}
	
	public void setTotalEspbLabelText() {
		int totalEspb = selectedStudent.getTotalEspb();
		String totalEspbInString = Integer.toString(totalEspb);
		totalEspbLabel.setText("Ukupno ESPB: " + totalEspbInString);
	}
}
