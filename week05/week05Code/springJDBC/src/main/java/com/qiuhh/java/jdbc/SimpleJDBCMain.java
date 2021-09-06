package com.qiuhh.java.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class SimpleJDBCMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		H2Connection h2Init = new H2Connection();
		Connection conn = h2Init.connInit();
		//创建表
		new H2CreateTable().createTable(conn);
		
		//Statement方式 执行增删改查
		H2Curd curd = new H2Curd();
		curd.createData(conn, 1,"北京");
		curd.createData(conn, 2,"北京");
		curd.read(conn);
		
		curd.updateData(conn, 1, "tianjin");
		curd.read(conn);
		
		System.out.println("删除操作");
		curd.deleteData(conn, 1);
		curd.read(conn);
		
		
		//PreparedStatement方式 执行增删改查
		
		System.out.println("PreparedStatement方式 执行增删改查");
		preparedCurd(conn);
	
		
		
		//==================使用Hikari
		System.out.println(" Hikari  PreparedStatement方式 执行增删改查");
		try {
			HikariConn.getInstance().start();
			 conn = HikariConn.getInstance().getConnection();
			 preparedCurd(conn);
			 HikariConn.getInstance().stop();
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		h2Init.stopConnection(conn);
     
	}
	  public static void preparedCurd(Connection conn) {
   	   H2PreparedStatementCurd curd2 = new H2PreparedStatementCurd();
			curd2.createData(conn, 1,"北京");
			curd2.createData(conn, 2,"北京");
			curd2.read(conn);
			
			curd2.updateData(conn, 1, "tianjin");
			curd2.read(conn);
			
			System.out.println("删除操作");
			curd2.deleteData(conn, 1);
			curd2.read(conn);
	
			System.out.println("批量添加");
			curd2.batchCreateData(conn, 1,"北京",10);
			curd2.read(conn);
			
			
			curd2.deleteData(conn, 1);
			curd2.read(conn);
			curd2.createRollbackData(conn, 1,"no_exit");
			curd2.read(conn);
      }

}
