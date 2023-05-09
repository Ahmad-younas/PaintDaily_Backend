package com.example.backend.repository;

import com.example.backend.entity.Admin;
import com.example.backend.entity.SellerSignup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
    Admin findByEmail(String email);
}
