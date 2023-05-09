package com.example.backend.services;


import com.example.backend.entity.AllUserOrders;
import com.example.backend.repository.UserOrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AllUserOrdersServicesImp implements AllUserOrdersServices{

    @Autowired
    private UserOrdersRepository userOrdersRepository;

    @Override
    public List<AllUserOrders> getalluserorderdata() {
        List<AllUserOrders> allUserOrders1=  userOrdersRepository.getUnApprovedProduct();
        return allUserOrders1;
    }

    @Override
    public Optional<AllUserOrders> getalluserorderdatadetail(int id) {
        Optional<AllUserOrders> allUserOrders1=  userOrdersRepository.findById(id);
        return allUserOrders1;
    }

    @Override
    public List<AllUserOrders> alluserorderdatadetailStatus(int id) {
        AllUserOrders allUserOrders = new AllUserOrders();
        Optional<AllUserOrders> allUserOrders1 =  userOrdersRepository.findById(id);
        allUserOrders1.get().setStatus(true);
        userOrdersRepository.save(allUserOrders1.get());
       List<AllUserOrders> allUserOrders2 = userOrdersRepository.getUnApprovedProduct();

      //  Optional<AllUserOrders> allUserOrders4 = Optional.ofNullable(userOrdersRepository.findByStatus(allUserOrders1.get().isStatus()));
        return allUserOrders2;
    }

    @Override
    public List<AllUserOrders> getBuyerProduct(String id) {
    List<AllUserOrders> allUserOrders =    userOrdersRepository.getProductByBuyerID(id);
        return allUserOrders;
    }

    @Override
    public List<AllUserOrders> getBuyerProductByStatus(String id) {
        List<AllUserOrders> allUserOrders = userOrdersRepository.getProductByBuyerIDAndStatus(id);
        return allUserOrders;
    }

    @Override
    public List<AllUserOrders> getsellerProduct(String id) {
        List<AllUserOrders> allUserOrders = userOrdersRepository.getProductBySellerID(id);
        return allUserOrders;
    }

    @Override
    public List<AllUserOrders> getSellerProductByStatus(String id) {
        List<AllUserOrders> allUserOrders = userOrdersRepository.getProductBySellerIDAndStatus(id);
        return allUserOrders;
    }

    @Override
    public List<AllUserOrders> deleteProductById(int id) {
        userOrdersRepository.deleteBuyerProductById(Integer.toString(id));
        return null;
    }

    @Override
    public List<AllUserOrders> completedOrder() {
     List<AllUserOrders> allUserOrders  = userOrdersRepository.getApprovedProduct();
     return allUserOrders;
    }
}
