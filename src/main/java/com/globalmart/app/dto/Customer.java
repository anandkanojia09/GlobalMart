package com.globalmart.app.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
//	@NotEmpty(message = "Cannot be empty. Please give correct name")
//	@Range(max = 25, min = 2, message = "Should be more than 2 and less than 25 characters")
//	@Pattern(regexp = "[A-Za-z]*", message = "Name cannot have number or special characters Data!!")
	private String customerName;
//	@NotEmpty(message = "Cannot be empty")
//	@Pattern(regexp = "[A-Za-z0-9]", message = "Password should contain number and special characters!!")
//	@Range(min = 8, message = "Password should be more than 8 characters")
	private String password;
	private String email;
	private String phoneNumber;
	private String roomNumber;
	private String city;
	private String state;
	private int pincode;

	@Temporal(TemporalType.DATE)
	private Date createdDate = new Date(System.currentTimeMillis());

	@OneToMany(cascade = { CascadeType.ALL })
	private List<Order> orders = new ArrayList<>();

	public Customer() {
		super();
	}

	public Customer(Integer id,
			@NotEmpty(message = "Cannot be empty. Please give correct name") @Range(max = 25, min = 2, message = "Should be more than 2 and less than 25 characters") @Pattern(regexp = "[A-Za-z]*", message = "Name cannot have number or special characters Data!!") String customerName,
			@NotNull @NotBlank String password, String email, String phoneNumber, String roomNumber, String city,
			String state, int pincode, Date createdDate, List<Order> orders) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.roomNumber = roomNumber;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.createdDate = createdDate;
		this.orders = orders;
	}

	public Integer getId() {
		return id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public int getPincode() {
		return pincode;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

}
