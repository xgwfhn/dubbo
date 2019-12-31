消费端异步
版本   apache dubbo 2.7.2  jdk1.8   apache-maven-3.3.9  zookeeper-3.4.14

从v2.7.0开始，Dubbo的所有异步编程接口开始以CompletableFuture为基础

在消费端设置 async="true"   会进行异步调用

dubbo 官方文档  http://dubbo.apache.org/zh-cn/docs/user/demos/subscribe-only.html