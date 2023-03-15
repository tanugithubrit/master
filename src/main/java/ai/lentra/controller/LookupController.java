package ai.lentra.controller;

import ai.lentra.modal.lookups.SimCardType;
import ai.lentra.service.LookupServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lookups")
public class LookupController {
    @Autowired
    LookupServiceImpl lookupServiceImpl;
    @PostMapping("/sim-type")
    public ResponseEntity<?> addSimType(@RequestBody SimCardType simCardType){
      return   lookupServiceImpl.newSimCardType(simCardType);
    }
    @GetMapping("/sim-type/{id}")
    public ResponseEntity<?> getSimType(){
        return lookupServiceImpl.getSimType();
    }
}
