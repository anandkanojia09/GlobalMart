package com.globalmart.app.services;

import java.util.List;
import java.util.Optional;

import com.globalmart.app.dto.Admin;
import com.globalmart.app.exception.GlobalMartException;

public interface AdminServices {

	public Optional<Admin> getAdminById(Integer id) throws GlobalMartException;

	public Admin addAdmin(Admin admin) throws GlobalMartException;

	public void deleteAdminById(Integer id) throws GlobalMartException;

	public Admin updateAdminById(Admin admin) throws GlobalMartException;

	public List<Admin> getAllAdmins() throws GlobalMartException;

	public List<Admin> getAdminByNameAndPassword(String name, String password) throws GlobalMartException;

}
