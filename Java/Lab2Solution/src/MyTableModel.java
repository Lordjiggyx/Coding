


import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel {
	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] columnNames = {"First Name", "Surname", "Country" , "Event", "Place", "Time", "World Record" };

	private Object[][] data = { {"César Cielo", "Filho", "Brazil", "50m freestyle",1 , "21.30", false }, {"Amaury", "Leveaux", "France", "50m freestyle", 2, "21.45", false }, {"Alain", "Bernard", "France", "50m freestyle", 3, "21.49", false }, {"Alain", "Bernard", "France", "100m freestyle", 1, "47.21", false }, {"Eamon", "Sullivan", "Australia", "100m freestyle", 2, "47.32", false }};


	public MyTableModel(){
		columnNames = new String[] {"First Name", "Surname", "Country" , "Event", "Place", "Time", "World Record" };

		data = new Object[][]{ {"César Cielo", "Filho", "Brazil", "50m freestyle",1 , "21.30", false }, {"Amaury", "Leveaux", "France", "50m freestyle", 2, "21.45", false }, {"Alain", "Bernard", "France", "50m freestyle", 3, "21.49", false }, {"Alain", "Bernard", "France", "100m freestyle", 1, "47.21", false }, {"Eamon", "Sullivan", "Australia", "100m freestyle", 2, "47.32", false }};

		
	}
	public int getColumnCount() {
	return columnNames.length;
	}

	public int getRowCount() {
	return data.length;
	}
	
	public String getColumnName(int col) {
	return columnNames[col];
	}

	public Object getValueAt(int row, int col) {
	return data[row][col];
	}

/*
* JTable uses this method to determine the default renderer/
* editor for each cell.  If we didn't implement this method,
* then the last column would contain text ("true"/"false"),
* rather than a check box.
*/
	public Class getColumnClass(int c) {
	return getValueAt(0, c).getClass();
	}

/*
* Don't need to implement this method unless your table's
* editable.
*/
	public boolean isCellEditable(int row, int col) {
	//Note that the data/cell address is constant,
	//no matter where the cell appears onscreen.
	/*if (col < 2) {
	return false;
	} else {
	return true;
	}*/
	return true;
	}

/*
* Don't need to implement this method unless your table's
* data can change.
*/
	public void setValueAt(Object value, int row, int col) {
	
	data[row][col] = value;
	// Showing that the method has been called
	System.out.println("VALUE SET TO: "+value.toString()+" at col:"+ col + ", row:"+row);
	fireTableCellUpdated(row, col);
	
	}

}