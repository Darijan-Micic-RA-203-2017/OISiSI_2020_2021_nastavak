package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import controller.SubjectsController;

import model.Subject;
import model.SubjectsCollection;

public class SubjectEditingDialog extends JDialog implements ActionListener {
	// Polja:
	private boolean idUniquenessNeed;
	private SubjectNonStudentsDataPanel subjectNonStudentsDataPanel;
	private JScrollPane scrollPane;
	
	// Konstruktor:
	public SubjectEditingDialog(JFrame parent, int selectedRowIndex) {
		super(parent, "Izmena predmeta", true);
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		setSize(screenSize.width * 3 / 8, screenSize.height * 29 / 40);
		setResizable(false);
		setLocationRelativeTo(parent);
		
		idUniquenessNeed = false;
		subjectNonStudentsDataPanel = new SubjectNonStudentsDataPanel(idUniquenessNeed);
		
		fillSubjectNonStudentsDataPanel(selectedRowIndex);
		
		JButton confirmationButton = subjectNonStudentsDataPanel.getConfirmationButton();
		JButton cancellationButton = subjectNonStudentsDataPanel.getCancellationButton();
		
		confirmationButton.addActionListener(this);
		cancellationButton.addActionListener(this);
		
		scrollPane = new JScrollPane(subjectNonStudentsDataPanel);
		add(scrollPane);
	}
	
	// Radnje:
	public SubjectNonStudentsDataPanel getSubjectNonStudentsDataPanel() {
		return subjectNonStudentsDataPanel;
	}
	
	private void fillSubjectNonStudentsDataPanel(int selectedRowIndex) {
		Subject selectedSubject = SubjectsCollection.getInstance().getRow(selectedRowIndex);
		
		String id = selectedSubject.getId();
		subjectNonStudentsDataPanel.getIdTextField().setText(id);
		subjectNonStudentsDataPanel.getIncorrectIdMessageLabel().setVisible(false);
		subjectNonStudentsDataPanel.getExistingIdMessageLabel().setVisible(false);
		
		String name = selectedSubject.getName();
		subjectNonStudentsDataPanel.getNameTextField().setText(name);
		subjectNonStudentsDataPanel.getIncorrectNameMessageLabel().setVisible(false);
		
		int yearOfStudy = selectedSubject.getYearOfStudy();
		subjectNonStudentsDataPanel.getYearOfStudyComboBox().setSelectedIndex(yearOfStudy - 1);
		
		String semester = selectedSubject.getSemester();
		if (semester.equals("letnji")) {
			subjectNonStudentsDataPanel.getSemesterComboBox().setSelectedIndex(0);
		} else {
			subjectNonStudentsDataPanel.getSemesterComboBox().setSelectedIndex(1);
		}
		
		int espb = selectedSubject.getEspb();
		String espbInString = Integer.toString(espb);
		subjectNonStudentsDataPanel.getEspbTextField().setText(espbInString);
		subjectNonStudentsDataPanel.getIncorrectEspbMessageLabel().setVisible(false);
	}
	
	/** REFERENCA: Materijali za vežbe (v4 -> a - Unutrasnje klase i dogadjaji -> Interfejsi i unutrasnje klase.pdf) */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clickedButton = (JButton) e.getSource();
		
		switch (clickedButton.getName()) {
			case "confirmationButton":
				int selectedRow = MainFrame.getInstance().getTabbedPane().getSubjectsTab().
						getSubjectsTable().getSelectedRow();
				SubjectsController.getInstance().editSubjectNonStudentsData(selectedRow, this);
				dispose();
				break;
			case "cancellationButton":
				dispose();
		}
	}
}
