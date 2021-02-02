package listeners;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

import repository.GradesRepository;
import repository.ProfessorsRepository;
import repository.StudentsRepository;
import repository.SubjectsRepository;
import view.MainFrame;

/** REFERENCA: Materijali za vežbe (v4 -> b - Dogadjaji -> Dogadjaji -> listeners -> window -> MyWindowListener.java) */
public class MainFrameClosingListener implements WindowListener {
	@Override
	public void windowActivated(WindowEvent arg0) {}
	
	@Override
	public void windowClosed(WindowEvent arg0) {}
	
	@Override
	public void windowClosing(WindowEvent arg0) {
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
	
	@Override
	public void windowDeactivated(WindowEvent arg0) {}
	
	@Override
	public void windowDeiconified(WindowEvent arg0) {}
	
	@Override
	public void windowIconified(WindowEvent arg0) {}
	
	@Override
	public void windowOpened(WindowEvent arg0) {}
}
