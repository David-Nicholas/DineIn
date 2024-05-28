package com.ic.dinin.infrastructure.images.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public class AwsS3ImageHandlingService implements ImageService {

    @Override
    public String upload(MultipartFile file) {
        return null;
    }

    @Override
    public ResponseEntity<byte[]> retrieve(String imageName) {
        return ResponseEntity.notFound().build();
    }
}
