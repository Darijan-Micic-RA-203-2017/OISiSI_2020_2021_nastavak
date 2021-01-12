package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import listeners.ProfessorDataEntryListener;

public class ProfessorNonSubjectsDataPanel extends JPanel {
	private JPanel upperPanel;
	private ProfessorDataEntryListener professorDataEntryListener;
	
	private JLabel firstNameLabel;
	private JTextField firstNameTextField;
	private JLabel incorrectFirstNameMessageLabel;
	private JLabel lastNameLabel;
	private JTextField lastNameTextField;
	private JLabel incorrectLastNameMessageLabel;
	private JLabel dateOfBirthLabel;
	private JTextField dateOfBirthTextField;
	private JLabel incorrectDateOfBirthMessageLabel;
	private JLabel residenceLabel;
	private JTextField residenceTextField;
	private JLabel contactPhoneLabel;
	private JTextField contactPhoneTextField;
	private JLabel incorrectContactPhoneMessageLabel;
	private JLabel emailAddressLabel;
	private JTextField emailAddressTextField;
	private JLabel incorrectEmailAddressMessageLabel;
	private JLabel officeAddressLabel;
	private JTextField officeAddressTextField;
	private JLabel nationalIdLabel;
	private JTextField nationalIdTextField;
	private JLabel incorrectNationalIdMessageLabel;
	private JLabel existingNationalIdMessageLabel;
	private JLabel titleLabel;
	private JComboBox<String> titleComboBox;
	private JLabel callingLabel;
	private JComboBox<String> callingComboBox;
	
	private JPanel buttonsPanel;
	private JButton confirmationButton;
	private JButton cancellationButton;
	
	public ProfessorNonSubjectsDataPanel() {
		professorDataEntryListener = new ProfessorDataEntryListener(this);
		
		BorderLayout layout = new BorderLayout(0, 10);
		setLayout(layout);
		
		setUpUpperPanel();
		add(upperPanel, BorderLayout.NORTH);
		
		setUpButtonsPanel();
		add(buttonsPanel, BorderLayout.SOUTH);
	}
	
	public JTextField getFirstNameTextField() {
		return firstNameTextField;
	}
	
	public JLabel getIncorrectFirstNameMessageLabel() {
		return incorrectFirstNameMessageLabel;
	}
	
	public JTextField getLastNameTextField() {
		return lastNameTextField;
	}
	
	public JLabel getIncorrectLastNameMessageLabel() {
		return incorrectLastNameMessageLabel;
	}
	
	public JTextField  getDateOfBirthMessageTextField() {
		return dateOfBirthTextField;
	}
	
	public JLabel getIncorrectDateOfBirthMessageLabel() {
		return incorrectDateOfBirthMessageLabel;
	}
	
	public JTextField getResidenceTextField() {
		return residenceTextField;
	}
	
	public JTextField getContactPhoneTextField() {
		return contactPhoneTextField;
	}
	
	public JLabel getIncorrectContactPhoneMessageLabel() {
		return incorrectContactPhoneMessageLabel;
	}
	
	public JTextField getEmailAddressAddressTextField() {
		return emailAddressTextField;
	}
	
	public JLabel getIncorrectEmailAddressMessaggeLabel() {
		return incorrectEmailAddressMessageLabel;
	}
	
	public JTextField getOfficeAddressTextField() {
		return officeAddressTextField;
	}
	
	public JTextField getNationalIdTextField() {
		return nationalIdTextField;
	}
	
	public JLabel getIncorrectNationalIdMessageLabel() {
		return incorrectNationalIdMessageLabel;
	}
	
	public JLabel getExistingNationalIdMessageLabel() {
		return existingNationalIdMessageLabel;
	}
	
	public JComboBox<String> getTitleComboBox(){
		return titleComboBox;
	}
	
	public JComboBox<String> getCallingComboBox(){
		return callingComboBox;
	}
	
	public JButton getConfirmationButton() {
		return confirmationButton;
	}
	
	public JButton getCancellationButton() {
		return cancellationButton;
	}
	
	private void setUpUpperPanel() {
		/** REFERENCA: Materijali za vežbe (v5 -> GridbagLayout.pdf) */
		GridBagLayout upperPanelLayout = new GridBagLayout();
		upperPanel = new JPanel(upperPanelLayout);
		
		setUpFirstNameComponents();
		setUpLastNameComponents();
		setUpDateOfBirthComponents();
		setUpResidenceComponents();
		setUpContactPhoneComponents();
		setUpEmailAddressComponents();
		setUpOfficeAddressComponents();
		setUpNationalIdComponents();
		setUpTitleComponents();
		setUpCallingComponents();
	}
	
