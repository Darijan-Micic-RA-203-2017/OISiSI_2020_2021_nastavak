package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.StatusOfStudent;
import model.Student;
import model.StudentsCollection;
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
	
	// Konstruktor:
	private StudentsController() {}
	
	// Radnje:
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
		MainFrame.getInstance().refreshView("ADDED", -1);
	}

	public void deleteStudent(int rowSelectedIndex) {
		if (rowSelectedIndex >= 0) {
			// Izmena modela:
			Student student = StudentsCollection.getInstance().getRow(rowSelectedIndex);
			StudentsCollection.getInstance().deleteStudent(student.getIndexNumber());
			
			// Osvežavanje prikaza:
			MainFrame.getInstance().refreshView("DELETED", rowSelectedIndex);
		}
	}

	public void editStudentNonGradesData(int rowSelectedIndex, 
			StudentEditingDialog studentEditingDialog) {
		if (rowSelectedIndex >= 0) {
			// Izmena modela:
			Student student = StudentsCollection.getInstance().getRow(rowSelectedIndex);
			
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
			MainFrame.getInstance().refreshView(null, -1);
		}
	}
}
