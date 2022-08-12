package com.globalmart.app.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="orders")
public class Order {

	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull(message="Order Id  cant be null")
	@NotBlank(message="Order Id is mandatery")
	private int orderId;
	
	@NotNull(message="Amount cant be Null")
	@Min(value=500,message="Minimum Amount must be 500")
	private double amount;
	@Temporal(TemporalType.DATE)
	
	@NotNull(message="Order Date is mandetory")
	private Date orderDate = new Date(System.currentTimeMillis());

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", amount=" + amount + ", orderDate=" + orderDate + ", customer="
				+ customer + ", paymentMethod=" + paymentMethod + ", product=" + product + "]";
	}

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderId;
	private double amount;
	private String billingDate;
	private String customer;
	private String paymentMethod;

	@ManyToMany
	private List<Product> product = new ArrayList<>();

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	public Order() {
		super();
	}


	public Order(long orderId, double amount, String billingDate, String customer, String paymentMethod) {
		super();
		this.orderId = orderId;
		this.amount = amount;
		this.billingDate = billingDate;
		this.customer = customer;
		this.paymentMethod = paymentMethod;

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
