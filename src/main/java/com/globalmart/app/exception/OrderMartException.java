package com.globalmart.app.exception;

import org.springframework.validation.BindException;

public class OrderMartException extends Exception {
	
	public OrderMartException (String msg){
		super(msg);
	}

	public BindException getBindingResult() {
		// TODO Auto-generated method stub
		return null;
	}

}
