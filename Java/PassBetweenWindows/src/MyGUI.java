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

public class MyGUI extends JFrame implements ActionListener

{
	private JPanel contentPane , display;
	private JLabel  lbl;
	private JButton b;
	private JTextArea a;



public MyGUI()
{
	this.setTitle("Passing Information Between");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 550, 300);
	
	contentPane = new JPanel();
	lbl = new JLabel("My Label");
	b = new JButton("My Button");
	a = new JTextArea(10 , 12);
	display = new JPanel();
	contentPane.setLayout(new BorderLayout());
	
	//Must BE INCLUDED TO ADD TO THE JFRAME ITSELF

	
			contentPane.add(display);
			display.add(lbl);
			display.add(b);
			display.add(a);
			
			this.add(contentPane);
			
			b.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent arg0)
				{
					childFrame c = new childFrame(this);
				}
					}
			);


}


	
	
	

public static void main(String[] args) 
{
	MyGUI ab = new MyGUI();
	ab.setVisible(true);
}







public void actionPerformed1(ActionEvent e) {
	// TODO Auto-generated method stub
	
}






@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}
}







				
		
			
	








