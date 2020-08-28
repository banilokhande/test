 package com.test.springboot.restdbboot.rest;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.logging.LoggingApplicationListener;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.test.springboot.restdbboot.entity.Employee;
import com.test.springboot.restdbboot.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	Logger logger = LoggerFactory.getLogger(EmployeeRestController.class);

	private EmployeeService employeeService;
	// inject employee dao directly(refrain)
	@Autowired 
	public EmployeeRestController(EmployeeService theemployeeSevice) {
		employeeService=theemployeeSevice;
	}
	
	
	//expose "/employees" and return employee
	@GetMapping("/employees")
	//public ResponseEntity<List<Employee>> getAllEmployee(){
	public List<Employee> getAllEmployee(){
		//logger.error("Error occured");
		logger.info("Run Successfull");
		//logger.trace("All Employees are now fetched");
		//return ResponseEntity.ok().body(employeeService.getAllEmployee());
		
		return employeeService.getAllEmployee();
	}
	
   // Read employee by id
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		Employee theemployee=employeeService.findById(employeeId);
		if(theemployee == null) {
			throw new EmployeeNotFoundException("Employee not present "+ employeeId);
		}
		Employee returnValue= new Employee();
		BeanUtils.copyProperties(theemployee, returnValue);
		return theemployee;
	}
	
	//Create a new Employee
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		
		//to save a new item
		theEmployee.setId(0);
		employeeService.save(theEmployee);
		return theEmployee;
	}
	
	//Update an Employee
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		employeeService.save(theEmployee);
		return theEmployee;
				
	}
	
	//Delete an employee
	@DeleteMapping("employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		employeeService.deleteById(employeeId);
		return "Deleted employee id :  "+ employeeId;
	}
	
	
	
	
	
	
	
	
}
