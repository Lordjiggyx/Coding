
/**
 * Write a description of class Employee here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Employee
{
    private String name;
    private int jobcategory1;
    private double salary;
    private int years;
    private double smallSIncrease;
    private double bigSIncrease;
    private double smallAIncrease;
    private double bigAIncrease;
    public Employee(String name, int jobcategory1, double salary, int years , double smallSIncrease , double bigSIncrease,double smallAIncrease , double bigAIncrease)
    {
        this.name= name;
        this.jobcategory1=jobcategory1;
        this.salary=salary;
        this.years=years;
        this.smallSIncrease= salary + (salary*0.10);
        this.bigSIncrease =salary + (salary*0.15);
        this.smallAIncrease =salary + (salary*0.10);
        this.bigAIncrease =salary + (salary*0.15);
    }

    public Employee()
    {
        this.name="";
        this.jobcategory1=0;
        this.salary=0;
        this.years=0;
        this.smallSIncrease=salary + (salary*0.10);
        this.bigSIncrease=salary + (salary*0.15);
        this.smallAIncrease=salary + (salary*0.10);
        this.bigAIncrease=salary + (salary*0.15);
    }

    public String getname()
    {
        return this.name;
    }

    public int getjobcategory1()
    {
        return this.jobcategory1;
    }

    public double getsalary()
    {
        return this.salary;
    }

    public int getyears()
    {
        return this.years;
    }

    public double getsmallSIncrease()
    {
        return this.smallSIncrease;
    }

    public double getbigSIncrease()
    {
        return this.bigSIncrease;
    }

    public double getsmallAIncrease()
    {
        return this.smallAIncrease;
    }

    public double getbigAIncrease()
    {
        return this.bigSIncrease;
    }

    public void setname(String name)
    {
        this.name= name;  
    }

    public void setsmallSIncrease(double smallSIncrease)
    {
        this.smallSIncrease= salary + (salary*0.10);
    }

    public void setbigSIncrease(double bigSIncrease)
    {
        this.bigSIncrease= salary + (salary*0.15);
    }

    public void setsmallAIncrease(double smallAIncrease)
    {
        this.smallAIncrease= salary + (salary*0.10);
    }

    public void setbigAIncrease(double bigAIncrease)
    {
        this.bigAIncrease= salary + (salary*0.15);
    }

    
    public void setjobcategory1(int jobcategory1)
    {
        this.jobcategory1=jobcategory1;
    }

    public void setsalary(double salary)
    {
        this.salary=salary;
    }

    public void setyears(int years)
    {
        this.years=years;
    }

    public void display()
    {
        System.out.println("Employee's Name:" + this.name);
        if(this.jobcategory1==1)
        {
            System.out.println("Employee's Job Category:Sales");
        }
        else
        if(this.jobcategory1==2)
        {
            System.out.println("Employee's Job Category:Administraion");
        }
        System.out.println("Employee's Salary:" + this.salary);
        if(this.salary<=1700 && this.jobcategory1==1)
        {
            System.out.println("Employee's Salary With Increase of 10%:" +  this.smallSIncrease);
        }
        else
        if(this.salary>=1700 && this.jobcategory1==1)
        {
            System.out.println("Employee's Salary With Increase of 15%:" + ( this.bigSIncrease));
        }
        if(this.salary<=1000 && this.jobcategory1==2)
        {
            System.out.println("Employee's Salary With Increase of 10%:" + ( this.smallAIncrease));
        }
        else
        if(this.salary>=1000 && this.jobcategory1==2)
        {
            System.out.println("Employee's Salary With Increase of 15%:" + ( this.bigAIncrease));
        }
        System.out.println("Years Worked By Employee:" + this.years);

    }
    //Bonus method for salesperson
    public void sbonus()

    {
        double bonusdue=(years - 2)*50;
        if(years == 2 || (years < 2))
        {
            System.out.println("Sorry to inform you but this employee is not entitled to a bonus as of now");
        }
        else
        if(salary<=1700)
        {
            System.out.println("This employee is entitled to a bonus");
            System.out.println("Bonus due:" + bonusdue);
            System.out.println("Your Net Salary (bonus and increase incl.) is:" + (this.smallSIncrease + bonusdue));
        }
        else
        if (salary>=1700)
        {
            System.out.println("This employee is entitled to a bonus");
            System.out.println("Bonus due:" + bonusdue);
            System.out.println("Your Net Salary (bonus and increase incl.) is:" + (this.bigSIncrease + bonusdue));
        }
    }

    //Bonus method for Administration
    public void abonus()
    {
        double abonusdue= (salary*0.05*years);
        if(salary<=1000)
        {
            System.out.println("This employee is entitled to a bonus");
            System.out.println("Bonus due:" + abonusdue);
            System.out.println("Your Net Salary (bonus and increase incl.) is:" + (this.smallAIncrease + abonusdue));
        }
        else
        if(salary>=1000)
        {
            System.out.println("This employee is entitled to a bonus");
            System.out.println("Bonus due:" + abonusdue);
            System.out.println("Your Net Salary (bonus and increase incl.) is:" + (this.bigAIncrease + abonusdue));
        }
    }
}