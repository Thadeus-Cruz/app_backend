package com.example.autogarage.controller;

import com.example.autogarage.model.Admin;
import com.example.autogarage.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/admins")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    public ResponseEntity<Admin> login(@RequestBody Admin loginDetails) {
        Optional<Admin> admin = adminService.validateLogin(loginDetails.getEmail(), loginDetails.getPassword());
        return admin.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(401).build());
    }
}
