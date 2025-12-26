package JDBC_Package;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

// We have to fetch the data form the database and show it in the UI using different buttons
public class CombineUI_and_JDBC extends JFrame implements ActionListener{
	//UI
	JLabel l1, l2, l3;
	JTextField tf1, tf2, tf3;
	JButton b1, b2, b3, b4;
	
	//JDBC
	Connection con;
	Statement st;
	ResultSet rs; // to fetch the data
	
	CombineUI_and_JDBC(){
		// UI 
		setLayout(null);
		l1 = new JLabel("std_no: ");
		l2 = new JLabel("std_name: ");
		l3 = new JLabel("std_salary: ");
		
		tf1 = new JTextField();
		tf2 = new JTextField();
		tf3 = new JTextField();
		
		b1 = new JButton("First");
		b2 = new JButton("Next");
		b3 = new JButton("Prev");
		b4 = new JButton("Last");
		
		l1.setBounds(100,100,100,30);
		tf1.setBounds(220,100,100,30);
		
		l2.setBounds(100,140,100,30);
		tf2.setBounds(220,140,100,30);
		
		l3.setBounds(100,180,100,30);
		tf3.setBounds(220,180,100,30);
		
		b1.setBounds(100,220,100,30);
		b2.setBounds(220,220,100,30);
		
		b3.setBounds(100,260,100,30);
		b4.setBounds(220,260,100,30);
		
		add(l1);
		add(tf1);
		
		add(l2);
		add(tf2);
		
		add(l3);
		add(tf3);
		
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		
		// JDBC Connection
		String url = "jdbc:mysql://localhost:3306/CRT_JDBC";
		String user = "root";
		String password = "123456";
		try {
			 // Step 2:Load and Register the Drivers
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Step 3: Connect to MySQL.
			Connection con = DriverManager.getConnection(url, user, password);
			
			st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			//
			rs = st.executeQuery("SELECT * FROM rcoem_std");
			
			if(rs.next()) {
				tf1.setText(rs.getString(1));
				tf2.setText(rs.getString(2));
				tf3.setText(rs.getString(3));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void actionPerformed(ActionEvent ae) {
		try {
			JButton B = (JButton)ae.getSource();
			if(B == b1){ // Coming on First Button
				rs.first();
			}
			else if(B == b2) { // For Last Button
					if(!rs.isLast()) {
					rs.next();
				}
			}
			else if(B == b3) { // For Previous Button
				if(!rs.isFirst()) {
					rs.previous();
				}
			}
			else if(B == b4){ // For last button
				rs.last();
			}
			
			tf1.setText(rs.getString(1));
			tf2.setText(rs.getString(2));
			tf3.setText(rs.getString(3));
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		CombineUI_and_JDBC e = new CombineUI_and_JDBC();
		e.setVisible(true);
		e.setSize(600,600);
		
		e.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
	}

}

