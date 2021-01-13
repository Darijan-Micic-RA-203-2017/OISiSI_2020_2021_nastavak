package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.AboutDialog;
import view.MainFrame;

public class AboutDialogOpeningListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent arg0) {
		AboutDialog aboutDialog = new AboutDialog(MainFrame.getInstance());
		aboutDialog.setVisible(true);
	}
}
