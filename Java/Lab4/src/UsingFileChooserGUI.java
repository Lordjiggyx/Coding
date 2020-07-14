

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;


public class UsingFileChooserGUI extends javax.swing.JFrame implements ActionListener
 {
	JButton btnChooseFile;
	JFileChooser fc;
	public UsingFileChooserGUI(){
		createGUI();
		this.setVisible(true);
		this.pack();
	}
	
	public void createGUI(){
		btnChooseFile = new JButton("Choose File");
		fc = new JFileChooser(); 

		btnChooseFile.addActionListener(this);
		add(btnChooseFile);
	}
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() {
				new UsingFileChooserGUI();
				
			}
			
		});

	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Create JFileChooser
		//fc.showOpenDialog(UsingFileChooserGUI.this);
		
		//fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 

		//In response to a button click: 
		int returnVal = fc.showOpenDialog(this); 
		File file = fc.getSelectedFile();
		
		// Call the method on selected file
		UsingFiles files = new UsingFiles();
		files.fileManipulation(file.getPath());
		
	}

}
