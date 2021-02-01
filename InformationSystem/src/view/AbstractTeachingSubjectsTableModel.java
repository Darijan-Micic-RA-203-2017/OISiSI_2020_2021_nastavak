package view;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.table.AbstractTableModel;

import model.Subject;
import model.SubjectsCollection;

/** REFERENCA: Materijali za vežbe (v6 -> JTableMVCSimple -> view -> AbstractTableModelIgraci.java) */
public class AbstractTeachingSubjectsTableModel extends AbstractTableModel {
	private String nationalId;
	private ArrayList<String> columns;
	
	public AbstractTeachingSubjectsTableModel(String nationalId) {
		this.nationalId = nationalId;
		
		columns = new ArrayList<String>();
		columns.add("Šifra");
		columns.add("Naziv");
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
		for (Subject s : SubjectsCollection.getInstance().getSubjects()) {
			if (s.getProfessor() != null) {
				if(s.getProfessor().getNationalID() != null) {
					if(s.getProfessor().getNationalID().equals(nationalId)) {
						rowCount++;
					}
				} else {
					rowCount = 0;
				}
			} else {
				rowCount = 0;
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
		ArrayList<Subject> teachingSubjects =
				SubjectsCollection.getInstance().getTeachingSubjectsOfProfessorWith(nationalId);
		
		Subject row = teachingSubjects.get(rowIndex);
		
		switch(columnIndex) {
			case 0:
				return row.getId();
			case 1:
				return row.getName();
			case 2:
				return Integer.toString(row.getYearOfStudy());
			case 3:
				return row.getSemester().toString();
			default:
				return null;
		}
	}
}
