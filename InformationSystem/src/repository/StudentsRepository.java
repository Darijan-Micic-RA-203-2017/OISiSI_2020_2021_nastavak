package repository;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.BufferedOutputStream;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;

import dtos.StudentDTO;
import dtos.StudentsDTOsWrapper;
import model.Student;
import model.StudentsCollection;

/** REFERENCA: https://tdan.com/a-repository-model-the-object-oriented-design-model/4910 */
public class StudentsRepository {
	private String filePath;
	private File file;
	private XStream xStream;
	
	public StudentsRepository() {
		StringBuilder filePathBuilder = new StringBuilder("resources");
		filePathBuilder.append(File.separator);
		filePathBuilder.append("students.xml");
		
		filePath = filePathBuilder.toString();
		
		/** REFERENCA: Materijali za vežbe (v7 -> Serijalizacija.pdf) */
		file = new File(filePath);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException ioe) {
				System.out.println("Nije bilo moguće stvoriti datoteku \"students.xml\"!");
				ioe.printStackTrace();
			}
		}
		
		/** REFERENCA: Materijali za vežbe (v7 -> Serijalizacija.pdf) */
		xStream = new XStream();
		/** REFERENCA: https://x-stream.github.io/security.html */
		xStream.addPermission(AnyTypePermission.ANY);
		xStream.alias("studentsdtoswrapper", StudentsDTOsWrapper.class);
		xStream.alias("studentdto", StudentDTO.class);
	}
	
	public String getFilePath() {
		return filePath;
	}
	
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	public StudentsDTOsWrapper convertToDtosWrapper(ArrayList<Student> students) {
		ArrayList<StudentDTO> studentsDTOs = new ArrayList<StudentDTO>();
		
		StudentDTO dto = null;
		for (Student s : students) {
			dto = new StudentDTO(s);
			studentsDTOs.add(dto);
		}
		
		StudentsDTOsWrapper studentsDTOsWrapper = new StudentsDTOsWrapper(studentsDTOs);
		return studentsDTOsWrapper;
	}
	
	/** REFERENCA: Materijali za vežbe (v7 -> Serijalizacija.pdf) **/
	public void writeToFile() {
		try (FileOutputStream fos = new FileOutputStream(file);
				BufferedOutputStream bos = new BufferedOutputStream(fos)) {
			
			ArrayList<Student> students = StudentsCollection.getInstance().getStudents();
			StudentsDTOsWrapper studentsDTOsWrapper = convertToDtosWrapper(students);
			
			xStream.toXML(studentsDTOsWrapper, bos);
		} catch (FileNotFoundException fne) {
			System.out.println("Došlo je do greške prilikom pristupa "
					+ "datoteci \"students.xml\"!");
			fne.printStackTrace();
		} catch (Exception e) {
			System.out.println("Došlo je do greške!");
			e.printStackTrace();
		}
	}
	
	/** REFERENCA: Materijali za vežbe (v7 -> Serijalizacija.pdf) */
	public StudentsDTOsWrapper readFromFile() {
		StudentsDTOsWrapper studentsDTOsWrapper = null;
		
		/** REFERENCA: https://stackabuse.com/java-check-if-file-or-directory-is-empty/ */
		if (file.length() > 0) {
			try (FileInputStream fis = new FileInputStream(file);
					BufferedInputStream bis = new BufferedInputStream(fis)) {

				studentsDTOsWrapper = (StudentsDTOsWrapper) xStream.fromXML(bis);
			} catch (FileNotFoundException fne) {
				System.out.println("Došlo je do greške prilikom pristupa "
						+ "datoteci \"students.xml\"!");
				fne.printStackTrace();
			} catch (Exception e) {
				System.out.println("Došlo je do greške!");
				e.printStackTrace();
			}
		}
		
		if (studentsDTOsWrapper == null) {
			studentsDTOsWrapper = new StudentsDTOsWrapper(new ArrayList<StudentDTO>());
		}
		
		return studentsDTOsWrapper;
	}
}
