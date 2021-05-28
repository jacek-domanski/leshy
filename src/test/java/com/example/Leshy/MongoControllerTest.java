package com.example.Leshy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;;

@ExtendWith(SpringExtension.class)
@WebMvcTest(MongoController.class)
public class MongoControllerTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void testHelloEmpty() throws Exception {
		RequestBuilder request = 
			MockMvcRequestBuilders.get("/hello");
		MvcResult result = mvc.perform(request).andReturn();
		String expected = "Content: default c, Data: default d";
		String actual = result.getResponse().getContentAsString();

		assertEquals(expected, actual);
	}

	@Test
	public void testHelloWithC() throws Exception {
		RequestBuilder request = 
			MockMvcRequestBuilders.get("/hello?c=cc");
		MvcResult result = mvc.perform(request).andReturn();
		String expected = "Content: cc, Data: default d";
		String actual = result.getResponse().getContentAsString();

		assertEquals(expected, actual);
	}

	@Test
	public void testHelloWithD() throws Exception {
		String expected = "Content: default c, Data: dd";
		mvc.perform(MockMvcRequestBuilders.get("/hello?d=dd"))
			.andExpect(content().string(expected));
	}

	@Test
	public void testHelloWithCandD() throws Exception {
		String expected = "Content: cc, Data: dd";
		mvc.perform(get("/hello?c=cc&d=dd"))
			.andExpect(content().string(expected));
	}

	@Test
	public void testGetPlantSpecies() throws Exception {

	}

	@Test
	public void testGetSingleSpecies() throws Exception {

	}

	@Test
	public void testAddPlant() throws Exception {

	}

	@Test
	public void testUpdatePlant() throws Exception {

	}

	@Test
	public void testDeletePlant() throws Exception {

	}

}
