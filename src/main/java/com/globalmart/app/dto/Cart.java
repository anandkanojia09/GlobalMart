package com.globalmart.app.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cartId;
	private Integer productQuantity;
	private Double cartPrice;

	@OneToOne
	private CustomerDetails customer;

	public CustomerDetails getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDetails customer) {
		this.customer = customer;
	}

	@ManyToMany
	private List<Product> products = new ArrayList<>();

	public Cart(Integer cartId, Integer productQuantity, Double cartPrice, List<Product> products,
			CustomerDetails customer) {
		super();
		this.cartId = cartId;
		this.productQuantity = productQuantity;
		this.cartPrice = cartPrice;
		this.products = products;
		this.customer = customer;
	}

	public Cart() {
		super();
	}

	public Integer getCartId() {
		return cartId;
	}

	public Integer getProductQuantity() {
		return productQuantity;
	}

	public Double getCartPrice() {
		return cartPrice;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}

	public void setCartPrice(Double cartPrice) {
		this.cartPrice = cartPrice;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
