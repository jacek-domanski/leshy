package com.example.Leshy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.util.ArrayList;
import java.util.List;;

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
		List<PlantSingleSpecies> plantSpecies = new ArrayList<PlantSingleSpecies>();
		plantSpecies.add(new PlantSingleSpecies("Zamioculcas Zamifolia", 7));
		plantSpecies.add(new PlantSingleSpecies("Nepenthes Blood Mary", 3));
		plantSpecies.add(new PlantSingleSpecies("Senecio Rowleyanus", 4));
		plantSpecies.add(new PlantSingleSpecies("Ivy", 5));

		ObjectMapper mapper = new ObjectMapper();
		String expected = mapper.writeValueAsString(plantSpecies);

		mvc.perform(get("/plants"))
			.andExpect(content().string(expected));
	}//TODO make it pass when all tests are executed

	@Test
	public void testGetSingleSpeciesExistingSpecies() throws Exception {
		String expected = "{\"name\":\"Ivy\",\"wateringFrequencyDays\":5}";
		mvc.perform(get("/plants/Ivy"))
			.andExpect(content().string(expected));
	}

	@Test
	public void testGetSingleSpeciesNonExistingSpecies() throws Exception {
		String expected = "{\"name\":\"\",\"wateringFrequencyDays\":0}";
		mvc.perform(get("/plants/Ivyyyy"))
			.andExpect(content().string(expected));
	}

	@Test
	public void testAddPlantValid() throws Exception {
		PlantSingleSpecies plant = new PlantSingleSpecies("Thangsgiving cactus", 6);
		ObjectMapper mapper = new ObjectMapper();
		String body = mapper.writeValueAsString(plant);

		RequestBuilder request = 
			MockMvcRequestBuilders.post("/plants")
			.content(body)
			.contentType(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON);

		mvc.perform(request)
			.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void testAddPlantInvalid() throws Exception {
		String plant = "dasdas";
		ObjectMapper mapper = new ObjectMapper();
		String body = mapper.writeValueAsString(plant);

		RequestBuilder request = 
			MockMvcRequestBuilders.post("/plants")
			.content(body)
			.contentType(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON);

		mvc.perform(request)
			.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}

	@Test
	public void testUpdatePlant() throws Exception {
		String response = mvc.perform(get("/plants"))
			.andReturn().
			getResponse().
			getContentAsString();

		List<PlantSingleSpecies> originalPlants =
			new ObjectMapper().readValue(
				response, 
				new TypeReference<ArrayList<PlantSingleSpecies>>(){});
			
		String name = originalPlants.get(0).getName();
		int wateringFrequency = originalPlants.get(0).getWateringFrequencyDays() + 1;
		PlantSingleSpecies expected = new PlantSingleSpecies(name, wateringFrequency);
		String updatedPlantJson = 
			new ObjectMapper().writeValueAsString(expected);
		RequestBuilder request = 
			MockMvcRequestBuilders.put("/plants")
			.content(updatedPlantJson)
			.contentType(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON);

		mvc.perform(request)
			.andExpect(MockMvcResultMatchers.status().isOk());

		response = mvc.perform(get("/plants"))
			.andReturn().
			getResponse().
			getContentAsString();
		
		List<PlantSingleSpecies> actualPlants =
		new ObjectMapper().readValue(
			response, 
			new TypeReference<ArrayList<PlantSingleSpecies>>(){});

		PlantSingleSpecies actual = actualPlants.get(0);

		assertEquals(expected, actual);
	}

	@Test
	public void testDeletePlant() throws Exception {

	}

}
