package view;

import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.Student;

public class FailedSubjectsPanel extends JPanel {
	private Student selectedStudent;
	
	private JPanel upperPanel;
	private JButton addSubject;
	private JButton deleteSubject;
	private JButton takeExam;
	
	private FailedSubjectsTable failedSubjectsTable;
	private JScrollPane failedSubjectsTableScrollPane;
	
	private JPanel bottomPanel;
	
	public FailedSubjectsPanel(Student selectedStudent) {
		BorderLayout layout = new BorderLayout(0, 10);
		setLayout(layout);
		
		this.selectedStudent = selectedStudent;
		
		setUpFailedSubjectsTable();
		
		setUpUpperPanel();
		add(upperPanel, BorderLayout.NORTH);
		
		setUpBottomPanel();
		add(bottomPanel, BorderLayout.SOUTH);
		
		add(failedSubjectsTableScrollPane, BorderLayout.CENTER);
	}
	
	public FailedSubjectsTable getFailedSubjectsTable() {
		return failedSubjectsTable;
	}
	
	private void setUpUpperPanel() {
		/** REFERENCA: Materijali za vežbe (v5 -> Termin5 - Layout.pdf) */
		upperPanel = new JPanel();
		BoxLayout upperPanelLayout = new BoxLayout(upperPanel, BoxLayout.X_AXIS);
		upperPanel.setLayout(upperPanelLayout);
		
		addSubject = new JButton("Dodaj");
		deleteSubject = new JButton("Obriši");
		takeExam = new JButton("Polaganje");
		
		upperPanel.add(Box.createHorizontalStrut(5));
		upperPanel.add(addSubject);
		upperPanel.add(Box.createHorizontalStrut(5));
		upperPanel.add(deleteSubject);
		upperPanel.add(Box.createHorizontalStrut(5));
		upperPanel.add(takeExam);
		upperPanel.add(Box.createGlue());
	}
	
	private void setUpFailedSubjectsTable() {
		failedSubjectsTable = new FailedSubjectsTable(selectedStudent.getIndexNumber());
		failedSubjectsTableScrollPane = new JScrollPane(failedSubjectsTable);
	}
	
	private void setUpBottomPanel() {
		bottomPanel = new JPanel();
		BoxLayout bottomPanelLayout = new BoxLayout(bottomPanel, BoxLayout.X_AXIS);
		bottomPanel.setLayout(bottomPanelLayout);
		
		bottomPanel.add(Box.createGlue());
		
	}
	
	
}
