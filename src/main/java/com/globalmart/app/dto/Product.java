package com.globalmart.app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Product {
	/************************************************************************************
	 * @author Anant Narayan Patel
	 * 
	 *         Description : It is a POJO class for Product. All the entity and
	 *         their respective mappings are defined here.
	 * 
	 *         Version 1.0
	 * 
	 *         Created Date 02-AUG-2022
	 ************************************************************************************/

	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;

	@NotEmpty(message = "Name is Mandatory.")
	@Pattern(regexp = "[A-Za-z0-9 ]*", message = "Only Alphanumeric characters are allowed.")
	@Size(min = 3, max = 20, message = "Name must be between 3 and 20 characters long.")
	private String productName;
	@Pattern(regexp = "[A-Za-z0-9. ]*", message = "Only Alphanumeric characters are allowed.")
	@Size(min = 3, max = 200, message = "Description must be between 4 and 200 characters long.")
	@NotNull(message = "Description can't be Null.")
	private String productDescription;
	// @NotEmpty(message = "Price is required.")
	@Min(value = 1, message = "Price needs to be greater than 0")
	private Double price;
	@Min(value = 1, message = "Product quantity must be atleast 1.")

	private Integer productQuantity;
	@Column(columnDefinition = "integer default 0")
	private Integer orderQuantity;
	@ManyToOne
	private Category category;

	public Product() {
		super();
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Product(Integer id, String name, String description, Double price, Integer productQuantity, Integer orderQuantity, Category category) {
		super();
		this.productId = id;
		this.productName = name;
		this.productDescription = description;
		this.price = price;
		this.productQuantity = productQuantity;
		this.orderQuantity = orderQuantity;
		this.category = category;
	}

	public Integer getId() {
		return productId;
	}

	public void setId(Integer id) {
		this.productId = id;
	}

	public String getName() {
		return productName;
	}

	public void setName(String name) {
		this.productName = name;
	}

	public String getDescription() {
		return productDescription;
	}

	public void setDescription(String description) {
		this.productDescription = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}

	public Integer getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(Integer orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	@Override
	public String toString() {
		return "Product [category=" + category + ", description=" + productDescription + ", id=" + productId + ", name=" + productName
				+ ", orderQuantity=" + orderQuantity + ", price=" + price + ", productQuantity=" + productQuantity
				+ "]";
	}

}
