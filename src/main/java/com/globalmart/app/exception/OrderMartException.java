package com.globalmart.app.exception;

import org.springframework.validation.BindException;

@SuppressWarnings("serial")
public class OrderMartException extends Exception {
	
	/************************************************************************************
	 * @author Abhishek  Yadav
	 * 
	 *         Description : It is a Order Exception class that handles exceptions
	 *         for the Order module.
	 * 
	 *         Version 1.1
	 * 
	 *         Created Date 08-AUG-2022
	 ************************************************************************************/

	public OrderMartException(String msg) {
		super(msg);
	}

	public BindException getBindingResult() {
		// TODO Auto-generated method stub
		return null;
	}

}
