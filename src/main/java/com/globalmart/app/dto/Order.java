 package com.globalmart.app.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Order {
	@Id
     private long orderId;
	 private double amount;
	 private String billingDate;
	 private String customer;
	 private String paymentMethod;
	 
	public Order() {
		super();
		this.orderId=orderId;
		this.amount=amount;
		this.billingDate=billingDate;
		this.customer=customer;
		this.paymentMethod=paymentMethod;
		
		// TODO Auto-generated constructor stub
	}
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getBillingDate() {
		return billingDate;
	}
	public void setBillingDate(String billingDate) {
		this.billingDate = billingDate;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	 

	

	
}
