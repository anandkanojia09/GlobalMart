package com.globalmart.app.dto;

import java.io.Serializable;
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
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;
	@NotBlank(message = "Name is Mandatory.")
	@Pattern(regexp = "[A-Za-z]*", message = "No letters are allowed.")
	@Size(min = 2, max = 20, message = "Name must be between 2 and 20 characters long.")
	private String customerName;
	@NotBlank(message = "Cannot be empty")
	@Pattern(regexp = "^(?=.*[0-9])"+ "(?=.*[a-z])(?=.*[A-Z])"+ "(?=.*[@#$%^&+=])"+ "(?=\\S+$).{6,20}$", message = "Password should contain at least one smallcase and one upper case letter, number and a special character!!")
	@Size(min = 6, max = 20, message = "Password should be more than 6 characters")
	private String userPassword;
	@NotBlank(message = "Cannot be empty")
	@Pattern(regexp = "[A-Za-z0-9]*", message = "username already in use!!")
	@Size(min = 3, max = 20, message = "username should be more than 3 characters")
	private String userName;
	@Email
	@NotBlank(message = "Cannot be empty")
	private String userEmail;
	@NotBlank(message = "Cannot be empty")
	@Pattern(regexp = "([0-9]*{10})", message = "Phone number should contain numbers only!!")
	@Size(min = 10, max = 10, message = "Incorrect Number ")
	private String userPhoneNumber;
	private String roomNumber;
	private String city;
	private String state;
	@NotBlank(message = "Pin cannot be empty")
	@Pattern(regexp = "^[1-9]{1}[0-9]{2}\\s{0,1}[0-9]{3}$", message = "Invalid pin!! Try again.")
	@Size(min = 6, max = 6, message = "Incorrect Pin!!")
	private String pincode;

	@Temporal(TemporalType.DATE)
	private Date createdDate = new Date(System.currentTimeMillis());

	@OneToMany(cascade = { CascadeType.ALL })
	private List<Order> orders = new ArrayList<>();

	public Customer() {
		super();
	}

	public Customer(Integer customerId,
			@NotBlank(message = "Name is Mandatory.") @Pattern(regexp = "[A-Za-z]*", message = "No letters are allowed.") @Size(min = 2, max = 20, message = "Name must be between 2 and 20 characters long.") String customerName,
			@NotBlank(message = "Cannot be empty") @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,20}$", message = "Password should contain at least one smallcase and one upper case letter, number and a special character!!") @Size(min = 6, max = 20, message = "Password should be more than 6 characters") String userPassword,
			@NotBlank(message = "Cannot be empty") @Pattern(regexp = "[A-Za-z0-9]*", message = "username already in use!!") @Size(min = 3, max = 20, message = "username should be more than 3 characters") String userName,
			@Email @NotBlank(message = "Cannot be empty") String userEmail,
			@NotBlank(message = "Cannot be empty") @Pattern(regexp = "([0-9]*{10})", message = "Phone number should contain numbers only!!") @Size(min = 10, max = 10, message = "Incorrect Number ") String userPhoneNumber,
			String roomNumber, String city, String state,
			@NotBlank(message = "Pin cannot be empty") @Pattern(regexp = "^[1-9]{1}[0-9]{2}\\s{0,1}[0-9]{3}$", message = "Invalid pin!! Try again.") @Size(min = 10, max = 10, message = "Incorrect Pin!!") String pincode,
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
	
	public Customer(Integer customerId,
			@NotBlank(message = "Name is Mandatory.") @Pattern(regexp = "[A-Za-z]*", message = "No letters are allowed.") @Size(min = 2, max = 20, message = "Name must be between 2 and 20 characters long.") String customerName,
			@NotBlank(message = "Cannot be empty") @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,20}$", message = "Password should contain at least one smallcase and one upper case letter, number and a special character!!") @Size(min = 6, max = 20, message = "Password should be more than 6 characters") String userPassword,
			@NotBlank(message = "Cannot be empty") @Pattern(regexp = "[A-Za-z0-9]*", message = "username already in use!!") @Size(min = 3, max = 20, message = "username should be more than 3 characters") String userName,
			@Email @NotBlank(message = "Cannot be empty") String userEmail,
			@NotBlank(message = "Cannot be empty") @Pattern(regexp = "([0-9]*{10})", message = "Phone number should contain numbers only!!") @Size(min = 10, max = 10, message = "Incorrect Number ") String userPhoneNumber,
			String roomNumber, String city, String state,
			@NotBlank(message = "Pin cannot be empty") @Pattern(regexp = "^[1-9]{1}[0-9]{2}\\s{0,1}[0-9]{3}$", message = "Invalid pin!! Try again.") @Size(min = 10, max = 10, message = "Incorrect Pin!!") String pincode) {
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

	public String getPincode() {
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

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

}
