import java.util.Scanner;
/**
 * INHERTIANCE EXAMPLE - Employee is a specialisation of Person
 */

public class Employee extends Person
{
  
    private String identifier;
    private String department;

    //POLYMORPHISM  1 - overloading - two versions of the one constructor made identifiable by the number of parameters
    public Employee() //create a blank employee
    {
        super();  // Person() Call constructor in superclass
        this.identifier = "";
        this.department = "";
    }

    public Employee(String name, String dob, String addr, String id)//create employee with all its details except jobtitle
    {
        super(name, addr, dob);  // Person(name, addr, dob) Call constructor in superclass
        this.identifier = id;
    }
    
    public Employee(String name, String dob, String addr, String id, String dept)//create employee with all its details
    {
        this(name, dob, addr, id ); //call the constructor with this number of parameters
        Scanner scan = new Scanner(System.in);
        while(!dept.matches("[DT][A-z]*"))
        {
            System.out.println("Please input the department name again With the first two letters starting with DT in capital");
            dept = scan.nextLine();
        }
        this.department = dept;

    }

    public void display()  //POLYMORPHISM 2 - overriding - this display() overrides the display() in Person
    {
        super.display();  //Call the display() method in Person
        System.out.println("Identifier = " + this.identifier);
        System.out.println("Job title = " + this.department);
    }

    public void display(String title)  //POLYMORPHISM  1 - overloading - this display() overloads the display() above
    {
        System.out.println(title);
        super.display();  //Call the display() method in Person
        System.out.println("Identifier = " + this.identifier);
        System.out.println("Job title = " + this.department);
    }
}
