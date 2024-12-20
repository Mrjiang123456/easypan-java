//package com.easypan.service.impl;
//
//import io.minio.*;
//import io.minio.http.Method;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import java.io.InputStream;
//
//@Service
//public class MinioService {
//    private final MinioClient minioClient;
//    private final String bucketName;
//    @Autowired
//    public MinioService(MinioClient minioClient,
//                        @Value("${minio.bucketName}") String bucketName) {
//        this.minioClient = minioClient;
//        this.bucketName = bucketName;
//    }
//    // 上传
//    public String uploadFile(String objectName, InputStream stream, String contentType) throws Exception {
//        boolean isExist = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
//        if (!isExist) {
//            minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
//        }
//        // 保存图片
//        minioClient.putObject(PutObjectArgs.builder()
//                .bucket(bucketName)
//                .object(objectName)
//                .stream(stream, -1, 10485760)
//                .contentType(contentType)
//                .build());
//        // 返回 URL 地址
//        return minioClient.getPresignedObjectUrl(GetPresignedObjectUrlArgs.builder()
//                .bucket(bucketName)
//                .object(objectName)
//                .method(Method.GET)
//                .build());
//    }
//    // 下载
//    public InputStream downloadFile(String objectName) throws Exception {
//        return minioClient.getObject(GetObjectArgs.builder()
//                .bucket(bucketName)
//                .object(objectName)
//                .build());
//    }
//}
