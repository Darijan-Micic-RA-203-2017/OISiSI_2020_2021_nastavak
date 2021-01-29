package model;

import java.util.Date;

import dtos.ProfessorDTO;

import java.util.ArrayList;

public class Professor {
	private String lastName;
	private String firstName;
	private Date dateOfBirth;
	private String residence;
	private String contactPhone;
	private String emailAddress;
	private String officeAddress;
	private String nationalID;
	private TitleOfProfessor title;
	private CallingOfProfessor calling;
	private ArrayList<Subject> teachingSubjects;
	
	public Professor() {}
	
	public Professor(String lastName, String firstName, Date dateOfBirth, String residence, 
			String contactPhone, String emailAddress, String officeAddress, String nationalID, 
			TitleOfProfessor title, CallingOfProfessor calling, 
			ArrayList<Subject> teachingSubjects) {
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
	
	public Professor(ProfessorDTO professorDTO) {
		this.lastName = professorDTO.getLastName();
		this.firstName = professorDTO.getFirstName();
		this.dateOfBirth = professorDTO.getDateOfBirth();
		this.residence = professorDTO.getResidence();
		this.contactPhone = professorDTO.getContactPhone();
		this.emailAddress = professorDTO.getEmailAddress();
		this.officeAddress = professorDTO.getOfficeAddress();
		this.nationalID = professorDTO.getNationalID();
		this.title = professorDTO.getTitle();
		this.calling = professorDTO.getCalling();
		this.teachingSubjects = new ArrayList<Subject>();
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

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
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
	
	public String getNationalID() {
		return this.nationalID;
	}
	
	public void setNationalID(String nationalID) {
		this.nationalID = nationalID;
	}
	
	public TitleOfProfessor getTitle() {
		return this.title;
	}
	
	public void setTitle(TitleOfProfessor title) {
		this.title = title;
	}
	
	public CallingOfProfessor getCalling() {
		return this.calling;
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
	
	public boolean teachesSubject(String idOfSubject) {
		boolean answer = false;
		
		for (Subject s : teachingSubjects) {
			if (s.getId().equals(idOfSubject)) {
				answer = true;
				break;
			}
		}
		
		return answer;
	}
}
