版本   apache dubbo 2.7.3  jdk1.8   apache-maven-3.3.9  zookeeper-3.4.14

dubbo 官网demo  https://github.com/apache/dubbo-samples  master分支
##多版本
* 当一个接口实现，出现不兼容升级时，可以用版本号过渡，版本号不同的服务相互间不引用。
* 可以按照以下的步骤进行版本迁移：
  * 在低压力时间段，先升级一半提供者为新版本
  * 再将所有消费者升级为新版本
  * 然后将剩下的一半提供者升级为新版本

测试 同时启动俩个版本的接口服务
客户端  设置 version="*" 同时调用所有版本接口       
关闭其中一个版本的服务提供者  会报org.apache.dubbo.remoting.RemotingException:  连接失败


部署  将提供者 maven install 打成jar包    将jar包和lib 拷贝到同一目录下     cmd 进入 到该目录  java -jar xxx.jar 启动  如果要修改所依赖的ar  
打开要部署的jar包   找到 MANIFEST.MF  进行修改    如果没有install后  没有lib包  则要在pom.xml 加入lib的配置 

dubbo group和version的区别   目前未知