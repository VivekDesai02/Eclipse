package com.conn;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbConnection {
	public static Connection connection(){
		Connection conn = null;
		
		try {
			 Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
