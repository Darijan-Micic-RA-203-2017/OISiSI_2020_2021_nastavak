package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class AboutDialog extends JDialog {
	// Polja:
	private JPanel panel;
	private JLabel applicationVersionLabel;
	private JTextArea applicationShortDescriptionArea;
	private JScrollPane scrollPane;
	
	// Konstruktor:
	public AboutDialog(JFrame parent) {
		super(parent, "O aplikaciji", true);
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		setSize(screenSize.width / 2, screenSize.height / 2);
		setResizable(false);
		setLocationRelativeTo(parent);
		
		setUpPanel();
		
		setUpApplicationVersionLabel();
		panel.add(applicationVersionLabel, BorderLayout.NORTH);
		
		setUpApplicationDescription();
		panel.add(applicationShortDescriptionArea, BorderLayout.SOUTH);
		
		scrollPane = new JScrollPane(panel);
		add(scrollPane);
	}
	
	// Radnje:
	private void setUpPanel() {
		BorderLayout panelBorderLayout = new BorderLayout(0, 10);
		panel = new JPanel(panelBorderLayout);
		
		panel.setBackground(Color.WHITE);
	}
	
	private void setUpApplicationVersionLabel() {
		applicationVersionLabel = new JLabel("Studentska služba 1.0", JLabel.CENTER);
		
		Font font = new Font("Arial", Font.BOLD, 20);
		applicationVersionLabel.setFont(font);
	}
	
	private void setUpApplicationDescription() {
		applicationShortDescriptionArea = new JTextArea();
		
		/** REFERENCA: https://stackoverflow.com/questions/8858584/how-to-wrap-text-in-a-jtextarea */
		applicationShortDescriptionArea.setLineWrap(true);
		applicationShortDescriptionArea.setWrapStyleWord(true);
		
		String desription = "Aplikacija predstavlja informacioni sistem studentske službe " + 
		"Fakulteta tehničkih nauka u Novom Sadu. Kao takva, namenjena je upotrebi od strane " + 
		"referenta studentske službe. Aplikacija je napravljena upotrebom programskog jezika " + 
		"Java, a njena grafičko korisnička sprega (eng. interface) upotrebom biblioteke Swing.\n" + 
		"Aplikacija rukuje sa tri tipa entiteta: student, profesor i predmet.\n\n" + 
		"Autori aplikacije:\n" + 
		"1) Darijan Mićić\n" + 
		"Student 4. godine Fakulteta tehničkih nauka u Novom Sadu, sa brojem indeksa " + 
		"RA 203/2017. Upisan je na studijski program Računarstvo i automatika, odnosno na " + 
		"studijski modul Primenjene računarske nauke i informatika.\n" + 
		"2) Ognjen Srdić\n" + 
		"Student 3. godine Fakulteta tehničkih nauka u Novom Sadu, sa brojem indeksa " + 
		"RA 46/2018. Upisan je na studijski program Računarstvo i automatika, odnosno na " + 
		"studijski modul Primenjene računarske nauke i informatika.";
		
		applicationShortDescriptionArea.setText(desription);
		Font font = new Font("Arial", Font.PLAIN, 14);
		applicationShortDescriptionArea.setFont(font);
		
		applicationShortDescriptionArea.setEditable(false);
	}
}
