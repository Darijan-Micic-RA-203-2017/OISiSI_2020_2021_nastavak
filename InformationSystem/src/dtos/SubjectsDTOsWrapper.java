package dtos;

import java.util.ArrayList;

public class SubjectsDTOsWrapper {
	private ArrayList<SubjectDTO> subjectsDTOs;
	
	public SubjectsDTOsWrapper() {}
	
	public SubjectsDTOsWrapper(ArrayList<SubjectDTO> subjectsDTOs) {
		this.subjectsDTOs = subjectsDTOs;
	}
	
	public ArrayList<SubjectDTO> getSubjectsDTOs() {
		return subjectsDTOs;
	}
	
	public void setSubjectsDTOs(ArrayList<SubjectDTO> subjectsDTOs) {
		this.subjectsDTOs = subjectsDTOs;
	}
}
