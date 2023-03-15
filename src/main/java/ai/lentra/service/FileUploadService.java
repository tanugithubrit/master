package ai.lentra.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileUploadService {
    public ResponseEntity<?> uploadFilesOnline(Long applicantId, MultipartFile[] multipartFiles, String latitude, String longitude);
    public ResponseEntity<?> downloadFile(Long applicantId) throws IOException;

    ResponseEntity<?> getFilebyNameAndApplicantId(Long applicantId, String filename) throws IOException;

    public ResponseEntity<?> uploadFilesOffline(Long applicantId, MultipartFile[] files);
}
