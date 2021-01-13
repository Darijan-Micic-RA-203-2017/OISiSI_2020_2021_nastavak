package controller;

import java.util.ArrayList;

import dtos.GradeDTO;
import dtos.ProfessorDTO;
import dtos.StudentDTO;
import dtos.SubjectDTO;
import model.Grade;
import model.GradesCollection;
import model.Professor;
import model.ProfessorsCollection;
import model.Student;
import model.StudentsCollection;
import model.Subject;
import model.SubjectsCollection;
import repository.GradesRepository;
import repository.ProfessorsRepository;
import repository.StudentsRepository;
import repository.SubjectsRepository;

/** REFERENCA: Materijali za vežbe (v6 -> JTableMVCSimple -> controller -> IgraciController.java) */
public class EntitiesConnectingAfterReadingController {
	private static EntitiesConnectingAfterReadingController instance = null;
	
	public static EntitiesConnectingAfterReadingController getInstance() {
		if (instance == null) {
			instance = new EntitiesConnectingAfterReadingController();
		}
		
		return instance;
	}
	
	private ArrayList<StudentDTO> unconnectedStudents;
	private ArrayList<ProfessorDTO> unconnectedProfessors;
	private ArrayList<SubjectDTO> unconnectedSubjects;
	private ArrayList<GradeDTO> unconnectedGrades;
	
	private ArrayList<Student> students;
	private ArrayList<Professor> professors;
	private ArrayList<Subject> subjects;
	private ArrayList<Grade> grades;
	
	private EntitiesConnectingAfterReadingController() {
		StudentsRepository studentsRepository = new StudentsRepository();
		unconnectedStudents = studentsRepository.readFromFile().getStudentsDTOs();
		
		ProfessorsRepository professorsRepository = new ProfessorsRepository();
		unconnectedProfessors = professorsRepository.readFromFile().getProfessorsDTOs();
		
		SubjectsRepository subjectsRepository = new SubjectsRepository();
		unconnectedSubjects = subjectsRepository.readFromFile().getSubjectsDTOs();
		
		GradesRepository gradesRepository = new GradesRepository();
		unconnectedGrades = gradesRepository.readFromFile().getGradesDTOs();
		
		convertToEntitiesLists();
		
		connectEntities();
		
		StudentsCollection.getInstance().setStudents(students);
		ProfessorsCollection.getInstance().setProfessors(professors);
		SubjectsCollection.getInstance().setSubjects(subjects);
		GradesCollection.getInstance().setGrades(grades);
	}
	
	public ArrayList<Student> getStudents() {
		return students;
	}
	
	public ArrayList<Professor> getProfessors() {
		return professors;
	}
	
	public ArrayList<Subject> getSubjects() {
		return subjects;
	}
	
	public ArrayList<Grade> getGrades() {
		return grades;
	}
	
	private void convertToEntitiesLists() {
		convertToProfessorsList();
		convertToSubjectsList();
		convertToStudentsList();
		convertToGradesList();
	}
	
	private void convertToProfessorsList() {
		professors = new ArrayList<Professor>();
		
		for (ProfessorDTO pDTO : unconnectedProfessors) {
			Professor professor = new Professor(pDTO);
			professors.add(professor);
		}
	}
	
	private void convertToSubjectsList() {
		subjects = new ArrayList<Subject>();
		
		for (SubjectDTO sDTO : unconnectedSubjects) {
			Subject subject = new Subject(sDTO);
			subjects.add(subject);
		}
	}
	
	private void convertToStudentsList() {
		students = new ArrayList<Student>();
		
		for (StudentDTO sDTO : unconnectedStudents) {
			Student student = new Student(sDTO);
			students.add(student);
		}
	}
	
	private void convertToGradesList() {
		grades = new ArrayList<Grade>();
		
		for (GradeDTO gDTO : unconnectedGrades) {
			Grade grade = new Grade(gDTO);
			grades.add(grade);
		}
	}
	
	private void connectEntities() {
		connectProfessorsWithSubjects();
		connectStudentsWithSubjects();
		connectGradesWithSubjects();
		connectGradesWithStudents();
	}
	
	private void connectProfessorsWithSubjects() {
		setTeachingSubjectsForEachProfessor();
		setProfessorForEachSubject();
	}
	
	private void setTeachingSubjectsForEachProfessor() {
		int outerForLoopIndex = 0;
		for (ProfessorDTO pDTO : unconnectedProfessors) {
			int innerForLoopIndex = 0;
			for (SubjectDTO sDTO : unconnectedSubjects) {
				if (sDTO.isThaughtByTeacherWith(pDTO.getNationalID())) {
					Subject subject = subjects.get(innerForLoopIndex);
					professors.get(outerForLoopIndex).getTeachingSubjects().add(subject);
				}
				
				innerForLoopIndex++;
			}
			
			outerForLoopIndex++;
		}
	}
	
