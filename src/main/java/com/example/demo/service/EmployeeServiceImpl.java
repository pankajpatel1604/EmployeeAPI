package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.exception.EmployeeDaoException;
import com.example.demo.exception.EmployeeServiceException;
import com.example.domain.Employee;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeDao employeeDao;
	
	public long addEmployee(Employee employee) throws EmployeeServiceException {
		
		try {
			
			return employeeDao.addEmployee(employee);
		
		} catch(EmployeeDaoException exe) {
			throw new EmployeeServiceException(exe.getMessage());
		}
	}
	
	public List<Employee> getEmployeeList() throws EmployeeServiceException  {
		
		try {
			
			return employeeDao.getEmployeeList();
		
		} catch(EmployeeDaoException exe) {
			throw new EmployeeServiceException(exe.getMessage());
		}
	}
	
	public Employee getEmployee(long empNo) throws EmployeeServiceException  {
		try {
			
			return employeeDao.getEmployee(empNo);
		
		} catch(EmployeeDaoException exe) {
			throw new EmployeeServiceException(exe.getMessage());
		}
	}
	
	public boolean deleteEmployee(long empNo) throws EmployeeServiceException  {
		try {
			
			return employeeDao.deleteEmployee(empNo);

		} catch(EmployeeDaoException exe) {
			throw new EmployeeServiceException(exe.getMessage());
		}
	}

	public boolean updateEmployee(Employee employee) throws EmployeeServiceException {
		try {
			return employeeDao.updateEmployee(employee);
		} catch(EmployeeDaoException exe) {
			throw new EmployeeServiceException(exe.getMessage());
		}
		
	}
	
}
