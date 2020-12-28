package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.StatusOfStudent;
import model.Student;
import model.StudentsCollection;
import view.MainFrame;
import view.StudentAddingDialog;

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
		String lastName = studentAddingDialog.getLastNameTextField().getText();
		String firstName = studentAddingDialog.getFirstNameTextField().getText();
		String dateOfBirthStringRepresentation = 
				studentAddingDialog.getDateOfBirthTextField().getText();
		/** REFERENCA: https://www.javatpoint.com/java-string-to-date */
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
		Date dateOfBirth = null;
		try {
			dateOfBirth = sdf.parse(dateOfBirthStringRepresentation);
		} catch (ParseException pE) {
			pE.printStackTrace();
		}
		String residence = studentAddingDialog.getAddressTextField().getText();
		String contactPhone = studentAddingDialog.getContactPhoneTextField().getText();
		String emailAddress = studentAddingDialog.getEmailAddressTextField().getText();
		String indexNumber = studentAddingDialog.getIndexNumberTextField().getText();
		String yearOfEnrollmentStringRepresentation = 
				studentAddingDialog.getYearOfEnrollmentTextField().getText();
		int yearOfEnrollment = Integer.parseInt(yearOfEnrollmentStringRepresentation);
		int currentYearOfStudyComboBoxSelectedIndex = 
				studentAddingDialog.getCurrentYearOfStudyComboBox().getSelectedIndex();
		int currentYearOfStudy = currentYearOfStudyComboBoxSelectedIndex + 1;
		int statusOfStudentComboBoxSelectedIndex = 
				studentAddingDialog.getStatusOfStudentComboBox().getSelectedIndex();
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

	public void modifyStudentNonGradesData(int rowSelectedIndex) {
		if (rowSelectedIndex >= 0) {
			// Izmena modela:
			Student student = StudentsCollection.getInstance().getRow(rowSelectedIndex);
			
			/** REFERENCA: https://www.javatpoint.com/java-string-to-date */
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy.");
			
			String modifiedDateOfBirthStringRepresentation = "03.01.1998.";
			Date modifiedDateOfBirth = null;
			try {
				modifiedDateOfBirth = simpleDateFormat.parse(modifiedDateOfBirthStringRepresentation);
			} catch (ParseException pE) {
				pE.printStackTrace();
			}
			
			StudentsCollection.getInstance().modifyStudentNonGradesData(student.getIndexNumber(), 
					"Peka", "Stanislav", modifiedDateOfBirth, "Starca Vujadina 7, Kragujevac", 
					"0624560318", "marko.vitas@yahoo.com", 2019, 2, StatusOfStudent.S);
			
			// Osvežavanje prikaza:
			MainFrame.getInstance().refreshView(null, -1);
		}
	}
}
