package com.example.Leshy;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PlantsSpeciesService {
    private List<PlantSingleSpecies> plantSpecies;

    public PlantsSpeciesService() {
        this.plantSpecies = new ArrayList<PlantSingleSpecies>();

        this.plantSpecies.add(new PlantSingleSpecies("Zamioculcas Zamifolia", 7));
        this.plantSpecies.add(new PlantSingleSpecies("Nepenthes Blood Mary", 3));
        this.plantSpecies.add(new PlantSingleSpecies("Senecio Rowleyanus", 4));
    }

    public void add(PlantSingleSpecies singleSpecies){
        this.plantSpecies.add(singleSpecies);
    }

    public List<PlantSingleSpecies> getAllSpecies(){
        return this.plantSpecies;
    }

    public PlantSingleSpecies getSingleSpecies(String name){
        for (PlantSingleSpecies singleSpecies : plantSpecies){
            if (singleSpecies.getName() == name) {
                return singleSpecies;
            }
        }

        return new PlantSingleSpecies();
    }
    
}
