package com.test.springboot.restdbboot.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.atLeast;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.test.springboot.restdbboot.dao.EmployeeRepository;
import com.test.springboot.restdbboot.entity.Employee;
import com.test.springboot.restdbboot.rest.EmployeeNotFoundException;
import com.test.springboot.restdbboot.rest.EmployeeRestController;

class EmployeeServiceImplTest {
	@InjectMocks
	EmployeeServiceImpl	employeeService;
	
	@Mock
	EmployeeRepository employeeDao;
	
	
	
	@BeforeEach
	void setUp() throws Exception {
	MockitoAnnotations.initMocks(this);
	
	}

	@Test
	void testGetEmployee() {
		Employee empl = new Employee();
		empl.setEmail("KJ@gmail");
		empl.setFirstName("Kash");
		empl.setLastName("Twelve");
		empl.setId(6);
		Optional<Employee> theemployee = Optional.of(empl);
		
	
		  when(employeeDao.findById(6)).thenReturn(theemployee); 
		  Employee empEntity =employeeService.findById(6); 
		 
		 System.out.println(empl.getFirstName());
		 System.out.println(empEntity.getFirstName());
		assertEquals(empl.getFirstName(), empEntity.getFirstName());
		
	}
	
	@Test
	void testCreateEmployee() {
		
		  Employee theemployee = new Employee(); theemployee.setId(2);
		  theemployee.setFirstName("Ridhi"); theemployee.setLastName("Sharma");
		  theemployee.setEmail("rs@gmail.com");
		
		/*Works for both Employees, optional as well
		 * Employee empl = new Employee(); empl.setEmail("KJ@gmail");
		 * empl.setFirstName("Kash"); empl.setLastName("Twelve"); empl.setId(6);
		 * Optional<Employee> theemployee = Optional.of(empl);
		 */
		 employeeService.save(theemployee);
		 verify(employeeDao,atLeast(1)).save(theemployee);
		
		
	}
	
	@Test
	void testUpdateEmployee() {
		
		Employee empl = new Employee();
		empl.setEmail("KJ@gmail");
		empl.setFirstName("Kash");
		empl.setLastName("Twelve");
		empl.setId(2);
		Optional<Employee> theemployee = Optional.of(empl);
		  Employee em= theemployee.get();
		  em.setFirstName("Tracy");
		  
		  when(employeeDao.findById(2)).thenReturn(theemployee); 
		  Employee empServ = employeeService.findById(2);
		  employeeService.save(em);
		  System.out.println(em.getFirstName());
		  assertEquals(em.getFirstName(), empServ.getFirstName());	 
		}
	
	/*
	 * @Test final void testGetEmployee_Employee_NotFound() {
	 * when(employeeService.findById(anyInt())).thenReturn(null);
	 * assertThrows(EmployeeNotFoundException.class, ()->{
	 * empRestController.getEmployee(2); } ); }
	 * 
	 * 
	 * @Test void testGetAllEmployee() {
	 * 
	 * System.out.println(employeeService.getAllEmployee().size()); Integer b=
	 * empRestController.getAllEmployee().size(); // System.out.println(a);
	 * System.out.println(b); // assertEquals(a,b); //
	 * assertTrue(employeeService.getAllEmployee().size() ==
	 * empRestController.getAllEmployee().size());
	 * 
	 * }
	 * 
	 * 
	 * @Test void testUpdateEmployee() { theemployee= employeeService.findById(4);
	 * theemployee.setFirstName("Jenna"); //employeeService.save(theemployee);
	 * Employee empEntity = empRestController.getEmployee(4);
	 * System.out.println(theemployee.getFirstName()); System.out.println(
	 * empEntity.getFirstName()); // assertEquals("Updated First Name",true,
	 * employeeService.save(theemployee)); assertEquals(theemployee.getFirstName(),
	 * empEntity.getFirstName(), "Updated First Name");
	 * 
	 * }
	 * 
	 */

}
