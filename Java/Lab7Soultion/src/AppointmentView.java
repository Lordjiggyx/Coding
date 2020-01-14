

import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.swing.*;

public class AppointmentView extends JFrame {

	JTextArea detailsTextArea;
	JScrollPane scroller;
	JPanel bottomPanel;
	JButton closeButton;

	public AppointmentView(ArrayList <Appointment>aptsList) {

		super("Summary of Appointments");
		detailsTextArea = new JTextArea(10, 50);
		scroller = new JScrollPane(detailsTextArea);

		setLayout(new BorderLayout());

		String detailsString = "";
		
		detailsString = detailsString + "Date:\t Time:\tPatient Name\tDoctor\n";
		
		for (Appointment apt : aptsList) {
			
			// Print a new line for each appointment

		    detailsString = detailsString + apt.getDate()+ "\t" + apt.getTime() + "\t" + apt.getPatient().name + " " + apt.getPatient().surname + "\t" + apt.getDoctor() + "\n";
 			
		}
		

		detailsTextArea.append(detailsString);
		detailsTextArea.setEditable(false);

		add(scroller, BorderLayout.NORTH);

		bottomPanel = new JPanel();

		closeButton = new JButton("Close");
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		bottomPanel.add(closeButton);
		add(bottomPanel, BorderLayout.CENTER);

		setVisible(true);
		setSize(400, 500);
	}
}

