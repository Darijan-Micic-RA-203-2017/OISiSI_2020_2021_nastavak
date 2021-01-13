package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

/** REFERENCA: Materijali za vežbe (v6 -> JTableMVCSimple -> view -> IgraciJTable.java) */
public class PassedSubjectsTable extends JTable {
	// Konstruktor:
	public PassedSubjectsTable(String indexNumber) {
		setRowSelectionAllowed(true);
		setColumnSelectionAllowed(true);
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		// Sama JTable komponenta napravljena je poštujući MVC arhitekturu.
		setModel(new AbstractPassedSubjectsTableModel(indexNumber));
	}

	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component c = super.prepareRenderer(renderer, row, column);
		
		if (isRowSelected(row)) {
			c.setBackground(Color.LIGHT_GRAY);
		} else {
			c.setBackground(Color.WHITE);
		}
		
		return c;
	}
}
