package com.example.backend.services;

import com.example.backend.entity.ImageData;
import com.example.backend.repository.FileDataRepository;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class StorageServicesImp implements ServiceStorage {
    private final FileDataRepository fileDataRepository;

    public StorageServicesImp(FileDataRepository fileDataRepository) {
        this.fileDataRepository = fileDataRepository;
    }

    @Override
    public String uploadImage(String path, MultipartFile file) throws IOException {
        //File name
        String name = file.getOriginalFilename();

        //Full path

        String filePath = path+ File.separator + name;
        String newPath = path.substring(26,32);
        String getFile =newPath+"/"+name;


//        String randomID = UUID.randomUUID().toString();
//       String fileName1 =  randomID.concat(name.substring(name.lastIndexOf(".")));

        //Create folder if not created

        File file1= new File(path);
        if(!file1.exists())
            file1.mkdir();

        //file copy

        Files.copy(file.getInputStream(), Paths.get(filePath));

        return getFile;
    }
}
