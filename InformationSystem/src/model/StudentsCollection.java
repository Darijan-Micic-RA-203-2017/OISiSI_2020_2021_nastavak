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
		initStudents();

		columns = new ArrayList<String>();
		columns.add("Broj indeksa");
		columns.add("Ime");
		columns.add("Prezime");
		columns.add("Godina studija");
		columns.add("Status");
		columns.add("Prosek");
	}
	
	// Radnje:
	private void initStudents() {
		students = new ArrayList<Student>();
		
		/** REFERENCA: https://www.javatpoint.com/java-string-to-date */
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
				"Dimitrija Tucovića 6, Pančevo", "0614560761", "zarko.miskovic@gmail.com", 
				"ra-45-2018", 2018, 2, StatusOfStudent.B, 0.0, new ArrayList<Grade>(), 
				new ArrayList<Subject>()));
		students.add(new Student("Vitas", "Ilija", dateOfBirth2, 
				"Starca Vujadina 13, Nova Pazova", "0638766452", "ilija_vitas@yahoo.com", 
				"ra-87-2018", 2018, 2, StatusOfStudent.S, 0.0, new ArrayList<Grade>(), 
				new ArrayList<Subject>()));
	}
	
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
}
