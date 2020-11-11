package com.revature.michael_mcauliffe_p0.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.revature.michael_mcauliffe_p0.pojos.Log;

public class ConnectionUtil {

	private static Log log = new Log();
	
    private static ConnectionUtil instance;
    private Connection connection;
    
    private String url = "jdbc:postgresql://localhost:5432/postgres?";
    private String username = "postgres";
    private String password = "Link6453";

    private ConnectionUtil() throws SQLException {
    	
        try {
        	
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(url, username, password);
        
        } catch (ClassNotFoundException cnfe) {
        	
        	new Thread(() -> {log.info("Database Connection Creation Failed : "
        					+ cnfe.getMessage());}).start();

        }
    }

    public Connection getConnection() {
    	
        return connection;
    }

    public static ConnectionUtil getInstance() throws SQLException {
    	
        if (instance == null) {
        	
            instance = new ConnectionUtil();
            
        } else if (instance.getConnection().isClosed()) {
        	
            instance = new ConnectionUtil();
        }

        return instance;
    }
}