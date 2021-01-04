package view;

import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import controller.AddEntityAction;
import controller.EditEntityAction;
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
		
		fileMenu = new JMenu("File");
		fileMenu.setIcon(fileMenuIcon);
		fileMenu.setMnemonic(KeyEvent.VK_F);
		
		setUpNewMenuItem();
		setUpCloseMenuItem();
		
		fileMenu.add(newMenuItem);
		fileMenu.addSeparator();
		fileMenu.add(closeMenuItem);
		
		add(fileMenu);
	}

	private void setUpNewMenuItem() {
		String imagePath = getImagePath("New_icon.jpg");
		ImageIcon newMenuItemIcon = ImageIconScaler.scaleImageIcon(imagePath, 16, 16);
		
		AddEntityAction addEntityAction = new AddEntityAction();
		newMenuItem = new JMenuItem(addEntityAction);
		newMenuItem.setText("New");
		newMenuItem.setIcon(newMenuItemIcon);
	}
	
	private void setUpCloseMenuItem() {
		String imagePath = getImagePath("Close_icon.jpg");
		ImageIcon closeMenuItemIcon = ImageIconScaler.scaleImageIcon(imagePath, 16, 16);
		
		closeMenuItem = new JMenuItem("Close", closeMenuItemIcon);
		closeMenuItem.setMnemonic(KeyEvent.VK_C);
		closeMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK));
	}
	
	private void setUpEditMenu() {
		String imagePath = getImagePath("Edit_icon.png");
		ImageIcon editMenuIcon = ImageIconScaler.scaleImageIcon(imagePath, 16, 16);
		
		editMenu = new JMenu("Edit");
		editMenu.setIcon(editMenuIcon);
		editMenu.setMnemonic(KeyEvent.VK_E);
		
		setUpEditMenuItem();
		setUpDeleteMenuItem();
		
		editMenu.add(editMenuItem);
		editMenu.addSeparator();
		editMenu.add(deleteMenuItem);
		
		add(editMenu);
	}
	
	private void setUpEditMenuItem() {
		String imagePath = getImagePath("Edit_icon.png");
		ImageIcon editMenuItemIcon = ImageIconScaler.scaleImageIcon(imagePath, 16, 16);
		
		EditEntityAction editEntityAction = new EditEntityAction();
		editMenuItem = new JMenuItem(editEntityAction);
		editMenuItem.setText("Edit");
		editMenuItem.setIcon(editMenuItemIcon);
	}
	
	private void setUpDeleteMenuItem() {
		String imagePath = getImagePath("Delete_icon.png");
		ImageIcon deleteMenuItemIcon = ImageIconScaler.scaleImageIcon(imagePath, 16, 16);
		
		deleteMenuItem = new JMenuItem("Delete", deleteMenuItemIcon);
		deleteMenuItem.setMnemonic(KeyEvent.VK_D);
		deleteMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.CTRL_DOWN_MASK));
	}
	
	private void setUpHelpMenu() {
		String imagePath = getImagePath("Help_icon.png");
		ImageIcon helpMenuIcon = ImageIconScaler.scaleImageIcon(imagePath, 16, 16);
		
		helpMenu = new JMenu("Help");
		helpMenu.setIcon(helpMenuIcon);
		helpMenu.setMnemonic(KeyEvent.VK_H);
		
		setUpHelpMenuItem();
		setUpAboutMenuItem();
		
		helpMenu.add(helpMenuItem);
		helpMenu.addSeparator();
		helpMenu.add(aboutMenuItem);
		
		add(helpMenu);
	}
	
	private void setUpHelpMenuItem() {
		String imagePath = getImagePath("Help_icon.png");
		ImageIcon helpMenuItemIcon = ImageIconScaler.scaleImageIcon(imagePath, 16, 16);
		
		helpMenuItem = new JMenuItem("Help", helpMenuItemIcon);
		helpMenuItem.setMnemonic(KeyEvent.VK_L);
		helpMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, KeyEvent.CTRL_DOWN_MASK));
		
		HelpDialogOpeningListener helpDialogOpeningListener = new HelpDialogOpeningListener();
		helpMenuItem.addActionListener(helpDialogOpeningListener);
	}
	
	private void setUpAboutMenuItem() {
		String imagePath = getImagePath("About_icon.png");
		ImageIcon aboutMenuItemIcon = ImageIconScaler.scaleImageIcon(imagePath, 16, 16);
		
		aboutMenuItem = new JMenuItem("About", aboutMenuItemIcon);
		aboutMenuItem.setMnemonic(KeyEvent.VK_A);
		aboutMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK));
		
		AboutDialogOpeningListener aboutDialogOpeningListener = new AboutDialogOpeningListener();
		aboutMenuItem.addActionListener(aboutDialogOpeningListener);
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
