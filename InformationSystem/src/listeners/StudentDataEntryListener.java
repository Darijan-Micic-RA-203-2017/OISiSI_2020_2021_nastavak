package listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import view.StudentAddingDialog;

/** REFERENCA: Materijali za vežbe (v4 -> b - Dogadjaji -> Dogadjaji -> listeners -> key -> MyKeyListener.java) */
public class StudentDataEntryListener implements KeyListener {
	// Polje:
	private StudentAddingDialog studentAddingDialog;

	// Konstruktor:
	public StudentDataEntryListener(StudentAddingDialog dialog) {
		studentAddingDialog = dialog;
	}

	// Radnje:
	@Override
	public void keyPressed(KeyEvent arg0) {}
	
	/** REFERENCA: https://www.javatpoint.com/java-regex */
	@Override
	public void keyReleased(KeyEvent arg0) {
		boolean enteredDataValidity = true;

		JTextField firstNameTextField = studentAddingDialog.getFirstNameTextField();
		JLabel incorrectFirstNameMessageLabel = studentAddingDialog.getIncorrectFirstNameMessageLabel();

		JTextField lastNameTextField = studentAddingDialog.getLastNameTextField();
		JLabel incorrectLastNameMessageLabel = studentAddingDialog.getIncorrectLastNameMessageLabel();

		JTextField dateOfBirthTextField = studentAddingDialog.getDateOfBirthTextField();
		JLabel incorrectDateOfBirthMessageLabel = studentAddingDialog.getIncorrectDateOfBirthMessageLabel();

		JTextField contactPhoneTextField = studentAddingDialog.getContactPhoneTextField();
		JLabel incorrectContactPhoneMessageLabel = studentAddingDialog.getIncorrectContactPhoneMessageLabel();

		JTextField emailAddressTextField = studentAddingDialog.getEmailAddressTextField();
		JLabel incorrectEmailAddressMessageLabel = studentAddingDialog.getIncorrectEmailAddressMessageLabel();

		JTextField indexNumberTextField = studentAddingDialog.getIndexNumberTextField();
		JLabel incorrectIndexNumberMessageLabel = studentAddingDialog.getIncorrectIndexNumberMessageLabel();

		JTextField yearOfEnrollmentTextField = studentAddingDialog.getYearOfEnrollmentTextField();
		JLabel incorrectYearOfEnrollmentMessageLabel = studentAddingDialog.getIncorrectYearOfEnrollmentMessageLabel();

		JButton confirmationButton = studentAddingDialog.getConfirmationButton();
		
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
		if (!Pattern.matches("[a-z]{2}-[0-9]{2,3}-[0-9]{4}", indexNumberTextField.getText())) {
			enteredDataValidity = false;

			incorrectIndexNumberMessageLabel.setVisible(true);
		} else {
			incorrectIndexNumberMessageLabel.setVisible(false);
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
