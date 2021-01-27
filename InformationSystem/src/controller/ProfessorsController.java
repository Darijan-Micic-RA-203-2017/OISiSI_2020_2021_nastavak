package controller;

import java.text.*;
import java.util.ArrayList;
import java.util.Date;

import model.Professor;
import model.ProfessorsCollection;
import model.Subject;
import model.SubjectsCollection;
import model.CallingOfProfessor;
import model.TitleOfProfessor;
import view.MainFrame;
import view.ProfessorAddingDialog;
import view.ProfessorNonSubjectsDataPanel;
import view.ProfessorEditingDialog;

/** REFERENCA: Materijali za vežbe (v6 -> JTableMVCSimple -> controller -> IgraciController.java) */
public class ProfessorsController {
	private static ProfessorsController instance = null;
	
	public static ProfessorsController getInstance() {
		if(instance == null) {
			instance = new ProfessorsController();
		}
		
		return instance;
	}
	
	private ProfessorsController() {}
	
	public void addProfessor(ProfessorAddingDialog professorAddingDialog) {
		ProfessorNonSubjectsDataPanel professorNonSubjectsDataPanel =
				professorAddingDialog.getProfessorNonSubjectDataPanel();
		String lastName = professorNonSubjectsDataPanel.getLastNameTextField().getText();
		String firstName = professorNonSubjectsDataPanel.getFirstNameTextField().getText();
		String dateOfBirthStringRepresentation = professorNonSubjectsDataPanel.getDateOfBirthMessageTextField().getText();
		/** REFERENCA: https://www.javatpoint.com/java-string-to-date */
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
		Date dateOfBirth = null;
		try {
			dateOfBirth  = sdf.parse(dateOfBirthStringRepresentation);
		} catch(ParseException pE) {
			pE.printStackTrace();
		}
		String residence = professorNonSubjectsDataPanel.getResidenceTextField().getText();
		String contactPhone = professorNonSubjectsDataPanel.getContactPhoneTextField().getText();
		String emailAddress  = professorNonSubjectsDataPanel.getEmailAddressAddressTextField().getText();
		String officeAddress = professorNonSubjectsDataPanel.getOfficeAddressTextField().getText();
		String nationalId = professorNonSubjectsDataPanel.getNationalIdTextField().getText();
		int titleComboBoxSelectedIndex = professorNonSubjectsDataPanel.getTitleComboBox().getSelectedIndex();
		TitleOfProfessor title = null;
		if(titleComboBoxSelectedIndex == 0) {
			title = TitleOfProfessor.BSC;
		} else if(titleComboBoxSelectedIndex == 1) {
			title = TitleOfProfessor.MSC;
		} else if(titleComboBoxSelectedIndex == 2) {
			title = TitleOfProfessor.MR;
		} else if(titleComboBoxSelectedIndex == 3) {
			title = TitleOfProfessor.DR;
		} else if(titleComboBoxSelectedIndex == 4) {
			title = TitleOfProfessor.PROF_DR;
		}
		int callingComboBoxSelectedIndex = professorNonSubjectsDataPanel.getCallingComboBox().getSelectedIndex();
		CallingOfProfessor calling = null;
		if(callingComboBoxSelectedIndex == 0) {
			calling = CallingOfProfessor.SARADNIK_U_NASTAVI;
		} else if(callingComboBoxSelectedIndex == 1) {
			calling = CallingOfProfessor.ASISTENT;
		} else if(callingComboBoxSelectedIndex == 2) {
			calling = CallingOfProfessor.ASISTENT_SA_DOKTORATOM;
		} else if(callingComboBoxSelectedIndex == 3) {
			calling = CallingOfProfessor.DOCENT;
		} else if(callingComboBoxSelectedIndex == 4) {
			calling = CallingOfProfessor.VANREDNI_PROFESOR;
		} else if(callingComboBoxSelectedIndex == 5) {
			calling = CallingOfProfessor.REDOVNI_PROFESOR;
		} else if(callingComboBoxSelectedIndex == 6) {
			calling = CallingOfProfessor.PROFESOR_EMERITUS;
		}
		
		ProfessorsCollection.getInstance().addProfessor(lastName, firstName, dateOfBirth, residence, contactPhone, emailAddress, officeAddress, nationalId, title, calling);
		
		MainFrame.getInstance().refreshView("ADDED", -1);
	}
	
