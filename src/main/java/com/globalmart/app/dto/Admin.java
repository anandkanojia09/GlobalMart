package com.globalmart.app.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Admin {

	@Id
	private Integer adminId;
	private String adminName;
	private String passsword;

	public Admin() {
		super();
	}

	public String getName() {
		return adminName;
	}

	public void setName(String name) {
		this.adminName = name;
	}

	public Admin(Integer adminId, String name, String passsword) {
		super();
		this.adminId = adminId;
		this.adminName = name;
		this.passsword = passsword;
//		this.customers = customers;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public String getPasssword() {
		return passsword;
	}

	public void setAdminId(Integer id) {
		this.adminId = id;
	}

	public void setAdminName(String name) {
		this.adminName = name;
	}

	public void setPasssword(String passsword) {
		this.passsword = passsword;
	}

}
