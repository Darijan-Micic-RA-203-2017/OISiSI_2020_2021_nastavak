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

public class HelpDialog extends JDialog {
	// Polja:
	private JPanel panel;
	private JLabel applicationNameLabel;
	private JTextArea workDescriptionArea;
	private JScrollPane scrollPane;
	
	// Konstruktor:
	public HelpDialog(JFrame parent) {
		super(parent, "Način korišćenja aplikacije", true);
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		setSize(screenSize.width / 2, screenSize.height / 2);
		setResizable(false);
		setLocationRelativeTo(parent);
		
		setUpPanel();
		
		setUpApplicationNameLabel();
		panel.add(applicationNameLabel, BorderLayout.NORTH);
		
		setUpAplicationDescription();
		panel.add(workDescriptionArea, BorderLayout.SOUTH);
		
		scrollPane = new JScrollPane(panel);
		add(scrollPane);
	}
	
	// Radnje:
	private void setUpPanel() {
		BorderLayout panelBorderLayout = new BorderLayout(0, 10);
		panel = new JPanel(panelBorderLayout);
		
		panel.setBackground(Color.WHITE);
	}
	
	private void setUpApplicationNameLabel() {
		applicationNameLabel = new JLabel("Studentska služba", JLabel.CENTER);
		
		Font font = new Font("Arial", Font.BOLD, 20);
		applicationNameLabel.setFont(font);
	}
	
