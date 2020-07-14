import java.util.Scanner;
/**
 * Write a description of class BusinessDriver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BusinessDriver
{
    public static void main(String args[])
    {
        Scanner stdIn = new Scanner(System.in);
        String cname;//customer name
        String Address;
        double owed; 
        int newCustomer;
        String name;
        String jobcategory;
        int jobcategory1;//Created for error checking of user input
        int doloopKiller1=1;//Created to cancel do loop
        int doloopKiller2=1;
        int doloopKiller3=1;
        int doloopKiller4=1;
        int doloopKiller5=1;
        double salary;
        int years;
        double netSalary;
        Employee Employee1;
        Customer Customer1;
        double bonusdue;
        double smallSIncrease;
        double bigSIncrease;
        double smallAIncrease;
        double bigAIncrease;
        double abonusdue;//bonus due for administartion

        System.out.print("\f");
        System.out.println("Employee:");

        System.out.println(" ");
        Employee1 = new Employee();

        System.out.println("What Is The Employee's Name?");
        name = stdIn.next();
        stdIn.nextLine();
        Employee1.setname(name);
        do//keeps user in a loop until correct answer is given
        {
            System.out.println(" ");
            System.out.println("What Is The Employee's Job Category?");
            System.out.println("Please enter 1 for Sales or 2 for Administration");
            jobcategory1 = stdIn.nextInt();
            stdIn.nextLine();
            Employee1.setjobcategory1(jobcategory1);
            if (jobcategory1 ==1 || jobcategory1 ==2)
            {
                doloopKiller1=doloopKiller1 - 2;
            }
        }
        while (doloopKiller1>0);

        do
        {
            System.out.println(" ");
            System.out.println("What Is The Employee's Monthly Salary?");
            salary = stdIn.nextDouble();
            stdIn.nextLine();
            Employee1.setsalary(salary);
            Employee1.setsmallSIncrease(salary);
            Employee1.setbigSIncrease(salary);
            Employee1.setsmallAIncrease(salary);
            Employee1.setbigAIncrease(salary);
            if(salary< 0 || salary<100000000)
            {
                doloopKiller2=doloopKiller2 - 2;
            }
        }
        while(doloopKiller2>0);//keeps user in a loop until correct answer 

        do
        {
            System.out.println(" ");
            System.out.println("How Many Years Has This Employee Worked At This Company?");
            years = stdIn.nextInt();
            stdIn.nextLine();
            Employee1.setyears(years);
            if( years<0 || years<100)
            {
                doloopKiller3=doloopKiller3 - 2;
            }
        }
        while(doloopKiller3>0);//keeps user in a loop until correct answer 
        System.out.println(" ");
        System.out.println("Employee Details:");
        Employee1.display();
        if(jobcategory1 ==1)
        {
            Employee1.sbonus();
        }
        else
        if(jobcategory1 == 2)
        {
            Employee1.abonus();
        }

        System.out.println(" ");
        System.out.println("Customer:");

        System.out.println(" ");
        Customer1 = new Customer();

        System.out.println("What Is The Customer's Name?");
        cname = stdIn.next();
        stdIn.nextLine();
        Customer1.setcname(cname);

        System.out.println(" ");
        System.out.println("What Is The Customer's Address?");
        Address = stdIn.next();
        stdIn.nextLine();
        Customer1.setAddress(Address);

        System.out.println(" ");
        do
        {
            System.out.println("How much does the Customer Owe This Company?");
            owed = stdIn.nextDouble();
            stdIn.nextLine();
            Customer1.setowed(owed);
            if(owed <=0 || owed<1000000000)
            {
                doloopKiller4=doloopKiller4-2;
            }
        }
        while(doloopKiller4>0);//keeps user in a loop until correct answer

        do
        {
            System.out.println(" ");
            System.out.println("We will now check your legibility to do business with us ");
            System.out.println("Please enter 1 to continue");
            newCustomer=stdIn.nextInt();

            if ( newCustomer==1 || newCustomer== 2)
            {
                doloopKiller5=doloopKiller5-2;
            }
        }
        while(doloopKiller5>0);
        System.out.println(" ");
        if ( newCustomer==1)
        {
            Customer1.blockAccount();
        }
        else
        if(newCustomer==2)
        {
            Customer1.blockAccount1();
        }
        System.out.println(" ");
         Customer1.display();
    }
}
