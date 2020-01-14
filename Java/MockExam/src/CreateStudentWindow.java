

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

public class CreateStudentWindow extends JFrame {
	
	private JPanel panel = new JPanel();
	private JLabel namelabel = new JLabel("Name:");
	private JTextField name = new JTextField(20);
	private JLabel numberlabel = new JLabel("Student Number:");
	private JTextField number = new JTextField(20);
	private JLabel agelabel = new JLabel("Age:");
	private JTextField age = new JTextField(20);
	private JButton createStudent = new JButton("Create Student");
	private MainWindow parent;
	
	public CreateStudentWindow(MainWindow window) {
		parent = window;
		this.setSize(300, 200);
		this.setLocationRelativeTo(null);
		panel.add(namelabel);
		panel.add(name);
		panel.add(numberlabel);
		panel.add(number);
		panel.add(agelabel);
		panel.add(age);
		panel.add(createStudent);
		
		Container pane = this.getContentPane();
		pane.add(panel);
		
		this.setVisible(true);
		
		createStudent.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {

			Student student = new Student(name.getText(), number.getText(), Integer.parseInt(age.getText()));
			window.addStudent(student);
			
			}
			
		});
		
	
		
	}

	
	

}