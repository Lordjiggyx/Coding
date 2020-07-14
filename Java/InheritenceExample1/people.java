import java.util.ArrayList;
import java.util.Scanner;
/**
 * Write a description of class people here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class people
{
    ArrayList<Employee> people;

    public people()
    {
        people = new ArrayList<Employee>();
    }

    public void addEmployees()
    {
        System.out.print("\f");
        for ( int i = 0 ; i <=2; i++)
        {
            Scanner scan = new Scanner(System.in);
            String name;
            String dateOfBirth;
            String address;
            String identifier;
            String department;
            Employee aEmployee;
            
            System.out.println("Name;");
            name = scan.nextLine();
            
            System.out.println("dateOfBirth;");
            dateOfBirth = scan.nextLine();
            
            System.out.println("address;");
            address = scan.nextLine();
            
            System.out.println("identifier;");
            identifier = scan.nextLine();
            
            System.out.println("department;");
            department = scan.nextLine();
            
            aEmployee = new Employee(  name,  dateOfBirth,  address,  identifier,  department);
            people.add(aEmployee);
            if (aEmployee.correctName()== false)
            {
                System.out.println("The format you have used for the name is incorrect and you will now be terminated!!!!!!!!!");
            }
            else
            {
                System.out.println("Well done it was properly input");
            }
            
            System.out.println(" ");
            
        }   
    }
   
    public void displayEmployees()
    
    {
         for (Employee per : people)
        {
            System.out.println(" "); 
            per.display();
        }

    }

    public static void main(String[] args)
    {
        System.out.print("\f");
        people driver = new people();
        driver.addEmployees();
        driver.displayEmployees();
    }
}
