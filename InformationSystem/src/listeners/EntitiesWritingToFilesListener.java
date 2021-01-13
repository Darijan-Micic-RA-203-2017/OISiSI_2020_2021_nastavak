package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import dao.GradeDAO;
import dao.ProfessorDAO;
import dao.StudentDAO;
import dao.SubjectDAO;
import view.MainFrame;

public class EntitiesWritingToFilesListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		int selectedOption = JOptionPane.showConfirmDialog(MainFrame.getInstance(), 
				"Da li ste sigurni da želite da zatvorite aplikaciju?", "Zatvaranje aplikacije", 
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		
		if (selectedOption == JOptionPane.YES_OPTION) {
			StudentDAO studentDAO = new StudentDAO();
			studentDAO.writeToFile();
			
			ProfessorDAO professorDAO = new ProfessorDAO();
			professorDAO.writeToFile();
			
			SubjectDAO subjectDAO = new SubjectDAO();
			subjectDAO.writeToFile();
			
			GradeDAO gradeDAO = new GradeDAO();
			gradeDAO.writeToFile();
			
			MainFrame.getInstance().setDefaultCloseOperation(MainFrame.EXIT_ON_CLOSE);
		} else {
			MainFrame.getInstance().setDefaultCloseOperation(MainFrame.DO_NOTHING_ON_CLOSE);
		}
	}
}
