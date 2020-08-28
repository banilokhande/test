package com.test.springboot.restdbboot.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.Ignore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.test.springboot.restdbboot.dao.EmployeeRepository;
import com.test.springboot.restdbboot.entity.Employee;
import com.test.springboot.restdbboot.service.EmployeeServiceImpl;

@RunWith(MockitoJUnitRunner.class)
class EmployeeServiceImplTest {
	@Mock
	Employee empl;
	@Autowired
	EmployeeRepository employeeRepository;
	
	@InjectMocks
	EmployeeServiceImpl empService ;
	
	@Test
	void testFindByID() {
		Optional<Employee> emp =Optional.of(new Employee ("Vicky","Beck","Vicky@gmail.com"));
		Mockito.when(employeeRepository.findById(2)).thenReturn(emp);
		
		Employee service = new Employee();
		service = empService.findById(2);
		assertEquals(emp, service);
	}
	
	@Test
	void testFindByID_B() {
	Employee theempl = new Employee ("B","C","com");
	employeeRepository.save(theempl);
	//Assertions.assertNotNull(employeeRepository.existsById(theempl));
	
	}
	
	
		
	
	/*@Ignore
	@Test
	void testSave() {
		 empl = new Employee ("Neha","Beck","Vicky@gmail.com");
		//Mockito.when(employeeRepository.findAll()).thenReturn(List<Emloyee>,);
		
		Employee service = new Employee();
		//service = empService.save(empl);
		Assertions.assertEquals(empl, service);
	}*/
	

}
