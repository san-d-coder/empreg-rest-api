package com.sandcoder.emprest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandcoder.emprest.model.Employee;
import com.sandcoder.emprest.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	/* (non-Javadoc)
	 * @see com.sandcoder.emprest.service.EmployeeService#findEmployees()
	 */
	@Override
	public Iterable<Employee> findEmployees(){
		return this.employeeRepository.findAllByOrderByEmployeeIdAsc();
	}
	
	/* (non-Javadoc)
	 * @see com.sandcoder.emprest.service.EmployeeService#findEmployee(int)
	 */
	@Override
	public Employee findEmployee(int employeeId) {
		return this.employeeRepository.findById(employeeId).get();
	}
	
	/* (non-Javadoc)
	 * @see com.sandcoder.emprest.service.EmployeeService#saveEmployee(com.sandcoder.emprest.model.Employee)
	 */
	@Override
	public Employee createEmployee(Employee employee) {
		return this.employeeRepository.save(employee);
	}
	
	/* (non-Javadoc)
	 * @see com.sandcoder.emprest.service.EmployeeService#editEmployee(int, com.sandcoder.emprest.model.Employee)
	 */
	@Override
	public void editEmployee(int employeeId, Employee employee) {
		this.employeeRepository.findById(employeeId).ifPresentOrElse((foundEmployee) -> {
			foundEmployee = employee;
			this.employeeRepository.save(foundEmployee);
		}, ()->{
			System.out.println("not there");
		});
	}
	
	/* (non-Javadoc)
	 * @see com.sandcoder.emprest.service.EmployeeService#deleteEmployee(int)
	 */
	@Override
	public void deleteEmployee(int employeeId) {
		this.employeeRepository.deleteById(employeeId);
	}

}
