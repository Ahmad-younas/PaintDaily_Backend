package com.example.backend.repository;
import com.example.backend.entity.Addproduct;
import com.example.backend.entity.AllUserOrders;
import com.example.backend.entity.BuyerAccountDetail;
import com.example.backend.entity.TransactionDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserOrdersRepository extends JpaRepository<AllUserOrders,Integer> {

    AllUserOrders findByStatus(boolean status);

    @Query("SELECT u FROM AllUserOrders u WHERE u.buyerAccountId =:n ")
    public List<AllUserOrders> getProductByBuyerID(@Param("n") String buyerAccountId);
    @Query("SELECT u FROM AllUserOrders u WHERE u.status = true AND u.buyerAccountId =:n")
    public List<AllUserOrders> getProductByBuyerIDAndStatus(@Param("n") String buyerAccountId);

    @Query("SELECT u FROM AllUserOrders u WHERE u.sellerId =:n ")
    public List<AllUserOrders> getProductBySellerID(@Param("n") String sellerId);
    @Query("SELECT u FROM AllUserOrders u WHERE u.status = true AND u.sellerId =:n")
    public List<AllUserOrders> getProductBySellerIDAndStatus(@Param("n") String sellerId);

    @Query("delete  FROM AllUserOrders u WHERE u.buyerAccountId =:n")
    public List<AllUserOrders> deleteBuyerProductById(@Param("n") String sellerId);
    @Modifying
    @Query(value = "SELECT * FROM all_user_orders WHERE all_user_orders.status = false ", nativeQuery = true)
    public List<AllUserOrders> getUnApprovedProduct();
    @Modifying
    @Query(value = "SELECT * FROM all_user_orders WHERE all_user_orders.status = true ", nativeQuery = true)
    public List<AllUserOrders> getApprovedProduct();




}
