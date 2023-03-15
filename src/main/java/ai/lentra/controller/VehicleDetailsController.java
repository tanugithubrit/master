package ai.lentra.controller;

import ai.lentra.dto.VehicleDetailsDTO;
import ai.lentra.dto.responses.ResponseDTO;
import ai.lentra.exceptions.InvalidInputException;
import ai.lentra.service.VehicleDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Validated
@RequestMapping(value ="/vehicleDetails")
public class VehicleDetailsController {
    @Autowired
    VehicleDetailsServiceImpl vehicleDetailsService;
    @PostMapping("/vehicles/{applicantId}")
    public ResponseEntity<ResponseDTO> saveVehicleDetails(@RequestBody @Valid VehicleDetailsDTO vehicleDetailsDTO, @PathVariable("applicantId") long applicantId ) throws InvalidInputException {
        return vehicleDetailsService.saveVehicleDetails(vehicleDetailsDTO,applicantId);
    }
    @GetMapping("/vehicles/{applicantId}")
    public ResponseEntity<Object> getVehicleDetails( @PathVariable Long applicantId )
    {
        return vehicleDetailsService.getVehicleDetails(applicantId);
    }
    @PatchMapping("/vehicles/{applicantId}")
    public ResponseEntity<ResponseDTO> updateVehicleDetails(@RequestBody VehicleDetailsDTO vehicleDetailsDTO, @PathVariable("applicantId") long applicantId ) throws InvalidInputException {
        return vehicleDetailsService.updateVehicleDetails(vehicleDetailsDTO,applicantId);
    }
}
