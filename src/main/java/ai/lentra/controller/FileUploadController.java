package ai.lentra.controller;

import ai.lentra.service.FileUploadServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class FileUploadController {

@Autowired
FileUploadServiceImpl fileUploadServiceImpl;
    @PostMapping(value = "files/{applicantId}/upload/online",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)

    public ResponseEntity<?> uploadFilesOnline(@PathVariable Long applicantId, @RequestBody MultipartFile[] files, String latitude,String longitude)  {

       return fileUploadServiceImpl.uploadFilesOnline(applicantId,files,latitude,longitude);
    }
    @PostMapping(value = "files/{applicantId}/upload/offline",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)

    public ResponseEntity<?> uploadFilesOffline(@PathVariable Long applicantId, @RequestBody MultipartFile[] files, String latitude,String longitude)  {

        return fileUploadServiceImpl.uploadFilesOffline(applicantId,files);
    }

    @GetMapping(value = "/files/{applicantId}/download", produces ="application/zip")
    public ResponseEntity<?> downloadFile(@PathVariable Long applicantId) throws IOException {
        return fileUploadServiceImpl.downloadFile(applicantId);
    }
    @GetMapping(value = "/files/{applicantId}/{fileName}/download", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE,MediaType.IMAGE_GIF_VALUE,MediaType.IMAGE_GIF_VALUE,"image/bmp","image/tiff"})
    public ResponseEntity<?> downloadFile(@PathVariable Long applicantId,@PathVariable String fileName) throws IOException {
        return fileUploadServiceImpl.getFilebyNameAndApplicantId(applicantId,fileName);
    }
}