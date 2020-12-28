package view;

import java.awt.BorderLayout;
import java.awt.Color;
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

public class SubjectAddingDialog extends JDialog implements ActionListener {
	// Polja:
	private JPanel mainPanel;
	
	private JPanel upperPanel;
	//private SubjectDataEntryListener subjectDataEntryListener;
	
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
	
	private JPanel buttonsPanel;
	private JButton confirmationButton;
	private JButton cancellationButton;
	
	private JScrollPane scrollPane;
	
	// Konstruktor:
	public SubjectAddingDialog(JFrame parent) {
		super(parent, "Dodavanje predmeta", true);
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		setSize(screenSize.width * 3 / 8, screenSize.height * 29 / 40);
		setResizable(false);
		setLocationRelativeTo(parent);
		
		//subjectDataEntryListener = new SubjectDataEntryListener(this);
		
		setUpMainPanel();
		
		setUpUpperPanel();
		mainPanel.add(upperPanel, BorderLayout.NORTH);
		
		setUpButtonsPanel();
		mainPanel.add(buttonsPanel, BorderLayout.SOUTH);
		
		scrollPane = new JScrollPane(mainPanel);
		add(scrollPane);
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
	
	public JButton getConfirmationButton() {
		return confirmationButton;
	}
	
	private void setUpMainPanel() {
		BorderLayout mainPanelLayout = new BorderLayout(0, 10);
		mainPanel = new JPanel(mainPanelLayout);
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
	}
	
	private void setUpIdComponents() {
		idLabel = new JLabel("Šifra predmeta*");
		idTextField = new JTextField();
		
		//idTextField.addKeyListener(subjectDataEntryListener);
		
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
		
		//nameTextField.addKeyListener(subjectDataEntryListener);
		
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
		
		//espbTextField.addKeyListener(subjectDataEntryListener);
		
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
		
		confirmationButton.setEnabled(false);
		
		confirmationButton.addActionListener(this);
	}
	
	private void setUpCancellationButton() {
		cancellationButton = new JButton("Odustani");
		cancellationButton.setName("cancellationButton");
		
		cancellationButton.addActionListener(this);
	}
	
	/** REFERENCA: Materijali za vežbe (v4 -> a - Unutrasnje klase i dogadjaji -> Interfejsi i unutrasnje klase.pdf) */
	@Override
	public void actionPerformed(ActionEvent e) {
		/*
		JButton clickedButton = (JButton) e.getSource();
		
		switch (clickedButton.getName()) {
			case "confirmationButton":
				//SubjectsController.getInstance().addSubject(this);
				dispose();
				break;
			case "cancellationButton":
				dispose();
		}
		*/
	}
}
