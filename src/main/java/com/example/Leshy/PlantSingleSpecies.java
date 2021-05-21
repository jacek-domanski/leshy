package com.example.Leshy;

public class PlantSingleSpecies {
    private String name;
    private int wateringFrequencyDays;
    
    public PlantSingleSpecies() {
    }
    
    public PlantSingleSpecies(String name, int wateringFrequencyDays) {
        this.name = name;
        this.wateringFrequencyDays = wateringFrequencyDays;
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
    public void setWateringFrequencyDays(int wateringFrequencyDays) {
        this.wateringFrequencyDays = wateringFrequencyDays;
    }

    @Override
    public String toString(){
        return String.format("Name: %s, Watering frequency: %s days", name, wateringFrequencyDays);
    }

    

}
