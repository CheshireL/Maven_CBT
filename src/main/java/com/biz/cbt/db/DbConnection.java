package com.biz.cbt.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

static private Connection dbConn;
	
	static {
		
		String oracleDriver = "oracle.jdbc.driver.OracleDriver";
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "myBTs";
		String password = "1234";
		
		try {
			Class.forName(oracleDriver);
			dbConn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
		
		
		

}
