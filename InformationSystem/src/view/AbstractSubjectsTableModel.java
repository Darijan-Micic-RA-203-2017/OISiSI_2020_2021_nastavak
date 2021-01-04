package view;

import javax.swing.table.AbstractTableModel;

import model.SubjectsCollection;;

/** REFERENCA: Materijali za vežbe (v6 -> JTableMVCSimple -> view -> AbstractTableModelIgraci.java) */
public class AbstractSubjectsTableModel extends AbstractTableModel {
	public AbstractSubjectsTableModel() {}
	
	@Override
	public int getColumnCount() {
		return SubjectsCollection.getInstance().getColumnCount();
	}
	
	@Override
	public int getRowCount() {
		return SubjectsCollection.getInstance().getSubjects().size();
	}
	
	@Override
	public String getColumnName(int column) {
		return SubjectsCollection.getInstance().getColumnName(column);
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return SubjectsCollection.getInstance().getValueAt(rowIndex, columnIndex);
	}
}
