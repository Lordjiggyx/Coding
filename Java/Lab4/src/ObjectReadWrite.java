

import java.text.*;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
 

public class ObjectReadWrite {
 
    public static void main(String[] args) throws IOException {

    	//output the people to the file
        String datafile = "person.txt";
        ObjectOutputStream objectOutput = null;
        try {
        	objectOutput
                    = new ObjectOutputStream(new FileOutputStream(datafile));
 	
     
                List<Person> listPersons = new ArrayList<>();
     
                listPersons.add(
                    new Person("John Doe", 25, "j.doe@gmail.com"));
     
                listPersons.add(
                    new Person("Mary Smith", 30, "m.smith@gmail.com"));
     
                listPersons.add(
                    new Person("Sally Jones",21, "s.jones@gmail.com"));
     
                for (Person person : listPersons) {
                    objectOutput.writeObject(person);
                }
     
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        finally{
        	objectOutput.close();
        }
     
        ObjectInputStream objectInput = null;
        try {
 
            objectInput
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
        finally{
        	objectInput.close();
        }
    }
 
}
