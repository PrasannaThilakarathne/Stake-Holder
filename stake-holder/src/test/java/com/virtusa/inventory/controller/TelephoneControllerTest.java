package com.virtusa.inventory.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(TelephoneControllerTest.class)
public class TelephoneControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	TelephoneController telephoneController;

	@Test
	public void okTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/telephones/telephone"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void notFoundTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/telepho")).andExpect(MockMvcResultMatchers.status().isNotFound());
	}
}
