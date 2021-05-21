package com.example.Leshy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MongoController{

    @Autowired
    private PlantsSpeciesService plantsSpeciesService;

    @GetMapping("/hello")
    public String hello(
        @RequestParam() String c, 
        @RequestParam(value = "f", defaultValue = "default d") String d){

        System.out.println("I've been called!");

        return (new Hello(c, d)).toString();
    }

    @GetMapping("/getPlantSpecies")
    public List<PlantSingleSpecies> getPlantSpecies(){
        return plantsSpeciesService.getAllSpecies();
    }

    @PostMapping("/addPlant")
    public void addPlant(@RequestBody PlantSingleSpecies singleSpecies){
        System.out.println("addPlant called! Adding:");
        System.out.println(singleSpecies);

        plantsSpeciesService.add(singleSpecies);
    }



}