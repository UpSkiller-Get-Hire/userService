package org.UPSkiller.Service;

import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class UserCvService {

    private final MinioClient minioClient;

    @Value("${minio.bucket}")
    private String bucket;

    public String uploadCv(String userId, MultipartFile file) throws Exception {
        if (file.isEmpty()){
            throw new RuntimeException("File is empty");
        }

        if(!file.getContentType().equals("application/pdf")){
            throw new RuntimeException("Only pdf are allowed");
        }

        if(file.getSize() > 5*1024*1024){
            throw new RuntimeException("File size must be less than 5MB");
        }

        String filename = userId+"_"+System.currentTimeMillis()+".pdf";

        minioClient.putObject(
                PutObjectArgs.builder()
                        .bucket(bucket)
                        .object(filename)
                        .stream(file.getInputStream(),file.getSize(),-1)
                        .contentType("application/pdf")
                        .build()
        );

        return filename;
    }
}
