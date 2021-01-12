package dtos;

import java.util.ArrayList;

public class GradesDTOsWrapper {
	private ArrayList<GradeDTO> gradesDTOs;
	
	public GradesDTOsWrapper() {}
	
	public GradesDTOsWrapper(ArrayList<GradeDTO> gradesDTOs) {
		this.gradesDTOs = gradesDTOs;
	}
	
	public ArrayList<GradeDTO> getGradesDTOs() {
		return gradesDTOs;
	}
	
	public void setGradesDTOs(ArrayList<GradeDTO> gradesDTOs) {
		this.gradesDTOs = gradesDTOs;
	}
}
