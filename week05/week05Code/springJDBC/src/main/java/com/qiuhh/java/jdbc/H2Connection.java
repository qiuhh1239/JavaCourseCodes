package com.qiuhh.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2Connection {
	/**
	 * @param args
         * @author www.zuidaima.com
	 */
	private H2ServerStart server;
	public Connection connInit() {
		
		server = new H2ServerStart();
		Connection conn = null;
			server.startH2();
			try {
				Class.forName("org.h2.Driver");
				conn = DriverManager.getConnection("jdbc:h2:tcp://localhost:9123/mem:DBTest", "","");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return conn;
	}
	
	
	public void stopConnection(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn = null;
		}
		
		server.stopH2();
	}

}
