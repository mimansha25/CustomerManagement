package com.excelr.exception;

public class EmptyBodyException extends RuntimeException{

	String msg;

	public EmptyBodyException(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}
}
