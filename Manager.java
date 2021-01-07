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

import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

@NamedQueries({ @NamedQuery(name = "getAllManagers", query = "from Manager") })

@Component("manager")
@Entity
@Table(name = "managers")
public class Manager {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MANAGER_ID")
	private int managerId;

	@NotEmpty(message = "Enter Password")
	@Min(value = 5)
	@Column(name = "MANAGER_PASSWORD", length = 20)
	private String managerPassword;

	@NotEmpty(message = "Enter Firstname")
	@Min(value = 5)
	@Column(name = "MANAGER_FIRSTNAME", length = 20)
	private String managerFirstName;

	@Column(name = "MANAGER_LASTNAME", length = 20)
	private String managerLastName;

	@Column(name = "MANAGER_AGE")
	private int managerAge;

	@Column(name = "MANAGER_GENDER", length = 10)
	private String managerGender;

	@NotEmpty(message = "Enter Contact Number")
	@Column(name = "MANAGER_CONTACTNUMBER")
	private long managerContactNumber;

	@Column(name = "ADMIN_APPROVAL_STATUS", length = 10)
	private String approvalStatus;

	public Manager() {
		super();
	}

	public String getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public String getManagerPassword() {
		return managerPassword;
	}

	public void setManagerPassword(String managerPassword) {
		this.managerPassword = managerPassword;
	}

	public String getManagerFirstName() {
		return managerFirstName;
	}

	public void setManagerFirstName(String managerFirstName) {
		this.managerFirstName = managerFirstName;
	}

	public String getManagerLastName() {
		return managerLastName;
	}

	public void setManagerLastName(String managerLastName) {
		this.managerLastName = managerLastName;
	}

	public int getManagerAge() {
		return managerAge;
	}

	public void setManagerAge(int managerAge) {
		this.managerAge = managerAge;
	}

	public String getManagerGender() {
		return managerGender;
	}

	public void setManagerGender(String managerGender) {
		this.managerGender = managerGender;
	}

	public long getManagerContactNumber() {
		return managerContactNumber;
	}

	public void setManagerContactNumber(long managerContactNumber) {
		this.managerContactNumber = managerContactNumber;
	}

}
