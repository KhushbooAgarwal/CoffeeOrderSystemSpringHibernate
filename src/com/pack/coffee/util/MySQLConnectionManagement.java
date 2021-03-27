package com.pack.coffee.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnectionManagement {
	
static private Connection connection;
	
	public static Connection getConnection()throws ClassNotFoundException,SQLException{
			
		Class.forName("oracle.jdbc.driver.OracleDriver");
		connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","wiley123"); 
		return connection;
		
	}
	

}
