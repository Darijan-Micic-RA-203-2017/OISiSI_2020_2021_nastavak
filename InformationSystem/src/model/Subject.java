package model;

import java.util.ArrayList;

import dtos.SubjectDTO;

//na grani subject bez polja koja predstavljaju objekte drugih klasa, oni sa javljaju na grani refactor/subject

public class Subject {

	private String id;
	private String name;
	private SemesterOfSubject semester;
	private int yearOfStudy;
	private Professor professor;
	private int espb;
	private ArrayList<Student> passedSubject;
	private ArrayList<Student> failedSubject;
	
	
	public Subject() {}
	
	public Subject(String id, String name, SemesterOfSubject semester, int yearOfStudy, Professor professor, int espb,
			ArrayList<Student> passedSubject, ArrayList<Student> failedSubject) {
		this.id = id;
		this.name = name;
		this.semester = semester;
		this.yearOfStudy = yearOfStudy;
		this.professor = professor;
		this.espb = espb;
		this.passedSubject = passedSubject;
		this.failedSubject = failedSubject;
	}
	
	public Subject(SubjectDTO subjectDTO) {
		this.id = subjectDTO.getId();
		this.name = subjectDTO.getName();
		this.semester = subjectDTO.getSemester();
		this.yearOfStudy = subjectDTO.getYearOfStudy();
		this.professor = new Professor();
		this.espb = subjectDTO.getEspb();
		this.passedSubject = new ArrayList<Student>();
		this.failedSubject = new ArrayList<Student>();
	}
	
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public SemesterOfSubject getSemester() {
		return this.semester;
	}
	
	public void setSemester(SemesterOfSubject semester) {
		this.semester = semester;
	}
	
	public int getYearOfStudy() {
		return this.yearOfStudy;
	}
	
	public void setYearOfStudy(int yearOfStudy) {
		this.yearOfStudy = yearOfStudy;
	}
	
	public Professor getProfessor() {
		return this.professor;
	}
	
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
	public int getEspb() {
		return this.espb;
	}
	
	public void setEspb(int espb) {
		this.espb = espb;
	}
	
	public ArrayList<Student> getPassedSubject(){
		return this.passedSubject;
	}
	
	public void setPassedSubject(ArrayList<Student> passedSubject) {
		this.passedSubject = passedSubject;
	}
	
	public ArrayList<Student> getFailedSubject(){
		return this.failedSubject;
	}
	
	public void setFailedSubject(ArrayList<Student> failedSubject) {
		this.failedSubject = failedSubject;
	}
	
	public boolean hasBeenPassedByStudentWith(String indexNumber) {
		boolean answer = false;
		
		for (Student s : passedSubject) {
			if (s.getIndexNumber().equals(indexNumber)) {
				answer = true;
				break;
			}
		}
		
		return answer;
	}
	
	public boolean hasNotBeenPassedByStudentWith(String indexNumber) {
		boolean answer = false;
		
		for (Student s : failedSubject) {
			if (s.getIndexNumber().equals(indexNumber)) {
				answer = true;
				break;
			}
		}
		
		return answer;
	}
	
	public boolean isThaughtByTeacherWith(String nationalId) {
		boolean answer = false;
		
		if (professor.getNationalID().equals(nationalId)) {
			answer = true;
		}
		
		return answer;
	}
}
