package com.example.autogarage.controller;
import com.example.autogarage.model.Garage;
import com.example.autogarage.service.GarageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/garages")
public class GarageController {

    @Autowired
    private GarageService garageService;
    
    @GetMapping
    public List<Garage> getAllGarages() {
        return garageService.getAllGarages();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Garage> getGarageById(@PathVariable Long id) {
        Optional<Garage> garage = garageService.getGarageById(id);
        return garage.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public Garage createGarage(@RequestBody Garage garage) {
        return garageService.saveGarage(garage);
    }
    
    @DeleteMapping("/{id}")
    public void deleteGarage(@PathVariable Long id) {
        garageService.deleteGarage(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Garage> updateGarage(@PathVariable Long id, @RequestBody Garage garageDetails) {
        Garage updatedGarage = garageService.updateGarage(id, garageDetails);
        if (updatedGarage != null) {
            return ResponseEntity.ok(updatedGarage);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
