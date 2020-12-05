package view;

import java.awt.*;
import java.awt.event.*;

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
		
		super(SwingConstants.HORIZONTAL);
		btnNew = new JButton();
		btnNew.setToolTipText("New");
		btnNew.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNew.setIcon(new ImageIcon("images/toolBar/new-icon.jpg"));
		add(btnNew);
		btnNew.addActionListener(this);
		
		addSeparator();

		btnEdit = new JButton();
		btnEdit.setToolTipText("Edit");
		btnEdit.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnEdit.setIcon(new ImageIcon("images/toolBar/edit-icon.png"));
		add(btnEdit);
		btnEdit.addActionListener(this);
		
		addSeparator();

		btnDelete = new JButton();
		btnDelete.setToolTipText("Delete");
		btnDelete.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnDelete.setIcon(new ImageIcon("images/toolBar/delete-icon.png"));
		add(btnDelete);
		btnDelete.addActionListener(this);
		
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		addSeparator();
		
		JTextField t = new JTextField("Unesite korisnika");
		add(t);
		
		addSeparator();
		
		btnFind = new JButton();
		btnFind.setToolTipText("Find");
		btnFind.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnFind.setIcon(new ImageIcon("images/toolBar/find-icon.png"));
		add(btnFind);
		btnFind.addActionListener(this);
		
		
		setBackground(new Color(255, 255, 204));



		
	}
	
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
