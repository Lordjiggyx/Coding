//*****************************************************************
//  ArrayQueue.java       
//
//  Represents an array implementation of a queue. The front of
//  the queue is kept at array  index 0.
//********************************************************************

package dataStructures;

public class ArrayQueue<T> implements QueueADT<T>
{
   private final int DEFAULT_CAPACITY = 100;
   private int rear;
   private T[] queue; 

   //-----------------------------------------------------------------
   //  Creates an empty queue using the default capacity.
   //-----------------------------------------------------------------
   public ArrayQueue()
   {
      rear = 0;
      queue = (T[])(new Object[DEFAULT_CAPACITY]);
   }

   //-----------------------------------------------------------------
   //  Creates an empty queue using the specified capacity.
   //-----------------------------------------------------------------
   public ArrayQueue (int initialCapacity)
   {
      rear = 0;
      queue = (T[])(new Object[initialCapacity]);
   }

   //-----------------------------------------------------------------
   //  Adds the specified element to the rear of the queue, expanding
   //  the capacity of the queue array if necessary.
   //-----------------------------------------------------------------
   public void enqueue (T element)
   {
      if (size() == queue.length) 
         expandCapacity();

      queue[rear] = element;
      rear++;
   }

   //-----------------------------------------------------------------
   //  Removes the element at the front of the queue and returns a
   //  reference to it. Throws an EmptyCollectionException if the
   //  queue is empty.
   //-----------------------------------------------------------------
   public T dequeue() 
   {
      if (isEmpty()) {
         System.out.println("Queue is empty");
         return null;
      }
      else {
          T result = queue[0];

          rear--;

          // shift the elements 
          for (int scan=0; scan < rear; scan++)
              queue[scan] = queue[scan+1];

          queue[rear] = null;
 
          return result;
      }
   }
   
   //-----------------------------------------------------------------
   //  Returns a reference to the element at the front of the queue.
   //  The element is not removed from the queue.  Throws an
   //  EmptyCollectionException if the queue is empty.  
   //-----------------------------------------------------------------
   public T first() 
   {
      if (isEmpty()) {
          System.out.println("Queue is empty");
          return null;
      }
      else
          return queue[0];
   }

   //-----------------------------------------------------------------
   //  Returns true if this queue is empty and false otherwise. 
   //-----------------------------------------------------------------
   public boolean isEmpty()
   {
      return (rear == 0);
   }
 
   //-----------------------------------------------------------------
   //  Returns the number of elements currently in this queue.
   //-----------------------------------------------------------------
   public int size()
   {
      return rear;
   }

     //-----------------------------------------------------------------
   //  Creates a new array to store the contents of the queue with
   //  twice the capacity of the old one.
   //-----------------------------------------------------------------
   private void expandCapacity()
   {
      T[] larger = (T[])(new Object[queue.length*2]);

      for (int scan=0; scan < queue.length; scan++)
         larger[scan] = queue[scan];

      queue = larger;
   }
}

