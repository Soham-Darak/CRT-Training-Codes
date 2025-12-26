package JDBC_Package;
/*
	Step 1: SQL
	Step 2: Drivers and Loaders
	Step 3: Connection
	Step 4: Write the Queries
	Step 5: Execute the Queries
	Step 6: Data Base -> Table -> CRUD
	Step 7: Close 
*/
// Step 1: import java.sql*;
import java.sql.*;

public class JDBC_Basics {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/?useSSL=false&serverTimezone=UTC";
		String user = "root";
		String password = "123456";
		String dbName = "CRT_JDBC";
		try {
			// Step 2:Load and Register the Drivers
			Class.forName("com.mysql.cj.jdbc.Driver"); // cj means we are using the connectors
			
			// Step 3: Connect to MySQL.
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.print("Database Connection Successful.");
			
			// Step 4: Create SQL Queries
			Statement stmt = con.createStatement();
			String sql = "CREATE DATABASE " + dbName;
			
			// Step 5: Execute the SQL Queries
			stmt.executeUpdate(sql);
			
			// Step 6: Get Connect
			System.out.print("Database Created Successful: "+dbName);
			
			// Step 7: Close the Connection
			con.close();

		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
