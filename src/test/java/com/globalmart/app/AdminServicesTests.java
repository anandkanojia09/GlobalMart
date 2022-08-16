package com.globalmart.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.globalmart.app.dao.AdminRepo;
import com.globalmart.app.dto.Admin;
import com.globalmart.app.exception.GlobalMartException;
import com.globalmart.app.services.AdminServices;

@SpringBootTest
class AdminServicesTests {

	@Autowired
	private AdminServices adminService;
	
	@Autowired
	AdminRepo adminRepo;

	Admin admin = new Admin(53, "SHHS", "jhdhd");

	@AfterEach
	void drop() throws GlobalMartException {
		try {
			adminService.deleteAdminById(53);
		} catch (Exception e) {

		}
	}

	@BeforeEach
	@Test
	void addAdmin() throws GlobalMartException {

		assumeTrue(adminService != null);
		assertNotNull(adminService.addAdmin(admin));
		assertThrows(GlobalMartException.class, () -> adminService.addAdmin(null));

	}

	@Test
	void getAdminById() throws GlobalMartException {

		assumeTrue(adminService != null);
		Admin adminFound = adminService.getAdminById(53).get();
		assertEquals(admin.getAdminName(), adminFound.getAdminName());
		assertThrows(GlobalMartException.class, () -> adminService.getAdminById(8999));

	}

	@Test
	void updateAdmin() throws GlobalMartException {
		assumeTrue(adminService != null);
		Admin adminUpdate = new Admin(890, "SHHS", "jhdhd");
		assertThrows(GlobalMartException.class, () -> adminService.updateAdmin(adminUpdate));
		Admin admin2 = adminService.updateAdmin(new Admin(53, "SHHS", "llllll"));
		assertEquals("llllll", admin2.getPassword());
	}

	@Test
	void deleteAdminById() throws GlobalMartException {
		assumeTrue(adminService != null);
		assertTrue(adminService.deleteAdminById(53));
		assertThrows(GlobalMartException.class, () -> adminService.getAdminById(53));
		assertThrows(GlobalMartException.class, () -> adminService.deleteAdminById(900));
	}

	@Test
	void getAllAdmin() throws GlobalMartException {
		assertNotNull(adminService.getAllAdmins());
		adminRepo.deleteAll();
		assertThrows(GlobalMartException.class, () -> adminService.getAllAdmins());
	}

	@Test
	void getByNameAndPassword() {
		assertThrows(GlobalMartException.class, () -> adminService.getAdminByNameAndPassword("akkk", "hkjk"));
		assertThrows(GlobalMartException.class, () -> adminService.getAdminByNameAndPassword(null, null));
	}

}
