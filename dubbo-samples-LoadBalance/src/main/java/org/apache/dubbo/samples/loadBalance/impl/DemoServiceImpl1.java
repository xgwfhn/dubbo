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

package org.apache.dubbo.samples.loadBalance.impl;

import org.apache.dubbo.samples.loadBalance.api.DemoService;

public class DemoServiceImpl1 implements DemoService {

    public String sayHello(String name) {
       /* try {
            // sleeping 5 seconds leads to TimeoutException on client side, and mock impl will be invoked
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        }*/
      /*  try {
			Thread.sleep(10000);//模拟服务端超时  这时dubbo将执行DemoServiceMock 的sayHello降至处理
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
        return "第一个服务提供者" + name;
    }
}
