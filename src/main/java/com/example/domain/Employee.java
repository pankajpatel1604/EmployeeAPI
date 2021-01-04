package com.example.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class Employee {
	
	@NotNull
	@Size(min=2,max=15)
	private String firstName;
	
	@NotNull
	@Size(min=2,max=15)
	private String lastName; 
	
	private long employeeId;
	
	@NotNull
	@Size(min=2,max=10)
	private String department;
	
	public Employee(String firstName, String lastName, long employeeId, String department) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.employeeId = employeeId;
		this.department = department;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	

}
