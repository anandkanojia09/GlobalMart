package com.globalmart.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globalmart.app.dao.PaymentRepo;
import com.globalmart.app.dto.Payment;
import com.globalmart.app.exception.PaymentException;



@Service
public class PaymentServiceImpl implements Paymentservice{
	
	
	@Autowired
    PaymentRepo paymentrepo;
	

	@Override
	public Payment addPayment(Payment paymentObj) throws PaymentException {
		if(paymentObj==null) {
			throw new PaymentException("Payment not added please provide essiential details");
		}
		Optional<Payment> payment = paymentrepo.findById(paymentObj.getPaymentId());
		if(payment.isEmpty()) {
			throw new PaymentException("Already Paid");
		}
		else {
			paymentObj.setPaymentAmount(null);
			return this.paymentrepo.save(paymentObj);
		}
		
		
	}

	@Override
	public Payment getPaymentById(Integer paymentId) throws PaymentException {
      Optional<Payment> payment = this.paymentrepo.findById(paymentId);
      if(payment.isEmpty()) {
    	  throw new PaymentException("Already paid");
     }
		return payment.get();
	}

	@Override
	public Payment updatePayment(Payment paymentObj) throws PaymentException{
		if(paymentObj==null) {
			throw new PaymentException("Payment not added please provide essiential details");
		}
		else {
	  return this.paymentrepo.save(paymentObj);
		}
	}

	@Override
	public void deletePaymentById(Integer paymentId) throws PaymentException {
		Optional<Payment> payment = paymentrepo.findById(paymentId);
		if(payment.isEmpty()) {
			throw new PaymentException("Cannot be deleted");
		}
		paymentrepo.deleteById(paymentId);
		
	}

	@Override
	public List<Payment> getAllPayment() throws PaymentException {
		List<Payment>payments = paymentrepo.findAll() ;
		return payments;
	}

	

}
