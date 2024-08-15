package com.example.autogarage.service;
import com.example.autogarage.model.Garage;
import com.example.autogarage.repository.GarageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GarageService {

    @Autowired
    private GarageRepository garageRepository;

    public List<Garage> getAllGarages() {
        return garageRepository.findAll();
    }

    public Optional<Garage> getGarageById(Long id) {
        return garageRepository.findById(id);
    }

    public Garage saveGarage(Garage garage) {
        return garageRepository.save(garage);
    }

    public void deleteGarage(Long id) {
        garageRepository.deleteById(id);
    }

    public Garage updateGarage(Long id, Garage garageDetails) {
        Garage garage = garageRepository.findById(id).orElse(null);
        if (garage != null) {
            garage.setName(garageDetails.getName());
            garage.setRating(garageDetails.getRating());
            return garageRepository.save(garage);
        }
        return null;
    }
}
