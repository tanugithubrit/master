package ai.lentra.service;

import ai.lentra.dto.contact_info.ContactDetailsDTO;
import ai.lentra.dto.responses.ResponseDTO;
import ai.lentra.dto.responses.ResponseDataDTO;
import ai.lentra.exceptions.DuplicateResourceException;
import ai.lentra.exceptions.ResourceNotFoundException;
import ai.lentra.modal.contact_info.ContactDetails;
import ai.lentra.repository.ContactFormRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static ai.lentra.commons.ResponeGen.getResponse;

@Service
public class ContactFormServiceImpl implements ContactFormService{
    @Autowired
    ContactFormRepository repository;


    public ResponseEntity<Object> getByApplicantId(Long applicantId) {
        ContactDetails contactDetails = repository.findByApplicantId(applicantId);
        return (contactDetails == null ? ResponseEntity.status(HttpStatus.NOT_FOUND).body(getResponse(404,"Contact Details Not Found for Applicant " + applicantId,"ERROR")) : ResponseEntity.status(HttpStatus.OK).body(contactDetails));
    }


    @Override
    public ResponseEntity<ResponseDTO> addContactForm(ContactDetailsDTO contactDetails, Long applicantId) throws ResourceNotFoundException, DuplicateResourceException {
        contactDetails.setApplicantId(applicantId);
        ObjectMapper objectMapper = new ObjectMapper();
        ContactDetails contactDetails_o = objectMapper.convertValue(contactDetails, ContactDetails.class);

        ContactDetails byApplicantId = repository.findByApplicantId(contactDetails_o.getApplicantId());
        if (byApplicantId != null)
        {
           throw new DuplicateResourceException("ContactDetails for the applicant is already exists");
        }
        try{
            repository.save(contactDetails_o);
            return ResponseEntity.status(HttpStatus.CREATED).body(getResponse(201,"Contact Details for the applicant has been added successfully ","CREATED"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(getResponse(500,"error while adding contact details for the applicant ","ERROR"));
        }
    }
@Override
    public ResponseEntity<ResponseDTO> updateContactDetails(ContactDetailsDTO contactDetailsDTO, Long applicantId) {
        Optional<ContactDetails> optionalApplicant = Optional.ofNullable(repository.findByApplicantId(applicantId));
        if (!optionalApplicant.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(getResponse(404,"Contact Details Not Found for Applicant :"+applicantId,"ERROR"));
        }
        ContactDetails existingContact = optionalApplicant.get();
        if (contactDetailsDTO.getMobileNumber() != null) {
            existingContact.setMobileNumber(contactDetailsDTO.getMobileNumber());
        }
        if (contactDetailsDTO.getPersonalEmail() != null) {
            existingContact.setPersonalEmail(contactDetailsDTO.getPersonalEmail());
        }
        if (contactDetailsDTO.getSimType() != null) {
            existingContact.setSimType(contactDetailsDTO.getSimType());
        }
        existingContact.setMobileNumberVerified(contactDetailsDTO.isMobileNumberVerified());

        if (contactDetailsDTO.isMobileNumberVerified() != existingContact.isMobileNumberVerified()) {
            existingContact.setMobileNumberVerified(contactDetailsDTO.isMobileNumberVerified());
        }
        if (contactDetailsDTO.getPhoneNumber() != null) {
            existingContact.setPhoneNumber(contactDetailsDTO.getPhoneNumber());
        }
        existingContact.setPhoneNumberVerified(contactDetailsDTO.isPhoneNumberVerified());


        existingContact.setPersonalEmailVerified(contactDetailsDTO.isPersonalEmailVerified());

//        if (contactDetails.isPersonalEmailVerified() != existingContact.isPersonalEmailVerified()) {
//            existingContact.setPersonalEmailVerified(contactDetails.isPersonalEmailVerified());
//        }
        existingContact.setContDomainCheck(contactDetailsDTO.isDomainCheck());

//        if (contactDetails.isDomainCheck() != existingContact.isDomainCheck()) {
//            existingContact.setDomainCheck(contactDetails.isDomainCheck());
//        }
        existingContact.setRegisteredWithBank(contactDetailsDTO.isRegisteredWithBank());

//        if (contactDetails.isRegisteredWithBank() != existingContact.isRegisteredWithBank()) {
//            existingContact.setRegisteredWithBank(contactDetails.isRegisteredWithBank());
//        }
//Success Response
//        ResponseDTO successResponseDTO=new ResponseDTO();
//        successResponseDTO.setCode(HttpStatus.CREATED);
//        successResponseDTO.setMessage("Contact Information Created   Successfully");
//        successResponseDTO.setStatus("Created");
//        //Error Response
//        ResponseDTO errResponseDTO = new ResponseDTO();
//        errResponseDTO.setCode(HttpStatus.NOT_FOUND);
//        errResponseDTO.setMessage("Contact Information Not Updated");
//        errResponseDTO.setStatus("Failed to Update");
        try {
            repository.save(existingContact);
        }catch (Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(getResponse(400,"Error while updating a contact details ","ERROR"));
        }
        return ResponseEntity.status(HttpStatus.OK).body(getResponse(200,"Contact Details updated successfully","SUCCESS"));


    }


}