package com.sandcoder.emprest.service;

import com.sandcoder.emprest.model.Employee;

public interface EmployeeService {

	Iterable<Employee> findEmployees();

	Employee findEmployee(int employeeId);

	Employee createEmployee(Employee employee);

	void editEmployee(int employeeId, Employee employee);

	void deleteEmployee(int employeeId);

}