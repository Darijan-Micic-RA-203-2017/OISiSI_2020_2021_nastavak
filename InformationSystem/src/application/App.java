package application;

import controller.ProfessorsController;
import controller.StudentsController;
import controller.SubjectsController;
import model.ProfessorsCollection;
import model.StudentsCollection;
import model.SubjectsCollection;
import view.MainFrame;

public class App {
	public static void main(String[] args) {
		/** REFERENCA: Materijali za vežbe (v5 -> a - Singleton -> Singleton.pdf) */
		/** REFERENCA: Materijali za vežbe (v6 -> JTableMVCSimple -> igraci -> MainApp.java) */
		StudentsCollection.getInstance();
		ProfessorsCollection.getInstance();
		SubjectsCollection.getInstance();
		
		StudentsController.getInstance();
		ProfessorsController.getInstance();
		SubjectsController.getInstance();
		
		MainFrame.getInstance();
	}
}
