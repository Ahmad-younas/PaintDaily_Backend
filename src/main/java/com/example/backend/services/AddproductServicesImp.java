package com.example.backend.services;
import com.example.backend.entity.Addproduct;
import com.example.backend.entity.Reviews;
import com.example.backend.exception.ResourceNotFoundException;
import com.example.backend.repository.AddproductRepository;
import com.example.backend.repository.ReviewsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddproductServicesImp implements AddproductServices{

    private AddproductRepository addproductRepository;

    private ReviewsRepository reviewsRepository;

    public AddproductServicesImp(AddproductRepository addproductRepository) {
        this.addproductRepository = addproductRepository;
    }

    @Override
    public Addproduct saveProduct(Addproduct allproduct) {
        Addproduct allproduct2 = addproductRepository.save(allproduct);
        return allproduct2;
    }

    @Override
    public List<Addproduct> getAllProducts(String id) {
        return addproductRepository.getProductByBuyerID(id);
    }

    @Override
    public Optional<Addproduct> getUserById(int id) {
          Optional<Addproduct> addproduct3 =  addproductRepository.findById(id);
          return addproduct3;
    }

    @Override
    public Addproduct updateUserById(Addproduct addproduct) {
        int productId = addproduct.getId();
        Addproduct updateProduct = addproductRepository.findById(productId).get();
        updateProduct.setProductTitle(addproduct.getProductTitle());
        updateProduct.setDescription(addproduct.getDescription());
        updateProduct.setProductImage(addproduct.getProductImage());
        updateProduct.setProductColorImage(addproduct.getProductColorImage());
        updateProduct.setProductColorName(addproduct.getProductColorName());
        updateProduct.setSelectCategory(addproduct.getSelectCategory());
        updateProduct.setPrice(addproduct.getPrice());
        return addproductRepository.save(updateProduct);

    }

    @Override
    public Addproduct deleteProduct(int id) {
         addproductRepository.deleteById(id);
         return null;

    }

    @Override
    public Addproduct addProduct(Addproduct addproduct) {

        return addproductRepository.save(addproduct);
    }

    @Override
    public List<Addproduct> getAllProducts() {
        List<Addproduct> addproduct = addproductRepository.findAll();
        return addproduct;
    }

    @Override
    public List<Addproduct> deleteProductId(String id) {
        addproductRepository.deleteSellerProductById(id);
        return null;
    }

    @Override
    public Addproduct StoreRating(String id, Addproduct addproduct) {
        Addproduct addproduct1 = addproductRepository.findById(Integer.parseInt(id)).orElseThrow(()->new ResourceNotFoundException("Resourse Not Found With id"+id));
        String rating = addproduct1.getRating();
        String TotalRating = rating.concat(addproduct.getRating());
        addproduct1.setRating(TotalRating);
        String NewRating = addproduct1.getRating();
            int sum = 0;
            int Total= 0;
            int count=0;
            for (int i = 0; i < NewRating.length(); i++) {
                char c = NewRating.charAt(i);
                int num = Character.getNumericValue(c);
                sum += num;
                count++;
            }
            Total=sum/count;
            addproduct1.setTotalRating(String.valueOf(Total));
            Addproduct addproduct2 = addproductRepository.save(addproduct1);
            return addproduct2;
    }


}
