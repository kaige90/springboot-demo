package com.chenkai.springbootdemo.demo.exception;

public class ExceptionMsg {

	public final static ExceptionMsg NULL_PARAM = new ExceptionMsg(1000,"参数为空");
	public final static ExceptionMsg NULL_PROPERTY = new ExceptionMsg(1001,"属性为空");
	public final static ExceptionMsg ID_GENEREATE_ERROR = new ExceptionMsg(2000,"id生成出错");
	public final static ExceptionMsg SQL_INSERT_ERROR = new ExceptionMsg(3000,"保存出错");
	public final static ExceptionMsg SQL_DELETE_ERROR = new ExceptionMsg(3001,"删除出错");
	public final static ExceptionMsg SQL_UPDATE_ERROR = new ExceptionMsg(3002,"更新出错");
	public final static ExceptionMsg SQL_GET_ERROR = new ExceptionMsg(3003,"查询出错");
	public final static ExceptionMsg BUSS_ERROR = new ExceptionMsg(5000,"系统业务出错");
	public final static ExceptionMsg CUSTOM_ERROR = new ExceptionMsg(6000,"自定义错误");
	
	/**
	 * 自定义异常信息
	 * @param code 暂时定为[1000-2000)参数相关 [2000-3000)id生成出错 [3000-4000)sql相关 [5000-6000)业务错误 [6000-7000)自定义错误
	 * @param msg
	 */
	public ExceptionMsg(int code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}
	
	/**
	 * 生成 {@link #CUSTOM_ERROR}自定义错误
	 * @param msg
	 */
	public ExceptionMsg(String msg){
		this(CUSTOM_ERROR.getCode(),msg);
	}
	
	private int code;
	private String msg;
	public int getCode() {
		return code;
	}
	public String getMsg() {
		return msg;
	}
}
