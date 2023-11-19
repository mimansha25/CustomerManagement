package com.excelr.exception;

@SuppressWarnings("serial")
public class InValidFirstnameOrLastnameException  extends RuntimeException{

	String msg;

	public InValidFirstnameOrLastnameException(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}
	
	
}
