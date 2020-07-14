//********************************************************************
//  ArrayList.java     
//
//  This is my very pared-down and simplified version of an ArrayList definition.
//********************************************************************


public class ArrayList<T>
{
   private final int DEFAULT_CAPACITY = 100;
   private int open;  // indicates the next open slot
   private T[] array; 
  

   //-----------------------------------------------------------------
   //  Creates an empty ArrayList using the default capacity.
   //-----------------------------------------------------------------
   public ArrayList()
   {
      open = 0;
      array = (T[])(new Object[DEFAULT_CAPACITY]);
   }

   //-----------------------------------------------------------------
   //  Creates an empty ArrayList using the specified capacity.
   //-----------------------------------------------------------------
   public ArrayList(int initialCapacity)
   {
      open = 0;
      array = (T[])(new Object[initialCapacity]);
   }

   //-----------------------------------------------------------------
   //  Adds the specified element to the next available slot in the array
   //-----------------------------------------------------------------
   public void add (T element)
   {
	  if (size() == array.length )
		  expandCapacity();
	  
	  array[open] = element;
      open++;
   }
   
   

   //-----------------------------------------------------------------
   //  Removes the last element added to the array. 
   //-----------------------------------------------------------------
   public T remove()
   {
      if (isEmpty())
        System.out.println("The list is empty");

      open--;
      T result = array[open];
      array[open] = null; 
 
      return result;
   }
   
   //-----------------------------------------------------------------
   //  Returns true if the array is empty and false otherwise. 
   //-----------------------------------------------------------------
   public boolean isEmpty()
   {
	   
	return (open == 0);
   }
 
   //-----------------------------------------------------------------
   //  Returns the number of elements in the array.
   //-----------------------------------------------------------------
   public int size()
   {
	return open;
   }

   //-------------------------------------------------
	//  Creates a new array to store the contents of the array with
	//  twice the capacity of the old one.
	//-----------------------------------------------------------------
	private void expandCapacity()
	{
	    T[] larger = (T[])(new Object[array.length*2]);

	      for (int scan=0; scan < array.length; scan++)
	         larger[scan] = array[scan];

	      array = larger;
	   }

   
   //-----------------------------------------------------------------
   //  Returns a string representation of the entire array. 
   //-----------------------------------------------------------------
   public String toString()
   {
      String result = "";

      for (int scan=0; scan < open; scan++) 
         result = result + array[scan].toString() + "\n";

      return result;
   }

   
}
