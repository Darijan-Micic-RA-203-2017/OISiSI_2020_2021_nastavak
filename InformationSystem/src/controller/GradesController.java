package controller;

import java.util.ArrayList;

import model.Grade;
import model.GradesCollection;
import model.Student;
import view.StudentEditingDialog;

/** REFERENCA: Materijali za vežbe (v6 -> JTableMVCSimple -> controller -> IgraciController.java) */
public class GradesController {
	private static GradesController instance = null;
	
	public static GradesController getInstance() {
		if (instance == null) {
			instance = new GradesController();
		}
		
		return instance;
	}
	
	private GradesController() {}
	
	public void cancelGrade(int selectedRowIndex, StudentEditingDialog studentEditingDialog) {
		// Izmena modela:
		Student selectedStudent = studentEditingDialog.getStudentEditingTabbedPane().
				getSelectedStudent();
		String indexNumber = selectedStudent.getIndexNumber();
		
		ArrayList<Grade> gradesOfStudent = GradesCollection.getInstance().
				getGradesOfStudent(indexNumber);
		int selectedGradeIndex = studentEditingDialog.getStudentEditingTabbedPane().
				getPassedSubjectsPanel().getPassedSubjectsTable().getSelectedRow();
		Grade cancelledGrade = gradesOfStudent.get(selectedGradeIndex);
		GradesCollection.getInstance().getGrades().remove(cancelledGrade);
		
		StudentsController.getInstance().cancelGrade(indexNumber, cancelledGrade.getId());
		SubjectsController.getInstance().
				moveStudentToNonPassedList(cancelledGrade.getSubject().getId(), indexNumber);
		
		// Osvežavanje prikaza:
		studentEditingDialog.refreshView("CANCELLED GRADE", selectedRowIndex);
	}
}
