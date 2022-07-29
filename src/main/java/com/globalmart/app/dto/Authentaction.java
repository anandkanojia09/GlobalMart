package com.globalmart.app.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.lang.NonNull;



@Entity
public class Authentaction {
	@Id
	Integer id;
	@NonNull
	String password;
	
	@OneToOne
	Admin admin;
	
	
	public Authentaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Authentaction(Integer id, String password) {
		super();
		this.id = id;
		this.password = password;
	}

     
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	

}
