package ai.lentra.controller;


import ai.lentra.commons.EndPointReferer;
import ai.lentra.commons.JsonUtils1;
import ai.lentra.dto.ResidenceDto;
import ai.lentra.exceptions.ResourceNotFoundException;
import ai.lentra.modal.residence.ResidenceDetails;
import ai.lentra.service.ResidenceService;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

import static ai.lentra.commons.EndPointReferer.*;
import static ai.lentra.commons.ErrorMessage.RESIDENCE_NOT_FOUND;

@RestController
@RequestMapping(
        value = EndPointReferer.RESIDENCE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class ResidenceController {
    private static final Logger logger =  LoggerFactory.getLogger(ResidenceController.class);

    @Autowired
    private JsonUtils1 jsonUtils;
    @Autowired
    ResidenceService residenceService;
    @Operation(summary = "Get all residence")
    @GetMapping(RESIDENCE_ALL)
    public ResponseEntity<List<ResidenceDto>> getAllResidence() throws ResourceNotFoundException {
        logger.info("Started API call to get all residence");
        List<ResidenceDetails> residence = residenceService.findAll();
        List<ResidenceDto> residenceDtoList =

                residence.stream()
                        .map(addr -> jsonUtils.mapper().convertValue(addr, ResidenceDto.class)).collect(Collectors.toList());
        if (!residence.isEmpty()) {

            return  ResponseEntity.status(HttpStatus.OK).body(residenceDtoList);
        }
        throw new EntityNotFoundException(RESIDENCE_NOT_FOUND);
    }

    @Operation(summary = "Get Single residence")
    @GetMapping(RESIDENCE_ID)
    public ResponseEntity<ResidenceDto> getResidence(@PathVariable Long applicantId) throws ResourceNotFoundException {
        logger.info("Started API call to get residence details for Id {} ...", applicantId);
//        ResidenceDetails residence = residenceService.findResidenceByAppId(applicantId);
//        ResidenceDto residenceDto = jsonUtils.mapper().convertValue(residence, ResidenceDto.class);
//        logger.info("Done getting residence details with response {}...", residenceDto.toString());


        return new ResponseEntity<>(new ResidenceDto(), HttpStatus.OK);
    }


    @Operation(summary = "Add residence")
    @PostMapping(RESIDENCE_ADD)
    public ResponseEntity<?> createResidence(@RequestBody ResidenceDto residenceDto) {
        logger.info("Started API request for Creating REsidence...");
        ResidenceDetails residence = jsonUtils.mapper().convertValue(residenceDto, ResidenceDetails.class);


        logger.info("Done Creating residence...");
        return residenceService.addExpense(residence);
    }


    @Operation(summary = "Update Single ResidenceDetails")
    @PutMapping(RESIDENCE_ID + RESIDENCE_UPDATE)
    public ResponseEntity<ResidenceDto> updateExpenses(@PathVariable Long applicantId,  @RequestBody ResidenceDto residenceDto) throws ResourceNotFoundException {
        logger.info("Started API call to get residence details for Id {} ...", applicantId);
        ResidenceDetails residence = residenceService.findResidenceByAppId(applicantId);
//                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));
        ResidenceDto residenceDtoOld = jsonUtils.mapper().convertValue(residence, ResidenceDto.class);
        logger.info("Done getting residence details with response {}...", residenceDtoOld.toString());
        ResidenceDetails newResidence = jsonUtils.mapper().convertValue(residenceDto, ResidenceDetails.class);
        ResidenceDetails residenceUpdated = residenceService.updateExpense(newResidence,residence);
        ResidenceDto residenceDtoNew = jsonUtils.mapper().convertValue(residenceUpdated, ResidenceDto.class);

        return new ResponseEntity<>(residenceDtoNew, HttpStatus.OK);
    }

}
