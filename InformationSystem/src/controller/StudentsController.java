package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.Grade;
import model.GradesCollection;
import model.StatusOfStudent;
import model.Student;
import model.StudentsCollection;
import model.Subject;
import model.SubjectsCollection;
import view.MainFrame;
import view.StudentAddingDialog;
import view.StudentEditingDialog;
import view.StudentNonGradesDataPanel;

/** REFERENCA: Materijali za vežbe (v6 -> JTableMVCSimple -> controller -> IgraciController.java) */
public class StudentsController {
	private static StudentsController instance = null;

	public static StudentsController getInstance() {
		if (instance == null) {
			instance = new StudentsController();
		}
		
		return instance;
	}
	
	private StudentsController() {}
	
	public void addStudent(StudentAddingDialog studentAddingDialog) {
		StudentNonGradesDataPanel studentNonGradesDataPanel = 
				studentAddingDialog.getStudentNonGradesDataPanel();
		
		String lastName = studentNonGradesDataPanel.getLastNameTextField().getText();
		String firstName = studentNonGradesDataPanel.getFirstNameTextField().getText();
		String dateOfBirthStringRepresentation = 
				studentNonGradesDataPanel.getDateOfBirthTextField().getText();
		/** REFERENCA: https://www.javatpoint.com/java-string-to-date */
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
		Date dateOfBirth = null;
		try {
			dateOfBirth = sdf.parse(dateOfBirthStringRepresentation);
		} catch (ParseException pE) {
			pE.printStackTrace();
		}
		String residence = studentNonGradesDataPanel.getAddressTextField().getText();
		String contactPhone = studentNonGradesDataPanel.getContactPhoneTextField().getText();
		String emailAddress = studentNonGradesDataPanel.getEmailAddressTextField().getText();
		String indexNumber = studentNonGradesDataPanel.getIndexNumberTextField().getText();
		String yearOfEnrollmentStringRepresentation = 
				studentNonGradesDataPanel.getYearOfEnrollmentTextField().getText();
		int yearOfEnrollment = Integer.parseInt(yearOfEnrollmentStringRepresentation);
		int currentYearOfStudyComboBoxSelectedIndex = 
				studentNonGradesDataPanel.getCurrentYearOfStudyComboBox().getSelectedIndex();
		int currentYearOfStudy = currentYearOfStudyComboBoxSelectedIndex + 1;
		int statusOfStudentComboBoxSelectedIndex = 
				studentNonGradesDataPanel.getStatusOfStudentComboBox().getSelectedIndex();
		StatusOfStudent statusOfStudent = null;
		if (statusOfStudentComboBoxSelectedIndex == 0) {
			statusOfStudent = StatusOfStudent.B;
		} else {
			statusOfStudent = StatusOfStudent.S;
		}
		
		StudentsCollection.getInstance().addStudent(lastName, firstName, dateOfBirth, 
				residence, contactPhone, emailAddress, indexNumber, yearOfEnrollment, 
				currentYearOfStudy, statusOfStudent);
		
		// Osvežavanje prikaza:
		MainFrame.getInstance().refreshView("ADDED STUDENT", -1);
	}
	
	public void deleteStudent(int rowSelectedIndex) {
		Student student = StudentsCollection.getInstance().getRow(rowSelectedIndex);
		
		// Izmena modela:
		StudentsCollection.getInstance().deleteStudent(student.getIndexNumber());
		
		ArrayList<Long> gradesIdsOfStudent = new ArrayList<Long>();
		ArrayList<String> passedSubjectsIdsOfStudent = new ArrayList<String>();
		for (Grade g : student.getPassedSubjects()) {
			gradesIdsOfStudent.add(g.getId());
			passedSubjectsIdsOfStudent.add(g.getSubject().getId());
		}
		
		ArrayList<String> nonPassedSubjectsIdsOfStudent = new ArrayList<String>();
		for (Subject s : student.getNonPassedSubjects()) {
			nonPassedSubjectsIdsOfStudent.add(s.getId());
		}
		
		GradesCollection.getInstance().deleteGradesOfStudent(gradesIdsOfStudent);
		
		SubjectsCollection.getInstance().
				deleteStudentFromSubjectsRecords(student.getIndexNumber(), 
						passedSubjectsIdsOfStudent, nonPassedSubjectsIdsOfStudent);

		// Osvežavanje prikaza:
		MainFrame.getInstance().refreshView("DELETED STUDENT", rowSelectedIndex);
	}
	
	public void editStudentNonGradesData(int selectedRowIndex, 
			StudentEditingDialog studentEditingDialog) {
		Student student = StudentsCollection.getInstance().getRow(selectedRowIndex);
		
		// Izmena modela:
		StudentNonGradesDataPanel studentNonGradesDataPanel = studentEditingDialog.
				getStudentEditingTabbedPane().getStudentNonGradesDataPanel();
		
		String lastName = studentNonGradesDataPanel.getLastNameTextField().getText();
		String firstName = studentNonGradesDataPanel.getFirstNameTextField().getText();
		String dateOfBirthStringRepresentation = 
				studentNonGradesDataPanel.getDateOfBirthTextField().getText();
		/** REFERENCA: https://www.javatpoint.com/java-string-to-date */
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
		Date dateOfBirth = null;
		try {
			dateOfBirth = sdf.parse(dateOfBirthStringRepresentation);
		} catch (ParseException pE) {
			pE.printStackTrace();
		}
		String residence = studentNonGradesDataPanel.getAddressTextField().getText();
		String contactPhone = studentNonGradesDataPanel.getContactPhoneTextField().getText();
		String emailAddress = studentNonGradesDataPanel.getEmailAddressTextField().getText();
		String newIndexNumber = studentNonGradesDataPanel.getIndexNumberTextField().getText();
		String yearOfEnrollmentStringRepresentation = 
				studentNonGradesDataPanel.getYearOfEnrollmentTextField().getText();
		int yearOfEnrollment = Integer.parseInt(yearOfEnrollmentStringRepresentation);
		int currentYearOfStudyComboBoxSelectedIndex = 
				studentNonGradesDataPanel.getCurrentYearOfStudyComboBox().getSelectedIndex();
		int currentYearOfStudy = currentYearOfStudyComboBoxSelectedIndex + 1;
		int statusOfStudentComboBoxSelectedIndex = 
				studentNonGradesDataPanel.getStatusOfStudentComboBox().getSelectedIndex();
		StatusOfStudent statusOfStudent = null;
		if (statusOfStudentComboBoxSelectedIndex == 0) {
			statusOfStudent = StatusOfStudent.B;
		} else {
			statusOfStudent = StatusOfStudent.S;
		}
		
		String oldIndexNumber = student.getIndexNumber();
		StudentsCollection.getInstance().editStudentNonGradesData(oldIndexNumber, lastName, 
				firstName, dateOfBirth, residence, contactPhone, emailAddress, 
				newIndexNumber, yearOfEnrollment, currentYearOfStudy, statusOfStudent);
		
		// Osvežavanje prikaza:
		MainFrame.getInstance().refreshView("EDITED STUDENT", selectedRowIndex);
	}
	
	public void cancelGrade(String indexNumber, long cancelledGradeId) {
		StudentsCollection.getInstance().cancelGrade(indexNumber, cancelledGradeId);
	}
}
