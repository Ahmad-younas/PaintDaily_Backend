package com.example.backend.services;

import com.example.backend.entity.AllProduct;
import com.example.backend.entity.Reviews;

import java.util.List;
import java.util.Optional;

public interface ReviewsServices {
    Reviews postReviews(Reviews reviews);
    List<Reviews> getReviews();

    List<Reviews> GetReviewsById(String id);
}
