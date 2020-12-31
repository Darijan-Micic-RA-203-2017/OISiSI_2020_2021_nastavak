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

import listeners.StudentDataEntryListener;

public class StudentNonGradesDataPanel extends JPanel {
	// Polja:
	private JPanel upperPanel;
	private StudentDataEntryListener studentDataEntryListener;
	
	private JLabel firstNameLabel;
	private JTextField firstNameTextField;
	private JLabel incorrectFirstNameMessageLabel;
	private JLabel lastNameLabel;
	private JTextField lastNameTextField;
	private JLabel incorrectLastNameMessageLabel;
	private JLabel dateOfBirthLabel;
	private JTextField dateOfBirthTextField;
	private JLabel incorrectDateOfBirthMessageLabel;
	private JLabel addressLabel;
	private JTextField addressTextField;
	private JLabel contactPhoneLabel;
	private JTextField contactPhoneTextField;
	private JLabel incorrectContactPhoneMessageLabel;
	private JLabel emailAddressLabel;
	private JTextField emailAddressTextField;
	private JLabel incorrectEmailAddressMessageLabel;
	private JLabel indexNumberLabel;
	private JTextField indexNumberTextField;
	private JLabel incorrectIndexNumberMessageLabel;
	private JLabel yearOfEnrollmentLabel;
	private JTextField yearOfEnrollmentTextField;
	private JLabel incorrectYearOfEnrollmentMessageLabel;
	private JLabel currentYearOfStudyLabel;
	private JComboBox<String> currentYearOfStudyComboBox;
	private JLabel statusOfStudentLabel;
	private JComboBox<String> statusOfStudentComboBox;
	
	private JPanel buttonsPanel;
	private JButton confirmationButton;
	private JButton cancellationButton;
	
	// Konstruktor:
	public StudentNonGradesDataPanel() {
		studentDataEntryListener = new StudentDataEntryListener(this);
		
		BorderLayout layout = new BorderLayout(0, 10);
		setLayout(layout);
		
		setUpUpperPanel();
		add(upperPanel, BorderLayout.NORTH);
		
		setUpButtonsPanel();
		add(buttonsPanel, BorderLayout.SOUTH);
	}
	
	// Radnje:
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
	
	public JTextField getDateOfBirthTextField() {
		return dateOfBirthTextField;
	}
	
	public JLabel getIncorrectDateOfBirthMessageLabel() {
		return incorrectDateOfBirthMessageLabel;
	}
	
	public JTextField getAddressTextField() {
		return addressTextField;
	}
	
	public JTextField getContactPhoneTextField() {
		return contactPhoneTextField;
	}
	
	public JLabel getIncorrectContactPhoneMessageLabel() {
		return incorrectContactPhoneMessageLabel;
	}
	
	public JTextField getEmailAddressTextField() {
		return emailAddressTextField;
	}
	
	public JLabel getIncorrectEmailAddressMessageLabel() {
		return incorrectEmailAddressMessageLabel;
	}
	
	public JTextField getIndexNumberTextField() {
		return indexNumberTextField;
	}
	
	public JLabel getIncorrectIndexNumberMessageLabel() {
		return incorrectIndexNumberMessageLabel;
	}
	
	public JTextField getYearOfEnrollmentTextField() {
		return yearOfEnrollmentTextField;
	}
	
	public JLabel getIncorrectYearOfEnrollmentMessageLabel() {
		return incorrectYearOfEnrollmentMessageLabel;
	}
	
	public JComboBox<String> getCurrentYearOfStudyComboBox() {
		return currentYearOfStudyComboBox;
	}
	
	public JComboBox<String> getStatusOfStudentComboBox() {
		return statusOfStudentComboBox;
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
		setUpAddressComponents();
		setUpContactPhoneComponents();
		setUpEmailAddressComponents();
		setUpIndexNumberComponents();
		setUpYearOfEnrollmentComponents();
		setUpCurrentYearOfStudyComponents();
		setUpStatusOfStudentComponents();
	}
	
