package controller;

import model.GradesCollection;
import model.Professor;
import model.ProfessorsCollection;
import model.SemesterOfSubject;
import model.StudentsCollection;
import model.Subject;
import model.SubjectsCollection;
import view.MainFrame;
import view.SubjectAddingDialog;
import view.SubjectEditingDialog;
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
		int semesterComboBoxSelectedIndex = 
				subjectNonStudentsDataPanel.getSemesterComboBox().getSelectedIndex();
		SemesterOfSubject semester = null;
		if (semesterComboBoxSelectedIndex == 0) {
			semester = SemesterOfSubject.LETNJI;
		} else {
			semester = SemesterOfSubject.ZIMSKI;
		}
		String espbStringRepresentation = 
				subjectNonStudentsDataPanel.getEspbTextField().getText();
		int espb = Integer.parseInt(espbStringRepresentation);
		
		SubjectsCollection.getInstance().addSubject(id, name, semester, yearOfStudy, espb);
		
		// Osvežavanje prikaza:
		MainFrame.getInstance().refreshView("ADDED", -1);
	}
	
	public void editSubjectNonStudentsData(int rowSelectedIndex, 
			SubjectEditingDialog subjectEditingDialog) {
		if (rowSelectedIndex >= 0) {
			// Izmena modela:
			Subject subject = SubjectsCollection.getInstance().getRow(rowSelectedIndex);
			
			SubjectNonStudentsDataPanel subjectNonStudentsDataPanel = 
					subjectEditingDialog.getSubjectNonStudentsDataPanel();

			String newId = subjectNonStudentsDataPanel.getIdTextField().getText();
			String name = subjectNonStudentsDataPanel.getNameTextField().getText();
			int yearOfStudyComboBoxSelectedIndex = 
					subjectNonStudentsDataPanel.getYearOfStudyComboBox().getSelectedIndex();
			int yearOfStudy = yearOfStudyComboBoxSelectedIndex + 1;
			int semesterComboBoxSelectedIndex = 
					subjectNonStudentsDataPanel.getSemesterComboBox().getSelectedIndex();
			SemesterOfSubject semester = null;
			if (semesterComboBoxSelectedIndex == 0) {
				semester = SemesterOfSubject.LETNJI;
			} else {
				semester = SemesterOfSubject.ZIMSKI;
			}
			String espbStringRepresentation = 
					subjectNonStudentsDataPanel.getEspbTextField().getText();
			int espb = Integer.parseInt(espbStringRepresentation);
			// Privremeno, dok ne bude napravljena funkcionalnost:
			Professor professor = new Professor();
			
			String oldId = subject.getId();
			SubjectsCollection.getInstance().editSubjectNonStudentsData(oldId, newId, name, 
					semester, yearOfStudy, espb, professor);

			// Osvežavanje prikaza:
			MainFrame.getInstance().refreshView(null, -1);
		}
	}
	
	public void deleteSubject(int selectedRowIndex) {
		Subject subject = SubjectsCollection.getInstance().getRow(selectedRowIndex);
		String subjectId = subject.getId();
		
		// Izmena modela:
		StudentsCollection.getInstance().deleteSubjectFromStudentsRecords(subjectId);
		
		GradesCollection.getInstance().deleteGradesForSubject(subjectId);
		
		Professor professor = subject.getProfessor();
		if (professor != null) {
			String nationalIdOfProfessor = professor.getNationalID();
			
			ProfessorsCollection.getInstance().
					deleteSubjectFromProfessorsRecords(nationalIdOfProfessor, subjectId);
		}
		
		SubjectsCollection.getInstance().deleteSubject(subjectId);
		
		// Osvežavanje prikaza:
		MainFrame.getInstance().refreshView("DELETED SUBJECT", selectedRowIndex);
	}
	
	public void moveStudentToNonPassedList(String subjectId, String indexNumber) {
		SubjectsCollection.getInstance().moveStudentToNonPassedList(subjectId, indexNumber);
	}
}
