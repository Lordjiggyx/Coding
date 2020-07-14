import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;

public class OrderView extends JFrame
{
	JPanel p;
	JTable myTable;
	MyTableModel2 tm;
	JLabel Field1, Field2, Field3, Field4;
	JTextField input1, input2, input3, input4;
	JButton btnUpdate, btnDelete, btndisplay, btnClose, btnadd;
	JScrollPane myPane;
	public OrderView() 
	{		
		p = new JPanel();
		tm = new MyTableModel2();
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
		Field4= new JLabel("Field 4", JLabel.LEFT); 

		input1= new JTextField(20); 
		input2= new JTextField(20); 
		input3= new JTextField(20); 
		input4= new JTextField(20);  
		
		centerPanel.add(Field1);
		centerPanel.add(input1);
		//centerPanel.add(Field2);
		//centerPanel.add(input2);
		//centerPanel.add(Field3);
		//centerPanel.add(input3);
		//centerPanel.add(Field4);
		//centerPanel.add(input4);
		
		
		
		return centerPanel;
	}
	public JPanel createBottomPanel()
	{
		   JPanel BottomPanel = new JPanel();
		   btnadd = new JButton("Add");
		   btnUpdate = new JButton("Update");
		   btnDelete = new JButton("Delete");;
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
