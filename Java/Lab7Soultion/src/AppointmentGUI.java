
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.DateFormatter;

public class AppointmentGUI extends JFrame {
	   private JLabel lblLogo, lblFName, lblSName, lblDOB, lblDr, lblStartDate, lblStartTime, lblDuration, lblFinishTime;
	   private JTextField txtFName, txtSName, txtDOB, txtFinish;
	   private JComboBox<String> comboDoctors; 
	   private JSpinner spinnerDate, spinnerTime, spinnerDuration;
	   private SpinnerDateModel modelDate, modelTime;
	   private SpinnerNumberModel modelDuration;
	   private JSpinner.DateEditor editorDate, editorTime;
	   private JButton btnAdd, btnView;
	   private Calendar calendar;
	   private DateFormatter formatter;
	   private int initial=0, min=0, max=60, increment=5;
	   private ActionListener addAL, viewAL;
	   private ChangeListener CL;
	   private ArrayList <Appointment>arrAppointments = new ArrayList<Appointment>();
	   private JPanel pnlDisplay,pnlInput, pnlBtns;
	   private String[] doctor = { "Dr. Smith", "Dr. Jones", "Dr. Phil" };
	   

	   public AppointmentGUI() {
		   this.setTitle("Create Appointment");
		   this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		   createSpinners();
		   createGUI();
		   createActionListeners();

	   }
	   
	   
	   public void createGUI() {
		//create components and to containers
		   Icon logo = new ImageIcon("logo.jpg");
	       lblLogo = new JLabel(logo);
	       lblLogo.setToolTipText("Company Logo");
		   
		   lblFName = new JLabel("First Name:");
		   lblSName = new JLabel("Surname:");
		   lblDOB = new JLabel("DOB:");
		   lblDr = new JLabel("Doctor:");
		   lblStartDate = new JLabel("Date:");
		   lblStartTime = new JLabel("Time:");
		   lblDuration = new JLabel("Duration:");
		   lblFinishTime = new JLabel("Appointment ends at:");

			   
		   txtFName = new JTextField(5);
		   txtSName  = new JTextField(5);
		   txtDOB= new JTextField(5);
		   comboDoctors = new JComboBox<String>(doctor);
		   txtFinish = new JTextField(5);
		   txtFinish.setEditable(false);
 
		   btnAdd = new JButton("Add");
		  

		   btnView = new JButton("View");
		   //btnView.addActionListener(viewAL);
		   
		   pnlDisplay = new JPanel();
		   pnlDisplay.add(lblLogo);
		   
		   pnlInput = new JPanel(new GridLayout(8, 0));
		   pnlInput.add(lblFName);
		   pnlInput.add(txtFName);
		   pnlInput.add(lblSName);
		   pnlInput.add(txtSName);
		   pnlInput.add(lblDOB);
		   pnlInput.add(txtDOB);
		   pnlInput.add(lblDr);
		   pnlInput.add(comboDoctors);
		   pnlInput.add(lblStartDate);
		   pnlInput.add(spinnerDate);
		   pnlInput.add(lblStartTime);
		   pnlInput.add(spinnerTime);
		   pnlInput.add(lblDuration);
		   pnlInput.add(spinnerDuration);
		   pnlInput.add(lblFinishTime);
		   pnlInput.add(txtFinish);
		   
		   pnlBtns = new JPanel();
		   pnlBtns.add(btnAdd);
		   pnlBtns.add(btnView);
		   add(pnlDisplay, BorderLayout.NORTH);
		   add(pnlInput, BorderLayout.CENTER);
		   add(pnlBtns, BorderLayout.SOUTH);
		   


    	}
	   
	   public void createSpinners() {
		   
		   modelDuration = 
					new SpinnerNumberModel(initial, min, max, increment);
			spinnerDuration = new JSpinner(modelDuration);

		    //calendar = Calendar.getInstance();
		    
		    Date today = new Date();

	        modelDate = new SpinnerDateModel();
	        modelDate.setValue(today);
	        
	        modelTime = new SpinnerDateModel();
	        modelTime.setValue(today);

	        spinnerDate = new JSpinner(modelDate);
	        spinnerTime = new JSpinner(modelTime);

	        editorTime = new JSpinner.DateEditor(spinnerTime, "HH:mm");
	        formatter = (DateFormatter)editorTime.getTextField().getFormatter();

	        spinnerTime.setEditor(editorTime);
	        
	        editorDate = new JSpinner.DateEditor(spinnerDate, "dd/MM/yyyy");
			//Date Editor
		   spinnerDate.setEditor(editorDate);
	   }
	   
	   public void createActionListeners()
	   {
		   addAL = new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// No previous if at beginning of list
					
					if (e.getActionCommand() == "Add"){
						if(txtFName.getText().isEmpty() || txtSName.getText().isEmpty() || txtDOB.getText().isEmpty())
							JOptionPane.showMessageDialog(null, "All fields must be completed.", 
									"Empty Message", JOptionPane.INFORMATION_MESSAGE);
						else
							createAppointment();

					}
				}
			};
			
			   viewAL = new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// No previous if at beginning of list
						
						if (e.getActionCommand() == "View")
						{
							if(arrAppointments.size() == 0)
								JOptionPane.showMessageDialog(null, "There are no appointments added");
							else
								new AppointmentView(arrAppointments);
								
						}

					}
				};
				
			CL = new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
				int duration = Integer.parseInt(((SpinnerNumberModel)e.getSource()).getValue().toString());

				Date date = modelTime.getDate();
				 
	            Calendar calendar = Calendar.getInstance();
	            calendar.setTime(date);
	            calendar.add(Calendar.MINUTE, duration);
	    		SimpleDateFormat sdfDate = new SimpleDateFormat("kk:mm");
	    		String strDate = sdfDate.format(calendar.getTime());
	            txtFinish.setText("Appointment ends at: "  + strDate);
				
				}

		    };

			
			btnAdd.addActionListener(addAL);
			btnView.addActionListener(viewAL);
			modelDuration.addChangeListener(CL);
		   
	   }
	  
	   public void createAppointment()
	   {
		   //Create a patient object
		   Patient p = new Patient(txtFName.getText(), txtSName.getText(), txtDOB.getText());
		   String doctor = comboDoctors.getSelectedItem().toString();
		   SimpleDateFormat formatDate = new SimpleDateFormat("yyyy/MM/dd");
		   String spinnerDate = formatDate.format(modelDate.getValue());
		   
		   SimpleDateFormat formatTime = new SimpleDateFormat("hh:mm");
		   String spinnerTime = formatTime.format(modelTime.getValue());
		   

		   int duration = Integer.parseInt(modelDuration.getValue().toString());
		   //Create an appointment
		   Appointment apt = new Appointment(p,spinnerDate, doctor, spinnerTime, duration);
		   arrAppointments.add(apt);
		   JOptionPane.showMessageDialog(null, "Appointment created for patient:" + p.name + " " + p.surname);
		   
	   }
	    public static void main(String []args)
	    {
	    	AppointmentGUI gui = new AppointmentGUI();
	    	gui.setSize(400, 500);
	    	gui.setVisible(true);
	    }


		public ArrayList <Appointment> getArrAppointments() {
			return arrAppointments;
		}


		public void setArrAppointments(ArrayList <Appointment> arrAppointments) {
			this.arrAppointments = arrAppointments;
		}

}

