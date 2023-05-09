package com.example.backend.entity;

import jakarta.persistence.*;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String productImage;
    private String productTitle;
    private String productQuantity;
    private int productPrice;
    private String sellerId;

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public Cart() {

    }
    public BuyerAccountDetail getBuyerAccountDetail() {
        return buyerAccountDetail;
    }

    public Cart(BuyerAccountDetail buyerAccountDetail) {
        this.buyerAccountDetail = buyerAccountDetail;
    }

    public void setBuyerAccountDetail(BuyerAccountDetail buyerAccountDetail) {
        this.buyerAccountDetail = buyerAccountDetail;
    }
    @OneToOne
//    @JoinColumn(name="buyer_id")
    private BuyerAccountDetail buyerAccountDetail;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(String productQuantity) {
        this.productQuantity = productQuantity;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

}
