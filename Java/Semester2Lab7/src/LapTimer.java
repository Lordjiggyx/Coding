import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class LapTimer extends JFrame implements ActionListener 

{
	JLabel one;
	JLabel two;
	JLabel three;
	JLabel four;
	JPanel p;
	JButton b;
	JButton b1;
	MyTimerThread a;
	Thread realThread;
	JTextArea field1 , field2;

	public LapTimer() 

	{
		float totalSeconds=0.0f;
		float lapSeconds=0.0f;
		one = new JLabel("Lap");
		two = new JLabel("Total Seconds");
		three = new JLabel();
		four = new JLabel();
		
		//field1 = new JTextArea(10, 10);
		
		
		//field2 = new JTextArea(10, 10);
	
	
		p = new JPanel();
		b = new JButton("Start");
		b1 = new JButton("Stop");
		p.add(b);
		p.add(b1);
		p.add(one);
		p.add(two);
		p.add(three);
		p.add(four);
		//p.add(field1);
		//p.add(field2);
		setContentPane(p);
	
		//Must be in the Constructor instead of being created in the buton 
		a = new MyTimerThread(totalSeconds ,this );
		realThread = new Thread(a);

		b.addActionListener(this);
	
		b1.addActionListener(this);
}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand()=="Start"){

			realThread.start();
		}
		else if(e.getActionCommand()=="Stop"){
			a.stop();
		}
		
	}
	public static void main(String[] args)
	{javax.swing.SwingUtilities.invokeLater(new Runnable(){

		@Override
		public void run()
		{
			LapTimer a = new LapTimer();
			a.setVisible(true);
			a.pack();
		}
		});

}
}
