服务端异步
版本   apache dubbo 2.7.2  jdk1.8   apache-maven-3.3.9  zookeeper-3.4.14

Provider端异步执行将阻塞的业务从Dubbo内部线程池切换到业务自定义线程，避免Dubbo线程池的过度占用，有助于避免不同服务间的互相影响。
异步执行无益于节省资源或提升RPC响应性能，因为如果业务执行需要阻塞，则始终还是要有线程来负责执行

测试结果
服务端会先执行完方法里的代码,然后再切换到线程里的代码,最终消费端收到线程代码里的返回值

从v2.7.0开始，Dubbo的所有异步编程接口开始以CompletableFuture为基础
官方文档  http://dubbo.apache.org/zh-cn/docs/user/demos/async-execute-on-provider.html