	private void setUpFirstNameComponents() {
		firstNameLabel = new JLabel("Ime*");
		firstNameTextField = new JTextField();
		
		firstNameTextField.addKeyListener(professorDataEntryListener);
		
		incorrectFirstNameMessageLabel = new JLabel("Ime nije ispravno uneto!");
		incorrectFirstNameMessageLabel.setForeground(Color.RED);
		
		Dimension textFieldPrefferedSize = new Dimension(this.getWidth()*9/20, 20);
		firstNameTextField.setPreferredSize(textFieldPrefferedSize);
		
		/** REFERENCA: Materijali za vežbe (v5 -> GridbagLayout.pdf) */
		Insets labelInsets = new Insets(10, 10, 10, 10);
		GridBagConstraints labelConstraints = new GridBagConstraints(0, 0, 1, 1, 0, 0, 
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, labelInsets, 0, 0);
		upperPanel.add(firstNameLabel, labelConstraints);
		
		Insets textFieldInsets = new Insets(10, 10, 5, 10);
		GridBagConstraints textFieldConstraints = new GridBagConstraints(1, 0, 1, 1, 0, 0, 
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, textFieldInsets, 0, 0);
		upperPanel.add(firstNameTextField, textFieldConstraints);
		
		Insets incorrectMessageLabelInsets = new Insets(5, 10, 10, 10);
		GridBagConstraints incorrectMessageLabelConstraints = new GridBagConstraints(1, 1, 
				1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 
				incorrectMessageLabelInsets, 0, 0);
		upperPanel.add(incorrectFirstNameMessageLabel, incorrectMessageLabelConstraints);
		
	}
	
	private void setUpLastNameComponents() {
		lastNameLabel = new JLabel("Prezime*");
		lastNameTextField = new JTextField();
		
		lastNameTextField.addKeyListener(professorDataEntryListener);
		
		incorrectLastNameMessageLabel = new JLabel("Prezime nije ispravno uneto!");
		incorrectLastNameMessageLabel.setForeground(Color.RED);
		
		/** REFERENCA: Materijali za vežbe (v5 -> GridbagLayout.pdf) */
		Insets labelInsets = new Insets(10, 10, 10, 10);
		GridBagConstraints labelConstraints = new GridBagConstraints(0, 2, 1, 1, 0, 0, 
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, labelInsets, 0, 0);
		upperPanel.add(lastNameLabel, labelConstraints);
		
		Insets textFieldInsets = new Insets(10, 10, 5, 10);
		GridBagConstraints textFieldConstraints = new GridBagConstraints(1, 2, 1, 1, 0, 0, 
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, textFieldInsets, 0, 0);
		upperPanel.add(lastNameTextField, textFieldConstraints);
		
		Insets incorrectMessageLabelInsets = new Insets(5, 10, 10, 10);
		GridBagConstraints incorrectMessageLabelConstraints = new GridBagConstraints(1, 3, 
				1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 
				incorrectMessageLabelInsets, 0, 0);
		upperPanel.add(incorrectLastNameMessageLabel, incorrectMessageLabelConstraints);
	}
	
	public void setUpDateOfBirthComponents() {
		dateOfBirthLabel = new JLabel("Datum rođenja*");
		dateOfBirthTextField = new JTextField();
		
		dateOfBirthTextField.addKeyListener(professorDataEntryListener);
		
		incorrectDateOfBirthMessageLabel = 
				new JLabel("Datum rođenja mora biti unet u obliku: dd.MM.yyyy.");
		incorrectDateOfBirthMessageLabel.setForeground(Color.RED);
		
		/** REFERENCA: Materijali za vežbe (v5 -> GridbagLayout.pdf) */
		Insets labelInsets = new Insets(10, 10, 10, 10);
		GridBagConstraints labelConstraints = new GridBagConstraints(0, 4, 1, 1, 0, 0, 
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, labelInsets, 0, 0);
		upperPanel.add(dateOfBirthLabel, labelConstraints);
		
		Insets textFieldInsets = new Insets(10, 10, 5, 10);
		GridBagConstraints textFieldConstraints = new GridBagConstraints(1, 4, 1, 1, 0, 0, 
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, textFieldInsets, 0, 0);
		upperPanel.add(dateOfBirthTextField, textFieldConstraints);
		
		Insets incorrectMessageLabelInsets = new Insets(5, 10, 10, 10);
		GridBagConstraints incorrectMessageLabelConstraints = new GridBagConstraints(1, 5, 
				1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 
				incorrectMessageLabelInsets, 0, 0);
		upperPanel.add(incorrectDateOfBirthMessageLabel, incorrectMessageLabelConstraints);
	}
	
