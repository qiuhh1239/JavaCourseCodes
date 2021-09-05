package com.qiuhh.java.jdbc;

import java.sql.Connection;

public class SimpleJDBCMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		H2Connection h2Init = new H2Connection();
		Connection conn = h2Init.connInit();
		new H2CreateTable().createTable(conn);
	}

}
