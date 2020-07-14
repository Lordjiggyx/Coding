     //************************************************************
    //  LinearNode.java      
    //
    //  Represents a node in a linked list.
    //************************************************************
    
    package dataStructures;   


    public class LinearNode<T>
    {
       private LinearNode<T> next;
       private T element;
    
       //---------------------------------------------------------
       //  Creates an empty node.
       //---------------------------------------------------------
       public LinearNode()
       {
          this.next = null;
          this.element = null;
       }
    
       //---------------------------------------------------------
       //  Creates a node storing the specified element.
       //---------------------------------------------------------
       public LinearNode (T elem)
       {
          this.next = null;
          this.element = elem;
       }
    
       //---------------------------------------------------------
       //  Returns the node that follows this one.
       //---------------------------------------------------------
       public LinearNode<T> getNext()
       {
          return next;
       }
    
       //---------------------------------------------------------
       //  Sets the node that follows this one.
       //---------------------------------------------------------
       public void setNext (LinearNode<T> node)
       {
          next = node;
       }
    
       //---------------------------------------------------------
       //  Returns the element stored in this node.
       //---------------------------------------------------------
       public T getElement()
       {
          return element;
       }
    
       //---------------------------------------------------------
       //  Sets the element stored in this node.
       //---------------------------------------------------------
       public void setElement (T elem)
       {
          element = elem;
       }
    }

