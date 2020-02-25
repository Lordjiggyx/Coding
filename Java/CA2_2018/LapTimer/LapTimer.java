package LapTimer;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class LapTimer extends JFrame {

	private Font counterFont = new Font("Arial", Font.BOLD, 20);
	private Font totalFont = new Font("Arial", Font.PLAIN, 14);

	private JLabel lapLabel = new JLabel("Seconds running:");
	private JTextField lapField = new JTextField(15);
	private JLabel totalLabel = new JLabel("Total seconds:");
	private JTextField totalField = new JTextField(15);

	private String datafile;
	private File currentFile;
	private JButton startButton = new JButton("START");
	private JButton lapButton = new JButton("LAP");
	private JButton stopButton = new JButton("STOP");

	// The text area and the scroll pane in which it resides
	private JTextArea display;

	private JScrollPane myPane;

	// These represent the menus
	private JMenuItem saveData = new JMenuItem("Save data", KeyEvent.VK_S);
	private JMenuItem displayData = new JMenuItem("Display data", KeyEvent.VK_D);
	
	private JMenu options = new JMenu("Options");

	private JMenuBar menuBar = new JMenuBar();

	private boolean started;

	private float totalSeconds = (float)0.0;
	private float lapSeconds = (float)0.0;

	private int lapCounter = 1;

	private LapTimerThread lapThread;
	private Thread Thread;

	private Session currentSession;
	
	private final JLabel lblLapTimeGoal = new JLabel("Lap time goal:");
	private final JTextField goalTextField = new JTextField();
	private final JPanel SetTimePanel = new JPanel();
	private final JLabel lblSeconds = new JLabel("seconds");
	
	private String[] goal_message = {"GOAL REACHED", "GOAL NOT REACHED"};


	public LapTimer() {

		setTitle("Lap Timer Application");

		MigLayout layout = new MigLayout("fillx");
		JPanel panel = new JPanel(layout);
		getContentPane().add(panel);

		options.add(saveData);
		options.add(displayData);
		menuBar.add(options);

		this.setJMenuBar(menuBar);

		MigLayout centralLayout = new MigLayout("fillx");

		JPanel centralPanel = new JPanel(centralLayout);

		GridLayout timeLayout = new GridLayout(0,2);

		JPanel timePanel = new JPanel(timeLayout);

		lapField.setEditable(false);
		lapField.setFont(counterFont);
		lapField.setText("00:00:00.0");

		totalField.setEditable(false);
		totalField.setFont(totalFont);
		totalField.setText("00:00:00.0");
		timePanel.add(lblLapTimeGoal);
		
		timePanel.add(SetTimePanel);
		goalTextField.setText("60");
		goalTextField.setColumns(10);
		SetTimePanel.add(goalTextField);
		SetTimePanel.add(lblSeconds);

		// Setting the alignments of the components
		lblLapTimeGoal.setHorizontalAlignment(SwingConstants.RIGHT);
		goalTextField.setHorizontalAlignment(SwingConstants.CENTER);
		totalLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lapLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lapField.setHorizontalAlignment(JTextField.CENTER);
		totalField.setHorizontalAlignment(JTextField.CENTER);

		timePanel.add(lapLabel);
		timePanel.add(lapField);
		timePanel.add(totalLabel);
		timePanel.add(totalField);

		centralPanel.add(timePanel, "wrap");

		GridLayout buttonLayout = new GridLayout(1, 3);

		JPanel buttonPanel = new JPanel(buttonLayout);

		buttonPanel.add(startButton);
		buttonPanel.add(lapButton);
		buttonPanel.add(stopButton);

		centralPanel.add(buttonPanel, "spanx, growx, wrap");

		panel.add(centralPanel, "wrap");

		display = new JTextArea(100,150);
		display.setMargin(new Insets(5,5,5,5));
		display.setEditable(false);
		myPane = new JScrollPane(display, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panel.add(myPane, "alignybottom, h 100:320, wrap");


		// Initial state of system
		started = false;
		currentSession = new Session();

		// Allowing interface to be displayed
		setSize(400, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		/* This method should allow the user to save data to a file called textData.txt */
		saveData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
					JFileChooser fc = new JFileChooser();
					fc.setCurrentDirectory(new File(System.getProperty("user.dir")));
					int returnVal = fc.showSaveDialog(LapTimer.this);
					if (returnVal == JFileChooser.APPROVE_OPTION)
					{
						currentFile = fc.getSelectedFile();
						
						if (currentFile.exists())
						{
							int result = JOptionPane.showConfirmDialog(LapTimer.this, "This will overwrite the existing file.\n Are you sure you want to do this?");
							if (result == 0) 
							{
								try 
								{
									writeDataFile(currentFile);
								}
								catch (IOException ex)
								{
									JOptionPane.showMessageDialog(LapTimer.this, "I/O Exception\n " + ex.toString(), "Error Message", JOptionPane.ERROR_MESSAGE);
								}
							}
						}
						else 
						{
							try
							{
								
								writeDataFile(currentFile);
							}
							catch (IOException ex) 
							{
								JOptionPane.showMessageDialog(LapTimer.this, "I/O Exception\n " + ex.toString(), "Error Message", JOptionPane.ERROR_MESSAGE);
							}
						}
					}
				}
		});

		/* This method should retrieve the contents of a file representing a 
		   previous report using a JFileChooser. The result should be displayed 
		   as the contents of a dialog object. */
		displayData.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				JFileChooser fc = new JFileChooser();
				fc.setCurrentDirectory(new File(System.getProperty("user.dir")));
				int returnVal = fc.showOpenDialog(LapTimer.this);
				if (returnVal == JFileChooser.APPROVE_OPTION)
				{
					File file = fc.getSelectedFile();
					// Check to see if there is already a file with this name
					
						try 
						{
							readDataFile(file);
							
						}
						catch (IOException ex) 
						{
							JOptionPane.showMessageDialog(LapTimer.this, "I/O Exception\n " + ex.toString(), "Error Message", JOptionPane.ERROR_MESSAGE);
						} catch (ClassNotFoundException e1) 
						{
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			
		});

		/* This method should check to see if the application is already running, 
		   and if not, launch a LapTimerThread object,
		   
		   but if there is another 
		   session already under way, it should ask the user whether they want to 
		   restart 
		   
		   if they do then the existing thread and session should be 
		   reset. 
		   
		   The lap counter should be set to 1 and a new Session object 
		   should be created.

		   A new LapTimerThread object should be created with 
		   totalSeconds set to 0.0 and the display area should be cleared.
		   
		    When the 
		   new thread is started, make sure the goal textField is disabled */
	
		startButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				//if the timer has started the user is asked if they want to start the timer again
				if(started == true)
				{
					//User message
					int result = JOptionPane.showConfirmDialog(LapTimer.this, "There is a session underway would you like to retstart?");
					// if they answer yes
					if (result == 0)
					{
						//the thread is stopped with the total secinds and lap counter being set to the inital values
						totalSeconds = (float)0.0;
						lapCounter = 1;
						lapThread.stop();
						//A new thread is created along with a new session and started again
						lapThread = new LapTimerThread(LapTimer.this, LapTimer.this.totalSeconds);
						Thread = new Thread(lapThread);
						currentSession = new Session();
						Thread.start();
						//text area is cleared and goal field is set to non editable 
						display.setText(" ");
						goalTextField.setEditable(false);
						
					}
					//if they say no the timer is continued
					if (result == 1)
					{
						JOptionPane.showMessageDialog(null, "Timer Will Continue");
					}
				}
				//if the timer is has not been started it starts using the same logic above
				if(started == false)
				{
						JOptionPane.showMessageDialog(null, "Timer Will Now Start");
						lapCounter = 1;
						currentSession = new Session();
						display.setText("");
						totalSeconds = (float) 0.0;
						lapThread = new LapTimerThread(LapTimer.this, LapTimer.this.totalSeconds);
						Thread = new Thread(lapThread);	
						Thread.start();
						goalTextField.setEditable(false);
					}
					
				//entered to indictae that timer has beemn started
				started = true;
					}
		});
				
	
	
			
		


		/* This method should only work if a session has been started. 
		 * Once started,
		   clicking the Lap button should cause the length of the current lap to be
		   retrieved and used to create a new Lap object which is added to the 
		   session collection.

			The old LapTimerThread object should be stopped and 
		   a new thread should be started with the updated value of total seconds.
		   
		   
		   The lap number and time should be added to the display area. The message 
		   saying if the goal was reached also need to be added */
		lapButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{

				/* Insert code here */
				//if the timer hasnt been started yet then a message is displayed
				if(started == false)
				{
					JOptionPane.showMessageDialog(null, "No Session In Progress");
				}
				else
				{
					//creates a local variable to store current lpa seconds
					float currentLap = lapThread.getLapSeconds();;
					//lap is created taking in the lap counter and the current lap time as paramenters
					Lap aLap= new Lap(lapCounter, currentLap);
					//The lap is then added to the session class
					currentSession.addLap(aLap);
					//Displays lap id and time and if the goal was reached or not 
					display.append("Lap:");
					display.append(String.valueOf(aLap.getId()));
					display.append("	");
					display.append(convertToHMSString(aLap.getLapTime()));
					display.append("	");
					if(currentLap >Integer.parseInt(goalTextField.getText()))
					{
						display.append(goal_message[1]);
					}
					if(currentLap <Integer.parseInt(goalTextField.getText()))
					{
						display.append(goal_message[0]);
					}
					display.append("\n");
					//Thread is stopped and started again 
					lapThread.stop();
					//Counter is incremented
					lapCounter++;
					//total seconds is added
					totalSeconds = totalSeconds + lapThread.getLapSeconds();
					//new lap thread created and started again
					lapThread = new LapTimerThread(LapTimer.this, LapTimer.this.totalSeconds);
					Thread = new Thread(lapThread);
					Thread.start();
					
				}
				
			}
		});

		/* This method should have most of the same functionality as the Lap
		   button's action listener,
		   
		   except that a new LapTimerThread object is
		   NOT started.

		   In addition, the total time for all the laps should be 
		   calculated and displayed in the text area, 
		   
		   along with the average lap time and the 
		   
		   numbers and times of the fastest and slowest laps. */
		stopButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//if the timer hasn't been started a message is displayed
				if (started == false)
				{
					JOptionPane.showMessageDialog(null, "Timer Has Not Been Started Yet");
				}
				//else then the timer is stopped
				else
				{
				lapThread.stop();
				JOptionPane.showMessageDialog(null, "Timer Has Stopped");
				//if there are no laps in the session class then only the time it was stopped at is displayed and the timer is stopped
				if(currentSession.getSize() == 0)
				{
					JOptionPane.showMessageDialog(null, "No Laps Recorded , Time Stopped will be displayed");
					display.append("Stopped At: ");
					display.append(convertToHMSString(lapThread.getTotalSeconds()));
					display.append("\n");
					goalTextField.setEditable(true);
					started = false;
				}
				else
				//If there are multiple laps the time it was stopped at , average time , fastest lap , and slowest lap is all displayed timer stopped as well
				{
				display.append("\n");
				display.append("Stopped At:");
				display.append(convertToHMSString(lapThread.getTotalSeconds()));
				display.append("\n");
				display.append("Average Time:");
				display.append(convertToHMSString(currentSession.calculateAverageTime()));
				display.append("\n");
				display.append("Fastest Lap:");
				display.append(String.valueOf(currentSession.getFastestLap().getId()));
				display.append("	");
				display.append("Time: ");
				display.append(convertToHMSString(currentSession.getFastestLap().getLapTime()));
				display.append("\n");
				display.append("Slowest Lap:");
				display.append(String.valueOf(currentSession.getSlowestLap().getId()));
				display.append("	");
				display.append("Time: ");
				display.append(convertToHMSString(currentSession.getSlowestLap().getLapTime()));		
				goalTextField.setEditable(true);
				started = false;
				}
				}
				}
		});
		
	}
	
	/* These two methods are used by the LapTimerThread to update the values
	   displayed in the two text fields. Each value is formatted as a 
	   hh:mm:ss.S string by calling the convertToHMSString method below/. */

	public void updateLapDisplay(float value)
	{
		lapField.setText(convertToHMSString(value));

	}

	public void updateTotalDisplay(float value) {

		totalField.setText(convertToHMSString(value));

	}
	
	/* These methods are here to help access the
	 *  goaltextField in the GUI */
	
	public String getGoalValue(){
		return  goalTextField.getText();
	}
	
	public void EnableGoalEditing(boolean makeEditable){
		goalTextField.setEditable(makeEditable);
	}
	
	public void setTextArea(String str){
		display.setText(str);
	}

	private String convertToHMSString(float seconds) {
		long msecs, secs, mins, hrs;
		// String to be displayed
		String returnString = "";

		// Split time into its components

		long secondsAsLong = (long)(seconds * 10);

		msecs = secondsAsLong % 10;
		secs = (secondsAsLong / 10) % 60;
		mins = ((secondsAsLong / 10) / 60) % 60;
		hrs = ((secondsAsLong / 10) / 60) / 60;

		// Insert 0 to ensure each component has two digits
		if (hrs < 10) {
			returnString = returnString + "0" + hrs;
		}
		else returnString = returnString + hrs;
		returnString = returnString + ":";

		if (mins < 10) {
			returnString = returnString + "0" + mins;		
		}
		else returnString = returnString + mins;
		returnString = returnString + ":";

		if (secs < 10) {
			returnString = returnString + "0" + secs;		
		}
		else returnString = returnString + secs;

		returnString = returnString + "." + msecs;

		return returnString;

	}

	/* These methods will be used by the action listeners attached
	   to the two menu items. */

	public synchronized void writeDataFile(File f) throws IOException, FileNotFoundException {
		ObjectOutputStream out = null;
		//placed in a try-catch to handle errors
		try {
			out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
			//creates an objectoutputstream which takes in the display contents as a parameter
			out.writeObject(display.getText());
			
				} 
		catch (FileNotFoundException ex) {
			JOptionPane.showMessageDialog(LapTimer.this, "File Not Found Exception\n " + ex.toString(), "Error Message", JOptionPane.ERROR_MESSAGE);
		}
		catch (IOException ex) {
			JOptionPane.showMessageDialog(LapTimer.this, "I/O Exception\n " + ex.toString(), "Error Message", JOptionPane.ERROR_MESSAGE);
		}
		catch (Exception ex) {
			JOptionPane.showMessageDialog(LapTimer.this, "Exception\n " + ex.toString(), "Error Message", JOptionPane.ERROR_MESSAGE);
		}
		// Make sure to close stream
		finally {
			out.close();
		}
		//Message indicating data has been saved
		JOptionPane.showMessageDialog(null , "Your Data has Been Saved");
	}

	public synchronized String readDataFile(File f) throws IOException, ClassNotFoundException{
	
		
		ObjectInputStream inputStream = null;
		//placed in a try-catch to handle errors
		try {
			inputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(f)));
			//create a new object
			Object read = new Object();
			//let that object equal the object being read in
			
			read = inputStream.readObject();
			
			//text area is created
			JTextArea area = new JTextArea(10,10);
			//gathers the information from the object being read in
			area.append(read.toString());
			//displays in a message box
			JOptionPane.showMessageDialog(null, area);
		} 
		catch (FileNotFoundException ex) {
			JOptionPane.showMessageDialog(LapTimer.this, "File Not Found Exception\n " + ex.toString(), "Error Message", JOptionPane.ERROR_MESSAGE);
		}
		catch (IOException ex) {
			JOptionPane.showMessageDialog(LapTimer.this, "I/O Exception\n " + ex.toString(), "Error Message", JOptionPane.ERROR_MESSAGE);
		}
		catch (Exception ex) {
			JOptionPane.showMessageDialog(LapTimer.this, "Exception\n " + ex.toString(), "Error Message", JOptionPane.ERROR_MESSAGE);
		}
		// Make sure to close stream
		finally {
			inputStream.close();
		}
		return datafile;
	}

	public static void main(String[] args) {

		LapTimer timer = new LapTimer();
		timer.setVisible(true);

	}
	

}