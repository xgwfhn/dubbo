
版本   apache dubbo 2.7.3  jdk1.8   apache-maven-3.3.9  zookeeper-3.4.14

dubbo 负载均衡 需要安装dubbo-admin 通过它进行设置服务端被调用的比例   多个服务端向zookeeper注册服务后  可以在dubbo-admin中通过端口来区分
负载均衡
dubbo-admin下载部署(dubbo-admin项目下载地址变更)
	要先启动zookeeper,dubbo-admin 回去连接它
	下载地址  https://github.com/apache/dubbo-admin
	部署
	apache版本
	https://blog.csdn.net/tuantuanyua/article/details/76582080
	
	dubbo-admin(alibaba)部署
	下载地址 https://github.com/apache/dubbo/releases
	https://blog.csdn.net/ChinaMuZhe/article/details/80748843（测试通过）
	alibaba版本时  dubbo-admin是在源码中    apache版本后  已经将dubbo-admin去除
	部署版本:dubbo-dubbo-2.5.10    apache-maven-3.3.9   jdk1.8  zookeeper-3.4.14
	
dubbo负载均衡策略  配置
在消费端设置
<dubbo:reference interface="..." loadbalance="roundrobin" />在消费端配置后  服务端就不需要配置了
在服务端设置
<dubbo:service interface="..." loadbalance="roundrobin" /> 在服务端配置后  消费端就不需要配置了

zookeeper-端口说明
https://blog.csdn.net/webnum/article/details/76653665
Dubbo之dubbo协议
https://blog.csdn.net/lixinkuan328/article/details/103230879

dubbo服务端修改后  要重新向zookeeper注册  才能生效
所有负载均衡策略 值都要小写   如<dubbo:reference interface="..." loadbalance="roundrobin" />


多个服务端启动 向zookeeper注册服务时会报22222端口占用  但是还是能注册成功
