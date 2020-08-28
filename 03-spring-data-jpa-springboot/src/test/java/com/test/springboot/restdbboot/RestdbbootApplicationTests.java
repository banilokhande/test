package com.test.springboot.restdbboot;

import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.test.context.junit4.SpringRunner;

import com.test.springboot.restdbboot.dao.EmployeeRepository;
import com.test.springboot.restdbboot.entity.Employee;
import com.test.springboot.restdbboot.service.EmployeeServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
class RestdbbootApplicationTests {

	@Autowired
	private EmployeeServiceImpl service ;
	
	@MockBean
	private EmployeeRepository repository ;
	
	@Test
	void contextLoads() {
		
	}
	
	/*
	 * @Test public void getUserTest() {
	 * 
	 * when(repository.findAll()).thenReturn(Collections.emptyList());
	 * assertFalse(condition); verify(repository).findAll();
	 * 
	 * }
	 * 
	 */
}
