注意：  
config-sharding.yaml 配置  
dataSourceCommon，password 后加密码，密码前需要有空格  

1.（必做）搭建一个 3 节点 Kafka 集群，测试功能和性能；实现 spring kafka 下对 kafka 集群的操作，将代码提交到 github。
 
搭建一个 3 节点 Kafka 集群，测试功能和性能,配置文件
[kafka9001.properties](spring-kafka-example/config/kafka9001.properties)，
[kafka9002.properties](spring-kafka-example/config/kafka9002.properties)，
[kafka9003.properties](spring-kafka-example/config/kafka9003.properties)，
[zookeeper.properties](spring-kafka-example/config/zookeeper.properties)


实现 spring kafka 下对 kafka 集群的操作
配置文件

[application.properties](spring-kafka-example/src/main/resources/application.properties)

启动
[KafkaDemoApplication.java](spring-kafka-example/src/main/java/bytes/qhh/kafkaApp/KafkaDemoApplication.java)
主方法，producer生成数据，[KafkaConsumerListener.java](spring-kafka-example/src/main/java/bytes/qhh/kafkaApp/KafkaConsumerListener.java)消费端在控制台打印信息



