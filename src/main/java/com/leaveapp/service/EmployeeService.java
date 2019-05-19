package com.leaveapp.service;

import java.util.List;

import com.leaveapp.bean.Employee;
import com.leaveapp.bean.Leave;

public interface EmployeeService {
	public int applyleave(Leave lvedet);

	public List<Employee> getUser();

	public Employee findById(int id);

	public Employee findMgrById(int id);

	public void deleteUserById(int id);

	public List<Leave> getLveDet(int id);

	public List<Leave> getrptLveDet(int id);

	public int aprvelve(Leave lvedet);
}
