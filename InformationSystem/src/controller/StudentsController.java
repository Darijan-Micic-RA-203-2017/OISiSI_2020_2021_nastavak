package controller;

import java.time.LocalDate;

import model.StatusOfStudent;
import model.Student;
import model.StudentsCollection;
import view.MainFrameForTesting;

/** REFERENCA: Materijali za vežbe (v6 -> JTableMVCSimple -> controller -> IgraciController.java) */
public class StudentsController {
	private static StudentsController instance = null;

	public static StudentsController getInstance() {
		if (instance == null) {
			instance = new StudentsController();
		}
		
		return instance;
	}
	
	// Konstruktor:
	private StudentsController() {}
	
	// Radnje:
	public void addStudent() {
		// Izmena modela:
		StudentsCollection.getInstance().addStudent("Vitas", "Marko", LocalDate.now(), 
				"Starca Vujadina 7, Kragujevac", "0624560318", "marko.vitas@yahoo.com", 
				"in-88-2019", 2019, 2, StatusOfStudent.S);
		
		// Osvežavanje prikaza:
		MainFrameForTesting.getInstance().refreshView("ADDED", -1);
	}

	public void deleteStudent(int rowSelectedIndex) {
		if (rowSelectedIndex >= 0) {
			// Izmena modela:
			Student student = StudentsCollection.getInstance().getRow(rowSelectedIndex);
			StudentsCollection.getInstance().deleteStudent(student.getIndexNumber());
			
			// Osvežavanje prikaza:
			MainFrameForTesting.getInstance().refreshView("DELETED", rowSelectedIndex);
		}
	}

	public void modifyStudentsNonGradeData(int rowSelectedIndex) {
		if (rowSelectedIndex >= 0) {
			// Izmena modela:
			Student student = StudentsCollection.getInstance().getRow(rowSelectedIndex);
			StudentsCollection.getInstance().modifyStudentNonGradesData(student.getIndexNumber(), 
					"Peka", "Stanislav", LocalDate.now(), "Starca Vujadina 7, Kragujevac", 
					"0624560318", "marko.vitas@yahoo.com", 2019, 2, StatusOfStudent.S);
			
			// Osvežavanje prikaza:
			MainFrameForTesting.getInstance().refreshView(null, -1);
		}
	}
}
