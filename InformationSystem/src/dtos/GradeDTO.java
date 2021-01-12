package dtos;

import java.util.Date;

import model.Grade;

/** REFERENCA: https://en.wikipedia.org/wiki/Data_transfer_object */
public class GradeDTO {
	private long id;
	private String indexNumberOfStudent;
	private String idOfSubject;
	private int value;
	private Date dateOfPassing;
	
	public GradeDTO() {}
	
	public GradeDTO(long id, String indexNumberOfStudent, String idOfSubject, int value, 
			Date dateOfPassing) {
		this.id = id;
		this.indexNumberOfStudent = indexNumberOfStudent;
		this.idOfSubject = idOfSubject;
		this.value = value;
		this.dateOfPassing = dateOfPassing;
	}
	
	public GradeDTO(Grade grade) {
		this.id = grade.getId();
		if (grade.getStudent() != null) {
			if (grade.getStudent().getIndexNumber() != null) {
				this.indexNumberOfStudent = grade.getStudent().getIndexNumber();
			} else {
				this.indexNumberOfStudent = "";
			}
		} else {
			this.indexNumberOfStudent = "";
		}
		if (grade.getSubject() != null) {
			if (grade.getSubject().getId() != null) {
				this.idOfSubject = grade.getSubject().getId();
			} else {
				this.idOfSubject = "";
			}
		} else {
			this.idOfSubject = "";
		}
		this.value = grade.getValue();
		this.dateOfPassing = grade.getDateOfPassing();
	}
	
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getIndexNumberOfStudent() {
		return this.indexNumberOfStudent;
	}
	
	public void setIndexNumberOfStudent(String indexNumberOfStudent) {
		this.indexNumberOfStudent = indexNumberOfStudent;
	}
	
	public String getIdOfSubject() {
		return this.idOfSubject;
	}
	
	public void setIdOfSubject(String idOfSubject) {
		this.idOfSubject = idOfSubject;
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
		
		if (indexNumberOfStudent.equals(indexNumber)) {
			answer = true;
		}
		
		return answer;
	}
	
	public boolean isAssignedToSubjectWith(String id) {
		boolean answer = false;
		
		if (idOfSubject.equals(id)) {
			answer = true;
		}
		
		return answer;
	}
}
