package com.example.backend.repository;

import com.example.backend.entity.AllUserOrders;
import com.example.backend.entity.TransactionDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransactionDetailRepository extends JpaRepository<TransactionDetail,Integer> {

    @Query("SELECT u FROM TransactionDetail u WHERE u.status =:n ")
    public List<TransactionDetail> getProductByStatus(@Param("n") Boolean status);
}
