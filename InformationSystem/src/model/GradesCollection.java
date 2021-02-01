package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/** REFERENCA: Materijali za vežbe (v6 -> JTableMVCSimple -> model -> BazaIgraca.java) */
public class GradesCollection {
	private static GradesCollection instance = null;

	public static GradesCollection getInstance() {
		if (instance == null) {
			instance = new GradesCollection();
		}
		
		return instance;
	}
	
	private ArrayList<Grade> grades;
	private ArrayList<String> columns;
	private long currentMaximumId;
	
	// Konstruktor:
	private GradesCollection() {
		//initGrades();

		columns = new ArrayList<String>();
		columns.add("Šifra predmeta");
		columns.add("Naziv predmeta");
		columns.add("Broj indeksa studenta");
		columns.add("ESPB");
		columns.add("Ocena");
		columns.add("Datum");
	}
	
	/*
	private void initGrades() {
		grades = new ArrayList<Grade>();
		
		currentMaximumId = 0;
		
		Student student1 = new Student();
		Student student2 = new Student();
		for (Student s : StudentsCollection.getInstance().getStudents()) {
			if (s.getIndexNumber().equals("ra-45-2018")) {
				student1 = s;
			} else if (s.getIndexNumber().equals("ra-87-2018")) {
				student2 = s;
			}
		}
		
		Subject subject1 = new Subject();
		Subject subject2 = new Subject();
		for (Subject s : SubjectsCollection.getInstance().getSubjects()) {
			if (s.getId().equals("E773")) {
				subject1 = s;
			} else if (s.getId().equals("E382")) {
				subject2 = s;
			}
		}
		
		int value1 = 8;
		int value2 = 9;
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy.");

		String dateOfPassing1InString = "21.01.2020.";
		String dateOfPassing2InString = "23.01.2020.";
		Date dateOfPassing1 = null;
		Date dateOfPassing2 = null;
		try {
			dateOfPassing1 = simpleDateFormat.parse(dateOfPassing1InString);
			dateOfPassing2 = simpleDateFormat.parse(dateOfPassing2InString);
		} catch (ParseException pE) {
			pE.printStackTrace();
		}
		
		Grade grade1 = new Grade(currentMaximumId, student1, subject1, value1, dateOfPassing1);
		grades.add(grade1);
		student1.getPassedSubjects().add(grade1);
		student1.setAverageGrade(student1.calculateNewAverageGrade());
		subject1.getPassedSubject().add(student1);
		currentMaximumId++;
		
		Grade grade2 = new Grade(currentMaximumId, student1, subject2, value2, dateOfPassing2);
		grades.add(grade2);
		student1.getPassedSubjects().add(grade2);
		student1.setAverageGrade(student1.calculateNewAverageGrade());
		subject2.getPassedSubject().add(student1);
		currentMaximumId++;
		
		Grade grade3 = new Grade(currentMaximumId, student2, subject1, value1, dateOfPassing1);
		grades.add(grade3);
		student2.getPassedSubjects().add(grade3);
		student2.setAverageGrade(student2.calculateNewAverageGrade());
		subject1.getPassedSubject().add(student2);
		currentMaximumId++;
		
		Grade grade4 = new Grade(currentMaximumId, student2, subject2, value2, dateOfPassing2);
		grades.add(grade4);
		student2.getPassedSubjects().add(grade4);
		student2.setAverageGrade(student2.calculateNewAverageGrade());
		subject2.getPassedSubject().add(student2);
		currentMaximumId++;
	}
	*/
	
	public ArrayList<Grade> getGrades() {
		return grades;
	}

	public void setGrades(ArrayList<Grade> grades) {
		this.grades = grades;
	}

	public int getColumnCount() {
		return columns.size();
	}

	public String getColumnName(int index) {
		return columns.get(index);
	}

	public Grade getRow(int rowIndex) {
		return grades.get(rowIndex);
	}

	public String getValueAt(int row, int column) {
		Grade grade = grades.get(row);
		
		switch (column) {
		case 0:
			return grade.getSubject().getId();
		case 1:
			return grade.getSubject().getName();
		case 2:
			return grade.getStudent().getIndexNumber();
		case 3:
			return Integer.toString(grade.getSubject().getEspb());
		case 4:
			return Integer.toString(grade.getValue());
		/** REFERENCA: https://www.javatpoint.com/java-date-to-string */
		case 5:
			Date dateOfPassing = grade.getDateOfPassing();
			SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
			return sdf.format(dateOfPassing);
		default:
			return null;
		}
	}

	public void addGrade(Student student, Subject subject, int value, 
			Date dateOfPassing) {
		Grade newGrade = new Grade(currentMaximumId, student, subject, value, dateOfPassing);
		grades.add(newGrade);
		currentMaximumId++;
	}

	public void deleteGrade(long id) {
		for (Grade g : grades) {
			if (g.getId() == id) {
				grades.remove(g);
				break;
			}
		}
	}

	public void editGrade(long oldId, long newId, Student student, Subject subject, int value, 
			Date dateOfPassing) {
		for (Grade g : grades) {
			if (g.getId() == oldId) {
				g.setId(newId);
				g.setStudent(student);
				g.setSubject(subject);
				g.setValue(value);
				g.setDateOfPassing(dateOfPassing);
				break;
			}
		}
	}
	
	public void deleteGradesOfStudent(String indexNumberOfStudent) {
		ArrayList<Grade> gradesOfStudent = getGradesOfStudent(indexNumberOfStudent);
		grades.removeAll(gradesOfStudent);
	}
	
	public void deleteGradesForSubject(String subjectId) {
		ArrayList<Grade> gradesForSubject = getGradesForSubject(subjectId);
		grades.removeAll(gradesForSubject);
	}
	
	public Grade findById(long id) {
		Grade grade = null;
		
		for (Grade g : grades) {
			if (g.getId() == id) {
				grade = g;
				break;
			}
		}
		
		return grade;
	}
	
	public boolean idExists(long id) {
		boolean answer = false;
		for (Grade g : grades) {
			if (g.getId() == id) {
				answer = true;
				break;
			}
		}
		
		return answer;
	}
	
	public boolean editedIdMatchesWithExistingId(long currentId, long editedId) {
		boolean matchingIdFinding = false;
		for (Grade g : grades) {
			if (g.getId() != currentId) {
				if (g.getId() == editedId) {
					matchingIdFinding = true;
					break;
				}
			}
		}
		
		return matchingIdFinding;
	}
	
	public ArrayList<Grade> getGradesOfStudent(String indexNumber) {
		ArrayList<Grade> gradesOfOneStudent = new ArrayList<Grade>();
		
		for (Grade g : grades) {
			if (g.getStudent().getIndexNumber().equals(indexNumber)) {
				gradesOfOneStudent.add(g);
			}
		}
		
		return gradesOfOneStudent;
	}
	
	public ArrayList<Grade> getGradesForSubject(String subjectId) {
		ArrayList<Grade> gradesForOneSubject = new ArrayList<Grade>();
		
		for (Grade g : grades) {
			if (g.getSubject().getId().equals(subjectId)) {
				gradesForOneSubject.add(g);
			}
		}
		
		return gradesForOneSubject;
	}
}
