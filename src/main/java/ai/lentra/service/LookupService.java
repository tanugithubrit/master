package ai.lentra.service;

import ai.lentra.modal.lookups.SimCardType;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LookupService {
    public ResponseEntity newSimCardType(SimCardType simCardType);
    public ResponseEntity<List<Object>> getSimType();
}
