package com.spring.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.EmployeeDao;
import com.spring.model.Employee;
import com.spring.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	
 	@Autowired
   public EmployeeDao dao;	
 
	public List<Employee> getEmployees() {
		
		return dao.getEmployees();
	}

	public int saveEmployee(Employee emp) {
		
		return dao.saveEmployee(emp);
	}

	public int deleteEmployee(int id) {

		return dao.deleteEmployee(id);
	}

	public int updateEmployee(Employee emp) {
	
		return dao.updateEmployee(emp);
	}

	public Employee getEmployeeById(int id) {
		
		return dao.getEmployeeById(id);
	}
	
	
	

}
