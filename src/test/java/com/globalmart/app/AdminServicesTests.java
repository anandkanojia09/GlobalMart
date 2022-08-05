package com.globalmart.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.globalmart.app.dto.Admin;
import com.globalmart.app.exception.GlobalMartException;
import com.globalmart.app.services.AdminServices;

@SpringBootTest
class AdminServicesTests {

	@Autowired
	private AdminServices adminService;

	Admin admin = new Admin(53, "SHHS", "jhdhd");

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
		assertEquals(admin, adminFound);
		assertThrows(GlobalMartException.class, () -> adminService.getAdminById(0));

	}

//	@Test
//	void updateAdmin() throws GlobalMartException {
//		assumeTrue(adminService != null);
//		admin = new Admin(0, "AAAA", "JJJJ");
//		assertThrows(GlobalMartException.class, () -> adminService.updateAdminById(admin));
//		Admin admin2 = adminService.updateAdminById(new Admin(53, "SHHS", "jhdhd"));
//		assertEquals(admin.getAdminId(), admin2.getAdminId());
//	}
//
//	@Test
//	void deleteAdmnById() throws GlobalMartException {
//		assumeTrue(adminService != null);
//		adminService.deleteAdminById(53);
//		assertThrows(GlobalMartException.class, () -> adminService.getAdminById(53));
//	}

}
