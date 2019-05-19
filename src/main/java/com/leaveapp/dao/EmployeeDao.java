package com.leaveapp.dao;

import java.util.List;

import com.leaveapp.bean.Leave;
import com.leaveapp.bean.Employee;

public interface EmployeeDao {
	public int applylve(Leave lvedet);

	public List<Employee> getEmployee();

	public Employee findById(int id);

	public Employee findMgrById(int id);

	public void delete(int id);

	public List<Leave> getLveDet(int id);

	public List<Leave> getrptLveDet(int id);

	public int aprvelve(Leave lvedet);
}
