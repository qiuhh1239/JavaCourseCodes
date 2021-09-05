package com.qiuhh.java.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class H2Curd {
	
	public boolean createData(Connection conn,int id,String city) {
		
		// 添加一条语句
		 String insertSql = "insert into city values("+id+",'"+city+"')";
		 Statement stmt = null;
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(insertSql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public List read(Connection conn) {
		List result = new ArrayList();
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM city ");
			City city = null;
			 while (rs.next()) {
				
				 int id = rs.getInt("id");
				 String cityName = rs.getString("city_name");
				 city = new City(id,cityName);
				 
				 System.out.println(city);
				 result.add(city);
				 
			 }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 return result;
	}
	
	public boolean updateData(Connection conn,int id,String city) {
		
		// sql
		 String sql = "update city set city_name='"+city+"' where id = "+id ;
		 Statement stmt = null;
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public boolean deleteData(Connection conn,int id) {
		
		// SQL语句
		 String sql = "delete from city where id = "+id ;
		 Statement stmt = null;
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

}
