package com.virtusa.inventory.controller;

import javax.management.loading.PrivateClassLoader;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.virtusa.inventory.service.CustomerDetailService;

@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerDetailControllerTest {
	
	private MockMvc mockMvc;
	
	@Mock
	private CustomerDetailService customerDetailService;
	
	@InjectMocks
	private CustomerDetailController customerDetailController;
	
	@Before
	public void setUp()throws Exception{
		mockMvc = MockMvcBuilders.standaloneSetup(customerDetailController).build();
	}
	
	
	
}
