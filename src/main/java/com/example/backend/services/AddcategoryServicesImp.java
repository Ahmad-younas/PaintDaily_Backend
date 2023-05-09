package com.example.backend.services;

import com.example.backend.entity.AddCategoris;
import com.example.backend.repository.AddcategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddcategoryServicesImp implements AddcategoryServices {

    @Autowired
    private AddcategoryRepository addcategoryRepository;

    @Override
    public List<AddCategoris> saveCatetory(AddCategoris addCategoris) {
         addcategoryRepository.save(addCategoris);
         List<AddCategoris> list = addcategoryRepository.findAll();
        return list;
    }

    @Override
    public List<AddCategoris> getCategories() {
        List<AddCategoris> list = addcategoryRepository.findAll();
        return list;
    }

    @Override
    public List<AddCategoris> deleteCategories(String id) {
        addcategoryRepository.deleteById(Integer.valueOf(id));
        List<AddCategoris> addCategoris = addcategoryRepository.findAll();
        return addCategoris;
    }
}
