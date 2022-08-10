package com.globalmart.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.globalmart.app.dto.Admin;
import com.globalmart.app.exception.GlobalMartException;
import com.globalmart.app.services.AdminServices;

@RestController
public class AdminController {

	@Autowired
	private AdminServices adminServices;

	@PostMapping("admin")
	public Admin addAdmin(@Valid @RequestBody Admin admin) throws GlobalMartException {
		Admin adminAdded = null;
		adminAdded = adminServices.addAdmin(admin);
		return adminAdded;
	}

	@GetMapping("admin/{id}")
	public Optional<Admin> getAdminById(@PathVariable("id") Integer id) throws GlobalMartException {
		Optional<Admin> admin = null;
		admin = adminServices.getAdminById(id);
		return admin;
	}

	@PutMapping("admin")
	public Admin updateAdmin(@RequestBody Admin admin) throws GlobalMartException {
		Admin updatedAdmin = null;
		updatedAdmin = adminServices.updateAdminById(admin);
		return updatedAdmin;
	}

	@DeleteMapping("admin/{id}")
	public String deleteAdmin(@PathVariable("id") Integer id) throws GlobalMartException {
		String msg = "";
		if (adminServices.deleteAdminById(id))
			msg = "Delete Successfull";
		return msg;
	}

	@GetMapping("admins/all")
	public List<Admin> getAllAdmins() throws GlobalMartException {
		List<Admin> admins = new ArrayList<>();
		admins = adminServices.getAllAdmins();
		return admins;
	}
}
