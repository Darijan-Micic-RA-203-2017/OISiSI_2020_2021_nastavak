package view;

import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

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
		setUpHelpMenu();
	}
	
	// Ostale radnje:
	private void setUpFileMenu() {
		ImageIcon fileMenuIcon = ImageIconScaler.scaleImageIcon("images/menuBar/File_icon.png", 16, 16);
		
		this.fileMenu = new JMenu("File");
		this.fileMenu.setIcon(fileMenuIcon);
		this.fileMenu.setMnemonic(KeyEvent.VK_F);
		
		setUpNewMenuItem();
		setUpCloseMenuItem();
		
		this.fileMenu.add(newMenuItem);
		this.fileMenu.addSeparator();
		this.fileMenu.add(closeMenuItem);
		
		this.add(fileMenu);
	}

	private void setUpNewMenuItem() {
		ImageIcon newMenuItemIcon = ImageIconScaler.scaleImageIcon("images/menuBar/New_icon.jpg", 16, 16);
		
		this.newMenuItem = new JMenuItem("New", newMenuItemIcon);
		this.newMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
	}
	
	private void setUpCloseMenuItem() {
		ImageIcon closeMenuItemIcon = ImageIconScaler.scaleImageIcon("images/menuBar/Close_icon.jpg", 16, 16);
		
		this.closeMenuItem = new JMenuItem("Close", closeMenuItemIcon);
		this.closeMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK));
	}
	
	private void setUpEditMenu() {
		ImageIcon editMenuIcon = ImageIconScaler.scaleImageIcon("images/menuBar/Edit_icon.png", 16, 16);
		
		this.editMenu = new JMenu("Edit");
		this.editMenu.setIcon(editMenuIcon);
		this.editMenu.setMnemonic(KeyEvent.VK_E);
		
		setUpEditMenuItem();
		setUpDeleteMenuItem();
		
		this.editMenu.add(editMenuItem);
		this.editMenu.addSeparator();
		this.editMenu.add(deleteMenuItem);
		
		this.add(editMenu);
	}
	
	private void setUpEditMenuItem() {
		ImageIcon editMenuItemIcon = ImageIconScaler.scaleImageIcon("images/menuBar/Edit_icon.png", 16, 16);
		
		this.editMenuItem = new JMenuItem("Edit", editMenuItemIcon);
		this.editMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_DOWN_MASK));
	}
	
	private void setUpDeleteMenuItem() {
		ImageIcon deleteMenuItemIcon = ImageIconScaler.scaleImageIcon("images/menuBar/Delete_icon.png", 16, 16);
		
		this.deleteMenuItem = new JMenuItem("Delete", deleteMenuItemIcon);
		this.deleteMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.CTRL_DOWN_MASK));
	}
	
	private void setUpHelpMenu() {
		ImageIcon helpMenuIcon = ImageIconScaler.scaleImageIcon("images/menuBar/Help_icon.png", 16, 16);
		
		this.helpMenu = new JMenu("Help");
		this.helpMenu.setIcon(helpMenuIcon);
		this.helpMenu.setMnemonic(KeyEvent.VK_H);
		
		setUpHelpMenuItem();
		setUpAboutMenuItem();
		
		this.helpMenu.add(helpMenuItem);
		this.helpMenu.addSeparator();
		this.helpMenu.add(aboutMenuItem);
		
		this.add(helpMenu);
	}
	
	private void setUpHelpMenuItem() {
		ImageIcon helpMenuItemIcon = ImageIconScaler.scaleImageIcon("images/menuBar/Help_icon.png", 16, 16);
		
		this.helpMenuItem = new JMenuItem("Help", helpMenuItemIcon);
		this.helpMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, KeyEvent.CTRL_DOWN_MASK));
	}
	
	private void setUpAboutMenuItem() {
		ImageIcon aboutMenuItemIcon = ImageIconScaler.scaleImageIcon("images/menuBar/About/icon.png", 16, 16);
		
		this.aboutMenuItem = new JMenuItem("About", aboutMenuItemIcon);
		this.aboutMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK));
	}
}
