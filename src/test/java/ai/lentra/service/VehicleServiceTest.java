package ai.lentra.service;

import ai.lentra.dto.VehicleDetailsDTO;
import ai.lentra.dto.personal_info.PersonalDetailsDTO;
import ai.lentra.dto.responses.ResponseDTO;
import ai.lentra.exceptions.DuplicateResourceException;
import ai.lentra.exceptions.InvalidInputException;
import ai.lentra.modal.VehicleDetails;
import ai.lentra.modal.personal_info.PersonalDetails;
import ai.lentra.repository.VehicleDetailsRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class VehicleServiceTest {
    @Mock
    private VehicleDetailsRepository vehicleDetailsRepository;

    @InjectMocks
    private VehicleDetailsServiceImpl vehicleDetailsService;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testAddVehicleDetails() throws DuplicateResourceException, InvalidInputException, JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Long applicantId=152415215L;
        String jsonRespone="{\n" +
                "    \"applicantId\": 152415215,\n" +
                "    \"numberOfVehiclesOwned\": 2,\n" +
                "    \"bikeRegistrationNumber\": 1452,\n" +
                "    \"manufactureYearCar\": 2222,\n" +
                "    \"bikeManufactureName\": \"TVSSd\",\n" +
                "    \"carHypothecatedTo\": \"HDFC\",\n" +
                "    \"carRegistrationNumber\": 1524,\n" +
                "    \"withParkingSpace\": false,\n" +
                "    \"carOwnershipType\": \"OWNED\",\n" +
                "    \"manufactureYearTwoWheeler\": 1999,\n" +
                "    \"twoWheelerModel\": \"YAMAHA\",\n" +
                "    \"carIssuingAuthority\": \"HDFC\",\n" +
                "    \"carManufactureName\": \"HONDA\",\n" +
                "    \"bikeOwnershipType\": \"OWNDE\",\n" +
                "    \"financedFromDateCar\": \"20/01/2020\",\n" +
                "    \"carFuelType\": \"DIESEL\",\n" +
                "    \"bikeHypothecatedTo\": \"HDFC\",\n" +
                "    \"carSeatingCapacity\": 2,\n" +
                "    \"bikeIssuingAuthority\": \"HDFC\",\n" +
                "    \"vehicleType\": \"JJASDJJSJDJAJSDJAD\",\n" +
                "    \"carModel\": \"sad\",\n" +
                "    \"financedFromDateBike\": \"20/03/2001\"\n" +
                "}";
        VehicleDetails vehicleInfo= objectMapper.readValue(jsonRespone, VehicleDetails.class);
       VehicleDetailsDTO vehicleObj =objectMapper.convertValue(vehicleInfo,VehicleDetailsDTO.class);




        when(vehicleDetailsRepository.findByApplicantId(anyLong())).thenReturn(null);
        // Act
        ResponseEntity<?> response = vehicleDetailsService.saveVehicleDetails(vehicleObj, applicantId);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("SUCCESS", ((ResponseDTO)response.getBody()).getMessage().toString());
        assertEquals("VEHICLE DETAILS ADDED SUCCESSFULLY ", ((ResponseDTO)response.getBody()).getStatus().toString());

        // Verify
        ArgumentCaptor<VehicleDetails> argumentCaptor = ArgumentCaptor.forClass(VehicleDetails.class);
        verify(vehicleDetailsRepository, times(1)).save(argumentCaptor.capture());
        VehicleDetails savedDetails = argumentCaptor.getValue();
        assertEquals("JJASDJJSJDJAJSDJAD", savedDetails.getVehicleType());
        assertEquals("sad", savedDetails.getCarModel());
        assertEquals(applicantId, savedDetails.getApplicantId());
        assertEquals(2, savedDetails.getCarSeatingCapacity());
    }
