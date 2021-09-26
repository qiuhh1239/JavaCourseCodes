package com.qiuhh.java.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class SimpleJDBCMain {

	public static void main(String[] args) {
		
		
		//==================使用Hikari
		System.out.println(" Hikari  PreparedStatement方式 执行增删改查");
		Connection conn;
		try {
			HikariConn.getInstance().start();
			 conn = HikariConn.getInstance().getConnection();
			 preparedCurd(conn);
			 HikariConn.getInstance().stop();
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     
	}
	  public static void preparedCurd(Connection conn) {
		  SQLPreparedStatementCurd curd2 = new SQLPreparedStatementCurd();
			curd2.createData(conn, 1,100);
			curd2.createData(conn, 2,200);
			curd2.read(conn);
			
			curd2.updateData(conn, 1, 110);
			curd2.read(conn);
			
			System.out.println("删除操作");
			curd2.deleteData(conn, 10);
			curd2.read(conn);
	
			/*	System.out.println("批量添加");
				curd2.batchCreateData(conn, 1,15D,10);*/
			curd2.read(conn);
			
			
			curd2.deleteData(conn, 1);
			curd2.read(conn);
			curd2.createRollbackData(conn, 1,555);
			curd2.read(conn);
      }

}
