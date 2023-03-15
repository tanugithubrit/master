package ai.lentra.controller;

import ai.lentra.commons.EndPointReferer;
import ai.lentra.commons.JsonUtils1;
import ai.lentra.dto.SummaryDto;
import ai.lentra.modal.summary.Summary;
import ai.lentra.service.SummaryService;
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
import static ai.lentra.commons.ErrorMessage.SUMMARY_NOT_FOUND;

@RestController
@RequestMapping(
        value = EndPointReferer.SUMMARY,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class SummaryController {
    private static final Logger logger =  LoggerFactory.getLogger(SummaryController.class);

    @Autowired
    private JsonUtils1 jsonUtils;
    @Autowired
    SummaryService summaryService;
    @Operation(summary = "Get all summary")
    @GetMapping(SUMMARY_ALL)
    public ResponseEntity<List<SummaryDto>> getAllSummaries() {
        logger.info("Started API call to get all Summaries");
        List<Summary> summaryList = summaryService.findAll();
        List<SummaryDto> summaryDtoList=

                summaryList.stream()
                        .map(addr -> jsonUtils.mapper().convertValue(addr, SummaryDto.class)).collect(Collectors.toList());
        if (!summaryList.isEmpty()) {

            return  ResponseEntity.status(HttpStatus.OK).body(summaryDtoList);
        }
        throw new EntityNotFoundException(SUMMARY_NOT_FOUND);
    }

    @Operation(summary = "Add Summary")
    @PostMapping(SUMMARY_ADD)
    public ResponseEntity<?> createSummary(@RequestBody SummaryDto summaryDto) {
        logger.info("Started API request for Creating Summary...");
        Summary summary = jsonUtils.mapper().convertValue(summaryDto, Summary.class);

        summaryService.addSummary( summary);
        logger.info("Done Creating Summary...");
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "Get Single Summary")
    @GetMapping(SUMMARY_ID)
    public ResponseEntity<SummaryDto> getSummary(@PathVariable Long summaryId) {
        logger.info("Started API call to get summary details for Id {} ...", summaryId);
        Summary summary = summaryService.findSummaryById(summaryId);
        SummaryDto summaryDto = jsonUtils.mapper().convertValue(summary, SummaryDto.class);
        logger.info("Done getting summary details with response {}...", summaryDto.toString());


        return new ResponseEntity<>(summaryDto, HttpStatus.OK);
    }


    @Operation(summary = "Update Single Summary")
    @PutMapping(SUMMARY_ID + SUMMARY_UPDATE)
    public ResponseEntity<SummaryDto> updateSummary(@PathVariable Long summaryId,  @RequestBody SummaryDto summaryDto) {
        logger.info("Started API call to get summary details for Id {} ...", summaryId);
        Summary summay = summaryService.findSummaryById(summaryId);
//                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));
        SummaryDto summaryDtoOld = jsonUtils.mapper().convertValue(summay, SummaryDto.class);
        logger.info("Done getting summary details with response {}...", summaryDtoOld.toString());
        Summary newSUmmary = jsonUtils.mapper().convertValue(summaryDto, Summary.class);
        Summary summaryUpdated = summaryService.updateService(newSUmmary,summay);
        SummaryDto summaryDtoNew = jsonUtils.mapper().convertValue(summaryUpdated, SummaryDto.class);

        return new ResponseEntity<>(summaryDtoNew, HttpStatus.OK);
    }

}
