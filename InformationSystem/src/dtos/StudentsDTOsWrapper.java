package dtos;

import java.util.ArrayList;

public class StudentsDTOsWrapper {
	private ArrayList<StudentDTO> studentsDTOs;
	
	public StudentsDTOsWrapper() {}
	
	public StudentsDTOsWrapper(ArrayList<StudentDTO> studentsDTOs) {
		this.studentsDTOs = studentsDTOs;
	}
	
	public ArrayList<StudentDTO> getStudentsDTOs() {
		return studentsDTOs;
	}
	
	public void setStudentsDTOs(ArrayList<StudentDTO> studentsDTOs) {
		this.studentsDTOs = studentsDTOs;
	}
}
