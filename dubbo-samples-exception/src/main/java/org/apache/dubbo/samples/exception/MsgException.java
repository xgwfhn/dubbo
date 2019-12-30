package org.apache.dubbo.samples.exception;

public class MsgException extends Exception {

	private String code;
	private String msg;
	
	
	
	public String getCode() {
		return code;
	}



	public void setCode(String code) {
		this.code = code;
	}



	public String getMsg() {
		return msg;
	}



	public void setMsg(String msg) {
		this.msg = msg;
	}



	public MsgException(String code,String msg){
		this.code=code;
		this.msg=msg;
	}
}
