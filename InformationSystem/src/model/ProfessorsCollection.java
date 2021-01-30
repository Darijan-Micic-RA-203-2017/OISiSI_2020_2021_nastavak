package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;

/** REFERENCA: Materijali za vežbe (v6 -> JTableMVCSimple -> model -> BazaIgraca.java) */
public class ProfessorsCollection {
	private static ProfessorsCollection instance = null;
	
	public static ProfessorsCollection getInstance() {
		if (instance == null) {
			instance = new ProfessorsCollection();
		}
		
		return instance;
	}
	
	private ArrayList<Professor> professors;
	private ArrayList<String> columns;
	
	private ProfessorsCollection() {
		//initProfessors();
		
		columns = new ArrayList<String>();
		columns.add("Ime");
		columns.add("Prezime");
		columns.add("Titula");
		columns.add("Zvanje");
	}
	
	/*
	private void initProfessors() {
		professors = new ArrayList<Professor>();
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy.");
		
		String dateOfBirth1StringRepresentation = "01.08.1970.";
		String dateOfBirth2StringRepresentation = "11.04.1960.";
		String dateOfBirth3StringRepresentation = "10.12.1987.";
		Date dateOfBirth1 = null;
		Date dateOfBirth2 = null;
		Date dateOfBirth3 = null;
		try {
			dateOfBirth1 = simpleDateFormat.parse(dateOfBirth1StringRepresentation);
			dateOfBirth2 = simpleDateFormat.parse(dateOfBirth2StringRepresentation);
			dateOfBirth3 = simpleDateFormat.parse(dateOfBirth3StringRepresentation);
		} catch(ParseException pE) {
			pE.printStackTrace();
		}
		professors.add(new Professor("Ban","Ivo", dateOfBirth1,
				"Nikole Tesle 13,Zrenjanin","064/200-0163","ivoban@gmail.com",
				"Slavka Rodića 25,Zrenjanin","080119700",TitleOfProfessor.BSC,CallingOfProfessor.VANREDNI_PROFESOR,new ArrayList<Subject>()));
		professors.add(new Professor("Oroz","Savo", dateOfBirth2,
				"Marije Bursać 43,Zrenjanin","065/206-0813","ssavo_oroz@gmail.com",
				"Slavka Rodića 25,Zrenjanin","041119600",TitleOfProfessor.MSC,CallingOfProfessor.REDOVNI_PROFESOR,new ArrayList<Subject>()));
		professors.add(new Professor("Kraljević","Ana",dateOfBirth3,
				"Aradački atari BB,Zrenjanin","068/7834-253","kraljvicana@gmail.com",
				"Bulevar Evrope 46,Novi Sad","101219870",TitleOfProfessor.DR,CallingOfProfessor.ASISTENT_SA_DOKTORATOM,new ArrayList<Subject>()));
	}
	*/
	
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
			return professor.getTitle().toString();
		case 3:
			return professor.getCalling().toString();
		default:
			return null;
		}
	}
	
	public void addProfessor(String lastName, String firstName, Date dateOfBirth,
			String residence, String contactPhone, String emailAddress, String officeAddress,
			String id, TitleOfProfessor title, CallingOfProfessor calling) {
		Professor newProfessor = new Professor(lastName, firstName, dateOfBirth, residence,
				contactPhone, emailAddress, officeAddress, id, title, calling, new ArrayList<Subject>());
		professors.add(newProfessor);
	}
	
	public void deleteProfessor(String nationalId) {
		for (Professor p : professors) {
			if (p.getNationalID().equals(nationalId)) {
				professors.remove(p);
				break;
			}
		}
	}
	
	public void editProfessorNonSubjectsData(String oldNationalId, String lastName, 
			String firstName, Date dateOfBirth, String residence, String contactPhone, 
			String emailAddress, String officeAddress, String newNationalId, 
			TitleOfProfessor title, CallingOfProfessor calling) {
		for (Professor p : professors) {
			if (p.getNationalID().equals(oldNationalId)) {
				p.setLastName(lastName);
				p.setFirstName(firstName);
				p.setDateOfBirth(dateOfBirth);
				p.setResidence(residence);
				p.setContactPhone(contactPhone);
				p.setEmailAddress(emailAddress);
				p.setOfficeAddress(officeAddress);
				p.setNationalID(newNationalId);
				p.setTitle(title);
				p.setCalling(calling);
				break;
			}
		}
	}
	
	public void deleteSubjectFromProfessorsRecords(String nationalIdOfProfessor, 
			String subjectId) {
		Professor professor = findByNationalId(nationalIdOfProfessor);
		
		for (Subject s : professor.getTeachingSubjects()) {
			if (s.getId().equals(subjectId)) {
				professor.getTeachingSubjects().remove(s);
				break;
			}
		}
	}
	
	public Professor findByNationalId(String nationalId) {
		Professor professor = null;
		
		for (Professor p : professors) {
			if (p.getNationalID().equals(nationalId)) {
				professor = p;
				break;
			}
		}
		
		return professor;
	}
	
	public boolean nationalIdExists(String nationalId) {
		boolean answer = false;
		
		for (Professor p : professors) {
			if (p.getNationalID().equals(nationalId)) {
				answer = true;
				break;
			}
		}
		
		return answer;
	}
	
	public boolean editedNationalIdMatchesWithExistingNationalId(String currentNationalId,
			String editedNationalId) {
		boolean matchingNationalIdFinding = false;
		
		for (Professor p : professors) {
			if (!p.getNationalID().equals(currentNationalId)) {
				if (p.getNationalID().equals(editedNationalId)) {
					matchingNationalIdFinding = true;
					break;
				}
			}
		}
		
		return matchingNationalIdFinding;
	}
}
