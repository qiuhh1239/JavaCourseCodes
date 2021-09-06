package com.qiuhh.java.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class H2PreparedStatementCurd {
	
	public boolean createData(Connection conn,int id,String city) {
		
		// 添加一条语句
		 String insertSql = "insert into city values(?,?)";
		 PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(insertSql);
			stmt.setInt(1, id);
			stmt.setString(2, city);
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public List read(Connection conn) {
		List result = new ArrayList();
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement("SELECT * FROM city ");
			ResultSet rs = stmt.executeQuery();
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
		 String sql = "update city set city_name=? where id = ?";
		 PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, city);
			stmt.setInt(2, id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public boolean deleteData(Connection conn,int id) {
		
		// SQL语句
		 String sql = "delete from city where id = ?";
		 PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	
	/**
	 * 
	 * @param conn  数据库链接
	 * @param id  
	 * @param city  城市名称
	 * @param num   批量插入数
	 * @return
	 */
	public boolean batchCreateData(Connection conn,int id,String city,int num) {
		
		// 添加一条语句
		 String insertSql = "insert into city values(?,?)";
		 PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(insertSql);
			
			for(int i=0;i<num;i++) {
				stmt.setInt(1, id+i);
				stmt.setString(2, city+i);
				stmt.addBatch();
			}
		
			stmt.executeBatch();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public boolean createRollbackData(Connection conn,int id,String city) {
		
		// 添加一条语句
		 String insertSql = "insert into city values(?,?)";
		 PreparedStatement stmt = null;
		try {
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement(insertSql);
			stmt.setInt(1, id);
			stmt.setString(2, city);
			stmt.execute();
			stmt.close();
			
			PreparedStatement stmt1 = conn.prepareStatement("select * from no_exit_table");
			stmt1.executeQuery();
			stmt1.close();
			
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("打印异常，事务回滚");
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return false;
		}finally {
			try {
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return true;
	}
	
}
