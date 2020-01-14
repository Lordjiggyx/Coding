

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.filechooser.FileNameExtensionFilter;


public class EmployeeApplication extends JFrame  
{
    JTable myTable;
	String datafile = "Employee.html";
	// Menu structure
	JMenuBar myBar;
	JMenu fileMenu, employeeMenu,  exitMenu;
	JMenuItem fileLoad, fileSave, fileSaveAs, filePrintReport, addEmployee, removeEmployee, exitProgram;
	
	// Array of data types to be used in combo box when defining new structure
	String[] dataTypeNames;
	
	JPanel p;
	MyTableModel tm;
	JScrollPane myPane;
	
	// Subdialog used when defining new structure
	JLabel lblPPSNo, lblName, lblGender, lblDepartment, lblPosition, lblSalary;
	JTextField txtPPSNo, txtName, txtDepartment, txtPosition, txtSalary;
	JComboBox cbGender, comboBox;
	String[] genderArr = { "Male", "Female" };
	JButton btnNew, btnUpdate, btnDelete, btnPrintAll, btnClose;
	
	// Used to indicate whether data is already in a file
	File currentFile;
	

	public EmployeeApplication()
	{
		// Create menu bar and table to panel
		JMenuBar myBar = createMenuBar();
		this.setJMenuBar(myBar);
		
		p = new JPanel();
		tm = new MyTableModel();
		myTable = new JTable(tm);
		myPane = new JScrollPane(myTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		myTable.setSelectionForeground(Color.white);
		myTable.setSelectionBackground(Color.red);
		myTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

   
		p.setLayout(new BorderLayout());
		myPane.setPreferredSize(new Dimension(450, 110));
		p.add(myPane, BorderLayout.NORTH);
			
		JPanel myCenterPanel = createCentrePanel();
		Border line = BorderFactory.createLineBorder(Color.black);
		myCenterPanel.setBorder(BorderFactory.createTitledBorder(line, "Employee Records Editor"));

			

		p.add(myCenterPanel, BorderLayout.CENTER);
			
		JPanel myBottomPanel = createBottomPanel();
		p.add(myBottomPanel, BorderLayout.SOUTH);

		//Update button
		
		btnUpdate.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
				int i = myTable.getSelectedRow();
				if(i>=0 )
				{
				tm.setValueAt(txtPPSNo.getText() , i , 0);
				tm.setValueAt(txtName.getText() , i , 1);
				tm.setValueAt(cbGender.getSelectedItem() , i , 2);
				tm.setValueAt(txtDepartment.getText() , i , 3);
				tm.setValueAt(txtPosition.getText() , i , 4);
				tm.setValueAt(Double.parseDouble(txtSalary.getText()) , i , 5);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Error , No Row Has Been Selected To Be Updated");
				}
			}
		}
				);
		
		
		
		//TEXTFIELD UPDATE
	
		myTable.addMouseListener(new MouseAdapter()
				{
				public void mouseClicked(MouseEvent e)
				{
					int i = myTable.getSelectedRow();
					txtPPSNo.setText(tm.getValueAt(i, 0).toString());
					txtName.setText(tm.getValueAt(i, 1).toString());
					cbGender.setSelectedItem(tm.getValueAt(i, 2));
					txtDepartment.setText(tm.getValueAt(i, 3).toString());
					txtPosition.setText(tm.getValueAt(i, 4).toString());
					txtSalary.setText(tm.getValueAt(i, 5).toString());
				}
				}
		);
		
	
		
		// TODO load the contents of the employee.dat file into the table
		fileLoad.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				JFileChooser fc = new JFileChooser();
				int returnVal = fc.showOpenDialog(EmployeeApplication.this);
				if (returnVal == JFileChooser.APPROVE_OPTION)
				{
					File file = fc.getSelectedFile();
					// Check to see if there is already a file with this name
					if (file.exists()) 
					{
						int result = JOptionPane.showConfirmDialog(EmployeeApplication.this, "This will overwrite the existing file.\n Are you sure you want to do this?");
						if (result == 0)
						{
							try 
							{
								readDataFile(file);
							}
							catch (IOException ex) 
							{
								JOptionPane.showMessageDialog(EmployeeApplication.this, "I/O Exception\n " + ex.toString(), "Error Message", JOptionPane.ERROR_MESSAGE);
							} catch (ClassNotFoundException e1)
							{
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}
					// This is a new file name
					else 
					{
						try 
						{
							readDataFile(file);
						}
						catch (IOException ex) 
						{
							JOptionPane.showMessageDialog(EmployeeApplication.this, "I/O Exception\n " + ex.toString(), "Error Message", JOptionPane.ERROR_MESSAGE);
						} catch (ClassNotFoundException e1) 
						{
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
		});
		

		// Saving the file - usually in a different location
		fileSaveAs.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				JFileChooser fc = new JFileChooser();
				int returnVal = fc.showSaveDialog(EmployeeApplication.this);
				if (returnVal == JFileChooser.APPROVE_OPTION) 
				{
					File file = fc.getSelectedFile();
					// Check to see if there is already a file with this name
					if (file.exists())
					{
						int result = JOptionPane.showConfirmDialog(EmployeeApplication.this, "This will overwrite the existing file.\n Are you sure you want to do this?");
						if (result == 0) 
						{
							try {
								// We put the implementation of writing into a separate method
								writeDataFile(file);
							}
							catch (IOException ex) 
							{
								JOptionPane.showMessageDialog(EmployeeApplication.this, "I/O Exception\n " + ex.toString(), "Error Message", JOptionPane.ERROR_MESSAGE);
							}
						}
					}
					// This is a new file name
					else 
					{
						try 
						{
							writeDataFile(file);
						}
						catch (IOException ex) 
						{
							JOptionPane.showMessageDialog(EmployeeApplication.this, "I/O Exception\n " + ex.toString(), "Error Message", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			}
		});

		// Saving the file - usually in the same location
		fileSave.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				// Data may not yet have been saved to a file
				// currentFile not being null means that the file object has been created and we then check that it exists in the file system
				if (currentFile != null && currentFile.exists())
				{
					int result = JOptionPane.showConfirmDialog(EmployeeApplication.this, "This will overwrite the existing file.\n Are you sure you want to do this?");
					if (result == 0) 
					{
						try
						{
							writeDataFile(currentFile);
						}
						catch (IOException ex) 
						{
							JOptionPane.showMessageDialog(EmployeeApplication.this, "I/O Exception\n " + ex.toString(), "Error Message", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
				// Otherwise we need to specify the name to use for this file
				else {
					JOptionPane.showMessageDialog(EmployeeApplication.this, "File doesn't exist.\n", "Error message", JOptionPane.ERROR_MESSAGE);
					// Ask user to specify file name (remember user can type in new file name in file chooser)
					JFileChooser fc = new JFileChooser();
					int returnVal = fc.showSaveDialog(EmployeeApplication.this);
					if (returnVal == JFileChooser.APPROVE_OPTION)
					{
						currentFile = fc.getSelectedFile();
						if (currentFile.exists())
						{
							int result = JOptionPane.showConfirmDialog(EmployeeApplication.this, "This will overwrite the existing file.\n Are you sure you want to do this?");
							if (result == 0) 
							{
								try 
								{
									writeDataFile(currentFile);
								}
								catch (IOException ex)
								{
									JOptionPane.showMessageDialog(EmployeeApplication.this, "I/O Exception\n " + ex.toString(), "Error Message", JOptionPane.ERROR_MESSAGE);
								}
							}
						}
						else 
						{
							try
							{
								writeDataFile(currentFile);
							}
							catch (IOException ex) 
							{
								JOptionPane.showMessageDialog(EmployeeApplication.this, "I/O Exception\n " + ex.toString(), "Error Message", JOptionPane.ERROR_MESSAGE);
							}
						}
					}
				}
			}
		});

		
		// Prints report as external HTML file with name BankReport.html
		//THIS FORM OF PRINTING THE TABLE CONTENTS WAS DEVISED BY MYSELF , ANY OTHER SUBMISSION WITH VERY SIMILAR LAYOUT WAS TAKEN FROM THIS HENCE THIS IS THE ORGINAL
		btnPrintAll.addActionListener(new ActionListener() 
		{
			//This is this date model variable 
			Date a = new Date();
			//This is the Date formatting variable allows a to be formatted
			String date = new SimpleDateFormat("d - M - YYYY").format(a);
			public void actionPerformed(ActionEvent e) 
			{
				//If there are no rows present File is not created
				if(tm.getRowCount() ==0)
				{
					JOptionPane.showMessageDialog(null, "Report Cannot Be Created , No Information Present");
				}
				else
				{
				try
				{
					//Create a new File with the name of the file declared at the top
					File file = new File(datafile);
					//Checks if the file exists
					
					//FileWriter Object which exports the file path of employee.html
					FileWriter fw = new FileWriter(file.getAbsoluteFile());
					//BufferedWriter Object Takes in the FileWriter variable
					BufferedWriter bw = new BufferedWriter(fw);
					//bw.Write is the method to write out information when using the Buffered Writer
					//Repeated in accordance with html conventions opening and closing cells , rows and tables
					
					
					bw.write("<html>");
					bw.write("<body>");
					bw.write("<p>" + "Report at:"+date + "</p>");
					bw.write("<table border = 1>");
					bw.write("<tr>"
							+ "<th>PPSNumber</th>"
							+ "<th>Name</th>"
							+ "<th>Gender</th>"
							+ "<th>Department</th>"
							+ "<th>Position</th>"
							+ "<th>Salary</th>"
							+"</tr>");
					//Loop to create rows using "<tr>"
					for(int o = 0; o <tm.getRowCount(); o++)
					{
						bw.write("<tr>");
						//Loop to populate cells 
						//Opens a CELL
						//gets value at the corresponding coordinate converts to a string
						//Closes a CELL

						for(int i = 0; i <tm.getColumnCount(); i++)
						{
							bw.write("<td>");
							bw.write((String) tm.getValueAt(o, i).toString());
							bw.write("</td>");
						}
					}
					//Closes Table
					bw.write("</table>");
					//Closes both WriterObjects
					bw.close();
					fw.close();
						JOptionPane.showMessageDialog(null, "HTML File Has Been Created");

				}
				
				catch (Exception ex)
				{
					JOptionPane.showMessageDialog(EmployeeApplication.this, "Exception\n " + ex.toString(), "Error Message", JOptionPane.ERROR_MESSAGE);
				}
				}
			}
			});
		filePrintReport.addActionListener(new ActionListener() 
		{
			//This is this date model variable 
			Date a = new Date();
			//This is the Date formatting variable allows a to be formatted
			String date = new SimpleDateFormat("d - M - YYYY").format(a);
			public void actionPerformed(ActionEvent e) 
			{
				//If there are no rows present File is not created
				if(tm.getRowCount() ==0)
				{
					JOptionPane.showMessageDialog(null, "Report Cannot Be Created , No Information Present");
				}
				else
				{
				try
				{
					//Create a new File with the name of the file declared at the top
					File file = new File(datafile);
					//Checks if the file exists
					
					//FileWriter Object which exports the file path of employee.html
					FileWriter fw = new FileWriter(file.getAbsoluteFile());
					//BufferedWriter Object Takes in the FileWriter variable
					BufferedWriter bw = new BufferedWriter(fw);
					//bw.Write is the method to write out information when using the Buffered Writer
					//Repeated in accordance with html conventions opening and closing cells , rows and tables
					
					
					bw.write("<html>");
					bw.write("<body>");
					bw.write("<p>" + "Report at:"+date + "</p>");
					bw.write("<table border = 1>");
					bw.write("<tr>"
							+ "<th>PPSNumber</th>"
							+ "<th>Name</th>"
							+ "<th>Gender</th>"
							+ "<th>Department</th>"
							+ "<th>Position</th>"
							+ "<th>Salary</th>"
							+"</tr>");
					//Loop to create rows using "<tr>"
					for(int o = 0; o <tm.getRowCount(); o++)
					{
						bw.write("<tr>");
						//Loop to populate cells 
						//Opens a CELL
						//gets value at the corresponding coordinate converts to a string
						//Closes a CELL

						for(int i = 0; i <tm.getColumnCount(); i++)
						{
							bw.write("<td>");
							bw.write((String) tm.getValueAt(o, i).toString());
							bw.write("</td>");
						}
					}
					//Closes Table
					bw.write("</table>");
					//Closes both WriterObjects
					bw.close();
					fw.close();
						JOptionPane.showMessageDialog(null, "HTML File Has Been Created");

				}
				
				catch (Exception ex)
				{
					JOptionPane.showMessageDialog(EmployeeApplication.this, "Exception\n " + ex.toString(), "Error Message", JOptionPane.ERROR_MESSAGE);
				}
				}
			}
			});


		// Both of these listeners behave in the same way so we extract their code to a separate method

		// exits program from menu
		exitProgram.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				closeDown();
			}
		});
		
		btnClose.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				closeDown();
			}
		});
		
		
		AddEmployeeListener add = new AddEmployeeListener();
		btnNew.addActionListener(add);  
		//using second add option
		addEmployee.addActionListener(add);

		
		//delete 
		RemoveEmployeeListener delete = new RemoveEmployeeListener(btnDelete, myTable, tm);
		btnDelete.addActionListener(delete);
		removeEmployee.addActionListener(delete);

		
		
		// exits program by closing window
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				closeDown();
			}
		}); // end windowlistener

		this.setTitle("Employee Application");
		this.setContentPane(p);
		this.setVisible(true);
		this.pack();
	} // constructor

	public void readDataFile(File f) throws IOException, ClassNotFoundException 
	{
	ObjectInputStream inputStream = null;
	try {
		inputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(f)));
		// Write column headers as one object
		tm.setColumnNames((Vector<String>) inputStream.readObject());
		// Write table data as second object
		tm.setTableData((Vector<Object>)inputStream.readObject());
		// This indicates that there is no unsaved data for the moment
		tm.modified = false;
	} 
	catch (FileNotFoundException ex) {
		JOptionPane.showMessageDialog(EmployeeApplication.this, "File Not Found Exception\n " + ex.toString(), "Error Message", JOptionPane.ERROR_MESSAGE);
	}
	catch (IOException ex) {
		JOptionPane.showMessageDialog(EmployeeApplication.this, "I/O Exception\n " + ex.toString(), "Error Message", JOptionPane.ERROR_MESSAGE);
	}
	catch (Exception ex) {
		JOptionPane.showMessageDialog(EmployeeApplication.this, "Exception\n " + ex.toString(), "Error Message", JOptionPane.ERROR_MESSAGE);
	}
	// Make sure to close stream
	finally {
		inputStream.close();
	}
}{
		//TODO 
        
	}
	public void writeDataFile(File f) throws IOException, FileNotFoundException {
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
			// Write column headers as one object
			out.writeObject(tm.getColumnNames());
			// Write table data as second object
			out.writeObject(tm.getTableData());
			// This indicates that there is no unsaved data for the moment
			tm.modified = false;
		} 
		catch (FileNotFoundException ex) {
			JOptionPane.showMessageDialog(EmployeeApplication.this, "File Not Found Exception\n " + ex.toString(), "Error Message", JOptionPane.ERROR_MESSAGE);
		}
		catch (IOException ex) {
			JOptionPane.showMessageDialog(EmployeeApplication.this, "I/O Exception\n " + ex.toString(), "Error Message", JOptionPane.ERROR_MESSAGE);
		}
		catch (Exception ex) {
			JOptionPane.showMessageDialog(EmployeeApplication.this, "Exception\n " + ex.toString(), "Error Message", JOptionPane.ERROR_MESSAGE);
		}
		// Make sure to close stream
		finally {
			out.close();
		}
	}
