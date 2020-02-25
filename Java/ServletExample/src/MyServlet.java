import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet
{
	private Connection connection;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Boolean valid = true;
		String name = request.getParameter("NAME");
		String num1 = request.getParameter("Number_1");
		String num2 = request.getParameter("Number_2");
		String num3 = request.getParameter("Number_3");
		String num4 = request.getParameter("Number_4");
		String num5 = request.getParameter("Number_5");
		String num6 = request.getParameter("Number_6");
		int Numbers[] = new int[6];
	
		try {
			Numbers[0] = Integer.parseInt(num1);
			Numbers[1] = Integer.parseInt(num2);
			Numbers[2] = Integer.parseInt(num3);
			Numbers[3] = Integer.parseInt(num4);
			Numbers[4] = Integer.parseInt(num5);
			Numbers[5] = Integer.parseInt(num6);
		} catch (NumberFormatException e) {
			
			out.println("<HTML>");
			out.println("<HEAD><TITLE>Invalid Input </TITLE></HEAD>");
			out.println("<BODY>");
			out.println("You left A Space Empty Please Return And Fill This Space");
			out.println("</BODY></HTML>");
		}
		
	for (int i = 0 ; i <Numbers.length; i++)
	{
		if(Numbers[i] < 1 || Numbers[i] > 47)
		{
		valid = false;
		}
		
	}	
		if(valid == false)
		{
		out.println("<HTML>");
		out.println("<HEAD><TITLE>Invalid Input </TITLE></HEAD>");
		out.println("<BODY>");
		out.println("Values Entered Are Not Valid(Must be between 1-47)");
		out.println("</BODY></HTML>");
		}
		else if(valid == true)
		{
		Arrays.sort(Numbers);
		out.println("<HTML>");
		out.println("<HEAD><TITLE>Lotto Numbers </TITLE></HEAD>");
		out.println("<BODY>");
		out.println(name);
		out.println("Numbers:" + Arrays.toString(Numbers));
		out.println("</BODY></HTML>");
		out.close();
		
		
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		}
		catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		try 
		{
			connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/dt354jdbc?"+"user=root&password=root");
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//connection =DriverManager.getConnection ("jdbc:mysql://localhost:3306/dt354jdbc"+"root ,root");
		
		
		//insert data into database
		PreparedStatement createUser;
		try
		{
			createUser = connection.prepareStatement("INSERT into users (NAME,Number_1 ,Number_2 ,Number_3 ,Number_4 ,Number_5 ,Number_6)" +" VALUES (?, ? , ? , ? , ? , ? , ?)");
			createUser.setString(1, name);
			createUser.setString(2, num1);
			createUser.setString(3, num2);
			createUser.setString(4, num3);
			createUser.setString(5, num4);
			createUser.setString(6, num5);
			createUser.setString(7, num6);
			int rowsUpdated = createUser.executeUpdate();
			createUser.close();
			
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
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
			}
			connection.close();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		}



public static void main(String[] args)
{
	try {
		MyServlet jdbc = new MyServlet();
	} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
}
}
	
	
		
		
	
	



