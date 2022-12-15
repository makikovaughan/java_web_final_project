package com.example.java_web_final_project.controller;

import com.example.java_web_final_project.entity.Travel;
import com.example.java_web_final_project.service.TravelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;

@RestController
@RequestMapping("/travels")
public class TravelController {

    private final TravelService travelService;

    public TravelController(TravelService travelService) {
        this.travelService = travelService;
    }


    //Get all travel data
    @CrossOrigin("http://localhost:8080/")
    @GetMapping
    public List<Travel> getTravel() {
        return travelService.all();
    }

    //Add a new travel data
    @CrossOrigin("http://localhost:8080/")
    @PostMapping
    public Travel addTravel(@RequestBody Travel travel) {
        return travelService.addTravel(travel);
    }

    //Delete a travel data
    @CrossOrigin("http://localhost:8080/")
    @DeleteMapping("/{id}")
    public Travel deleteTravel(@PathVariable Integer id){
        return travelService.deleteTravel(id);
    }

    //Update a travel data
    @CrossOrigin("http://localhost:8080/")
    @PutMapping("/{id}")
    public Travel updateTravel(@PathVariable Integer id,
                               @RequestBody Travel travel) {
        return travelService.updateTravel(id, travel);
    }
}