	private void setUpFirstNameComponents() {
		firstNameLabel = new JLabel("Ime*");
		firstNameTextField = new JTextField();
		
		firstNameTextField.addKeyListener(studentDataEntryListener);
		
		incorrectFirstNameMessageLabel = new JLabel("Ime nije ispravno uneto!");
		incorrectFirstNameMessageLabel.setForeground(Color.RED);
		
		/* Podešavanjem željene širine prvog polja za unos teksta biće podešena i širina 
		 * komponenti u drugoj koloni donjih redova.
		*/
		Dimension textFieldPreferredSize = new Dimension(this.getWidth() * 9 / 20, 20);
		firstNameTextField.setPreferredSize(textFieldPreferredSize);
		
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
		
		lastNameTextField.addKeyListener(studentDataEntryListener);
		
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
	
	private void setUpDateOfBirthComponents() {
		dateOfBirthLabel = new JLabel("Datum rođenja*");
		dateOfBirthTextField = new JTextField();
		
		dateOfBirthTextField.addKeyListener(studentDataEntryListener);
		
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
	
	private void setUpAddressComponents() {
		addressLabel = new JLabel("Adresa*");
		addressTextField = new JTextField();
		
		/** REFERENCA: Materijali za vežbe (v5 -> GridbagLayout.pdf) */
		Insets labelInsets = new Insets(10, 10, 10, 10);
		GridBagConstraints labelConstraints = new GridBagConstraints(0, 6, 1, 1, 0, 0, 
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, labelInsets, 0, 0);
		upperPanel.add(addressLabel, labelConstraints);
		
		Insets textFieldInsets = new Insets(10, 10, 10, 10);
		GridBagConstraints textFieldConstraints = new GridBagConstraints(1, 6, 1, 1, 0, 0, 
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, textFieldInsets, 0, 0);
		upperPanel.add(addressTextField, textFieldConstraints);
	}
	
	private void setUpContactPhoneComponents() {
		contactPhoneLabel = new JLabel("Broj telefona*");
		contactPhoneTextField = new JTextField();
		
		contactPhoneTextField.addKeyListener(studentDataEntryListener);
		
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
		
		emailAddressTextField.addKeyListener(studentDataEntryListener);
		
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
	
	private void setUpIndexNumberComponents() {
		indexNumberLabel = new JLabel("Broj indeksa*");
		indexNumberTextField = new JTextField();
		
		indexNumberTextField.addKeyListener(studentDataEntryListener);
		
		incorrectIndexNumberMessageLabel = 
				new JLabel("Broj indeksa mora biti unet u jednom od sledeća tri oblika: " + 
		"SS-xxx-yyyy, SS-xx-yyyy ili SS-x-yyyy");
		incorrectIndexNumberMessageLabel.setForeground(Color.RED);
		
		/** REFERENCA: Materijali za vežbe (v5 -> GridbagLayout.pdf) */
		Insets labelInsets = new Insets(10, 10, 10, 10);
		GridBagConstraints labelConstraints = new GridBagConstraints(0, 11, 1, 1, 0, 0, 
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, labelInsets, 0, 0);
		upperPanel.add(indexNumberLabel, labelConstraints);
		
		Insets textFieldInsets = new Insets(10, 10, 5, 10);
		GridBagConstraints textFieldConstraints = new GridBagConstraints(1, 11, 1, 1, 0, 0, 
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, textFieldInsets, 0, 0);
		upperPanel.add(indexNumberTextField, textFieldConstraints);
		
		Insets incorrectMessageLabelInsets = new Insets(5, 10, 10, 10);
		GridBagConstraints incorrectMessageLabelConstraints = new GridBagConstraints(1, 12, 
				1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 
				incorrectMessageLabelInsets, 0, 0);
		upperPanel.add(incorrectIndexNumberMessageLabel, incorrectMessageLabelConstraints);
	}
	
	private void setUpYearOfEnrollmentComponents() {
		yearOfEnrollmentLabel = new JLabel("Godina upisa*");
		yearOfEnrollmentTextField = new JTextField();
		
		yearOfEnrollmentTextField.addKeyListener(studentDataEntryListener);
		
		incorrectYearOfEnrollmentMessageLabel = 
				new JLabel("Godina upisa mora biti uneta kao četvorocifreni broj!");
		incorrectYearOfEnrollmentMessageLabel.setForeground(Color.RED);
		
		/** REFERENCA: Materijali za vežbe (v5 -> GridbagLayout.pdf) */
		Insets labelInsets = new Insets(10, 10, 10, 10);
		GridBagConstraints labelConstraints = new GridBagConstraints(0, 13, 1, 1, 0, 0, 
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, labelInsets, 0, 0);
		upperPanel.add(yearOfEnrollmentLabel, labelConstraints);
		
		Insets textFieldInsets = new Insets(10, 10, 5, 10);
		GridBagConstraints textFieldConstraints = new GridBagConstraints(1, 13, 1, 1, 0, 0, 
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, textFieldInsets, 0, 0);
		upperPanel.add(yearOfEnrollmentTextField, textFieldConstraints);
		
		Insets incorrectMessageLabelInsets = new Insets(5, 10, 10, 10);
		GridBagConstraints incorrectMessageLabelConstraints = new GridBagConstraints(1, 14, 
				1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 
				incorrectMessageLabelInsets, 0, 0);
		upperPanel.add(incorrectYearOfEnrollmentMessageLabel, incorrectMessageLabelConstraints);
	}
	
	private void setUpCurrentYearOfStudyComponents() {
		currentYearOfStudyLabel = new JLabel("Trenutna godina studija*");
		String[] possibleYearsOfStudy = {"I (prva)", "II (druga)", "III (treća)", 
				"IV (četvrta)", "V (peta)", "VI (šesta)", "VII (sedma)", "VIII (osma)"};
		currentYearOfStudyComboBox = new JComboBox<String>(possibleYearsOfStudy);
		
		/** REFERENCA: Materijali za vežbe (v5 -> GridbagLayout.pdf) */
		Insets labelInsets = new Insets(10, 10, 10, 10);
		GridBagConstraints labelConstraints = new GridBagConstraints(0, 15, 1, 1, 0, 0, 
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, labelInsets, 0, 0);
		upperPanel.add(currentYearOfStudyLabel, labelConstraints);
		
		Insets comboBoxInsets = new Insets(10, 10, 10, 10);
		GridBagConstraints comboBoxConstraints = new GridBagConstraints(1, 15, 1, 1, 0, 0, 
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, comboBoxInsets, 0, 0);
		upperPanel.add(currentYearOfStudyComboBox, comboBoxConstraints);
	}
	
	private void setUpStatusOfStudentComponents() {
		statusOfStudentLabel = new JLabel("Način finansiranja*");
		String[] possibleStatusesOfStudent = {"Budžet", "Samofinansiranje"};
		statusOfStudentComboBox = new JComboBox<String>(possibleStatusesOfStudent);
		
		/** REFERENCA: Materijali za vežbe (v5 -> GridbagLayout.pdf) */
		Insets labelInsets = new Insets(10, 10, 10, 10);
		GridBagConstraints labelConstraints = new GridBagConstraints(0, 16, 1, 1, 0, 0, 
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, labelInsets, 0, 0);
		upperPanel.add(statusOfStudentLabel, labelConstraints);
		
		Insets comboBoxInsets = new Insets(10, 10, 0, 10);
		GridBagConstraints comboBoxConstraints = new GridBagConstraints(1, 16, 1, 1, 0, 0, 
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, comboBoxInsets, 0, 0);
		upperPanel.add(statusOfStudentComboBox, comboBoxConstraints);
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
