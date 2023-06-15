package projects.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import java.util.Properties;
import projects.exception.*;

public class DbConnection {
	
	private static final String HOST = "localhost";
	private static final String PASSWORD = "projects@123";
	private static int PORT = 3306;
	private static final String SCHEMA = "projects";
	private static final String USER = "projects";
	
	public static Connection getConnection()
	{
		String url = String.format("jdbc:mysql://%s:%d/%s?user=%s&password=%s", HOST, PORT, SCHEMA, USER, PASSWORD);
		System.out.println("Connecting with url = " + url);
	
	try {
       
         Connection conn = DriverManager.getConnection(url);
         System.out.println("Connection to schema " + SCHEMA + " is successful.");
         return conn;
        
    } catch (SQLException e) {
        System.out.println("Unable to get connect at " + url);
        throw new DbException(e);
        //throw new DbException("Unable to get connect at \" + url");
    }
}
}
