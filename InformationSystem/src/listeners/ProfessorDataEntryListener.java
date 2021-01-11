package listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import view.ProfessorNonSubjectsDataPanel;

/** REFERENCA: Materijali za vežbe (v4 -> b - Dogadjaji -> Dogadjaji -> listeners -> key -> MyKeyListener.java) */
public class ProfessorDataEntryListener implements KeyListener  {
	private ProfessorNonSubjectsDataPanel professorNonSubjectsDataPanel;
	
	public ProfessorDataEntryListener(ProfessorNonSubjectsDataPanel panel) {
		professorNonSubjectsDataPanel = panel;
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {}
	
	/** REFERENCA: https://www.javatpoint.com/java-regex */
	@Override
	public void keyReleased(KeyEvent arg0) {
		boolean enteredDataValidity = true;
		
		JTextField firstNameTextField = professorNonSubjectsDataPanel.getFirstNameTextField();
		JLabel incorrectFirstNameMessageLabel = professorNonSubjectsDataPanel.getIncorrectFirstNameMessageLabel();
		
		JTextField lastNameTextField = professorNonSubjectsDataPanel.getLastNameTextField();
		JLabel incorrectLastNameMessageLabel = professorNonSubjectsDataPanel.getIncorrectLastNameMessageLabel();
		
		JTextField dateOfBirthTextField = professorNonSubjectsDataPanel.getDateOfBirthMessageTextField();
		JLabel incorrectDateOfBirthMessageLabel = professorNonSubjectsDataPanel.getIncorrectDateOfBirthMessageLabel();
		
		JTextField contactPhoneTextField = professorNonSubjectsDataPanel.getContactPhoneTextField();
		JLabel incorrectContactPhoneMessageLabel = professorNonSubjectsDataPanel.getIncorrectContactPhoneMessageLabel();
		
		JTextField emailAddressTextField = professorNonSubjectsDataPanel.getEmailAddressAddressTextField();
		JLabel incorrectEmailAddressMessageLable = professorNonSubjectsDataPanel.getIncorrectEmailAddressMessaggeLabel();
		
		JTextField nationalIdTextField = professorNonSubjectsDataPanel.getNationalIdTextField();
		JLabel incorrectNationalIdMessageLable = professorNonSubjectsDataPanel.getIncorrectNationalIdMessageLabel();
		
		JButton confirmationButton = professorNonSubjectsDataPanel.getConfirmationButton();
		
		/** REFERENCA: https://stackoverflow.com/questions/10894122/java-regex-for-support-unicode */
		if(!Pattern.matches("[A-Z\\p{L}][a-z\\p{L}]+([ -][A-Z\\p{L}][a-z\\p{L}]+)*", firstNameTextField.getText())) {
			enteredDataValidity = false;
			
			incorrectFirstNameMessageLabel.setVisible(true);
		} else {
			incorrectFirstNameMessageLabel.setVisible(false);
		}
		if(!Pattern.matches("[A-Z\\p{L}][a-z\\p{L}]+([ -][A-Z\\p{L}][a-z\\p{L}]+)*", lastNameTextField.getText())) {
			enteredDataValidity = false;
			
			incorrectLastNameMessageLabel.setVisible(true);
		} else {
			incorrectLastNameMessageLabel.setVisible(false);
		}
		/** REFERENCA: http://www.regular-expressions.info/dates.html */
		if(!Pattern.matches("^(0[1-9]|[12][0-9]|3[01])\\.(0[1-9]|1[012])\\.(19|20)[0-9]{2}\\.", dateOfBirthTextField.getText())) {
			enteredDataValidity = false;
			
			incorrectDateOfBirthMessageLabel.setVisible(true);
		} else {
			incorrectDateOfBirthMessageLabel.setVisible(false);
		}
		if(!Pattern.matches("[0-9]+", contactPhoneTextField.getText())) {
			enteredDataValidity = false;
			
			incorrectContactPhoneMessageLabel.setVisible(true);
		} else {
			incorrectContactPhoneMessageLabel.setVisible(false);
		}
		if(!Pattern.matches("[a-z0-9\\_\\-\\.]+@[a-z]+\\.[a-z\\.]+", emailAddressTextField.getText())) {
			enteredDataValidity = false;
			
			incorrectEmailAddressMessageLable.setVisible(true);
		} else {
			incorrectEmailAddressMessageLable.setVisible(false);
		}
		if(!Pattern.matches("[0-9]{9}", nationalIdTextField.getText())) {
			enteredDataValidity = false;
			
			incorrectNationalIdMessageLable.setVisible(true);
		} else {
			incorrectNationalIdMessageLable.setVisible(false);
		}
		if(enteredDataValidity) {
			confirmationButton.setEnabled(true);
		} else {
			confirmationButton.setEnabled(false);
		}
	}
	@Override
	public void keyTyped(KeyEvent arg0) {}
}
