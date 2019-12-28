dubbo+zookeeper集群
版本   apache dubbo 2.7.3  jdk1.8   apache-maven-3.3.9  zookeeper-3.4.14

zookeeper集群
windows版本
https://blog.csdn.net/u010739551/article/details/51924088
linux版本
https://my.oschina.net/stonezing/blog/502834
https://blog.csdn.net/fd2025/article/details/79958461

zookeeper中各个默认端口的作用
https://blog.csdn.net/kangswx/article/details/102874493

2181 对client端提供服务
2888 集群内及其通讯使用的端口
3888 集群选举leader
在每个zookeeper的conf下的zoo.cfg文件中配置
dataDir = dataPath
clientPORT = 2181
server.1=host1:2888:3888
server.2=host2:2888:3888
server.3=host3:2888:3888

官网地址 https://github.com/apache/dubbo-samples
源码地址:http://dubbo.apache.org/zh-cn/blog/download.html
eclipse 关联源码  https://blog.csdn.net/cherrycheng_/article/details/50917049
jar 包源码地址 : 到maven 仓库   进入jar详情页面   Files	jar (2.2 MB)  View All   点击  View All  

测试 关掉正在运行的zookeeper后   消费端是否还能调用其他的zookeeper

三台 zookeeper  zoo.cfg配置
dataDir=C:/tool/zk/server1/zookeeper-3.4.14/data
dataLogDir=C:/tool/zk/server1/zookeeper-3.4.14/logs
clientPort=2181
server.1=127.0.0.1:8880:7770  
server.2=127.0.0.1:8881:7771  
server.3=127.0.0.1:8882:7772

dataDir=C:/tool/zk/server2/zookeeper-3.4.14/data
dataLogDir=C:/tool/zk/server2/zookeeper-3.4.14/logs
clientPort=2182
server.1=127.0.0.1:8880:7770  
server.2=127.0.0.1:8881:7771  
server.3=127.0.0.1:8882:7772

dataDir=C:/tool/zk/server3/zookeeper-3.4.14/data
dataLogDir=C:/tool/zk/server3/zookeeper-3.4.14/logs
clientPort=2183
server.1=127.0.0.1:8880:7770  
server.2=127.0.0.1:8881:7771  
server.3=127.0.0.1:8882:7772