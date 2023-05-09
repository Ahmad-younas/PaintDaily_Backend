package com.example.backend.services;

import com.example.backend.entity.Cart;

import java.util.List;
import java.util.Optional;

public interface CartServices {

    Cart addtoCart(Cart addtocart, int buyerAccountId);
    List<Cart> getAllCart(int buyerCartId);
    List<Cart> deleteProduct(int id);
    List<Cart> deleteCartById(int id);
}
