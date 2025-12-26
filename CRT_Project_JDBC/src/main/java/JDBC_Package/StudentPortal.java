package JDBC_Package;


import javax.swing.*;
import java.sql.*;

public class StudentPortal {

    JFrame frame;

    JLabel idLabel, nameLabel, marksLabel;
    JTextField idField, nameField, marksField;

    JButton firstBtn, nextBtn, prevBtn, lastBtn;

    Connection con;
    Statement stmt;
    ResultSet rs;

    StudentPortal() {

        frame = new JFrame("Student Records");

        // Labels
        idLabel = new JLabel("ID:");
        nameLabel = new JLabel("Name:");
        marksLabel = new JLabel("Marks:");

        // TextFields
        idField = new JTextField();
        nameField = new JTextField();
        marksField = new JTextField();

        // Buttons
        firstBtn = new JButton("First");
        nextBtn = new JButton("Next");
        prevBtn = new JButton("Previous");
        lastBtn = new JButton("Last");

        frame.setLayout(null);

        // Label positions
        idLabel.setBounds(50, 30, 80, 25);
        nameLabel.setBounds(50, 70, 80, 25);
        marksLabel.setBounds(50, 110, 80, 25);

        // TextField positions
        idField.setBounds(140, 30, 200, 25);
        nameField.setBounds(140, 70, 200, 25);
        marksField.setBounds(140, 110, 200, 25);

        // Button positions
        firstBtn.setBounds(30, 170, 80, 30);
        nextBtn.setBounds(120, 170, 80, 30);
        prevBtn.setBounds(210, 170, 100, 30);
        lastBtn.setBounds(320, 170, 80, 30);

        // Add components to frame
        frame.add(idLabel);
        frame.add(nameLabel);
        frame.add(marksLabel);

        frame.add(idField);
        frame.add(nameField);
        frame.add(marksField);

        frame.add(firstBtn);
        frame.add(nextBtn);
        frame.add(prevBtn);
        frame.add(lastBtn);

        frame.setSize(460, 280);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        connectDatabase();
        buttonActions();
    }

    void connectDatabase() {
        try {
        	String url = "jdbc:mysql://localhost:3306/CRT_JDBC";
    		String user = "root";
    		String pass = "123456";

            con = DriverManager.getConnection(url, user, pass);

            stmt = con.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            );

            rs = stmt.executeQuery("SELECT * FROM rcoem_std");

            if (rs.first()) {
                showRecord();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void showRecord() throws SQLException {
        idField.setText(String.valueOf(rs.getInt("std_no")));
        nameField.setText(rs.getString("std_name"));
        marksField.setText(String.valueOf(rs.getInt("std_salary")));
    }

    void buttonActions() {

        firstBtn.addActionListener(e -> {
            try {
                if (rs.first()) showRecord();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        nextBtn.addActionListener(e -> {
            try {
                if (rs.next()) showRecord();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        prevBtn.addActionListener(e -> {
            try {
                if (rs.previous()) showRecord();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        lastBtn.addActionListener(e -> {
            try {
                if (rs.last()) showRecord();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }

    public static void main(String[] args) {
        new StudentPortal();
    }
}
