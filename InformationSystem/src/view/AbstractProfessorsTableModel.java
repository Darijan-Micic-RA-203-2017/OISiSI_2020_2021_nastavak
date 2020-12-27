package view;

import javax.swing.table.AbstractTableModel;

import model.ProfessorsCollection;

/** REFERENCA: Materijali za vežbe (v6 -> JTableMVCSimple -> view -> AbstractTableModelIgraci.java) */
public class AbstractProfessorsTableModel extends AbstractTableModel {
	public AbstractProfessorsTableModel() {}
	
	@Override
	public int getColumnCount() {
		return ProfessorsCollection.getInstance().getColumnCount();
	}
	
	@Override
	public int getRowCount() {
		return ProfessorsCollection.getInstance().getProfessors().size();
	}
	
	@Override
	public String getColumnName(int column) {
		return ProfessorsCollection.getInstance().getColumnName(column);
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return ProfessorsCollection.getInstance().getValueAt(rowIndex, columnIndex);
	}

}
