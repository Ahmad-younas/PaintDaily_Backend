package com.example.backend.services;

import com.example.backend.entity.AddCategoris;

import java.util.List;

public interface AddcategoryServices {
    List<AddCategoris> saveCatetory(AddCategoris addCategoris);
    List<AddCategoris> getCategories();
    List<AddCategoris> deleteCategories(String id);
}
