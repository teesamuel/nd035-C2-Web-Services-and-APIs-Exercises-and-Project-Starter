package com.udacity.pricing;

import com.udacity.pricing.domain.price.Price;
import com.udacity.pricing.mocks.ModelMockTest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.net.URI;
import java.net.URISyntaxException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureJsonTesters
@AutoConfigureMockMvc
public class PricingServiceApplicationTests {


	@Autowired
	private MockMvc mvc;

	@Autowired
	private JacksonTester<Price> json;

	@Test
	public void contextLoads() {
	}

	private static Price price ;

	@Before
	public   void fetchPrice(){
		price = ModelMockTest.getPrice();
	}

	@Test
	public void testGetPrice() throws Exception {

		mvc.perform(
						get(new URI("/prices/1"))
//								.content( json.write(price).getJson())
								.contentType(MediaType.APPLICATION_JSON_UTF8)
								.accept(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().is2xxSuccessful());
	}


	@Test
	public void testCreatePrice() throws Exception {

		mvc.perform(
						post(new URI("/prices"))
								.content( json.write(price).getJson())
								.contentType(MediaType.APPLICATION_JSON_UTF8)
								.accept(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isCreated());
	}

	@Test
	public void testUpdatePrice() throws Exception {
		price.setCurrency("CAD");
		mvc.perform(
						put(new URI("/prices/1"))
								.content( json.write(price).getJson())
								.contentType(MediaType.APPLICATION_JSON_UTF8)
								.accept(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().is2xxSuccessful());
	}

}
