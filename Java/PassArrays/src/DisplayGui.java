import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;


public class DisplayGui extends JFrame implements ActionListener{

	private JLabel title;
	private JButton button;
	private JPanel contentPane;
	
	
	public DisplayGui(ArrayList<String> customerList)
	{
		
		this.setTitle("Customer display");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 300); 
		title = new JLabel ("List of Customers");
		button = new JButton ("Return");
		button.addActionListener(this);
		contentPane = new JPanel();
		contentPane.setLayout(new FlowLayout());
		
		Object[] customers = (customerList.toArray());
		 JComboBox<Object> comboBox = new JComboBox<Object>(customers);
		 comboBox.setEditable(true);
		 
		 //final JList<String> list = new JList<String>(comboBox.getModel());
		 
		 
		 
		this.add(contentPane);
		contentPane.add(title);
		contentPane.add(button);
		contentPane.add(comboBox);
		
		setSize(400 , 200);
		setVisible(true);
	


	button.addActionListener(new ActionListener()
			{
	public void actionPerformed(ActionEvent e) 
	{
		setVisible(false); 
		dispose();	
	}
});

}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}

	


