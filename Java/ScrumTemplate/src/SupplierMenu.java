import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class SupplierMenu extends JFrame
{

	String password = "3175";
	public SupplierMenu() {
		
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
						SupplierView v = new SupplierView();
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
