package com.example.backend.services;

import com.example.backend.entity.AllProduct;
import com.example.backend.repository.CheckOutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckOutServicesImp implements CheckOutServices{

    @Autowired
    private CheckOutRepository checkOutRepository;


    @Override
    public AllProduct addCheckout(AllProduct allProduct) {
        AllProduct allProduct1 = checkOutRepository.save(allProduct);
        return allProduct1;
    }
}
