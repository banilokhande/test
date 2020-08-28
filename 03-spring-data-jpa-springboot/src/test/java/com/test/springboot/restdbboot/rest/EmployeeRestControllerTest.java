package com.test.springboot.restdbboot.rest;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertThat ;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.* ;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.hibernate.type.AnyType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.test.springboot.restdbboot.entity.Employee;
import com.test.springboot.restdbboot.service.EmployeeService;
import com.test.springboot.restdbboot.service.EmployeeServiceImpl;

class EmployeeRestControllerTest {
	
	@InjectMocks
	EmployeeRestController 	empRestController ;
	
	@Mock
	EmployeeService employeeService;
	
	
	
	@BeforeEach
	void setUp() throws Exception {
	MockitoAnnotations.initMocks(this);
	
	}

	@Test
	void testGetEmployee() {
		Employee theemployee = new Employee();
		theemployee.setId(2);
		theemployee.setFirstName("Ridhi");
		theemployee.setLastName("Sharma");
		theemployee.setEmail("rs@gmail.com");
		
		
		when(employeeService.findById(anyInt())).thenReturn(theemployee);
		Employee empEntityController = empRestController.getEmployee(2);
		assertNotNull(empEntityController);
		//assertEquals("Riddhi", empEntity.getFirstName());
		assertEquals(theemployee.getId(), empEntityController.getId());
		assertEquals(theemployee.getFirstName(), empEntityController.getFirstName());
		/*
		 * System.out.println(theemployee.getId());
		 * System.out.println(empEntity.getFirstName());
		 */
	}
	
	@Test
	final void testGetEmployee_Employee_NotFound() {
		when(employeeService.findById(anyInt())).thenReturn(null);
		assertThrows(EmployeeNotFoundException.class, 
				()->{
					empRestController.getEmployee(2);
				}
				);
	}  
	
	
	 @Test 
	 void testGetAllEmployee() { 
		 
		System.out.println(employeeService.getAllEmployee().size());
		 Integer b= empRestController.getAllEmployee().size();
		// System.out.println(a);
		 System.out.println(b);
	//	assertEquals(a,b);
		//	 assertTrue(employeeService.getAllEmployee().size() == empRestController.getAllEmployee().size());
		
	  }
	 
		
		  @Test 
		  void testUpdateEmployee() { 
		  Employee theemployee = new Employee();
		 //theemployee= employeeService.findById(4);
		  theemployee.setFirstName("Jenna");
		  theemployee.setLastName("Pits");
		  theemployee.setEmail("Jt@gmail.com");
		  theemployee.setId(4);
		 // employeeService.save(theemployee);
		  Optional<Employee> em = Optional.of(theemployee);
		  Employee empl = em.get();
		  empl.setFirstName("Tracy");
		  when(employeeService.findById(4)).thenReturn(empl);
		  Employee empCont = empRestController.getEmployee(4);
		  employeeService.save(empl);
		  System.out.println(empl.getFirstName());
		  assertEquals(empl.getFirstName(), empCont.getFirstName());	
			
			/*
			 * Employee empEntity = empRestController.getEmployee(4); empEntity =
			 * empRestController.addEmployee(theemployee); //assertNotNull(empEntity);
			 * 
			 * System.out.println(theemployee.getFirstName()); System.out.println(
			 * empEntity.getFirstName()); // assertEquals("Updated First Name",true,
			 * employeeService.save(theemployee)); assertEquals(theemployee.getFirstName(),
			 * empEntity.getFirstName());
			 */
		  
		  }
	 
	 

}
