package com.example.backend.repository;
import com.example.backend.entity.BuyerAccountDetail;
import com.example.backend.entity.SellerSignup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BuyerAccountRepository  extends JpaRepository<BuyerAccountDetail,Integer> {
    BuyerAccountDetail findByEmail(String email);

    Optional<BuyerAccountDetail> deleteAllById(int id);
}
