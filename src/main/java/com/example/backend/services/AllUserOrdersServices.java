package com.example.backend.services;


import com.example.backend.entity.AllUserOrders;

import java.util.List;
import java.util.Optional;

public interface AllUserOrdersServices {
    List<AllUserOrders> getalluserorderdata();
    Optional<AllUserOrders> getalluserorderdatadetail(int id);

    List<AllUserOrders> alluserorderdatadetailStatus(int id);
    List<AllUserOrders> getBuyerProduct(String id);
    List<AllUserOrders> getBuyerProductByStatus(String id);
    List<AllUserOrders> getsellerProduct(String id);
    List<AllUserOrders> getSellerProductByStatus(String id);

    List<AllUserOrders> deleteProductById(int id);
    List<AllUserOrders> completedOrder();

}
