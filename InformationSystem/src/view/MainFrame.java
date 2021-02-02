package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import view.MenuBar;
import view.ToolBar;

import listeners.MainFrameClosingListener;

public class MainFrame extends JFrame {
	/** REFERENCA: Materijali za vežbe (v5 -> a - Singleton -> Singleton.pdf) */
	private static MainFrame instance = null;
	
	public static MainFrame getInstance() {
		if (instance == null) {
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
		
		BorderLayout layout = new BorderLayout();
		setLayout(layout);
		
		MainFrameClosingListener mainFrameClosingListener = new MainFrameClosingListener();
		addWindowListener(mainFrameClosingListener);
		
		menuBar = new MenuBar();
		setJMenuBar(menuBar);
		
		toolBar = new ToolBar();
		add(toolBar, BorderLayout.NORTH);
		
		statusBar = new StatusBar();
		add(statusBar, BorderLayout.SOUTH);
		
		tabbedPane = new TabbedPane();
		add(tabbedPane, BorderLayout.CENTER);
	}
	
	public TabbedPane getTabbedPane() {
		return tabbedPane;
	}
	
	public void refreshView(String action, int value) {
		int selectedTabIndex = tabbedPane.getSelectedIndex();
		
		if (selectedTabIndex == 0) {
			AbstractStudentsTableModel studentsTableModel = (AbstractStudentsTableModel) 
					tabbedPane.getStudentsTab().getStudentsTable().getModel();
			
			studentsTableModel.fireTableDataChanged();
		} else if (selectedTabIndex == 1) {
			AbstractProfessorsTableModel professorsTableModel = (AbstractProfessorsTableModel) 
					tabbedPane.getProfessorsTab().getProfessorsTable().getModel();
			
			professorsTableModel.fireTableDataChanged();
		} else if (selectedTabIndex == 2) {
			AbstractSubjectsTableModel subjectsTableModel = (AbstractSubjectsTableModel) 
					tabbedPane.getSubjectsTab().getSubjectsTable().getModel();
			
			subjectsTableModel.fireTableDataChanged();
			
			if (action.equals("DELETED SUBJECT")) {
				AbstractStudentsTableModel studentsTableModel = (AbstractStudentsTableModel) 
						tabbedPane.getStudentsTab().getStudentsTable().getModel();
				
				studentsTableModel.fireTableDataChanged();
			}
		}
		
		validate();
	}
}
