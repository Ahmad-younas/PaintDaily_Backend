package com.example.backend.repository;

import com.example.backend.entity.ImageData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileDataRepository extends JpaRepository<ImageData, Integer> {


}
