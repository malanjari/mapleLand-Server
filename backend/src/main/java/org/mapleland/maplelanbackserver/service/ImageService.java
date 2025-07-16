package org.mapleland.maplelanbackserver.service;

import lombok.RequiredArgsConstructor;
import org.mapleland.maplelanbackserver.dto.image.ImageFile;
import org.mapleland.maplelanbackserver.dto.response.ImageResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Service
public class ImageService {
    private final S3ImageService s3imageService;

    public ImageResponse save(MultipartFile image) {
        validateSizeOfImage(image);

        ImageFile imageFile = new ImageFile(image);
        String imageUrl = s3imageService.uploadImage(imageFile);

        return new ImageResponse(imageUrl);
    }

    public void deleteImage(String originalUrl) {
        s3imageService.deleteImage(originalUrl);
    }

    private void validateSizeOfImage(MultipartFile image) {
        if (image == null || image.isEmpty()) {
            throw new RuntimeException("이미지가 존재하지 않습니다.");
        }
    }
}
