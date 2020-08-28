package com.test.springboot.restdbboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.test.springboot.restdbboot.dao.EmployeeRepository;
import com.test.springboot.restdbboot.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository ;
	
	public EmployeeServiceImpl(EmployeeRepository theemployeeRepository) {
		employeeRepository=theemployeeRepository;
	}
	
	@Override
	public List<Employee> getAllEmployee() {
		System.out.println((List<Employee>) employeeRepository.findAll());
		return (List<Employee>) employeeRepository.findAll();
		
	}

	@Override
	//@Transactional   : JPA automatically does it for you
	public Employee findById(int theId) {
		
		Optional<Employee> result = employeeRepository.findById(theId);
		return result.get();
	}

	@Override
	public void save(Employee theEmployee) {
		employeeRepository.save(theEmployee);

	}

	@Override
	public void deleteById(int theId) {

		employeeRepository.deleteById(theId);

	}

}
