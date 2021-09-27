package com.qiuhh.java.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLPreparedStatementCurd {
	
	public boolean createData(Connection conn,int id,double money) {
		
		// 添加一条语句
		 String insertSql = "insert into orders(user_id,money) values(?,?)";
		 PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(insertSql);
			stmt.setInt(1, id);
			stmt.setDouble(2, money);
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
			stmt = conn.prepareStatement("SELECT * FROM orders ");
			ResultSet rs = stmt.executeQuery();
			Orders order = null;
			 while (rs.next()) {
				
				 long id = rs.getLong("id");
				 int userId = rs.getInt("user_id");
				 double money = rs.getDouble("money");
				 order = new Orders(id,userId,money);
				 
				 System.out.println(order);
				 result.add(order);
				 
			 }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 return result;
	}
	
	public boolean updateData(Connection conn,long id,double money) {
		
		// sql
		 String sql = "update orders set money=? where id = ?";
		 PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setDouble(1, money);
			stmt.setLong(2, id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public boolean deleteData(Connection conn,long id) {
		
		// SQL语句
		 String sql = "delete from orders where id = ?";
		 PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setLong(1, id);
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
	public boolean batchCreateData(Connection conn,List<Orders> ordersArr) {
		
		// 添加一条语句
		 String insertSql = "insert into orders(user_id,money) values(?,?)";
		 PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(insertSql);
			
			int userId = 0 ;
			double money = 0;
			Orders order = null;
			for(int i=0;i<ordersArr.size();i++) {
				order = ordersArr.get(i);
				userId = order.getUser_id();
				money = order.getMoney();
				
				stmt.setInt(1, userId);
				stmt.setDouble(2, money);
				stmt.addBatch();
				
				if(i % 500 == 0) {
                    
                    //2.  攒够500,执行一次batch
					stmt.executeBatch();
                    
                    //3. 清空batch
					stmt.clearBatch();
                }
			}
		
			stmt.executeBatch();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public boolean createRollbackData(Connection conn,int id,double money) {
		
		// 添加一条语句
		 String insertSql = "insert into orders(user_id,money) values(?,?)";
		 PreparedStatement stmt = null;
		try {
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement(insertSql);
			stmt.setInt(1, id);
			stmt.setDouble(2, money);
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
