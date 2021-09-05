package com.qiuhh.java.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class H2CreateTable {
	
	public boolean createTable(Connection conn) {
		
		
		Statement stmt;
		try {
			stmt = conn.createStatement();
			String createSql = "create table city(id integer not null,city_name varchar(255))";
			stmt.executeUpdate(createSql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}
	
	public boolean createTable(Connection conn,String sql) {
		
		
		Statement stmt;
		try {
			stmt = conn.createStatement();
			String createSql = "create table city(id integer not null,city_name varchar(255))";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}

}
