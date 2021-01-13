package listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.Professor;
import model.ProfessorsCollection;
import view.ProfessorNonSubjectsDataPanel;

/** REFERENCA: Materijali za vežbe (v4 -> b - Dogadjaji -> Dogadjaji -> listeners -> key -> MyKeyListener.java) */
public class ProfessorDataEntryListener implements KeyListener  {
	private ProfessorNonSubjectsDataPanel professorNonSubjectsDataPanel;
	private String typeOfParentDialog;
	private int selectedRowIndex;
	
	public ProfessorDataEntryListener(ProfessorNonSubjectsDataPanel panel, String typeOfParentDialog,
			int selectedRowIndex) {
		professorNonSubjectsDataPanel = panel;
		this.typeOfParentDialog = typeOfParentDialog;
		this.selectedRowIndex = selectedRowIndex;
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {}
	
	/** REFERENCA: https://www.javatpoint.com/java-regex */
	@Override
	public void keyReleased(KeyEvent arg0) {
		JButton confirmationButton = professorNonSubjectsDataPanel.getConfirmationButton();
		confirmationButton.setEnabled(false);
		
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
		JLabel existingNationalIdMessageLable = professorNonSubjectsDataPanel.getExistingNationalIdMessageLabel();
		
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
		String enteredContactPhone = contactPhoneTextField.getText();
		if (!Pattern.matches("[0-9]{3}/[0-9]{3,4}-[0-9]{3,4}", enteredContactPhone)) {
			enteredDataValidity = false;

			incorrectContactPhoneMessageLabel.setVisible(true);
		} else {
			incorrectContactPhoneMessageLabel.setVisible(false);
			if (!contains10or9Digits(enteredContactPhone)) {
				enteredDataValidity = false;
				
				incorrectContactPhoneMessageLabel.setVisible(true);
			} else {
				incorrectContactPhoneMessageLabel.setVisible(false);
			}
		}
		String enteredNationalId = nationalIdTextField.getText();
		if(!Pattern.matches("[0-9]{9}", nationalIdTextField.getText())) {
			enteredDataValidity = false;
			
			incorrectNationalIdMessageLable.setVisible(true);
			existingNationalIdMessageLable.setVisible(false);
		} else {
			if(typeOfParentDialog.equals("ProfessorAddingDialog")) {
				if(ProfessorsCollection.getInstance().nationalIdExists(enteredNationalId)) {
					enteredDataValidity = false;
					
					incorrectNationalIdMessageLable.setVisible(false);
					existingNationalIdMessageLable.setVisible(true);
				} else {
					incorrectNationalIdMessageLable.setVisible(false);
					existingNationalIdMessageLable.setVisible(false);
				}
			} else {
				Professor selectedProfessor = ProfessorsCollection.getInstance().getRow(selectedRowIndex);
				String currentNationalId = selectedProfessor.getNationalID();
				if(ProfessorsCollection.getInstance().
						editedNationalIdMatchesWithExistingNationalId(currentNationalId,
								enteredNationalId)){
					enteredDataValidity = false;
					
					incorrectNationalIdMessageLable.setVisible(false);
					existingNationalIdMessageLable.setVisible(true);
				} else {
					incorrectNationalIdMessageLable.setVisible(false);
					existingNationalIdMessageLable.setVisible(false);
				}
			}
			
		}
		if(enteredDataValidity) {
			confirmationButton.setEnabled(true);
		}
	}
	@Override
	public void keyTyped(KeyEvent arg0) {}
	
	private boolean contains10or9Digits(String enteredContactPhone) {
		boolean answer = false;
		
		int numberOfDigits = 0;
		for (char c : enteredContactPhone.toCharArray()) {
			if (Character.isDigit(c)) {
				numberOfDigits++;
			}
		}
		
		if (numberOfDigits == 10 || numberOfDigits == 9) {
			answer = true;
		}
		
		return answer;
	}
}
