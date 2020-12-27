package controller;

import java.time.LocalDate;

import model.Professor;
import model.ProfessorsCollection;
import model.CallingOfProfessor;
import model.TitleOfProfessor;
import view.MainFrame;

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
	
	public void addProfessor() {
		ProfessorsCollection.getInstance().addProfessor("Kovačević","Miodrag",LocalDate.of(1982, 10, 10),
				"Desanke Maksimović 32, Kragujevac", "0613214457", "miodrag__kovacevic@yahoo.com",
				"Vuka Karadžića 87, Beograd",1010982,TitleOfProfessor.DR,CallingOfProfessor.REDOVNI_PROFESOR);
		
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
			ProfessorsCollection.getInstance().modifyProfessor("Ilijev", "Ivana", LocalDate.of(1989, 7, 8),
					"Branislava Nušića 91, Beograd", "0639076833", "ivkailijev@gmail.com", 
					"Nikole Tesle 4, Beograd", 7089891, TitleOfProfessor.MR, CallingOfProfessor.ASISTENT);
			
			MainFrame.getInstance().refreshView(null, -1);
		}
	}
	
	
}
