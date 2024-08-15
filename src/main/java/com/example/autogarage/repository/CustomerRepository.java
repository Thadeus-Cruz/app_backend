package com.example.autogarage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.autogarage.model.Customer;
import java.util.Optional;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @SuppressWarnings("null")
    Optional<Customer> findById(Long id);
    List<Customer> findByName(String name);
    Optional<Customer> findByEmail(String email);

    // New method for finding a customer by email and password
    Optional<Customer> findByEmailAndPassword(String email, String password);
}
