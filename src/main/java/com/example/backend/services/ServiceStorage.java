package com.example.backend.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ServiceStorage {
     String uploadImage(String path, MultipartFile file) throws IOException;
}
