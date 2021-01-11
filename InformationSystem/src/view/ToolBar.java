package view;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

import controller.AddEntityAction;
import controller.EditEntityAction;


public class ToolBar extends JToolBar implements ActionListener {
	
	private static final long serialVersionUID = 4L;
	private JButton btnNew;
	private JButton btnEdit;
	private JButton btnDelete;
	private JButton btnFind;
	
	
	public ToolBar() {
		/** REFERENCA: Materijali za vežbe (v2 -> Termin3 - Swing komponente.pdf ,v3 -> Termin5 - Layout.pdf) */
		BoxLayout boxLayout = new BoxLayout(this, BoxLayout.X_AXIS);
		this.setLayout(boxLayout);
		
		this.setBorder(BorderFactory.createLineBorder(Color.GRAY,2));
		
		String imagePath1 = getImagePath("new-icon.jpg");
		ImageIcon newToolBarIcon = ImageIconScaler.scaleImageIcon(imagePath1, 20, 20);
		
		AddEntityAction addEntityAction = new AddEntityAction();
		this.btnNew = new JButton(addEntityAction);
		btnNew.setToolTipText("New");
		btnNew.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.btnNew.setIcon(newToolBarIcon);
		add(btnNew);
		
		this.add(Box.createHorizontalStrut(5));
		this.add(btnNew);

		String imagePath2 = getImagePath("edit-icon.png");
		ImageIcon editToolBarIcon = ImageIconScaler.scaleImageIcon(imagePath2, 20, 20);
		
		EditEntityAction editEntityAction = new EditEntityAction();
		this.btnEdit = new JButton(editEntityAction);
		btnEdit.setToolTipText("Edit");
		btnEdit.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.btnEdit.setIcon(editToolBarIcon);
		add(btnEdit);
		
		this.add(Box.createHorizontalStrut(5));
		this.add(btnEdit);
		
		btnEdit.addActionListener(this);

		String imagePath3 = getImagePath("delete-icon.png");
		ImageIcon deleteToolBarIcon = ImageIconScaler.scaleImageIcon(imagePath3, 20, 20);
		this.btnDelete = new JButton();
		btnDelete.setToolTipText("Delete");
		btnDelete.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.btnDelete.setIcon(deleteToolBarIcon);
		add(btnDelete);
		
		this.add(Box.createHorizontalStrut(5));
		this.add(btnDelete);
		
		btnDelete.addActionListener(this);
		
		JTextField t = new JTextField("Unesite korisnika");
		t.setMaximumSize(new Dimension(t.getPreferredSize().width, Integer.MAX_VALUE));
		this.add(Box.createHorizontalGlue());
		this.add(t);
		
		this.add(Box.createHorizontalStrut(5));
		
		String imagePath4 = getImagePath("find-icon.png");
		ImageIcon findToolBarIcon = ImageIconScaler.scaleImageIcon(imagePath4, 20, 20);
		this.btnFind = new JButton();
		btnFind.setToolTipText("Find");
		btnFind.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.btnFind.setIcon(findToolBarIcon);
		add(btnFind);
		
		this.add(Box.createHorizontalStrut(5));
		this.add(btnFind);
		
		btnFind.addActionListener(this);
		
		
		setBackground(new Color(255, 255, 204));
		setFloatable(false);


		
	}
	/** REFERENCA: https://www.youtube.com/watch?v=2KQ2ryPS4Kg */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnDelete) {
			JOptionPane.showMessageDialog(null, "Pritisnuli ste dugme Delete");
		}
		else if(e.getSource() == btnFind) {
			JOptionPane.showMessageDialog(null, "Pritisnuli ste dugme Find");
		}
	}
	
	// Radnja za izgradnju putanje do slike:
		private String getImagePath(String nameOfImage) {
			StringBuilder imagePathBuilder = new StringBuilder("images");
			imagePathBuilder.append(File.separator).append("toolBar");
			imagePathBuilder.append(File.separator).append(nameOfImage);
			
			String imagePath = imagePathBuilder.toString();
			
			return imagePath;
		}

}