// This behaviour will be used whether we close the application by clicking on the X button in the top-right corner or by selecting
// an option from a menu, so it makes sense to have it as an independent method that can be reused.
	public void closeDown() {
		// Ask user to confirm decision
		int result = JOptionPane.showConfirmDialog(EmployeeApplication.this, "This will close the application.\n Are you sure you want to do this?");
		if (result == 0) {
			// Give user second chance if there is unsaved data
			if (tm.modified) {
				int result2 = JOptionPane.showConfirmDialog(EmployeeApplication.this, "You have unsaved data that will be lost.\n Are you sure you want to do this?");
				if (result2 == 0) {
					System.exit(0);
				} 
			}
			else {
				System.exit(0);
			}
		}
	}

	public JMenuBar createMenuBar(){
		// Setting up menu
		fileLoad = new JMenuItem("Open");
		fileSave = new JMenuItem("Save");
		fileSaveAs = new JMenuItem("Save As");
		filePrintReport = new JMenuItem("Print Report");
		
		fileMenu = new JMenu("File");
		fileMenu.add(fileLoad);
		fileMenu.add(fileSave);
		fileMenu.add(fileSaveAs);
		fileMenu.add(filePrintReport);
		
		addEmployee = new JMenuItem("Add");
		removeEmployee = new JMenuItem("Remove");
		
		employeeMenu = new JMenu("Employees");
		employeeMenu.add(addEmployee);
		employeeMenu.add(removeEmployee);
		
		exitProgram = new JMenuItem("Exit Program");
		exitMenu = new JMenu("Exit");
		exitMenu.add(exitProgram);
		
		myBar = new JMenuBar();
		myBar.add(fileMenu);
		myBar.add(employeeMenu);
		myBar.add(exitMenu);
		
		return myBar;
	
	}
	public JPanel createCentrePanel()
	{
		   JPanel centerPanel = new JPanel(new GridLayout(6, 2));
		   
			lblPPSNo = new JLabel("PPS Number", JLabel.LEFT); 
			lblName = new JLabel("FullName", JLabel.LEFT); 
			lblGender= new JLabel("Gender", JLabel.LEFT);
			lblDepartment= new JLabel("Department", JLabel.LEFT); 
			lblPosition= new JLabel("Position", JLabel.LEFT); 
			lblSalary= new JLabel("Salary", JLabel.LEFT); 
			
	
		    txtPPSNo= new JTextField(20); 
		    txtName= new JTextField(20); 
		    txtDepartment= new JTextField(20); 
		    txtPosition= new JTextField(20);  
		    txtSalary= new JTextField(20);
		    txtSalary.setText("0.0");
		    String[] genderArr = { "Male", "Female" };
			cbGender= new JComboBox(genderArr); 
	
	       centerPanel.add(lblPPSNo);
	       centerPanel.add(txtPPSNo);
	       centerPanel.add(lblName);
	       centerPanel.add(txtName);
	       centerPanel.add(lblGender);
	       centerPanel.add(cbGender);
	       centerPanel.add(lblDepartment);
	       centerPanel.add(txtDepartment);
	       centerPanel.add(lblPosition);
	       centerPanel.add(txtPosition);
	       centerPanel.add(lblSalary);
	       centerPanel.add(txtSalary);
	
	       return centerPanel;
		
	}

	public JPanel createBottomPanel()
	{
		   JPanel BottomPanel = new JPanel();
		   btnNew = new JButton("Add New");
		   btnUpdate = new JButton("Update");
		   btnDelete = new JButton("Delete");;
		   btnPrintAll = new JButton("Print All");
		   btnClose = new JButton("Close");
		   BottomPanel.add(btnNew);
		   BottomPanel.add(btnUpdate);
		   BottomPanel.add(btnDelete);
		   BottomPanel.add(btnPrintAll);
		   BottomPanel.add(btnClose);
	
	       return BottomPanel;
		
	}


	public static void main (String args[]){
		new EmployeeApplication();
	} // main
	
	
	class AddEmployeeListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			try
			{
			String pps = txtPPSNo.getText();
			String name = txtName.getText();
			String gender = cbGender.getSelectedItem().toString();
			String dept = txtDepartment.getText();
			String position = txtPosition.getText();
			double salary = Double.parseDouble(txtSalary.getText());	
			Vector<Object> data = new Vector <Object> (5);
			if(txtPPSNo.getText().isEmpty() || txtName.getText().isEmpty() || txtDepartment.getText().isEmpty() || txtPosition.getText().isEmpty() || txtSalary.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Please Enter all Information");;
			}
			else
			{
			data.add(pps);
			data.add(name);
			data.add(gender);
			data.add(dept);
			data.add(position);
			data.add(salary);
			tm.addRow(data);
			}
		}
			catch(NumberFormatException ex)
			{
				JOptionPane.showMessageDialog(null, "A Letter Was Entered Where A Number Is Expected Please Try Again");;
			}
	}
}
}