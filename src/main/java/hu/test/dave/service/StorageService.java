package hu.test.dave.service;

import org.springframework.web.multipart.MultipartFile;

public interface StorageService {

    void store(MultipartFile file);

}
