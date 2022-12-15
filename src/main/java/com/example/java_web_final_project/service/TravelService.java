package com.example.java_web_final_project.service;

import com.example.java_web_final_project.entity.Travel;
import com.example.java_web_final_project.repository.TravelRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class TravelService {

    private final TravelRepository travelRepository;

    public TravelService(TravelRepository travelRepository) {
        this.travelRepository = travelRepository;
    }

    //Get all travel data
    public List<Travel> all() {
        return travelRepository.findAll();
    }

    //Add a new travel data
    public Travel addTravel(Travel travel) {
        travelRepository.save(travel);
        return travel;
    }

    public Travel deleteTravel(Integer id) {
        Optional<Travel> travel = travelRepository.findById(id);

        //Throw data if the id does not exist.
        if(!travel.isPresent()) {
            throw new IllegalStateException("The travel ID: " + id + " does not exist");
        }

        travelRepository.deleteById(id);

        //Return the deleted data
        return travel.get();
    }

    public Travel updateTravel(Integer id, Travel travel) {

        //Check if the travel id exists
        Travel updateTravel = travelRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "Travel ID: " + id + " does not exist."));

        //Save data
        travel.setId(updateTravel.getId());
        travelRepository.save(travel);

        return travel;
    }
}
