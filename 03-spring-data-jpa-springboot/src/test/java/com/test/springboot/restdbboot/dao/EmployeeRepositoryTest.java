package com.test.springboot.restdbboot.dao;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.test.springboot.restdbboot.entity.Employee;






@Transactional
@SpringBootTest
public class EmployeeRepositoryTest {
	

private static final Logger log = LoggerFactory.getLogger(EmployeeRepositoryTest.class);
	
/*
 * @Autowired private TestEntityManager entityManager;
 */
	
	@Autowired
	private EmployeeRepository repository;

private Optional<Employee> findById;
	
	
	
	@Test
	@Rollback(false)
	public void testFindEmployee() {
		
		  Employee emp = new Employee(); 
		  emp.setId(1);
		  emp.setFirstName("Shane");
		  emp.setLastName("James");
		  emp.setEmail("Sj@gmail.com");
		 //repository.saveAndFlush(emp); assertThat(emp.getId()).isGreaterThan(0);
		List<Employee> actualList = repository.findAll();
		System.out.println(actualList);
		assertEquals(actualList.get(0).getId(), emp.getId());
		assertThat(actualList).isNotNull();
	
	}

	@Test
	public void createEmployee() {
		Employee emp = new Employee(); 
		  emp.setId(1);
		  emp.setFirstName("Shane");
		  emp.setLastName("James");
		  emp.setEmail("Sj@gmail.com");
		  Employee actualList = repository.save(emp);
		  System.out.println("Check OUT for " +actualList);
		  assertEquals(emp.getId(), actualList.getId());
		  
	}
	
   @Test
   public void updateEmployee() {
		Employee emp = new Employee(); 
		  emp.setId(2);
		  emp.setFirstName("Shane");
		  emp.setLastName("James");
		  emp.setEmail("Sj@gmail.com");
		 Employee updateEmp=   repository.getOne(2);
		  updateEmp.setFirstName("Nats");
		  repository.save(updateEmp);
		   
		  System.out.println("Check OUT for " + updateEmp);
		  assertEquals("Nats", updateEmp.getFirstName());
		  
	}
   
   @Test
   public void deleteEmployee() {
		Employee emp = new Employee(); 
		  emp.setId(2);
		  emp.setFirstName("Shane");
		  emp.setLastName("James");
		  emp.setEmail("Sj@gmail.com");
		  repository.save(emp);
		  repository.delete(emp);
			/*
			 * updateEmp.setFirstName("Nats"); repository.save(updateEmp);
			 */
		   
		  System.out.println("Check OUT for " + emp.getFirstName());
		  //assertNotNull(repository.getOne(3));
		  assertNotNull(repository.getOne(2));
		  
	}
   
}