	private void setUpResidenceComponents() {
		residenceLabel = new JLabel("Adresa stanovanja*");
		residenceTextField = new JTextField();
		
		/** REFERENCA: Materijali za vežbe (v5 -> GridbagLayout.pdf) */
		Insets labelInsets = new Insets(10, 10, 10, 10);
		GridBagConstraints labelConstraints = new GridBagConstraints(0, 6, 1, 1, 0, 0, 
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, labelInsets, 0, 0);
		upperPanel.add(residenceLabel, labelConstraints);
		
		Insets textFieldInsets = new Insets(10, 10, 10, 10);
		GridBagConstraints textFieldConstraints = new GridBagConstraints(1, 6, 1, 1, 0, 0, 
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, textFieldInsets, 0, 0);
		upperPanel.add(residenceTextField, textFieldConstraints);
	}
	
	private void setUpContactPhoneComponents() {
		contactPhoneLabel = new JLabel("Broj telefona*");
		contactPhoneTextField = new JTextField();
		
		contactPhoneTextField.addKeyListener(professorDataEntryListener);
		
		incorrectContactPhoneMessageLabel = 
				new JLabel("Broj telefona može sadržati samo cifre!");
		incorrectContactPhoneMessageLabel.setForeground(Color.RED);
		
		/** REFERENCA: Materijali za vežbe (v5 -> GridbagLayout.pdf) */
		Insets labelInsets = new Insets(10, 10, 10, 10);
		GridBagConstraints labelConstraints = new GridBagConstraints(0, 7, 1, 1, 0, 0, 
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, labelInsets, 0, 0);
		upperPanel.add(contactPhoneLabel, labelConstraints);
		
		Insets textFieldInsets = new Insets(10, 10, 5, 10);
		GridBagConstraints textFieldConstraints = new GridBagConstraints(1, 7, 1, 1, 0, 0, 
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, textFieldInsets, 0, 0);
		upperPanel.add(contactPhoneTextField, textFieldConstraints);
		
		Insets incorrectMessageLabelInsets = new Insets(5, 10, 10, 10);
		GridBagConstraints incorrectMessageLabelConstraints = new GridBagConstraints(1, 8, 
				1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 
				incorrectMessageLabelInsets, 0, 0);
		upperPanel.add(incorrectContactPhoneMessageLabel, incorrectMessageLabelConstraints);
	}
	
	private void setUpEmailAddressComponents() {
		emailAddressLabel = new JLabel("E-mail adresa*");
		emailAddressTextField = new JTextField();
		
		emailAddressTextField.addKeyListener(professorDataEntryListener);
		
		incorrectEmailAddressMessageLabel = 
				new JLabel("E-mail adresa mora biti uneta u obliku: korisnicko_ime@domen.korenski_domen!");
		incorrectEmailAddressMessageLabel.setForeground(Color.RED);
		
		/** REFERENCA: Materijali za vežbe (v5 -> GridbagLayout.pdf) */
		Insets labelInsets = new Insets(10, 10, 10, 10);
		GridBagConstraints labelConstraints = new GridBagConstraints(0, 9, 1, 1, 0, 0, 
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, labelInsets, 0, 0);
		upperPanel.add(emailAddressLabel, labelConstraints);
		
		Insets textFieldInsets = new Insets(10, 10, 5, 10);
		GridBagConstraints textFieldConstraints = new GridBagConstraints(1, 9, 1, 1, 0, 0, 
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, textFieldInsets, 0, 0);
		upperPanel.add(emailAddressTextField, textFieldConstraints);
		
		Insets incorrectMessageLabelInsets = new Insets(5, 10, 10, 10);
		GridBagConstraints incorrectMessageLabelConstraints = new GridBagConstraints(1, 10, 
				1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 
				incorrectMessageLabelInsets, 0, 0);
		upperPanel.add(incorrectEmailAddressMessageLabel, incorrectMessageLabelConstraints);
	}
	
	private void setUpOfficeAddressComponents() {
		officeAddressLabel = new JLabel("Adresa kancelarije*");
		officeAddressTextField = new JTextField();
		
		/** REFERENCA: Materijali za vežbe (v5 -> GridbagLayout.pdf) */
		Insets labelInsets = new Insets(10, 10, 10, 10);
		GridBagConstraints labelConstraints = new GridBagConstraints(0, 11, 1, 1, 0, 0, 
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, labelInsets, 0, 0);
		upperPanel.add(officeAddressLabel, labelConstraints);
		
		Insets textFieldInsets = new Insets(10, 10, 10, 10);
		GridBagConstraints textFieldConstraints = new GridBagConstraints(1, 11, 1, 1, 0, 0, 
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, textFieldInsets, 0, 0);
		upperPanel.add(officeAddressTextField, textFieldConstraints);
	}
	
