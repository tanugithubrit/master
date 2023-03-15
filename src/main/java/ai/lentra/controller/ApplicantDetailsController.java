package ai.lentra.controller;

import ai.lentra.dto.ApplicantDetailsDTO;
import ai.lentra.service.ApplicantDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ApplicantDetailsController {

    @Autowired
    private ApplicantDetailsService applicantDetailsService;
    @PostMapping("/applicants/{applicantId}")
    public ResponseEntity<?> saveApplicantDetails(@PathVariable("applicantId") long applicantId, @RequestBody ApplicantDetailsDTO applicantDetailsDTO) {
        applicantDetailsDTO.setApplicantId(applicantId);
        System.out.println(applicantDetailsDTO);
        return applicantDetailsService.saveApplicantDetails(applicantId, applicantDetailsDTO);
    }
    @GetMapping("/applicants/{applicantId}")
    public ResponseEntity<?> getApplicantDetails(@PathVariable("applicantId") long applicantId) {
        return null;
    }

    @PatchMapping("/applicants/{applicantId}")
    public ResponseEntity<?> updateApplicantDetails(@PathVariable("applicantId") long applicantId) {
        return null;
    }
}
