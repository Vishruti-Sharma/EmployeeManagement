package com.amdocs.controller;

import java.util.List;

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

import com.amdocs.entity.Employee;

import com.amdocs.service.EmployeeService;

@RestController
public class MyController {
	
	@Autowired
	private EmployeeService es;
	
	@GetMapping("/home")
	public String home() {
		return "welcome to the employee portal";
	}
	
	
	
	
	
	@PostMapping("employee")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
		Employee savedEmployee=es.addEmployee(employee);
		return new ResponseEntity<>(savedEmployee,HttpStatus.CREATED);
	}	
		@GetMapping("employee/{id}")
		public ResponseEntity<Employee> getEmployeeById(@PathVariable("id")Long empId){
			Employee employee=es.getEmployee(empId);
			return new ResponseEntity<>(employee,HttpStatus.OK);
		}
		@GetMapping("employee")
		public ResponseEntity<List<Employee>> getAllUser(){
			List<Employee> employees=es.getEmployees();
			return new ResponseEntity<>(employees,HttpStatus.OK);
		}
		
		@PutMapping("employee/{id}")
		public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long empId,@RequestBody Employee employee){
			employee.setEmpId(empId);
			Employee updatedEmployee=es.updateEmployeeById(empId,employee);
			return new ResponseEntity<>(updatedEmployee,HttpStatus.OK);
		}
		@DeleteMapping("employee/{id}")
		public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long empId){
			es.deleteEmployee(empId);
			return new ResponseEntity<>("User successfully deleted",HttpStatus.OK);
		}
	
	
	
	
//	@GetMapping("/employee")
//	public List<Employee> getEmployee(){
//		return this.es.getEmployees();
//	}
//	
//	@GetMapping("/employee/{empId}")
//	public Employee getEmployee(@PathVariable String empId) {
//		return this.es.getEmployee(Long.parseLong(empId));
//	}
//	@PostMapping("/employee")
//	public Employee addEmployee(@RequestBody Employee employee) {
//		return this.es.addEmployee(employee);
//	}
//	@PutMapping("/employee/{empId}")
//	public Employee updateEmployeeById(@RequestBody Employee employee) {
//		return this.es.updateEmployeeById(employee);
//	}
//	@DeleteMapping("/employee/{empId}")
//		public ResponseEntity<HttpStatus> deleteEmployee
//		(@PathVariable String empId){
//			try {
//				this.es.deleteEmployee(Long.parseLong(empId));
//				return new ResponseEntity<>(HttpStatus.OK);
//				
//			}catch(Exception e) {
//				return new ResponseEntity<>
//				(HttpStatus.INTERNAL_SERVER_ERROR);
//			}
//		}
		
	}
	