	private void setUpAplicationDescription() {
		workDescriptionArea = new JTextArea();
		
		/** REFERENCA: https://stackoverflow.com/questions/8858584/how-to-wrap-text-in-a-jtextarea */
		workDescriptionArea.setLineWrap(true);
		workDescriptionArea.setWrapStyleWord(true);
		
		String applicationUsageDescription = "Glavni prozor aplikacije sadrži sledeće " + 
		"komponente:\n" + 
		"1) Traka sa menijima\n" + 
		"  Sadrži sledeće menije:\n" + 
		"  a) File (mnemonik Alt + F), sa stavkama:\n" + 
		"    New (mnemonik Alt + N, prečica Ctrl + N)\n" + 
		"    Close (mnemonik Alt + C, prečica Ctrl + C)\n" + 
		"  b) Edit (mnemonik Alt + E), sa stavkama:\n" + 
		"    Edit (mnemonik Alt + I, prečica Ctrl + E)\n" + 
		"    Delete (mnemonik Alt + D, prečica Ctrl + D)\n" + 
		"  c) Help (mnemonik Alt + H), sa stavkama:\n" + 
		"    Help (mnemonik Alt + L, prečica Ctrl + H)\n" + 
		"    About (mnemonik Alt + A, prečica Ctrl + B)\n" + 
		"2) Traka sa alatkama\n" + 
		"  Sadrži sledeće stavke:\n" + 
		"    a) Dugme za dodavanje novog entiteta\n" + 
		"    b) Dugme za izmenu označenog postojećeg entiteta\n" + 
		"    c) Dugme za brisanje označenog postojećeg entiteta\n" + 
		"    č) Polje za unos kriterijuma pretrage entiteta\n" + 
		"    ć) Dugme za pretragu entiteta po unetom kriterijumu pretrage\n" + 
		"3) Središnji panel\n" + 
		"4) Statusna traka\n" + 
		"  Sadrži dve labele. U levoj je prikazan naziv aplikacije, a u desnoj trenutno " + 
		"vreme i datum.\n\n\n" + 
		"Aplikacija \"Studentska služba\" rukuje sa 4 tipa entiteta: student, profesor, "
		+ "predmet i ocena. Pokretanjem aplikacije, vrši se proces učitavanja svih entiteta iz "
		+ "XML datoteka u podimeniku \"resouces\" korenskog imenika projekta. Entiteti se "
		+ "čuvaju u datotekama čije ime jasno govori kog su tipa. Čitanje se vrši upotrebom "
		+ "spoljne biblioteke XStream i biblioteka od kojih ona zavisi. Spoljne biblioteke "
		+ "smeštene su u podimeniku \"lib\" korenskog imenika projekta. Nakon što se završi "
		+ "učitavanje lista nepovezanih DTO (eng. Data Transfer Object) predstava entiteta, "
		+ "vrši se njihovo međusobno spajanje na osnovu zajedničkih vrednosti polja. Nakon što "
		+ "se završi spajanje, popunjavaju se spiskovi entiteta. Korisniku se na središnjem "
		+ "panelu prikazuje tabela svih unetih studenata, u kartici \"Studenti\". Klikom na "
		+ "karticu \"Profesori\" ili na karticu \"Predmeti\", može se promeniti prikaz. Tada "
		+ "biva prikazana tabela svih unetih profesora, odnosno predmeta.\n\n\n" + 
		"Odabirom stavke New u meniju File, ili klikom na dugme New u traci sa alatkama, " + 
		"ili preko gore navedenih prečica, otvara se dijalog za unos podataka o novom entitetu "
		+ "u trenutno odabranu tabelu entiteta (studenti, profesori ili predmeti). Podaci "
		+ "moraju biti uneti u ispravnom obliku kako bi dugme \"Potvrdi\" bilo omogućeno. "
		+ "Klikom na dugme \"Potvrdi\", nakon što su uneti podaci u ispravnom obliku, zatvara "
		+ "se dijalog, entitet se dodaje u odgovarajući spisak i osvežava se tabela kako bi se "
		+ "prikazao dodati entitet. U svakom trenutku, moguće je napustiti dijalog za "
		+ "dodavanje entiteta klikom na dugme \"Odustani\".\n\n\n" + 
		"Odabirom stavke Edit u meniju Edit, ili klikom na dugme Edit u traci sa alatkama, " + 
		"ili preko gore navedenih prečica, otvara se dijalog za izmenu podataka trenutno "
		+ "odabranog entiteta u tabeli koja je prikazana.\n\n"
		+ "Dijalog za izmenu studenta sadrži tri kartice: \"Informacije\", \"Položeni\" i "
		+ "\"Nepoloženi\". U kartici \"Informacije\" moguće je izmeniti osnovne podatke "
		+ "studenta. Primenjuju se iste provere ispravnosti kao kod dijaloga za dodavanje "
		+ "studenta, s dodatnom proverom da li se izmenjeni broj indeksa poklapa sa brojem "
		+ "indeksa nekog drugog studenata. Klikom na dugme \"Potvrdi\" pokreće se isti "
		+ "redosled radnji kao kod dodavanja novog studenta. U kartici \"Položeni\" "
		+ "prikazana je tabela položenih predmeta odabranog studenta, njegova prosečna ocena "
		+ "i ukupan broj stečenih ESPB bodova. Nakon što se odabere jedan od položenh "
		+ "predmeta, klik na dugme \"Poništi ocenu\" neće otvoriti dijalog koji upozorava "
		+ "korisnika da poništavanje ne može biti izvršeno jer nije odabran predmet. "
		+ "Umesto toga, otvara se dijalog koji korisnika pita da li zaista želi da poništi "
		+ "ocenu. Ako je odabrana mogućnost \"Da\", predmet se uklanja iz liste položenih "
		+ "predmeta studenta i osvežavaju se donje dve labele tako da prikazuju nove "
		+ "vrednosti prosečne ocene i ukupnog broja stečenih ESPB bodova. U kartici "
		+ "\"Nepoloženi\" prikazana je tabela nepoloženih predmeta odabranog studenta. "
		+ "Nije omogućeno izvršavanje funkcionalnosti nakon klika na neko od dugmadi "
		+ "\"Dodaj\", \"Obriši\" i \"Polaganje\".\n\n" + 
		"Dijalog za izmenu profesora sadrži dve kartice: \"Info\" i \"Predmeti\". U kartici "
		+ "\"Info\" moguće je izmeniti osnovne podatke profesora. Primenjuju se iste provere "
		+ "ispravnosti kao kod dijaloga za dodavanje profesora, s dodatnom proverom da li "
		+ "se izmenjeni broj lične karte poklapa sa brojem lične karte nekog drugog profesora. "
		+ "Klikom na dugme \"Potvrdi\" pokreće se isti redosled radnji kao kod dodavanja novog "
		+ "profesora. U kartici \"Predmeti\" prikazana je tabela predmeta koje predaje "
		+ "odabrani profesor. Nije omogućeno izvršavanje funkcionalnosti nakon klika na neko "
		+ "od dugmad \"Dodaj predmet\" i \"Ukloni predmet\".\n\n"
		+ "Dijalog za izmenu predmeta ima isti sadržaj kao i dijalog za dodavanje novog "
		+ "predmeta. Vrši se dodatna provera da li se izmenjena šifra poklapa sa šifrom "
		+ "nekog drugog predmeta. Klikom na dugme \"Potvrdi\" pokreće se isti redosled radnji "
		+ "kao kod dodavanja novog predmeta. Nije omogućeno izvršavanje funkcionalnosti nakon "
		+ "klika na neko od dugmadi: \"+\" za dodavanje profesora i \"-\" za uklanjanje "
		+ "postojećeg profesora.\n\n\n"
		+ "Odabirom stavke Delete u meniju Edit, ili klikom na dugme Delete u traci sa " + 
		"alatkama, treba da se otvori dijalog koji pita korisnika da li je siguran da želi " + 
		"da obriše trenutno izabran entitet. Ta funkcionalnost nije napravljena.\n\n\n" + 
		"Klikom na dugme Find u traci sa alatkama, treba da se osveži trenutno odabrana " + 
		"tabela entiteta, tako da budu prikazani entiteti koji zadovoljavaju uneti "
		+ "kriterijum pretrage, u polju za unos levo od dugmeta Find. Ova funkcionalnost nije "
		+ "napravljena.\n\n\n" + 
		"Odabirom stavke Close u meniju File, ili preko gore navedenih prečica, pokreće se "
		+ "pisanje entiteta u 4 XML datoteke - grades.xml, professors.xml, students.xml i "
		+ "subjects.xml. Datoteke se nalaze u podimeniku \"resources\" korenskog imenika "
		+ "projekta. Nakon što se pisanje završi, aplikacija se zatvara.\n\n\n" + 
		"Odabirom stavke Help u meniju Help, otvara se dijalog sa ovim uputstvom o načinu " + 
		"korišćenja aplikacije.\n\n" + 
		"Odabirom stavke About u meniju Help, otvara se dijalog u kom je prikazano izdanje " + 
		"aplikacije, kratak opis aplikacije i sažeta biografija svakog autora.";
		
		workDescriptionArea.setText(applicationUsageDescription);
		Font font = new Font("Arial", Font.PLAIN, 14);
		workDescriptionArea.setFont(font);
		
		workDescriptionArea.setEditable(false);
	}
}
