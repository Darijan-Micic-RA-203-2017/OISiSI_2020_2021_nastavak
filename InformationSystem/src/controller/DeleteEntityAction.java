package controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import view.MainFrame;

public class DeleteEntityAction extends AbstractAction {
	public DeleteEntityAction() {
		putValue(MNEMONIC_KEY, KeyEvent.VK_D);
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.CTRL_DOWN_MASK));
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		int selectedTabIndex = MainFrame.getInstance().getTabbedPane().getSelectedIndex();
		
		if (selectedTabIndex == 0) {
			int selectedRowIndex = MainFrame.getInstance().getTabbedPane().
					getStudentsTab().getStudentsTable().getSelectedRow();
			
			if (selectedRowIndex >= 0) {
				/** REFERENCA: Materijali za vežbe (v4 -> b - Dogadjaji -> Dogadjaji.pdf) */
				int selectedOption = JOptionPane.showConfirmDialog(MainFrame.getInstance(), 
						"Da li ste sigurni da želite da obrišete studenta?", 
						"Brisanje studenta", JOptionPane.YES_NO_OPTION);
				
				if (selectedOption == JOptionPane.YES_OPTION) {
					StudentsController.getInstance().deleteStudent(selectedRowIndex);
				}
			} else {
				/** REFERENCA: Materijali za vežbe (v4 -> b - Dogadjaji -> Dogadjaji.pdf) */
				JOptionPane.showMessageDialog(MainFrame.getInstance(), 
						"Da bi se moglo izvršiti brisanje studenta, on mora biti odabran u "
						+ "tabeli.", "Upozorenje", JOptionPane.WARNING_MESSAGE);
			}
		} else if (selectedTabIndex == 1) {
			int selectedRowIndex = MainFrame.getInstance().getTabbedPane().
					getProfessorsTab().getProfessorsTable().getSelectedRow();
			
			if (selectedRowIndex >= 0) {
				/** REFERENCA: Materijali za vežbe (v4 -> b - Dogadjaji -> Dogadjaji.pdf) */
				int selectedOption = JOptionPane.showConfirmDialog(MainFrame.getInstance(), 
						"Da li ste sigurni da želite da obrišete profesora?", 
						"Brisanje profesora", JOptionPane.YES_NO_OPTION);
				
				if (selectedOption == JOptionPane.YES_OPTION) {
					ProfessorsController.getInstance().deleteProfessor(selectedRowIndex);
				}
			} else {
				/** REFERENCA: Materijali za vežbe (v4 -> b - Dogadjaji -> Dogadjaji.pdf) */
				JOptionPane.showMessageDialog(MainFrame.getInstance(), 
						"Da bi se moglo izvršiti brisanje profesora, on mora biti odabran u "
						+ "tabeli.", "Upozorenje", JOptionPane.WARNING_MESSAGE);
			}
		} else if (selectedTabIndex == 2) {
			int selectedRowIndex = MainFrame.getInstance().getTabbedPane().
					getSubjectsTab().getSubjectsTable().getSelectedRow();
			
			if (selectedRowIndex >= 0) {
				/** REFERENCA: Materijali za vežbe (v4 -> b - Dogadjaji -> Dogadjaji.pdf) */
				int selectedOption = JOptionPane.showConfirmDialog(MainFrame.getInstance(), 
						"Da li ste sigurni da želite da obrišete predmet?", 
						"Brisanje predmeta", JOptionPane.YES_NO_OPTION);
				
				if (selectedOption == JOptionPane.YES_OPTION) {
					SubjectsController.getInstance().deleteSubject(selectedRowIndex);
				}
			} else {
				/** REFERENCA: Materijali za vežbe (v4 -> b - Dogadjaji -> Dogadjaji.pdf) */
				JOptionPane.showMessageDialog(MainFrame.getInstance(), 
						"Da bi se moglo izvršiti brisanje predmeta, on mora biti odabran u "
						+ "tabeli.", "Upozorenje", JOptionPane.WARNING_MESSAGE);
			}
		}
	}
}
