package com.globalmart.app.services;

import java.util.List;

import com.globalmart.app.dto.Payment;
import com.globalmart.app.exception.PaymentException;






public interface Paymentservice  {

	
    Payment addPayment(Payment paymentObj) throws PaymentException;
	
	Payment getPaymentById(Integer paymentId) throws PaymentException;
	
	Payment updatePayment(Payment paymentObj) throws PaymentException ;
	
	void deletePaymentById(Integer paymentId)  throws PaymentException;
	
	List<Payment> getAllPayment() throws PaymentException ;
}
