package com.amdocs.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amdocs.entity.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Long> {
	
	
}
