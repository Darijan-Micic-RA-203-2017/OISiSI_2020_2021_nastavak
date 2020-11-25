package model;

import java.time.LocalDate;

public class Grade {
	// Polja:
	private long id;
	//private Subject subject;
	private int value;
	private LocalDate dateOfPassing;
	
	// Konstruktori:
	public Grade() {}
	
	public Grade(long id, int value, LocalDate dateOfPassing) {
		this.id = id;
		this.value = value;
		this.dateOfPassing = dateOfPassing;
	}
	
	// Dobavljačke i postavljačke radnje:
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	/*
	public Subject getSubject() {
		return subject;
	}
	
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	*/
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public LocalDate getDateOfPassing() {
		return dateOfPassing;
	}

	public void setDateOfPassing(LocalDate dateOfPassing) {
		this.dateOfPassing = dateOfPassing;
	}
}
