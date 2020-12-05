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

public class Frame extends JFrame {
	

	private static final long serialVersionUID = 4L;
	
	public Frame() {
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize(screenWidth * 3 / 4, screenHeight * 3 / 4);
		setTitle("Studentska služba");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		this.add(panel);
		
		JLabel lbl = new JLabel("TODO: Prikaz entiteta sistema");
		lbl.setToolTipText("Prikaz entiteta sistema ce biti naknadno uradjen");
		panel.add(lbl);
		
		MenuBar menu = new MenuBar();
		this.setJMenuBar(menu);
		
		ToolBar toolbar = new ToolBar();
		add(toolbar, BorderLayout.NORTH);
		
		StatusBar statusbar = new StatusBar();
		add(statusbar, BorderLayout.SOUTH);
	}

}
