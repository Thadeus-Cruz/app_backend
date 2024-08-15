package com.example.autogarage.service;

import com.example.autogarage.model.Admin;
import com.example.autogarage.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public Optional<Admin> validateLogin(String email, String password) {
        return adminRepository.findByEmailAndPassword(email, password);
    }
}

