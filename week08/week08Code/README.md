注意：  
config-sharding.yaml 配置  
dataSourceCommon，password 后加密码，密码前需要有空格  

必做题1  
[orders.sql](sqlSplit/config/orders.sql)是数据库脚本  
[config-sharding.yaml](sqlSplit/config/config-sharding.yaml)与[server.yaml](sqlSplit/config/server.yaml)是apache-shardingsphere-5.0.0-alpha-shardingsphere-proxy-bin的配置文件  
[SimpleJDBCMain.java](sqlSplit/src/main/java/com/qiuhh/java/jdbc/SimpleJDBCMain.java)是增删改查的main方法  