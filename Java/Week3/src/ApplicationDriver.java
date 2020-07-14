

public class ApplicationDriver 
{
	public static void main(String[] args)
	{
	     Pair<String> p1 = new Pair<String>("Hello", "Wld");
	     
		 Pair<String> p2 = new Pair<String>("Hello", "World");
	
			
		if (p1.equals(p2))
			System.out.println("There are the same");
		else
			System.out.println("There are not the same");
		
		System.out.println("First item:  " + p1.toString() + "  Second item: " + p2.toString());
		
			
	}
}
