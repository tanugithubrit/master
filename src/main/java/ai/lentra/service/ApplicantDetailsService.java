package ai.lentra.service;

import ai.lentra.dto.ApplicantDetailsDTO;
import org.springframework.http.ResponseEntity;

public interface ApplicantDetailsService {
    public ResponseEntity<?> getApplicantDetails(Long applicantId);
    public ResponseEntity<?> updateApplicantDetails(Long applicantId, ApplicantDetailsDTO applicantDetailsDTO);
    public ResponseEntity<?> saveApplicantDetails(Long applicantId,ApplicantDetailsDTO applicantDetailsDTO);
}
