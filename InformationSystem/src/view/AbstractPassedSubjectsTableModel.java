package view;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.table.AbstractTableModel;

import model.Grade;
import model.GradesCollection;

/** REFERENCA: Materijali za vežbe (v6 -> JTableMVCSimple -> view -> AbstractTableModelIgraci.java) */
public class AbstractPassedSubjectsTableModel extends AbstractTableModel {
	// Polje:
	private String indexNumber;
	private ArrayList<String> columns;
	
	// Konstruktor:
	public AbstractPassedSubjectsTableModel(String indexNumber) {
		this.indexNumber = indexNumber;
		
		columns = new ArrayList<String>();
		columns.add("Šifra predmeta");
		columns.add("Naziv predmeta");
		columns.add("ESPB");
		columns.add("Ocena");
		columns.add("Datum");
	}
	
	// Radnje:
	@Override
	public int getColumnCount() {
		return columns.size();
	}

	@Override
	public int getRowCount() {
		int rowCount = 0;
		for (Grade g : GradesCollection.getInstance().getGrades()) {
			if (g.getStudent().getIndexNumber().equals(indexNumber)) {
				rowCount++;
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
		ArrayList<Grade> studentGrades = 
				GradesCollection.getInstance().getGradesOfStudent(indexNumber);
		
		Grade row = studentGrades.get(rowIndex);
		
		switch (columnIndex) {
			case 0:
				return row.getSubject().getId();
			case 1:
				return row.getSubject().getName();
			case 2:
				return Integer.toString(row.getSubject().getEspb());
			case 3:
				return Integer.toString(row.getValue());
			/** REFERENCA: https://www.javatpoint.com/java-date-to-string */
			case 4:
				Date dateOfPassing = row.getDateOfPassing();
				SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
				return sdf.format(dateOfPassing);
			default:
				return null;
		}
	}
}
