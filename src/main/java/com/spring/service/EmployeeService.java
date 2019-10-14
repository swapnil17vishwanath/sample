package com.spring.service;

import java.util.List;


import com.spring.model.Employee;

public interface EmployeeService {
	
	

	public List<Employee> getEmployees();
	public int saveEmployee(Employee emp);
	public int deleteEmployee(int id);
	public int updateEmployee(Employee emp);
	public Employee getEmployeeById(int id);

}
