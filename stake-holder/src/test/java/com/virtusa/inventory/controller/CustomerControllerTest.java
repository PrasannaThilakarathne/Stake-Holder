package com.virtusa.inventory.controller;

import org.hibernate.query.criteria.internal.expression.SearchedCaseExpression.WhenClause;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.virtusa.inventory.repository.CustomerRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(CustomerControllerTest.class)
public class CustomerControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	CustomerController customerController;
	

	@Test
	public void testIsOk() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/details")).andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void testNotFound() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/detail")).andExpect(MockMvcResultMatchers.status().isNotFound());

	}
}
