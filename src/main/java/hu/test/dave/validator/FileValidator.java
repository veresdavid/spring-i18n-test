package hu.test.dave.validator;

import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileValidator {

    private static final Long MAX_FILE_SIZE = 69 * 1024L;
    private static final String FILE_EXTENSION = "txt";

    public boolean isValid(MultipartFile file) {

        if (file.isEmpty()) return false;

        if (file.getSize() > MAX_FILE_SIZE) return false;

        if (!FilenameUtils.isExtension(file.getOriginalFilename(), FILE_EXTENSION)) return false;

        return true;

    }

}
