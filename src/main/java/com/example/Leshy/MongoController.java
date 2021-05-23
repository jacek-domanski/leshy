package com.example.Leshy;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MongoController{

    @Autowired
    private PlantsSpeciesService plantsSpeciesService;

    @Autowired
    private Logger logger;

    @GetMapping("/hello")
    public String hello(
        @RequestParam(value = "c", defaultValue = "default c") String c, 
        @RequestParam(value = "d", defaultValue = "default d") String d){

        System.out.println("Hello was called!");
        logger.info("Hello was called!");

        return (new Hello(c, d)).toString();
    }

    @GetMapping("/plants")
    public List<PlantSingleSpecies> getPlantSpecies(){
        logger.info("Received GET all plants");
        return plantsSpeciesService.getAllSpecies();
    }

    @GetMapping("/plants/{name}")
    public PlantSingleSpecies getSingleSpecies(@PathVariable String name){
        logger.info("Received GET " + name + " plant");
        return plantsSpeciesService.getSingleSpecies(name);
    }

    @PostMapping("/plants")
    public void addPlant(@RequestBody PlantSingleSpecies singleSpecies){
        logger.info("Received POST plant: " + singleSpecies);
        plantsSpeciesService.add(singleSpecies);
    }

    @PutMapping("/plants")
    public void updatePlant(@RequestBody PlantSingleSpecies singleSpecies) {
        logger.info("Received PUT plant: " + singleSpecies);
        plantsSpeciesService.update(singleSpecies);
    }

    @DeleteMapping("/plants/{name}")
    public void deletePlant(@PathVariable String name) {
        logger.info("Received DELETE " + name + " plant");
        plantsSpeciesService.delete(name);
    }



}