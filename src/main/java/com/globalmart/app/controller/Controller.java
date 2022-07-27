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
import com.globalmart.app.dao.CategoryRepo;
import com.globalmart.app.dao.CustomerRepo;
import com.globalmart.app.dao.ProductRepo;
import com.globalmart.app.dto.Admin;
import com.globalmart.app.dto.Category;
import com.globalmart.app.dto.CustomerDetails;
import com.globalmart.app.dto.Product;

@RestController
public class Controller {
	
	@Autowired
	private CustomerRepo customerRepo;
	@Autowired
	private AdminRepo adminRepo;
	@Autowired
	private CategoryRepo categoryRepo;
	@Autowired
	private ProductRepo productRepo;
	
	@PostMapping("customer")
	public CustomerDetails addCustomer(@RequestBody CustomerDetails customer) {
		return customerRepo.save(customer);
	}
	
	@GetMapping("customer/{id}")
	public Optional<CustomerDetails> getCustomer(@PathVariable("id") Integer id ) {
		return customerRepo.findById(id);
	}
	
	@PostMapping("admin")
	public Admin addAdmin(@RequestBody Admin admin) {
		return adminRepo.save(admin);
	}
	
	@GetMapping("admin/{id}")
	public Optional<Admin> getAdmin(@PathVariable("id") Integer id ) {
		return adminRepo.findById(id);
	}
	
	@DeleteMapping("deleteCustomer/{id}")
	public void deleteCustomer(@PathVariable("id") Integer id ) {
		customerRepo.deleteById(id);
	}
	
	@DeleteMapping("deleteAdmin/{id}")
	public void deleteAdmin(@PathVariable("id") Integer id ) {
		adminRepo.deleteById(id);
	}
	
	@GetMapping("allCustomer")
	public List<CustomerDetails> getAllCustomer() {
		return customerRepo.findAll();
	}
	
	@PostMapping("category")
	public Category addCategory(@RequestBody Category categ) {
		return categoryRepo.save(categ);
	}
	
	@GetMapping("categories/{id}")
	public Optional<Category> getCategory(@PathVariable("id")Integer id) {
		return categoryRepo.findById(id);
	}
	
	@PostMapping("product")
	public Product addProduct(@RequestBody Product product) {
		return productRepo.save(product);
	}
	
	@GetMapping("product/{id}")
	public Optional<Product> getProduct(@PathVariable("id")Integer id) {
		return productRepo.findById(id);
	}
	
}
