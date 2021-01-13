package listeners;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

import dao.GradeDAO;
import dao.ProfessorDAO;
import dao.StudentDAO;
import dao.SubjectDAO;
import view.MainFrame;

/** REFERENCA: Materijali za vežbe (v4 -> b - Dogadjaji -> Dogadjaji -> listeners -> window -> MyWindowListener.java) */
public class MainFrameClosingListener implements WindowListener {
	@Override
	public void windowActivated(WindowEvent arg0) {}
	
	@Override
	public void windowClosed(WindowEvent arg0) {}
	
	@Override
	public void windowClosing(WindowEvent arg0) {
		MainFrame mainFrame = (MainFrame) arg0.getComponent();
		
		int selectedOption = JOptionPane.showConfirmDialog(mainFrame, 
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
			
			mainFrame.setDefaultCloseOperation(MainFrame.EXIT_ON_CLOSE);
		} else {
			mainFrame.setDefaultCloseOperation(MainFrame.DO_NOTHING_ON_CLOSE);
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
