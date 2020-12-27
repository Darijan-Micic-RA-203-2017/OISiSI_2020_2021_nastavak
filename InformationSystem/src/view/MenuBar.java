package view;

import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import controller.AddEntityAction;
import listeners.AboutDialogOpeningListener;
import listeners.HelpDialogOpeningListener;

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
		setUpFileMenu();
		setUpEditMenu();
		setUpHelpMenu();
	}
	
	// Ostale radnje:
	private void setUpFileMenu() {
		String imagePath = getImagePath("File_icon.png");
		ImageIcon fileMenuIcon = ImageIconScaler.scaleImageIcon(imagePath, 16, 16);
		
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
		String imagePath = getImagePath("New_icon.jpg");
		ImageIcon newMenuItemIcon = ImageIconScaler.scaleImageIcon(imagePath, 16, 16);
		
		AddEntityAction addEntityAction = new AddEntityAction();
		this.newMenuItem = new JMenuItem(addEntityAction);
		this.newMenuItem.setText("New");
		this.newMenuItem.setIcon(newMenuItemIcon);
	}
	
	private void setUpCloseMenuItem() {
		String imagePath = getImagePath("Close_icon.jpg");
		ImageIcon closeMenuItemIcon = ImageIconScaler.scaleImageIcon(imagePath, 16, 16);
		
		this.closeMenuItem = new JMenuItem("Close", closeMenuItemIcon);
		this.closeMenuItem.setMnemonic(KeyEvent.VK_C);
		this.closeMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK));
	}
	
	private void setUpEditMenu() {
		String imagePath = getImagePath("Edit_icon.png");
		ImageIcon editMenuIcon = ImageIconScaler.scaleImageIcon(imagePath, 16, 16);
		
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
		String imagePath = getImagePath("Edit_icon.png");
		ImageIcon editMenuItemIcon = ImageIconScaler.scaleImageIcon(imagePath, 16, 16);
		
		this.editMenuItem = new JMenuItem("Edit", editMenuItemIcon);
		this.editMenuItem.setMnemonic(KeyEvent.VK_I);
		this.editMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_DOWN_MASK));
	}
	
	private void setUpDeleteMenuItem() {
		String imagePath = getImagePath("Delete_icon.png");
		ImageIcon deleteMenuItemIcon = ImageIconScaler.scaleImageIcon(imagePath, 16, 16);
		
		this.deleteMenuItem = new JMenuItem("Delete", deleteMenuItemIcon);
		this.deleteMenuItem.setMnemonic(KeyEvent.VK_D);
		this.deleteMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.CTRL_DOWN_MASK));
	}
	
	private void setUpHelpMenu() {
		String imagePath = getImagePath("Help_icon.png");
		ImageIcon helpMenuIcon = ImageIconScaler.scaleImageIcon(imagePath, 16, 16);
		
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
		String imagePath = getImagePath("Help_icon.png");
		ImageIcon helpMenuItemIcon = ImageIconScaler.scaleImageIcon(imagePath, 16, 16);
		
		this.helpMenuItem = new JMenuItem("Help", helpMenuItemIcon);
		this.helpMenuItem.setMnemonic(KeyEvent.VK_L);
		this.helpMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, KeyEvent.CTRL_DOWN_MASK));
		
		HelpDialogOpeningListener helpDialogOpeningListener = new HelpDialogOpeningListener();
		this.helpMenuItem.addActionListener(helpDialogOpeningListener);
	}
	
	private void setUpAboutMenuItem() {
		String imagePath = getImagePath("About_icon.png");
		ImageIcon aboutMenuItemIcon = ImageIconScaler.scaleImageIcon(imagePath, 16, 16);
		
		this.aboutMenuItem = new JMenuItem("About", aboutMenuItemIcon);
		this.aboutMenuItem.setMnemonic(KeyEvent.VK_A);
		this.aboutMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK));
		
		AboutDialogOpeningListener aboutDialogOpeningListener = new AboutDialogOpeningListener();
		this.aboutMenuItem.addActionListener(aboutDialogOpeningListener);
	}
	
	// Radnja za izgradnju putanje do slike:
	private String getImagePath(String nameOfImage) {
		StringBuilder imagePathBuilder = new StringBuilder("images");
		imagePathBuilder.append(File.separator).append("menuBar");
		imagePathBuilder.append(File.separator).append(nameOfImage);
		
		String imagePath = imagePathBuilder.toString();
		
		return imagePath;
	}
}
