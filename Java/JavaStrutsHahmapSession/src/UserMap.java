import java.util.HashMap;

public class UserMap 
{
	HashMap<String , Object> hm = new HashMap<String , Object>();

	public UserMap()
	{
		User a = new User("Jenny" , "Jenny123@gmail.com");
		hm.put("Jenny", a );
		
		User b = new User("Bob" , "Bob123@gmail.com");
		hm.put("Bob", b );
		
		User J = new User("Jane" , "Jane123@gmail.com");
		hm.put("Jane", J );
		hm.put("Password", "Secret");
		User x = (User) hm.get("Jenny");
		System.out.println(x.getEmail());
		
		System.out.println(hm.get("Password"));
		
	}
	
	
	
	
	
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		UserMap Um = new UserMap();
		
	}

}
