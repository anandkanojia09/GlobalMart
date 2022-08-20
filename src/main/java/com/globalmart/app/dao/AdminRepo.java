package com.globalmart.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.globalmart.app.dto.Admin;

public interface AdminRepo extends JpaRepository<Admin, Integer> {

	List<Admin> findByAdminNameAndAdminPassword(String name, String password);

}