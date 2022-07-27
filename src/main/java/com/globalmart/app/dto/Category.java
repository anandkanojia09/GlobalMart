package com.globalmart.app.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {

	@Id
	private Integer categoryId;
	private String name;
	private String Description;

	private Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	private Category(Integer categoryId, String name, String description) {
		super();
		this.categoryId = categoryId;
		this.name = name;
		Description = description;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return Description;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		Description = description;
	}

}
