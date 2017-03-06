package hu.test.dave.service;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
@PropertySource("classpath:application.properties")
public class FileSystemStorageService implements StorageService {

    @Value("${file.upload.folder}")
    public String fileUploadFolderName;

    @Override
    public void store(MultipartFile file) {

        try {
            String newFileName = UUID.randomUUID().toString() + "." + FilenameUtils.getExtension(file.getOriginalFilename());
            Files.copy(file.getInputStream(), Paths.get(fileUploadFolderName).resolve(newFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
