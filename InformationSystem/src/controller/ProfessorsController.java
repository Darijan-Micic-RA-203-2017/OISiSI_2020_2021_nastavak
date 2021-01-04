package controller;

import java.text.*;
import java.util.Date;

import model.Professor;
import model.ProfessorsCollection;
import model.CallingOfProfessor;
import model.TitleOfProfessor;
import view.MainFrame;
import view.ProfessorAddingDialog;

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
		String lastName = professorAddingDialog.getLastNameTextField().getText();
		String firstName = professorAddingDialog.getFirstNameTextField().getText();
		String dateOfBirthStringRepresentation = professorAddingDialog.getDateOfBirthMessageTextField().getText();
		/** REFERENCA: https://www.javatpoint.com/java-string-to-date */
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
		Date dateOfBirth = null;
		try {
			dateOfBirth  = sdf.parse(dateOfBirthStringRepresentation);
		} catch(ParseException pE) {
			pE.printStackTrace();
		}
		String residence = professorAddingDialog.getResidenceTextField().getText();
		String contactPhone = professorAddingDialog.getContactPhoneTextField().getText();
		String emailAddress  = professorAddingDialog.getEmailAddressAddressTextField().getText();
		String officeAddress = professorAddingDialog.getOfficeAddressTextField().getText();
		String nationalIdStringRepresentation = professorAddingDialog.getNationalIdTextField().getText();
		int nationalId = Integer.parseInt(nationalIdStringRepresentation);
		int titleComboBoxSelectedIndex = professorAddingDialog.getTitleComboBox().getSelectedIndex();
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
		int callingComboBoxSelectedIndex = professorAddingDialog.getCallingComboBox().getSelectedIndex();
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
		if(rowSelectedIndex >= 0) {
			Professor professor = ProfessorsCollection.getInstance().getRow(rowSelectedIndex);
			ProfessorsCollection.getInstance().deleteProfessor(professor.getNationalID());
			
			MainFrame.getInstance().refreshView("DELETED", rowSelectedIndex);
		}
	}
		
	public void modifyProfessor(int rowSelectedIndex) {
		if(rowSelectedIndex >= 0) {
			Professor professor = ProfessorsCollection.getInstance().getRow(rowSelectedIndex);
			/** REFERENCA: https://www.javatpoint.com/java-string-to-date */
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy.");
			
			String modifiedDateOfBirthStringRepresentation = "07.07.1977.";
			Date modifiedDateOfBirth = null;
			try {
				modifiedDateOfBirth = simpleDateFormat.parse(modifiedDateOfBirthStringRepresentation);
			} catch (ParseException pE) {
				pE.printStackTrace();
			}
			
			ProfessorsCollection.getInstance().modifyProfessor("Jeremić", "Nikola", modifiedDateOfBirth, "Bulevar Oslobođenja 67, Novi Sad",
					"06398098765", "jereminn@gmail.com", "Teodora Mandića 21, Novi Sad", professor.getNationalID(), TitleOfProfessor.DR, CallingOfProfessor.SARADNIK_U_NASTAVI);
			
			MainFrame.getInstance().refreshView(null, -1);
		}
	}
	
	
}
