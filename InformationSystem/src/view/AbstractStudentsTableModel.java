package view;

import javax.swing.table.AbstractTableModel;

import model.StudentsCollection;

/** REFERENCA: Materijali za vežbe (v6 -> JTableMVCSimple -> view -> AbstractTableModelIgraci.java) */
public class AbstractStudentsTableModel extends AbstractTableModel {
	// Konstruktor:
	public AbstractStudentsTableModel() {}
	
	// Radnje:
	@Override
	public int getColumnCount() {
		return StudentsCollection.getInstance().getColumnCount();
	}

	@Override
	public int getRowCount() {
		return StudentsCollection.getInstance().getStudents().size();
	}
	
	@Override
	public String getColumnName(int column) {
		return StudentsCollection.getInstance().getColumnName(column);
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return StudentsCollection.getInstance().getValueAt(rowIndex, columnIndex);
	}
}
