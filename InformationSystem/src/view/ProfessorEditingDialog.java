package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

import controller.ProfessorsController;

public class ProfessorEditingDialog extends JDialog implements ActionListener {
	private ProfessorEditingTabbedPane professorEditingTabbedPane;
	
	public ProfessorEditingDialog(JFrame parent, int selectedRowIndex) {
		super(parent, "Izmena profesora", true);
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		setSize(screenSize.width * 3 / 8, screenSize.height * 29 / 40);
		setResizable(false);
		setLocationRelativeTo(parent);
		
		professorEditingTabbedPane = new ProfessorEditingTabbedPane(selectedRowIndex);
		
		JButton confirmationButton =
				professorEditingTabbedPane.getProfessorNonSubjectsDataPanel().getConfirmationButton();
		JButton cancellationButton =
				professorEditingTabbedPane.getProfessorNonSubjectsDataPanel().getCancellationButton();
		
		confirmationButton.addActionListener(this);
		cancellationButton.addActionListener(this);
		
		add(professorEditingTabbedPane);
	}
	
	public ProfessorEditingTabbedPane getProfessorEditingTabbedPane() {
		return professorEditingTabbedPane;
	}
	
	/** REFERENCA: Materijali za vežbe (v4 -> a - Unutrasnje klase i dogadjaji -> Interfejsi i unutrasnje klase.pdf) */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clickedButton = (JButton) e.getSource();
		
		switch (clickedButton.getName()) {
			case "confirmationButton":
				int selectedRow = MainFrame.getInstance().getTabbedPane().getProfessorsTab().
						getProfessorsTable().getSelectedRow();
				ProfessorsController.getInstance().editProfessorNonSubjectsData(selectedRow, this);
				dispose();
				break;
			case "cancellationButton":
				dispose();
		}
	}
}
