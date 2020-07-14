import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;



import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import java.util.ArrayList;

public class checkBoxExample extends JFrame implements ActionListener
{

	private JPanel pnlchkBoxes , pnlDisplay , contentPane;
	private JCheckBox  chkAmericano, chkLatte , chkCappuccino ;
	private JLabel  lblOrder;
	private JTextArea txtOrder;
	
	
	public checkBoxExample()
	{
		this.setTitle("Check Box Demo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 300);
		
		contentPane = new JPanel();
		pnlchkBoxes  = new JPanel();
		pnlDisplay = new JPanel();
		chkAmericano = new JCheckBox("Americano");
		chkLatte  = new JCheckBox("Latte");
		chkCappuccino = new JCheckBox("Cappuccino");
		lblOrder = new JLabel("Your order is:");
		txtOrder = new JTextArea();
		contentPane.setLayout(new BorderLayout());
		txtOrder.setRows(10);
		txtOrder.setColumns(20);
		txtOrder.setEditable(false);
		//Must BE INCLUDED TO ADD TO THE JFRAME ITSELF
		this.add(contentPane);/////////////////////////
		///////////////////////////////////////////////
		
		
		//level 1
		contentPane.add(pnlDisplay , BorderLayout.CENTER);
		contentPane.add(pnlchkBoxes , BorderLayout.NORTH);
		//level 2 
		pnlDisplay.add(lblOrder);
		pnlDisplay.add(txtOrder);
		pnlchkBoxes.add(chkAmericano);
		pnlchkBoxes.add(chkCappuccino);
		pnlchkBoxes.add(chkLatte);
		
		chkAmericano.addActionListener(this);
		chkCappuccino.addActionListener(this);
		chkLatte.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		if (chkAmericano.isSelected())
		{
			txtOrder.setText("Americano");
		}
		if (chkCappuccino.isSelected())
		{
			txtOrder.setText("Cappuccino");
		}
		if (chkLatte.isSelected())
		{
			txtOrder.setText("Latte");
		}
		if (chkAmericano.isSelected() && chkCappuccino.isSelected() )
		{
			txtOrder.setText("Americano" + "\n" + "Cappucino");
		}
		if (chkCappuccino.isSelected() && chkLatte.isSelected())
		{
			txtOrder.setText("Cappucino" + "\n" + "Latte");
		}
		
		if (chkCappuccino.isSelected() && chkLatte.isSelected() && chkAmericano.isSelected())
		{
			txtOrder.setText("Cappucino" + "\n" + "Latte"+ "\n" + "Americano");
		}
		
	}
	public static void main(String[] args) 
	{
		checkBoxExample checkBoxExample = new checkBoxExample();
		checkBoxExample.setVisible(true);
	}

}
