package com.leaveapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.leaveapp.bean.Employee;
import com.leaveapp.bean.Leave;
import com.leaveapp.service.EmployeeService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = { "/employee" })
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	@CrossOrigin(origins = "*")
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> getUserById(@PathVariable("id") int id) {
		System.out.println("Fetching User with id " + id);
		Employee user = employeeService.findById(id);
		if (user == null) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Employee>(user, HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@GetMapping(value = "mgr/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> getMgrById(@PathVariable("id") int id) {
		System.out.println("Fetching Mgr for employee id " + id);
		Employee user = employeeService.findMgrById(id);
		if (user == null) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Employee>(user, HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@PostMapping(value = "/leave/create", headers = "Accept=application/json", produces = { "application/json" })
	public int applyLve(@RequestBody Leave leave, UriComponentsBuilder ucBuilder) {
		System.out.println("Applying leave for " + leave.getEmpid());
		return employeeService.applyleave(leave);
	}

	@CrossOrigin(origins = "*")
	@GetMapping(value = "/get", headers = "Accept=application/json")
	public List<Employee> getAllUser() {
		List<Employee> tasks = employeeService.getUser();
		return tasks;

	}

	@CrossOrigin(origins = "*")
	@PostMapping(value = "/leave/approve", headers = "Accept=application/json", produces = { "application/json" })
	public int approveLve(@RequestBody Leave leave, UriComponentsBuilder ucBuilder) {
		System.out.println("Approving leave for " + leave.getId());
		return employeeService.aprvelve(leave);
	}

	@CrossOrigin(origins = "*")
	@GetMapping(value = "/leave/{id}", headers = "Accept=application/json")
	public List<Leave> getempleave(@PathVariable("id") int id) {
		List<Leave> tasks = employeeService.getLveDet(id);
		return tasks;
	}

	@CrossOrigin(origins = "*")
	@GetMapping(value = "/rptleave/{id}", headers = "Accept=application/json")
	public List<Leave> getrptleave(@PathVariable("id") int id) {
		List<Leave> tasks = employeeService.getrptLveDet(id);
		return tasks;

	}

	
	@CrossOrigin(origins = "*")
	@DeleteMapping(value = "/{id}", headers = "Accept=application/json")
	public ResponseEntity<Employee> deleteUser(@PathVariable("id") int id) {
		Employee user = employeeService.findById(id);
		if (user == null) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
		employeeService.deleteUserById(id);
		return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
	}
}
