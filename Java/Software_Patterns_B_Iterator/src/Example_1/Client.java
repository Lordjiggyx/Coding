package Example_1;

public class Client {
	
	public static void main(String args[]) 
    { 
       //Declare the Aggregate/Collection class
		NotificationCollection nc = new NotificationCollection();
		
		//get the Iterator of this class and set to an Iterator object
		Iterator it = nc.getIterator();
		
		//use a while loop based on the hasNext method to iterate
		while(it.hasNext())
		{
			//Do whatever you want in this case dsiplat message
			
			//create new notfictaion object
			Notification n = (Notification)it.next();
			System.out.println(n.getNotification()); 
		}
		System.out.println("Finsihed"); 

    } 

}
