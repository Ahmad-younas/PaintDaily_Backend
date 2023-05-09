package com.example.backend.services;

import com.example.backend.entity.Addproduct;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface AddproductServices {
    Addproduct saveProduct(Addproduct allproduct);
    List<Addproduct> getAllProducts(String id);

    Optional<Addproduct> getUserById(int id);

    Addproduct updateUserById(Addproduct addproduct);

    Addproduct deleteProduct(int id);

    Addproduct addProduct(Addproduct addproduct);

    List<Addproduct> getAllProducts();

    List<Addproduct> deleteProductId(String id);

    Addproduct StoreRating(String id, Addproduct addproduct);



}