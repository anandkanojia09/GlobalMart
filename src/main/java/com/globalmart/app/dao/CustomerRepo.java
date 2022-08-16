package com.globalmart.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.globalmart.app.dto.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

	List<Customer> findByUserNameAndPassword(String name, String password);
}