package controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import view.MainFrame;
import view.StudentEditingDialog;
import view.SubjectEditingDialog;
import view.ProfessorEditingDialog;

public class EditEntityAction extends AbstractAction {
	public EditEntityAction() {
		putValue(MNEMONIC_KEY, KeyEvent.VK_I);
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_DOWN_MASK));
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		int selectedTabIndex = MainFrame.getInstance().getTabbedPane().getSelectedIndex();
		
		if (selectedTabIndex == 0) {
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
		} else if (selectedTabIndex == 1) {
			int selectedRowIndex = MainFrame.getInstance().getTabbedPane().
					getProfessorsTab().getProfessorsTable().getSelectedRow();
			
			if (selectedRowIndex >= 0) {
				ProfessorEditingDialog editingDialog =
						new ProfessorEditingDialog(MainFrame.getInstance(), selectedRowIndex);
				editingDialog.setVisible(true);
			} else {
				/** REFERENCA: Materijali za vežbe (v4 -> b - Dogadjaji -> Dogadjaji.pdf) */
				JOptionPane.showMessageDialog(MainFrame.getInstance(), 
						"Da bi se mogla izvršiti izmena profesora, on mora biti odabran u "
						+ "tabeli.", "Upozorenje", JOptionPane.WARNING_MESSAGE);
			}
		} else if (selectedTabIndex == 2) {
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
