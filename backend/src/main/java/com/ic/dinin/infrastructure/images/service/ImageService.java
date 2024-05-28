package com.ic.dinin.infrastructure.images.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

    String upload(MultipartFile file);

    ResponseEntity<byte[]> retrieve(String imageName);
}
