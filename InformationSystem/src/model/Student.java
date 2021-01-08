package model;

import java.util.ArrayList;
import java.util.Date;

public class Student {
	// Polja:
	private String lastName;
	private String firstName;
	private Date dateOfBirth;
	private String residence;
	private String contactPhone;
	private String emailAddress;
	private String indexNumber;
	private int yearOfEnrollment;
	private int currentYearOfStudy;
	private StatusOfStudent statusOfStudent;
	private double averageGrade;
	private ArrayList<Grade> passedSubjects;
	private ArrayList<Subject> nonPassedSubjects;
	
	// Konstruktori:
	public Student() {}
	
	public Student(String lastName, String firstName, Date dateOfBirth, String residence, 
			String contactPhone, String emailAddress, String indexNumber, int yearOfEnrollment, 
			int currentYearOfStudy, StatusOfStudent statusOfStudent, double averageGrade, 
			ArrayList<Grade> passedSubjects, ArrayList<Subject> nonPassedSubjects) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.dateOfBirth = dateOfBirth;
		this.residence = residence;
		this.contactPhone = contactPhone;
		this.emailAddress = emailAddress;
		this.indexNumber = indexNumber;
		this.yearOfEnrollment = yearOfEnrollment;
		this.currentYearOfStudy = currentYearOfStudy;
		this.statusOfStudent = statusOfStudent;
		this.averageGrade = averageGrade;
		this.passedSubjects = passedSubjects;
		this.nonPassedSubjects = nonPassedSubjects;
	}
	
	// Dobavljačke i postavljačke radnje:
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

	public String getIndexNumber() {
		return this.indexNumber;
	}

	public void setIndexNumber(String indexNumber) {
		this.indexNumber = indexNumber;
	}

	public int getYearOfEnrollment() {
		return this.yearOfEnrollment;
	}

	public void setYearOfEnrollment(int yearOfEnrollment) {
		this.yearOfEnrollment = yearOfEnrollment;
	}

	public int getCurrentYearOfStudy() {
		return this.currentYearOfStudy;
	}

	public void setCurrentYearOfStudy(int currentYearOfStudy) {
		this.currentYearOfStudy = currentYearOfStudy;
	}

	public StatusOfStudent getStatusOfStudent() {
		return this.statusOfStudent;
	}

	public void setStatusOfStudent(StatusOfStudent statusOfStudent) {
		this.statusOfStudent = statusOfStudent;
	}

	public double getAverageGrade() {
		return this.averageGrade;
	}

	public void setAverageGrade(double averageGrade) {
		this.averageGrade = averageGrade;
	}
	
	public ArrayList<Grade> getPassedSubjects() {
		return this.passedSubjects;
	}

	public void setPassedSubjects(ArrayList<Grade> passedSubjects) {
		this.passedSubjects = passedSubjects;
	}
	
	public ArrayList<Subject> getNonPassedSubjects() {
		return this.nonPassedSubjects;
	}

	public void setNonPassedSubjects(ArrayList<Subject> nonPassedSubjects) {
		this.nonPassedSubjects = nonPassedSubjects;
	}
	
	public double calculateNewAverageGrade() {
		int gradeValuesSum = 0;
		for (Grade g : passedSubjects) {
			gradeValuesSum += g.getValue();
		}
		
		double newAverageGrade = gradeValuesSum * 1.0 / passedSubjects.size();
		
		return newAverageGrade;
	}
	
	public int getTotalEspb() {
		int totalEspb = 0;
		for (Grade g : passedSubjects) {
			totalEspb += g.getSubject().getEspb();
		}
		
		return totalEspb;
	}
}
