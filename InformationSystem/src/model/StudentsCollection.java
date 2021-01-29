package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/** REFERENCA: Materijali za vežbe (v6 -> JTableMVCSimple -> model -> BazaIgraca.java) */
public class StudentsCollection {
	private static StudentsCollection instance = null;

	public static StudentsCollection getInstance() {
		if (instance == null) {
			instance = new StudentsCollection();
		}
		
		return instance;
	}
	
	private ArrayList<Student> students;
	private ArrayList<String> columns;
	
	// Konstruktor:
	private StudentsCollection() {
		//initStudents();

		columns = new ArrayList<String>();
		columns.add("Broj indeksa");
		columns.add("Ime");
		columns.add("Prezime");
		columns.add("Godina studija");
		columns.add("Status");
		columns.add("Prosek");
	}
	
	/*
	private void initStudents() {
		students = new ArrayList<Student>();
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy.");

		String dateOfBirth1StringRepresentation = "30.12.1999.";
		String dateOfBirth2StringRepresentation = "09.05.1999.";
		Date dateOfBirth1 = null;
		Date dateOfBirth2 = null;
		try {
			dateOfBirth1 = simpleDateFormat.parse(dateOfBirth1StringRepresentation);
			dateOfBirth2 = simpleDateFormat.parse(dateOfBirth2StringRepresentation);
		} catch (ParseException pE) {
			pE.printStackTrace();
		}
		
		students.add(new Student("Mišković", "Žarko", dateOfBirth1, 
				"Dimitrija Tucovića 6, Pančevo", "061/456-0761", "zarko.miskovic@gmail.com", 
				"ra-45-2018", 2018, 2, StatusOfStudent.B, 0.0, new ArrayList<Grade>(), 
				new ArrayList<Subject>()));
		students.add(new Student("Vitas", "Ilija", dateOfBirth2, 
				"Starca Vujadina 13, Nova Pazova", "063/8766-452", "ilija_vitas@yahoo.com", 
				"ra-87-2018", 2018, 2, StatusOfStudent.S, 0.0, new ArrayList<Grade>(), 
				new ArrayList<Subject>()));
	}
	*/
	
