package com.qiuhh.java.jdbc;

import java.sql.Connection;

public class SimpleJDBCMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		H2Connection h2Init = new H2Connection();
		Connection conn = h2Init.connInit();
		//创建表
		new H2CreateTable().createTable(conn);
		
		//执行增删改查
		H2Curd curd = new H2Curd();
		curd.createData(conn, 1,"北京");
		curd.createData(conn, 2,"北京");
		curd.read(conn);
		
		curd.updateData(conn, 1, "tianjin");
		curd.read(conn);
		h2Init.stopConnection(conn);
	}

}
