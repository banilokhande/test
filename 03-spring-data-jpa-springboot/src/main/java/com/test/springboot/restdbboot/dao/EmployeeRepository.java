package com.test.springboot.restdbboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.CrudRepository;

import com.test.springboot.restdbboot.entity.Employee;



public interface EmployeeRepository extends JpaRepository <Employee, Integer> {

	//public Employee findByName(String name);
}
