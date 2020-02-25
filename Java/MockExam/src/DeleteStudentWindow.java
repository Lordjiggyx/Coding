

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class DeleteStudentWindow extends JFrame implements ActionListener{
	
	private JPanel panel = new JPanel();
	private JLabel namelabel = new JLabel("Name:");
	private JTextField name = new JTextField(20);
	
	private JButton deleteStudent = new JButton("Delete Student");
	private MainWindow parent;
	
	public DeleteStudentWindow(MainWindow window) {
		parent = window;
		this.setSize(300, 200);
		this.setLocationRelativeTo(null);
		panel.add(namelabel);
		panel.add(name);
		panel.add(deleteStudent);
		deleteStudent.addActionListener(this);
		Container pane = this.getContentPane();
		pane.add(panel);
		
		this.setVisible(true);
		
		
		
	
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String studentName = name.getText();
		parent.deleteStudent(studentName);
		
	}

	
	

}