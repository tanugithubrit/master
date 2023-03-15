package ai.lentra.service;

import ai.lentra.exceptions.ResourceNotFoundException;

import ai.lentra.modal.residence.ResidenceDetails;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ResidenceService {
    List<ResidenceDetails> findAll()  throws ResourceNotFoundException;

    ResidenceDetails findResidenceByAppId(Long residenceId) throws ResourceNotFoundException;

    ResidenceDetails updateExpense(ResidenceDetails newResidence, ResidenceDetails ResidenceDetail);

    ResponseEntity<?> addExpense(ResidenceDetails ResidenceDetail);
}
