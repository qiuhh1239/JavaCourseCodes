注意：  
config-sharding.yaml 配置  
dataSourceCommon，password 后加密码，密码前需要有空格  

必做题 2,使用shardingsphere-proxy中间件
[orders.sql](sqlSplit/config/orders.sql)是数据库脚本  
[config-sharding.yaml](sqlSplit/config/config-sharding.yaml)与[server.yaml](sqlSplit/config/server.yaml)是apache-shardingsphere-5.0.0-alpha-shardingsphere-proxy-bin的配置文件  
[SimpleJDBCMain.java](sqlSplit/src/main/java/com/qiuhh/java/jdbc/SimpleJDBCMain.java)是增删改查的main方法  

必做题 6  
没有业务逻辑，只是一个demo，基于 hmily TCC  
[demo.sql](hmily-demo-springcloud/config/demo.sql)是数据库脚本,没有写数据库逻辑，连接数据库是为了程序能正常运行;  

1、先启动Eureka服务[EurekaServerApplication.java](demo-Eureka/src/main/java/com/qhh/java/EurekaServerApplication.java)

2、再启动[SpringCloudHmilyDemoApplication.java](hmily-demo-springcloud/src/main/java/com/qhh/java/SpringCloudHmilyDemoApplication.java)

3、访问[http://localhost:8090/hello/say](http://localhost:8090/hello/say),查看控制台，控制台打印confirm hello world


