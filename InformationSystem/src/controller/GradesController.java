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
	
	public void cancelGrade(int rowSelectedIndex, StudentEditingDialog studentEditingDialog) {
		if (rowSelectedIndex >= 0) {
			// Izmena modela:
			Student selectedStudent = studentEditingDialog.getStudentEditingTabbedPane().
					getSelectedStudent();
			
			ArrayList<Grade> gradesOfStudent = GradesCollection.getInstance().
					getGradesOfStudent(selectedStudent.getIndexNumber());
			int selectedGradeIndex = studentEditingDialog.getStudentEditingTabbedPane().
					getPassedSubjectsPanel().getPassedSubjectsTable().getSelectedRow();
			Grade cancelledGrade = gradesOfStudent.get(selectedGradeIndex);
			GradesCollection.getInstance().getGrades().remove(cancelledGrade);
			
			StudentsController.getInstance().cancelGrade(selectedStudent.getIndexNumber(), 
					cancelledGrade.getId());
			SubjectsController.getInstance().
					moveStudentToNonPassedList(cancelledGrade.getSubject().getId(), 
							selectedStudent.getIndexNumber());
			
			// Osvežavanje prikaza:
			studentEditingDialog.refreshView(null, -1);
		}
	}
}
