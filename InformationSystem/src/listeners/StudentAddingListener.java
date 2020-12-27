package listeners;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.StudentsController;
import view.MainFrame;
import view.StudentAddingDialog;

public class StudentAddingListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		StudentsController.getInstance().addStudent();
		
		Window[] ownedWindows = MainFrame.getInstance().getOwnedWindows();
		
		StudentAddingDialog dialog = null;
		for (Window w : ownedWindows) {
			if (w instanceof StudentAddingDialog) {
				dialog = (StudentAddingDialog) w;
			}
		}
		
		StudentAddingDialog studentAddingDialog = dialog;
		studentAddingDialog.dispose();
	}
}
