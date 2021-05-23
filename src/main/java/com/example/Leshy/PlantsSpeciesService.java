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
        this.plantSpecies.add(new PlantSingleSpecies("Ivy", 5));
    }

    public List<PlantSingleSpecies> getAllSpecies(){
        return this.plantSpecies;
    }

    public PlantSingleSpecies getSingleSpecies(String name){
        try {
            return 
                plantSpecies
                    .stream()
                    .filter(p -> p.getName().equals(name))
                    .findFirst()
                    .get();
        } catch (Exception e){
            return new PlantSingleSpecies();
        }
    }

    public void add(PlantSingleSpecies singleSpecies){
        this.plantSpecies.add(singleSpecies);
    }

    public void delete(String name){
        plantSpecies.removeIf(p -> p.getName().equals(name));
    }

    public void update(PlantSingleSpecies singleSpecies) {
        
        for (int i=0; i<plantSpecies.size(); i++) {
            if (plantSpecies.get(i).getName().equals(singleSpecies.getName())) {
                plantSpecies.set(i, singleSpecies);
                return;
            }
        }

    }


    
}
