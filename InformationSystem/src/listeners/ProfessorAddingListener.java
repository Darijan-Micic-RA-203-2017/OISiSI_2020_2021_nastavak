package listeners;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.ProfessorsController;
import view.MainFrame;
import view.ProfessorAddingDialog;

public class ProfessorAddingListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		ProfessorsController.getInstance().addProfessor();
		
		Window[] ownedWindows = MainFrame.getInstance().getOwnedWindows();
		
		ProfessorAddingDialog dialog = null;
		for(Window w : ownedWindows) {
			if(w instanceof ProfessorAddingDialog) {
				dialog = (ProfessorAddingDialog) w;
			}
		}
		
		ProfessorAddingDialog professorAddingDialog = dialog;
		professorAddingDialog.dispose();
	}
}
