//********************************************************************
//  LinkedStack.java       
//
//  Represents a linked implementation of a stack.
//********************************************************************

package dataStructures;



public class LinkedStack<T> implements StackADT<T>
{
   private int count;  // indicates the next open slot
   private LinearNode<T> top; 

   //-----------------------------------------------------------------
   //  Creates an empty stack.
   //-----------------------------------------------------------------
   public LinkedStack()
   {
      count = 0;
      top = null;
   }

   //-----------------------------------------------------------------
   //  Adds the specified element to the top of the stack.
   //-----------------------------------------------------------------
   public void push (T element)
   {
      LinearNode<T> temp = new LinearNode<T> (element);

      temp.setNext(top);
      top = temp;
      count++;
   }

   //-----------------------------------------------------------------
   //  Removes the element at the top of the stack and returns a
   //  reference to it. Throws an EmptyStackException if the stack
   //  is empty.
   //-----------------------------------------------------------------
   public T pop() 
   {
      if (isEmpty())
    	  System.out.println("The stack is empty");

      T result = (T)top.getElement();
      top = top.getNext();
      count--;
 
      return result;
   }
   
   //-----------------------------------------------------------------
   //  Returns a reference to the element at the top of the stack.
   //  The element is not removed from the stack.  Throws an
   //  EmptyStackException if the stack is empty.  
   //-----------------------------------------------------------------
   public T peek() 
   {
      if (isEmpty())
    	  System.out.println("The stack is empty");

      return (T) top.getElement();
   }

   //-----------------------------------------------------------------
   //  Returns true if the stack is empty and false otherwise. 
   //-----------------------------------------------------------------
   public boolean isEmpty()
   {
      return (count == 0);
   }
 
   //-----------------------------------------------------------------
   //  Returns the number of elements in the stack.
   //-----------------------------------------------------------------
   public int size()
   {
      return count;
   }

   //-----------------------------------------------------------------
   //  Returns a string representation of the stack. 
   //-----------------------------------------------------------------
   public String toString()
   {
      String result = "";
      LinearNode<T> current = top;

      while (current != null)
      {
         result = result + (current.getElement()).toString() + "\n";
         current = current.getNext();
      }

      return result;
   }
}
