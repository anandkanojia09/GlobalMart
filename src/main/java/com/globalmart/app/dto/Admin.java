package com.globalmart.app.dto;

import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Admin {

	@Id
	private Integer adminId;
	private String name;
	private String passsword;

	private Admin() {
		super();
	}

	private Admin(Integer id, String name, String passsword) {
		super();
		this.adminId = id;
		this.name = name;
		this.passsword = passsword;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public String getAdminName() {
		return name;
	}

	public String getPasssword() {
		return passsword;
	}

	public void setAdminId(Integer id) {
		this.adminId = id;
	}

	public void setAdminName(String name) {
		this.name = name;
	}

	public void setPasssword(String passsword) {
		this.passsword = passsword;
	}

}
