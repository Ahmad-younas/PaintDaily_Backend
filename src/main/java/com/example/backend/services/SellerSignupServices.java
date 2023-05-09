package com.example.backend.services;

import com.example.backend.entity.BuyerAccountDetail;
import com.example.backend.entity.SellerSignup;

import java.util.List;
import java.util.Optional;

public interface SellerSignupServices {

    String savesellerdetails(SellerSignup sellerSignup);
    SellerSignup SellerLogin(SellerSignup sellerSignup);

    List<SellerSignup> getAllSeller(SellerSignup sellerSignup);
    Optional<SellerSignup> getSellerByID(int id);

    List<SellerSignup> deleteById(int id);

    SellerSignup updateSetting(int id ,SellerSignup sellerSignup);
}
