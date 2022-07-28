package com.globalmart.app.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Product {

	@Id
	private Integer productId;
	private String productName;
	private String productDesc;
	private Double productPrice;

	@ManyToOne
	private Category categoryId;

	private Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	private Product(Integer productId, String productName, String productDesc, Double productPrice,
			Category categoryId) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDesc = productDesc;
		this.productPrice = productPrice;
		this.categoryId = categoryId;
	}

	public Integer getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public Category getCategoryId() {
		return categoryId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public void setCategoryId(Category categoryId) {
		this.categoryId = categoryId;
	}

}
