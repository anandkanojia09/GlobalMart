package com.globalmart.app.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Orders {
	@Id
	private Integer orderId;

	private String deliveryAddress;
	private Integer paymentId;
	@Temporal(TemporalType.DATE)
	private Date CreatedDate = new Date(System.currentTimeMillis());

	public Orders() {
		super();

	}

	public Orders(Integer orderId, Product product, String deliveryAddress, Integer paymentId, Date createdDate) {
		super();
		this.orderId = orderId;

		this.deliveryAddress = deliveryAddress;
		this.paymentId = paymentId;
		CreatedDate = createdDate;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public Integer getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	public Date getCreatedDate() {
		return CreatedDate;
	}

	public void setCreatedDate(Date createdDate) {
		CreatedDate = createdDate;
	}

}
