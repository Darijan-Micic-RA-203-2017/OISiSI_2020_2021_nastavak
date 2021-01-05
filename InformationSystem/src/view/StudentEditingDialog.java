package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

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
		
		confirmationButton.addActionListener(this);
		cancellationButton.addActionListener(this);
		
		add(studentEditingTabbedPane);
	}
	
	public StudentEditingTabbedPane getStudentEditingTabbedPane() {
		return studentEditingTabbedPane;
	}
	
	/** REFERENCA: Materijali za vežbe (v4 -> a - Unutrasnje klase i dogadjaji -> Interfejsi i unutrasnje klase.pdf) */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clickedButton = (JButton) e.getSource();
		
		switch (clickedButton.getName()) {
			case "confirmationButton":
				int selectedRow = MainFrame.getInstance().getTabbedPane().getStudentsTab().
						getStudentsTable().getSelectedRow();
				StudentsController.getInstance().editStudentNonGradesData(selectedRow, this);
				dispose();
				break;
			case "cancellationButton":
				dispose();
		}
	}
}
