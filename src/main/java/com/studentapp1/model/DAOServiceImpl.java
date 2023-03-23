package com.studentapp1.model;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class DAOServiceImpl implements DAOService {
	
	private Connection con;
	private java.sql.Statement stmt;
	

	@Override
	public void connectionDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Establish the connection to the database
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_database","root","test@123");
			//create a statement--> connection is the interface of statement
			stmt= con.createStatement();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	public boolean verifyCredentials(String email, String password) {
		
		//it checks database whether the given details are  correct or not 
		try {
		 ResultSet result =stmt.executeQuery("select *from login where email='"+email+"'and password='"+password+"'");
		 return result.next();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void saveReg(String name, String city, String email, String mobile) {
		try {
			 stmt.executeUpdate("insert into registration values('"+name+"','"+city+"','"+email+"','"+mobile+"')");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
