package view;

import java.awt.Color;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StatusBar extends JPanel {
	// Polja:
	private JLabel applicationNameLabel;
	private JLabel currentTimeAndDateLabel;
	
	// Konstruktor:
	public StatusBar() {
		/** REFERENCA: Materijali za vežbe (v3 -> Termin5 - Layout.pdf) */
		BoxLayout boxLayout = new BoxLayout(this, BoxLayout.X_AXIS);
		this.setLayout(boxLayout);
		
		this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
		
		this.applicationNameLabel = new JLabel("Studentska služba");
		this.currentTimeAndDateLabel = new JLabel();
		
		this.add(Box.createHorizontalStrut(5));
		this.add(applicationNameLabel);
		this.add(Box.createGlue());
		this.add(currentTimeAndDateLabel);
		this.add(Box.createHorizontalStrut(5));
		
		setUpCurrentTimeAndDateLabel(this.currentTimeAndDateLabel);
	}
	
	// Radnja:
	/** REFERENCA: https://www.youtube.com/watch?v=tpQAslXjNKU */
	private void setUpCurrentTimeAndDateLabel(JLabel currentTimeAndDateLabel) {
		Thread timeAndDateThread = new Thread() {
			@Override
			public void run() {
				try {
					while (true) {
						DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm dd.MM.yyyy.");
						LocalDateTime currentTimeAndDate = LocalDateTime.now();
						currentTimeAndDateLabel.setText(dtf.format(currentTimeAndDate));
						sleep(1000);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		
		timeAndDateThread.start();
	}
}
