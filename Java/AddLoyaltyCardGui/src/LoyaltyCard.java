//Importing needed packages
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;


//Declaration of the class itself using Calling the use of A JFrame and An Action Listener
public class LoyaltyCard extends JFrame implements ActionListener
{
	//Declartions of Gui components E.g panel menu label buttons etc...
	private JPanel contentPane ,existingCustomer , panelButtons , panelSelectCustomer , panelRadioButtons, panelAddLoyaltyCard , panelTextArea;
	private JLabel labelSelectCustomer;
	private JButton addCard , Clear , Finish;
	private JRadioButton Value1, Value2, Value3;
	private JTextArea txt;
	TitledBorder borderTitled;
	BevelBorder borderBevel;
	
	//Creation of the constructor must have same name of the class
	public LoyaltyCard()
	{
		//Sets the title of the frame itself
		this.setTitle("Loyalty Card Demo");
		//For the "X" button in the top right corner to allow closure
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 300);
		//I personally use this panel as the main panel to which i add all other panels to the add this panel to the frame
		contentPane = new JPanel();
		//Panels for the question
		existingCustomer = new JPanel();
		panelButtons = new JPanel();
		panelSelectCustomer = new JPanel();
		panelRadioButtons = new JPanel();
		panelAddLoyaltyCard = new JPanel();
		panelTextArea = new JPanel();
		//Label for question
		labelSelectCustomer = new JLabel("Select Customer");
		//text area
		txt = new JTextArea();
		//Buttons for the question
		//*Note that each button must have an action listener attached to it
		addCard= new JButton("Add Loyalty Card");
		addCard.addActionListener(this);
		
		Clear =new JButton("Clear All");
		Clear.addActionListener(this);
		
		Finish =new JButton("Finish");
		Finish.addActionListener(this);
		//This is how radio buttons are implemented
		//The button group is what makes the buttons mutually exclusive to one another
		final ButtonGroup group = new ButtonGroup();
		
		//Each RadioButton must be added to the group
		//Each RadioButton must be given an action command to allow it to be the only button selected
		Value1 = new JRadioButton("Sliver");
		Value1.setActionCommand("Sliver");
		group.add(Value1);
		
		Value2 =  new JRadioButton("Golden");
		Value2.setActionCommand("Golden");
		group.add(Value2);
		
		Value3 =  new JRadioButton("Platinum");
		Value3.setActionCommand("Platinum");
		group.add(Value3);
			
	
		//ComboBoxs are based on Arrays 
		//The type of Array must be declared first an the name of the array
		//in this context we are using a String array
		String[] People = {"John" , "Jane" , "Lilly", "Mark", "Peter"};
		 JComboBox<String> comboBox = new JComboBox<String>(People);
		 //Dunno what this means ;)
		 comboBox.setEditable(true);
		 //Sets the selected index of the combobox
		 comboBox.setSelectedIndex(2);
		
		 
		 //First the menu is declared and given an name like any other component
		JMenu option = new JMenu ("Menu");
		
		//This is how to add a click-able option to the menu it is declared as a JMenuItem
		JMenuItem view = new JMenuItem("View");
		//It is then given an action listener 
		view.addActionListener(this);
		//It is then added to the menu
		option.add(view);
		
		//Same Follows
		JMenuItem exit = new JMenuItem("exit");
		exit.addActionListener(this);
		option.add(exit);
		
		//The menu is then added to a bar which is where the menu will appear
		//The JmenuBar is declared the same as any other component
		JMenuBar bar = new JMenuBar();
		//The menu is then added to the bar
		bar.add(option);
		
		
		//MOST IMPORTANT PART- The menu Bar is then added to the JFrame
		setJMenuBar(bar);
		
		//This is to get the dialogue to pop up
		//Same treatment as a button 
		view.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent e)

		{
			//Declaration for the new Frame being called
			JFrame frame = new JFrame("Dialogue");
			//I just know that this should be filled with the frame and whatever information you wish to display in this case the info in the textarea
			JOptionPane.showMessageDialog(frame, txt.getText());
		}
	
		}
		);
	
		//Same treatment as a button
		exit.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) 
		{
			//The code used to close any window
			setVisible(false); 
			dispose();
		}
	
		}
		);
			
	
		//Declaration of the bevel border and the title border
		borderBevel = new BevelBorder(BevelBorder.LOWERED);
		borderTitled = new TitledBorder(borderBevel,"Existing Customer");
		
		//Sets the layout of the frame
		this.setLayout(new BorderLayout());
		//Sets the border of the frame to what is wanted e.g bordertTitled 
		existingCustomer.setBorder(borderTitled);
		//Sets the Layout to Grid Layout
		existingCustomer.setLayout(new GridLayout(4, 1));
		//Sets the Layout of the panel 
		contentPane.setLayout(new BorderLayout());
		//Sets the size of the text area
		txt.setRows(40);
		txt.setColumns(20);
		
		

		
		
		//Level 1 - Add content Pane to Frame
		add(contentPane);
		//Level 2 - Add two main panels to the content pane
		contentPane.add(existingCustomer ,BorderLayout.CENTER) ;
		contentPane.add(panelButtons , BorderLayout.SOUTH);
		//Level 3 - Add Sub-Panels to the 1st main panel
		existingCustomer.add(panelSelectCustomer);
		existingCustomer.add(panelRadioButtons);
		existingCustomer.add(panelAddLoyaltyCard);
		existingCustomer.add(panelTextArea);
		//Level 3 - Add Buttons to panel
		panelButtons.add(Clear);
		panelButtons.add(Finish);			
		//Level 3.1 - Add Label and combobox to the panel
		panelSelectCustomer.add(labelSelectCustomer);
		panelSelectCustomer.add(comboBox);
		//Level 3.2 - Add RadioButtons to the panel
		panelRadioButtons.add(Value1);
		panelRadioButtons.add(Value2);
		panelRadioButtons.add(Value3);
		//Level 3.3 - Add the button to the panel
		panelAddLoyaltyCard.add(addCard);
		//Level 3.4 - Add thetextArea to the panel
		panelTextArea.add(txt);
		
		
		//You the drill with the buttons by now
		addCard.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//Sets text to item selected in the combobox
				txt.setText((String) comboBox.getSelectedItem() + "\n");
				//Gets the selected item from the radio buttons
				txt.append("New Card:"  + group.getSelection().getActionCommand());
			}
		}
		);
		
		Clear.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//Clears text
				txt.setText(" ");
			}
		}
		);
		
		Finish.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//Closes window
				setVisible(false); 
				dispose();
			}
		}
		);
			//This brace closes the method body
	}

		
	//IMPORTANT FOR EMMA  THERE IS A ");" AT THE END OF EVERY BUTTON FUNCTION
	//THERE SHOULD BE ONLY TWO SETS OF BRACES 
	
	//Calls appliction into functionality
	public static void main (String[] args){
		LoyaltyCard a= new LoyaltyCard();
		a.setSize(400 , 400);
		a.setVisible(true);
	}




//Dunno
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	


}