package com.globalmart.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.globalmart.app.dto.Admin;
import com.globalmart.app.exception.GlobalMartException;
import com.globalmart.app.services.AdminServices;

@RestController
public class AdminController {

	@Autowired
	private AdminServices adminServices;

	@PostMapping("admin")
	public Admin addAdmin(@RequestBody Admin admin) throws GlobalMartException {
		return adminServices.addAdmin(admin);
	}

	@GetMapping("adminId/{id}")
	public Optional<Admin> getAdmin(@PathVariable("id") Integer id) throws GlobalMartException {
		return adminServices.getAdminById(id);
	}

	@GetMapping("adminName/{name}/{passowrd}")
	public List<Admin> getAdminByName(@RequestParam(value = "adminName") String name,
			@RequestParam(value = "passowrd") String password) throws GlobalMartException {
		return adminServices.getAdminByNameAndPassword(name, password);
	}

	@PostMapping("admin/update")
	public Admin updateAdmin(@RequestBody Admin admin) throws GlobalMartException {
		return adminServices.updateAdminById(admin);
	}

	@DeleteMapping("deleteAdmin/{id}")
	public void deleteAdmin(@PathVariable("id") Integer id) throws GlobalMartException {
		adminServices.deleteAdminById(id);

	}

	@GetMapping("admin/all")
	public List<Admin> getAllAdmin() throws GlobalMartException {
		return adminServices.getAllAdmins();
	}
}
