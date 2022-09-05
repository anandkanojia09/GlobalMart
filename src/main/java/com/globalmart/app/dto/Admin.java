
package com.globalmart.app.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/************************************************************************************
 * @author Anand Kumar Kanojia
 * 
 * Description : It is a POJO class for Admin. All the entity and
 *         		 their respective mappings are defined here.
 * 
 * Version : 1.0
 * 
 * Created Date 02-AUG-2022
 ************************************************************************************/
@Entity
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer adminId;
	@NotBlank(message = "Name is Mandatory.")
	@Pattern(regexp = "^[a-zA-Z][a-zA-Z\\s]{1,20}[a-zA-Z]$", message = "Only letters are allowed.")
	@Size(min = 3, max = 20, message = "Name must be between 3 and 20 characters long.")
	private String adminName;
	@NotBlank(message = "Cannot be empty")
	@Pattern(regexp = "^(?=.*[0-9])"+ "(?=.*[a-z])(?=.*[A-Z])"+ "(?=.*[@#$%^&+=])"+ "(?=\\S+$).{6,20}$", message = "Password should contain at least one smallcase and one upper case letter, number and a special character!!")
	@Size(min = 6, max = 20, message = "Password should be more than 6 characters")
	private String adminPassword;
	@Email
	@NotBlank(message = "Cannot be empty")
	private String adminEmail;
	@NotBlank(message = "Cannot be empty")
	@Pattern(regexp = "(^[1-9][0-9]{8}[0-9]$)", message = "Phone number should contain numbers only!!")
	@Size(min = 10, max = 10, message = "Incorrect Number ")
	private String adminPhoneNumber;
	
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(Integer adminId,
			@NotBlank(message = "Name is Mandatory.") @Pattern(regexp = "[A-Za-z]*", message = "Only Alphanumeric characters are allowed.") @Size(min = 3, max = 20, message = "Name must be between 3 and 20 characters long.") String adminName,
			@NotBlank(message = "Cannot be empty") @Pattern(regexp = "[A-Za-z0-9]*", message = "Password should contain number and special characters!!") @Size(min = 6, max = 20, message = "Password should be more than 6 characters") String adminPassword,
			@Email @NotBlank(message = "Cannot be empty") @Pattern(regexp = "[A-Za-z0-9]*", message = "Password should contain number and special characters!!") @Size(min = 6, max = 20, message = "Password should be more than 8 characters") String adminEmail,
			@NotBlank(message = "Cannot be empty") @Pattern(regexp = "(^[0-9]{10})", message = "Phone number should contain numbers only!!") @Size(min = 10, max = 10, message = "Incorrect Number ") String adminPhoneNumber) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminPassword = adminPassword;
		this.adminEmail = adminEmail;
		this.adminPhoneNumber = adminPhoneNumber;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public String getAdminPhoneNumber() {
		return adminPhoneNumber;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public void setAdminPhoneNumber(String adminPhoneNumber) {
		this.adminPhoneNumber = adminPhoneNumber;
	}

}