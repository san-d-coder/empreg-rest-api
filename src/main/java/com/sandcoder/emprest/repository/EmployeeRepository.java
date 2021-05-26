package com.sandcoder.emprest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sandcoder.emprest.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	public Iterable<Employee> findAllByOrderByEmployeeIdAsc();

}
