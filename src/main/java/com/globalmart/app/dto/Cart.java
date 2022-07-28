package com.globalmart.app.dto;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Cart {
	@Id
	private Integer productId;
	private Integer productQuantity;
	private Double cartPrice;
	private Integer userId;
	
	//@OneToMany
	//private Orders orderId;
	
	public Cart() {
		super();
		
	}

	public Cart(Integer productId, Integer productQuantity, Double cartPrice, Integer userId, Orders orderId) {
		super();
		this.productId = productId;
		this.productQuantity = productQuantity;
		this.cartPrice = cartPrice;
		this.userId = userId;
		
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}

	public Double getCartPrice() {
		return cartPrice;
	}

	public void setCartPrice(Double cartPrice) {
		this.cartPrice = cartPrice;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	
	

	
	
	
	
	

}

