package com.globalmart.app.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Admin {

	@Id
	private Integer id;
	private String name;
	private String passsword;

	private Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	private Admin(Integer id, String name, String passsword) {
		super();
		this.id = id;
		this.name = name;
		this.passsword = passsword;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPasssword() {
		return passsword;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPasssword(String passsword) {
		this.passsword = passsword;
	}

}
