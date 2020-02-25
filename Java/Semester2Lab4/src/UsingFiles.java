

import java.io.File;
import java.io.IOException;

public class UsingFiles 
{
	public UsingFiles()
	{
		fileManipulation("Lab_4_Directory");
	}
	
	public void  fileManipulation(String dir_name)
	{
		File one = new File(dir_name);
	    one.mkdir();
	    System.out.println(one.getPath());
	    System.out.println(one.getAbsolutePath());
	   // System.out.println(System.getProperty("user.dir")) ;
		
		
	}
	public static void main(String[] args) throws IOException
	{
		 javax.swing.SwingUtilities.invokeLater(new Runnable() {
	            
	        	public void run() {
	        	UsingFiles a = new UsingFiles();
	            }
	        });
	}
}