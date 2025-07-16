package org.mapleland.maplelanbackserver.dto.image;

import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Getter
public class ImageFile {
    private final MultipartFile file;
    private final String uniqueName;

    private static final List<String> ALLOWED_IMAGE_TYPES = Arrays.asList("image/jpeg", "image/png");

    public ImageFile(MultipartFile file) {
        validateNullImage(file);
        validateImageType(file);
        this.file = file;
        this.uniqueName = createUniqueName(file);
    }

    private void validateNullImage(MultipartFile file) {
        if (file.isEmpty()) {
            throw new RuntimeException("이미지가 존재하지 않습니다.");
        }
    }

    private void validateImageType(MultipartFile file) {
        String contentType = file.getContentType();
        if (contentType == null || !ALLOWED_IMAGE_TYPES.contains(contentType)) {
            throw new RuntimeException("허용되지 않는 이미지 형식입니다. JPG 또는 PNG 파일만 업로드할 수 있습니다.");
        }
    }

    private String createUniqueName(MultipartFile image) {
        String originalFilename = image.getOriginalFilename();
        return UUID.randomUUID().toString() + "_" + originalFilename;
    }

    public String getContentType() {
        return this.file.getContentType();
    }

    public long getSize() {
        return this.file.getSize();
    }

    public InputStream getInputStream() throws IOException {
        return this.file.getInputStream();
    }
}
