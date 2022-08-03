package com.globalmart.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globalmart.app.dao.AdminRepo;
import com.globalmart.app.dto.Admin;
import com.globalmart.app.exception.GlobalMartException;

@Service
public class AdminServiceImpl implements AdminServices {

	@Autowired
	private AdminRepo adminRepo;

	@Override
	public Admin addAdmin(Admin admin) throws GlobalMartException {
		if (admin == null)
			throw new GlobalMartException("Admincant be null");
		return adminRepo.save(admin);

	}

	@Override
	public Optional<Admin> getAdminById(Integer id) throws GlobalMartException {
		Optional<Admin> admin = adminRepo.findById(id);
		if (admin.isEmpty()) {
			throw new GlobalMartException("Admin with admin id " + id + " does not exist");
		}
		return admin;
	}

	@Override
	public Admin updateAdminById(Admin admin) throws GlobalMartException {
		int x = admin.getAdminId();
		if (adminRepo.existsById(x)) {
			adminRepo.save(admin);
		} else {
			throw new GlobalMartException("No customer with data exists to be updated!! ");
		}
		return admin;
	}

	@Override
	public void deleteAdminById(Integer id) throws GlobalMartException {
		if (adminRepo.existsById(id)) {
			adminRepo.deleteById(id);
			if (adminRepo.existsById(id)) {
				throw new GlobalMartException("Unable to delete User. Try Again!!");
			}
		} else {
			throw new GlobalMartException("No customer with id " + id + " exists to be deleted ");
		}
	}

	@Override
	public List<Admin> getAllAdmins() throws GlobalMartException {
		List<Admin> allAdmins = adminRepo.findAll();
		if (allAdmins.isEmpty()) {
			throw new GlobalMartException("No customers yet!!");
		}
		return allAdmins;
	}

	@Override
	public List<Admin> getAdminByNameAndPassword(String name, String password) throws GlobalMartException {
		List<Admin> admins = new ArrayList<>();
		try {
			admins = adminRepo.findByAdminNameAndPassword(name, password);
		} catch (Exception e) {
			throw new GlobalMartException(e.getLocalizedMessage());
		}
		return admins;
	}

}
