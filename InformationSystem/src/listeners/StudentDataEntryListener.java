package listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.StudentsCollection;
import view.StudentNonGradesDataPanel;

/** REFERENCA: Materijali za vežbe (v4 -> b - Dogadjaji -> Dogadjaji -> listeners -> key -> MyKeyListener.java) */
public class StudentDataEntryListener implements KeyListener {
	// Polja:
	private StudentNonGradesDataPanel studentNonGradesDataPanel;
	private boolean indexNumberUniquenessNeed;
	
	// Konstruktor:
	public StudentDataEntryListener(StudentNonGradesDataPanel panel, 
			boolean indexNumberUniquenessNeed) {
		studentNonGradesDataPanel = panel;
		this.indexNumberUniquenessNeed = indexNumberUniquenessNeed;
	}

	// Radnje:
	@Override
	public void keyPressed(KeyEvent arg0) {}
	
	/** REFERENCA: https://www.javatpoint.com/java-regex */
	@Override
	public void keyReleased(KeyEvent arg0) {
		boolean enteredDataValidity = true;

		JTextField firstNameTextField = studentNonGradesDataPanel.getFirstNameTextField();
		JLabel incorrectFirstNameMessageLabel = studentNonGradesDataPanel.getIncorrectFirstNameMessageLabel();

		JTextField lastNameTextField = studentNonGradesDataPanel.getLastNameTextField();
		JLabel incorrectLastNameMessageLabel = studentNonGradesDataPanel.getIncorrectLastNameMessageLabel();

		JTextField dateOfBirthTextField = studentNonGradesDataPanel.getDateOfBirthTextField();
		JLabel incorrectDateOfBirthMessageLabel = studentNonGradesDataPanel.getIncorrectDateOfBirthMessageLabel();

		JTextField contactPhoneTextField = studentNonGradesDataPanel.getContactPhoneTextField();
		JLabel incorrectContactPhoneMessageLabel = studentNonGradesDataPanel.getIncorrectContactPhoneMessageLabel();

		JTextField emailAddressTextField = studentNonGradesDataPanel.getEmailAddressTextField();
		JLabel incorrectEmailAddressMessageLabel = studentNonGradesDataPanel.getIncorrectEmailAddressMessageLabel();

		JTextField indexNumberTextField = studentNonGradesDataPanel.getIndexNumberTextField();
		JLabel incorrectIndexNumberMessageLabel = studentNonGradesDataPanel.getIncorrectIndexNumberMessageLabel();
		JLabel existingIndexNumberMessageLabel = studentNonGradesDataPanel.getExistingIndexNumberMessageLabel();

		JTextField yearOfEnrollmentTextField = studentNonGradesDataPanel.getYearOfEnrollmentTextField();
		JLabel incorrectYearOfEnrollmentMessageLabel = studentNonGradesDataPanel.getIncorrectYearOfEnrollmentMessageLabel();

		JButton confirmationButton = studentNonGradesDataPanel.getConfirmationButton();
		
		/** REFERENCA: https://stackoverflow.com/questions/10894122/java-regex-for-support-unicode */
		if (!Pattern.matches("[A-Z\\p{L}][a-z\\p{L}]+([ -][A-Z\\p{L}][a-z\\p{L}]+)*", firstNameTextField.getText())) {
			enteredDataValidity = false;
			
			incorrectFirstNameMessageLabel.setVisible(true);
		} else {
			incorrectFirstNameMessageLabel.setVisible(false);
		}

		if (!Pattern.matches("[A-Z\\p{L}][a-z\\p{L}]+([ -][A-Z\\p{L}][a-z\\p{L}]+)*", lastNameTextField.getText())) {
			enteredDataValidity = false;

			incorrectLastNameMessageLabel.setVisible(true);
		} else {
			incorrectLastNameMessageLabel.setVisible(false);
		}
		
		/** REFERENCA: http://www.regular-expressions.info/dates.html */
		if (!Pattern.matches("^(0[1-9]|[12][0-9]|3[01])\\.(0[1-9]|1[012])\\.(19|20)[0-9]{2}\\.", dateOfBirthTextField.getText())) {
			enteredDataValidity = false;

			incorrectDateOfBirthMessageLabel.setVisible(true);
		} else {
			incorrectDateOfBirthMessageLabel.setVisible(false);
		}

		if (!Pattern.matches("[0-9]+", contactPhoneTextField.getText())) {
			enteredDataValidity = false;

			incorrectContactPhoneMessageLabel.setVisible(true);
		} else {
			incorrectContactPhoneMessageLabel.setVisible(false);
		}

		if (!Pattern.matches("[a-z0-9\\_\\-\\.]+@[a-z]+\\.[a-z\\.]+", emailAddressTextField.getText())) {
			enteredDataValidity = false;

			incorrectEmailAddressMessageLabel.setVisible(true);
		} else {
			incorrectEmailAddressMessageLabel.setVisible(false);
		}

		/** REFERENCA: https://www.logicbig.com/tutorials/core-java-tutorial/java-regular-expressions/java-regex-basic.html */
		String enteredIndexNumber = indexNumberTextField.getText();
		if (!Pattern.matches("[a-z]{2}-[0-9]{1,3}-[0-9]{4}", enteredIndexNumber)) {
			enteredDataValidity = false;

			incorrectIndexNumberMessageLabel.setVisible(true);
			existingIndexNumberMessageLabel.setVisible(false);
		} else {
			if (indexNumberUniquenessNeed) {
				if (StudentsCollection.getInstance().indexNumberExists(enteredIndexNumber)) {
					enteredDataValidity = false;

					incorrectIndexNumberMessageLabel.setVisible(false);
					existingIndexNumberMessageLabel.setVisible(true);
				} else {
					incorrectIndexNumberMessageLabel.setVisible(false);
					existingIndexNumberMessageLabel.setVisible(false);
				}
			} else {
				incorrectIndexNumberMessageLabel.setVisible(false);
				existingIndexNumberMessageLabel.setVisible(false);
			}
		}

		if (!Pattern.matches("[0-9]{4}", yearOfEnrollmentTextField.getText())) {
			enteredDataValidity = false;

			incorrectYearOfEnrollmentMessageLabel.setVisible(true);
		} else {
			incorrectYearOfEnrollmentMessageLabel.setVisible(false);
		}

		if (enteredDataValidity) {
			confirmationButton.setEnabled(true);
		} else {
			confirmationButton.setEnabled(false);
		}
	}
	
	@Override
	public void keyTyped(KeyEvent arg0) {}
}
