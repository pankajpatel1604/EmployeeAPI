package com.example.demo.dao;

import java.util.List;

import com.example.demo.exception.EmployeeDaoException;
import com.example.domain.Employee;

public interface EmployeeDao {
	
	public long addEmployee(Employee employee) throws EmployeeDaoException;
	
	public List<Employee> getEmployeeList() throws EmployeeDaoException;
	
	public Employee getEmployee(long empNo) throws EmployeeDaoException;
	
	public boolean deleteEmployee(long empNo) throws EmployeeDaoException;
	
	public boolean updateEmployee(Employee employee) throws EmployeeDaoException;

}
