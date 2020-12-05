package view;

import java.awt.*;
import java.awt.event.*;

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


public class ToolBar extends JToolBar implements ActionListener {
	
	private static final long serialVersionUID = 4L;
	private JButton btnNew;
	private JButton btnEdit;
	private JButton btnDelete;
	private JButton btnFind;
	
	
	public ToolBar() {
		/** REFERENCA: Materijali za vežbe (v3 -> Termin5 - Layout.pdf) */
		BoxLayout boxLayout = new BoxLayout(this, BoxLayout.X_AXIS);
		this.setLayout(boxLayout);
		
		this.setBorder(BorderFactory.createLineBorder(Color.GRAY,2));
		
		this.btnNew = new JButton();
		btnNew.setToolTipText("New");
		btnNew.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNew.setIcon(new ImageIcon("images/toolBar/new-icon.jpg"));
		add(btnNew);
		
		this.add(Box.createHorizontalStrut(5));
		this.add(btnNew);
		
		btnNew.addActionListener(this);

		this.btnEdit = new JButton();
		btnEdit.setToolTipText("Edit");
		btnEdit.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnEdit.setIcon(new ImageIcon("images/toolBar/edit-icon.png"));
		add(btnEdit);
		
		this.add(Box.createHorizontalStrut(5));
		this.add(btnEdit);
		
		btnEdit.addActionListener(this);

		this.btnDelete = new JButton();
		btnDelete.setToolTipText("Delete");
		btnDelete.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnDelete.setIcon(new ImageIcon("images/toolBar/delete-icon.png"));
		add(btnDelete);
		
		this.add(Box.createHorizontalStrut(5));
		this.add(btnDelete);
		
		btnDelete.addActionListener(this);
		
		this.add(new JToolBar.Separator(new Dimension(1000,0)));
		
		JTextField t = new JTextField("Unesite korisnika");
		this.add(t);
		
		this.add(Box.createHorizontalStrut(5));
		
		this.btnFind = new JButton();
		btnFind.setToolTipText("Find");
		btnFind.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnFind.setIcon(new ImageIcon("images/toolBar/find-icon.png"));
		add(btnFind);
		
		this.add(Box.createHorizontalStrut(5));
		this.add(btnFind);
		
		btnFind.addActionListener(this);
		
		
		setBackground(new Color(255, 255, 204));
		setFloatable(false);


		
	}
	/** REFERENCA: https://www.youtube.com/watch?v=2KQ2ryPS4Kg */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnNew) {
			JOptionPane.showMessageDialog(null, "Pritisnuli ste dugme New");
		}
		else if(e.getSource() == btnEdit) {
			JOptionPane.showMessageDialog(null, "Pritisnuli ste dugme Edit");
		}
		else if(e.getSource() == btnDelete) {
			JOptionPane.showMessageDialog(null, "Pritisnuli ste dugme Delete");
		}
		else if(e.getSource() == btnFind) {
			JOptionPane.showMessageDialog(null, "Pritisnuli ste dugme Find");
		}
	}

}
