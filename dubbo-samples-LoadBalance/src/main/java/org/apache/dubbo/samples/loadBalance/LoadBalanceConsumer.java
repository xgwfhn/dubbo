/*
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
 */

package org.apache.dubbo.samples.loadBalance;

import org.apache.dubbo.samples.loadBalance.api.DemoService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LoadBalanceConsumer {
    private static Logger logger = LoggerFactory.getLogger(LoadBalanceConsumer.class);

   public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/loadBalance-consumer.xml");
        context.start();
        for(int i=0;i<=50;i++) {
	        DemoService demoService = context.getBean("demoService", DemoService.class);
	        String hello = demoService.sayHello("world");
	        try {
				Thread.sleep(1000);
		        System.out.println("------------"+hello);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
        }
    }
    
    //ConsistentHash LoadBalance   一致性Hash，相同参数的请求总是发到同一提供者
    //当某一台提供者挂时，原本发往该提供者的请求，基于虚拟节点，平摊到其它提供者，不会引起剧烈变动
    /*public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/loadBalance-consumer.xml");
        context.start();
        for(int i=0;i<=50;i++) {
        	String hello=""; 
	        DemoService demoService = context.getBean("demoService", DemoService.class);
	        if(i%2==0){
		         hello = demoService.sayHello("world1");
	        }else{
		         hello = demoService.sayHello("world2");
	        }
	        try {
				Thread.sleep(1000);
		        System.out.println("------------"+hello);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
        }
    }*/
}