//    @Test
//    void testGetVehicleDetails() throws JsonProcessingException {
//        ObjectMapper objectMapper = new ObjectMapper();
//        Long applicantId=152415215L;
//        String jsonRespone="{\n" +
//                "    \"applicantId\": 152415215,\n" +
//                "    \"numberOfVehiclesOwned\": 2,\n" +
//                "    \"bikeRegistrationNumber\": 1452,\n" +
//                "    \"manufactureYearCar\": 2222,\n" +
//                "    \"bikeManufactureName\": \"TVSSd\",\n" +
//                "    \"carHypothecatedTo\": \"HDFC\",\n" +
//                "    \"carRegistrationNumber\": 1524,\n" +
//                "    \"withParkingSpace\": false,\n" +
//                "    \"carOwnershipType\": \"OWNED\",\n" +
//                "    \"manufactureYearTwoWheeler\": 1999,\n" +
//                "    \"twoWheelerModel\": \"YAMAHA\",\n" +
//                "    \"carIssuingAuthority\": \"HDFC\",\n" +
//                "    \"carManufactureName\": \"HONDA\",\n" +
//                "    \"bikeOwnershipType\": \"OWNDE\",\n" +
//                "    \"financedFromDateCar\": \"20/01/2020\",\n" +
//                "    \"carFuelType\": \"DIESEL\",\n" +
//                "    \"bikeHypothecatedTo\": \"HDFC\",\n" +
//                "    \"carSeatingCapacity\": 2,\n" +
//                "    \"bikeIssuingAuthority\": \"HDFC\",\n" +
//                "    \"vehicleType\": \"JJASDJJSJDJAJSDJAD\",\n" +
//                "    \"carModel\": \"sad\",\n" +
//                "    \"financedFromDateBike\": \"20/03/2001\"\n" +
//                "}";
//        VehicleDetails vehicleInfo= objectMapper.readValue(jsonRespone, VehicleDetails.class);
//        VehicleDetailsDTO vehicleObj =objectMapper.convertValue(vehicleInfo,VehicleDetailsDTO.class);
//        when(vehicleDetailsRepository.findByApplicantId(anyLong())).thenReturn(vehicleInfo);
//        // Act
//        ResponseEntity<?> response = vehicleDetailsService.getVehicleDetails(applicantId);
//        // Assert
//        VehicleDetails vehicleDetails= (VehicleDetails) response.getBody();
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals(vehicleObj.getCarModel(),vehicleDetails.getCarModel());
//        // Verify
//        ArgumentCaptor<VehicleDetails> argumentCaptor = ArgumentCaptor.forClass(VehicleDetails.class);
//        verify(vehicleDetailsRepository, times(1)).save(argumentCaptor.capture());
//        VehicleDetails savedDetails = argumentCaptor.getValue();
//        assertEquals("JJASDJJSJDJAJSDJAD", savedDetails.getVehicleType());
//        assertEquals("sad", savedDetails.getCarModel());
//        assertEquals(applicantId, savedDetails.getApplicantId());
//        assertEquals(2, savedDetails.getCarSeatingCapacity());
//    }


    @Test
    void testUpdateVehicleDetails() throws DuplicateResourceException, InvalidInputException, JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Long applicantId=152415215L;
        String jsonRespone="{\n" +
                "    \"applicantId\": 152415215,\n" +
                "    \"numberOfVehiclesOwned\": 2,\n" +
                "    \"bikeRegistrationNumber\": 1452,\n" +
                "    \"manufactureYearCar\": 2222,\n" +
                "    \"bikeManufactureName\": \"TVSSd\",\n" +
                "    \"carHypothecatedTo\": \"HDFC\",\n" +
                "    \"carRegistrationNumber\": 1524,\n" +
                "    \"withParkingSpace\": false,\n" +
                "    \"carOwnershipType\": \"OWNED\",\n" +
                "    \"manufactureYearTwoWheeler\": 1999,\n" +
                "    \"twoWheelerModel\": \"YAMAHA\",\n" +
                "    \"carIssuingAuthority\": \"HDFC\",\n" +
                "    \"carManufactureName\": \"HONDA\",\n" +
                "    \"bikeOwnershipType\": \"OWNDE\",\n" +
                "    \"financedFromDateCar\": \"20/01/2020\",\n" +
                "    \"carFuelType\": \"DIESEL\",\n" +
                "    \"bikeHypothecatedTo\": \"HDFC\",\n" +
                "    \"carSeatingCapacity\": 2,\n" +
                "    \"bikeIssuingAuthority\": \"HDFC\",\n" +
                "    \"vehicleType\": \"JJASDJJSJDJAJSDJAD\",\n" +
                "    \"carModel\": \"sad\",\n" +
                "    \"financedFromDateBike\": \"20/03/2001\"\n" +
                "}";
        VehicleDetails vehicleInfo= objectMapper.readValue(jsonRespone, VehicleDetails.class);
        VehicleDetailsDTO vehicleObj =objectMapper.convertValue(vehicleInfo,VehicleDetailsDTO.class);




        when(vehicleDetailsRepository.findByApplicantId(anyLong())).thenReturn(vehicleInfo);
        // Act
        ResponseEntity<?> response = vehicleDetailsService.updateVehicleDetails(vehicleObj, applicantId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("SUCCESS", ((ResponseDTO)response.getBody()).getMessage().toString());
        assertEquals("VEHICLE DETAILS SUCCESSFULLY UPDATED", ((ResponseDTO)response.getBody()).getStatus().toString());

        // Verify
        ArgumentCaptor<VehicleDetails> argumentCaptor = ArgumentCaptor.forClass(VehicleDetails.class);
        verify(vehicleDetailsRepository, times(1)).save(argumentCaptor.capture());
        VehicleDetails savedDetails = argumentCaptor.getValue();
        assertEquals("JJASDJJSJDJAJSDJAD", savedDetails.getVehicleType());
        assertEquals("sad", savedDetails.getCarModel());
        assertEquals(applicantId, savedDetails.getApplicantId());
        assertEquals(2, savedDetails.getCarSeatingCapacity());
    }
}
