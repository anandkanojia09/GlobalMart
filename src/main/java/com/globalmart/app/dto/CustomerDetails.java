package com.globalmart.app.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class CustomerDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private String passsword;
	private String email;
	private String phoneNumber;
	private String address;
	
	@Temporal(TemporalType.DATE)
	private Date createdDate= new Date(System.currentTimeMillis());

	private CustomerDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	private CustomerDetails(Integer id, String passsword, String name, String email, String phoneNumber, String address,
			Date createdDate) {
		super();
		this.id = id;
		this.passsword = passsword;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	public Integer getId() {
		return id;
	}

	public String getPasssword() {
		return passsword;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setPasssword(String passsword) {
		this.passsword = passsword;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	
}
