package com.globalmart.app.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@SuppressWarnings("serial")
@Entity
public class Customer implements Serializable {
	
	/************************************************************************************
	 * @author Anand Kumar Kanojia
	 * 
	 * Description : It is a POJO class for Customer. All the entity and
	 *         		 their respective mappings are defined here.
	 * 
	 * Version 1.0
	 * 
	 * Created Date 02-AUG-2022
	 ************************************************************************************/

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer customerId;
	@NotBlank(message = "Name is Mandatory.")
	@Pattern(regexp = "[A-Za-z]*", message = "Only Alphanumeric characters are allowed.")
	@Size(min = 3, max = 20, message = "Name must be between 3 and 20 characters long.")
	private String customerName;
	@NotBlank(message = "Cannot be empty")
	@Pattern(regexp = "[A-Za-z0-9]*", message = "Password should contain number and special characters!!")
	@Size(min = 6, max = 20, message = "Password should be more than 6 characters")
	private String userPassword;
	@Column(unique = true)
	@NotBlank(message = "Cannot be empty")
	@Pattern(regexp = "[A-Za-z0-9]*", message = "username already in use!!")
	@Size(min = 6, max = 20, message = "username should be more than 6 characters")
	private String userName;
	@Email
	@NotBlank(message = "Cannot be empty")
	@Pattern(regexp = "[A-Za-z0-9]*", message = "Incorrect email format!! Enter correct email.")
	private String userEmail;
	@NotBlank(message = "Cannot be empty")
	@Pattern(regexp = "([0-9]*{10})", message = "Phone number should contain numbers only!!")
	@Size(min = 10, max = 10, message = "Incorrect Number ")
	private String userPhoneNumber;
	private String roomNumber;
	private String city;
	private String state;
	@Pattern(regexp = "(^$|[0-9]*{6})", message = "Incorrect Pin !!")
	@Size(min = 6, max = 6, message = "Cannot be more than 6 digits!!")
	private Integer pincode;

	@Temporal(TemporalType.DATE)
	private Date createdDate = new Date(System.currentTimeMillis());

	@OneToMany(cascade = { CascadeType.ALL })
	private List<Order> orders = new ArrayList<>();

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(Integer customerId,
			@NotBlank(message = "Name is Mandatory.") @Pattern(regexp = "[A-Za-z]*", message = "Only Alphanumeric characters are allowed.") @Size(min = 3, max = 20, message = "Name must be between 3 and 20 characters long.") String customerName,
			@NotBlank(message = "Cannot be empty") @Pattern(regexp = "[A-Za-z0-9]*", message = "Password should contain number and special characters!!") @Size(min = 6, max = 20, message = "Password should be more than 6 characters") String userPassword,
			@NotBlank(message = "Cannot be empty") @Pattern(regexp = "[A-Za-z0-9]*", message = "username already in use!!") @Size(min = 6, max = 20, message = "username should be more than 6 characters") String userName,
			@Email @NotBlank(message = "Cannot be empty") @Pattern(regexp = "[A-Za-z0-9]*", message = "Password should contain number and special characters!!") @Size(min = 6, max = 20, message = "Password should be more than 8 characters") String userEmail,
			@NotBlank(message = "Cannot be empty") @Pattern(regexp = "(^[0-9]{10})", message = "Phone number should contain numbers only!!") @Size(min = 10, max = 10, message = "Incorrect Number ") String userPhoneNumber,
			String roomNumber, String city, String state,
			@NotBlank(message = "Cannot be empty") @Pattern(regexp = "(^[0-9]{6})", message = "Incorrect Pin !!") @Size(min = 6, max = 6, message = "Cannot be more than 6 digits!!") Integer pincode,
			Date createdDate, List<Order> orders) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.userPassword = userPassword;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPhoneNumber = userPhoneNumber;
		this.roomNumber = roomNumber;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.createdDate = createdDate;
		this.orders = orders;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public String getUserPhoneNumber() {
		return userPhoneNumber;
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

	public Integer getPincode() {
		return pincode;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
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

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

}
