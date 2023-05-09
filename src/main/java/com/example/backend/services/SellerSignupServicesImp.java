package com.example.backend.services;
import com.example.backend.entity.SellerSignup;
import com.example.backend.exception.ResourceNotFoundException;
import com.example.backend.repository.SellerSignupRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class SellerSignupServicesImp implements SellerSignupServices {

    private SellerSignupRepository sellerSignupRepository;


    public SellerSignupServicesImp(SellerSignupRepository sellerSignupRepository) {
        this.sellerSignupRepository = sellerSignupRepository;
    }

    public String savesellerdetails(SellerSignup sellerSignup) {
        SellerSignup sellerSignup1 = sellerSignupRepository.findByEmail(sellerSignup.getEmail());
        if(sellerSignup1==null){
            sellerSignupRepository.save(sellerSignup);
            return sellerSignup.getUsername() + "Saved";
        }else{
            System.out.println("User already Exists");
            return "User already Exists";
        }
    }

    @Override
    public SellerSignup SellerLogin(SellerSignup sellerSignup) {
        SellerSignup sellerSignup1 = sellerSignupRepository.findByEmail(sellerSignup.getEmail());
        if(sellerSignup1==null){
            return sellerSignup1;
        }else{
            System.out.println("User already Exists");
//            Map<String, String> response = new HashMap<>();
//            response.put("CheckSellerId",String.valueOf(sellerSignup1.getCheckSellerId()));
//            response.put("SellerId",sellerSignup1.getSellerId());
//            response.put("Password",sellerSignup1.getPassword());
//            response.put("Address",sellerSignup1.getAddress());
            return sellerSignup1;
        }

    }

    @Override
    public List<SellerSignup> getAllSeller(SellerSignup sellerSignup) {
        List<SellerSignup> remaningItem = sellerSignupRepository.findAll();
        return remaningItem;
    }

    @Override
    public Optional<SellerSignup> getSellerByID(int id) {
       Optional<SellerSignup> list= sellerSignupRepository.findById(id);
       return list;
    }

    @Override
    public List<SellerSignup> deleteById(int id) {
        sellerSignupRepository.deleteById(id);
        List<SellerSignup> list = sellerSignupRepository.findAll();
        return list;
    }

    @Override
    public SellerSignup updateSetting(int id ,SellerSignup sellerSignup) {

     SellerSignup sellerSignup1=   sellerSignupRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Resourse Not Found With id"+id));
     sellerSignup1.setPassword(sellerSignup.getPassword());
     sellerSignup1.setAddress(sellerSignup.getAddress());
     SellerSignup sellerSignup2 = sellerSignupRepository.save(sellerSignup1);
        return sellerSignup2;
    }


}



