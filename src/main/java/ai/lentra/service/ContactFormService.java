package ai.lentra.service;

import ai.lentra.dto.contact_info.ContactDetailsDTO;
import ai.lentra.dto.responses.ResponseDTO;
import ai.lentra.exceptions.DuplicateResourceException;
import ai.lentra.exceptions.ResourceNotFoundException;
import ai.lentra.modal.contact_info.ContactDetails;
import org.springframework.http.ResponseEntity;

public interface ContactFormService {
    public ResponseEntity<Object> getByApplicantId(Long applicantId);

    public ResponseEntity<ResponseDTO> addContactForm(ContactDetailsDTO contactDetailsD, Long applicantId) throws ResourceNotFoundException, DuplicateResourceException;
    public ResponseEntity<ResponseDTO> updateContactDetails(ContactDetailsDTO contactDetails, Long applicantId);
}