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

import listeners.SubjectDataEntryListener;

public class SubjectNonStudentsDataPanel extends JPanel {
	// Polja:
	private JPanel upperPanel;
	private SubjectDataEntryListener subjectDataEntryListener;
	
	private JLabel idLabel;
	private JTextField idTextField;
	private JLabel incorrectIdMessageLabel;
	private JLabel nameLabel;
	private JTextField nameTextField;
	private JLabel incorrectNameMessageLabel;
	private JLabel semesterLabel;
	private JComboBox<String> semesterComboBox;
	private JLabel yearOfStudyLabel;
	private JComboBox<String> yearOfStudyComboBox;
	private JLabel espbLabel;
	private JTextField espbTextField;
	private JLabel incorrectEspbMessageLabel;
	private JLabel professorLabel;
	private JPanel professorPanel;
	private JTextField professorTextField;
	private JButton professorAddingButton;
	private JButton professorRemovalButton;
	
	private JPanel buttonsPanel;
	private JButton confirmationButton;
	private JButton cancellationButton;
	
	// Konstruktor:
	public SubjectNonStudentsDataPanel() {
		subjectDataEntryListener = new SubjectDataEntryListener(this);
		
		BorderLayout layout = new BorderLayout(0, 10);
		setLayout(layout);
		
		setUpUpperPanel();
		add(upperPanel, BorderLayout.NORTH);
		
		setUpButtonsPanel();
		add(buttonsPanel, BorderLayout.SOUTH);
	}
	
	// Radnje:
	public JTextField getIdTextField() {
		return idTextField;
	}
	
	public JLabel getIncorrectIdMessageLabel() {
		return incorrectIdMessageLabel;
	}
	
	public JTextField getNameTextField() {
		return nameTextField;
	}
	
	public JLabel getIncorrectNameMessageLabel() {
		return incorrectNameMessageLabel;
	}
	
	public JComboBox<String> getSemesterComboBox() {
		return semesterComboBox;
	}
	
	public JComboBox<String> getYearOfStudyComboBox() {
		return yearOfStudyComboBox;
	}
	
	public JTextField getEspbTextField() {
		return espbTextField;
	}
	
	public JLabel getIncorrectEspbMessageLabel() {
		return incorrectEspbMessageLabel;
	}
	
	public JLabel getProfessorLabel() {
		return professorLabel;
	}
	
	public JPanel getProfessorPanel() {
		return professorPanel;
	}
	
	public JTextField getProfessorTextField() {
		return professorTextField;
	}
	
	public JButton getProfessorAddingButton() {
		return professorAddingButton;
	}
	
	public JButton getProfessorRemovalButton() {
		return professorRemovalButton;
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
		
		setUpIdComponents();
		setUpNameComponents();
		setUpSemesterComponents();
		setUpYearOfStudyComponents();
		setUpEspbComponents();
		setUpProfessorComponents();
	}
	
	private void setUpIdComponents() {
		idLabel = new JLabel("Šifra predmeta*");
		idTextField = new JTextField();
		
		idTextField.addKeyListener(subjectDataEntryListener);
		
		incorrectIdMessageLabel = new JLabel("Šifra predmeta nije ispravno uneta!");
		incorrectIdMessageLabel.setForeground(Color.RED);
		
		/* Podešavanjem željene širine prvog polja za unos teksta biće podešena i širina 
		 * komponenti u drugoj koloni donjih redova.
		*/
		Dimension textFieldPreferredSize = new Dimension(this.getWidth() * 9 / 20, 20);
		idTextField.setPreferredSize(textFieldPreferredSize);
		
		/** REFERENCA: Materijali za vežbe (v5 -> GridbagLayout.pdf) */
		Insets labelInsets = new Insets(10, 10, 10, 10);
		GridBagConstraints labelConstraints = new GridBagConstraints(0, 0, 1, 1, 0, 0, 
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, labelInsets, 0, 0);
		upperPanel.add(idLabel, labelConstraints);
		
		Insets textFieldInsets = new Insets(10, 10, 5, 10);
		GridBagConstraints textFieldConstraints = new GridBagConstraints(1, 0, 1, 1, 0, 0, 
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, textFieldInsets, 0, 0);
		upperPanel.add(idTextField, textFieldConstraints);
		
		Insets incorrectMessageLabelInsets = new Insets(5, 10, 10, 10);
		GridBagConstraints incorrectMessageLabelConstraints = new GridBagConstraints(1, 1, 
				1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 
				incorrectMessageLabelInsets, 0, 0);
		upperPanel.add(incorrectIdMessageLabel, incorrectMessageLabelConstraints);
	}
	
	private void setUpNameComponents() {
		nameLabel = new JLabel("Naziv predmeta*");
		nameTextField = new JTextField();
		
		nameTextField.addKeyListener(subjectDataEntryListener);
		
		incorrectNameMessageLabel = new JLabel("Naziv predmeta nije ispravno unet!");
		incorrectNameMessageLabel.setForeground(Color.RED);
		
		/** REFERENCA: Materijali za vežbe (v5 -> GridbagLayout.pdf) */
		Insets labelInsets = new Insets(10, 10, 10, 10);
		GridBagConstraints labelConstraints = new GridBagConstraints(0, 2, 1, 1, 0, 0, 
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, labelInsets, 0, 0);
		upperPanel.add(nameLabel, labelConstraints);
		
		Insets textFieldInsets = new Insets(10, 10, 5, 10);
		GridBagConstraints textFieldConstraints = new GridBagConstraints(1, 2, 1, 1, 0, 0, 
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, textFieldInsets, 0, 0);
		upperPanel.add(nameTextField, textFieldConstraints);
		
		Insets incorrectMessageLabelInsets = new Insets(5, 10, 10, 10);
		GridBagConstraints incorrectMessageLabelConstraints = new GridBagConstraints(1, 3, 
				1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 
				incorrectMessageLabelInsets, 0, 0);
		upperPanel.add(incorrectNameMessageLabel, incorrectMessageLabelConstraints);
	}
	
