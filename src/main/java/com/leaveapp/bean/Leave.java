package com.leaveapp.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LeaveDetails")
public class Leave {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "empid")
	private int empid;

	@Column(name = "empname")
	private String empname;

	@Column(name = "noofdays")
	private int noofdays;

	@Column(name = "strdate")
	private String strdate;

	@Column(name = "enddate")
	private String enddate;

	@Column(name = "leavetype")
	private String leavetype;

	@Column(name = "status")
	private String status;

	@Column(name = "reason")
	private String reason;

	@Column(name = "appliedon")
	private String appliedon;

	@Column(name = "mgrid")
	private int mgrid;

	@Column(name = "mgrcmnt")
	private String mgrcmnt;

	@Column(name = "lvebal")
	private int lvebal;

	public int getMgrid() {
		return mgrid;
	}

	public void setMgrid(int mgrid) {
		this.mgrid = mgrid;
	}

	public int getLvebal() {
		return lvebal;
	}

	public void setLvebal(int lvebal) {
		this.lvebal = lvebal;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public int getNoofdays() {
		return noofdays;
	}

	public void setNoofdays(int noofdays) {
		this.noofdays = noofdays;
	}

	public String getStrdate() {
		return strdate;
	}

	public void setStrdate(String strdate) {
		this.strdate = strdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public String getLeavetype() {
		return leavetype;
	}

	public void setLeavetype(String leavetype) {
		this.leavetype = leavetype;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getAppliedon() {
		return appliedon;
	}

	public void setAppliedon(String appliedon) {
		this.appliedon = appliedon;
	}

	public String getMgrcmnt() {
		return mgrcmnt;
	}

	public void setMgrcmnt(String mgrcmnt) {
		this.mgrcmnt = mgrcmnt;
	}

}
