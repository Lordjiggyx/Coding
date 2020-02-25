
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;


public class StockGUI extends JFrame{
	static ArrayList <Products>stock ;
	JPanel p;
	
	
	JLabel Field1, Field2, Field3, Field4;
	JTextField input1, input3, input4;
	JComboBox j;
	JButton btnADD, btnDelete, btndisplay, btnClose;
	JScrollPane myPane;
	private JButton btnReturn;
	
	
	public StockGUI(ArrayList<Products> stockRef){
	p = new JPanel();
	stock = stockRef;
	myPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	
	

	p.setLayout(new BorderLayout());
	myPane.setPreferredSize(new Dimension(450, 110));
	p.add(myPane);
		
	JPanel myCenterPanel = createCentrePanel();
	Border line = BorderFactory.createLineBorder(Color.black);
	myCenterPanel.setBorder(BorderFactory.createTitledBorder(line, "Records Editor"));

		

	p.add(myCenterPanel, BorderLayout.CENTER);

	this.setTitle("View & Update");
	this.setContentPane(p);
setVisible(true);
	this.pack();
	
	btnADD.addActionListener(new ActionListener() {
	   	public void actionPerformed(ActionEvent e) {
	   		Date date = new Date();
	   		date.setHours(0);
	   	int price =0;
	   		Random randomNum = new Random();
	   		int id = randomNum.nextInt(100);
	   	//Products(int ID, String name, String Type, int price  , Date date){	
	   		if (j.getSelectedIndex()==0){
	   		price = 50;
	   		}
	   		 if ( j.getSelectedIndex()==1){
	   			price = 30;
	   		}
	   		if ( j.getSelectedIndex()==2){
	   			price = 20;
	   		}
	   	Products p = new Products(id,input1.getText(),j.getSelectedItem().toString(),price,date);
	   	stock.add(p);
	   
	   	
			
	   }
});
	

    JButton btnNewButton = new JButton("Get Drop Down Item");

    btnNewButton.addActionListener(new ActionListener() {

               public void actionPerformed(ActionEvent arg0) {

                         

                         

                          if ( j.getSelectedIndex() > -1) {

                     // choice.remove( j.getSelectedIndex());

                       j.getSelectedIndex();

               }

                         

               }

    });
	
}
	public JPanel createCentrePanel()

	{
		String[] type = {"Luxury", "Essential", "Gift"};
		JPanel centerPanel = new JPanel();
		
		Field1 = new JLabel("Name", JLabel.LEFT); 
		Field2 = new JLabel("Product Type", JLabel.LEFT); 
		Field3= new JLabel("Quantity", JLabel.LEFT);
		//Field4= new JLabel("Field 4", JLabel.LEFT); 
btnADD = new JButton("Add");
		input1= new JTextField(20); 
j = new JComboBox(type);
		input3= new JTextField(20); 
		input4= new JTextField(20);  
		
		centerPanel.add(Field1);
		centerPanel.add(input1);
		centerPanel.add(Field2);
		centerPanel.add(j);
		centerPanel.add(Field3);
		centerPanel.add(input3);
		centerPanel.add(btnADD);
		
		btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		centerPanel.add(btnReturn);
		//centerPanel.add(Field4);
		//centerPanel.add(input4);
		
		
		
		return centerPanel;
	
	
	}  

	
}
