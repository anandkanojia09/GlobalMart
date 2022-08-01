package com.globalmart.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.globalmart.app.dao.AdminRepo;
import com.globalmart.app.dao.CartRepo;
import com.globalmart.app.dao.CustomerRepo;
import com.globalmart.app.dto.Admin;
import com.globalmart.app.dto.Cart;
import com.globalmart.app.dto.CustomerDetails;

@RestController
public class AdminController {

	@Autowired
	private CustomerRepo customerRepo;
	@Autowired
	private AdminRepo adminRepo;

	@Autowired
	private CartRepo cartRepo;

	@PostMapping("admin")
	public Admin addAdmin(@RequestBody Admin admin) {
		return adminRepo.save(admin);
	}

	@GetMapping("admin/{id}")
	public Optional<Admin> getAdmin(@PathVariable("id") Integer id) {
		return adminRepo.findById(id);
	}

	@PostMapping("admin/update")
	public Admin updateAdmin(@RequestBody Admin admin) {
		return adminRepo.save(admin);
	}

	@DeleteMapping("deleteAdmin/{id}")
	public void deleteAdmin(@PathVariable("id") Integer id) {
		adminRepo.deleteById(id);
	}

	@GetMapping("allCustomer")
	public List<CustomerDetails> getAllCustomer() {
		return customerRepo.findAll();
	}

	@GetMapping("allCart")
	public List<Cart> getAllCarts() {
		return cartRepo.findAll();
	}

}
