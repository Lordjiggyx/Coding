
import java.awt.*;

import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.text.MaskFormatter;
import java.util.ArrayList;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

public class Menu extends JFrame{
	
	private ArrayList<Customer> customerList = new ArrayList<Customer>();
    private int position = 0;
	private String password;
	private Customer customer = null;
	private CustomerAccount acc = new CustomerAccount();
	JFrame f, f1;
	JLabel firstNameLabel, surnameLabel, pPPSLabel, dOBLabel;
	JTextField firstNameTextField, surnameTextField, pPSTextField, dOBTextField;
	JLabel customerIDLabel, passwordLabel;
	JTextField customerIDTextField, passwordTextField;
	Container content;
	Customer cus;
	JPanel panel2;
	JButton add, cancel;
	String 	PPS,firstName,surname,DOB,CustomerID;
	Admin a = new Admin();
	CustomerMenu cm = new CustomerMenu();
	
	public static void main(String[] args)
	{
		Menu driver = new Menu();
		driver.menuStart();
	}
	
	public void menuStart()
	{
		   /*The menuStart method asks the user if they are a new customer, an existing customer or an admin. It will then start the create customer process
		  if they are a new customer, or will ask them to log in if they are an existing customer or admin.*/
		
			
		
			
			f = new JFrame("User Type");
			f.setSize(400, 300);
			f.setLocation(200, 200);
			f.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent we) { System.exit(0); }
			});

			JPanel userTypePanel = new JPanel();
			final ButtonGroup userType = new ButtonGroup();
			JRadioButton radioButton;
			userTypePanel.add(radioButton = new JRadioButton("Existing Customer"));
			radioButton.setActionCommand("Customer");
			userType.add(radioButton);
			
			userTypePanel.add(radioButton = new JRadioButton("Administrator"));
			radioButton.setActionCommand("Administrator");
			userType.add(radioButton);
			
			userTypePanel.add(radioButton = new JRadioButton("New Customer"));
			radioButton.setActionCommand("New Customer");
			userType.add(radioButton);

			JPanel continuePanel = new JPanel();
			JButton continueButton = new JButton("Continue");
			continuePanel.add(continueButton);

			Container content = f.getContentPane();
			content.setLayout(new GridLayout(2, 1));
			content.add(userTypePanel);
			content.add(continuePanel);



			//Continue Button shortened
			continueButton.addActionListener(new ActionListener(  ) {
				public void actionPerformed(ActionEvent ae) {
					String user = userType.getSelection().getActionCommand(  );
					
					//if user selects NEW CUSTOMER--------------------------------------------------------------------------------------
					if(user.equals("New Customer"))
					{
						newCustomer();
					}
					
					
					//------------------------------------------------------------------------------------------------------------------
					
					//if user select ADMIN----------------------------------------------------------------------------------------------
					if(user.equals("Administrator")	)
					{
						adminUsernamePasswordInput();
					}
					//----------------------------------------------------------------------------------------------------------------
					
					
					
					//if user selects CUSTOMER ---------------------------------------------------------------------------------------- 
					if(user.equals("Customer")	)
					{
						customerInput();
					}
					//-----------------------------------------------------------------------------------------------------------------------
				}

				
			});f.setVisible(true);	
	}

	
	//Deals with creating labels and textfields
	public void labelTextfield()
	{
		firstNameLabel = new JLabel("First Name:", SwingConstants.LEFT);
		surnameLabel = new JLabel("Surname:", SwingConstants.LEFT);
		pPPSLabel = new JLabel("PPS Number:", SwingConstants.LEFT);
		dOBLabel = new JLabel("Date of birth", SwingConstants.LEFT);
		customerIDLabel = new JLabel("CustomerID:", SwingConstants.LEFT);
		passwordLabel = new JLabel("Password:", SwingConstants.LEFT);
		
		
		firstNameTextField = new JTextField(20);
		surnameTextField = new JTextField(20);
		pPSTextField = new JTextField(20);
		dOBTextField = new JTextField(20);
		customerIDTextField = new JTextField(20);
		passwordTextField = new JTextField(20);
		
	}
	
	
	public void adminUsernamePasswordInput()
	{
		boolean adminNameloop = true, adminPsswordLoop = true , ValidCreds = false;
	    while(adminNameloop)
	    {
	    Object adminUsername = JOptionPane.showInputDialog(f, "Enter Administrator Username:");

	    if(!adminUsername.equals("admin"))
	    {
	    	int reply  = JOptionPane.showConfirmDialog(null, "Incorrect Username. Try again?", "Username Error", JOptionPane.YES_NO_OPTION);
	    	if (reply == JOptionPane.YES_OPTION) {
	    		adminNameloop = true;
	    	}
	    	else if(reply == JOptionPane.NO_OPTION)
	    	{
	    		adminNameloop = false;
	    		adminPsswordLoop = false;
	    	
	    	}
	    }
	    else
	    {
	    	adminNameloop = false;
	    }				    
	    }
	    
	    while(adminPsswordLoop)
	    {
	    	Object adminPassword = JOptionPane.showInputDialog(f, "Enter Administrator Password;");
	    	
	    	   if(!adminPassword.equals("admin11"))
			    {
			    	int reply  = JOptionPane.showConfirmDialog(null, "Incorrect Password. Try again?", "Password Error", JOptionPane.YES_NO_OPTION);
			    	if (reply == JOptionPane.YES_OPTION) {
			    		
			    	}
			    	else if(reply == JOptionPane.NO_OPTION){
			    		adminPsswordLoop = false;
			    		
			    	}
			    }
	    	   else
	    	   {
	    		   adminPsswordLoop =false;
	    		   ValidCreds = true;
	    	   }
	    }
	    	
	    if(ValidCreds)
	    {
	    adminNameloop = false;
	    //pass in the customer list
	    a.setCustomerList(customerList);
	    //then create the admin menu
	    a.menu();
	    }					
	}

	public void customerInput()

	{
		boolean CustomerNameloop = true, CustomerPasswordloop2 = true;
		boolean validCreds = false;
		boolean found = false;
		//Customer customer = null;
	    while(CustomerNameloop)
	    {
	    Object customerID = JOptionPane.showInputDialog(f, "Enter Customer ID:");
	    
	    //
	    if(findCustomer(customerID))
	    {
	    	found = true;
	    }
	    
	    if(found == false)
	    {
	    	CustomerNotFound();
	    }
	    else
	    {
	    	CustomerNameloop = false;
	    }
	   
	    }
	    
	    while(CustomerPasswordloop2)
	    {
	    	Object customerPassword = JOptionPane.showInputDialog(f, "Enter Customer Password;");
	    	
	    	   if(!customer.getPassword().equals(customerPassword))//check if custoemr password is correct
			    {
			    	int reply  = JOptionPane.showConfirmDialog(null, "Incorrect password. Try again?", "Passwords Error", JOptionPane.YES_NO_OPTION);
			    	if (reply == JOptionPane.YES_OPTION) {
			    		
			    	}
			    	else if(reply == JOptionPane.NO_OPTION){
			    		CustomerPasswordloop2 = false;
			    	}
			    }
	    	   else
	    	   {
	    		   CustomerPasswordloop2 =false;
	    		   validCreds = true;
	    	   }
	    }
	    	
	    if(validCreds)
	    {
	    	CustomerNameloop = false;
	    	cm.setCustomer(cus);
	    	cm.menu();
	    }
	}
	public void newCustomer() {
		
		f.dispose();		
		f1 = new JFrame("Create New Customer");
		f1.setSize(400, 300);
		f1.setLocation(200, 200);
		f1.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) { System.exit(0); }
		});
			Container content = f1.getContentPane();
			content.setLayout(new BorderLayout());
			
			labelTextfield();
			JPanel panel = new JPanel(new GridLayout(6, 2));
			panel.add(firstNameLabel);
			panel.add(firstNameTextField);
			panel.add(surnameLabel);
			panel.add(surnameTextField);
			panel.add(pPPSLabel);
			panel.add(pPSTextField);
			panel.add(dOBLabel);
			panel.add(dOBTextField);
				
			panel2 = new JPanel();
			add = new JButton("Add");
			cancel = new JButton("Cancel");	
			
			//make only one add method
			add.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {


					PPS = pPSTextField.getText();
					firstName = firstNameTextField.getText();
					surname = surnameTextField.getText();
					DOB = dOBTextField.getText();
					password = "";
					CustomerID = "ID"+PPS ;
					f1.dispose();

					boolean passwordLoop = true;
					while(passwordLoop){
						password = JOptionPane.showInputDialog(f, "Enter 7 character Password;");

						if(password.length() != 7)//Making sure password is 7 characters
						{
						JOptionPane.showMessageDialog(f1, "Password must be 7 charatcers long", "Incorrect Password", JOptionPane.ERROR_MESSAGE);
						}
						else
						{
							passwordLoop = false;
							ArrayList<CustomerAccount> accounts = new ArrayList<CustomerAccount> ();
							Customer customer = new Customer(PPS, surname, firstName, DOB, CustomerID, password, accounts);

							customerList.add(customer);

							JOptionPane.showMessageDialog(f, "CustomerID = " + CustomerID +"\n Password = " + password  ,"Customer created.",  JOptionPane.INFORMATION_MESSAGE);

						}
					}
				menuStart();

				}
			});						
							
			cancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					f1.dispose();
					menuStart();
				}
			});	
			
			panel2.add(add);
			panel2.add(cancel);
			
			content.add(panel, BorderLayout.CENTER);
			content.add(panel2, BorderLayout.SOUTH);
	
			f1.setVisible(true);	
		
	}

	public void noCustomer()
	{
	JOptionPane.showMessageDialog(f, "There are no customers yet!"  ,"Oops!",  JOptionPane.INFORMATION_MESSAGE);
	f.dispose();
	a.menu();
	}

	public void CustomerNotFound()
	{
		    	int reply  = JOptionPane.showConfirmDialog(null, "User Not Found Try again?", "No User", JOptionPane.YES_NO_OPTION);
		    	if (reply == JOptionPane.YES_OPTION) {
		    		
		    	}
		    	else if(reply == JOptionPane.NO_OPTION)
		    	{
		    		f.dispose();
		    		
		    	}
		    
	}

	
	public boolean findCustomer(Object obj)
	{
		boolean result = false;
		 for (Customer aCustomer: customerList){
		    	
			if(aCustomer.getCustomerID().equals(obj))
			{
				customer = aCustomer;
				result =true;
				System.out.println("User  found");
				break;
				
			}
			if(!aCustomer.getCustomerID().equals(obj))
			{
				noCustomer();
			}
		 }
		 return result;
	}
	
}


