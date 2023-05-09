package com.example.backend.services;

import com.example.backend.entity.BuyerAccountDetail;
import com.example.backend.entity.Cart;
import com.example.backend.entity.SellerSignup;
import com.example.backend.exception.ResourceNotFoundException;
import com.example.backend.repository.BuyerAccountRepository;
import com.example.backend.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BuyerDetailServicesImp implements BuyerDetailServices {

    @Autowired
    private BuyerAccountRepository buyerAccountRepository;
    @Autowired
    private CartRepository cartRepository;

    public BuyerDetailServicesImp(BuyerAccountRepository buyerAccountRepository) {
        this.buyerAccountRepository = buyerAccountRepository;
    }

    public BuyerAccountDetail savebuyerdetails(BuyerAccountDetail buyerAccountDetail) {
        BuyerAccountDetail buyerAccountDetail1 = buyerAccountRepository.save(buyerAccountDetail);
        return buyerAccountDetail1;
    }

    @Override
    public BuyerAccountDetail BuyerLogin(BuyerAccountDetail buyerAccountDetail) {
        String buyerEmail = buyerAccountDetail.getEmail();
        BuyerAccountDetail buyerAccountDetail1 = buyerAccountRepository.findByEmail(buyerEmail);
        return buyerAccountDetail1;
    }

    @Override
    public List<BuyerAccountDetail> getAllbuyer(BuyerAccountDetail buyerAccountDetail) {
        List<BuyerAccountDetail> remaningItem = buyerAccountRepository.findAll();
        return remaningItem;
    }

    @Transactional
    public List<BuyerAccountDetail> deleteBuyer(int id) {
        System.out.println("id"+id);
//        cartRepository.deleteById(id);
        buyerAccountRepository.deleteById(id);
        List<BuyerAccountDetail> remainingItems = buyerAccountRepository.findAll();
        return remainingItems;
    }

    @Override
    public BuyerAccountDetail updateSetting(int id, BuyerAccountDetail buyerAccountDetail) {

        BuyerAccountDetail buyerAccountDetail1 = buyerAccountRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Resourse Not Found With id"+id));
        buyerAccountDetail1.setAddress(buyerAccountDetail.getAddress());
        buyerAccountDetail1.setPassword(buyerAccountDetail.getPassword());
        BuyerAccountDetail buyerAccountDetail2 = buyerAccountRepository.save(buyerAccountDetail);
        return buyerAccountDetail2;
    }
}



