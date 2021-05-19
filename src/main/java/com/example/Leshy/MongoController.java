package com.example.Leshy;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MongoController{

    @GetMapping("/hello")
    public String hello(
        @RequestParam(value = "c", defaultValue = "default c") String c, 
        @RequestParam(value = "d", defaultValue = "default d") String d){
        
        System.out.println("I've been called!");

        return (new Hello(c, d)).toString();
    }

}