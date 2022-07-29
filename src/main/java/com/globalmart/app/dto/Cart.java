package com.globalmart.app.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Cart {

	@Id
	private Integer cartId;
	private Integer productQuantity;
	private Double cartPrice;

//	@OneToMany
//	private List<Order> orders;

	@ManyToMany
	private List<Product> products = new ArrayList<>();

	public Cart() {
		super();
	}

	public Cart(Integer cartId, Integer productQuantity, Double cartPrice) {
		super();
		this.cartId = cartId;
		this.productQuantity = productQuantity;
		this.cartPrice = cartPrice;
//		this.orders = order;
	}

	public Integer getProductId() {
		return cartId;
	}

	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public Integer getProductQuantity() {
		return productQuantity;
	}

	public Double getCartPrice() {
		return cartPrice;
	}

//	public List<Order> getOrders() {
//		return orders;
//	}
//
//	public void setOrders(List<Order> orders) {
//		this.orders = orders;
//	}

	public void setProductId(Integer cartId) {
		this.cartId = cartId;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}

	public void setCartPrice(Double cartPrice) {
		this.cartPrice = cartPrice;
	}

}
