package com.example.autogarage.service;

import com.example.autogarage.model.Customer;
import com.example.autogarage.repository.CustomerRepository;
import java.util.ArrayList;
import java.util.Optional;

import javax.swing.JOptionPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
 public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    Optional<Customer> customerOpt = customerRepository.findByEmail(email);
    if (customerOpt.isEmpty()) {
        JOptionPane.showMessageDialog(null, "User not found with email: " + email, "Error", JOptionPane.ERROR_MESSAGE);
        return null; // You might want to handle this according to your logic.
    }
    
    Customer customer = customerOpt.get();
    return new org.springframework.security.core.userdetails.User(customer.getEmail(), customer.getPassword(),
            new ArrayList<>());
}
}
