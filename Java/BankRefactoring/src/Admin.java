import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;



//import Menu.returnAdmin;
//import Menu.returnCustomer;
//import Menu.returnMenu;

public class Admin extends JFrame {
	
	private ArrayList<Customer> customerList = new ArrayList<Customer>();
    private int position = 0;

	//Might need to remove if not used
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
	returnMenu rm = new returnMenu();
	returnAdmin ra = new returnAdmin();
	returnCustomer rc = new returnCustomer();

	
	public void menu()
	{
		dispose();
		
		f = new JFrame("Administrator Menu");
		f.setSize(400, 400);
		f.setLocation(200, 200);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) { System.exit(0); }
		});          
		f.setVisible(true);
		
		JPanel deleteCustomerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton deleteCustomer = new JButton("Delete Customer");	
		deleteCustomer.setPreferredSize(new Dimension(250, 20));
		deleteCustomerPanel.add(deleteCustomer);
		
		JPanel deleteAccountPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton deleteAccount = new JButton("Delete Account");
		deleteAccount.setPreferredSize(new Dimension(250, 20));	
		deleteAccountPanel.add(deleteAccount);
		
		JPanel bankChargesPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton bankChargesButton = new JButton("Apply Bank Charges");
		bankChargesButton.setPreferredSize(new Dimension(250, 20));	
		bankChargesPanel.add(bankChargesButton);
		
		JPanel interestPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton interestButton = new JButton("Apply Interest");
		interestPanel.add(interestButton);
		interestButton.setPreferredSize(new Dimension(250, 20));
		
		JPanel editCustomerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton editCustomerButton = new JButton("Edit existing Customer");
		editCustomerPanel.add(editCustomerButton);
		editCustomerButton.setPreferredSize(new Dimension(250, 20));
		
		JPanel navigatePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton navigateButton = new JButton("Navigate Customer Collection");
		navigatePanel.add(navigateButton);
		navigateButton.setPreferredSize(new Dimension(250, 20));
		
		JPanel summaryPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton summaryButton = new JButton("Display Summary Of All Accounts");
		summaryPanel.add(summaryButton);
		summaryButton.setPreferredSize(new Dimension(250, 20));
		
		JPanel accountPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton accountButton = new JButton("Add an Account to a Customer");
		accountPanel.add(accountButton);
		accountButton.setPreferredSize(new Dimension(250, 20));
		
		JPanel returnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton returnButton = new JButton("Exit Admin Menu");
		returnPanel.add(returnButton);

		JLabel label1 = new JLabel("Please select an option");
		
		content = f.getContentPane();
		content.setLayout(new GridLayout(10, 1));
		content.add(label1);
		content.add(accountPanel);
		content.add(bankChargesPanel);
		content.add(interestPanel);
		content.add(editCustomerPanel);
		content.add(navigatePanel);
		content.add(summaryPanel);	
		content.add(deleteCustomerPanel);
		content.add(deleteAccountPanel);
		content.add(returnPanel);
		
