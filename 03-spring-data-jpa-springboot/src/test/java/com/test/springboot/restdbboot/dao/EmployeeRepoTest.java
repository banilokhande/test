package com.test.springboot.restdbboot.dao;
import static org.assertj.core.api.Assertions.assertThat;


import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.test.springboot.restdbboot.entity.Employee;






@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@TestMethodOrder(OrderAnnotation.class)
public class EmployeeRepoTest {
	
	
	@Autowired
	private EmployeeRepository repository;
	
	/* @Test
	@Rollback(false)
	@Order(1)
	public void testCreateEmployee() {
		//Employee savedProduct = repository.save(new Employee("Shibani", "Lokhande","shibani.lokhande@gm.com"));
		
    	Employee emp = new Employee();
    	emp.setId(9);
    	emp.setFirstName("Reslie");
    	emp.setLastName("James");
    	emp.setEmail("Sj@gmail.com");
    	repository.save(emp);
		assertThat(emp.getId()).isGreaterThan(0);
	}


	
	
	
	 * @Test
	 * 
	 * @Order(2) public void testFindProductByName() { Employee product =
	 * repository.findByName("Emma");
	 * assertThat(product.getFirstName()).isEqualTo("Emma"); }
	 */


}
