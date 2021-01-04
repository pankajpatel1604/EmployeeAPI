package com.example.demo.service;

import java.util.List;

import com.example.demo.exception.EmployeeServiceException;
import com.example.domain.Employee;

public interface EmployeeService {

	public long addEmployee(Employee employee) throws EmployeeServiceException;
	
	public List<Employee> getEmployeeList() throws EmployeeServiceException;
	
	public Employee getEmployee(long empNo) throws EmployeeServiceException;
	
	public boolean deleteEmployee(long empNo) throws EmployeeServiceException;
	
	public boolean updateEmployee(Employee employee) throws EmployeeServiceException;
	
}
