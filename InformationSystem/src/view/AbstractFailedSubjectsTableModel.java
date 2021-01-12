package view;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.table.AbstractTableModel;

import model.Student;
import model.StudentsCollection;
import model.Subject;
import model.SubjectsCollection;

/** REFERENCA: Materijali za vežbe (v6 -> JTableMVCSimple -> view -> AbstractTableModelIgraci.java) */
public class AbstractFailedSubjectsTableModel extends AbstractTableModel {
	private String indexNumber;
	private ArrayList<String> columns;
	
	public AbstractFailedSubjectsTableModel(String indexNumber) {
		this.indexNumber = indexNumber;
		
		columns = new ArrayList<String>();
		columns.add("Šifra predmeta");
		columns.add("Naziv predmeta");
		columns.add("ESPB");
		columns.add("Godina studija");
		columns.add("Semestar");
	}
	
	@Override
	public int getColumnCount() {
		return columns.size();
	}
	
	@Override
	public int getRowCount() {
		int rowCount = 0;
		for(Subject s : SubjectsCollection.getInstance().getSubjects()) {
			for(Student s1 : s.getFailedSubject()) {
				if(s1.getIndexNumber().equals(indexNumber)) {
					rowCount++;
				}
			}
		}
		return rowCount;
	}
	
	@Override
	public String getColumnName(int column) {
		return columns.get(column);
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		ArrayList<Subject> studentSubjects =
				SubjectsCollection.getInstance().getFailedSubjectsOfStudent(indexNumber);
		
		Subject row = studentSubjects.get(rowIndex);
		
		switch (columnIndex) {
			case 0:
				return row.getId();
			case 1:
				return row.getName();
			case 2:
				return Integer.toString(row.getEspb());
			case 3:
				return Integer.toString(row.getYearOfStudy());
			case 4:
				return row.getSemester().toString();
			default:
				return null;
		}
	}
}
