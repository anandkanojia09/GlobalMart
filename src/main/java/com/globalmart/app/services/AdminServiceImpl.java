package com.globalmart.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globalmart.app.dao.AdminRepo;
import com.globalmart.app.dto.Admin;
import com.globalmart.app.exception.GlobalMartException;
/************************************************************************************
 *         @author          Anand Kumar Kanojia
 *         Description      It is a service class that provides the operations for admin class like add admin, get admin, 
 *          				delete admin, get all customers, get all admins 
 *         Version          1.1
 *         Created Date     08-AUG-2022
 ************************************************************************************/
@Service
public class AdminServiceImpl implements AdminServices {

	@Autowired
	private AdminRepo adminRepo;

	/************************************************************************************
	 * Method: addAdmin
     * Description: add admin(s) data for the application.
	 * @param admin - admin data of type Admin class.
	 * @returns admin - saved or added admin class or throws exception.
	 * @throws GlobalMartException - It is raised due to no details of the admin to be added.
     * Created By - Anand Kumar Kanojia
     * Created Date - 08-AUG-2022
	 ************************************************************************************/
	@Override
	public Admin addAdmin(Admin admin) throws GlobalMartException { 
		if (admin == null)
			throw new GlobalMartException("Admin cant be null");
		return adminRepo.save(admin);

	}
	
	/************************************************************************************
	 * Method: getAdminById
     * Description:  	fetches admin(s) data from the application.
	 * @param id - id of the admin to be searched.
	 * @returns admin - container object of the fetched admin class or throws exception.
	 * @throws GlobalMartException - It is raised due to no details of the admin to be fetched or wrong input.
     * Created By - Anand Kumar Kanojia
     * Created Date - 08-AUG-2022                          
	 ************************************************************************************/
	@Override
	public Optional<Admin> getAdminById(Integer id) throws GlobalMartException {
		Optional<Admin> admin = adminRepo.findById(id);
		if (admin.isEmpty()) {
			throw new GlobalMartException("Admin with admin id " + id + " does not exist");
		}
		return admin;
	}
	
	/************************************************************************************
	 * Method: updateAdminById
     * Description: update admin(s) data for the application.
	 * @param admin - admin data of type Admin class.
	 * @returns admin - updated admin data class or throws exception.
	 * @throws GlobalMartException - It is raised due to no details of the admin or wrong input.
     * Created By - Anand Kumar Kanojia
     * Created Date - 08-AUG-2022                           
	 ************************************************************************************/
	@Override
	public Admin updateAdmin(Admin admin) throws GlobalMartException {
		Integer id = admin.getAdminId();
		if (adminRepo.existsById(id)) {
			adminRepo.save(admin);
		} else {
			throw new GlobalMartException("No customer with the data exists to be updated!! Create new Admin ");
		}
		return admin;
	}
	
	/************************************************************************************
	 * Method: deleteAdminById
     * Description: delete admin(s) data from the application.
	 * @param id - id of the admin to be deleted.
	 * @returns boolean - true, if deleted successfully or throw exception.
	 * @throws GlobalMartException - It is raised due to no details of the admin to be added.
     * Created By - Anand Kumar Kanojia
     * Created Date - 08-AUG-2022                          
	 ************************************************************************************/
	@Override
	public boolean deleteAdminById(Integer id) throws GlobalMartException {
		boolean flag = true;
		if (adminRepo.existsById(id)) {
			adminRepo.deleteById(id);
			if (adminRepo.existsById(id)) {
				flag=false;
				throw new GlobalMartException("Unable to delete User. Try Again!!");
			}
		} else {
			flag=false;
			throw new GlobalMartException("No customer with id " + id + " exists to be deleted ");
		}
		return flag;
	}
	
	/************************************************************************************
	 * Method: getAdminById
     * Description: add admin(s) data for the application.
	 * @param id - admin data of type Admin class.
	 * @returns admin - saved or added admin class or throws exception.
	 * @throws GlobalMartException - It is raised due to no details of the admin to be added.
     * Created By - Anand Kumar Kanojia
     * Created Date - 08-AUG-2022                           
	 ************************************************************************************/
	@Override
	public List<Admin> getAllAdmins() throws GlobalMartException {
		List<Admin> allAdmins = adminRepo.findAll();
		if (allAdmins.isEmpty()) {
			throw new GlobalMartException("No customers yet!!");
		}
		return allAdmins;
	}
	
	/************************************************************************************
	 * Method: getAdminByNameAndPassword
     * Description: fetch admin(s) data using name and password.
	 * @param name - name of the admin.
	 * @param password - password of the admin's account.
	 * @returns admin - admin class found or throws exception.
	 * @throws GlobalMartException - It is raised due to no details of the admin are found or missmatch.
     * Created By - Anand Kumar Kanojia
     * Created Date - 08-AUG-2022                          
	 ************************************************************************************/
	@Override
	public List<Admin> getAdminByNameAndPassword(String name, String password) throws GlobalMartException {
		List<Admin> admins = new ArrayList<>();
		admins = adminRepo.findByAdminNameAndAdminPassword(name, password);
		if(admins.isEmpty()) {
			throw new GlobalMartException("No admin(s) with the name and password provided!! Check and try again.");
		}
		return admins;
	}


}