	public ArrayList<Student> getStudents() {
		return students;
	}

	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}

	public int getColumnCount() {
		return columns.size();
	}

	public String getColumnName(int index) {
		return columns.get(index);
	}

	public Student getRow(int rowIndex) {
		return students.get(rowIndex);
	}

	public String getValueAt(int row, int column) {
		Student student = students.get(row);
		
		switch (column) {
		case 0:
			return student.getIndexNumber();
		case 1:
			return student.getFirstName();
		case 2:
			return student.getLastName();
		case 3:
			return Integer.toString(student.getCurrentYearOfStudy());
		case 4:
			return student.getStatusOfStudent().toString();
		/** REFERENCA: https://java2blog.com/java-round-double-float-to-2-decimal-places/ */
		case 5:
			return Double.toString(Math.round(student.getAverageGrade() * 100.0) / 100.0);
		default:
			return null;
		}
	}

	public void addStudent(String lastName, String firstName, Date dateOfBirth, 
			String residence, String contactPhone, String emailAddress, String indexNumber, 
			int yearOfEnrollment, int currentYearOfStudy, StatusOfStudent statusOfStudent) {
		Student newStudent = new Student(lastName, firstName, dateOfBirth, residence, 
				contactPhone, emailAddress, indexNumber, yearOfEnrollment, currentYearOfStudy, 
				statusOfStudent, 0.0, new ArrayList<Grade>(), new ArrayList<Subject>());
		students.add(newStudent);
	}

	public void deleteStudent(String indexNumber) {
		for (Student s : students) {
			if (s.getIndexNumber().equals(indexNumber)) {
				students.remove(s);
				break;
			}
		}
	}

	public void editStudentNonGradesData(String oldIndexNumber, String lastName, 
			String firstName, Date dateOfBirth, String residence, String contactPhone, 
			String emailAddress, String newIndexNumber, int yearOfEnrollment, 
			int currentYearOfStudy, StatusOfStudent statusOfStudent) {
		for (Student s : students) {
			if (s.getIndexNumber().equals(oldIndexNumber)) {
				s.setLastName(lastName);
				s.setFirstName(firstName);
				s.setDateOfBirth(dateOfBirth);
				s.setResidence(residence);
				s.setContactPhone(contactPhone);
				s.setEmailAddress(emailAddress);
				s.setIndexNumber(newIndexNumber);
				s.setYearOfEnrollment(yearOfEnrollment);
				s.setCurrentYearOfStudy(currentYearOfStudy);
				s.setStatusOfStudent(statusOfStudent);
				break;
			}
		}
	}
	
	public void deleteSubjectFromStudentsRecords(String subjectId) {
		ArrayList<Student> studentsWhoHavePassedSubject = 
				getStudentsWhoHavePassedSubjectWith(subjectId);
		
		for (Student student : studentsWhoHavePassedSubject) {
			for (Grade grade : student.getPassedSubjects()) {
				if (grade.getSubject().getId().equals(subjectId)) {
					student.getPassedSubjects().remove(grade);
					double newAverageGrade = student.calculateNewAverageGrade();
					student.setAverageGrade(newAverageGrade);
					break;
				}
			}
		}
		
		ArrayList<Student> studentsWhoHaveNotPassedSubject = 
				getStudentsWhoHaveNotPassedSubjectWith(subjectId);
		
		for (Student student : studentsWhoHaveNotPassedSubject) {
			for (Subject subject : student.getNonPassedSubjects()) {
				if (subject.getId().equals(subjectId)) {
					student.getNonPassedSubjects().remove(subject);
					break;
				}
			}
		}
	}
	
	public ArrayList<Student> getStudentsWhoHavePassedSubjectWith(String subjectId) {
		ArrayList<Student> studentsWhoHavePassedSubject = new ArrayList<Student>();
		
		for (Student s : students) {
			if (s.hasPassedSubjectWith(subjectId)) {
				studentsWhoHavePassedSubject.add(s);
			}
		}
		
		return studentsWhoHavePassedSubject;
	}
	
	public ArrayList<Student> getStudentsWhoHaveNotPassedSubjectWith(String subjectId) {
		ArrayList<Student> studentsWhoHaveNotPassedSubject = new ArrayList<Student>();
		
		for (Student s : students) {
			if (s.hasNotPassedSubjectWith(subjectId)) {
				studentsWhoHaveNotPassedSubject.add(s);
			}
		}
		
		return studentsWhoHaveNotPassedSubject;
	}
	
	public void cancelGrade(String indexNumber, long cancelledGradeId) {
		Student student = findByIndexNumber(indexNumber);
		
		Subject nonPassedSubject = null;
		for (Grade g : student.getPassedSubjects()) {
			if (g.getId() == cancelledGradeId) {
				student.getPassedSubjects().remove(g);
				nonPassedSubject = g.getSubject();
				break;
			}
		}
		
		student.getNonPassedSubjects().add(nonPassedSubject);
		
		double newAverageGrade = student.calculateNewAverageGrade();
		student.setAverageGrade(newAverageGrade);
	}
	
	public Student findByIndexNumber(String indexNumber) {
		Student student = null;
		
		for (Student s : students) {
			if (s.getIndexNumber().equals(indexNumber)) {
				student = s;
				break;
			}
		}
		
		return student;
	}
	
	public boolean indexNumberExists(String indexNumber) {
		boolean answer = false;
		for (Student s : students) {
			if (s.getIndexNumber().equals(indexNumber)) {
				answer = true;
				break;
			}
		}
		
		return answer;
	}
	
	public boolean editedIndexNumberMatchesWithExistingIndexNumber(String currentIndexNumber, 
			String editedIndexNumber) {
		boolean matchingIndexNumberFinding = false;
		for (Student s : students) {
			if (!s.getIndexNumber().equals(currentIndexNumber)) {
				if (s.getIndexNumber().equals(editedIndexNumber)) {
					matchingIndexNumberFinding = true;
					break;
				}
			}
		}
		
		return matchingIndexNumberFinding;
	}
}
