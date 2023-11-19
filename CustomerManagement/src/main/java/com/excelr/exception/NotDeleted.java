package com.excelr.exception;

public class NotDeleted extends RuntimeException{
	String msg;

	public NotDeleted(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}
}
