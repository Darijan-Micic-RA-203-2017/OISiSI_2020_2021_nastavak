package model;

import java.util.ArrayList;

public class SubjectsCollection {
	private static SubjectsCollection instance = null;
	
	public static SubjectsCollection getInstance() {
		if(instance == null) {
			instance = new SubjectsCollection();
		}
		
		return instance;
	}
	
	private ArrayList<Subject> subjects;
	private ArrayList<String> columns;
	
	private SubjectsCollection() {
		initSubjects();
		
		columns = new ArrayList<String>();
		columns.add("Šifra predmeta");
		columns.add("Naziv predmeta");
		columns.add("Broj ESPB bodova");
		columns.add("Godina na kojoj se predmet izvodi");
		columns.add("Semestar u kojem se predmet izvodi");
	}
	
	private void initSubjects() {
		subjects = new ArrayList<Subject>();
		
		subjects.add(new Subject("E345","Baze podataka",SemesterOfSubject.ZIMSKI,
				3,new Professor(),6,new ArrayList<Student>(),new ArrayList<Student>()));
		subjects.add(new Subject("E773","Arhitektura računara",SemesterOfSubject.ZIMSKI,
				2,new Professor(),9,new ArrayList<Student>(),new ArrayList<Student>()));
		subjects.add(new Subject("E382","Verovatnoća",SemesterOfSubject.LETNJI,
				2,new Professor(),6,new ArrayList<Student>(),new ArrayList<Student>()));
	}
	
	public ArrayList<Subject> getSubjects(){
		return subjects;
	}
	
	public void setSubjects(ArrayList<Subject> subjects) {
		this.subjects = subjects;
	}
	
	public int getColumnCount() {
		return columns.size();
	}
	
	public String getColumnName(int index) {
		return columns.get(index);
	}
	
	public Subject getRow(int rowIndex) {
		return subjects.get(rowIndex);
	}
	
	public String getValueAt(int row, int column) {
		Subject subject = subjects.get(row);
		
		switch(column) {
		case 0:
			return subject.getId();
		case 1:
			return subject.getName();
		case 2:
			return String.valueOf(subject.getEspb());
		case 3:
			return String.valueOf(subject.getYearOfStudy());
		case 4:
			return subject.getSemester().toString();
		default:
			return null;
		}
	}
	
	public void addSubject(String id, String name, SemesterOfSubject semester,
			int yearOfStudy, int espb) {
		Subject newSubject = new Subject(id, name, semester, yearOfStudy,new Professor(),
				espb, new ArrayList<Student>(), new ArrayList<Student>());
		subjects.add(newSubject);
	}
	
	public void deleteSubject(String id) {
		for(Subject s : subjects) {
			if(s.getId()==id) {
				subjects.remove(s);
				break;
			}
		}
	}
	
	public void editSubjectNonStudentsData(String oldId, String newId, String name, 
			SemesterOfSubject semester, int yearOfStudy, int espb, Professor professor) {
		for (Subject s : subjects) {
			if (s.getId().equals(oldId)) {
				s.setId(newId);
				s.setName(name);
				s.setSemester(semester);
				s.setYearOfStudy(yearOfStudy);
				s.setEspb(espb);
				s.setProfessor(professor);
				break;
			}
		}
	}
	
	public void moveStudentToNonPassedList(String subjectId, String indexNumber) {
		Subject subject = findById(subjectId);
		
		Student nonPassedStudent = null;
		for (Student s : subject.getPassedSubject()) {
			if (s.getIndexNumber().equals(indexNumber)) {
				subject.getPassedSubject().remove(s);
				nonPassedStudent = s;
				break;
			}
		}
		
		subject.getFailedSubject().add(nonPassedStudent);
	}
	
	public Subject findById(String id) {
		Subject subject = null;
		
		for (Subject s : subjects) {
			if (s.getId().equals(id)) {
				subject = s;
				break;
			}
		}
		
		return subject;
	}
	
	public boolean idExists(String id) {
		boolean answer = false;
		for (Subject s : subjects) {
			if (s.getId().equals(id)) {
				answer = true;
				break;
			}
		}
		
		return answer;
	}
	
	public boolean editedIdMatchesWithExistingId(String currentId, String editedId) {
		boolean matchingIdFinding = false;
		for (Subject s : subjects) {
			if (!s.getId().equals(currentId)) {
				if (s.getId().equals(editedId)) {
					matchingIdFinding = true;
					break;
				}
			}
		}
		
		return matchingIdFinding;
	}
}
