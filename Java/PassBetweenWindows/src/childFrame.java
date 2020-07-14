import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class childFrame extends JFrame
{
	private JPanel contentPane , display;
	private JLabel  lbl;
	private JButton bt;
	private JTextField a;
	ActionListener parentGUI;
	
	
	
	public childFrame(ActionListener actionListener)
	{
		parentGUI = actionListener;
		lbl = new JLabel("My Label");
		bt = new JButton("Click Me");
		a = new JTextField(10);
		display = new JPanel();
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		
		//Must BE INCLUDED TO ADD TO THE JFRAME ITSELF

		
				contentPane.add(display);
				display.add(lbl);
				display.add(bt);
				display.add(a);
				
				this.add(contentPane);
				setVisible(true);
				setSize(500,500);
	}
	


		
	}

