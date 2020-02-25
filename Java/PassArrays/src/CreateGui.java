import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class CreateGui extends JFrame implements ActionListener
{

	private JPanel window1 , contentPane , bWindow ;
	private JTextField text1 , text2, text3;
	private JLabel name , surname , Dob;
	private JButton submit , cancel;
	static ArrayList <String> customerList;
	

	public static void main (String[] args){
		CreateGui a= new CreateGui(customerList);
		a.setSize(400 , 400);
		a.setVisible(true);
	}
	
	
	public CreateGui(ArrayList<String> customerListRef){
		
	{
		this.setTitle("Customer Details");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 300); 
		customerList = customerListRef;
		//Declare components
		contentPane = new JPanel();
		window1 = new JPanel();	
		text1 = new JTextField();
		text2 = new JTextField();
		text3 = new JTextField();
		name  = new JLabel ("Name:");
		surname = new JLabel ("Surname:");
		Dob = new JLabel ("date Of Birth:");
		submit = new JButton("Submit");
		submit.addActionListener(this);
		cancel = new JButton("Cancel");
		cancel.addActionListener(this);
		
		//Set layout
		contentPane.setLayout(new GridLayout(4, 2 ));
		
		
		//Add Components
		
		this.add(contentPane);
		//Have the components arranged the way you want it to look
		contentPane.add(name);
		contentPane.add(text1);
		contentPane.add(surname);
		contentPane.add(text2);
		contentPane.add(Dob);
		contentPane.add(text3);

		
		
		contentPane.add(window1);
		window1.add(submit);
		window1.add(cancel);		
		
		setSize(400 , 200);
		setVisible(true);
		
		submit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				// TODO Auto-generated method stub
				Customer cust = new Customer (text1.getText(), text2.getText() , text3.getText());
				customerList.add(cust.toString());
				setVisible(false); 
				dispose();
			}
				});
		
		cancel.addActionListener(new ActionListener()
		{
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		text1.setText(" ");
		text2.setText(" ");
		text3.setText(" ");
		
	}
		});
	}
}







	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}











}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	


