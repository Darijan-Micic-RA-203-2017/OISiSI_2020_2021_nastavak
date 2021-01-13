package repository;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;

import dtos.SubjectDTO;
import dtos.SubjectsDTOsWrapper;
import model.Subject;

/** REFERENCA: https://tdan.com/a-repository-model-the-object-oriented-design-model/4910 */
public class SubjectsRepository {
	private String filePath;
	private File file;
	private XStream xStream;
	
	public SubjectsRepository() {
		StringBuilder filePathBuilder = new StringBuilder("resources");
		filePathBuilder.append(File.separator);
		filePathBuilder.append("subjects.xml");
		
		filePath = filePathBuilder.toString();
		
		/** REFERENCA: Materijali za vežbe (v7 -> Serijalizacija.pdf) */
		file = new File(filePath);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException ioe) {
				System.out.println("Nije bilo moguće stvoriti datoteku \"subjects.xml\"!");
				ioe.printStackTrace();
			}
		}
		
		/** REFERENCA: Materijali za vežbe (v7 -> Serijalizacija.pdf) */
		xStream = new XStream();
		/** REFERENCA: https://x-stream.github.io/security.html */
		xStream.addPermission(AnyTypePermission.ANY);
		xStream.alias("subjectsdtoswrapper", SubjectsDTOsWrapper.class);
		xStream.alias("subjectdto", SubjectDTO.class);
	}
	
	public String getFilePath() {
		return filePath;
	}
	
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	public SubjectsDTOsWrapper convertToDtosWrapper(ArrayList<Subject> subjects) {
		ArrayList<SubjectDTO> subjectsDTOs = new ArrayList<SubjectDTO>();
		
		SubjectDTO dto = null;
		for (Subject s : subjects) {
			dto = new SubjectDTO(s);
			subjectsDTOs.add(dto);
		}
		
		SubjectsDTOsWrapper subjectsDTOsWrapper = new SubjectsDTOsWrapper(subjectsDTOs);
		return subjectsDTOsWrapper;
	}
	
	/** REFERENCA: Materijali za vežbe (v7 -> Serijalizacija.pdf) */
	public SubjectsDTOsWrapper readFromFile() {
		SubjectsDTOsWrapper subjectsDTOsWrapper = null;
		
		try (FileInputStream fis = new FileInputStream(file);
				BufferedInputStream bis = new BufferedInputStream(fis)) {
			
			subjectsDTOsWrapper = (SubjectsDTOsWrapper) xStream.fromXML(bis);
		} catch (FileNotFoundException fne) {
			System.out.println("Došlo je do greške prilikom pristupa "
					+ "datoteci \"subjects.xml\"!");
			fne.printStackTrace();
		} catch (Exception e) {
			System.out.println("Došlo je do greške!");
			e.printStackTrace();
		}
		
		if (subjectsDTOsWrapper == null) {
			subjectsDTOsWrapper = new SubjectsDTOsWrapper(new ArrayList<SubjectDTO>());
		}
		
		return subjectsDTOsWrapper;
	}
}
