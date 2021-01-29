package model;

import java.util.Date;

import dtos.GradeDTO;

public class Grade {
	private long id;
	private Student student;
	private Subject subject;
	private int value;
	private Date dateOfPassing;
	
	public Grade() {}
	
	public Grade(long id, Student student, Subject subject, int value, Date dateOfPassing) {
		this.id = id;
		this.student = student;
		this.subject = subject;
		this.value = value;
		this.dateOfPassing = dateOfPassing;
	}
	
	public Grade(GradeDTO gradeDTO) {
		this.id = gradeDTO.getId();
		this.student = null;
		this.subject = null;
		this.value = gradeDTO.getValue();
		this.dateOfPassing = gradeDTO.getDateOfPassing();
	}
	
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public Student getStudent() {
		return this.student;
	}
	
	public void setStudent(Student student) {
		this.student = student;
	}
	
	public Subject getSubject() {
		return this.subject;
	}
	
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	
	public int getValue() {
		return this.value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Date getDateOfPassing() {
		return this.dateOfPassing;
	}

	public void setDateOfPassing(Date dateOfPassing) {
		this.dateOfPassing = dateOfPassing;
	}
	
	public boolean belongsToStudentWith(String indexNumber) {
		boolean answer = false;
		
		if (student.getIndexNumber().equals(indexNumber)) {
			answer = true;
		}
		
		return answer;
	}
	
	public boolean isAssignedToSubjectWith(String id) {
		boolean answer = false;
		
		if (subject.getId().equals(id)) {
			answer = true;
		}
		
		return answer;
	}
}
