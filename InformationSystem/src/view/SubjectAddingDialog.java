package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import controller.SubjectsController;

public class SubjectAddingDialog extends JDialog implements ActionListener {
	// Polja:
	private SubjectNonStudentsDataPanel subjectNonStudentsDataPanel;
	private JScrollPane scrollPane;
	
	// Konstruktor:
	public SubjectAddingDialog(JFrame parent) {
		super(parent, "Dodavanje predmeta", true);
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		setSize(screenSize.width * 3 / 8, screenSize.height * 29 / 40);
		setResizable(false);
		setLocationRelativeTo(parent);
		
		subjectNonStudentsDataPanel = new SubjectNonStudentsDataPanel();
		
		JButton confirmationButton = subjectNonStudentsDataPanel.getConfirmationButton();
		confirmationButton.setEnabled(false);
		confirmationButton.addActionListener(this);
		
		JButton cancellationButton = subjectNonStudentsDataPanel.getCancellationButton();
		cancellationButton.addActionListener(this);
		
		scrollPane = new JScrollPane(subjectNonStudentsDataPanel);
		add(scrollPane);
	}
	
	// Radnje:
	public SubjectNonStudentsDataPanel getSubjectNonStudentsDataPanel() {
		return subjectNonStudentsDataPanel;
	}
	
	/** REFERENCA: Materijali za vežbe (v4 -> a - Unutrasnje klase i dogadjaji -> Interfejsi i unutrasnje klase.pdf) */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clickedButton = (JButton) e.getSource();
		
		switch (clickedButton.getName()) {
			case "confirmationButton":
				SubjectsController.getInstance().addSubject(this);
				dispose();
				break;
			case "cancellationButton":
				dispose();
		}
	}
}
