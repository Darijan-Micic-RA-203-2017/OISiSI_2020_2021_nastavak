package view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class HelpDialog extends JDialog {
	// Polja:
	private JScrollPane scrollPane;
	private JTextArea workDescriptionArea;
	
	// Konstruktor:
	public HelpDialog(JFrame parent) {
		super(parent, "Način korišćenja aplikacije", true);
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		setSize(screenSize.width / 2, screenSize.height / 2);
		setLocationRelativeTo(parent);
		
		setUpAplicationDescription();
		this.scrollPane = new JScrollPane(this.workDescriptionArea);
		add(this.scrollPane);
	}
	
	// Radnje:
	private void setUpAplicationDescription() {
		this.workDescriptionArea = new JTextArea();
		
		String applicationUsageDescription = "Studentska služba\n\n" + 
		"Glavni prozor aplikacije sadrži sledeće komponente:\n" + 
		"1) Traka sa menijima\n" + 
		"Sadrži sledeće menije:\n" + 
		"a) File (mnemonik Alt + F), sa stavkama:\n" + 
		"New (mnemonik Alt + N, prečica Ctrl + N)\n" + 
		"Close (mnemonik Alt + C, prečica Ctrl + C)\n" + 
		"b) Edit (mnemonik Alt + E), sa stavkama:\n" + 
		"Edit (mnemonik Alt + I, prečica Ctrl + E)\n" + 
		"Delete (mnemonik Alt + D, prečica Ctrl + D)\n" + 
		"c) Help (mnemonik Alt + H), sa stavkama:\n" + 
		"Help (mnemonik Alt + L, prečica Ctrl + H)\n" + 
		"About (mnemonik Alt + A, prečica Ctrl + A)\n" + 
		"2) Traka sa alatkama\n" + 
		"Sadrži sledeće stavke:\n" + 
		"a) Dugme za dodavanje novog entiteta\n" + 
		"b) Dugme za izmenu označenog postojećeg entiteta\n" + 
		"c) Dugme za brisanje označenog postojećeg entiteta\n" + 
		"č) Polje za unos kriterijuma pretrage entiteta\n" + 
		"ć) Dugme za pretragu entiteta po unetom kriterijumu pretrage\n" + 
		"3) Središnji panel\n" + 
		"4) Statusna traka\n\n" + 
		"Sadrži dve labele. U levoj je prikazan naziv aplikacije, a u desnoj trenutno " + 
		"vreme i datum.\n\n" + 
		"Dijalog sa informacijama o načinu korišćenja aplikacije biće naknadno proširen " + 
		"kada budu napravljene dodatne funkcionalnosti.\n" + 
		"Odabirom stavke New u meniju File, ili klikom na dugme New u traci sa alatkama, " + 
		"treba da se otvori dijalog za unos podataka o novom entitetu u trenutno odabranu " + 
		"tabelu entiteta (studenti, profesori ili predmeti).\n" + 
		"Odabirom stavke Edit u meniju Edit, ili klikom na dugme Edit u traci sa alatkama, " + 
		"treba da se otvori dijalog sa podacima o trenutno izabranom entitetu.\n" + 
		"Odabirom stavke Delete u meniju Edit, ili klikom na dugme Delete u traci sa " + 
		"alatkama, treba da se otvori dijalog koji pita korisnika da li je siguran da želi " + 
		"da obriše trenutno izabran entitet.\n" + 
		"Klikom na dugme Find u traci sa alatkama, treba da se osveži trenutno odabrana " + 
		"tabela entiteta. Biće prikazani entiteti koji zadovoljavaju uneti kriterijum " + 
		"pretrage, u polju za unos levo od dugmeta Find.\n" + 
		"Odabirom stavke Close u meniju File, treba da se zatvori aplikacija.\n" + 
		"Odabirom stavke Help u meniju Help, otvara se dijalog sa ovim uputstvom o načinu " + 
		"korišćenja aplikacije.\n" + 
		"Odabirom stavke About u meniju Help, otvara se dijalog u kom je prikazano izdanje " + 
		"aplikacije, kratak opis aplikacije i sažeta biografija svakog autora.";
		
		this.workDescriptionArea.setText(applicationUsageDescription);
		
		this.workDescriptionArea.setEditable(false);
	}
}
