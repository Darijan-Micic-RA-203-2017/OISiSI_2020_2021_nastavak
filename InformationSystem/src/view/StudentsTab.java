package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class StudentsTab extends JPanel {
	// Polja:
	private StudentsTable studentsTable;
	private JScrollPane studentsScrollPane;
	
	// Konstruktor:
	public StudentsTab() {
		BorderLayout layout = new BorderLayout();
		setLayout(layout);
		
		studentsTable = new StudentsTable();
		studentsScrollPane = new JScrollPane(studentsTable);
		add(studentsScrollPane, BorderLayout.CENTER);
	}
	
	// Radnje:
	public StudentsTable getStudentsTable() {
		return studentsTable;
	}
}
