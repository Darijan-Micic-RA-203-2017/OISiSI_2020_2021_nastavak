package view;

import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.Professor;;

public class TeachingSubjectsPanel extends JPanel {
	private Professor selectedProfessor;
	
	private JPanel upperPanel;
	private JButton addSubjectButton;
	private JButton deleteSubjectButton;
	
	private TeachingSubjectsTable teachingSubjectsTable;
	private JScrollPane teachingSubjectsTableScrollPane;
	
	private JPanel bottomPanel;
	private JPanel blankPanel;
	
	public TeachingSubjectsPanel(Professor selectedProfessor) {
		BorderLayout layout = new BorderLayout(0, 10);
		setLayout(layout);
		
		this.selectedProfessor = selectedProfessor;
		
		setUpTeachingSubjectsTable();
		
		setUpUpperPanel();
		add(upperPanel, BorderLayout.NORTH);
		
		setUpBottomPanel();
		add(bottomPanel, BorderLayout.SOUTH);
		
		add(teachingSubjectsTableScrollPane, BorderLayout.CENTER);
	}
	
	private void setUpUpperPanel() {
		/** REFERENCA: Materijali za vežbe (v5 -> Termin5 - Layout.pdf) */
		upperPanel = new JPanel();
		BoxLayout upperPanelLayout = new BoxLayout(upperPanel, BoxLayout.X_AXIS);
		upperPanel.setLayout(upperPanelLayout);
		
		addSubjectButton = new JButton("Dodaj predmet");
		deleteSubjectButton = new JButton("Ukloni predmet");
		
		upperPanel.add(Box.createHorizontalStrut(5));
		upperPanel.add(addSubjectButton);
		upperPanel.add(Box.createHorizontalStrut(5));
		upperPanel.add(deleteSubjectButton);
		upperPanel.add(Box.createGlue());
	}
	
	private void setUpTeachingSubjectsTable() {
		teachingSubjectsTable = new TeachingSubjectsTable(selectedProfessor.getNationalID());
		teachingSubjectsTableScrollPane = new JScrollPane(teachingSubjectsTable);
	}
	
	private void setUpBottomPanel() {
		bottomPanel = new JPanel();
		BoxLayout bottomPanelLayout = new BoxLayout(bottomPanel, BoxLayout.X_AXIS);
		bottomPanel.setLayout(bottomPanelLayout);
		
		blankPanel = new JPanel();
		BoxLayout blankPanelLayout = new BoxLayout(blankPanel, BoxLayout.Y_AXIS);
		blankPanel.setLayout(blankPanelLayout);
		
		bottomPanel.add(Box.createGlue());
		bottomPanel.add(blankPanel);
		bottomPanel.add(Box.createHorizontalStrut(5));
	}
}
