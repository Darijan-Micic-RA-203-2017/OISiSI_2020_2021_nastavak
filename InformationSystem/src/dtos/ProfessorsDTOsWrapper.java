package dtos;

import java.util.ArrayList;

public class ProfessorsDTOsWrapper {
	private ArrayList<ProfessorDTO> professorsDTOs;
	
	public ProfessorsDTOsWrapper() {}
	
	public ProfessorsDTOsWrapper(ArrayList<ProfessorDTO> professorsDTOs) {
		this.professorsDTOs = professorsDTOs;
	}
	
	public ArrayList<ProfessorDTO> getProfessorsDTOs() {
		return professorsDTOs;
	}
	
	public void setProfessorsDTOs(ArrayList<ProfessorDTO> professorsDTOs) {
		this.professorsDTOs = professorsDTOs;
	}
}
