package org.apache.dubbo.samples.mock.api.temp;

public class MockException {

	private String code;
	private String msg;
	
	public MockException(String code,String msg){
		this.code=code;
		this.msg=msg;
	}
}
