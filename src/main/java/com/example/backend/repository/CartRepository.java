package com.example.backend.repository;

import com.example.backend.entity.BuyerAccountDetail;
import com.example.backend.entity.Cart;
import com.example.backend.entity.TransactionDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart,Integer> {

    List<Cart> findAllByBuyerAccountDetail(BuyerAccountDetail buyerAccountDetail);
    @Modifying
    @Query(value = "delete  FROM cart  WHERE buyer_account_detail_id =:n ",nativeQuery = true)
    void deleteAllByBuyerAccountDetailId(@Param("n") int buyerAccountDetail);
//    void deleteAllByBuyerAccountDetail(BuyerAccountDetail buyerAccountDetail);





}
