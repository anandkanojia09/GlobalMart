package com.globalmart.app.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class CustomerDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String customerName;
	private String passsword;
	private String email;
	private String phoneNumber;
	private String roomNumber;
	private String city;
	private String state;
	private int pincode;

	@Temporal(TemporalType.DATE)
	private Date createdDate = new Date(System.currentTimeMillis());

	@OneToOne
	private Cart cart;

	@OneToMany
	private List<Order> orders = new ArrayList<>();

	public String getCustomerName() {
		return customerName;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	private CustomerDetails() {
		super();
		
	}

	private CustomerDetails(Integer id, String name, String passsword, String email, String phoneNumber,
			String roomNumber, String city, String state, int pincode, Date createdDate, Cart cart) {
		super();
		this.id = id;
		this.customerName = name;
		this.passsword = passsword;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.roomNumber = roomNumber;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.createdDate = createdDate;
		this.cart = cart;
	}

	public Integer getId() {
		return id;
	}

	public String getPasssword() {
		return passsword;
	}

	public String getEmail() {
		return email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public Cart getCart() {
		return cart;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.customerName = name;
	}

	public void setPasssword(String passsword) {
		this.passsword = passsword;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

}
