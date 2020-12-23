package model;

enum Semesters{
	LETNJI,
	ZIMSKI
}

//na grani subject bez polja koja predstavljaju objekte drugih klasa, oni sa javljaju na grani refactor/subject

public class Subject {

	private long id;
	private String name;
	private Semesters semester;
	private int yearOfStudy;
	private int espb;
	
	public Subject() {}
	
	public Subject(long id, String name, Semesters semester, int yearOfStudy, int espb) {
		this.id = id;
		this.name = name;
		this.semester = semester;
		this.yearOfStudy = yearOfStudy;
		this.espb = espb;
	}
	
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Semesters getSemester() {
		return this.semester;
	}
	
	public void setSemester(Semesters semester) {
		this.semester = semester;
	}
	
	public int getYearOfStudy() {
		return this.yearOfStudy;
	}
	
	public void setYearOfStudy(int yearOfStudy) {
		this.yearOfStudy = yearOfStudy;
	}
	
	public int getEspb() {
		return this.espb;
	}
	
	public void setEspb(int espb) {
		this.espb = espb;
	}
	
}
