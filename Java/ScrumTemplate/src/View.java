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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;



public class View extends JFrame
{
	JPanel p;
	JTable myTable;
	MyTableModel tm;
	JLabel Field1, Field2, Field3, Field4;
	JTextField input1, input2, input3, input4;
	JButton btnUpdate, btnDelete, btndisplay, btnClose, btnadd;
	JScrollPane myPane;
	public View() 
	{		
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
		myCenterPanel.setBorder(BorderFactory.createTitledBorder(line, "Records Editor"));

			

		p.add(myCenterPanel, BorderLayout.CENTER);
			
		JPanel myBottomPanel = createBottomPanel();
		p.add(myBottomPanel, BorderLayout.SOUTH);


		this.setTitle("View & Update");
		this.setContentPane(p);
		this.setVisible(true);
		this.pack();
	}
	
	
	
	public JPanel createCentrePanel()

	{
		JPanel centerPanel = new JPanel(new GridLayout(4, 2));
		
		Field1 = new JLabel("ID", JLabel.LEFT); 
		Field2 = new JLabel("Name", JLabel.LEFT); 
		Field3= new JLabel("Email", JLabel.LEFT);
		Field4= new JLabel("Address", JLabel.LEFT); 

		input1= new JTextField(20); 
		input2= new JTextField(20); 
		input3= new JTextField(20); 
		input4= new JTextField(20);  
		
		centerPanel.add(Field1);
		centerPanel.add(input1);
		centerPanel.add(Field2);
		centerPanel.add(input2);
		centerPanel.add(Field3);
		centerPanel.add(input3);
		centerPanel.add(Field4);
		centerPanel.add(input4);
		
		
		
		return centerPanel;
	}
	public JPanel createBottomPanel()
	{
		   JPanel BottomPanel = new JPanel();
		   btnadd = new JButton("Add");
		   btnadd.addActionListener(new ActionListener() {
		   	public void actionPerformed(ActionEvent e) {
		   		
					try
					{
					String Id = input1.getText();
					String name = input2.getText();
					String email = input3.getText();
					String Address = input4.getText();	
					Vector<Object> data = new Vector <Object> (3);
					if(input1.getText().isEmpty() || input2.getText().isEmpty() || input3.getText().isEmpty() || input4.getText().isEmpty())
					{
						JOptionPane.showMessageDialog(null, "Please Enter all Information");;
					}
					else
					{
					data.add(Id);
					data.add(name);
					data.add(email);
					data.add(Address);
				
					tm.addRow(data);
					}
				}
					catch(NumberFormatException ex)
					{
						JOptionPane.showMessageDialog(null, "A Letter Was Entered Where A Number Is Expected Please Try Again");;
					}
		   	}
		   });
		   btnUpdate = new JButton("Update");
		   btnUpdate.addActionListener(new ActionListener() {
		   	public void actionPerformed(ActionEvent e) 
		   	{
		   		int i = myTable.getSelectedRow();
				if(i>=0 )
				{
				tm.setValueAt(input1.getText() , i , 0);
				tm.setValueAt(input2.getText() , i , 1);
				tm.setValueAt(input3.getText() , i , 2);
				tm.setValueAt(input4.getText() , i , 3);

				}
				else
				{
					JOptionPane.showMessageDialog(null, "Error , No Row Has Been Selected To Be Updated");
				}
		   	}
		   });
		   btnDelete = new JButton("Delete");
		   btnDelete.addActionListener(new ActionListener() {
		   	public void actionPerformed(ActionEvent e) 
		   	{
		   		
		   		if(myTable.getSelectedRow() == -1)
				{
					int result = JOptionPane.showConfirmDialog(null, "No Row Selected , Last Row Will Be Deleted.\n Are you sure you want to do this?" );
					if (result == JOptionPane.YES_OPTION)
					{
						tm.deleteRow(myTable.getRowCount()-1);
					}
					if (result == JOptionPane.NO_OPTION)
					{

						JOptionPane.showMessageDialog(null, "No Row Will Be Deleted");;
					}
					if (result == JOptionPane.CANCEL_OPTION)
					{

						JOptionPane.showMessageDialog(null, "No Row Will Be Deleted");
					}
					
				}
				else
				{
					tm.deleteRow(myTable.getSelectedRow());
				}
				}
		   	}
		   );;
		   btndisplay = new JButton("Print Form");
		   btnClose = new JButton("Return");
		   btnClose.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) 
			 	{
			 		setVisible(false);
			 	}
			 });
		   BottomPanel.add(btnadd);
		   BottomPanel.add(btnUpdate);
		   BottomPanel.add(btnDelete);
		   BottomPanel.add(btndisplay);
		   BottomPanel.add(btnClose);
	
	       return BottomPanel;
		
	}

}
