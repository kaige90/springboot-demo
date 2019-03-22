package com.chenkai.springbootdemo.demo.exception;

public class CommonException extends Exception{

	private static final long serialVersionUID = -1058736517486619711L;
	private ExceptionMsg exceptionMsg;

	public CommonException(){
		super(ExceptionMsg.CUSTOM_ERROR.getMsg());
		this.exceptionMsg = ExceptionMsg.CUSTOM_ERROR;
	}
	public CommonException(ExceptionMsg exceptionMsg){
		super(exceptionMsg.getMsg());
		this.exceptionMsg = exceptionMsg;
	}
	
	/**
	 * 自定义错误构造方法
	 * 它的ExceptionCodes
	 * @param errMsg 自定义错误描述
	 */
	public CommonException(String errMsg){
		super(errMsg);
		this.exceptionMsg = new ExceptionMsg(errMsg);
	}

	public int getErrCode() {
		return exceptionMsg.getCode();
	}
	
	public ExceptionMsg getCode(){
		return exceptionMsg;
	}
	
}
