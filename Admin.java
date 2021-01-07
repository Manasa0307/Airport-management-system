package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

@NamedQueries({ @NamedQuery(name = "getAllAdmins", query = "from Admin") })

@Component("admin")
@Entity
@Table(name = "admins")
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ADMIN_ID")
	private int adminId;

	@NotEmpty(message = "Enter Password")
	// @Size(min = 5)
	@Min(5)
	@Column(name = "ADMIN_PASSWORD", length = 20)
	private String adminPassword;

	@NotEmpty(message = "Enter Firstname")
	// @Size(min = 5)
	@Min(5)
	@Column(name = "ADMIN_FIRSTNAME", length = 20)
	private String adminFirstName;

	@Column(name = "ADMIN_LASTNAME", length = 20)
	private String adminLastName;

	@Column(name = "ADMIN_AGE")
	private int adminAge;

	@Column(name = "ADMIN_GENDER", length = 20)
	private String adminGender;

	@NotEmpty(message = "Invalid contact number")
	@Column(name = "ADMIN_CONTACTNUMBER")
	@Size(min = 10, max = 10)
	private long adminContactNumber;

	public Admin() {
		super();
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public String getAdminFirstName() {
		return adminFirstName;
	}

	public void setAdminFirstName(String adminFirstName) {
		this.adminFirstName = adminFirstName;
	}

	public String getAdminLastName() {
		return adminLastName;
	}

	public void setAdminLastName(String adminLastName) {
		this.adminLastName = adminLastName;
	}

	public int getAdminAge() {
		return adminAge;
	}

	public void setAdminAge(int adminAge) {
		this.adminAge = adminAge;
	}

	public String getAdminGender() {
		return adminGender;
	}

	public void setAdminGender(String adminGender) {
		this.adminGender = adminGender;
	}

	public long getAdminContactNumber() {
		return adminContactNumber;
	}

	public void setAdminContactNumber(long adminContactNumber) {
		this.adminContactNumber = adminContactNumber;
	}

}
