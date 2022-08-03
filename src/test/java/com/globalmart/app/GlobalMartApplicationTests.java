package com.globalmart.app;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.globalmart.app.dto.Admin;
import com.globalmart.app.exception.GlobalMartException;
import com.globalmart.app.services.AdminServiceImpl;

@SpringBootTest
class GlobalMartApplicationTests {

	@Autowired
	private AdminServiceImpl adminService;

//	@Test
//	void getAdminById() throws GlobalMartException {
//
//		assumeTrue(adminService != null);
//		Optional<Admin> admin = adminService.getAdminById(56);
//		assertTrue(admin.isPresent());
//
//	} 

	@BeforeEach
	public void addAdmin() {
		Admin admin = new Admin(56, "ahaha", "asasa");
		this.adminService.addAdmin(admin);
	}

	@Test
	void deleteAdmnById() throws GlobalMartException {
		assumeTrue(adminService != null);
		adminService.deleteAdminById(56);
		assertFalse(adminService.getAdminById(56).isPresent());

	}

}
