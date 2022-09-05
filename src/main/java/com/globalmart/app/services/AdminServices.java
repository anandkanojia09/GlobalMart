package com.globalmart.app.services;

import java.util.List;
import java.util.Optional;

import com.globalmart.app.dto.Admin;
import com.globalmart.app.exception.GlobalMartException;

/************************************************************************************
 *         @author          Anand Kumar Kanojia
 *         Description      It is a admin service interface that provides abstraction to the business logic and repository.
 *         Version          1.1
 *         Created Date     08-AUG-2022
 ************************************************************************************/
public interface AdminServices {

	public Optional<Admin> getAdminById(Integer id) throws GlobalMartException;

	public Admin addAdmin(Admin admin) throws GlobalMartException;

	public boolean deleteAdminById(Integer id) throws GlobalMartException;

	public List<Admin> getAllAdmins() throws GlobalMartException;

	public List<Admin> getAdminByNameAndPassword(String name, String password) throws GlobalMartException;

	Admin updateAdmin(Admin admin) throws GlobalMartException;

}
