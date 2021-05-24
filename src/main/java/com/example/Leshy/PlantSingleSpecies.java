package com.example.Leshy;

public class PlantSingleSpecies {
    private String name;
    private int wateringFrequencyDays;
    
    public PlantSingleSpecies() {
        this.name = "";
        this.wateringFrequencyDays = 0;
    }
    
    public PlantSingleSpecies(String name, int wateringFrequencyDays) throws IllegalArgumentException {
        this.name = name;

        setWateringFrequencyDays(wateringFrequencyDays);
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getWateringFrequencyDays() {
        return wateringFrequencyDays;
    }
    public void setWateringFrequencyDays(int wateringFrequencyDays) throws IllegalArgumentException {
        if (wateringFrequencyDays < 0){
            throw new IllegalArgumentException("wateringFrequencyDays must not be negative");
        }
        this.wateringFrequencyDays = wateringFrequencyDays;
    }

    @Override
    public String toString(){
        return String.format("Name: %s, Watering frequency: %d days", name, wateringFrequencyDays);
    }
    

}
