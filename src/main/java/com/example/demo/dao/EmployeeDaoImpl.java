package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.example.demo.exception.EmployeeDaoException;
import com.example.domain.Employee;

@Component("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {
	
	private static long employeeId = 2222;
	
	private static List<Employee> empList = new ArrayList<Employee>();
	
	static {
		Employee employee1 = new Employee("James","Bolen", 1111,"Admin");
		Employee employee2 = new Employee("Jim","Florian", 1112,"Sales");	
		Employee employee3 = new Employee("Thomas","Smith", 1113,"HR");
		
		empList.add(employee1);
		empList.add(employee2);
		empList.add(employee3);
		
			
	}
	
	public long addEmployee(Employee employee) throws EmployeeDaoException {
		if(employee.getEmployeeId()==0)
		employee.setEmployeeId(++employeeId);
		empList.add(employee);
		return employee.getEmployeeId();
	}
	
	public List<Employee> getEmployeeList() throws EmployeeDaoException  {
		return empList;
	}
	
	public Employee getEmployee(long employeeId) throws EmployeeDaoException {
		List<Employee> employeeList =  empList.stream().filter(emp->emp.getEmployeeId()==employeeId).collect(Collectors.toList());
		if(!CollectionUtils.isEmpty(employeeList))
			return employeeList.get(0);
		else 
			return null;
	}
	
	public boolean deleteEmployee(long employeeId) throws EmployeeDaoException {
		return empList.removeIf(emp->emp.getEmployeeId()==employeeId);
		
	}

	public boolean updateEmployee(Employee employee) throws EmployeeDaoException {
		
		boolean updateEmployee = false;
		
		for(Employee emp : empList) {
			if(emp.getEmployeeId()==employee.getEmployeeId()) {
				emp.setDepartment(employee.getDepartment());
				emp.setFirstName(employee.getFirstName());
				emp.setLastName(employee.getLastName());
				updateEmployee = true;
			}
		}
		
		return updateEmployee;	
		
	}

}
