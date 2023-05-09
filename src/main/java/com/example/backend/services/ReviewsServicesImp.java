package com.example.backend.services;


import com.example.backend.entity.Addproduct;
import com.example.backend.entity.Reviews;
import com.example.backend.repository.AddproductRepository;
import com.example.backend.repository.ReviewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewsServicesImp implements ReviewsServices{

    @Autowired
    private ReviewsRepository reviewsRepository;

    @Autowired
    private AddproductRepository addproductRepository;

    @Override
    public Reviews postReviews(Reviews reviews) {

//        int id = reviews.getId();
        Reviews reviews1 = reviewsRepository.save(reviews);
//     Optional<Addproduct> addproduct =   addproductRepository.findById(id);
//    String rating= addproduct.get().getRating();
//    rating = rating+ reviews.getRating();
//    addproduct.get().setRating(rating);
//    Addproduct addproduct1= addproductRepository.save(addproduct);
        return reviews1;
    }

    @Override
    public List<Reviews> getReviews() {
      List<Reviews> reviews = reviewsRepository.findAll();
      return reviews;
    }

    @Override
    public List<Reviews> GetReviewsById(String id) {
        List<Reviews>  reviews =  reviewsRepository.GetReviewsById(id);
        return reviews;
    }


}
