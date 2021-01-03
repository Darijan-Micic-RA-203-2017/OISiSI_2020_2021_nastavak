package controller;

import view.MainFrame;
import view.SubjectAddingDialog;
import view.SubjectNonStudentsDataPanel;

/** REFERENCA: Materijali za vežbe (v6 -> JTableMVCSimple -> controller -> IgraciController.java) */
public class SubjectsController {
	private static SubjectsController instance = null;

	public static SubjectsController getInstance() {
		if (instance == null) {
			instance = new SubjectsController();
		}
		
		return instance;
	}
	
	// Konstruktor:
	private SubjectsController() {}
	
	// Radnje:
	public void addSubject(SubjectAddingDialog subjectAddingDialog) {
		SubjectNonStudentsDataPanel subjectNonStudentsDataPanel = 
				subjectAddingDialog.getSubjectNonStudentsDataPanel();
		
		String id = subjectNonStudentsDataPanel.getIdTextField().getText();
		String name = subjectNonStudentsDataPanel.getNameTextField().getText();
		int yearOfStudyComboBoxSelectedIndex = 
				subjectNonStudentsDataPanel.getYearOfStudyComboBox().getSelectedIndex();
		int yearOfStudy = yearOfStudyComboBoxSelectedIndex + 1;
		/*
		int semesterComboBoxSelectedIndex = 
				subjectNonStudentsDataPanel.getSemesterComboBox().getSelectedIndex();
		Semester semester = null;
		if (semesterComboBoxSelectedIndex == 0) {
			semester = Semester.LETNJI;
		} else {
			semester = Semester.ZIMSKI;
		}
		*/
		
		String espbStringRepresentation = 
				subjectNonStudentsDataPanel.getEspbTextField().getText();
		int espb = Integer.parseInt(espbStringRepresentation);
		
		//SubjectsCollection.getInstance().addSubject(id, name, yearOfStudy, semester, espb);
		
		// Osvežavanje prikaza:
		MainFrame.getInstance().refreshView("ADDED", -1);
	}
}
