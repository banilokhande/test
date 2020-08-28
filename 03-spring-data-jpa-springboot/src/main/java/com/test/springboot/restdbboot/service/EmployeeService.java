package com.test.springboot.restdbboot.service;

import java.util.List;

import com.test.springboot.restdbboot.entity.Employee;

public interface EmployeeService {

  public List<Employee> getAllEmployee();
	
	public Employee findById(int theId);
	
	public void save(Employee theEmployee) ;
	
	public void deleteById(int theId);
	
}
