package com.revature.michael_mcauliffe_p0.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

private Connection conn;
	
	public Connection createConnection() throws SQLException {
		
		Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres?", "postgres", "Link6453");
		
		return conn;
		
	}
}
