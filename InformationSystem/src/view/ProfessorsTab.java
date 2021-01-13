package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ProfessorsTab extends JPanel {
	
	private ProfessorsTable professorsTable;
	private JScrollPane professorsScrollPane;
	
	public ProfessorsTab() {
		BorderLayout layout = new BorderLayout();
		setLayout(layout);
		
		professorsTable = new ProfessorsTable();
		professorsScrollPane = new JScrollPane(professorsTable);
		add(professorsScrollPane, BorderLayout.CENTER);
	}
	
	public ProfessorsTable getProfessorsTable() {
		return professorsTable;
	}

}
