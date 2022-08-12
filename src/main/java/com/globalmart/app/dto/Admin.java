
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

	public Admin(Integer adminId, String adminName, String passsword) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.passsword = passsword;
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

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public void setPasssword(String passsword) {
		this.passsword = passsword;
	}
}