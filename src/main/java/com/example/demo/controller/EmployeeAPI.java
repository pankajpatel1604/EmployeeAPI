package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.exception.EmployeeServiceException;
import com.example.demo.service.EmployeeService;
import com.example.domain.Employee;

@RestController
public class EmployeeAPI {
	
	@Autowired
	EmployeeService employeeService;
	
	protected final Log logger = LogFactory.getLog(getClass());
	
	@GetMapping("employees/employeeList")
	public List<Employee> getEmployeeList() throws EmployeeServiceException {
		
		return employeeService.getEmployeeList();
		
	}
	
	@PostMapping("employees/addEmployee")
	public ResponseEntity<String> addEmployee(@Valid  @RequestBody Employee employee) throws EmployeeServiceException {
		
		long employeeId = employeeService.addEmployee(employee);
		
		logger.info("Employeee Id Created :"+employeeId);
		return new ResponseEntity<String>("employeeId :"+employeeId,HttpStatus.CREATED); 
		
	}
	
	@GetMapping("employees/getEmployee/{Id}")
	public Employee getEmployee(@PathVariable("Id") long employeeId) throws EmployeeNotFoundException, EmployeeServiceException  {
		
		logger.info("Employeee Id :"+employeeId);
		Employee employee = employeeService.getEmployee(employeeId);
		if(employee ==null)
			throw new EmployeeNotFoundException("employeeId :"+employeeId + " not found");
		
		return employee;
	}
	
	@DeleteMapping("employees/deleteEmployee/{Id}")
	public void deleteEmployee(@PathVariable("Id") long employeeId) throws EmployeeNotFoundException, EmployeeServiceException {
		
		boolean employeeDeleted = employeeService.deleteEmployee(employeeId);
		if(!employeeDeleted)
			throw new EmployeeNotFoundException("employeeId :"+employeeId + " not found");	
	}
	
	
	@PutMapping("employees/updateEmployee")
	public void updateEmployee(@Valid  @RequestBody Employee employee) throws EmployeeServiceException {
		
		boolean employeeUpdated = employeeService.updateEmployee(employee);
		if(!employeeUpdated)
			throw new EmployeeNotFoundException("employeeId :"+employee.getEmployeeId() + " not found");
		
	}
	
	
}
