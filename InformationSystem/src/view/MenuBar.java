package view;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar {
	// Polja:
	private JMenu fileMenu;
	private JMenuItem newMenuItem;
	private JMenuItem closeMenuItem;
	private JMenu editMenu;
	private JMenuItem editMenuItem;
	private JMenuItem deleteMenuItem;
	private JMenu helpMenu;
	private JMenuItem helpMenuItem;
	private JMenuItem aboutMenuItem;
	
	// Konstruktor:
	public MenuBar() {
		super();
		
		setUpFileMenu();
		setUpEditMenu();
		setUpAboutMenu();
	}
	
	// Ostale radnje:
	private void setUpFileMenu() {
		ImageIcon fileMenuIcon = ImageIconScaler.scaleImageIcon("images/menuBar/File_icon.png", 16, 16);
		ImageIcon newMenuItemIcon = ImageIconScaler.scaleImageIcon("images/menuBar/New_icon.jpg", 16, 16);
		ImageIcon closeMenuItemIcon = ImageIconScaler.scaleImageIcon("images/menuBar/Close_icon.jpg", 16, 16);
		
		this.fileMenu = new JMenu("File");
		this.fileMenu.setIcon(fileMenuIcon);
		
		this.newMenuItem = new JMenuItem("New", newMenuItemIcon);
		
		this.closeMenuItem = new JMenuItem("Close", closeMenuItemIcon);
		
		this.fileMenu.add(newMenuItem);
		this.fileMenu.addSeparator();
		this.fileMenu.add(closeMenuItem);
		
		this.add(fileMenu);
	}
	
	private void setUpEditMenu() {
		ImageIcon editMenuIcon = ImageIconScaler.scaleImageIcon("images/menuBar/Edit_icon.png", 16, 16);
		ImageIcon deleteMenuItemIcon = ImageIconScaler.scaleImageIcon("images/menuBar/Delete_icon.png", 16, 16);
		
		this.editMenu = new JMenu("Edit");
		this.editMenu.setIcon(editMenuIcon);
		
		this.editMenuItem = new JMenuItem("Edit", editMenuIcon);
		this.deleteMenuItem = new JMenuItem("Delete", deleteMenuItemIcon);
		
		this.editMenu.add(editMenuItem);
		this.editMenu.addSeparator();
		this.editMenu.add(deleteMenuItem);
		
		this.add(editMenu);
	}
	
	private void setUpAboutMenu() {
		ImageIcon helpMenuIcon = ImageIconScaler.scaleImageIcon("images/menuBar/Help_icon.png", 16, 16);
		ImageIcon aboutMenuItemIcon = ImageIconScaler.scaleImageIcon("images/menuBar/About/icon.png", 16, 16);
		
		this.helpMenu = new JMenu("Help");
		this.helpMenu.setIcon(helpMenuIcon);
		
		this.helpMenuItem = new JMenuItem("Help", helpMenuIcon);
		this.aboutMenuItem = new JMenuItem("About", aboutMenuItemIcon);
		
		this.helpMenu.add(helpMenuItem);
		this.helpMenu.addSeparator();
		this.helpMenu.add(aboutMenuItem);
		
		this.add(helpMenu);
	}
}
