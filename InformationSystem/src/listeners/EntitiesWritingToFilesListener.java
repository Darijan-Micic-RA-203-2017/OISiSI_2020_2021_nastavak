package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import repository.GradesRepository;
import repository.ProfessorsRepository;
import repository.StudentsRepository;
import repository.SubjectsRepository;
import view.MainFrame;

public class EntitiesWritingToFilesListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		int selectedOption = JOptionPane.showConfirmDialog(MainFrame.getInstance(), 
				"Da li ste sigurni da želite da zatvorite aplikaciju?", "Zatvaranje aplikacije", 
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		
		if (selectedOption == JOptionPane.YES_OPTION) {
			StudentsRepository studentDAO = new StudentsRepository();
			studentDAO.writeToFile();
			
			ProfessorsRepository professorDAO = new ProfessorsRepository();
			professorDAO.writeToFile();
			
			SubjectsRepository subjectDAO = new SubjectsRepository();
			subjectDAO.writeToFile();
			
			GradesRepository gradeDAO = new GradesRepository();
			gradeDAO.writeToFile();
			
			MainFrame.getInstance().setDefaultCloseOperation(MainFrame.EXIT_ON_CLOSE);
		} else {
			MainFrame.getInstance().setDefaultCloseOperation(MainFrame.DO_NOTHING_ON_CLOSE);
		}
	}
}
