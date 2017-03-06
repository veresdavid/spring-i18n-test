package hu.test.dave.controller;

import hu.test.dave.service.StorageService;
import hu.test.dave.validator.FileValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {

    @Autowired
    private StorageService storageService;

    private FileValidator fileValidator;

    public FileUploadController() {
        fileValidator = new FileValidator();
    }

    @RequestMapping(path = "/upload", method = RequestMethod.POST)
    public String uploadFile(@RequestParam("file") MultipartFile file) {

        if(fileValidator.isValid(file)) {

            storageService.store(file);

        }

        return "welcome";

    }

    @RequestMapping(path = "/upload", method = RequestMethod.GET)
    public String loadPage() {
        return "upload";
    }

}
