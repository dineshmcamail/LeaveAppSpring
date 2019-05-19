package com.leaveapp.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EmployeeDetails")
public class Employee {

	@Id
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;

	@Column(name = "mobile")
	private String mobile;

	@Column(name = "joineddate")
	private String joineddate;

	@Column(name = "department")
	private String department;

	@Column(name = "leavebal")
	private int leavebal;

	@Column(name = "mgrid")
	private int mgrid;

	public int getMgrid() {
		return mgrid;
	}

	public void setMgrid(int mgrid) {
		this.mgrid = mgrid;
	}

	public int getLeavebal() {
		return leavebal;
	}

	public void setLeavebal(int leavebal) {
		this.leavebal = leavebal;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getJoineddate() {
		return joineddate;
	}

	public void setJoineddate(String joineddate) {
		this.joineddate = joineddate;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
