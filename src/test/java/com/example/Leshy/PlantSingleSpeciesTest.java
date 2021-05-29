package com.example.Leshy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlantSingleSpeciesTest {

	@Test
	public void testPlantSingleSpeciesEmpty() {
		PlantSingleSpecies plantSingleSpecies = new PlantSingleSpecies();

		String expectedName = "";
		String actualName = plantSingleSpecies.getName();
		assertEquals(expectedName, actualName);

		int expectedWateringFrequency = 0;
		int actualWateringFrequency = plantSingleSpecies.getWateringFrequencyDays();
		assertEquals(expectedWateringFrequency, actualWateringFrequency);
	}

	@Test
	public void testPlantSingleSpecies2params() {
		PlantSingleSpecies plantSingleSpecies = new PlantSingleSpecies("John", 7);

		String expectedName = "John";
		String actualName = plantSingleSpecies.getName();
		assertEquals(expectedName, actualName);

		int expectedWateringFrequency = 7;
		int actualWateringFrequency = plantSingleSpecies.getWateringFrequencyDays();
		assertEquals(expectedWateringFrequency, actualWateringFrequency);
	}

	@Test
	public void testPlantSingleSpecies2paramsThrowsException() {
		Assertions.assertThrows(
			IllegalArgumentException.class, 
			() -> new PlantSingleSpecies("John", -7));
	}

	@Test
	public void testGetName() throws Exception {
		PlantSingleSpecies plantSingleSpecies = new PlantSingleSpecies();
		String expected = "";
		String actual = plantSingleSpecies.getName();
		assertEquals(expected, actual);

		plantSingleSpecies = new PlantSingleSpecies("John", 5);
		expected = "John";
		actual = plantSingleSpecies.getName();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetName() throws Exception {
		PlantSingleSpecies plantSingleSpecies = new PlantSingleSpecies();
		plantSingleSpecies.setName("John");
		String expected = "John";
		String actual = plantSingleSpecies.getName();
		assertEquals(expected, actual);

		plantSingleSpecies.setName("");
		expected = "";
		actual = plantSingleSpecies.getName();
		assertEquals(expected, actual);
	}

	@Test
	public void testGetWateringFrequencyDays() throws Exception {
		PlantSingleSpecies plantSingleSpecies = new PlantSingleSpecies();
		String expected = "";
		String actual = plantSingleSpecies.getName();
		assertEquals(expected, actual);

		plantSingleSpecies = new PlantSingleSpecies("John", 5);
		expected = "John";
		actual = plantSingleSpecies.getName();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetWateringFrequencyDays() throws Exception {
		PlantSingleSpecies plantSingleSpecies = new PlantSingleSpecies();
		plantSingleSpecies.setWateringFrequencyDays(5);
		int expected = 5;
		int actual = plantSingleSpecies.getWateringFrequencyDays();
		assertEquals(expected, actual);

		plantSingleSpecies.setWateringFrequencyDays(0);
		expected = 0;
		actual = plantSingleSpecies.getWateringFrequencyDays();
		assertEquals(expected, actual);

		Assertions.assertThrows(
			IllegalArgumentException.class, 
			() -> plantSingleSpecies.setWateringFrequencyDays(-5));
	}

	@Test
	public void testToString() throws Exception {
		PlantSingleSpecies plantSingleSpecies = new PlantSingleSpecies();
		String expected = "Name: , Watering frequency: 0 days";
		String actual = plantSingleSpecies.toString();
		assertEquals(expected, actual);

		plantSingleSpecies = new PlantSingleSpecies("John", 5);
		expected = "Name: John, Watering frequency: 5 days";
		actual = plantSingleSpecies.toString();
		assertEquals(expected, actual);
	}

	@Test
	public void testEqualsValid() {
		boolean expected = true;
		PlantSingleSpecies plant1 = new PlantSingleSpecies("aa", 1);
		PlantSingleSpecies plant2 = new PlantSingleSpecies("aa", 1);
		boolean actual = plant1.equals(plant2);

		assertEquals(expected, actual);
	}

	@Test
	public void testEqualsValidSame() {
		boolean expected = true;
		PlantSingleSpecies plant1 = new PlantSingleSpecies("aa", 1);
		boolean actual = plant1.equals(plant1);

		assertEquals(expected, actual);
	}

	@Test
	public void testEqualsValidEmpty() {
		boolean expected = true;
		PlantSingleSpecies plant1 = new PlantSingleSpecies();
		PlantSingleSpecies plant2 = new PlantSingleSpecies();
		boolean actual = plant1.equals(plant2);

		assertEquals(expected, actual);
	}

	@Test
	public void testEqualsInvalid() {
		boolean expected = false;
		PlantSingleSpecies plant1 = new PlantSingleSpecies();
		PlantSingleSpecies plant2 = new PlantSingleSpecies("aa", 1);
		boolean actual = plant1.equals(plant2);

		assertEquals(expected, actual);
	}

	@Test
	public void testEqualsInvalid2() {
		boolean expected = false;
		PlantSingleSpecies plant1 = new PlantSingleSpecies("bb", 1);
		PlantSingleSpecies plant2 = new PlantSingleSpecies("aa", 1);
		boolean actual = plant1.equals(plant2);

		assertEquals(expected, actual);
	}

	@Test
	public void testEqualsInvalid3() {
		boolean expected = false;
		PlantSingleSpecies plant1 = new PlantSingleSpecies("aa", 2);
		PlantSingleSpecies plant2 = new PlantSingleSpecies("aa", 1);
		boolean actual = plant1.equals(plant2);

		assertEquals(expected, actual);
	}

	@Test
	public void testEqualsInvalid4() {
		boolean expected = false;
		PlantSingleSpecies plant1 = new PlantSingleSpecies("bb", 2);
		PlantSingleSpecies plant2 = new PlantSingleSpecies("aa", 1);
		boolean actual = plant1.equals(plant2);

		assertEquals(expected, actual);
	}
}
