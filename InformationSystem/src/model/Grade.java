package model;

import java.util.Date;

public class Grade {
	// Polja:
	private long id;
	private Student student;
	private Subject subject;
	private int value;
	private Date dateOfPassing;
	
	// Konstruktori:
	public Grade() {}
	
	public Grade(long id, Student student, Subject subject, int value, Date dateOfPassing) {
		this.id = id;
		this.student = student;
		this.subject = subject;
		this.value = value;
		this.dateOfPassing = dateOfPassing;
	}
	
	// Dobavljačke i postavljačke radnje:
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
}
