package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class SubjectsTab extends JPanel {
	private SubjectsTable subjectsTable;
	private JScrollPane subjectsScrollPane;
	
	public SubjectsTab() {
		BorderLayout layout = new BorderLayout();
		setLayout(layout);
		
		subjectsTable = new SubjectsTable();
		subjectsScrollPane = new JScrollPane(subjectsTable);
		add(subjectsScrollPane,BorderLayout.CENTER);
	}
	
	public SubjectsTable getSubjectsTable() {
		return subjectsTable;
	}
}
