package com.globalmart.app.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "orders")
public class Order {
	
	/************************************************************************************
	 * @author Abhishek Yadav
	 * 
	 *         Description : It is a POJO class for Order. All the entity and
	 *         their respective mappings are defined here.
	 * 
	 *         Version 1.1
	 * 
	 *         Created Date 08-AUG-2022
	 ************************************************************************************/


	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int orderId;

//	@NotNull(message = "Amount cant be Null")
//	@Min(value = 500, message = "Minimum Amount must be 500")
	private double amount;
	
	@Temporal(TemporalType.DATE)
	private Date orderDate = new Date(System.currentTimeMillis());
	
	@OneToOne(cascade = CascadeType.ALL)
	Payment payment = new Payment();

	@ManyToMany
	private List<Product> product = new ArrayList<>();

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(int orderId,
			@NotNull(message = "Amount cant be Null") @Min(value = 500, message = "Minimum Amount must be 500") double amount,
			Date orderDate, Payment payment, List<Product> product) {
		super();
		this.orderId = orderId;
		this.amount = amount;
		this.orderDate = orderDate;
		this.payment = payment;
		this.product = product;
	}

	public int getOrderId() {
		return orderId;
	}

	public double getAmount() {
		return amount;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public Payment getPayment() {
		return payment;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

}