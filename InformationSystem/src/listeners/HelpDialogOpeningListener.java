package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.HelpDialog;
import view.MainFrame;

public class HelpDialogOpeningListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent arg0) {
		HelpDialog helpDialog = new HelpDialog(MainFrame.getInstance());
		helpDialog.setVisible(true);
	}
}
