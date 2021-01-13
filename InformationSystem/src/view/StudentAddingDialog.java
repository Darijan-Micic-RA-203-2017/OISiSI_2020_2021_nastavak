package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import controller.StudentsController;

public class StudentAddingDialog extends JDialog implements ActionListener {
	// Polja:
	private String typeOfDialog;
	private StudentNonGradesDataPanel studentNonGradesDataPanel;
	private JScrollPane scrollPane;
	
	// Konstruktor:
	public StudentAddingDialog(JFrame parent) {
		super(parent, "Dodavanje studenta", true);
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		setSize(screenSize.width * 3 / 8, screenSize.height * 29 / 40);
		setResizable(false);
		setLocationRelativeTo(parent);
		
		typeOfDialog = "StudentAddingDialog";
		studentNonGradesDataPanel = new StudentNonGradesDataPanel(typeOfDialog, -1);
		
		JButton confirmationButton = studentNonGradesDataPanel.getConfirmationButton();
		confirmationButton.setEnabled(false);
		confirmationButton.addActionListener(this);
		
		JButton cancellationButton = studentNonGradesDataPanel.getCancellationButton();
		cancellationButton.addActionListener(this);
		
		scrollPane = new JScrollPane(studentNonGradesDataPanel);
		add(scrollPane);
	}
	
	// Radnje:
	public StudentNonGradesDataPanel getStudentNonGradesDataPanel() {
		return studentNonGradesDataPanel;
	}
	
	/** REFERENCA: Materijali za vežbe (v4 -> a - Unutrasnje klase i dogadjaji -> Interfejsi i unutrasnje klase.pdf) */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clickedButton = (JButton) e.getSource();
		
		switch (clickedButton.getName()) {
			case "confirmationButton":
				StudentsController.getInstance().addStudent(this);
				dispose();
				break;
			case "cancellationButton":
				dispose();
		}
	}
}
