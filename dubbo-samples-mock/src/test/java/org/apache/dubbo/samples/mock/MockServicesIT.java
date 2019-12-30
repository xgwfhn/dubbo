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
package org.apache.dubbo.samples.mock;

import org.apache.dubbo.samples.mock.api.DemoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:spring/mock-consumer.xml")
public class MockServicesIT {
    @Autowired
    @Qualifier("demoService")
    private DemoService service;

    @Test
    public void testMock() {
        String response = service.sayHello("world");
        assertThat(response, is("mock world"));
    }
    
    
    //服务端超时将会返还null  即忽略了异常  
    @Test
    public void testSayHelloReturnNullByTimeout() {
        String response = service.sayHelloReturnNullByTimeout("world");
        System.out.println("response---"+response);
        assertThat(response, is("mock world"));
    }
    
    //服务端不对异常处理,消费端不报错,但无法获取到返回值,客户端无法执行调用后面的代码
    @Test
    public void testSayHelloReturnNullByExceptionNoHandle() throws Exception {
        String response = service.sayHelloReturnNullByExceptionNoHandle("world");
        System.out.println("response---"+response);
        assertThat(response, is("mock world"));
    }
    
    //服务端进行了异常处理,获取到返回值
    @Test
    public void testSayHelloReturnNullByExceptionHandle() {
        String response = service.sayHelloReturnNullByExceptionHandle("world");
        System.out.println("response---"+response);
        assertThat(response, is("mock world"));
    }
    
    //服务端未进行异常处理  消费端org.apache.dubbo.rpc.RpcException: Invoke remote method timeout.  why?
    @Test
    public void testSayHelloReturnNullByThrowExcetion() {
        String response = service.sayHelloReturnNullByThrowExcetion("world");
        System.out.println("response---"+response);
        assertThat(response, is("mock world"));
    }
    
}