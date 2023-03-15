package ai.lentra.service;

import ai.lentra.dto.responses.ResponseDTO;
import ai.lentra.modal.lookups.SimCardType;
import ai.lentra.repository.lookups.SimCardTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;

@Service
public class LookupServiceImpl implements LookupService {
    @Autowired
    SimCardTypeRepository simCardTypeRepository;
    @Override
    public ResponseEntity newSimCardType(SimCardType simCardType)
    {
        if (simCardType!=null) {
            simCardType.setActive(true);
            simCardTypeRepository.save(simCardType);
            ResponseDTO responseDTO = new ResponseDTO();
            responseDTO.setStatus("Success");
            responseDTO.setCode(HttpStatus.CREATED);
            responseDTO.setMessage("Successfully created sim card type.");
            return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
        }
        else {
            ResponseDTO responseDTO = new ResponseDTO();
            responseDTO.setStatus("Failed");
            responseDTO.setCode(HttpStatus.BAD_REQUEST);
            responseDTO.setMessage("Failed to create sim Data");
            return ResponseEntity.badRequest().body(responseDTO);
        }
    }

    @Override
    public ResponseEntity<List<Object>> getSimType() {
        List<SimCardType> simCardType = simCardTypeRepository.findAll();
        if (simCardType!= null) {
            return ResponseEntity.ok(Collections.singletonList(simCardType));
        }
        else {
            ResponseDTO responseDTO = new ResponseDTO();
            responseDTO.setStatus("Failed");
            responseDTO.setCode(HttpStatus.NOT_FOUND);
            responseDTO.setMessage("Failed to retrieve sim card type.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonList(responseDTO));
        }
    }
}
