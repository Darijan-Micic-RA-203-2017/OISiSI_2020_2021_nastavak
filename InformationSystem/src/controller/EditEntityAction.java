package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import view.MainFrame;
import view.StudentEditingDialog;
import view.StudentsTab;
import view.SubjectEditingDialog;
import view.SubjectsTab;

public class EditEntityAction extends AbstractAction {
	public EditEntityAction() {
		putValue(MNEMONIC_KEY, KeyEvent.VK_I);
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_DOWN_MASK));
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Component selectedTab = MainFrame.getInstance().getTabbedPane().getSelectedComponent();
		
		if (selectedTab instanceof StudentsTab) {
			int selectedRowIndex = MainFrame.getInstance().getTabbedPane().
					getStudentsTab().getStudentsTable().getSelectedRow();
			
			if (selectedRowIndex >= 0) {
				StudentEditingDialog editingDialog = 
						new StudentEditingDialog(MainFrame.getInstance(), selectedRowIndex);
				editingDialog.setVisible(true);
			} else {
				/** REFERENCA: Materijali za vežbe (v4 -> b - Dogadjaji -> Dogadjaji.pdf) */
				JOptionPane.showMessageDialog(MainFrame.getInstance(), 
						"Da bi se mogla izvršiti izmena studenta, on mora biti odabran u "
						+ "tabeli.", "Upozorenje", JOptionPane.WARNING_MESSAGE);
			}
		} else if (selectedTab instanceof SubjectsTab) {
			int selectedRowIndex = MainFrame.getInstance().getTabbedPane().
					getSubjectsTab().getSubjectsTable().getSelectedRow();
			
			if (selectedRowIndex >= 0) {
				SubjectEditingDialog editingDialog = 
						new SubjectEditingDialog(MainFrame.getInstance(), selectedRowIndex);
				editingDialog.setVisible(true);
			} else {
				/** REFERENCA: Materijali za vežbe (v4 -> b - Dogadjaji -> Dogadjaji.pdf) */
				JOptionPane.showMessageDialog(MainFrame.getInstance(), 
						"Da bi se mogla izvršiti izmena predmeta, on mora biti odabran u "
						+ "tabeli.", "Upozorenje", JOptionPane.WARNING_MESSAGE);
			}
		}
	}
}
