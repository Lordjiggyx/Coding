

import java.io.File;

public class UsingFiles {

	public UsingFiles()
	{
		super();
	}
	public void fileManipulation(String dir) 
	{
		// create an object of the class File based on the current directory:
		File lab4_dir = new File(dir); 
		// create a new director: "Lab5_directory"
		lab4_dir.mkdir();
		// Display relative path
		String relative_path = lab4_dir.getPath();
		System.out.println("Relative path: "+relative_path);
		// Display absolute path
		String absolute_path = lab4_dir.getAbsolutePath();
		System.out.println("Absolute path: "+absolute_path);
		// Display current working directory:
		String current_dir_string = System.getProperty("user.dir");
		System.out.println("Current directory: "+current_dir_string);
	}
	public static void main(String args[]){
		
		// Call the function from the main class
		UsingFiles files = new UsingFiles();
		files.fileManipulation("Lab4_directory");
		
	}
}
