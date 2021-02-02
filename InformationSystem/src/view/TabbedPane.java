package view;

import javax.swing.JTabbedPane;

public class TabbedPane extends JTabbedPane {
	private StudentsTab studentsTab;
	private ProfessorsTab professorsTab;
	private SubjectsTab subjectsTab;
	
	public TabbedPane() {
		studentsTab = new StudentsTab();
		add("Studenti", studentsTab);
		
		professorsTab = new ProfessorsTab();
		add("Profesori", professorsTab);
		
		subjectsTab = new SubjectsTab();
		add("Predmeti", subjectsTab);
	}
	
	public StudentsTab getStudentsTab() {
		return studentsTab;
	}
	
	public ProfessorsTab getProfessorsTab() {
		return professorsTab;
	}
	
	public SubjectsTab getSubjectsTab() {
		return subjectsTab;
	}
}
