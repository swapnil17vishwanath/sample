package com.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.spring.model.Employee;
import com.spring.service.EmployeeService;

@RestController
public class EmployeeRestController {
	
	@Autowired
	public EmployeeService service;
	
	
	/*@RequestMapping(value="/getEmployee",method=RequestMethod.GET, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Employee>>  getEmployee()
	{
		List<Employee> empList=new ArrayList<Employee>();
		
		empList = service.getEmployees();
		
      return new ResponseEntity<List<Employee>>(empList,HttpStatus.OK);
		
	}*/
	
	
	@RequestMapping(value="/getEmployee",method=RequestMethod.GET, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView getEmployee()
	{
		List<Employee> empList=new ArrayList<Employee>();
		ModelAndView model=new ModelAndView();
		
		empList = service.getEmployees();
		model.addObject("list", empList);
		model.setViewName("login");
		
      return model;
		
	}
	
	
	
	
	@RequestMapping(value="/getEmployee/{id}",method=RequestMethod.GET, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee>  getEmployeeById(@PathVariable("id") int id)
	{
		Employee emp=new Employee();
		
		emp = service.getEmployeeById(id);
		
		return new ResponseEntity<Employee>(emp,HttpStatus.OK);
		
	}
	
	
	
	@RequestMapping(value="/saveEmployee", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp)
	{
		
		 service.saveEmployee(emp);
		
		return new ResponseEntity<Employee>(emp,HttpStatus.OK);
	
	}
	
	
	
	

	@RequestMapping(value="/deleteEmployee/{id}", method=RequestMethod.DELETE, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") int id)
	{
		
		service.deleteEmployee(id);
		
		
		
		return new ResponseEntity<Employee>(HttpStatus.OK);
	}
	

	@RequestMapping(value="/updateEmployee/{id}", method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public  ResponseEntity<Employee> updateEmployee(@PathVariable("id") int id,   @RequestBody Employee emp)
	{
		
		
	    Employee emp1=service.getEmployeeById(id);
	    emp1.setEmpName(emp.getEmpName());
	    emp1.setEmpCity(emp.getEmpCity());
	    emp1.setEmpSal(emp.getEmpSal());
	    service.updateEmployee(emp1);
	   

		return new ResponseEntity<Employee>(HttpStatus.OK);
	
	}
	
	
	
}
