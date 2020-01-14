import javax.swing.JFrame;
//Importing needed packages
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
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

public class ImageTest extends JFrame implements ActionListener
{
	private JPanel contentPane , Panel1, Panel2 ;
	private JButton button , button2 , button3;
	private JTextArea txt;
	
public ImageTest()
{
this.setTitle("Image testing");
contentPane = new JPanel();
button = new JButton("Display image");
button.addActionListener(this);

button2 = new JButton("Clear Text");
button2.addActionListener(this);

button3 = new JButton("Finish");
button3.addActionListener(this);

Panel1 = new JPanel();
Panel2 = new JPanel();

txt = new JTextArea();
txt.setRows(40);
txt.setColumns(20);

contentPane.setLayout(new BorderLayout());

add(contentPane);

contentPane.add(Panel1 , BorderLayout.CENTER);
contentPane.add(Panel2 , BorderLayout.SOUTH);

Panel1.add(txt);
Panel1.add(button);

Panel2.add(button2);
Panel2.add(button3);

button.addActionListener(new ActionListener()	
		{
	public void actionPerformed(ActionEvent e)
	{
		JFrame frame = new JFrame("Dialogue");
		JOptionPane.showMessageDialog(frame, new ImageIcon("Z:/ADS1/Images/src/Doggo.jfif"));
	}
		}
	);


button2.addActionListener(new ActionListener()	
{
public void actionPerformed(ActionEvent e)
{
	txt.setText(" ");
}
}
);


button3.addActionListener(new ActionListener()	
{
public void actionPerformed(ActionEvent e)
{
	setVisible(false); 
	dispose();
}
}
);
	
}



public static void main (String[] args){
	ImageTest a= new ImageTest();
	a.setSize(400 , 400);
	a.setVisible(true);
}





@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}
	
}
