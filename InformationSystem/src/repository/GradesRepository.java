package repository;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;

import dtos.GradeDTO;
import dtos.GradesDTOsWrapper;
import model.Grade;

/** REFERENCA: https://tdan.com/a-repository-model-the-object-oriented-design-model/4910 */
public class GradesRepository {
	private String filePath;
	private File file;
	private XStream xStream;
	
	public GradesRepository() {
		StringBuilder filePathBuilder = new StringBuilder("resources");
		filePathBuilder.append(File.separator);
		filePathBuilder.append("grades.xml");
		
		filePath = filePathBuilder.toString();
		
		/** REFERENCA: Materijali za vežbe (v7 -> Serijalizacija.pdf) */
		file = new File(filePath);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException ioe) {
				System.out.println("Nije bilo moguće stvoriti datoteku \"grades.xml\"!");
				ioe.printStackTrace();
			}
		}
		
		/** REFERENCA: Materijali za vežbe (v7 -> Serijalizacija.pdf) */
		xStream = new XStream();
		/** REFERENCA: https://x-stream.github.io/security.html */
		xStream.addPermission(AnyTypePermission.ANY);
		xStream.alias("gradesdtoswrapper", GradesDTOsWrapper.class);
		xStream.alias("gradedto", GradeDTO.class);
	}
	
	public String getFilePath() {
		return filePath;
	}
	
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	public GradesDTOsWrapper convertToDtosWrapper(ArrayList<Grade> grades) {
		ArrayList<GradeDTO> gradesDTOs = new ArrayList<GradeDTO>();
		
		GradeDTO dto = null;
		for (Grade g : grades) {
			dto = new GradeDTO(g);
			gradesDTOs.add(dto);
		}
		
		GradesDTOsWrapper gradesDTOsWrapper = new GradesDTOsWrapper(gradesDTOs);
		return gradesDTOsWrapper;
	}
	
	/** REFERENCA: Materijali za vežbe (v7 -> Serijalizacija.pdf) */
	public GradesDTOsWrapper readFromFile() {
		GradesDTOsWrapper gradesDTOsWrapper = null;
		
		/** REFERENCA: https://stackabuse.com/java-check-if-file-or-directory-is-empty/ */
		if (file.length() > 0) {
			try (FileInputStream fis = new FileInputStream(file);
					BufferedInputStream bis = new BufferedInputStream(fis)) {

				gradesDTOsWrapper = (GradesDTOsWrapper) xStream.fromXML(bis);
			} catch (FileNotFoundException fne) {
				System.out.println("Došlo je do greške prilikom pristupa "
						+ "datoteci \"grades.xml\"!");
				fne.printStackTrace();
			} catch (Exception e) {
				System.out.println("Došlo je do greške!");
				e.printStackTrace();
			}
		}
		
		if (gradesDTOsWrapper == null) {
			gradesDTOsWrapper = new GradesDTOsWrapper(new ArrayList<GradeDTO>());
		}
		
		return gradesDTOsWrapper;
	}
}
