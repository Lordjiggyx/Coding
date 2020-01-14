

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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

public class MainWindow extends JFrame implements ActionListener{

	private JPanel panel = new JPanel();
	private JButton createStudent = new JButton("Create Student");
	private JButton deleteStudent = new JButton("Delete Student");
	
	private ArrayList<Student> students = new ArrayList<Student>();
	public MainWindow() 
	{

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		panel.add(createStudent);
		panel.add(deleteStudent);
		Container pane = this.getContentPane();
		pane.add(panel);
		
		createStudent.addActionListener(this);
		deleteStudent.addActionListener(this);
	}
	
	

	public ArrayList<Student> getStudents() 
	{
		return students;
	}


	public void setStudents(ArrayList<Student> students) 
	{
		this.students = students;
	}

	public void addStudent(Student student)
	{
		students.add(student);
		
		String studentList = "";
		for(Student tempStudent: students)
		{
			studentList = studentList + tempStudent.getName() +", ";
		}
		JOptionPane.showMessageDialog(this, "Student "+student.getName()+" was added OK. Students are "+studentList);
	}
	
	public void deleteStudent(String name)
	{
		Student studentToDelete = null;
		for(Student student: students)
		{
			if(student.getName().equals(name))
			{
				studentToDelete = student;
			}
		}
		students.remove(studentToDelete);
		JOptionPane.showMessageDialog(this, "Student "+studentToDelete.getName()+" was deleted OK");
	}

	public static void main(String[] args) {
		MainWindow window = new MainWindow();
		window.setSize(200, 200);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Create Student")){
			CreateStudentWindow csw = new CreateStudentWindow(this); 
		}
		else{
			DeleteStudentWindow dsw = new DeleteStudentWindow(this);
		}
		
	}
}
	