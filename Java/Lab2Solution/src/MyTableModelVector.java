

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class MyTableModelVector extends AbstractTableModel{
	
	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	   /* We use vectors rather than arrays to allow the size to vary */
	   private Vector<String> columnNamesVector;
	   private Vector<Object> rowDataVector;
	   Vector <Object>newRow;
	   Vector <Object> newRows;
	   boolean ibRowNew = false;
	   boolean ibRowInserted = false;
	   Vector<Object> row;
	
	
	
	
		public MyTableModelVector(){
			String[] columnNames = {"First Name", "Surname", "Country" , "Event", "Place", "Time", "World Record" };
	
			Object[][] data = { {"César Cielo", "Filho", "Brazil", "50m freestyle",1 , "21.30", false }, {"Amaury", "Leveaux", "France", "50m freestyle", 2, "21.45", false }, {"Alain", "Bernard", "France", "50m freestyle", 3, "21.49", false }, {"Alain", "Bernard", "France", "100m freestyle", 1, "47.21", false }, {"Eamon", "Sullivan", "Australia", "100m freestyle", 2, "47.32", false }};
	
			columnNamesVector = new Vector<String>();
	         for (int i = 0; i < columnNames.length; i++) {
	        	 columnNamesVector.addElement(columnNames[i]);
	         }
	         rowDataVector = new Vector<Object>();
	         for (int i = 0; i < data.length; i++) {
	        	 newRow = new Vector<Object>();
	        	 for (int j = 0; j < data[i].length; j++) {
	        		 newRow.addElement(data[i][j]);
	        	 }
	        	 rowDataVector.addElement(newRow);
	    	 }
	         newRows = new Vector();
	      }
		
		public int getColumnCount() {
			return columnNamesVector.size();
		}
		
		public int getRowCount() {
			return rowDataVector.size();
		}
		
		public String getColumnName(int col) {
			return columnNamesVector.get(col);
		}
		
	      public Object getValueAt(int arow, int col){
		         row = (Vector) rowDataVector.elementAt(arow);
		         return row.elementAt(col);
	      }
	      
	      public void setValueAt(Object aValue, int aRow, int aCol) {
		         Vector dataRow = (Vector) rowDataVector.elementAt(aRow);
		         dataRow.setElementAt(aValue, aCol);
		         fireTableCellUpdated(aRow, aCol);
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
	      public boolean isCellEditable(int row, int col){
		         if (ibRowNew){
		            return true;
		         }
		         if (col == 0){
		            return  false;
		         } else {
		            return true;
		         }
		      }
	      
	         public void deleteRow(int rowToDelete){
		            Vector deletedRow = (Vector) rowDataVector.get(rowToDelete);
		            rowDataVector.remove(rowToDelete);
		            fireTableRowsDeleted(rowToDelete,rowToDelete);
		         }
		     
	         public void addRow(){
		            newRows.add(new Integer(rowDataVector.size() +1));
		            // Get the total number of rows in the Vector
		            int rowNumber = rowDataVector.size();
		            int pos;
		         
		            // Get what a row looks like
		            int numElements = newRow.size();
		            Vector newRowVect = new Vector();
		            for(int i = 0; i < numElements; i++){
		               String classType = newRow.elementAt(i).getClass().toString();
		               pos = classType.indexOf("String");
		               if(pos > 0){ // we have a String
		                  String blankString = new String();
		                  newRowVect.addElement(blankString);
		               }
		               pos = classType.indexOf("Integer");
		               if(pos > 0){ // we have an Integer
		                  Integer blankInt = new Integer("0");
		                  newRowVect.addElement(blankInt);
		               }
		               pos = classType.indexOf("Boolean");
		               if(pos > 0){ // we have a Boolean
		                  Boolean blankBool = new Boolean(false);
		                  newRowVect.addElement(blankBool);
		               }
		            }
		            rowDataVector.addElement(newRowVect);
		            ibRowNew = true;
		            this.isCellEditable(rowDataVector.size(),0);
		            System.out.println(rowDataVector.size());
		            //fireTableDataChanged();
		            //fireTableRowsInserted(rowNumber,rowNumber);
		            fireTableRowsInserted(rowDataVector.size(),rowDataVector.size());
		         }
		 
}


