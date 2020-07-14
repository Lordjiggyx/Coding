import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class BookingEntryDialog extends JFrame {
	
	String[] locations = {"Antrim", "Armagh", "Carlow", "Cavan", "Clare", "Cork", "Derry", "Donegal", "Down", "Dublin", "Fermanagh", 
			"Galway", "Kerry", "Kildare", "Kilkenny", "Laois", "Leitrim", "Limerick", "Longford", "Louth", "Mayo", "Meath", 
			"Monaghan", "Offaly", "Roscommon", "Sligo", "Tipperary", "Tyrone", "Waterford", "Westmeath", "Wexford", "Wicklow"
	};
	
	String[] startTimes = {"00.00", "01.00", "02.00", "03.00", "04.00", "05.00", "06.00", "07.00", "08.00", "09.00", "10.00", "11.00", 
			"12.00", "13.00", "14.00", "15.00", "16.00", "17.00", "18.00", "19.00", "20.00", "21.00", "22.00", "23.00" };
	
	private JLabel lblDate, lblStartTime, lblHours, lblAttendance, lblLocation, lblBuilding, lblEmail, lblContact;
	private JTextField txtDate, txtHours, txtAttendance, txtBuilding, txtEmail, txtContact;
	private JComboBox<String> cmbLocation, cmbStartTime;
	private JButton btnAdd;
	private JPanel pnlTop, pnlMiddle, pnlBottom;
	private JTextArea txtArResult;
	
	public BookingEntryDialog() {
		
		super("Add Booking");
		
		Container c = getContentPane();
		
		c.setLayout(new BorderLayout());
		
		pnlTop = new JPanel(new GridLayout(8, 2));
		lblDate = new JLabel("Date (format Month Day)");
		txtDate = new JTextField(15);
		pnlTop.add(lblDate);
		pnlTop.add(txtDate);
		lblStartTime = new JLabel("Choose start time");
		cmbStartTime = new JComboBox<String>(startTimes);
		pnlTop.add(lblStartTime);
		pnlTop.add(cmbStartTime);
		lblHours = new JLabel("Number of hours");
		txtHours = new JTextField(15);
		pnlTop.add(lblHours);
		pnlTop.add(txtHours);
		lblAttendance = new JLabel("Expected attendance");
		txtAttendance = new JTextField(15);
		pnlTop.add(lblAttendance);
		pnlTop.add(txtAttendance);
		lblLocation = new JLabel("Location");
		cmbLocation = new JComboBox<String>(locations);
		pnlTop.add(lblLocation);
		pnlTop.add(cmbLocation);
		lblBuilding = new JLabel("Building");
		txtBuilding = new JTextField(15);
		pnlTop.add(lblBuilding);
		pnlTop.add(txtBuilding);
		lblEmail = new JLabel("Email address");
		txtEmail = new JTextField(15);
		pnlTop.add(lblEmail);
		pnlTop.add(txtEmail);
		lblContact = new JLabel("Contact number");
		txtContact = new JTextField(15);
		pnlTop.add(lblContact);
		pnlTop.add(txtContact);
		c.add(pnlTop, BorderLayout.NORTH);
		pnlMiddle = new JPanel(new FlowLayout());
		btnAdd = new JButton("Add booking");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sample = "Date, " + txtDate.getText() + ", Time, " + cmbStartTime.getSelectedIndex() +  ", Hours, " + txtHours.getText() + 
						", Attendance, " + txtAttendance.getText() + ", Location, " + cmbLocation.getSelectedItem() + ", Building, " + txtBuilding.getText() 
						+ ", Contact, " + txtEmail.getText() + ", Phone, " + txtContact.getText();
				BookingClient bc = new BookingClient(BookingEntryDialog.this, sample);
			}
		});
		pnlMiddle.add(btnAdd);
		c.add(pnlMiddle, BorderLayout.CENTER);
		pnlBottom = new JPanel();
		txtArResult = new JTextArea(10, 50);
		txtArResult.setEditable(false);
		pnlBottom.add(txtArResult);
		c.add(pnlBottom, BorderLayout.SOUTH);
	}
	
	public void displayResult(String output) {
		txtArResult.setText("");
		txtArResult.setText(output);
	}
	
	public static void main(String[] args) {
		
		BookingEntryDialog bed = new BookingEntryDialog();
		bed.pack();
		bed.setVisible(true);

	}
	
}