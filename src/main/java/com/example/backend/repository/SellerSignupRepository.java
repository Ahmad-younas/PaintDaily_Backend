package com.example.backend.repository;
import com.example.backend.entity.SellerSignup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerSignupRepository  extends JpaRepository<SellerSignup,Integer> {
    SellerSignup findByEmail(String email);
}
