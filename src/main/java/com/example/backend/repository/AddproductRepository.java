package com.example.backend.repository;

import com.example.backend.entity.Addproduct;
import com.example.backend.entity.AllUserOrders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AddproductRepository extends JpaRepository<Addproduct,Integer> {
    @Query("SELECT u FROM Addproduct u WHERE  u.sellerId=:n")
    public List<Addproduct> getProductByBuyerID(@Param("n") String buyerAccountId);
    @Query("DELETE  FROM Addproduct u  WHERE  u.sellerSignupId=:n")
    public List<Addproduct> deleteSellerProductById(@Param("n") String buyerAccountId);
    @Modifying
    @Query(value = "SELECT * FROM add_product p LEFT JOIN reviews r ON p.id = r.product_id; ", nativeQuery = true)
    public List<Addproduct> getBothTabledata();

}
