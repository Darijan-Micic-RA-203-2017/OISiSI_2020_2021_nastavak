package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class StudentAddingDialog extends JDialog implements ActionListener {
	// Polja:
	private JPanel mainPanel;
	
	private JPanel upperPanel;
	
	private JLabel firstNameLabel;
	private JTextField firstNameTextField;
	private JLabel lastNameLabel;
	private JTextField lastNameTextField;
	private JLabel dateOfBirthLabel;
	private JTextField dateOfBirthTextField;
	private JLabel addressLabel;
	private JTextField addressTextField;
	private JLabel contactPhoneLabel;
	private JTextField contactPhoneTextField;
	private JLabel emailAddressLabel;
	private JTextField emailAddressTextField;
	private JLabel indexNumberLabel;
	private JTextField indexNumberTextField;
	private JLabel yearOfEnrollmentLabel;
	private JTextField yearOfEnrollmentTextField;
	private JLabel currentYearOfStudyLabel;
	private JComboBox<String> currentYearOfStudyComboBox;
	private JLabel statusOfStudentLabel;
	private JComboBox<String> statusOfStudentComboBox;
	
	private JPanel buttonsPanel;
	private JButton confirmationButton;
	private JButton cancellationButton;
	
	private JScrollPane scrollPane;
	
	// Konstruktor:
	public StudentAddingDialog(JFrame parent) {
		super(parent, "Dodavanje studenta", true);
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		setSize(screenSize.width * 3 / 8, screenSize.height * 29 / 40);
		setResizable(false);
		setLocationRelativeTo(parent);
		
		setUpMainPanel();
		
		setUpUpperPanel();
		mainPanel.add(upperPanel, BorderLayout.NORTH);
		
		setUpButtonsPanel();
		mainPanel.add(buttonsPanel, BorderLayout.SOUTH);
		
		scrollPane = new JScrollPane(mainPanel);
		add(scrollPane);
	}
	
	// Radnje:
	private void setUpMainPanel() {
		BorderLayout mainPanelLayout = new BorderLayout(0, 10);
		mainPanel = new JPanel(mainPanelLayout);
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
		
		/* Podešavanjem željene širine prvog polja za unos teksta biće podešena i širina 
		 * komponenti u drugoj koloni donjih redova.
		*/
		Dimension textFieldPreferredSize = new Dimension(this.getWidth() *9 / 20, 20);
		firstNameTextField.setPreferredSize(textFieldPreferredSize);
		
		/** REFERENCA: Materijali za vežbe (v5 -> GridbagLayout.pdf) */
		Insets labelInsets = new Insets(10, 10, 10, 10);
		GridBagConstraints labelConstraints = new GridBagConstraints(0, 0, 1, 1, 0, 0, 
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, labelInsets, 0, 0);
		upperPanel.add(firstNameLabel, labelConstraints);
		
		Insets textFieldInsets = new Insets(10, 10, 10, 10);
		GridBagConstraints textFieldConstraints = new GridBagConstraints(1, 0, 1, 1, 0, 0, 
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, textFieldInsets, 0, 0);
		upperPanel.add(firstNameTextField, textFieldConstraints);
	}
	
	private void setUpLastNameComponents() {
		lastNameLabel = new JLabel("Prezime*");
		lastNameTextField = new JTextField();
		
		/** REFERENCA: Materijali za vežbe (v5 -> GridbagLayout.pdf) */
		Insets labelInsets = new Insets(10, 10, 10, 10);
		GridBagConstraints labelConstraints = new GridBagConstraints(0, 1, 1, 1, 0, 0, 
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, labelInsets, 0, 0);
		upperPanel.add(lastNameLabel, labelConstraints);
		
		Insets textFieldInsets = new Insets(10, 10, 10, 10);
		GridBagConstraints textFieldConstraints = new GridBagConstraints(1, 1, 1, 1, 0, 0, 
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, textFieldInsets, 0, 0);
		upperPanel.add(lastNameTextField, textFieldConstraints);
	}
	
	private void setUpDateOfBirthComponents() {
		dateOfBirthLabel = new JLabel("Datum rođenja*");
		dateOfBirthTextField = new JTextField();
		
		/** REFERENCA: Materijali za vežbe (v5 -> GridbagLayout.pdf) */
		Insets labelInsets = new Insets(10, 10, 10, 10);
		GridBagConstraints labelConstraints = new GridBagConstraints(0, 2, 1, 1, 0, 0, 
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, labelInsets, 0, 0);
		upperPanel.add(dateOfBirthLabel, labelConstraints);
		
		Insets textFieldInsets = new Insets(10, 10, 10, 10);
		GridBagConstraints textFieldConstraints = new GridBagConstraints(1, 2, 1, 1, 0, 0, 
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, textFieldInsets, 0, 0);
		upperPanel.add(dateOfBirthTextField, textFieldConstraints);
	}
	
	private void setUpAddressComponents() {
		addressLabel = new JLabel("Adresa*");
		addressTextField = new JTextField();
		
		/** REFERENCA: Materijali za vežbe (v5 -> GridbagLayout.pdf) */
		Insets labelInsets = new Insets(10, 10, 10, 10);
		GridBagConstraints labelConstraints = new GridBagConstraints(0, 3, 1, 1, 0, 0, 
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, labelInsets, 0, 0);
		upperPanel.add(addressLabel, labelConstraints);
		
		Insets textFieldInsets = new Insets(10, 10, 10, 10);
		GridBagConstraints textFieldConstraints = new GridBagConstraints(1, 3, 1, 1, 0, 0, 
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, textFieldInsets, 0, 0);
		upperPanel.add(addressTextField, textFieldConstraints);
	}
	
	private void setUpContactPhoneComponents() {
		contactPhoneLabel = new JLabel("Broj telefona*");
		contactPhoneTextField = new JTextField();
		
		/** REFERENCA: Materijali za vežbe (v5 -> GridbagLayout.pdf) */
		Insets labelInsets = new Insets(10, 10, 10, 10);
		GridBagConstraints labelConstraints = new GridBagConstraints(0, 4, 1, 1, 0, 0, 
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, labelInsets, 0, 0);
		upperPanel.add(contactPhoneLabel, labelConstraints);
		
		Insets textFieldInsets = new Insets(10, 10, 10, 10);
		GridBagConstraints textFieldConstraints = new GridBagConstraints(1, 4, 1, 1, 0, 0, 
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, textFieldInsets, 0, 0);
		upperPanel.add(contactPhoneTextField, textFieldConstraints);
	}
	
	private void setUpEmailAddressComponents() {
		emailAddressLabel = new JLabel("E-mail adresa*");
		emailAddressTextField = new JTextField();
		
		/** REFERENCA: Materijali za vežbe (v5 -> GridbagLayout.pdf) */
		Insets labelInsets = new Insets(10, 10, 10, 10);
		GridBagConstraints labelConstraints = new GridBagConstraints(0, 5, 1, 1, 0, 0, 
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, labelInsets, 0, 0);
		upperPanel.add(emailAddressLabel, labelConstraints);
		
		Insets textFieldInsets = new Insets(10, 10, 10, 10);
		GridBagConstraints textFieldConstraints = new GridBagConstraints(1, 5, 1, 1, 0, 0, 
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, textFieldInsets, 0, 0);
		upperPanel.add(emailAddressTextField, textFieldConstraints);
	}
	
	private void setUpIndexNumberComponents() {
		indexNumberLabel = new JLabel("Broj indeksa*");
		indexNumberTextField = new JTextField();
		
		/** REFERENCA: Materijali za vežbe (v5 -> GridbagLayout.pdf) */
		Insets labelInsets = new Insets(10, 10, 10, 10);
		GridBagConstraints labelConstraints = new GridBagConstraints(0, 6, 1, 1, 0, 0, 
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, labelInsets, 0, 0);
		upperPanel.add(indexNumberLabel, labelConstraints);
		
		Insets textFieldInsets = new Insets(10, 10, 10, 10);
		GridBagConstraints textFieldConstraints = new GridBagConstraints(1, 6, 1, 1, 0, 0, 
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, textFieldInsets, 0, 0);
		upperPanel.add(indexNumberTextField, textFieldConstraints);
	}
	
	private void setUpYearOfEnrollmentComponents() {
		yearOfEnrollmentLabel = new JLabel("Godina upisa*");
		yearOfEnrollmentTextField = new JTextField();
		
		/** REFERENCA: Materijali za vežbe (v5 -> GridbagLayout.pdf) */
		Insets labelInsets = new Insets(10, 10, 10, 10);
		GridBagConstraints labelConstraints = new GridBagConstraints(0, 7, 1, 1, 0, 0, 
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, labelInsets, 0, 0);
		upperPanel.add(yearOfEnrollmentLabel, labelConstraints);
		
		Insets textFieldInsets = new Insets(10, 10, 10, 10);
		GridBagConstraints textFieldConstraints = new GridBagConstraints(1, 7, 1, 1, 0, 0, 
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, textFieldInsets, 0, 0);
		upperPanel.add(yearOfEnrollmentTextField, textFieldConstraints);
	}
	
	private void setUpCurrentYearOfStudyComponents() {
		currentYearOfStudyLabel = new JLabel("Trenutna godina studija*");
		String[] possibleYearsOfStudy = {"I (prva)", "II (druga)", "III (treća)", "IV (četvrta)"};
		currentYearOfStudyComboBox = new JComboBox<String>(possibleYearsOfStudy);
		
		/** REFERENCA: Materijali za vežbe (v5 -> GridbagLayout.pdf) */
		Insets labelInsets = new Insets(10, 10, 10, 10);
		GridBagConstraints labelConstraints = new GridBagConstraints(0, 8, 1, 1, 0, 0, 
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, labelInsets, 0, 0);
		upperPanel.add(currentYearOfStudyLabel, labelConstraints);
		
		Insets comboBoxInsets = new Insets(10, 10, 10, 10);
		GridBagConstraints comboBoxConstraints = new GridBagConstraints(1, 8, 1, 1, 0, 0, 
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, comboBoxInsets, 0, 0);
		upperPanel.add(currentYearOfStudyComboBox, comboBoxConstraints);
	}
	
	private void setUpStatusOfStudentComponents() {
		statusOfStudentLabel = new JLabel("Način finansiranja*");
		String[] possibleStatusesOfStudent = {"Budžet", "Samofinansiranje"};
		statusOfStudentComboBox = new JComboBox<String>(possibleStatusesOfStudent);
		
		/** REFERENCA: Materijali za vežbe (v5 -> GridbagLayout.pdf) */
		Insets labelInsets = new Insets(10, 10, 10, 10);
		GridBagConstraints labelConstraints = new GridBagConstraints(0, 9, 1, 1, 0, 0, 
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, labelInsets, 0, 0);
		upperPanel.add(statusOfStudentLabel, labelConstraints);
		
		Insets comboBoxInsets = new Insets(10, 10, 0, 10);
		GridBagConstraints comboBoxConstraints = new GridBagConstraints(1, 9, 1, 1, 0, 0, 
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
		
		confirmationButton.setEnabled(false);
	}
	
	private void setUpCancellationButton() {
		cancellationButton = new JButton("Odustani");
		
		cancellationButton.addActionListener(this);
	}
	
	/** REFERENCA: Materijali za vežbe (v4 -> a - Unutrasnje klase i dogadjaji -> Interfejsi i unutrasnje klase.pdf) */
	@Override
	public void actionPerformed(ActionEvent e) {
		dispose();
	}
}
