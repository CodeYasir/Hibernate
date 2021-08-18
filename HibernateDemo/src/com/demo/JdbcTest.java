package com.demo;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcTest {

	public static void main(String[] args) {

		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
		String user="hbstudent";
	    String pass="hbstudent";
	    
	    try{
	    	Connection con=DriverManager.getConnection(jdbcUrl,user,pass);
	    	System.out.println("Connection Success");
	    }
	    catch(Exception e) {
	    	e.printStackTrace();
	    }
	}

}
