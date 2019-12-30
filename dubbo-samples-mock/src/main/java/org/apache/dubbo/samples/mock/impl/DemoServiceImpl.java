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

package org.apache.dubbo.samples.mock.impl;

import org.apache.dubbo.samples.mock.api.DemoService;

public class DemoServiceImpl implements DemoService {

    public String sayHello(String name) {
        try {
            // sleeping 5 seconds leads to TimeoutException on client side, and mock impl will be invoked
        	//sleeping 5 seconds leads to TimeoutException on client side, and mock impl will be invoked
        	//睡眠5秒会导致客户端发生TimeoutException，并将调用mock impl
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello " + name;
    }

	@Override
	public String sayHelloReturnNullByTimeout(String name) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return "hello " + name;
	}

	@Override
	public String sayHelloReturnNullByExceptionNoHandle(String name)throws Exception {

			int i=10;
			int b=i/0;
			return "hello " + name;
	}

	@Override
	public String sayHelloReturnNullByExceptionHandle(String name) {
		// TODO Auto-generated method stub
		try{
			int i=10;
			int b=i/0;
			return null;
		}catch(Exception e){
			e.printStackTrace();
		}
		 return "hello " + name;
	}

	@Override
	public String sayHelloReturnNullByThrowExcetion(String name) {
		int i=10;
		int b=i/0;
		return null;
	}
}
