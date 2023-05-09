package com.example.backend.repository;

import com.example.backend.entity.Addproduct;
import com.example.backend.entity.Reviews;
import com.example.backend.entity.TransactionDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewsRepository extends JpaRepository<Reviews,Integer> {
    @Query("SELECT u FROM Reviews u WHERE  u.product_id=:n")
    public List<Reviews> GetReviewsById(@Param("n") String product_id);
}
