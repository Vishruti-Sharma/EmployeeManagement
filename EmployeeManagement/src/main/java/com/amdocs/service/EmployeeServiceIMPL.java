package com.amdocs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amdocs.dao.EmployeeDao;
import com.amdocs.entity.Employee;

@Service
public class EmployeeServiceIMPL implements EmployeeService{
	@Autowired
	private EmployeeDao ed;
	
	@Override
	public List<Employee> getEmployees(){
		return ed.findAll();
	}
	
	@Override
	public Employee getEmployee(Long empId) {
		return ed.findById(empId).get();
	}
	
	@Override
	public Employee updateEmployeeById(Long empId,Employee employee) {
		Employee existingEmp=ed.findById(employee.getEmpId()).get();
		existingEmp.setEmpFirstName(employee.getEmpFirstName());
		existingEmp.setEmpLastName(employee.getEmpLastName());
		existingEmp.setEmpEmail(employee.getEmpEmail());
		Employee updatedEmployee=ed.save(existingEmp);
		
		return updatedEmployee;
	}
	
	@Override
	public Employee addEmployee(Employee employee) {
		
		return ed.save(employee);
	}
	
	@Override
	public void deleteEmployee(Long parseLong) {
		Employee entity=ed.getOne(parseLong);
		ed.delete(entity);
	}
	
	
}
