
public abstract class Person
{

    protected String name;  //visible in super and subclass
    protected String address;
    protected String dateOfBirth;

    public Person()
    {
        this.name = "";
        this.address = "";
        this.dateOfBirth = "";
    }

    public Person(String name, String addr, String dob)  //Polymorphism - Overloading
    {
        this.name = name;
        this.address = addr;
        this.dateOfBirth = dob;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String n)
    {
        this.name = n;
    }

    public void display()
    {
        System.out.println("Name is " + this.name);
        System.out.println("Address is " + this.address);
        System.out.println("Date of birth is " + this.dateOfBirth);
    }

    public boolean correctName()
    {
        boolean correctName = false;
        if ( name.matches("[A-Z][a-z]*"))
        {
            this.name = name;
            correctName = true;
        }
        return correctName;
    }
}
