package com.example.autogarage.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.autogarage.model.Garage;

@Repository
public interface GarageRepository extends JpaRepository<Garage, Long> {
}
