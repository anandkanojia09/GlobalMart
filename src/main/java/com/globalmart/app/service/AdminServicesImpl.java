package com.globalmart.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.globalmart.app.dao.AdminRepo;
import com.globalmart.app.dto.Admin;


@Service
public class AdminServicesImpl implements AdminServices{

	
	@Autowired
	private AdminRepo adminRepo;
	
	@Override
	public List<Admin> getAllAdmin() {
		List<Admin> alladmin = new ArrayList<>();
		
		alladmin = adminRepo.findAll();
		
		return alladmin;
	}

}
