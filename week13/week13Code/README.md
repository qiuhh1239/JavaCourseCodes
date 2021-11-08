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

6.（必做）思考和设计自定义 MQ 第二个版本或第三个版本，写代码实现其中至少一个功能点，把设计思路和实现代码，提交到 GitHub。

第二个版本：自定义 Queue

[MyQueue.java](qmq-core/src/main/java/bytes/qhh/qmq/core/MyQueue.java)
自定义数组，当前写入位置rightIndex,消费位置leftIndex;



