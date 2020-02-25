

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class FileChooserGui extends JFrame implements ActionListener
{
	static private final String newline = "\n";
	JButton openButton;
    JFileChooser fc;
    JTextArea log;
	public FileChooserGui()
	{
		log = new JTextArea(5,20);
        log.setMargin(new Insets(5,5,5,5));
        log.setEditable(false);
        JScrollPane logScrollPane = new JScrollPane(log);
        fc = new JFileChooser();
        
        openButton = new JButton("Open");
        openButton.addActionListener(this);
        add(openButton);
}

	 public void actionPerformed(ActionEvent e) 
	 {
		 
	        //Handle open button action.
	        if (e.getSource() == openButton) 
	        {
	        	
	            int returnVal = fc.showOpenDialog(FileChooserGui.this);
	            fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	            File file=null;
	            if (returnVal == JFileChooser.APPROVE_OPTION)
	            {
	               file = fc.getSelectedFile();
	             
	            
	            UsingFiles a = new UsingFiles();
	            a.fileManipulation(file.getPath());
	            }
	        }
	 }
	 public static void main(String[] args) throws IOException
		{
			 javax.swing.SwingUtilities.invokeLater(new Runnable() {
		            
		        	public void run() {
		        		FileChooserGui a = new FileChooserGui();
		        		a.setVisible(true);
		        		a.pack();
		            }
		        });
}
}