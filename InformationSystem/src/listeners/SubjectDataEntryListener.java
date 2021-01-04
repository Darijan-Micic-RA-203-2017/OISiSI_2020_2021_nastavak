package listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import view.SubjectNonStudentsDataPanel;

/** REFERENCA: Materijali za vežbe (v4 -> b - Dogadjaji -> Dogadjaji -> listeners -> key -> MyKeyListener.java) */
public class SubjectDataEntryListener implements KeyListener {
	// Polje:
	private SubjectNonStudentsDataPanel subjectNonStudentsDataPanel;

	// Konstruktor:
	public SubjectDataEntryListener(SubjectNonStudentsDataPanel panel) {
		subjectNonStudentsDataPanel = panel;
	}

	// Radnje:
	@Override
	public void keyPressed(KeyEvent arg0) {}
	
	/** REFERENCA: https://www.javatpoint.com/java-regex */
	@Override
	public void keyReleased(KeyEvent arg0) {
		boolean enteredDataValidity = true;

		JTextField idTextField = subjectNonStudentsDataPanel.getIdTextField();
		JLabel incorrectIdMessageLabel = subjectNonStudentsDataPanel.getIncorrectIdMessageLabel();

		JTextField nameTextField = subjectNonStudentsDataPanel.getNameTextField();
		JLabel incorrectNameMessageLabel = 
				subjectNonStudentsDataPanel.getIncorrectNameMessageLabel();

		JTextField espbTextField = subjectNonStudentsDataPanel.getEspbTextField();
		JLabel incorrectEspbMessageLabel = 
				subjectNonStudentsDataPanel.getIncorrectEspbMessageLabel();

		JButton confirmationButton = subjectNonStudentsDataPanel.getConfirmationButton();
		
		/** REFERENCA: https://www.logicbig.com/tutorials/core-java-tutorial/java-regular-expressions/java-regex-basic.html */
		if (!Pattern.matches("[A-Z][A-Z0-9\\-]+", idTextField.getText())) {
			enteredDataValidity = false;
			
			incorrectIdMessageLabel.setVisible(true);
		} else {
			incorrectIdMessageLabel.setVisible(false);
		}
		
		/** REFERENCA: https://stackoverflow.com/questions/10894122/java-regex-for-support-unicode */
		if (!Pattern.matches("[A-Z\\p{L}][a-z\\p{L}]+( (- )?[a-z0-9\\p{L}]+)*", nameTextField.getText())) {
			enteredDataValidity = false;

			incorrectNameMessageLabel.setVisible(true);
		} else {
			incorrectNameMessageLabel.setVisible(false);
		}
		
		if (!Pattern.matches("[0-9]{1,2}", espbTextField.getText())) {
			enteredDataValidity = false;

			incorrectEspbMessageLabel.setVisible(true);
		} else {
			incorrectEspbMessageLabel.setVisible(false);
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