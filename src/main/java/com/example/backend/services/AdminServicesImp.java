package com.example.backend.services;

import com.example.backend.entity.Admin;
import com.example.backend.entity.SellerSignup;
import com.example.backend.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServicesImp implements AdminServices {

    @Autowired
    private  AdminRepository adminRepository;

    @Override
    public Admin Validate(Admin admin) {
        Admin admin1 = adminRepository.findByEmail(admin.getEmail());
        if(admin1==null){
            return admin1;
        }else{
            System.out.println("User already Exists");
//            Map<String, String> response = new HashMap<>();
//            response.put("CheckSellerId",String.valueOf(sellerSignup1.getCheckSellerId()));
//            response.put("SellerId",sellerSignup1.getSellerId());
//            response.put("Password",sellerSignup1.getPassword());
//            response.put("Address",sellerSignup1.getAddress());
            return admin1;
        }
    }
}
