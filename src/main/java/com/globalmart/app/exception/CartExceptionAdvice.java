package com.globalmart.app.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.HttpStatus;


@RestControllerAdvice
public class CartExceptionAdvice {

	@ExceptionHandler(CartException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String handleEmployeeException(CartException e) {
		return e.getMessage();
	}
}
