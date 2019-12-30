服务降级
版本   apache dubbo 2.7.3  jdk1.8   apache-maven-3.3.9  zookeeper-3.4.14

服务降级 :当服务响应超时 则走DemoServiceMock  否则走DemoServiceImpl
参考
https://blog.csdn.net/qq_34680763/article/details/102904912

Dubbo分布式应用面对高并发时的一种解决方式
https://blog.csdn.net/admin123404/article/details/97484710

dubbo 官方文档
http://dubbo.apache.org/zh-cn/docs/user/demos/subscribe-only.html

可以自定义位置mock的处理类  也可以使用默认位置的mock处理类
dubbo 服务每次修改代码后  都要重新注册  如何做到热部署
dubbo超时重试和异常处理
https://www.cnblogs.com/xuwc/p/8974709.html

在开发自测，联调过程中，经常碰到一些下游服务调用不通的场景，这个时候我们如何不依赖于下游系统，就业务系统独立完成自测？
dubbo自身是支持mock服务的，在reference标签里，有一个参数mock，该参数有四个值，false,default,true,或者Mock类的类名。分别代表如下含义:
false，不调用mock服务。
true，当服务调用失败时，使用mock服务。
default，当服务调用失败时，使用mock服务。