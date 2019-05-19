package com.leaveapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leaveapp.bean.Employee;
import com.leaveapp.bean.Leave;
import com.leaveapp.dao.EmployeeDao;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeDao empDao;

	public List<Employee> getUser() {
		return empDao.getEmployee();
	}

	public Employee findById(int id) {
		return empDao.findById(id);
	}

	public Employee findMgrById(int id) {
		return empDao.findMgrById(id);
	}

	public int applyleave(Leave lvedet) {
		return empDao.applylve(lvedet);
	}

	public int aprvelve(Leave lvedet) {
		return empDao.aprvelve(lvedet);
	}

	public void deleteUserById(int id) {
		empDao.delete(id);
	}

	public List<Leave> getLveDet(int id) {
		return empDao.getLveDet(id);
	}

	public List<Leave> getrptLveDet(int id) {
		return empDao.getrptLveDet(id);
	}
}
