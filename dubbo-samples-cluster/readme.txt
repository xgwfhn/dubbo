dubbo+zookeeper��Ⱥ
�汾   apache dubbo 2.7.3  jdk1.8   apache-maven-3.3.9  zookeeper-3.4.14

zookeeper��Ⱥ
windows�汾
https://blog.csdn.net/u010739551/article/details/51924088
linux�汾
https://my.oschina.net/stonezing/blog/502834
https://blog.csdn.net/fd2025/article/details/79958461

zookeeper�и���Ĭ�϶˿ڵ�����
https://blog.csdn.net/kangswx/article/details/102874493

2181 ��client���ṩ����
2888 ��Ⱥ�ڼ���ͨѶʹ�õĶ˿�
3888 ��Ⱥѡ��leader
��ÿ��zookeeper��conf�µ�zoo.cfg�ļ�������
dataDir = dataPath
clientPORT = 2181
server.1=host1:2888:3888
server.2=host2:2888:3888
server.3=host3:2888:3888

������ַ https://github.com/apache/dubbo-samples
Դ���ַ:http://dubbo.apache.org/zh-cn/blog/download.html
eclipse ����Դ��  https://blog.csdn.net/cherrycheng_/article/details/50917049
jar ��Դ���ַ : ��maven �ֿ�   ����jar����ҳ��   Files	jar (2.2 MB)  View All   ���  View All  

���� �ص��������е�zookeeper��   ���Ѷ��Ƿ��ܵ���������zookeeper

��̨ zookeeper  zoo.cfg����
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