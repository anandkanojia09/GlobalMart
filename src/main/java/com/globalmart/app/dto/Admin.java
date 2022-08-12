package com.globalmart.app.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Admin {

	@Id
	private Integer adminId;
//	@NotEmpty(message = "Cannot be empty. Please give correct name")
//	@Range(message = "Name should be more than 2 characters")
//	@Pattern(regexp = "[A-Za-z]*", message = "Name cannot have number or special characters !!")
	private String adminName;
//	@NotEmpty(message = "Password cannot be empty")
//	@Range(min = 6, max = 25, message = "Password should be more than 6 characters")
//	@Pattern(regexp = "[A-Za-z0-9]*", message = "Password should contain number and special characters!!")
	private String password;

	public Admin() {
		super();
	}

	public Admin(Integer adminId, String adminName, String passsword) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.password = passsword;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public String getPasssword() {
		return password;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public void setPasssword(String passsword) {
		this.password = passsword;
	}

}
