package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.JTextField;

import controller.AddEntityAction;
import controller.DeleteEntityAction;
import controller.EditEntityAction;

public class ToolBar extends JToolBar implements ActionListener {
	private JButton newButton;
	private JButton editButton;
	private JButton deleteButton;
	private JTextField entityFindingCriteriaTextField;
	private JButton findButton;
	
	public ToolBar() {
		/** REFERENCA: Materijali za vežbe (v2 -> Termin3 - Swing komponente.pdf) */
		/** REFERENCA: Materijali za vežbe (v3 -> Termin5 - Layout.pdf) */
		BoxLayout layout = new BoxLayout(this, BoxLayout.X_AXIS);
		setLayout(layout);
		
		setFloatable(false);
		
		setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
		
		Color backgroundColor = new Color(255, 255, 204);
		setBackground(backgroundColor);
		
		setUpNewButton();
		setUpEditButton();
		setUpDeleteButton();
		
		setUpEntityFindingCriteriaTextField();
		setUpFindButton();
	}
	
	private void setUpNewButton() {
		String imagePath = getImagePath("new-icon.jpg");
		ImageIcon newButtonIcon = ImageIconScaler.scaleImageIcon(imagePath, 20, 20);
		
		AddEntityAction addEntityAction = new AddEntityAction();
		newButton = new JButton(addEntityAction);
		newButton.setToolTipText("New");
		newButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		newButton.setIcon(newButtonIcon);
		
		add(Box.createHorizontalStrut(5));
		add(newButton);
		add(Box.createHorizontalStrut(5));
	}
	
	private void setUpEditButton() {
		String imagePath = getImagePath("edit-icon.png");
		ImageIcon editButtonIcon = ImageIconScaler.scaleImageIcon(imagePath, 20, 20);
		
		EditEntityAction editEntityAction = new EditEntityAction();
		editButton = new JButton(editEntityAction);
		editButton.setToolTipText("Edit");
		editButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		editButton.setIcon(editButtonIcon);
		
		add(editButton);
		add(Box.createHorizontalStrut(5));
	}
	
	private void setUpDeleteButton() {
		String imagePath = getImagePath("delete-icon.png");
		ImageIcon deleteButtonIcon = ImageIconScaler.scaleImageIcon(imagePath, 20, 20);
		
		DeleteEntityAction deleteEntityAction = new DeleteEntityAction();
		deleteButton = new JButton(deleteEntityAction);
		deleteButton.setToolTipText("Delete");
		deleteButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		deleteButton.setIcon(deleteButtonIcon);
		
		add(deleteButton);
		add(Box.createHorizontalGlue());
	}
	
	private void setUpEntityFindingCriteriaTextField() {
		entityFindingCriteriaTextField = new JTextField("Unesite kriterijum pretrage");
		
		Dimension textFieldMaximumSize = 
				new Dimension(entityFindingCriteriaTextField.getPreferredSize().width, 
						Integer.MAX_VALUE);
		entityFindingCriteriaTextField.setMaximumSize(textFieldMaximumSize);
		
		add(entityFindingCriteriaTextField);
		add(Box.createHorizontalStrut(5));
	}
	
	private void setUpFindButton() {
		String imagePath = getImagePath("find-icon.png");
		ImageIcon findButtonIcon = ImageIconScaler.scaleImageIcon(imagePath, 20, 20);
		
		findButton = new JButton();
		findButton.setToolTipText("Find");
		findButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		findButton.setIcon(findButtonIcon);
		findButton.addActionListener(this);
		
		add(findButton);
		add(Box.createHorizontalStrut(5));
	}
	
	/** REFERENCA: https://www.youtube.com/watch?v=2KQ2ryPS4Kg */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == findButton) {
			JOptionPane.showMessageDialog(null, "Pritisnuli ste dugme Find");
		}
	}
	
	private String getImagePath(String nameOfImage) {
		StringBuilder imagePathBuilder = new StringBuilder("images");
		imagePathBuilder.append(File.separator).append("toolBar");
		imagePathBuilder.append(File.separator).append(nameOfImage);

		String imagePath = imagePathBuilder.toString();

		return imagePath;
	}
}
