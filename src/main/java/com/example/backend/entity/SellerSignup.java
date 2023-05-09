package com.example.backend.entity;
import jakarta.persistence.*;

@Entity
public class SellerSignup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;
    private String phoneNumber;
    private String email;
    private String username;
    private String password;
    private String address;
    private String sellerAccountId;

    private int checkSellerId;

    public int getCheckSellerId() {
        return checkSellerId;
    }

    public void setCheckSellerId(int checkSellerId) {
        this.checkSellerId = checkSellerId;
    }

    public String getSellerAccountId() {
        return sellerAccountId;
    }

    public void setSellerAccountId(String sellerAccountId) {
        this.sellerAccountId = sellerAccountId;
    }

    public String getSellerId() {
        return SellerId;
    }

    public void setSellerId(String sellerId) {
        SellerId = sellerId;
    }

    private String SellerId;

//    @OneToMany(targetEntity = Addproduct.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "cp_fk",referencedColumnName = "id")

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    private String profilePic;
}
