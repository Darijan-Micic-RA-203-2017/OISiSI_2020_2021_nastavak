package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.MenuBar;
import view.ToolBar;

import controller.StudentsController;
import model.StudentsCollection;

import controller.ProfessorsController;
import model.ProfessorsCollection;

public class MainFrame extends JFrame {
	
	private static final long serialVersionUID = 4L;
	/** REFERENCA: Materijali za vežbe (v5 -> a - Singleton -> Singleton.pdf) */
	private static MainFrame instance = null;
	
	public static MainFrame getInstance() {
		if(instance == null) {
			instance = new MainFrame();
		}
		return instance;
	}
	
	private MenuBar menuBar;
	private ToolBar toolBar;
	private TabbedPane tabbedPane;
	private StatusBar statusBar;
	
	
	private MainFrame() {
		/** REFERENCA: Materijali za vežbe (v2 -> Termin3 - Swing komponente.pdf) */
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize(screenWidth * 3 / 4, screenHeight * 3 / 4);
		setTitle("Studentska služba");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
		setLayout(new BorderLayout());
		
		menuBar = new MenuBar();
		this.setJMenuBar(menuBar);
		
		toolBar = new ToolBar();
		add(toolBar, BorderLayout.NORTH);
		
		statusBar = new StatusBar();
		add(statusBar, BorderLayout.SOUTH);
		
		tabbedPane = new TabbedPane();
		add(tabbedPane, BorderLayout.CENTER);
		refreshView(null,-1);

	}

	public TabbedPane getTabbedPane() {
		return tabbedPane;
	}
	
	public void refreshView(String action, int value) {
		int selectedTabIndex = tabbedPane.getSelectedIndex();
		
		if(selectedTabIndex == 0) {
			AbstractStudentsTableModel studentsTableModel = 
					(AbstractStudentsTableModel) tabbedPane.getStudentsTab().getStudentsTable().getModel();
			
			studentsTableModel.fireTableDataChanged();
			validate();
		} else if(selectedTabIndex == 1) {
			AbstractProfessorsTableModel professorsTableModel =
					(AbstractProfessorsTableModel) tabbedPane.getProfessorsTab().getProfessorsTable().getModel();
			
			professorsTableModel.fireTableDataChanged();
			validate();
		} else if(selectedTabIndex == 2) {
			AbstractSubjectsTableModel subjectsTableModel =
					(AbstractSubjectsTableModel) tabbedPane.getSubjectsTab().getSubjectsTable().getModel();
			
			subjectsTableModel.fireTableDataChanged();
			validate();
		}
	}

}
