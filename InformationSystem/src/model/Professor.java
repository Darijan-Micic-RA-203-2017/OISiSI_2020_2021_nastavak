package model;

import java.time.LocalDate;
import java.util.ArrayList;


enum Titles{
	BSC,
	MSC,
	MR,
	DR,
	PROF
}

enum Callings{
	SARADNIK_U_NASTAVI,
	ASISTENT,
	ASISTENT_SA_DOKTORATOM,
	DOCENT,
	VANDREDNI_PROFESOR,
	REDOVNI_PROFESOR,
	PROFESOR_EMERITUS
}

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
	private Titles title;
	private Callings calling;
	private ArrayList<Subject> teachingSubjects;
	
	public Professor() {}
	
	public Professor(String lastName, String firstName, LocalDate dateOfBirth, String residence, String contactPhone,
			String emailAddress, String officeAddress, int nationalID, Titles title, Callings calling, ArrayList<Subject> teachingSubjects) {
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
	
	public Titles getTitle() {
		return this.title;
	}
	
	public void setTitle(Titles title) {
		this.title = title;
	}
	
	public Callings getCalling() {
		return this.calling;
	}
	
	public void setCalling(Callings calling) {
		this.calling = calling;
	}
	
	public ArrayList<Subject> getTeachingSubjects(){
		return this.teachingSubjects;
	}
	
	public void setTeachingSubjects(ArrayList<Subject> teachingSubjects) {
		this.teachingSubjects = teachingSubjects;
	}
}
