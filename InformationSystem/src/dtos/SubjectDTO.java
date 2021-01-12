package dtos;

import java.util.ArrayList;

import model.SemesterOfSubject;
import model.Student;
import model.Subject;

/** REFERENCA: https://en.wikipedia.org/wiki/Data_transfer_object */
public class SubjectDTO {
	private String id;
	private String name;
	private SemesterOfSubject semester;
	private int yearOfStudy;
	private String nationalIdOfProfessor;
	private int espb;
	private ArrayList<String> passedStudentsIndexNumbers;
	private ArrayList<String> nonPassedStudentsIndexNumbers;
	
	public SubjectDTO() {}
	
	public SubjectDTO(String id, String name, SemesterOfSubject semester, int yearOfStudy, 
			String nationalIdOfProfessor, int espb, 
			ArrayList<String> passedStudentsIndexNumbers, 
			ArrayList<String> nonPassedStudentsIndexNumbers) {
		this.id = id;
		this.name = name;
		this.semester = semester;
		this.yearOfStudy = yearOfStudy;
		this.nationalIdOfProfessor = nationalIdOfProfessor;
		this.espb = espb;
		this.passedStudentsIndexNumbers = passedStudentsIndexNumbers;
		this.nonPassedStudentsIndexNumbers = nonPassedStudentsIndexNumbers;
	}
	
	public SubjectDTO(Subject subject) {
		this.id = subject.getId();
		this.name = subject.getName();
		this.semester = subject.getSemester();
		this.yearOfStudy = subject.getYearOfStudy();
		if (subject.getProfessor() != null) {
			if (subject.getProfessor().getNationalID() != null) {
				this.nationalIdOfProfessor = subject.getProfessor().getNationalID();
			} else {
				this.nationalIdOfProfessor = "";
			}
		} else {
			this.nationalIdOfProfessor = "";
		}
		this.espb = subject.getEspb();
		
		this.passedStudentsIndexNumbers = new ArrayList<String>();
		for (Student s : subject.getPassedSubject()) {
			this.passedStudentsIndexNumbers.add(s.getIndexNumber());
		}
		
		this.nonPassedStudentsIndexNumbers = new ArrayList<String>();
		for (Student s : subject.getFailedSubject()) {
			this.nonPassedStudentsIndexNumbers.add(s.getIndexNumber());
		}
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
	
	public String getNationalIdOfProfessor() {
		return this.nationalIdOfProfessor;
	}
	
	public void setNationalIdOfProfessor(String nationalIdOfProfessor) {
		this.nationalIdOfProfessor = nationalIdOfProfessor;
	}
	
	public int getEspb() {
		return this.espb;
	}
	
	public void setEspb(int espb) {
		this.espb = espb;
	}
	
	public ArrayList<String> getPassedStudentsIndexNumbers(){
		return this.passedStudentsIndexNumbers;
	}
	
	public void setPassedStudentsIndexNumbers(ArrayList<String> passedStudentsIndexNumbers) {
		this.passedStudentsIndexNumbers = passedStudentsIndexNumbers;
	}
	
	public ArrayList<String> getNonPassedStudentsIndexNumbers(){
		return this.nonPassedStudentsIndexNumbers;
	}
	
	public void setNonPassedStudentsIndexNumbers(ArrayList<String> nonPassedStudentsIndexNumbers) {
		this.nonPassedStudentsIndexNumbers = nonPassedStudentsIndexNumbers;
	}
	
	public boolean hasBeenPassedByStudentWith(String indexNumber) {
		boolean answer = false;
		
		for (String s : passedStudentsIndexNumbers) {
			if (s.equals(indexNumber)) {
				answer = true;
				break;
			}
		}
		
		return answer;
	}
	
	public boolean hasNotBeenPassedByStudentWith(String indexNumber) {
		boolean answer = false;
		
		for (String s : nonPassedStudentsIndexNumbers) {
			if (s.equals(indexNumber)) {
				answer = true;
				break;
			}
		}
		
		return answer;
	}
	
	public boolean isThaughtByTeacherWith(String nationalId) {
		boolean answer = false;
		
		if (nationalIdOfProfessor.equals(nationalId)) {
			answer = true;
		}
		
		return answer;
	}
}
