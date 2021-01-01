package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

import view.MainFrame;
import view.StudentAddingDialog;
import view.StudentsTab;
import view.ProfessorsTab;
import view.ProfessorAddingDialog;

public class AddEntityAction extends AbstractAction {
	public AddEntityAction() {
		putValue(MNEMONIC_KEY, KeyEvent.VK_N);
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Component selectedTab = MainFrame.getInstance().getTabbedPane().getSelectedComponent();
		
		if (selectedTab instanceof StudentsTab) {
			StudentAddingDialog addingDialog = new StudentAddingDialog(MainFrame.getInstance());
			addingDialog.setVisible(true);
		}
		else if(selectedTab instanceof ProfessorsTab) {
			ProfessorAddingDialog addingDialog = new ProfessorAddingDialog(MainFrame.getInstance());
			addingDialog.setVisible(true);
		}
	}
}
