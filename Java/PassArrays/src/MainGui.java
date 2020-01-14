import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class MainGui extends JFrame implements ActionListener
{
	private JPanel window;
	private JButton Create , Display;
	ArrayList <String> customerList = new ArrayList();;
	
	public MainGui()
	{
		this.setTitle("Main Window");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 300); 
		
		window = new JPanel();
		Create = new JButton("Create Customers");
		Display = new JButton("Display Customers");
		
		this.add(window);
		window.add(Create);
		window.add(Display);
		
		Create.addActionListener(this);
		Display.addActionListener(this);
		
	}
public static void main (String[] args){
	MainGui main = new MainGui();
	main.setSize(400 , 200);
	main.setVisible(true);
}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Create)
		{
			CreateGui customerGui = new CreateGui(customerList);
		}
		else if (e.getSource() == Display)
		{
			DisplayGui display = new DisplayGui(customerList);
		}
	}
}
