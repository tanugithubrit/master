package ai.lentra.controller.advice;

import ai.lentra.dto.ResponseDto;
import ai.lentra.dto.responses.ResponseDTO;
import ai.lentra.exceptions.*;
import org.apache.tomcat.util.http.fileupload.impl.FileSizeLimitExceededException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class ControllerAdvice {
//    to handle the file upload exceptions
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<ResponseDTO> handleMaxUploadSizeExceededException(MaxUploadSizeExceededException exc) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setCode(HttpStatus.BAD_REQUEST);
        responseDTO.setStatus("Upload Failed ");
        responseDTO.setMessage("File size is exceed than allowed limit (100MB) ");
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDTO); //
    }
    //to handle the dto validation errors
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ResponseDTO>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<ResponseDTO> responseDTOs = new ArrayList<>();
        Map<String, String> errorMapping = new HashMap<>();
        ResponseDTO errorResponse= new ResponseDTO();
        errorResponse.setCode(HttpStatus.BAD_REQUEST);
        errorResponse.setStatus("Invalid Input Error");

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errorMapping.put(error.getField(), error.getDefaultMessage());
            errorResponse.setMessage(errorMapping.toString());
            responseDTOs.add(errorResponse);
        });


        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDTOs);
    }
    //to handle FileSizeLimitExceededException
    @ExceptionHandler(FileSizeLimitExceededException.class)
    public ResponseEntity<ResponseDTO> handleFileSizeLimitExceededException(FileSizeLimitExceededException exc) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setCode(HttpStatus.BAD_REQUEST);
        responseDTO.setStatus("Upload Failed ");
        responseDTO.setMessage("File size is exceed than allowed limit (100MB)  ");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDTO); //
    }
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ResponseDTO> handleLeadingZeroParseError(HttpMessageNotReadableException exc) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setCode(HttpStatus.BAD_REQUEST);
        responseDTO.setStatus("Invalid Input");
        if(exc.getCause().toString().contains("Leading zeroes not allowed")){
            responseDTO.setMessage("Invalid Input some of the Field contains leading zeros :");
        }
        if(exc.getCause().toString().contains("`java.math.BigDecimal` from String")){
            responseDTO.setMessage("Field contains Special Characters or Alphabets in number fields:");
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDTO); //
    }

//    To handle the ResourceNotFoundException
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResponseDTO> handleResourceNotFoundException(ResourceNotFoundException exc) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setCode(HttpStatus.NOT_FOUND);
        responseDTO.setStatus("ERROR");
        responseDTO.setMessage(exc.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDTO);
    }
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<ResponseDTO> handleDuplicateResource(DuplicateResourceException exc) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setCode(HttpStatus.CONFLICT);
        responseDTO.setStatus("Duplicate Request");
        responseDTO.setMessage(exc.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(responseDTO);
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DateTimeParseException.class)
    public ResponseEntity<ResponseDTO> handleDateTimeParse(DateTimeParseException exc) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setCode(HttpStatus.BAD_REQUEST);
        responseDTO.setStatus("Invalid Input");
        responseDTO.setMessage("Date should be in the format of  dd/mm/yyyy");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDTO);
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<ResponseDTO> handleInvalidInput(InvalidInputException exc) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setCode(HttpStatus.BAD_REQUEST);
        responseDTO.setStatus("Invalid Input");
        responseDTO.setMessage(exc.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDTO);
    }

    @ExceptionHandler(CurrencyNotFoundException.class)
    public ResponseEntity<ResponseDto> handleCurrencyExceptions(CurrencyNotFoundException ex) {
        List<ResponseDto> responseDTOs = new ArrayList<>();
        Map<String, String> errorMapping = new HashMap<>();
        ResponseDto errorResponse= new ResponseDto();
        errorResponse.setCode(HttpStatus.BAD_REQUEST);
        errorResponse.setStatus("Invalid Input Error");
        errorResponse.setMessage(ex.getMessage());


        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(ResidenceException.class)
    public ResponseEntity<ResponseDto> handleResidenceExceptions(CurrencyNotFoundException ex) {
        List<ResponseDto> responseDTOs = new ArrayList<>();
        Map<String, String> errorMapping = new HashMap<>();
        ResponseDto errorResponse= new ResponseDto();
        errorResponse.setCode(HttpStatus.BAD_REQUEST);
        errorResponse.setStatus("Invalid Input Error");
        errorResponse.setMessage(ex.getMessage());


        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

}
