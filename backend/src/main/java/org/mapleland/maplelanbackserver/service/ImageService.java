package org.mapleland.maplelanbackserver.service;

import io.awspring.cloud.s3.ObjectMetadata;
import lombok.RequiredArgsConstructor;
import org.mapleland.maplelanbackserver.config.S3Config;
import org.mapleland.maplelanbackserver.dto.image.ImageFile;
import org.mapleland.maplelanbackserver.dto.response.ImageResponse;
import org.mapleland.maplelanbackserver.table.User;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.UUID;

import static net.dv8tion.jda.api.utils.MarkdownSanitizer.sanitize;

@RequiredArgsConstructor
@Service
public class ImageService {
    private final S3ImageService s3imageService;
    private final S3Client s3Client;         // S3
    private final S3Config config;           // 버킷 설정파일 건드리지마시오

    public String getS3ImageUrl(UserInformationService user, MultipartFile image) {
        validateSizeOfImage(image);
        validateSizeOfImage(image);

        String fileExtension = getFileExtension(Objects.requireNonNull(image.getOriginalFilename()));
        String fileName = String.format("%s_profile_%s.%s",
                sanitizeFileName(user.getUsername()),
                UUID.randomUUID().toString().substring(0, 8),
                fileExtension
        );

        try {
            PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                    .bucket(config.getBucket())
                    .key(fileName)
                    .contentType(image.getContentType())
                    .build();

            s3Client.putObject(putObjectRequest, RequestBody.fromBytes(image.getBytes()));

            return String.format("https://%s.s3.%s.amazonaws.com/%s", config.getBucket(), config.getRegion(), fileName);

        } catch (IOException e) {
            throw new RuntimeException("S3 업로드 실패", e);
        }
    }

    public void deleteImage(String originalUrl) {
        // 필요 시 구현
    }

    private void validateSizeOfImage(MultipartFile image) {
        if (image == null || image.isEmpty()) {
            throw new RuntimeException("이미지가 존재하지 않습니다.");
        }
    }

    private String getFileExtension(String filename) {
        return filename.substring(filename.lastIndexOf('.') + 1);
    }

    private String sanitizeFileName(String input) {
        return input.replaceAll("[^a-zA-Z0-9가-힣]", "_");
    }
}
