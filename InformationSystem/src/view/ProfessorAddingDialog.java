package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import controller.ProfessorsController;

public class ProfessorAddingDialog extends JDialog implements ActionListener {
	private String typeOfDialog;
	private ProfessorNonSubjectsDataPanel professorNonSubjectsDataPanel;
	private JScrollPane scrollPane;
	
	public ProfessorAddingDialog(JFrame parent) {
		super(parent, "Dodavanje profesora", true);
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		setSize(screenSize.width*3/8, screenSize.height*29/40);
		setResizable(false);
		setLocationRelativeTo(parent);
		
		typeOfDialog = "ProfessorAddingDialog";
		professorNonSubjectsDataPanel = new ProfessorNonSubjectsDataPanel(typeOfDialog, -1);
		
		JButton confirmationButton = professorNonSubjectsDataPanel.getConfirmationButton();
		confirmationButton.setEnabled(false);
		confirmationButton.addActionListener(this);
		
		JButton cancellationButton = professorNonSubjectsDataPanel.getCancellationButton();
		cancellationButton.addActionListener(this);
		
		scrollPane = new JScrollPane(professorNonSubjectsDataPanel);
		add(scrollPane);
	}
	
	public ProfessorNonSubjectsDataPanel getProfessorNonSubjectDataPanel() {
		return professorNonSubjectsDataPanel;
	}
	
	/** REFERENCA: Materijali za vežbe (v4 -> a - Unutrasnje klase i dogadjaji -> Interfejsi i unutrasnje klase.pdf) */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clickedButton = (JButton) e.getSource();
		
		switch(clickedButton.getName()) {
		case "confirmationButton":
			ProfessorsController.getInstance().addProfessor(this);
			dispose();
			break;
		case "cancellationButton":
			dispose();
		}
	}
	
	
	
}
