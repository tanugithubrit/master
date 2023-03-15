package ai.lentra.service;

import ai.lentra.dto.ApplicantDetailsDTO;
import ai.lentra.dto.responses.ResponseDTO;
import ai.lentra.modal.ApplicantDetails;
import ai.lentra.modal.ApplicantDetailsHistory;
import ai.lentra.repository.ApplicantDetailsHistoryRepository;
import ai.lentra.repository.ApplicantDetailsRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ApplicantDetailsServiceImpl implements ApplicantDetailsService{
    @Autowired
    ApplicantDetailsHistoryRepository historyRepository;
    @Autowired
    ApplicantDetailsRepository applicantDetailsRepository;
    @Override
    public ResponseEntity<?> getApplicantDetails(Long applicantId) {
        return null;
    }

    @Override
    public ResponseEntity<?> updateApplicantDetails(Long applicantId, ApplicantDetailsDTO applicantDetailsDTO) {
        return null;
    }

    @Override
    public ResponseEntity<?> saveApplicantDetails(Long applicantId, ApplicantDetailsDTO applicantDetailsDTO) {
        ObjectMapper objectMapper= new ObjectMapper();
        System.out.println(applicantDetailsDTO.toString());
        System.out.println(applicantDetailsDTO.getContactInformation());
        ApplicantDetails applicantDetails = new ApplicantDetails();
        ApplicantDetailsHistory detailsHistory = new ApplicantDetailsHistory();
        applicantDetails=objectMapper.convertValue(applicantDetailsDTO,ApplicantDetails.class);
        detailsHistory=objectMapper.convertValue(applicantDetails,ApplicantDetailsHistory.class);
        detailsHistory.setApplicantId(applicantId);
        applicantDetails.setApplicantId(applicantId);
        historyRepository.save(detailsHistory);
        applicantDetailsRepository.save(applicantDetails);
        applicantDetailsRepository.save(applicantDetails);
        return  new ResponseEntity<>(applicantDetails,HttpStatus.CREATED);
//        return getResponse(201,"Success","Successfully Created",2001);
    }

    private ResponseEntity<?> getResponse(int httpStatus, String status, String message, int code) {
        ResponseDTO     responseDTO = new ResponseDTO();
        responseDTO.setStatus(status);
        responseDTO.setMessage(message);
        responseDTO.setCode(HttpStatus.valueOf(code));
        return ResponseEntity.status(httpStatus).body(responseDTO);
    }
}
