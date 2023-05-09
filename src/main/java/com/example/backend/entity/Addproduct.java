package com.example.backend.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name="addProduct")
public class Addproduct {
    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;
    private String ProductTitle;

    @Column(columnDefinition = "varchar(255) default '0'")
    private String rating;
    private String TotalRating;

    public String getTotalRating() {
        return TotalRating;
    }

    public void setTotalRating(String totalRating) {
        TotalRating = totalRating;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getProductWeight() {
        return productWeight;
    }

    public void setProductWeight(String productWeight) {
        this.productWeight = productWeight;
    }

    private String productWeight;
    private String SelectCategory;
    private String ProductColorName;
    private String ProductImage;
    private String ProductColorImage;
    private String sellerId;
    private String sellerSignupId;

    public String getSellerSignupId() {
        return sellerSignupId;
    }

    public void setSellerSignupId(String sellerSignupId) {
        this.sellerSignupId = sellerSignupId;
    }

    public String getSellerId() {
        return sellerId;
    }


    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    private String Price;

    @Column(length = 1000)
    private String Description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductTitle() {
        return ProductTitle;
    }

    public void setProductTitle(String productTitle) {
        ProductTitle = productTitle;
    }

    public String getSelectCategory() {
        return SelectCategory;
    }

    public void setSelectCategory(String selectCategory) {
        SelectCategory = selectCategory;
    }

    public String getProductColorName() {
        return ProductColorName;
    }

    public void setProductColorName(String productColorName) {
        ProductColorName = productColorName;
    }

    public String getProductImage() {
        return ProductImage;
    }

    public void setProductImage(String productImage) {
        ProductImage = productImage;
    }

    public String getProductColorImage() {
        return ProductColorImage;
    }

    public void setProductColorImage(String productColorImage) {
        ProductColorImage = productColorImage;
    }

}
