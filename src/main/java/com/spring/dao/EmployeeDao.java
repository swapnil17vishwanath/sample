package com.spring.dao;

import java.util.List;

import com.spring.model.Employee;

public interface EmployeeDao {
	
	public List<Employee> getEmployees();
	public int saveEmployee(Employee emp);
	public int deleteEmployee(int id);
	public int updateEmployee(Employee emp);
    public Employee getEmployeeById(int id);
}