	public void deleteProfessor(int rowSelectedIndex) {
		Professor professor = ProfessorsCollection.getInstance().getRow(rowSelectedIndex);
		
		// Izmena modela:
		ProfessorsCollection.getInstance().deleteProfessor(professor.getNationalID());
		
		ArrayList<String> teachingSubjectsIdsOfProfessor = new ArrayList<String>();
		for (Subject s : professor.getTeachingSubjects()) {
			teachingSubjectsIdsOfProfessor.add(s.getId());
		}
		
		SubjectsCollection.getInstance().
				deleteProfessorFromSubjectsRecords(teachingSubjectsIdsOfProfessor);
		
		// Osvežavanje prikaza:
		MainFrame.getInstance().refreshView("DELETED PROFESSOR", rowSelectedIndex);
	}
	
	public void editProfessorNonSubjectsData(int rowSelectedIndex,
			ProfessorEditingDialog professorEditingDialog) {
		if(rowSelectedIndex >= 0) {
			Professor professor = ProfessorsCollection.getInstance().getRow(rowSelectedIndex);
			
			ProfessorNonSubjectsDataPanel professorNonSubjectsDataPanel = professorEditingDialog.
					getProfessorEditingTabbedPane().getProfessorNonSubjectsDataPanel();
			
			String lastName = professorNonSubjectsDataPanel.getLastNameTextField().getText();
			String firstName = professorNonSubjectsDataPanel.getFirstNameTextField().getText();
			String dateOfBirthStringRepresentation = 
					professorNonSubjectsDataPanel.getDateOfBirthMessageTextField().getText();
			/** REFERENCA: https://www.javatpoint.com/java-string-to-date */
			SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
			Date dateOfBirth = null;
			try {
				dateOfBirth = sdf.parse(dateOfBirthStringRepresentation);
			} catch (ParseException pE) {
				pE.printStackTrace();
			}
			String residence = professorNonSubjectsDataPanel.getResidenceTextField().getText();
			String contactPhone = professorNonSubjectsDataPanel.getContactPhoneTextField().getText();
			String emailAddress = professorNonSubjectsDataPanel.getEmailAddressAddressTextField().getText();
			String officeAddress = professorNonSubjectsDataPanel.getOfficeAddressTextField().getText();
			String newNationalId = professorNonSubjectsDataPanel.getNationalIdTextField().getText();
			int titleComboBoxSelected = 
					professorNonSubjectsDataPanel.getTitleComboBox().getSelectedIndex();
			TitleOfProfessor title = null;
			if(titleComboBoxSelected == 0) {
				title = TitleOfProfessor.BSC;
			} else if(titleComboBoxSelected == 1) {
				title = TitleOfProfessor.MSC;
			} else if(titleComboBoxSelected == 2) {
				title = TitleOfProfessor.MR;
			} else if(titleComboBoxSelected == 3) {
				title = TitleOfProfessor.DR;
			} else {
				title = TitleOfProfessor.PROF_DR;
			}
			int callingComboBoxSelected =
					professorNonSubjectsDataPanel.getCallingComboBox().getSelectedIndex();
			CallingOfProfessor calling = null;
			if(callingComboBoxSelected == 0) {
				calling = CallingOfProfessor.SARADNIK_U_NASTAVI;
			} else if(callingComboBoxSelected == 1) {
				calling = CallingOfProfessor.ASISTENT;
			} else if(callingComboBoxSelected == 2) {
				calling = CallingOfProfessor.ASISTENT_SA_DOKTORATOM;
			} else if(callingComboBoxSelected == 3) {
				calling = CallingOfProfessor.DOCENT;
			} else if(callingComboBoxSelected == 4) {
				calling = CallingOfProfessor.VANREDNI_PROFESOR;
			} else if(callingComboBoxSelected == 5) {
				calling = CallingOfProfessor.REDOVNI_PROFESOR;
			} else {
				calling = CallingOfProfessor.PROFESOR_EMERITUS;
			}
			String oldNationalId = professor.getNationalID();
			ProfessorsCollection.getInstance().editProfessorNonSubjectsData(oldNationalId, lastName,
					firstName, dateOfBirth, residence, contactPhone, emailAddress, officeAddress,
					newNationalId, title, calling);
			
			MainFrame.getInstance().refreshView(null, -1);
		}
	}
	
	
}
