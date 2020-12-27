package model;

import java.time.LocalDate;
import java.util.ArrayList;

/** REFERENCA: Materijali za vežbe (v6 -> JTableMVCSimple -> model -> BazaIgraca.java) */
public class ProfessorsCollection {
	private static ProfessorsCollection instance = null;
	
	public static ProfessorsCollection getInstance() {
		if(instance == null) {
			instance = new ProfessorsCollection();
		}
		
		return instance;
	}
	
	private ArrayList<Professor> professors;
	private ArrayList<String> columns;
	
	private ProfessorsCollection() {
		initProfessors();
		
		columns = new ArrayList<String>();
		columns.add("Ime");
		columns.add("Prezime");
		columns.add("Titula");
		columns.add("Zvanje");
	}
	
	private void initProfessors() {
		professors = new ArrayList<Professor>();
		professors.add(new Professor("Ban","Ivo",LocalDate.of(1970, 1, 8),
				"Nikole Tesle 13,Zrenjanin","0642000163","ivoban@gmail.com",
				"Slavka Rodića 25,Zrenjanin",801970,Titles.BSC,Callings.VANREDNI_PROFESOR,new ArrayList<Subject>()));
		professors.add(new Professor("Oroz","Savo",LocalDate.of(1960, 11, 4),
				"Marije Bursać 43,Zrenjanin","0652060813","ssavo_oroz@gmail.com",
				"Slavka Rodića 25,Zrenjanin",411960,Titles.MSC,Callings.REDOVNI_PROFESOR,new ArrayList<Subject>()));
		professors.add(new Professor("Kraljević","Ana",LocalDate.of(1987, 10, 12),
				"Aradački atari BB,Zrenjanin","068783453","kraljvicana@gmail.com",
				"Bulevar Evrope 46,Novi Sad",801970,Titles.DR,Callings.ASISTENT_SA_DOKTORATOM,new ArrayList<Subject>()));
	}
	
	public ArrayList<Professor> getProfessors(){
		return professors;
	}
	
	public void setProfessors(ArrayList<Professor> professors) {
		this.professors = professors;
	}
	
	public int getColumnCount() {
		return columns.size();
	}
	
	public String getColumnName(int index) {
		return columns.get(index);
	}
	
	public Professor getRow(int rowIndex) {
		return professors.get(rowIndex);
	}
	
	public String getValueAt(int row, int column) {
		Professor professor = professors.get(row);
		
		switch(column) {
		case 0:
			return professor.getFirstName();
		case 1:
			return professor.getLastName();
		case 2:
			return professor.getTitle();
		case 3:
			return professor.getCalling();
		default:
			return null;
		}
	}
	
	public void addProfessor(String lastName, String firstName, LocalDate dateOfBirth,
			String residence, String contactPhone, String emailAddress, String officeAddress,
			int id, Titles title, Callings calling, ArrayList<Subject> teachingSubjects) {
		Professor newProfessor = new Professor(lastName, firstName, dateOfBirth, residence,
				contactPhone, emailAddress, officeAddress, id, title, calling, new ArrayList<Subject>());
		professors.add(newProfessor);
	}
	
	public void deleteProfessor(int id) {
		for(Professor p : professors) {
			if(p.getNationalID()==id) {
				professors.remove(p);
				break;
			}
		}
	}
	
	public void modifyProfessor(String lastName, String firstName, LocalDate dateOfBirth, String residence,
			String contactPhone, String emailAddress, String officeAddress, int id, Titles title, Callings calling) {
		for(Professor p : professors) {
			if(p.getNationalID() == id) {
				p.setLastName(lastName);
				p.setFirstName(firstName);
				p.setDateOfBirth(dateOfBirth);
				p.setResidence(residence);
				p.setContactPhone(contactPhone);
				p.setEmailAddress(emailAddress);
				p.setOfficeAddress(officeAddress);
				p.setNationalID(id);
				p.setTitle(title);
				p.setCalling(calling);
				break;
			}
		}
	}
	
	
	
	
}
