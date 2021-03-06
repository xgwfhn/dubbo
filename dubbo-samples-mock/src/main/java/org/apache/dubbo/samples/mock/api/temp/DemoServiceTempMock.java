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

package org.apache.dubbo.samples.mock.api.temp;

import org.apache.dubbo.samples.mock.api.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//DemoServiceMock必须和DemoService在同一目录下  否则找不到  并且命名格式接口名+Mock
public class DemoServiceTempMock implements DemoService {
    private static Logger logger = LoggerFactory.getLogger(DemoServiceTempMock.class);

    public String sayHello(String name) {
        logger.warn("about to execute mock: " + DemoServiceTempMock.class.getSimpleName());
        return "mockTemp " + name;
    }


	@Override
	public String sayHelloReturnNullByTimeout(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String sayHelloReturnNullByExceptionNoHandle(String name)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String sayHelloReturnNullByExceptionHandle(String name) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String sayHelloReturnNullByThrowExcetion(String name) {
		// TODO Auto-generated method stub
		return null;
	}
}
