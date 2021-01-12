package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import controller.GradesController;
import controller.StudentsController;

public class StudentEditingDialog extends JDialog implements ActionListener {
	// Polja:
	private String typeOfDialog;
	private StudentEditingTabbedPane studentEditingTabbedPane;
	
	// Konstruktor:
	public StudentEditingDialog(JFrame parent, int selectedRowIndex) {
		super(parent, "Izmena studenta", true);
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		setSize(screenSize.width * 3 / 8, screenSize.height * 29 / 40);
		setResizable(false);
		setLocationRelativeTo(parent);
		
		typeOfDialog = "StudentEditingDialog";
		studentEditingTabbedPane = 
				new StudentEditingTabbedPane(selectedRowIndex, typeOfDialog);
		
		JButton confirmationButton = 
				studentEditingTabbedPane.getStudentNonGradesDataPanel().getConfirmationButton();
		JButton cancellationButton = 
				studentEditingTabbedPane.getStudentNonGradesDataPanel().getCancellationButton();
		JButton gradeCancellationButton = studentEditingTabbedPane.getPassedSubjectsPanel().getGradeCancellationButton();
		
		confirmationButton.addActionListener(this);
		cancellationButton.addActionListener(this);
		gradeCancellationButton.addActionListener(this);
		
		add(studentEditingTabbedPane);
	}
	
	public StudentEditingTabbedPane getStudentEditingTabbedPane() {
		return studentEditingTabbedPane;
	}
	
	/** REFERENCA: Materijali za vežbe (v6 -> JTableMVCSimple -> view -> MainFrame.java) */
	public void refreshView(String action, int value) {
		int selectedTabIndex = studentEditingTabbedPane.getSelectedIndex();
		
		if (selectedTabIndex == 1) {
			AbstractPassedSubjectsTableModel passedSubjectsTableModel = 
					(AbstractPassedSubjectsTableModel) studentEditingTabbedPane.
							getPassedSubjectsPanel().getPassedSubjectsTable().getModel();
			
			passedSubjectsTableModel.fireTableDataChanged();
			validate();
		}
	}
	
	/** REFERENCA: Materijali za vežbe (v4 -> a - Unutrasnje klase i dogadjaji -> Interfejsi i unutrasnje klase.pdf) */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clickedButton = (JButton) e.getSource();
		
		switch (clickedButton.getName()) {
			case "confirmationButton":
				int selectedRowInStudentsTable = MainFrame.getInstance().getTabbedPane().
						getStudentsTab().getStudentsTable().getSelectedRow();
				StudentsController.getInstance().
						editStudentNonGradesData(selectedRowInStudentsTable, this);
				dispose();
				break;
			case "cancellationButton":
				dispose();
				break;
			/** REFERENCA: Materijali za vežbe (v4 -> b - Dogadjaji -> Dogadjaji.pdf) */
			/** REFERENCA: Materijali za vežbe (v4 -> b - Dogadjaji -> Dogadjaji -> listeners -> window -> MyWindowListener.java) */
			case "gradeCancellationButton":
				int selectedRowInPassedSubjectsTable = studentEditingTabbedPane.
						getPassedSubjectsPanel().getPassedSubjectsTable().getSelectedRow();
				
				if (selectedRowInPassedSubjectsTable >= 0) {
					int selectedOption = JOptionPane.showConfirmDialog(this, 
							"Da li ste sigurni da želite da poništite ocenu?", 
							"Poništavanje ocene", JOptionPane.YES_NO_OPTION);

					if (selectedOption == JOptionPane.YES_OPTION) {
						GradesController.getInstance().
								cancelGrade(selectedRowInPassedSubjectsTable, this);

						studentEditingTabbedPane.getPassedSubjectsPanel().setAverageGradeLabelText();
						studentEditingTabbedPane.getPassedSubjectsPanel().setTotalEspbLabelText();
					}
				} else {
					JOptionPane.showMessageDialog(this, "Da bi se moglo izvršiti "
							+ "poništavanje ocene, ona mora biti odabrana u tabeli.", 
							"Upozorenje", JOptionPane.WARNING_MESSAGE);
				}
				
				break;
		}
	}
}
