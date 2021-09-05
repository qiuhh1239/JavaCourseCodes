package com.qiuhh.java.jdbc;

import java.sql.SQLException;
import org.h2.tools.Server;

public class H2ServerStart {

	private Server server;

	//H2数据库服务器启动实例
    /*
     * 应用初始化时启动H2数据库
     */
    public void startH2() {
        try {
            System.out.println("正在启动h2数据库...");
            //使用org.h2.tools.Server这个类创建一个H2数据库的服务并启动服务，由于没有指定任何参数，那么H2数据库启动时默认占用的端口就是8082
            server =  org.h2.tools.Server.createTcpServer("-tcpPort", "9123").start();
            System.out.println("h2数据库启动成功...");
        } catch (SQLException e) {
            System.out.println("启动h2数据库出错：" + e.toString());
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /*
     * 应用销毁时停止H2数据库
     */
	 public void stopH2() {
	    if (this.server != null) {
	        // 停止H2数据库
	        this.server.stop();
	        this.server = null;
	    }
	}
}
