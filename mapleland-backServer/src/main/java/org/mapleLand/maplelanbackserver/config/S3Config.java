package org.mapleLand.maplelanbackserver.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
@Configuration

public class S3Config {

    @Value("${aws.accessKeyId}")
    private String accessKeyId;
    @Value("${aws.secretKey}")
    private String secretKey;
    @Value("${aws.s3.bucket}")
    private String bucket;
    @Value("${aws.region}")
    private String region;


    @Bean
    public S3Client s3Client() {
        AwsBasicCredentials awsBasicCredentials = AwsBasicCredentials.create(accessKeyId, secretKey);

        return S3Client.builder()
                .region(Region.AP_NORTHEAST_2)
                .credentialsProvider(StaticCredentialsProvider.create(awsBasicCredentials))
                .build();
    }

}
