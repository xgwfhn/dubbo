
版本 org.apache.dubbo2.7.2  jdk1.8   apache-maven-3.3.9  zookeeper-3.4.14

dubbo 自定义异常处理
org.apache.dubbo2.7.2 版本能捕获到自定义的异常  并不像之前的alibaba的版本捕获不到
参考
https://blog.csdn.net/wddddddsd/article/details/86540176
https://blog.csdn.net/zlfing/article/details/86676921


以jar包的形式部署
	拷贝target中项目的jar包及lib 放置到服务器的同一目录下  如果需要添加或删除项目的jar  可以在项目中的jar包的META-INF/MANIFEST.MF 修改
	运行命令   cmd进入jar所在位置   执行  java -jar xxx.jar