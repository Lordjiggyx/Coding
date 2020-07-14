import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class customerMenu extends JFrame
{

String password = "3175";
	public customerMenu() {
		
		{
			getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
			
			JButton btnNewButton_1 = new JButton("Edit Records");
			btnNewButton_1.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e) 
				{
					if(getPassword() == false)
					{
						
					}
					else
					{
						JOptionPane.showMessageDialog(null , "Correct Password");
						View v = new View();
					}
					
					
					
				}
			});
			getContentPane().add(btnNewButton_1);
			
			
			JButton btnNewButton_3 = new JButton("RETURN");
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) 
				{
					setVisible(false);
					
					
				}
			});
			
			JButton btnMakeOrder = new JButton("Make Order");
			btnMakeOrder.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) 
				{
					MakeOrderGui m = new MakeOrderGui();

				}
			});
			getContentPane().add(btnMakeOrder);
			getContentPane().add(btnNewButton_3);
	}
		
		setTitle("Menu");
		setSize(500,500);
		setVisible(true);
}
	public boolean getPassword()
	{
		JPasswordField A = new JPasswordField();
		int b = JOptionPane.showOptionDialog(this, new Object[] {A}, "Enter Password", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null , null);
		if (b == JOptionPane.YES_OPTION)
		{
			if(new String(A.getPassword()).equals(password))
			{
				return true;
			}
			else if (!new String(A.getPassword()).equals(password))
			{
				JOptionPane.showMessageDialog(this, "Wrong password");
			}
			return false;
		}
		else
			return false;
	}




}
