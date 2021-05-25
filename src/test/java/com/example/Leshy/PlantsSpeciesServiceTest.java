package com.example.Leshy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class PlantsSpeciesServiceTest {

	@Mock
	private ArrayList<PlantSingleSpecies> mockPlants;

	@Test
	public void testPlantsSpeciesService() throws Exception {
		PlantsSpeciesService plantsSpeciesService = new PlantsSpeciesService();
		assertNotNull(plantsSpeciesService);
	}

	@Test
	public void testGetAllSpecies() throws Exception {
		PlantsSpeciesService plantsSpeciesService = new PlantsSpeciesService();
		int expected = 4;
		int actual = plantsSpeciesService.getAllSpecies().size();

		assertEquals(expected, actual);

		plantsSpeciesService.add(new PlantSingleSpecies("aa", 5));
		expected = 5;
		actual = plantsSpeciesService.getAllSpecies().size();

		assertEquals(expected, actual);
	}

	@Test
	public void testGetSingleSpecies() throws Exception {
		PlantsSpeciesService plantsSpeciesService = new PlantsSpeciesService();
		String expectedName = "Ivy";
		PlantSingleSpecies actual = plantsSpeciesService.getSingleSpecies(expectedName);
		String actualName = actual.getName();

		assertNotNull(actual);
		assertEquals(expectedName, actualName);

		expectedName = "";
		actual = plantsSpeciesService.getSingleSpecies("aaaaaaaa");
		actualName = actual.getName();

		assertNotNull(actual);
		assertEquals(expectedName, actualName);
	}

	@Test
	public void testAdd() throws Exception {
		PlantsSpeciesService plantsSpeciesService = new PlantsSpeciesService();
		int expected = plantsSpeciesService.getAllSpecies().size() + 1;
		plantsSpeciesService.add(new PlantSingleSpecies("aa", 5));
		int actual = plantsSpeciesService.getAllSpecies().size();

		assertEquals(expected, actual);
	}

	@Test
	public void testDelete() throws Exception {
		PlantsSpeciesService plantsSpeciesService = new PlantsSpeciesService();
		int expected = plantsSpeciesService.getAllSpecies().size() - 1;
		plantsSpeciesService.delete("Ivy");
		int actual = plantsSpeciesService.getAllSpecies().size();

		assertEquals(expected, actual);

		expected = plantsSpeciesService.getAllSpecies().size();
		plantsSpeciesService.delete("aaaaaaaaaaaaa");
		actual = plantsSpeciesService.getAllSpecies().size();

		assertEquals(expected, actual);
	}

	@Test
	public void testUpdate() throws Exception {
		PlantsSpeciesService plantsSpeciesService = new PlantsSpeciesService();
		int expected = plantsSpeciesService.getSingleSpecies("Ivy").getWateringFrequencyDays() + 1;
		plantsSpeciesService.update(new PlantSingleSpecies("Ivy", expected));
		int actual = plantsSpeciesService.getSingleSpecies("Ivy").getWateringFrequencyDays();

		assertEquals(expected, actual);
	}

}
