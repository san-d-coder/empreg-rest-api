package com.sandcoder.emprest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sandcoder.emprest.model.Employee;
import com.sandcoder.emprest.service.EmployeeService;

@RestController(value = "/api/v1")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping(value = "/findAll")
	public Iterable<Employee> findEmployees() {
		return this.employeeService.findEmployees();
	}
	
	@GetMapping(value = "/find/{employeeId}")
	public Employee findEmployee(@PathVariable(value="employeeId") int employeeId) {
		return this.employeeService.findEmployee(employeeId);
	}
	
	@PostMapping(value = "/create")
	public Employee createEmployee(@RequestBody Employee employee) {
		return this.employeeService.createEmployee(employee);
	}
	
	@PutMapping(value = "/edit/{employeeId}")
	public void editEmployee(@PathVariable(value="employeeId") int employeeId, @RequestBody Employee employee) {
		this.employeeService.editEmployee(employeeId, employee);
	}
	
	@DeleteMapping(value = "/delete/{employeeId}")
	public void deleteEmployee(@PathVariable(value="employeeId") int employeeId) {
		this.employeeService.deleteEmployee(employeeId);
	}
	
}
