

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ObjectIOStream {
	public static void main(String[] args) throws IOException
	{
	 String datafile = "person.txt";
    try {
    	ObjectOutputStream objectOutput
                = new ObjectOutputStream(new FileOutputStream(datafile));
	
 
            List<Person> listPersons = new ArrayList<>();
 
            listPersons.add(
                new Person("Tomi", 25, "tomi@gmail.com"));
 
            listPersons.add(
                new Person("Bob", 30, "bob@gmail.com"));
 
            listPersons.add(
                new Person("Tam",21, "tam@gmail.com"));
 
            for (Person person : listPersons) {
                objectOutput.writeObject(person);
            }
 
        } catch (IOException ex) {
            ex.printStackTrace();
        }
 

    try {

        ObjectInputStream objectInput
        = new ObjectInputStream(new FileInputStream(datafile));
        while (true) {
            Person p = (Person) objectInput.readObject();

            System.out.print(p.getName() + "\t");
            System.out.print(p.getAge() + "\t");
            System.out.println(p.getEmail());
        }

    } catch (EOFException eof) {
        System.out.println("Reached end of file");
    } catch (IOException | ClassNotFoundException ex) {
        ex.printStackTrace();
    }
    finally
    {
    	
    }
}

}