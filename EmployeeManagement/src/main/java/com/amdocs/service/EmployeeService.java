package com.amdocs.service;

import java.util.List;

import com.amdocs.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> getEmployees();
	public Employee getEmployee(Long empId);
	public Employee addEmployee(Employee employee);
	public Employee updateEmployeeById(Long empId,Employee employee);
	public void deleteEmployee(Long parseLong);

}
