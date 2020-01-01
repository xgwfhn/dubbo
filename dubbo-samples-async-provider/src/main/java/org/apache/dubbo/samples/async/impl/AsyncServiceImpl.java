/*
 *
 *   Licensed to the Apache Software Foundation (ASF) under one or more
 *   contributor license agreements.  See the NOTICE file distributed with
 *   this work for additional information regarding copyright ownership.
 *   The ASF licenses this file to You under the Apache License, Version 2.0
 *   (the "License"); you may not use this file except in compliance with
 *   the License.  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 */

package org.apache.dubbo.samples.async.impl;

import org.apache.dubbo.rpc.AsyncContext;
import org.apache.dubbo.rpc.RpcContext;
import org.apache.dubbo.samples.async.api.AsyncService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AsyncServiceImpl implements AsyncService {
    private static Logger logger = LoggerFactory.getLogger(AsyncServiceImpl.class);

    //Provider端异步执行将阻塞的业务从Dubbo内部线程池切换到业务自定义线程，避免Dubbo线程池的过度占用，有助于避免不同服务间的互相影响。
    //异步执行无益于节省资源或提升RPC响应性能，因为如果业务执行需要阻塞，则始终还是要有线程来负责执行
    @Override
    public String sayHello(String name) {
        AsyncContext asyncContext = RpcContext.startAsync();
        logger.info("sayHello start");
        
        new Thread(() -> {
            asyncContext.signalContextSwitch(); // 如果要使用上下文，则必须要放在第一句执行
            logger.info("Attachment from consumer: " + RpcContext.getContext().getAttachment("consumer-key1"));
            logger.info("async start");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 写回响应
            asyncContext.write("Hello " + name + ", response from provider.");
            logger.info("async end");
        }).start();

        logger.info("sayHello end");
        return "hello, " + name;
    }

}
