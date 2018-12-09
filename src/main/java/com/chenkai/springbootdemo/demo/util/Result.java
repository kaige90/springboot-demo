package com.chenkai.springbootdemo.demo.util;

import java.util.List;

public class Result<T> {

	/**
	 * 判断标识
	 */
	private boolean success=false;
	/**
	 * 错误码 
	 */
	private int code;
	/**
	 * 错误信息 
	 */
	private String message="";
	/**
	 * 返回的数据 
	 */
	private T obj;
	
	/**
	 * 服务器当前时间
	 */
	private int now;
	
	
	
	public void setSuccess() {
		this.code = ResultCode.SUCCESS;
		success = true;
	}
	public void setFalse() {
		this.code = ResultCode.FAILER;
		success = false;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
		if(this.code==ResultCode.SUCCESS){
			this.success=true;
		}
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getObj() {
		return obj;
	}
	public void setObj(T obj) {
		this.obj = obj;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public int getNow() {
		this.now = (int)(System.currentTimeMillis()/1000);
		return now;
	}
	public void setNow(int now) {
		this.now = now;
	}

	public static Result successResult(){
		Result result = new Result();
		result.setSuccess();
		return result;
	}

	public static Result successResult(Object o){
		Result result = new Result();
		result.setObj(o);
		result.setSuccess();
		return result;
	}

}
