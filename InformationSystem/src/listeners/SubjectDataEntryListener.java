package listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.Subject;
import model.SubjectsCollection;

import view.SubjectNonStudentsDataPanel;

/** REFERENCA: Materijali za vežbe (v4 -> b - Dogadjaji -> Dogadjaji -> listeners -> key -> MyKeyListener.java) */
public class SubjectDataEntryListener implements KeyListener {
	// Polja:
	private SubjectNonStudentsDataPanel subjectNonStudentsDataPanel;
	private String typeOfParentDialog;
	private int selectedRowIndex;
	
	// Konstruktor:
	public SubjectDataEntryListener(SubjectNonStudentsDataPanel panel, 
			String typeOfParentDialog, int selectedRowIndex) {
		subjectNonStudentsDataPanel = panel;
		this.typeOfParentDialog = typeOfParentDialog;
		this.selectedRowIndex = selectedRowIndex;
	}

	// Radnje:
	@Override
	public void keyPressed(KeyEvent arg0) {}
	
	/** REFERENCA: https://www.javatpoint.com/java-regex */
	@Override
	public void keyReleased(KeyEvent arg0) {
		JButton confirmationButton = subjectNonStudentsDataPanel.getConfirmationButton();
		confirmationButton.setEnabled(false);
		
		boolean enteredDataValidity = true;

		JTextField idTextField = subjectNonStudentsDataPanel.getIdTextField();
		JLabel incorrectIdMessageLabel = subjectNonStudentsDataPanel.getIncorrectIdMessageLabel();
		JLabel existingIdMessageLabel = subjectNonStudentsDataPanel.getExistingIdMessageLabel();

		JTextField nameTextField = subjectNonStudentsDataPanel.getNameTextField();
		JLabel incorrectNameMessageLabel = 
				subjectNonStudentsDataPanel.getIncorrectNameMessageLabel();

		JTextField espbTextField = subjectNonStudentsDataPanel.getEspbTextField();
		JLabel incorrectEspbMessageLabel = 
				subjectNonStudentsDataPanel.getIncorrectEspbMessageLabel();
		
		/** REFERENCA: https://www.logicbig.com/tutorials/core-java-tutorial/java-regular-expressions/java-regex-basic.html */
		String enteredId = idTextField.getText();
		if (!Pattern.matches("[A-Za-z][A-Za-z0-9\\-]+", enteredId)) {
			enteredDataValidity = false;
			
			incorrectIdMessageLabel.setVisible(true);
			existingIdMessageLabel.setVisible(false);
		} else {
			if (typeOfParentDialog.equals("SubjectAddingDialog")) {
				if (SubjectsCollection.getInstance().idExists(enteredId)) {
					enteredDataValidity = false;

					incorrectIdMessageLabel.setVisible(false);
					existingIdMessageLabel.setVisible(true);
				} else {
					incorrectIdMessageLabel.setVisible(false);
					existingIdMessageLabel.setVisible(false);
				}
			} else {
				Subject selectedSubject = SubjectsCollection.getInstance().getRow(selectedRowIndex);
				String currentId = selectedSubject.getId();
				
				if (SubjectsCollection.getInstance().editedIdMatchesWithExistingId(currentId, 
						enteredId)) {
					enteredDataValidity = false;
					
					incorrectIdMessageLabel.setVisible(false);
					existingIdMessageLabel.setVisible(true);
				} else {
					incorrectIdMessageLabel.setVisible(false);
					existingIdMessageLabel.setVisible(false);
				}
			}
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
		}
	}
	
	@Override
	public void keyTyped(KeyEvent arg0) {}
}
