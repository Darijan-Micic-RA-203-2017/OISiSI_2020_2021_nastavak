package model;

import java.time.LocalDate;
import java.util.ArrayList;

//na grani professor bez polja koja predstavljaju objekte drugih klasa, oni sa javljaju na grani refactor/professor

public class Professor {

	private String lastName;
	private String firstName;
	private LocalDate dateOfBirth;
	private String residence;
	private String contactPhone;
	private String emailAddress;
	private String officeAddress;
	private int nationalID;
	private TitleOfProfessor title;
	private CallingOfProfessor calling;
	private ArrayList<Subject> teachingSubjects;
	
	public Professor() {}
	
	public Professor(String lastName, String firstName, LocalDate dateOfBirth, String residence, String contactPhone,
			String emailAddress, String officeAddress, int nationalID, TitleOfProfessor title, CallingOfProfessor calling, ArrayList<Subject> teachingSubjects) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.dateOfBirth = dateOfBirth;
		this.residence = residence;
		this.contactPhone = contactPhone;
		this.emailAddress = emailAddress;
		this.officeAddress = officeAddress;
		this.nationalID = nationalID;
		this.title = title;
		this.calling = calling;
		this.teachingSubjects = teachingSubjects;
	}
	
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public LocalDate getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public String getResidence() {
		return this.residence;
	}

	public void setResidence(String residence) {
		this.residence = residence;
	}
	
	public String getContactPhone() {
		return this.contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	
	public String getEmailAddress() {
		return this.emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public String getOfficeAddress() {
		return this.officeAddress;
	}
	
	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}
	
	public int getNationalID() {
		return this.nationalID;
	}
	
	public void setNationalID(int nationalID) {
		this.nationalID = nationalID;
	}
	
	public String getTitle() {
		switch(this.title){
		case BSC:
			return "BSc";
		case MSC:
			return "MSc";
		case MR:
			return "mr";
		case DR:
			return "dr";
		case PROF_DR:
			return "prof. dr";
		default:
			return null;
		}
	}
	
	public void setTitle(TitleOfProfessor title) {
		this.title = title;
	}
	
	public String getCalling() {
		switch(this.calling) {
		case SARADNIK_U_NASTAVI:
			return "saradnik u nastavi";
		case ASISTENT:
			return "asistent";
		case ASISTENT_SA_DOKTORATOM:
			return "asistent sa doktoratom";
		case DOCENT:
			return "docent";
		case VANREDNI_PROFESOR:
			return "vanredni profesor";
		case REDOVNI_PROFESOR:
			return "redovni profesor";
		case PROFESOR_EMERITUS:
			return "profesor emeritus";
		default:
			return null;
		
		}
	}
	
	public void setCalling(CallingOfProfessor calling) {
		this.calling = calling;
	}
	
	public ArrayList<Subject> getTeachingSubjects(){
		return this.teachingSubjects;
	}
	
	public void setTeachingSubjects(ArrayList<Subject> teachingSubjects) {
		this.teachingSubjects = teachingSubjects;
	}
}