//////////////////////////////////////////		
		bankChargesButton.addActionListener(new ActionListener(  ) {
			public void actionPerformed(ActionEvent ae) {
				
				boolean loop = true;
				
				boolean found = false;
				
				//
				if(customerList.isEmpty())
				{
					noCustomer();
				}
				else
				{
			    while(loop)
			    {
			    	//
			    Object customerID = JOptionPane.showInputDialog(f, "Customer ID of Customer You Wish to Apply Charges to:");
			    if(findCustomer(customerID))
			    {
			    	found =true;
			    	loop= false;
			    }
			    
			    if(found == false)
			    {
			    	//
			    	CustomerNotFound();
			    }  
			    else
			    {
			    	f.dispose();
			    	f = new JFrame("Administrator Menu");
					f.setSize(400, 300);
					f.setLocation(200, 200);
					f.addWindowListener(new WindowAdapter() {
						public void windowClosing(WindowEvent we) { System.exit(0); }
					});          
					f.setVisible(true);
				
					//
				    JComboBox<String> box = makeJCB();
					
				    
				    box.getSelectedItem();
				
				    JPanel boxPanel = new JPanel();
					boxPanel.add(box);
					
					JPanel buttonPanel = new JPanel();
					JButton continueButton = new JButton("Apply Charge");
					JButton returnButton = new JButton("Return");
					buttonPanel.add(continueButton);
					buttonPanel.add(returnButton);
					Container content = f.getContentPane();
					content.setLayout(new GridLayout(2, 1));
					
					content.add(boxPanel);
					content.add(buttonPanel);
					
			
						if(customer.getAccounts().isEmpty())
						{
							//
							noAccounts();
						}
						else
						{
							//
						acc = setAccount(box);
										
					continueButton.addActionListener(new ActionListener(  ) {
						public void actionPerformed(ActionEvent ae) {
							String euro = "\u20ac";
						 	
							
							if(acc instanceof CustomerDepositAccount)
							{
							JOptionPane.showMessageDialog(f, "25" + euro + " deposit account fee aplied."  ,"",  JOptionPane.INFORMATION_MESSAGE);
							acc.setBalance(acc.getBalance()-25);
							JOptionPane.showMessageDialog(f, "New balance = " + acc.getBalance() ,"Success!",  JOptionPane.INFORMATION_MESSAGE);
							}

							if(acc instanceof CustomerCurrentAccount)
							{
							
							
							JOptionPane.showMessageDialog(f, "15" + euro + " current account fee aplied."  ,"",  JOptionPane.INFORMATION_MESSAGE);
							acc.setBalance(acc.getBalance()-25);
							JOptionPane.showMessageDialog(f, "New balance = " + acc.getBalance() ,"Success!",  JOptionPane.INFORMATION_MESSAGE);
							}
							
							
							f.dispose();				
						menu();				
						}		
				     });
					//
					returnButton.addActionListener(ra);
						}
			    }
			    }
			    }  
			}		
	     });
		
		interestButton.addActionListener(new ActionListener(  ) {
			public void actionPerformed(ActionEvent ae) {

				boolean loop = true;
				
				boolean found = false;
			
				//
				if(customerList.isEmpty())
				{
					noCustomer();
				}
				else
				{
			    while(loop)
			    {
			    	//
			    Object customerID = JOptionPane.showInputDialog(f, "Customer ID of Customer You Wish to Apply Interest to:");
			    
			    if(findCustomer(customerID))
			    {
			    	found =true;
			    	loop= false;
			    }
			    //
			    if(found == false)
			    {
			    	CustomerNotFound();
			    }    
			    else
			    {
			    	f.dispose();
			    	f = new JFrame("Administrator Menu");
					f.setSize(400, 300);
					f.setLocation(200, 200);
					f.addWindowListener(new WindowAdapter() {
						public void windowClosing(WindowEvent we) { System.exit(0); }
					});          
					f.setVisible(true);
				
				//
				    JComboBox<String> box = makeJCB();
					
				    
				    box.getSelectedItem();
				
				    JPanel boxPanel = new JPanel();
					
					JLabel label = new JLabel("Select an account to apply interest to:");
					boxPanel.add(label);
					boxPanel.add(box);
					JPanel buttonPanel = new JPanel();
					JButton continueButton = new JButton("Apply Interest");
					JButton returnButton = new JButton("Return");
					buttonPanel.add(continueButton);
					buttonPanel.add(returnButton);
					Container content = f.getContentPane();
					content.setLayout(new GridLayout(2, 1));
					
					content.add(boxPanel);
					content.add(buttonPanel);
					
			//
						if(customer.getAccounts().isEmpty())
						{
							noAccounts();
						}
						else
						{
					//	
					acc = setAccount(box);
										
					continueButton.addActionListener(new ActionListener(  ) {
						public void actionPerformed(ActionEvent ae) {
							String euro = "\u20ac";
						 	double interest = 0;
						 	boolean loop = true;
						 	
						 	while(loop)
						 	{
							String interestString = JOptionPane.showInputDialog(f, "Enter interest percentage you wish to apply: \n NOTE: Please enter a numerical value. (with no percentage sign) \n E.g: If you wish to apply 8% interest, enter '8'");//the isNumeric method tests to see if the string entered was numeric. 
							if(isNumeric(interestString))
							{
								
								interest = Double.parseDouble(interestString);
								loop = false;
								
								acc.setBalance(acc.getBalance() + (acc.getBalance() * (interest/100)));
								
								JOptionPane.showMessageDialog(f, interest + "% interest applied. \n new balance = " + acc.getBalance() + euro ,"Success!",  JOptionPane.INFORMATION_MESSAGE);
							}
								
							
							else
							{
								JOptionPane.showMessageDialog(f, "You must enter a numerical value!" ,"Oops!",  JOptionPane.INFORMATION_MESSAGE);
							}
							
							
						 	}
							
							f.dispose();				
						menu();				
						}		
				     });
					//
					returnButton.addActionListener(ra);	
					
						}
			    }
			    }
			    }
			    
			}	
	     });
		
		editCustomerButton.addActionListener(new ActionListener(  ) {
			public void actionPerformed(ActionEvent ae) {
				
				boolean loop = true;
			
				boolean found = false;
			//
				if(customerList.isEmpty())
				{
					noCustomer();
				}
				else
				{
				
			    while(loop)
			    {
			    Object customerID = JOptionPane.showInputDialog(f, "Enter Customer ID:");
			    //
			    if(findCustomer(customerID))
			    {
			    	found =true;
			    	loop= false;
			    }
			    //
			    if(found == false)
			    {
			    	CustomerNotFound();
			    }    
			    else
			    {
			    	loop = false;
			    }
			   
			    }
				
				f.dispose();
				
				f.dispose();
				f = new JFrame("Administrator Menu");
				f.setSize(400, 300);
				f.setLocation(200, 200);
				f.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent we) { System.exit(0); }
				});       
				
				//
				labelTextfield();
				
				JPanel textPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
				JPanel cancelPanel = new JPanel();
				
				textPanel.add(firstNameLabel);
				textPanel.add(firstNameTextField);
				textPanel.add(surnameLabel);
				textPanel.add(surnameTextField);
				textPanel.add(pPPSLabel);
				textPanel.add(pPSTextField);
				textPanel.add(dOBLabel);
				textPanel.add(dOBTextField);
				textPanel.add(customerIDLabel);
				textPanel.add(customerIDTextField);
				textPanel.add(passwordLabel);
				textPanel.add(passwordTextField);

				firstNameTextField.setText(customer.getFirstName());
				surnameTextField.setText(customer.getSurname());
				pPSTextField.setText(customer.getPPS());
				dOBTextField.setText(customer.getDOB());
				customerIDTextField.setText(customer.getCustomerID());
				passwordTextField.setText(customer.getPassword());	
				
				JLabel label1 = new JLabel("Edit customer details below. The save");
				
			
				JButton saveButton = new JButton("Save");
				JButton cancelButton = new JButton("Exit");
				
				cancelPanel.add(cancelButton, BorderLayout.SOUTH);
				cancelPanel.add(saveButton, BorderLayout.SOUTH);
				content.removeAll();
				Container content = f.getContentPane();
				content.setLayout(new GridLayout(2, 1));
				content.add(textPanel, BorderLayout.NORTH);
				content.add(cancelPanel, BorderLayout.SOUTH);
				
				f.setContentPane(content);
				f.setSize(340, 350);
				f.setLocation(200, 200);
				f.setVisible(true);
				f.setResizable(false);
				
				saveButton.addActionListener(new ActionListener(  ) {
					public void actionPerformed(ActionEvent ae) {
					
						customer.setFirstName(firstNameTextField.getText());
						customer.setSurname(surnameTextField.getText());
						customer.setPPS(pPSTextField.getText());
						customer.setDOB(dOBTextField.getText());
						customer.setCustomerID(customerIDTextField.getText());
						customer.setPassword(passwordTextField.getText());		
						
						JOptionPane.showMessageDialog(null, "Changes Saved.");
							}		
					     });
				
				//
				cancelButton.addActionListener(ra);		
				}}
	     });
		
		summaryButton.addActionListener(new ActionListener(  ) {
			public void actionPerformed(ActionEvent ae) {
				f.dispose();
				
				
				f = new JFrame("Summary of Transactions");
				f.setSize(400, 700);
				f.setLocation(200, 200);
				f.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent we) { System.exit(0); }
				});          
				f.setVisible(true);
				
				JLabel label1 = new JLabel("Summary of all transactions: ");
				
				JPanel returnPanel = new JPanel();
				JButton returnButton = new JButton("Return");
				returnPanel.add(returnButton);
				
				JPanel textPanel = new JPanel();
				
				textPanel.setLayout( new BorderLayout() );
				JTextArea textArea = new JTextArea(40, 20);
				textArea.setEditable(false);
				textPanel.add(label1, BorderLayout.NORTH);
				textPanel.add(textArea, BorderLayout.CENTER);
				textPanel.add(returnButton, BorderLayout.SOUTH);
				
				JScrollPane scrollPane = new JScrollPane(textArea);
				textPanel.add(scrollPane);
				
			for (int a = 0; a < customerList.size(); a++)//For each customer, for each account, it displays each transaction.
				{
					for (int b = 0; b < customerList.get(a).getAccounts().size(); b ++ )
					{
						acc = customerList.get(a).getAccounts().get(b);
						for (int c = 0; c < customerList.get(a).getAccounts().get(b).getTransactionList().size(); c++)
						{
							
							textArea.append(acc.getTransactionList().get(c).toString());
							int total = (int) ((AccountTransaction) acc.getTransactionList().get(c)).getAmount(); //I was going to use this to keep a running total but I couldnt get it  working.
							
						}				
					}				
				}
				
				
				
				
				textPanel.add(textArea);
				content.removeAll();
				
				
				Container content = f.getContentPane();
				content.setLayout(new GridLayout(1, 1));
				content.add(textPanel);
				
				returnButton.addActionListener(ra);	
			}	
	     });
		
		navigateButton.addActionListener(new ActionListener(  ) {
			public void actionPerformed(ActionEvent ae) {
				f.dispose();
				
				if(customerList.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "There are currently no customers to display. ");
					menu();
				}
				else
				{
		
				JButton first, previous, next, last, cancel;
				JPanel gridPanel, buttonPanel, cancelPanel;			
	
				Container content = getContentPane();
				
				content.setLayout(new BorderLayout());
				
				buttonPanel = new JPanel();
				gridPanel = new JPanel(new GridLayout(8, 2));
				cancelPanel = new JPanel();
								
				labelTextfield();
				
				first = new JButton("First");
				previous = new JButton("Previous");
				next = new JButton("Next");
				last = new JButton("Last");
				cancel = new JButton("Cancel");
				
				firstNameTextField.setText(customerList.get(0).getFirstName());
				surnameTextField.setText(customerList.get(0).getSurname());
				pPSTextField.setText(customerList.get(0).getPPS());
				dOBTextField.setText(customerList.get(0).getDOB());
				customerIDTextField.setText(customerList.get(0).getCustomerID());
				passwordTextField.setText(customerList.get(0).getPassword());
				
				firstNameTextField.setEditable(false);
				surnameTextField.setEditable(false);
				pPSTextField.setEditable(false);
				dOBTextField.setEditable(false);
				customerIDTextField.setEditable(false);
				passwordTextField.setEditable(false);
				
				gridPanel.add(firstNameLabel);
				gridPanel.add(firstNameTextField);
				gridPanel.add(surnameLabel);
				gridPanel.add(surnameTextField);
				gridPanel.add(pPPSLabel);
				gridPanel.add(pPSTextField);
				gridPanel.add(dOBLabel);
				gridPanel.add(dOBTextField);
				gridPanel.add(customerIDLabel);
				gridPanel.add(customerIDTextField);
				gridPanel.add(passwordLabel);
				gridPanel.add(passwordTextField);
				
				buttonPanel.add(first);
				buttonPanel.add(previous);
				buttonPanel.add(next);
				buttonPanel.add(last);
				
				cancelPanel.add(cancel);
		
				content.add(gridPanel, BorderLayout.NORTH);
				content.add(buttonPanel, BorderLayout.CENTER);
				content.add(cancelPanel, BorderLayout.AFTER_LAST_LINE);
				first.addActionListener(new ActionListener(  ) {
					public void actionPerformed(ActionEvent ae) {
						position = 0;
						navigateCustomer(position);				
							}		
					     });
				//
				previous.addActionListener(new ActionListener(  ) {
					public void actionPerformed(ActionEvent ae) {
								
						if(position < 1)
						{
							//don't do anything
						}
						else
						{
							position = position - 1;
							
						navigateCustomer(position);				
						}			
							}		
					     });
				
				next.addActionListener(new ActionListener(  ) {
					public void actionPerformed(ActionEvent ae) {
					
						if(position == customerList.size()-1)
						{
							//don't do anything
						}
						else
						{
							position = position + 1;
							navigateCustomer(position);				
						}		
						
						
												
							}		
					     });
				
				last.addActionListener(new ActionListener(  ) {
					public void actionPerformed(ActionEvent ae) {
					
						position = customerList.size() - 1;
				
						navigateCustomer(position);									
							}		
					     });
				
				cancel.addActionListener(ra);			
				setContentPane(content);
				setSize(400, 300);
			       setVisible(true);
					}		
			}
		});
		
		accountButton.addActionListener(new ActionListener(  ) {
			public void actionPerformed(ActionEvent ae) {
				f.dispose();
				
				if(customerList.isEmpty())
				{
					noCustomer();
				}
				else
				{
				boolean loop = true;
				
				boolean found = false;
			
			    while(loop)
			    {
			    Object customerID = JOptionPane.showInputDialog(f, "Customer ID of Customer You Wish to Add an Account to:");
			    
			    //
			    if(findCustomer(customerID))
			    {
			    	found =true;
			    	loop= false;
			    }
			    //
			    if(found == false)
			    {
			    	CustomerNotFound();
			    }   
			    else
			    {
			    	loop = false;
			    	//a combo box in an dialog box that asks the admin what type of account they wish to create (deposit/current)
				    String[] choices = { "Current Account", "Deposit Account" };
				    String account = (String) JOptionPane.showInputDialog(null, "Please choose account type",
				        "Account Type", JOptionPane.QUESTION_MESSAGE, null, choices, choices[1]); 
				    
				    if(account.equals("Current Account"))
				    {
				    	//create current account
				    	boolean valid = true;
				    	double balance = 0;
				    	String number = String.valueOf("C" + (customerList.indexOf(customer)+1) * 10 + (customer.getAccounts().size()+1));//this simple algorithm generates the account number
				    	ArrayList<AccountTransaction> transactionList = new ArrayList<AccountTransaction>();
				    	int randomPIN = (int)(Math.random()*9000)+1000;
				           String pin = String.valueOf(randomPIN);
				    
				           ATMCard atm = new ATMCard(randomPIN, valid);
				    	
				    	CustomerCurrentAccount current = new CustomerCurrentAccount(atm, number, balance, transactionList);
				    	
				    	customer.getAccounts().add(current);
				    	JOptionPane.showMessageDialog(f, "Account number = " + number +"\n PIN = " + pin  ,"Account created.",  JOptionPane.INFORMATION_MESSAGE);
				    	
				    	//
				    	ra.actionPerformed(ae);
				    }
				    
				    if(account.equals("Deposit Account"))
				    {
				    	//create deposit account
				    	
				    	double balance = 0, interest = 0;
				    	String number = String.valueOf("D" + (customerList.indexOf(customer)+1) * 10 + (customer.getAccounts().size()+1));//this simple algorithm generates the account number
				    	ArrayList<AccountTransaction> transactionList = new ArrayList<AccountTransaction>();
				        	
				    	CustomerDepositAccount deposit = new CustomerDepositAccount(interest, number, balance, transactionList);
				    	
				    	customer.getAccounts().add(deposit);
				    	JOptionPane.showMessageDialog(f, "Account number = " + number ,"Account created.",  JOptionPane.INFORMATION_MESSAGE);
				    	
				    	ra.actionPerformed(ae);
				    }
			    
			    }			   
			    }
				}
			}
	     });		

		deleteCustomer.addActionListener(new ActionListener(  ) {
			public void actionPerformed(ActionEvent ae) {
				//
				boolean found = false;
						//, loop = true;
				
				if(customerList.isEmpty())
				{
					noCustomer();
				}
				else
				{
					 {
						    Object customerID = JOptionPane.showInputDialog(f, "Customer ID of Customer You Wish to Delete:");
						    
						    //
						    if(findCustomer(customerID))
						    {
						    	found =true;
						    	//loop= false;
						    }
						    //
						    if(found == false)
						    {
						    	CustomerNotFound();
						    } 
						    else
						    {
						    	if(customer.getAccounts().size()>0)
						    	{
						    		JOptionPane.showMessageDialog(f, "This customer has accounts. \n You must delete a customer's accounts before deleting a customer " ,"Oops!",  JOptionPane.INFORMATION_MESSAGE);
						    	}
						    	else
						    	{
						    		customerList.remove(customer);
						    		JOptionPane.showMessageDialog(f, "Customer Deleted " ,"Success.",  JOptionPane.INFORMATION_MESSAGE);
						    	}
						    }
						    
						    
				}}
			}
	     });		

		deleteAccount.addActionListener(new ActionListener(  ) {
			public void actionPerformed(ActionEvent ae) {
				boolean found = false;
						//loop = true;
					 {
						    Object customerID = JOptionPane.showInputDialog(f, "Customer ID of Customer from which you wish to delete an account");
						    
						    if(customerList.isEmpty())
							{
								noCustomer();
							}
						    
						    if(findCustomer(customerID))
						    {
						    	found =true;
						    	//loop= false;
						    }
						    //
						    if(found == false)
						    {
						    	CustomerNotFound();
						    }   
						    else
						    {
						    	//Here I would make the user select a an account to delete from a combo box. If the account had a balance of 0 then it would be deleted. (I do not have time to do this)
						    }
						    
						    
				}}
			
	     });
		//
		returnButton.addActionListener(rm);	
	}
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
	
	public void noCustomer()
	{
	JOptionPane.showMessageDialog(f, "There are no customers yet!"  ,"Oops!",  JOptionPane.INFORMATION_MESSAGE);
	f.dispose();
	menu();
	}

	public void CustomerNotFound()
	{
		    	int reply  = JOptionPane.showConfirmDialog(null, "User Not Found Try again?", "No User", JOptionPane.YES_NO_OPTION);
		    	if (reply == JOptionPane.YES_OPTION) {
		    		
		    	}
		    	else if(reply == JOptionPane.NO_OPTION)
		    	{
		    		f.dispose();
		    		//admin();
		    	}
		    
	}
	
	public void noAccounts()
	{
		JOptionPane.showMessageDialog(f, "This customer has no accounts! \n The admin must add acounts to this customer."   ,"Oops!",  JOptionPane.INFORMATION_MESSAGE);
		f.dispose();
		menu();
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
	
	public CustomerAccount setAccount(JComboBox<String>  jcb)
	{
		CustomerAccount a = null;
		
		for(int i = 0; i < customer.getAccounts().size(); i++)
	    {
	    	if(customer.getAccounts().get(i).getNumber() == jcb.getSelectedItem() )
	    	{
	    		a = customer.getAccounts().get(i);
	    	}
	    }
		return a;
	}
	
	public JComboBox<String> makeJCB()
	{
		JComboBox<String> box = new JComboBox<String>();
	    for (int i =0; i < customer.getAccounts().size(); i++)
	    {
	     box.addItem(customer.getAccounts().get(i).getNumber());
	    }
	    return box;
	}
	
	public void navigateCustomer( int pos)
	{
		firstNameTextField.setText(customerList.get(pos).getFirstName());
		surnameTextField.setText(customerList.get(pos).getSurname());
		pPSTextField.setText(customerList.get(pos).getPPS());
		dOBTextField.setText(customerList.get(pos).getDOB());
		customerIDTextField.setText(customerList.get(pos).getCustomerID());
		passwordTextField.setText(customerList.get(pos).getPassword());
	}
	
	class returnMenu implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			f.dispose();		
//			menuStart();	
		}
	}
	
	class returnAdmin implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			f.dispose();		
			menu();	
		}
	}
		
	class returnCustomer implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			f.dispose();		
			//customer(cus);
		}
	}
	
	public void setCustomerList(ArrayList<Customer> cl)
	{
		customerList = cl;
	}
	
	
	public static boolean isNumeric(String str)  // a method that tests if a string is numeric
	{  
	  try  
	  {  
	    double d = Double.parseDouble(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}
//	public static void main(String[] args)
//	{
//		A
//	}
}
