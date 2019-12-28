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

package org.apache.dubbo.samples.cache;

import org.apache.dubbo.samples.cache.api.CacheService;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CacheConsumer {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/cache-consumer.xml");
        context.start();

        CacheService cacheService = (CacheService) context.getBean("cacheService");

        // verify cache, same result is returned for different invocations (in fact, the return value increases
        // on every invocation on the server side)
        //验证缓存，对于不同的调用返回相同的结果（实际上，返回值会增加
        //在服务器端的每次调用中）
        //测试结果 
       /* OK: request: 0, response: 0
        OK: request: 0, response: 0
        OK: request: 0, response: 0
        OK: request: 0, response: 0
        OK: request: 0, response: 0*/
        String fix = null;
        for (int i = 0; i < 5; i++) {
            String result = cacheService.findCache("0");
            if (fix == null || fix.equals(result)) {
                System.out.println("OK: " + result);
            } else {
                System.err.println("ERROR: " + result);
            }
            fix = result;
            Thread.sleep(500);
        }

        // default cache.size is 1000 for LRU, should have cache expired if invoke more than 1001 times
        //LRU的默认cache.size为1000，如果调用次数超过1001次，则缓存应该已过期
        for (int n = 0; n < 1001; n++) {
            String pre = null;
            for (int i = 0; i < 10; i++) {
                String result = cacheService.findCache(String.valueOf(n));
                if (pre != null && !pre.equals(result)) {
                    System.err.println("ERROR: " + result);
                }
                pre = result;
            }
        }
        System.out.println("--------------end------");
        // verify if the first cache item is expired in LRU cache
        //验证LRU缓存中的第一个缓存项是否已过期
        //测试结果 OK: request: 0, response: 1001
         String result = cacheService.findCache("0");
        if (fix != null && !fix.equals(result)) {
            System.out.println("OK: " + result);
        } else {
            System.err.println("ERROR: " + result);
        }
    }

}
