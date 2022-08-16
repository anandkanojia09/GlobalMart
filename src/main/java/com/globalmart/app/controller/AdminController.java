package com.globalmart.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.globalmart.app.dto.Admin;
import com.globalmart.app.dto.Customer;
import com.globalmart.app.exception.GlobalMartException;
import com.globalmart.app.services.AdminServices;
import com.globalmart.app.services.CustomerServices;

@RestController
public class AdminController {

	@Autowired
	private CustomerServices customerServices;
	@Autowired
	private AdminServices adminServices;

	@PostMapping("admin")
	public Admin addAdmin(@RequestBody Admin admin) throws GlobalMartException {
		Admin adminAdded = null;
		adminAdded = adminServices.addAdmin(admin);
		return adminAdded;
	}

	@GetMapping("admin/{id}")
	public Optional<Admin> getAdmin(@PathVariable("id") Integer id) throws GlobalMartException {
		Optional<Admin> customerFound = null;
		customerFound = adminServices.getAdminById(id);
		return customerFound;
	}

	@PutMapping("admin")
	public Admin updateAdmin(@RequestBody Admin admin) throws GlobalMartException {
		Admin adminUpdated = null;
		adminUpdated = adminServices.updateAdminById(admin);
		return adminUpdated;
	}

	@DeleteMapping("deleteAdmin/{id}")
	public String deleteAdmin(@PathVariable("id") Integer id) throws GlobalMartException {
		String msg = null;
		if (adminServices.deleteAdminById(id))
			msg = "Delete Successfull";
		return msg;
	}

	@GetMapping("customers")
	public List<Customer> getAllCustomer() throws GlobalMartException {
		List<Customer> customers = null;
		customers = customerServices.getAllCustomers();
		return customers;
	}

}