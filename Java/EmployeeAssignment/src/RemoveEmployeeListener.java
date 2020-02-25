

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class RemoveEmployeeListener implements ActionListener
{

	JButton btn2 = new JButton();
	MyTableModel tm2;
	JTable MyTableModel2;
		
	//setting both buttons to be the same
	public RemoveEmployeeListener(JButton btnDelete ,JTable MyTableModel ,MyTableModel tm )
	{
		btn2 = btnDelete;
		MyTableModel2 = MyTableModel;
		tm2 = tm;
	
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
	
		if(MyTableModel2.getSelectedRow() == -1)
		{
			int result = JOptionPane.showConfirmDialog(null, "No Row Selected , Last Row Will Be Deleted.\n Are you sure you want to do this?" );
			if (result == JOptionPane.YES_OPTION)
			{
				tm2.deleteRow(MyTableModel2.getRowCount()-1);
			}
			if (result == JOptionPane.NO_OPTION)
			{

				JOptionPane.showMessageDialog(null, "No Row Will Be Deleted");;
			}
			if (result == JOptionPane.CANCEL_OPTION)
			{

				JOptionPane.showMessageDialog(null, "No Row Will Be Deleted");
			}
			
		}
		else
		{
			tm2.deleteRow(MyTableModel2.getSelectedRow());
		}
		}
		
		}



