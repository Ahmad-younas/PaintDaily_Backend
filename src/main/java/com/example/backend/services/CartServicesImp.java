package com.example.backend.services;

import com.example.backend.entity.BuyerAccountDetail;
import com.example.backend.entity.Cart;
import com.example.backend.repository.BuyerAccountRepository;
import com.example.backend.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;



@Service
public class CartServicesImp implements CartServices{

    private CartRepository cartRepository;
    public CartServicesImp(CartRepository cartRepository){
            this.cartRepository = cartRepository;
    }

    @Autowired
    private BuyerAccountRepository buyerAccountRepository;

    @Override
    public Cart addtoCart(Cart addtocart, int buyerAccountId) {

         Optional<BuyerAccountDetail> buyerAccountDetail = buyerAccountRepository.findById(buyerAccountId);
         addtocart.setBuyerAccountDetail(buyerAccountDetail.get());
        Cart cart = cartRepository.save(addtocart);
        return cart;
    }

    @Override
    public List<Cart> getAllCart(int buyerCartId) {
        BuyerAccountDetail buyerAccountDetail = new BuyerAccountDetail();
        buyerAccountDetail.setId(buyerCartId);
        return cartRepository.findAllByBuyerAccountDetail(buyerAccountDetail);
    }

    @Override
    public List<Cart> deleteProduct(int id) {
        cartRepository.deleteById(id);
        List<Cart> remainingItems = cartRepository.findAll();
        return remainingItems;
    }

    @Override
    @Transactional
    public List<Cart> deleteCartById(int id) {
        BuyerAccountDetail buyerAccountDetail = new BuyerAccountDetail();
        buyerAccountDetail.setId(id);
        cartRepository.deleteAllByBuyerAccountDetailId(id);
        return null;
    }

//    @Override
//    public Cart deletecart(Cart cart) {
//
//        cartRepository.deleteAllByBuyerAccountDetailId(cart);
//        return null;
//    }
}
