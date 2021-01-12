package dtos;

import java.util.ArrayList;
import java.util.Date;

import model.Grade;
import model.StatusOfStudent;
import model.Student;
import model.Subject;

/** REFERENCA: https://en.wikipedia.org/wiki/Data_transfer_object */
public class StudentDTO {
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
	private ArrayList<Long> passedSubjectsGradesIds;
	private ArrayList<String> nonPassedSubjectsIds;
	
	public StudentDTO() {}
	
	public StudentDTO(String lastName, String firstName, Date dateOfBirth, String residence, 
			String contactPhone, String emailAddress, String indexNumber, int yearOfEnrollment, 
			int currentYearOfStudy, StatusOfStudent statusOfStudent, double averageGrade, 
			ArrayList<Long> passedSubjectsGradesIds, ArrayList<String> nonPassedSubjects) {
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
		this.passedSubjectsGradesIds = passedSubjectsGradesIds;
		this.nonPassedSubjectsIds = nonPassedSubjects;
	}
	
	public StudentDTO(Student student) {
		this.lastName = student.getLastName();
		this.firstName = student.getFirstName();
		this.dateOfBirth = student.getDateOfBirth();
		this.residence = student.getResidence();
		this.contactPhone = student.getContactPhone();
		this.emailAddress = student.getEmailAddress();
		this.indexNumber = student.getIndexNumber();
		this.yearOfEnrollment = student.getYearOfEnrollment();
		this.currentYearOfStudy = student.getCurrentYearOfStudy();
		this.statusOfStudent = student.getStatusOfStudent();
		this.averageGrade = student.getAverageGrade();
		
		this.passedSubjectsGradesIds = new ArrayList<Long>();
		for (Grade g : student.getPassedSubjects()) {
			this.passedSubjectsGradesIds.add(g.getId());
		}
		
		this.nonPassedSubjectsIds = new ArrayList<String>();
		for (Subject s : student.getNonPassedSubjects()) {
			this.nonPassedSubjectsIds.add(s.getId());
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
	
	public ArrayList<Long> getPassedSubjectsGradesIds() {
		return this.passedSubjectsGradesIds;
	}

	public void setPassedSubjectsGradesIds(ArrayList<Long> passedSubjectsGradesIds) {
		this.passedSubjectsGradesIds = passedSubjectsGradesIds;
	}
	
	public ArrayList<String> getNonPassedSubjectsIds() {
		return this.nonPassedSubjectsIds;
	}

	public void setNonPassedSubjectsIds(ArrayList<String> nonPassedSubjectsIds) {
		this.nonPassedSubjectsIds = nonPassedSubjectsIds;
	}
	
	public boolean hasPassedSubject(long idOfGrade) {
		boolean answer = false;
		
		for (Long gradeId : passedSubjectsGradesIds) {
			if (gradeId == idOfGrade) {
				answer = true;
				break;
			}
		}
		
		return answer;
	}
	
	public boolean hasNotPassedSubject(String idOfSubject) {
		boolean answer = false;
		
		for (String id : nonPassedSubjectsIds) {
			if (id.equals(idOfSubject)) {
				answer = true;
				break;
			}
		}
		
		return answer;
	}
}
