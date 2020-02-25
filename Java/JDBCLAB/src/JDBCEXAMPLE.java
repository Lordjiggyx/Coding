		import java.sql.Connection;
		import java.sql.DriverManager;
		import java.sql.PreparedStatement;//parameterise query
		import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

		public class JDBCEXAMPLE {
		private Connection connection;
		public JDBCEXAMPLE() throws Exception
		{
		//Note that in class some people got an error on this using newer versions on MySQL. Check the
		//error and if required comment this line out as your driver may be
			
			//Connect to database
		
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/dt354jdbc?"+"user=root&password=root");
		//connection =DriverManager.getConnection ("jdbc:mysql://localhost:3306/dt354jdbc"+"root ,root");
		
		
		//insert data into database
		PreparedStatement createUser = connection.prepareStatement("INSERT into user (NAME,PASSWORD)" +" VALUES (?, ?)");
		createUser.setString(1, "Bob");
		createUser.setString(2, "Bob2");
		createUser.executeUpdate();
		createUser.close();
		
		//select data from database
		try 
		{
			Statement select = connection.createStatement();
			ResultSet rs = select.executeQuery("SELECT * FROM users Where ID  < 6");
			while (rs.next())
			{
				
			System.out.println("Column 1 values :"+rs.getString(1));
			System.out.println("Column 2 values :" +rs.getString(2));
			System.out.println("Column 3 values :" +rs.getString(3));
			System.out.println("Column 4 values :" +rs.getString(4));
			System.out.println("Column 5 values :" +rs.getString(5));
			System.out.println("Column 6 values :" +rs.getString(6));
			System.out.println("Column 7 values :" +rs.getString(7));
			System.out.println("Column 8 values :" +rs.getString(8));
			}
			connection.close();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		//In the case below there will only be one column returned so you can only access that info in
		//the Result Set
		//ResultSet rs = select.executeQuery("SELECT username FROM user WHERE username = 'Janet'");
		//In this case below you can access both columns as it returns all info in the user table
		
		
		public static void main(String[] args){
		try {
			JDBCEXAMPLE jdbc = new JDBCEXAMPLE();
		} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		}
		
	}


