/* This class is a definition of a new entity that I'm calling Pair. 
 This will allow me to 
 * create a Pair of anything that have the same type. So I could ultimately have a pair of students, 
 * a pair of grades, a pair of shoes or in the case that you'll be using today, a pair of strings and then later
 * a pair of points (where a point is defined by an x and a y coordinate).
 * 
 * Note that this class is in its own package. 
 * A package is simply a folder and using packages allows me organise my classes 
 * into folders so similar classes reside in common folders. */



public class Pair <E>{
	private E first;
	private E second;
	
	public Pair()
	{
		this.first = null;
		this.second = null;
	}
	
	public Pair(E firstItem, E secondItem)
	{
		this.first = firstItem;
		this.second = secondItem;
	}
	
	public void setFirst(E newFirst)
	{
		this.first = newFirst;
	}
	
	public void setSecond(E newSecond)
	{
		this.second = newSecond;
	}
	
	public E getFirst()
	{
		return this.first;
	}
	
	public E getSecond()
	{
		return this.second;
	}

//This will compare one pair object with another pair object for equality.
//There is a general "equals" method defined in the Object class so 
//we are overriding this with our own definition which tells Java
//how to compare two pairs.

	public boolean equals(Object otherObject)
	{
		Pair<E> otherPair = (Pair<E>) otherObject;
		if (this.first.equals(otherPair.getFirst()) && this.second.equals(otherPair.getSecond()))
				return true;
			else
				return false;
		
	}
	
	public String toString()
	{
		return this.first + " " + this.second;
	}
}
