package view;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import model.StatusOfStudent;
import model.Student;
import model.StudentsCollection;

public class StudentEditingTabbedPane extends JTabbedPane {
	// Polja:
	private Student selectedStudent;
	private StudentNonGradesDataPanel studentNonGradesDataPanel;
	private PassedSubjectsPanel passedSubjectsPanel;
	private FailedSubjectsPanel failedSubjectsPanel;
	
	// Konstruktor:
	public StudentEditingTabbedPane(int selectedRowIndex, String typeOfParentDialog) {
		selectedStudent = StudentsCollection.getInstance().getRow(selectedRowIndex);
		
		studentNonGradesDataPanel = 
				new StudentNonGradesDataPanel(typeOfParentDialog, selectedRowIndex);
		fillStudentNonGradesDataPanel();
		
		JScrollPane nonGradesDataScrollPane = new JScrollPane(studentNonGradesDataPanel);
		add("Informacije", nonGradesDataScrollPane);
		
		passedSubjectsPanel = new PassedSubjectsPanel(selectedStudent);
		add("Položeni", passedSubjectsPanel);
		
		failedSubjectsPanel = new FailedSubjectsPanel(selectedStudent);
		add("Nepoloženi", failedSubjectsPanel);
	}
	
	public Student getSelectedStudent() {
		return selectedStudent;
	}
	
	public StudentNonGradesDataPanel getStudentNonGradesDataPanel() {
		return studentNonGradesDataPanel;
	}
	
	public PassedSubjectsPanel getPassedSubjectsPanel() {
		return passedSubjectsPanel;
	}
	
	public FailedSubjectsPanel getFailedSubjectsPanel() {
		return failedSubjectsPanel;
	}
	
	private void fillStudentNonGradesDataPanel() {
		String firstName = selectedStudent.getFirstName();
		studentNonGradesDataPanel.getFirstNameTextField().setText(firstName);
		studentNonGradesDataPanel.getIncorrectFirstNameMessageLabel().setVisible(false);
		
		String lastName = selectedStudent.getLastName();
		studentNonGradesDataPanel.getLastNameTextField().setText(lastName);
		studentNonGradesDataPanel.getIncorrectLastNameMessageLabel().setVisible(false);
		
		/** REFERENCA: https://www.javatpoint.com/java-date-to-string */
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
		Date dateOfBirth = selectedStudent.getDateOfBirth();
		String dateOfBirthInString = sdf.format(dateOfBirth);
		studentNonGradesDataPanel.getDateOfBirthTextField().setText(dateOfBirthInString);
		studentNonGradesDataPanel.getIncorrectDateOfBirthMessageLabel().setVisible(false);
		
		String residence = selectedStudent.getResidence();
		studentNonGradesDataPanel.getAddressTextField().setText(residence);
		
		String contactPhone = selectedStudent.getContactPhone();
		studentNonGradesDataPanel.getContactPhoneTextField().setText(contactPhone);
		studentNonGradesDataPanel.getIncorrectContactPhoneMessageLabel().setVisible(false);
		
		String emailAddress = selectedStudent.getEmailAddress();
		studentNonGradesDataPanel.getEmailAddressTextField().setText(emailAddress);
		studentNonGradesDataPanel.getIncorrectEmailAddressMessageLabel().setVisible(false);
		
		String indexNumber = selectedStudent.getIndexNumber();
		studentNonGradesDataPanel.getIndexNumberTextField().setText(indexNumber);
		studentNonGradesDataPanel.getIncorrectIndexNumberMessageLabel().setVisible(false);
		
		int yearOfEnrollment = selectedStudent.getYearOfEnrollment();
		String yearOfEnrollmentInString = Integer.toString(yearOfEnrollment);
		studentNonGradesDataPanel.getYearOfEnrollmentTextField().setText(yearOfEnrollmentInString);
		studentNonGradesDataPanel.getIncorrectYearOfEnrollmentMessageLabel().setVisible(false);
		
		int currentYearOfStudy = selectedStudent.getCurrentYearOfStudy();
		studentNonGradesDataPanel.getCurrentYearOfStudyComboBox().setSelectedIndex(currentYearOfStudy - 1);
		
		StatusOfStudent statusOfStudent = selectedStudent.getStatusOfStudent();
		if (statusOfStudent == StatusOfStudent.B) {
			studentNonGradesDataPanel.getStatusOfStudentComboBox().setSelectedIndex(0);
		} else {
			studentNonGradesDataPanel.getStatusOfStudentComboBox().setSelectedIndex(1);
		}
	}
}
