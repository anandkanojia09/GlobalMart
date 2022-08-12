package com.globalmart.app.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
//import javax.persistence.ManyToMany;

//import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Orders {

	@Id
	private long orderId;
	private double amount;
	private String billingDate;
	private String customer;
	private String paymentMethod;

//	@ManyToMany
//	@JsonIgnore
//	private Product product;

	public Orders() {
		super();
	}
//
//	public Product getProduct() {
//		return product;
//	}
//
//	public void setProduct(Product product) {
//		this.product = product;
//	}

	public Orders(long orderId, double amount, String billingDate, String customer, String paymentMethod) {
		super();
		this.orderId = orderId;
		this.amount = amount;
		this.billingDate = billingDate;
		this.customer = customer;
		this.paymentMethod = paymentMethod;
//		this.product = product;
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
