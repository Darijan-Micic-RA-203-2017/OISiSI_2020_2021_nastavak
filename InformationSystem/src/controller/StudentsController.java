package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.StatusOfStudent;
import model.Student;
import model.StudentsCollection;
import view.MainFrame;

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
		/** REFERENCA: https://www.javatpoint.com/java-string-to-date */
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
		
		String dateOfBirthStringRepresentation = "26.08.1998.";
		Date dateOfBirth = null;
		try {
			dateOfBirth = simpleDateFormat.parse(dateOfBirthStringRepresentation);
		} catch (ParseException pE) {
			pE.printStackTrace();
		}
		
		// Izmena modela:
		StudentsCollection.getInstance().addStudent("Vitas", "Marko", dateOfBirth, 
				"Starca Vujadina 7, Kragujevac", "0624560318", "marko.vitas@yahoo.com", 
				"in-88-2019", 2019, 2, StatusOfStudent.S);
		
		// Osvežavanje prikaza:
		//MainFrame.getInstance().refreshView("ADDED", -1);
	}

	public void deleteStudent(int rowSelectedIndex) {
		if (rowSelectedIndex >= 0) {
			// Izmena modela:
			Student student = StudentsCollection.getInstance().getRow(rowSelectedIndex);
			StudentsCollection.getInstance().deleteStudent(student.getIndexNumber());
			
			// Osvežavanje prikaza:
			//MainFrame.getInstance().refreshView("DELETED", rowSelectedIndex);
		}
	}

	public void modifyStudentNonGradesData(int rowSelectedIndex) {
		if (rowSelectedIndex >= 0) {
			// Izmena modela:
			Student student = StudentsCollection.getInstance().getRow(rowSelectedIndex);
			
			/** REFERENCA: https://www.javatpoint.com/java-string-to-date */
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
			
			String modifiedDateOfBirthStringRepresentation = "03.01.1998.";
			Date modifiedDateOfBirth = null;
			try {
				modifiedDateOfBirth = simpleDateFormat.parse(modifiedDateOfBirthStringRepresentation);
			} catch (ParseException pE) {
				pE.printStackTrace();
			}
			
			StudentsCollection.getInstance().modifyStudentNonGradesData(student.getIndexNumber(), 
					"Peka", "Stanislav", modifiedDateOfBirth, "Starca Vujadina 7, Kragujevac", 
					"0624560318", "marko.vitas@yahoo.com", 2019, 2, StatusOfStudent.S);
			
			// Osvežavanje prikaza:
			//MainFrame.getInstance().refreshView(null, -1);
		}
	}
}
