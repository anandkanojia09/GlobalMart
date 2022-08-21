package com.globalmart.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.globalmart.app.dto.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

	List<Customer> findByUserNameAndUserPassword(String name, String password);

	List<Customer> findByUserPhoneNumber(String phoneNumber);

	List<Customer> findByUserEmail(String userEmail);

	List<Customer> findByUserName(String userName);
	
}