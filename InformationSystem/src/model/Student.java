package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Student {
	// Polja:
	private String lastName;
	private String firstName;
	private LocalDate dateOfBirth;
	private Address residence;
	private String contactPhone;
	private String emailAddress;
	private String indexNumber;
	private int yearOfEnrollment;
	private int currentYearOfStudy;
	private StatusOfStudent statusOfStudent;
	private double averageGrade;
	//private ArrayList<Grade> passedSubjects;
	//private ArrayList<Subject> nonPassedSubjects;
	
	// Konstruktori:
	public Student() {}
	
	public Student(String lastName, String firstName, LocalDate dateOfBirth, Address residence, String contactPhone,
			String emailAddress, String indexNumber, int yearOfEnrollment, int currentYearOfStudy,
			StatusOfStudent statusOfStudent, double averageGrade) {
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
	}
	
	// Dobavljačke i postavljačke radnje:
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Address getResidence() {
		return residence;
	}

	public void setResidence(Address residence) {
		this.residence = residence;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getIndexNumber() {
		return indexNumber;
	}

	public void setIndexNumber(String indexNumber) {
		this.indexNumber = indexNumber;
	}

	public int getYearOfEnrollment() {
		return yearOfEnrollment;
	}

	public void setYearOfEnrollment(int yearOfEnrollment) {
		this.yearOfEnrollment = yearOfEnrollment;
	}

	public int getCurrentYearOfStudy() {
		return currentYearOfStudy;
	}

	public void setCurrentYearOfStudy(int currentYearOfStudy) {
		this.currentYearOfStudy = currentYearOfStudy;
	}

	public StatusOfStudent getStatusOfStudent() {
		return statusOfStudent;
	}

	public void setStatusOfStudent(StatusOfStudent statusOfStudent) {
		this.statusOfStudent = statusOfStudent;
	}

	public double getAverageGrade() {
		return averageGrade;
	}

	public void setAverageGrade(double averageGrade) {
		this.averageGrade = averageGrade;
	}
	
	/*
	public ArrayList<Grade> getPassedSubjects() {
		return passedSubjects;
	}

	public void setPassedSubjects(ArrayList<Grade> passedSubjects) {
		this.passedSubjects = passedSubjects;
	}
	*/
	
	/*
	public ArrayList<Subject> getNonPassedSubjects() {
		return nonPassedSubjects;
	}

	public void setNonPassedSubjects(ArrayList<Subject> nonPassedSubjects) {
		this.nonPassedSubjects = nonPassedSubjects;
	}
	*/
}