	private void setProfessorForEachSubject() {
		int outerForLoopIndex = 0;
		for (SubjectDTO sDTO : unconnectedSubjects) {
			int innerForLoopIndex = 0;
			for (ProfessorDTO pDTO : unconnectedProfessors) {
				if (pDTO.teachesSubject(sDTO.getId())) {
					Professor professor = professors.get(innerForLoopIndex);
					subjects.get(outerForLoopIndex).setProfessor(professor);
					break;
				}
				
				innerForLoopIndex++;
			}
			
			outerForLoopIndex++;
		}
	}
	
	private void connectStudentsWithSubjects() {
		setNonPassedSubjectsForEachStudent();
		setNonPassedStudentsForEachSubject();
	}
	
	private void setNonPassedSubjectsForEachStudent() {
		int outerForLoopIndex = 0;
		for (StudentDTO stdDTO : unconnectedStudents) {
			int innerForLoopIndex = 0;
			for (SubjectDTO sbjDTO : unconnectedSubjects) {
				if (sbjDTO.hasNotBeenPassedByStudentWith(stdDTO.getIndexNumber())) {
					Subject subject = subjects.get(innerForLoopIndex);
					students.get(outerForLoopIndex).getNonPassedSubjects().add(subject);
				}
				
				innerForLoopIndex++;
			}
			
			outerForLoopIndex++;
		}
	}
	
	private void setNonPassedStudentsForEachSubject() {
		int outerForLoopIndex = 0;
		for (SubjectDTO sbjDTO : unconnectedSubjects) {
			int innerForLoopIndex = 0;
			for (StudentDTO stdDTO : unconnectedStudents) {
				if (stdDTO.hasNotPassedSubject(sbjDTO.getId())) {
					Student student = students.get(innerForLoopIndex);
					subjects.get(outerForLoopIndex).getFailedSubject().add(student);
				}
				
				innerForLoopIndex++;
			}
			
			outerForLoopIndex++;
		}
	}
	
	private void connectGradesWithSubjects() {
		setSubjectForEachGrade();
	}
	
	private void setSubjectForEachGrade() {
		int outerForLoopIndex = 0;
		for (GradeDTO gDTO : unconnectedGrades) {
			int innerForLoopIndex = 0;
			for (SubjectDTO sDTO : unconnectedSubjects) {
				if (gDTO.isAssignedToSubjectWith(sDTO.getId())) {
					Subject subject = subjects.get(innerForLoopIndex);
					grades.get(outerForLoopIndex).setSubject(subject);
					break;
				}
				
				innerForLoopIndex++;
			}
			
			outerForLoopIndex++;
		}
	}
	
	private void connectGradesWithStudents() {
		setStudentForEachGrade();
		setPassedSubjectsForEachStudent();
		setPassedStudentsForEachSubject();
	}
	
	private void setStudentForEachGrade() {
		int outerForLoopIndex = 0;
		for (GradeDTO gDTO : unconnectedGrades) {
			int innerForLoopIndex = 0;
			for (StudentDTO sDTO : unconnectedStudents) {
				if (sDTO.hasPassedSubject(gDTO.getId())) {
					Student student = students.get(innerForLoopIndex);
					grades.get(outerForLoopIndex).setStudent(student);
				}
				
				innerForLoopIndex++;
			}
			
			outerForLoopIndex++;
		}
	}
	
	private void setPassedSubjectsForEachStudent() {
		int outerForLoopIndex = 0;
		for (StudentDTO sDTO : unconnectedStudents) {
			int innerForLoopIndex = 0;
			for (GradeDTO gDTO : unconnectedGrades) {
				if (gDTO.belongsToStudentWith(sDTO.getIndexNumber())) {
					Grade grade = grades.get(innerForLoopIndex);
					students.get(outerForLoopIndex).getPassedSubjects().add(grade);
				}
				
				innerForLoopIndex++;
			}
			
			outerForLoopIndex++;
		}
	}
	
	private void setPassedStudentsForEachSubject() {
		int outerForLoopIndex = 0;
		for (SubjectDTO sbjDTO : unconnectedSubjects) {
			int innerForLoopIndex = 0;
			for (StudentDTO stdDTO : unconnectedStudents) {
				if (sbjDTO.hasBeenPassedByStudentWith(stdDTO.getIndexNumber())) {
					Student student = students.get(innerForLoopIndex);
					subjects.get(outerForLoopIndex).getPassedSubject().add(student);
				}
				
				innerForLoopIndex++;
			}
			
			outerForLoopIndex++;
		}
	}
}
