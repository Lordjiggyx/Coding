/*****************************************
 * 
 * Application program which uses the LinkedList collection.
 * This application creates a list of 4 integers (1 - 4),
 * display all 4 numbers, deletes the first number and then displays the numbers again.
 * 
 *********************************************/
package applications;

import dataStructures.*;  //have to import the dataStructures package so LinkedList code can be used

public class ListOfNumbers {
	 LinkedList<Integer> myList;  // my list of integers
	
	//constructor
	public ListOfNumbers()
	{
		myList = new LinkedList<Integer>();
	}
	
	
	//input 4 integers and stores as Integer objects
	public void inputNumbers()
	{
		Integer temp;
		
		for (int i = 0; i < 4; i++)
		{
			temp = new Integer(i+1); //create a new integer object with value i + 1
			myList.add(temp);
		}
	}
	
	//delete the first number from the list
	public void deleteFirstNumber()
	{
		Integer temp;
		
		if (!myList.isEmpty())
		{
			temp = myList.remove();
			System.out.println(temp.intValue() + " has been removed from the list");
		}
		else
			System.out.println("There are no values to delete");
	}
	
	//display all of the values in the list
	public void displayAllValues()
	{
		if (!myList.isEmpty())
		{
			System.out.println(myList.toString());
		}
		else
			System.out.println("The list is empty");
	}
	
	
	//MAIN method
	public static void main(String[] args)
	{
		ListOfNumbers driver = new ListOfNumbers();
		driver.inputNumbers();
		driver.displayAllValues();
		driver.deleteFirstNumber();
		driver.displayAllValues();
	}
	
}
