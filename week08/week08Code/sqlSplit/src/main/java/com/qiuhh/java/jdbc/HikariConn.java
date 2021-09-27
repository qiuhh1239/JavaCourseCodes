package com.qiuhh.java.jdbc;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

	/**
	 * 数据库服务
	 * 
	 */
	public class HikariConn {

	    // 数据库连接
	    private HikariDataSource dataSource;
	    private static HikariConn hikariConn;
	    public static HikariConn getInstance(){
	        if (hikariConn == null) {
	        	hikariConn = new HikariConn();
	        	
	        }
	        return hikariConn;
	    }

	    public void start() throws IOException, SQLException {

	        HikariConfig config = new HikariConfig();
	        config.setMaximumPoolSize(10);
	        //com.mysql.cj.jdbc.Driver
	        config.setDriverClassName("com.mysql.jdbc.Driver");
	       // config.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/e_commerce_platform");
	        config.setJdbcUrl("jdbc:mysql://127.0.0.1:3307/sharding_db");
	        config.setUsername("root");
	        config.setPassword("root");
	        /* config.addDataSourceProperty("cachePrepStmts", "true");
	        config.addDataSourceProperty("prepStmtCacheSize", "250");
	        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");*/
	        // 设置连接超时为8小时
	        config.setConnectionTimeout(8 * 60 * 60);
	        dataSource = new HikariDataSource(config);
	    }

	 
	    public Connection getConnection() throws SQLException {
	        try {
	            return dataSource.getConnection();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }   
	     }

	    public boolean stop() throws SQLException {
	        dataSource.close();
	        return true;
	    }
}
