package application;

import javax.swing.UIManager;

import controller.EntitiesConnectingAfterReadingController;
import controller.GradesController;
import controller.ProfessorsController;
import controller.StudentsController;
import controller.SubjectsController;
import model.GradesCollection;
import model.ProfessorsCollection;
import model.StudentsCollection;
import model.SubjectsCollection;
import view.MainFrame;

public class App {
	public static void main(String[] args) {
		/** REFERENCA: https://stackoverflow.com/questions/14158555/can-i-localize-the-joptionpane-yes-no-cancel-option */
		UIManager.put("OptionPane.yesButtonText", "Da");
		UIManager.put("OptionPane.noButtonText", "Ne");
		UIManager.put("OptionPane.cancelButtonText", "Odustani");
		
		/** REFERENCA: Materijali za vežbe (v5 -> a - Singleton -> Singleton.pdf) */
		/** REFERENCA: Materijali za vežbe (v6 -> JTableMVCSimple -> igraci -> MainApp.java) */
		StudentsCollection.getInstance();
		ProfessorsCollection.getInstance();
		SubjectsCollection.getInstance();
		GradesCollection.getInstance();
		
		EntitiesConnectingAfterReadingController.getInstance();
		
		StudentsController.getInstance();
		ProfessorsController.getInstance();
		SubjectsController.getInstance();
		GradesController.getInstance();
		
		MainFrame.getInstance();
	}
}
