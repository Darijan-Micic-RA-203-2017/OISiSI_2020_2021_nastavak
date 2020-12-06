package view;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class AboutDialog extends JDialog {
	// Polja:
	private JScrollPane scrollPane;
	private JTextArea applicationShortDescriptionArea;
	
	// Konstruktor:
	public AboutDialog(JFrame parent) {
		super(parent, "O aplikaciji", true);
		
		setUpApplicationDescription();
		this.scrollPane = new JScrollPane(applicationShortDescriptionArea);
		add(this.scrollPane);
	}
	
	// Radnje:
	private void setUpApplicationDescription() {
		this.applicationShortDescriptionArea = new JTextArea();
		
		String desription = "Studentska služba 1.0\n\n" + 
		"Aplikacija predstavlja informacioni sistem studentske službe Fakulteta tehničkih " + 
		"nauka u Novom Sadu. Kao takva, namenjena je upotrebi od strane referenta " + 
		"studentske službe. Aplikacija je napravljena upotrebom programskog jezika Java, a " + 
		"njena grafičko korisnička sprega (eng. interface) upotrebom biblioteke Swing\n" + 
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
		
		this.applicationShortDescriptionArea.setText(desription);
		
		this.applicationShortDescriptionArea.setEditable(false);
	}
}
