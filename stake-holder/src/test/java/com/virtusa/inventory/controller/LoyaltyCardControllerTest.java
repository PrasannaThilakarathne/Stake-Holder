package com.virtusa.inventory.controller;

import java.util.Date;

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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.virtusa.inventory.modal.LoyaltyCard;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(LoyaltyCardControllerTest.class)
public class LoyaltyCardControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private LoyaltyCardCotroller loyaltyCardCotroller;

	@Test
	public void testLoyaltyCardGetStatusIsOk() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/loyalty/card").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
//                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_VALUE))
//                .andReturn();
//                .andExpect(MockMvcResultMatchers.content().json());

	}

	@Test
	public void testLoyaltyCardGetStatusIsNotFound() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/loyalty/cards").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isNotFound());
//                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_VALUE))
//                .andReturn();
//                .andExpect(MockMvcResultMatchers.content().json());

	}

	@Test
	public void testLoyaltyCardPostStatusIsOk() throws Exception {

		LoyaltyCard loyaltyCard = new LoyaltyCard();
		loyaltyCard.setName("pasindu");
		loyaltyCard.setNumber("12345678");
		loyaltyCard.setPointBalance(10.0);
		loyaltyCard.setIssuedDate(new Date());
		loyaltyCard.setExpiryDate(new Date());

		// Convert LoyaltyCard object into String
		ObjectMapper mapper = new ObjectMapper();
		String loyaltyJson = mapper.writeValueAsString(loyaltyCard);
//		System.out.println(loyaltyJson);

		mockMvc.perform(MockMvcRequestBuilders.post("/loyalty/card").contentType(MediaType.APPLICATION_JSON)
				.content(loyaltyJson)).andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void testLoyaltyCardPostResponse() throws Exception {
		LoyaltyCard loyaltyCardPost = new LoyaltyCard();
		loyaltyCardPost.setName("pasindu");
		loyaltyCardPost.setNumber("12345678");
		loyaltyCardPost.setPointBalance(10.0);
		loyaltyCardPost.setIssuedDate(null);
		loyaltyCardPost.setExpiryDate(null);

		LoyaltyCard loyaltyCardResponse = new LoyaltyCard();
		loyaltyCardResponse.setId(1);
		loyaltyCardResponse.setName("pasindu");
		loyaltyCardResponse.setNumber("12345678");
		loyaltyCardResponse.setPointBalance(10.0);
		loyaltyCardResponse.setIssuedDate(null);
		loyaltyCardResponse.setExpiryDate(null);
		loyaltyCardResponse.setCategory(null);

		// Convert LoyaltyCard object into String
		ObjectMapper mapper = new ObjectMapper();
		String jsonPost = mapper.writeValueAsString(loyaltyCardPost);
		String jsonResponse = mapper.writeValueAsString(loyaltyCardResponse);
		mockMvc.perform(
				MockMvcRequestBuilders.post("/loyalty/card").contentType(MediaType.APPLICATION_JSON).content(jsonPost))
				.andExpect(MockMvcResultMatchers.content().json(jsonResponse));

	}
}
