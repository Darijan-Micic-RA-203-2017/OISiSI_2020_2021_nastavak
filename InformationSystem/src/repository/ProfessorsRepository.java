package repository;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;

import dtos.ProfessorDTO;
import dtos.ProfessorsDTOsWrapper;
import model.Professor;

/** REFERENCA: https://tdan.com/a-repository-model-the-object-oriented-design-model/4910 */
public class ProfessorsRepository {
	private String filePath;
	private File file;
	private XStream xStream;
	
	public ProfessorsRepository() {
		StringBuilder filePathBuilder = new StringBuilder("resources");
		filePathBuilder.append(File.separator);
		filePathBuilder.append("professors.xml");
		
		filePath = filePathBuilder.toString();
		
		/** REFERENCA: Materijali za vežbe (v7 -> Serijalizacija.pdf) */
		file = new File(filePath);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException ioe) {
				System.out.println("Nije bilo moguće stvoriti datoteku \"professors.xml\"!");
				ioe.printStackTrace();
			}
		}
		
		/** REFERENCA: Materijali za vežbe (v7 -> Serijalizacija.pdf) */
		xStream = new XStream();
		/** REFERENCA: https://x-stream.github.io/security.html */
		xStream.addPermission(AnyTypePermission.ANY);
		xStream.alias("professorsdtoswrapper", ProfessorsDTOsWrapper.class);
		xStream.alias("professordto", ProfessorDTO.class);
	}
	
	public String getFilePath() {
		return filePath;
	}
	
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	public ProfessorsDTOsWrapper convertToDtosWrapper(ArrayList<Professor> professors) {
		ArrayList<ProfessorDTO> professorsDTOs = new ArrayList<ProfessorDTO>();
		
		ProfessorDTO dto = null;
		for (Professor p : professors) {
			dto = new ProfessorDTO(p);
			professorsDTOs.add(dto);
		}
		
		ProfessorsDTOsWrapper professorsDTOsWrapper = new ProfessorsDTOsWrapper(professorsDTOs);
		return professorsDTOsWrapper;
	}
	
	/** REFERENCA: Materijali za vežbe (v7 -> Serijalizacija.pdf) */
	public ProfessorsDTOsWrapper readFromFile() {
		ProfessorsDTOsWrapper professorsDTOsWrapper = null;
		
		/** REFERENCA: https://stackabuse.com/java-check-if-file-or-directory-is-empty/ */
		if (file.length() > 0) {
			try (FileInputStream fis = new FileInputStream(file);
					BufferedInputStream bis = new BufferedInputStream(fis)) {

				professorsDTOsWrapper = (ProfessorsDTOsWrapper) xStream.fromXML(bis);
			} catch (FileNotFoundException fne) {
				System.out.println("Došlo je do greške prilikom pristupa "
						+ "datoteci \"professors.xml\"!");
				fne.printStackTrace();
			} catch (Exception e) {
				System.out.println("Došlo je do greške!");
				e.printStackTrace();
			}
		}
		
		if (professorsDTOsWrapper == null) {
			professorsDTOsWrapper = new ProfessorsDTOsWrapper(new ArrayList<ProfessorDTO>());
		}
		
		return professorsDTOsWrapper;
	}
}
