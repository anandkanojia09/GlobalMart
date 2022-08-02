package com.globalmart.app.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.HttpStatus;

@RestControllerAdvice
public class GlobalMartExceptionAdvice {

	@ExceptionHandler(GlobalMartException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String handleEmployeeException(GlobalMartException e) {
		return e.getMessage();
	}
}
