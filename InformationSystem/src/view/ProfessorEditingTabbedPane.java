package view;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import model.TitleOfProfessor;
import model.CallingOfProfessor;
import model.Professor;
import model.ProfessorsCollection;

public class ProfessorEditingTabbedPane extends JTabbedPane {
	private ProfessorNonSubjectsDataPanel professorsNonSubjectsDataPanel;
	private JPanel teachingSubjects;
	
	public ProfessorEditingTabbedPane(int selectedRowIndex) {
		professorsNonSubjectsDataPanel = new ProfessorNonSubjectsDataPanel();
		fillProfessorNonSubjectsDataPanel(selectedRowIndex);
		
		JScrollPane nonSubjectsDataScrollPane = new JScrollPane(professorsNonSubjectsDataPanel);
		add("Informacije",nonSubjectsDataScrollPane);
		
		teachingSubjects = new JPanel();
		add("Predmeti",teachingSubjects);
	}
	
	public ProfessorNonSubjectsDataPanel getProfessorNonSubjectsDataPanel() {
		return professorsNonSubjectsDataPanel;
	}
	
	private void fillProfessorNonSubjectsDataPanel(int selectedRowIndex) {
		Professor selectedProfessor = ProfessorsCollection.getInstance().getRow(selectedRowIndex);
		
		String firstName = selectedProfessor.getFirstName();
		professorsNonSubjectsDataPanel.getFirstNameTextField().setText(firstName);
		professorsNonSubjectsDataPanel.getIncorrectFirstNameMessageLabel().setVisible(false);
		
		String lastName = selectedProfessor.getLastName();
		professorsNonSubjectsDataPanel.getLastNameTextField().setText(lastName);
		professorsNonSubjectsDataPanel.getIncorrectLastNameMessageLabel().setVisible(false);
		
		/** REFERENCA: https://www.javatpoint.com/java-date-to-string */
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
		Date dateOfBirth = selectedProfessor.getDateOfBirth();
		String dateOfBirthInString = sdf.format(dateOfBirth);
		professorsNonSubjectsDataPanel.getDateOfBirthMessageTextField().setText(dateOfBirthInString);
		professorsNonSubjectsDataPanel.getIncorrectDateOfBirthMessageLabel().setVisible(false);
		
		String residence = selectedProfessor.getResidence();
		professorsNonSubjectsDataPanel.getResidenceTextField().setText(residence);
		
		String contactPhone = selectedProfessor.getContactPhone();
		professorsNonSubjectsDataPanel.getContactPhoneTextField().setText(contactPhone);
		professorsNonSubjectsDataPanel.getIncorrectContactPhoneMessageLabel().setVisible(false);
		
		String emailAdress = selectedProfessor.getEmailAddress();
		professorsNonSubjectsDataPanel.getEmailAddressAddressTextField().setText(emailAdress);
		professorsNonSubjectsDataPanel.getIncorrectEmailAddressMessaggeLabel().setVisible(false);
		
		String officeAdress = selectedProfessor.getOfficeAddress();
		professorsNonSubjectsDataPanel.getOfficeAddressTextField().setText(officeAdress);
		
		String nationalId = selectedProfessor.getNationalID();
		professorsNonSubjectsDataPanel.getNationalIdTextField().setText(nationalId);
		professorsNonSubjectsDataPanel.getIncorrectNationalIdMessageLabel().setVisible(false);
		
		TitleOfProfessor title = selectedProfessor.getTitle();
		if(title == TitleOfProfessor.BSC) {
			professorsNonSubjectsDataPanel.getTitleComboBox().setSelectedIndex(0);
		} else if(title == TitleOfProfessor.MSC) {
			professorsNonSubjectsDataPanel.getTitleComboBox().setSelectedIndex(1);
		} else if(title == TitleOfProfessor.MR) {
			professorsNonSubjectsDataPanel.getTitleComboBox().setSelectedIndex(2);
		} else if(title == TitleOfProfessor.DR) {
			professorsNonSubjectsDataPanel.getTitleComboBox().setSelectedIndex(3);
		} else {
			professorsNonSubjectsDataPanel.getTitleComboBox().setSelectedIndex(4);
		}
		
		CallingOfProfessor calling = selectedProfessor.getCalling();
		if(calling == CallingOfProfessor.SARADNIK_U_NASTAVI) {
			professorsNonSubjectsDataPanel.getCallingComboBox().setSelectedIndex(0);
		} else if(calling == CallingOfProfessor.ASISTENT) {
			professorsNonSubjectsDataPanel.getCallingComboBox().setSelectedIndex(1);
		} else if(calling == CallingOfProfessor.ASISTENT_SA_DOKTORATOM) {
			professorsNonSubjectsDataPanel.getCallingComboBox().setSelectedIndex(2);
		} else if(calling == CallingOfProfessor.DOCENT) {
			professorsNonSubjectsDataPanel.getCallingComboBox().setSelectedIndex(3);
		} else if(calling == CallingOfProfessor.VANREDNI_PROFESOR) {
			professorsNonSubjectsDataPanel.getCallingComboBox().setSelectedIndex(4);
		} else if(calling == CallingOfProfessor.REDOVNI_PROFESOR) {
			professorsNonSubjectsDataPanel.getCallingComboBox().setSelectedIndex(5);
		} else {
			professorsNonSubjectsDataPanel.getCallingComboBox().setSelectedIndex(6);
		}
	}
}
