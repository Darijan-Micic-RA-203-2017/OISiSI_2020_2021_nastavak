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
	private StudentNonGradesDataPanel studentNonGradesDataPanel;
	private JPanel passedSubjectsPanel;
	private JPanel unpassedSubjectsPanel;
	
	// Konstruktor:
	public StudentEditingTabbedPane(int selectedRowIndex, String typeOfParentDialog) {
		studentNonGradesDataPanel = 
				new StudentNonGradesDataPanel(typeOfParentDialog, selectedRowIndex);
		fillStudentNonGradesDataPanel(selectedRowIndex);
		
		JScrollPane nonGradesDataScrollPane = new JScrollPane(studentNonGradesDataPanel);
		add("Informacije", nonGradesDataScrollPane);
		
		passedSubjectsPanel = new JPanel();
		add("Položeni", passedSubjectsPanel);
		
		unpassedSubjectsPanel = new JPanel();
		add("Nepoloženi", unpassedSubjectsPanel);
	}
	
	public StudentNonGradesDataPanel getStudentNonGradesDataPanel() {
		return studentNonGradesDataPanel;
	}
	
	private void fillStudentNonGradesDataPanel(int selectedRowIndex) {
		Student selectedStudent = StudentsCollection.getInstance().getRow(selectedRowIndex);
		
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