	private void setUpNationalIdComponents() {
		nationalIdLabel = new JLabel("Broj lične karte*");
		nationalIdTextField = new JTextField();
		
		nationalIdTextField.addKeyListener(professorDataEntryListener);
		
		incorrectNationalIdMessageLabel = new JLabel("Broj lične karte mora imati 9 cifara!");
		incorrectNationalIdMessageLabel.setForeground(Color.RED);
		
		existingNationalIdMessageLabel = new JLabel("Uneti broj lične karte već postoji");
		existingNationalIdMessageLabel.setForeground(Color.RED);
		existingNationalIdMessageLabel.setVisible(false);
		
		/** REFERENCA: Materijali za vežbe (v5 -> GridbagLayout.pdf) */
		Insets labelInsets = new Insets(10, 10, 10, 10);
		GridBagConstraints labelConstraints = new GridBagConstraints(0, 12, 1, 1, 0, 0, 
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, labelInsets, 0, 0);
		upperPanel.add(nationalIdLabel, labelConstraints);
		
		Insets textFieldInsets = new Insets(10, 10, 5, 10);
		GridBagConstraints textFieldConstraints = new GridBagConstraints(1, 12, 1, 1, 0, 0, 
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, textFieldInsets, 0, 0);
		upperPanel.add(nationalIdTextField, textFieldConstraints);
		
		Insets incorrectMessageLabelInsets = new Insets(5, 10, 10, 10);
		GridBagConstraints incorrectMessageLabelConstraints = new GridBagConstraints(1, 13, 
				1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 
				incorrectMessageLabelInsets, 0, 0);
		upperPanel.add(incorrectNationalIdMessageLabel, incorrectMessageLabelConstraints);
		upperPanel.add(existingNationalIdMessageLabel, incorrectMessageLabelConstraints);
	}
	
	private void setUpTitleComponents() {
		titleLabel = new JLabel("Trenutna titula*");
		String[] possibleTitles = {"BSc","MSc","mr","dr","prof. dr"};
		titleComboBox = new JComboBox<String>(possibleTitles);
		
		/** REFERENCA: Materijali za vežbe (v5 -> GridbagLayout.pdf) */
		Insets labelInsets = new Insets(10, 10, 10, 10);
		GridBagConstraints labelConstraints = new GridBagConstraints(0, 14, 1, 1, 0, 0, 
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, labelInsets, 0, 0);
		upperPanel.add(titleLabel, labelConstraints);
		
		Insets comboBoxInsets = new Insets(10, 10, 10, 10);
		GridBagConstraints comboBoxConstraints = new GridBagConstraints(1, 14, 1, 1, 0, 0, 
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, comboBoxInsets, 0, 0);
		upperPanel.add(titleComboBox, comboBoxConstraints);
	}
	
	private void setUpCallingComponents() {
		callingLabel = new JLabel("Trenutno zvanje*");
		String[] possibleCallings = {"saradnik u nastavi", "asistent", "asistent sa doktoratom", "docent",
				"vanredni profesor", "redovni profesor", "profesor emeritus"};
		callingComboBox = new JComboBox<String>(possibleCallings);
		
		/** REFERENCA: Materijali za vežbe (v5 -> GridbagLayout.pdf) */
		Insets labelInsets = new Insets(10, 10, 10, 10);
		GridBagConstraints labelConstraints = new GridBagConstraints(0, 15, 1, 1, 0, 0, 
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, labelInsets, 0, 0);
		upperPanel.add(callingLabel, labelConstraints);
		
		Insets comboBoxInsets = new Insets(10, 10, 0, 10);
		GridBagConstraints comboBoxConstraints = new GridBagConstraints(1, 15, 1, 1, 0, 0, 
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, comboBoxInsets, 0, 0);
		upperPanel.add(callingComboBox, comboBoxConstraints);
	}
	
	private void setUpButtonsPanel() {
		/** REFERENCA: Materijali za vežbe (v3 -> Termin 5 - Layout.pdf) */
		FlowLayout buttonsPanelLayout = new FlowLayout(FlowLayout.CENTER, 20, 5);
		buttonsPanel = new JPanel(buttonsPanelLayout);
		
		setUpConfirmationButton();
		setUpCancellationButton();
		
		buttonsPanel.add(confirmationButton);
		buttonsPanel.add(cancellationButton);
	}
	
	private void setUpConfirmationButton() {
		confirmationButton = new JButton("Potvrdi");
		confirmationButton.setName("confirmationButton");
	}
	
	private void setUpCancellationButton() {
		cancellationButton = new JButton("Odustani");
		cancellationButton.setName("cancellationButton");
	}
}