	private void setUpSemesterComponents() {
		semesterLabel = new JLabel("Semestar*");
		String[] possibleSemesters = {"Letnji", "Zimski"};
		semesterComboBox = new JComboBox<String>(possibleSemesters);
		
		/** REFERENCA: Materijali za vežbe (v5 -> GridbagLayout.pdf) */
		Insets labelInsets = new Insets(10, 10, 10, 10);
		GridBagConstraints labelConstraints = new GridBagConstraints(0, 4, 1, 1, 0, 0, 
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, labelInsets, 0, 0);
		upperPanel.add(semesterLabel, labelConstraints);
		
		Insets comboBoxInsets = new Insets(10, 10, 10, 10);
		GridBagConstraints comboBoxConstraints = new GridBagConstraints(1, 4, 1, 1, 0, 0, 
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, comboBoxInsets, 0, 0);
		upperPanel.add(semesterComboBox, comboBoxConstraints);
	}
	
	private void setUpYearOfStudyComponents() {
		yearOfStudyLabel = new JLabel("Godina studija*");
		String[] possibleYearsOfStudy = {"I (prva)", "II (druga)", "III (treća)", 
				"IV (četvrta)", "V (peta)", "VI (šesta)", "VII (sedma)", "VIII (osma)"};
		yearOfStudyComboBox = new JComboBox<String>(possibleYearsOfStudy);
		
		/** REFERENCA: Materijali za vežbe (v5 -> GridbagLayout.pdf) */
		Insets labelInsets = new Insets(10, 10, 10, 10);
		GridBagConstraints labelConstraints = new GridBagConstraints(0, 5, 1, 1, 0, 0, 
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, labelInsets, 0, 0);
		upperPanel.add(yearOfStudyLabel, labelConstraints);
		
		Insets comboBoxInsets = new Insets(10, 10, 10, 10);
		GridBagConstraints comboBoxConstraints = new GridBagConstraints(1, 5, 1, 1, 0, 0, 
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, comboBoxInsets, 0, 0);
		upperPanel.add(yearOfStudyComboBox, comboBoxConstraints);
	}
	
	private void setUpEspbComponents() {
		espbLabel = new JLabel("Broj ESPB bodova*");
		espbTextField = new JTextField();
		
		espbTextField.addKeyListener(subjectDataEntryListener);
		
		incorrectEspbMessageLabel = 
				new JLabel("Broj ESPB bodova mora biti unet kao ceo broj!");
		incorrectEspbMessageLabel.setForeground(Color.RED);
		
		/** REFERENCA: Materijali za vežbe (v5 -> GridbagLayout.pdf) */
		Insets labelInsets = new Insets(10, 10, 10, 10);
		GridBagConstraints labelConstraints = new GridBagConstraints(0, 6, 1, 1, 0, 0, 
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, labelInsets, 0, 0);
		upperPanel.add(espbLabel, labelConstraints);
		
		Insets textFieldInsets = new Insets(10, 10, 5, 10);
		GridBagConstraints textFieldConstraints = new GridBagConstraints(1, 6, 1, 1, 0, 0, 
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, textFieldInsets, 0, 0);
		upperPanel.add(espbTextField, textFieldConstraints);
		
		Insets incorrectMessageLabelInsets = new Insets(5, 10, 0, 10);
		GridBagConstraints incorrectMessageLabelConstraints = new GridBagConstraints(1, 7, 
				1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 
				incorrectMessageLabelInsets, 0, 0);
		upperPanel.add(incorrectEspbMessageLabel, incorrectMessageLabelConstraints);
	}
	
	private void setUpProfessorComponents() {
		professorLabel = new JLabel("Profesor*");
		
		setUpProfessorPanel();
		
		Insets labelInsets = new Insets(10, 10, 10, 10);
		GridBagConstraints labelConstraints = new GridBagConstraints(0, 8, 1, 1, 0, 0, 
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, labelInsets, 0, 0);
		upperPanel.add(professorLabel, labelConstraints);
		
		Insets panelInsets = new Insets(10, 10, 10, 10);
		GridBagConstraints panelConstraints = new GridBagConstraints(1, 8, 1, 1, 0, 0, 
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, panelInsets, 0, 0);
		upperPanel.add(professorPanel, panelConstraints);
	}
	
	private void setUpProfessorPanel() {
		FlowLayout professorPanelLayout = new FlowLayout(FlowLayout.LEFT, 5, 5);
		professorPanel = new JPanel(professorPanelLayout);
		
		professorTextField = new JTextField();
		Dimension textFieldPreferredSize = new Dimension(this.getWidth() * 9 / 25, 20);
		professorTextField.setPreferredSize(textFieldPreferredSize);
		professorPanel.add(professorTextField);
		
		professorAddingButton = new JButton("+");
		professorAddingButton.setName("professorAddingButton");
		professorPanel.add(professorAddingButton);
		
		professorRemovalButton = new JButton("-");
		professorRemovalButton.setName("professorRemovalButton");
		professorPanel.add(professorRemovalButton);
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
