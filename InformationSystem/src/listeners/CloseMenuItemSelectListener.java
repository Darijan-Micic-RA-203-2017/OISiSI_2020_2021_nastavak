package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import view.MainFrame;

public class CloseMenuItemSelectListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		/** REFERENCA: https://stackoverflow.com/questions/1234912/how-to-programmatically-close-a-jframe */
		WindowEvent mainFrameClosingEvent = 
				new WindowEvent(MainFrame.getInstance(), WindowEvent.WINDOW_CLOSING);
		MainFrame.getInstance().dispatchEvent(mainFrameClosingEvent);
	}
}
