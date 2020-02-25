import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

public class User implements SessionAware{
private String firstName;
private String lastName;
private String postedBy;
private String postee;
private String content;
Connection connection;
boolean exists;
private Map<String, Object> session;

private ArrayList <Friend> friends = new ArrayList<Friend>();
private ArrayList <Member> members = new ArrayList<Member>();
private ArrayList <Post> posts = new ArrayList<Post>();
public User()
	{
		// TODO Auto-generated constructor stub
	}

public String login()throws Exception
{
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/Struts?"+"user=root&password=root");
	
	PreparedStatement st = connection.prepareStatement("select * from Members where FirstName = ?  && LastName = ?");
	st.setString(1, firstName);
	st.setString(2,lastName);
	ResultSet r1=st.executeQuery();
     if(r1.next()) 
     {
      String  DBfn =  r1.getString("FirstName");
      String  DBln = r1.getString("LastName");
       if(firstName.equalsIgnoreCase(DBfn) && lastName.equalsIgnoreCase(DBln)) 
       {
          exists = true;
          session.put("currentUser",DBfn );
          
       }
       else
       {
    	   exists = false;
       }
     }
     
     if(exists == true)
     {
         return "SUCCESS";
     }
     else
     {
    	 return "FAILURE";
     }
	
	}

public String register()
{
	try {
		saveNewUser();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return "SUCCESS";
}

public 	String addFriend()throws Exception
{
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/Struts?"+"user=root&password=root");
	
	PreparedStatement st = connection.prepareStatement("select * from Members where FirstName = ?  && LastName = ?");
	st.setString(1, firstName);
	st.setString(2,lastName);
	ResultSet r1=st.executeQuery();
	
     if(r1.next()) 
     {
      String user = (String) session.get("currentUser");
      String  DBfn =  r1.getString("FirstName");
      String  DBln = r1.getString("LastName");
       if(firstName.equalsIgnoreCase(DBfn) && lastName.equalsIgnoreCase(DBln)) 
       {
    	PreparedStatement createUser = connection.prepareStatement("INSERT into friends (addedBy,FirstName,LastName)" +" VALUES (?, ?,?)");
    	createUser.setString(1, user);
    	createUser.setString(2, DBfn);
    	createUser.setString(3, DBln);
    	
    	int rowsUpdated = createUser.executeUpdate();
    	createUser.close();
    	connection.close();
         exists = true;
      }
      else
      {
   	   exists = false;
      }
      }
     if(exists == true)
     {
    	 
         return "SUCCESS";
     }
     else
     {
    	 return "FAILURE";
     }
     }
    
public String viewFriends()throws Exception
{
	//getFriends();
	for(int i = 0 ; i<friends.size(); i++)
	{
		System.out.println(friends.get(i).getFirstname());
	}
	return "SUCCESS";
}
public ArrayList<Friend> getFriends() throws Exception
{
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/Struts?"+"user=root&password=root");
	
	String name =(String) session.get("currentUser");
	PreparedStatement statement = connection.prepareStatement("SELECT * FROM friends Where addedBy  = ?");
	statement.setString(1, name);
	ResultSet rs = statement.executeQuery();
	
	while(rs.next())
	{
		 String  DBfn1 =  rs.getString("FirstName");
	      String  DBln1 = rs.getString("LastName");
		friends.add( new Friend(DBfn1 , DBln1));
	}
	//st.close();
	statement.close();
	connection.close();
	return friends;
	}
	

public void setFriends(ArrayList<Friend> friends) {
	this.friends = friends;
}

public String getFirstName() {
	return firstName;
}


public void setFirstName(String firstName) {
	this.firstName = firstName;
}



public String getLastName() {
	return lastName;
}

public String addPosts() throws Exception
{
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/Struts?"+"user=root&password=root");
	
	
	PreparedStatement createUser = connection.prepareStatement("INSERT into posts (PostedBy,Post)" +" VALUES (?, ?)");
	createUser.setString(1, (String)session.get("currentUser"));
	createUser.setString(2, content);
	
	int rowsUpdated = createUser.executeUpdate();
	createUser.close();
	connection.close();
	
	return "SUCCESS";
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public void saveNewUser() throws Exception
{
	String Firstname = getFirstName();
	String Lastname = getLastName();

	Class.forName("com.mysql.jdbc.Driver").newInstance();
	connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/Struts?"+"user=root&password=root");
	
	PreparedStatement createUser = connection.prepareStatement("INSERT into Members (FirstName,LastName)" +" VALUES (?, ?)");
	createUser.setString(1, Firstname);
	createUser.setString(2, Lastname);
	
	int rowsUpdated = createUser.executeUpdate();
	createUser.close();
	connection.close();
}

@Override
public void setSession(Map map)
{
	// TODO Auto-generated method stub
	session = map;
}

public String viewAllUsers()throws Exception
{
	for(int i = 0 ; i<friends.size(); i++)
	{
		System.out.println(members.get(i).getFirstname());
	}
	return "SUCCESS";
}


public ArrayList <Member> getMembers() throws Exception
{
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/Struts?"+"user=root&password=root");
	PreparedStatement statement = connection.prepareStatement("SELECT FirstName , LastName FROM Members");
	ResultSet rs = statement.executeQuery();
	
	while(rs.next())
	{
		String  DBfn1 =  rs.getString("FirstName");
	      String  DBln1 = rs.getString("LastName");
	      members.add(new Member(DBfn1 , DBln1));
	}
	statement.close();
	connection.close();
	return members;
}

public void setMembers(ArrayList <Member> members) {

	this.members = members;
}

public String viewPosts()
{
	return "SUCCESS";
}

public ArrayList <Post> getPosts() throws Exception

{
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/Struts?"+"user=root&password=root");
String name =(String) session.get("currentUser");
PreparedStatement statement = connection.prepareStatement("SELECT * FROM posts Where PostedBy  = ?");
statement.setString(1, name);
ResultSet rs = statement.executeQuery();

while(rs.next())
{
	 String  DBPB =  rs.getString("PostedBy");
      String  Post = rs.getString("Post");
	posts.add( new Post(DBPB , Post));
}

statement.close();
connection.close();
	return posts;
}

public void setPosts(ArrayList <Post> posts) {
	this.posts = posts;
}

public String getPostedBy() {
	return postedBy;
}

public void setPostedBy(String postedBy) {
	this.postedBy = postedBy;
}

public String getPostee() {
	return postee;
}

public void setPostee(String postee) {
	this.postee = postee;
}

public String getContent() {
	return content;
}

public void setContent(String content) {
	this.content = content;
}


public String LogOff() 
{
	session.remove("currentUser");
	return "SUCCESS";
}
}
