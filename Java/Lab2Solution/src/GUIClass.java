
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class GUIClass extends JFrame implements ActionListener{

	// Define variables
	//MyTableModel myTableModel;
	MyTableModelVector myTableModel;
	JTable myTable;
	JButton btnDisplay, btnAddRow, btnDeleteRow;
	JTextField textDisplayCell;
	JScrollPane scroller;
	
	public GUIClass(){
		this.getContentPane().setLayout(new BorderLayout());
		// Create an instance of a model
		//myTableModel = new MyTableModel();
		myTableModel = new MyTableModelVector();
		// Create an instance of a table
		myTable = new JTable(myTableModel);

		scroller = new JScrollPane(myTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		scroller.setPreferredSize(new Dimension(600, 100));

		// Add the table to the GUI
		this.getContentPane().add(scroller, BorderLayout.NORTH);
		

		
		// Add a button
		JPanel pnlBtn = new JPanel();
		btnDisplay = new JButton("Display Cell Value");
		btnDisplay.addActionListener(this);
		btnAddRow= new JButton("Add Row");

		btnDeleteRow = new JButton("Delete Row");

		
	      /* This button allows an empty row to be created and values entered */
		btnAddRow.addActionListener(new ActionListener(){
	         public void actionPerformed(ActionEvent e){
	        	myTableModel.addRow();
	            myTable.setEditingRow(myTableModel.getRowCount());
	            myTable.setRowSelectionInterval(myTableModel.getRowCount()-1,myTableModel.getRowCount()-1);
	         }
	      });
	      /* This button allows a row to be deleted */
		btnDeleteRow.addActionListener(new ActionListener(){
	         public void actionPerformed(ActionEvent e){
	            int rowToDelete = myTable.getSelectedRow();
	            myTableModel.deleteRow(rowToDelete);
	            myTable.setEditingRow(rowToDelete -1);
	            myTable.setRowSelectionInterval(rowToDelete -1,rowToDelete -1);
	         }
	      });
		pnlBtn.add(btnDisplay);
		pnlBtn.add(btnAddRow);
		pnlBtn.add(btnDeleteRow);
		// Add a text field

		this.getContentPane().add(pnlBtn, BorderLayout.CENTER);
		
		JPanel pnlInput = new JPanel();
		textDisplayCell = new JTextField(20);
		pnlInput.add(textDisplayCell);
		this.getContentPane().add(pnlInput, BorderLayout.SOUTH);
	}
	
	public static void main(String args[]){
		GUIClass myGUI = new GUIClass();
		myGUI.setTitle("MyTableGUI");
		myGUI.pack();
		myGUI.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getActionCommand()=="Display Cell Value"){
			// Get selected row value
			int row = myTable.getSelectedRow();
			System.out.println("row: "+row);
			// Get selected column value
	        int col = myTable.getSelectedColumn();
	        System.out.println("col: "+col);
	
	        // Get selected value - if any cell was selected
	        if(row != -1 && col != -1){
	        	Object value = myTable.getModel().getValueAt(row, col); 
	        	// Print to console
	        	System.out.println(" value: "+value);
	        	// Print to the text field - cast to the correct object type
	        	if(value.getClass() == Integer.class){
	        		textDisplayCell.setText(Integer.toString((Integer)value));
	        	}
	        	else if(value.getClass() == Boolean.class){
	        		textDisplayCell.setText(Boolean.toString((Boolean)value));
	        	}
	        	else{
	        		textDisplayCell.setText((String)value);
	        	}
	        }
	        else{
	        	// Print to console
	        	System.out.println("No cell selected");
	        	// Print to the text field
	        	textDisplayCell.setText("No cell selected");
	        }
		}
		if(e.getActionCommand()=="Add Row"){
			
		}
	}
}
