
import java.util.Vector;

	import javax.swing.JOptionPane;
	import javax.swing.table.AbstractTableModel;
//Table Model For Orders
	class MyTableModel2 extends AbstractTableModel 
	{
		Vector<Object> row;
		Vector<Object> newRow;
		boolean ibRowNew = false;
		boolean ibRowInserted = false;
		
		/* We use vectors rather than arrays to allow the size to vary */
		private Vector<String> columnNames;
		private Vector<Object> rowData;
		
		// Used to indicate whether data has been modified since it was loaded
		public boolean modified;
		
		// Used to indicate row in table that can be modified
		int editable;

		MyTableModel2()
		{
			String[] columns = {"ID"};
			Object[][] inputData = 
				{
					{""}
					//
			};
			columnNames = new Vector<String>();
			for (int i = 0; i < columns.length; i++)
			{
				columnNames.addElement(columns[i]);
			}
			rowData = new Vector<Object>();
			for (int i = 0; i < inputData.length; i++) 
			{
				newRow = new Vector<Object>();
				for (int j = 0; j < inputData[i].length; j++) 
				{
					newRow.addElement(inputData[i][j]);
				}
				rowData.addElement(newRow);
			}
			// Initialising values
			modified = false;
			editable = -1;
		}

		@SuppressWarnings({ "rawtypes", "unchecked" })
		public Class getColumnClass(int col)
		{
			return getValueAt(0,col).getClass();
		}

		// Get and set methods for column names and table data

		public Vector<String> getColumnNames()
		{
			return columnNames;
		}

		public Vector<Object> getTableData()
{
			return rowData;
		}

		public void setColumnNames(Vector<String> names) 
		{
			columnNames = names;
			// This is a new structure so we need to tell the renderer this
			fireTableStructureChanged();
			modified = true;
		}

		public void setTableData(Vector<Object> data) 
		{
			rowData = data;
			// This is new data so we need to tell the renderer this
			fireTableDataChanged();
			modified = true;
		}

		public void setNewRow(Vector<Object> blankRow) 
		{
			newRow = blankRow;
		}

		public boolean isCellEditable(int row, int col)
		{
			// Only selected row can be edited
			return true;
			/* put back in if (row == editable){
				return true;
			}
			else {
				return false;
			}*/
		}

		public String getColumnName(int col)
		{
			return columnNames.get(col);
		}

		public int getRowCount()
		{
			return rowData.size();
		} 

		public int getColumnCount()
		{
			return columnNames.size();
		}

		@SuppressWarnings("unchecked")
		public Object getValueAt(int arow, int col)
		{
			row = (Vector<Object>) rowData.elementAt(arow);
			return row.elementAt(col);
		}

		@SuppressWarnings("unchecked")
		public void setValueAt(Object aValue, int aRow, int aCol) 
		{
			Vector<Object> dataRow = (Vector<Object>) rowData.elementAt(aRow);
			dataRow.setElementAt(aValue, aCol);
			fireTableCellUpdated(aRow, aCol);
			// Modifying a cell implies unsaved data
			modified = true;
		}

		//@SuppressWarnings("unused")
		public void deleteRow(int rowToDelete)
		{
			try {
				rowData.remove(rowToDelete);
				fireTableRowsDeleted(rowToDelete,rowToDelete);
			}
			catch (ArrayIndexOutOfBoundsException e)
			{
				JOptionPane.showMessageDialog(null, "No more rows to delete\n " + e.toString(), "Error Message", JOptionPane.ERROR_MESSAGE);
			}
		}

		public void addRow(Vector<Orders> data)
		{ //added my vector
			// Get the total number of rows in the Vector
			int rowNumber = rowData.size();
			int pos;
			// Get what a row looks like
			int numElements = getColumnCount();	
			
			for(int i = 0; i < numElements; i++)
			{
				String classType = getColumnClass(i).toString();
				pos = classType.indexOf("String");
				if(pos > 0){ // we have a String
					String blankString = new String();
					data.addElement(data.get(i)); //info is our vector
				}
				pos = classType.indexOf("Double");
				if(pos > 0){ // we have a Double
					Double blankDouble = new Double("0.0");
					data.addElement(data.get(i)); //info is our vector
				}
			}
			rowData.addElement(data); //info is our vector
			editable = rowData.size() - 1;
			fireTableRowsInserted(rowNumber,rowNumber);
		}
	}

