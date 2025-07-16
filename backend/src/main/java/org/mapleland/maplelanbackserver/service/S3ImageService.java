package org.mapleland.maplelanbackserver.service;

import io.awspring.cloud.s3.ObjectMetadata;
import io.awspring.cloud.s3.S3Resource;
import io.awspring.cloud.s3.S3Template;
import lombok.RequiredArgsConstructor;
import org.mapleland.maplelanbackserver.dto.image.ImageFile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

@RequiredArgsConstructor
@Service
public class S3ImageService {

    private final S3Template s3Template;

    @Value("${spring.cloud.aws.s3.bucket}")
    private String bucket;

    public String uploadImage(ImageFile imageFile) {
        final String path = imageFile.getUniqueName();

        try (final InputStream inputStream = imageFile.getInputStream()) {
            // contentType 등은 ObjectMetadataBuilder로 지정 가능
            S3Resource upload = s3Template.upload(
                    bucket,
                    path,
                    inputStream,
                    ObjectMetadata.builder()
                            .contentType(imageFile.getContentType())
                            .contentLength(imageFile.getSize())
                            .build()
            );

            return upload.getURL().toString();
        } catch (IOException | RuntimeException e) {
            throw new RuntimeException("이미지 업로드에 실패했습니다. " + e.getMessage());
        }
    }

    public void deleteImage(String imageUrl) {
        if (imageUrl == null || imageUrl.isEmpty()) {
            return;
        }
        try {
            new URL(imageUrl); // 유효성 체크

            String targetName = imageUrl.substring(imageUrl.lastIndexOf("/") + 1);

            s3Template.deleteObject(bucket, targetName);
        } catch (MalformedURLException e) {
            throw new RuntimeException("잘못된 이미지 URL 입니다.");
        } catch (RuntimeException e) {
            throw new RuntimeException("이미지 삭제에 실패했습니다. " + e.getMessage());
        }
    }

}
