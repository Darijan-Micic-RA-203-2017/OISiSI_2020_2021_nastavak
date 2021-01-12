package dtos;

import java.util.ArrayList;
import java.util.Date;

import model.CallingOfProfessor;
import model.Professor;
import model.Subject;
import model.TitleOfProfessor;

/** REFERENCA: https://en.wikipedia.org/wiki/Data_transfer_object */
public class ProfessorDTO {
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
	private ArrayList<String> teachingSubjectsIds;
	
	public ProfessorDTO() {}
	
	public ProfessorDTO(String lastName, String firstName, Date dateOfBirth, String residence, 
			String contactPhone, String emailAddress, String officeAddress, String nationalID, 
			TitleOfProfessor title, CallingOfProfessor calling, 
			ArrayList<String> teachingSubjectsIds) {
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
		this.teachingSubjectsIds = teachingSubjectsIds;
	}
	
	public ProfessorDTO(Professor professor) {
		this.lastName = professor.getLastName();
		this.firstName = professor.getLastName();
		this.dateOfBirth = professor.getDateOfBirth();
		this.residence = professor.getResidence();
		this.contactPhone = professor.getContactPhone();
		this.emailAddress = professor.getEmailAddress();
		this.officeAddress = professor.getOfficeAddress();
		this.nationalID = professor.getNationalID();
		this.title = professor.getTitle();
		this.calling = professor.getCalling();
		
		this.teachingSubjectsIds = new ArrayList<String>();
		for (Subject s : professor.getTeachingSubjects()) {
			this.teachingSubjectsIds.add(s.getId());
		}
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
	
	public ArrayList<String> getTeachingSubjectsIds(){
		return this.teachingSubjectsIds;
	}
	
	public void setTeachingSubjectsIds(ArrayList<String> teachingSubjectsIds) {
		this.teachingSubjectsIds = teachingSubjectsIds;
	}
	
	public boolean teachesSubject(String idOfSubject) {
		boolean answer = false;
		
		for (String s : teachingSubjectsIds) {
			if (s.equals(idOfSubject)) {
				answer = true;
				break;
			}
		}
		
		return answer;
	}
}
