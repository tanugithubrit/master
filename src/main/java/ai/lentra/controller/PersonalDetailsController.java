package ai.lentra.controller;

import ai.lentra.dto.personal_info.PersonalDetailsDTO;
import ai.lentra.dto.responses.ResponseDTO;
import ai.lentra.exceptions.DuplicateResourceException;
import ai.lentra.exceptions.InvalidInputException;
import ai.lentra.exceptions.ResourceNotFoundException;
import ai.lentra.service.PersonalDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@Validated
@RestController
public class PersonalDetailsController {
    @Autowired
    PersonalDetailServiceImpl personalDetailService;
    @PostMapping(value = "/personal-details/applicant/{applicantId}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addPersonalDetails(@PathVariable  Long applicantId, @RequestBody  @Valid PersonalDetailsDTO personalDetailsDTO) throws DuplicateResourceException, InvalidInputException, HttpMessageNotReadableException {
        validationCheck(personalDetailsDTO);
       return personalDetailService.addPersonalDetail(personalDetailsDTO,applicantId);
    }
    @GetMapping(value = "/personal-details/applicant/{applicantId}")
    public ResponseEntity<PersonalDetailsDTO> getPersonalDetails(@PathVariable Long applicantId) throws ResourceNotFoundException {
        return personalDetailService.getPersonalDetailByApplicantId(applicantId);
    }
    @PatchMapping("/personal-details/applicant/{applicantId}")
    public ResponseEntity<ResponseDTO> updatePersonalDetails(@PathVariable Long applicantId, @RequestBody PersonalDetailsDTO personalDetailsDTO) throws ResourceNotFoundException, InvalidInputException ,HttpMessageNotReadableException{
        return personalDetailService.updatePersonalDetail(personalDetailsDTO,applicantId);
    }
    void validationCheck(PersonalDetailsDTO personalDetailsDTO) throws InvalidInputException {
        if(personalDetailsDTO.getMiddleName()==null ||personalDetailsDTO.getMiddleName().isBlank()){
            throw new InvalidInputException("Middle name cannot be null ");
        }
        if(personalDetailsDTO.getFirstName()==null ||personalDetailsDTO.getFirstName().isBlank()){
            throw new InvalidInputException("First name cannot be null ");
        }
        if(personalDetailsDTO.getLastName()==null ||personalDetailsDTO.getLastName().isBlank()){
            throw new InvalidInputException("Last name cannot be null ");
        }
    }

}
