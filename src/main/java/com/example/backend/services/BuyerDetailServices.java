package com.example.backend.services;

import com.example.backend.entity.BuyerAccountDetail;
import com.example.backend.entity.SellerSignup;

import java.util.List;

public interface BuyerDetailServices {

    BuyerAccountDetail savebuyerdetails(BuyerAccountDetail buyerAccountDetail);

    BuyerAccountDetail BuyerLogin(BuyerAccountDetail buyerAccountDetail);

    List<BuyerAccountDetail> getAllbuyer(BuyerAccountDetail buyerAccountDetail);
    List<BuyerAccountDetail> deleteBuyer(int id);

    BuyerAccountDetail updateSetting(int id, BuyerAccountDetail buyerAccountDetail);

}
