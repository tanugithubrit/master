package ai.lentra.service;

import ai.lentra.dto.personal_info.PersonalDetailsDTO;
import ai.lentra.exceptions.DuplicateResourceException;
import ai.lentra.exceptions.InvalidInputException;
import ai.lentra.exceptions.ResourceNotFoundException;
import ai.lentra.modal.personal_info.PersonalDetails;
import org.springframework.http.ResponseEntity;

public interface PersonalDetailService {
    public ResponseEntity<?> addPersonalDetail(PersonalDetailsDTO personalDetailsDTO, Long applicantId) throws DuplicateResourceException, InvalidInputException;

    ResponseEntity<PersonalDetailsDTO> getPersonalDetailByApplicantId(Long applicantId) throws ResourceNotFoundException;


    ResponseEntity<?> updatePersonalDetail(PersonalDetailsDTO details, Long applicantId) throws ResourceNotFoundException;

}
