
package com.globalmart.app.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Admin {

	@Id
	private Integer adminId;
	private String adminName;
	private String password;

	public Admin() {
		super();
	}

	public Admin(Integer adminId, String adminName, String password) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.password = password;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public String getPassword() {
		return password;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public void setPasssword(String password) {
		this.password = password;
	}
}