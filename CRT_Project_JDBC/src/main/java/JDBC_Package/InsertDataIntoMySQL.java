package JDBC_Package;
import java.sql.*;
import java.sql.PreparedStatement;
public class InsertDataIntoMySQL {
	
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/CRT_JDBC";
		String user = "root";
		String password = "123456";
		try {
			 // Step 2:Load and Register the Drivers
			Class.forName("com.mysql.cj.jdbc.Driver"); // cj means we are using the connectors
			
			// Step 3: Connect to MySQL.
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.print("Database Connection Successful.");
			
			// Step 4: Create Table Queries
			Statement stmt = con.createStatement();
			String createTable = "CREATE TABLE IF NOT EXISTS rcoem_std "
					+ "("+" std_no INT PRIMARY KEY,"+"std_name VARCHAR(100),"+"std_salary DOUBLE)";
			
			// Step 5: Execute the Table Queries
			stmt.executeUpdate(createTable);
			
			// Step 6: Get Connect
			System.out.print("Table Created Successful: rcoem_std");
			
			// Step 4: Create Queries to insert the data in the table
			String insertData = "INSERT INTO rcoem_std (std_no,std_name,std_salary) VALUES(?,?,?)";
			
			PreparedStatement pst = con.prepareStatement(insertData);
			
			// Insert 1st std data.
			pst.setInt(1,201);
			pst.setString(2,"Soham");
			pst.setDouble(3,12345.65);
			
			pst.executeUpdate();
			
			// Insert 2st std data.
			pst.setInt(1,202);
			pst.setString(2,"Parth");
			pst.setDouble(3,12453.78);
			
			pst.executeUpdate();

			// Insert 3st std data.
			pst.setInt(1,203);
			pst.setString(2,"Rohit");
			pst.setDouble(3,23456.98);
			
			pst.executeUpdate();

			// Insert 4st std data.
			pst.setInt(1,204);
			pst.setString(2,"Priyanshu");
			pst.setDouble(3,65432.56);
			
			pst.executeUpdate();

			// Insert 5st std data.
			pst.setInt(1,205);
			pst.setString(2,"Yash");
			pst.setDouble(3,45678.23);
			
			pst.executeUpdate();

			System.out.println("Students Rrecords Inserted Successfully");
			
			
			// Step 7: Close the Connection
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
